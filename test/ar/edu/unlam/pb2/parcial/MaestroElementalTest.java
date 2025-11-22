package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaSalvaje;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;
import ar.edu.unlam.pb2.parcial.maestros.MaestriaInsuficienteException;
import ar.edu.unlam.pb2.parcial.maestros.MaestroElemental;

public class MaestroElementalTest {

	@Test
	public void creoUnMaestroYValidoSusDatos() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);

		assertEquals("Lionhead", maestro.getNombre());
		assertEquals(25, maestro.getMaestria());
		assertEquals(AfinidadElemental.TIERRA, maestro.getAfinidadPrincipal());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void unMaestroAgregaUnaCriaturaNullYFalla() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = null;				

		maestro.agregarCriatura(criatura1);			
	}
	
	@Test
	public void unMaestroAgregaUnaCriaturaAsuColeccionYLaBusca() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA,
				ComportamientoEmocional.TRANQUILO);

		maestro.agregarCriatura(criatura1);
		CriaturaElemental criaturaBuscada = maestro.buscarCriatura("Pikachu");

		assertEquals("Pikachu", criaturaBuscada.getNombre());
	}

	@Test
	public void unMaestroAgregaUnaCriaturaYLaEntrena() throws MaestriaInsuficienteException {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA,
				ComportamientoEmocional.TRANQUILO);

		maestro.agregarCriatura(criatura1);
		maestro.entrenarCriatura("Pikachu", 20);
		CriaturaElemental criaturaBuscada = maestro.buscarCriatura("Pikachu");

		assertEquals(120, criaturaBuscada.getEnergia());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void unMaestroEntrenaAUnaCriaturaConPuntosNegativosYTiraIllegalArgumentExcption() throws MaestriaInsuficienteException {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA,
				ComportamientoEmocional.TRANQUILO);

		maestro.agregarCriatura(criatura1);
		maestro.entrenarCriatura("Pikachu", -10);		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void unMaestroEntrenaAUnaCriaturaQueNoEstaEnLaListaDeCriaturasYLargaIllegalArgumentException() throws MaestriaInsuficienteException {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		
		maestro.entrenarCriatura("Pikachu", 10);		
	}
	
	@Test (expected = MaestriaInsuficienteException.class)
	public void unMaestroEntrenaAUnaCriaturaConMaestriaInsuficienteYTiraMaestriaInsuficineteException() throws MaestriaInsuficienteException {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);

		maestro.agregarCriatura(criatura1);
		maestro.entrenarCriatura("Pikachu", 30);		
	}
	

	@Test
	public void quePuedaPacificarUnaCriaturaInestable() {
		MaestroElemental maestro = new MaestroElemental("Arkon", 30, AfinidadElemental.FUEGO);
		CriaturaElemental criatura = new CriaturaSalvaje("Fangor", 100, AfinidadElemental.FUEGO,
				ComportamientoEmocional.INESTABLE);

		maestro.agregarCriatura(criatura);

		assertEquals(ComportamientoEmocional.INESTABLE, criatura.getComportamiento());
		maestro.pacificarCriatura("Fangor");
		assertEquals(ComportamientoEmocional.TRANQUILO, criatura.getComportamiento());
	}
	
	
}