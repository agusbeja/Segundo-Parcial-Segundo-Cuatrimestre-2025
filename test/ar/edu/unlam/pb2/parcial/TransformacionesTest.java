package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaSalvaje;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;
import ar.edu.unlam.pb2.parcial.enums.TipoTransformacion;
import ar.edu.unlam.pb2.parcial.maestros.MaestroElemental;
import ar.edu.unlam.pb2.parcial.transformaciones.BendicionDelRio;

public class TransformacionesTest {
	
	@Test
	public void queUnMaestroPuedaTransformarAUnaCriaturaExitosamente() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA,
				ComportamientoEmocional.TRANQUILO);
		maestro.agregarCriatura(criatura);
		
		maestro.transformarCriatura("Pikachu", TipoTransformacion.BENDICION_DEL_RIO);
		CriaturaElemental transformada = maestro.buscarCriatura("Pikachu");
		
		assertTrue(transformada instanceof BendicionDelRio);		
	}
	
	@Test
	public void queUnaCriaturaConLaBendicionDelRioDupliqueSuEnergia() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pikachu", 40, AfinidadElemental.AGUA,
				ComportamientoEmocional.TRANQUILO);
		maestro.agregarCriatura(criatura);
		
		maestro.transformarCriatura("Pikachu", TipoTransformacion.BENDICION_DEL_RIO);
		CriaturaElemental transformada = maestro.buscarCriatura("Pikachu");
		
		assertEquals(transformada.getEnergia(), 80);	
	}
	
	@Test
	public void queUnaCriaturaConLaLlamaInternaCambieSuComportamientoAInestable() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pikachu", 40, AfinidadElemental.AGUA,
				ComportamientoEmocional.TRANQUILO);
		maestro.agregarCriatura(criatura);
		
		maestro.transformarCriatura("Pikachu", TipoTransformacion.LLAMA_INTERNA);
		CriaturaElemental transformada = maestro.buscarCriatura("Pikachu");
		
		assertEquals(ComportamientoEmocional.INESTABLE, transformada.getComportamiento());	
	}
	
	@Test
	public void queUnaCriaturaConAfinidadFuegoYConLaLlamaInternaAumente30DeEnergia() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pikachu", 40, AfinidadElemental.FUEGO,
				ComportamientoEmocional.TRANQUILO);
		maestro.agregarCriatura(criatura);
		
		maestro.transformarCriatura("Pikachu", TipoTransformacion.LLAMA_INTERNA);
		CriaturaElemental transformada = maestro.buscarCriatura("Pikachu");
		
		assertEquals(70, transformada.getEnergia());	
	}
	
	@Test
	public void queUnaCriaturaConVinculoTerrestreNuncaQuedeConMenosDe50DeEnergia() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pikachu", 40, AfinidadElemental.FUEGO,
				ComportamientoEmocional.TRANQUILO);
		maestro.agregarCriatura(criatura);
		
		maestro.transformarCriatura("Pikachu", TipoTransformacion.VINCULO_TERRESTRE);
		CriaturaElemental transformada = maestro.buscarCriatura("Pikachu");
		
		assertEquals(50, transformada.getEnergia());	
	}
	
	@Test
	public void queUnaCriaturaConAscensoDelVientoTemporalmenteSeaDeTipoAire() {
		MaestroElemental maestro = new MaestroElemental("Lionhead", 25, AfinidadElemental.TIERRA);
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pikachu", 40, AfinidadElemental.FUEGO,
				ComportamientoEmocional.TRANQUILO);
		maestro.agregarCriatura(criatura);
		
		maestro.transformarCriatura("Pikachu", TipoTransformacion.ASCENSO_DEL_VIENTO);
		CriaturaElemental transformada = maestro.buscarCriatura("Pikachu");
		
		assertEquals(AfinidadElemental.AIRE, transformada.getAfinidadPrincipal());	
	}
	
	
	
	
	
	
	
}
