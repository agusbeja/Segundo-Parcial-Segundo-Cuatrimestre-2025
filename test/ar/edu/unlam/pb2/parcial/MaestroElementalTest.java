package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaestroElementalTest {
	
	@Test
	public void creoUnMaestroYValidoSusDatos() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		
		assertEquals("Lionhead", maestro.getNombre());
		assertEquals(40, maestro.getMaestria());
		assertEquals(AfinidadElemental.TIERRA, maestro.getAfinidadPrincipal());		
	}
	
	@Test
	public void unMaestroAgregaUnaCriaturaAsuColeccionYLaBusca() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
		
		maestro.agregarCriatura(criatura1);
		CriaturaElemental criaturaBuscada = maestro.buscarCriatura("Pikachu");
		
		assertEquals("Pikachu", criaturaBuscada.getNombre());				
	}
	
	@Test
	public void unMaestroAgregaUnaCriaturaYLaEntrena() throws MaestriaInsuficienteException {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
		
		maestro.agregarCriatura(criatura1);
		maestro.entrenarCriatura("Pikachu", 20);
		CriaturaElemental criaturaBuscada = maestro.buscarCriatura("Pikachu");
		
		assertEquals(120 , criaturaBuscada.getEnergia());				
	}
	
	@Test
    public void quePuedaPacificarUnaCriaturaInestable() {
        MaestroElemental maestro = new MaestroElemental("Arkon", 30, AfinidadElemental.FUEGO);
        CriaturaElemental criatura = new CriaturaSalvaje("Fangor", 100, AfinidadElemental.FUEGO, ComportamientoEmocional.INESTABLE);

        maestro.agregarCriatura(criatura);

        assertEquals(ComportamientoEmocional.INESTABLE, criatura.getComportamiento());
        maestro.pacificarCriatura("Fangor");
        assertEquals(ComportamientoEmocional.TRANQUILO, criatura.getComportamiento());
    }
}
