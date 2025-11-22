package ar.edu.unlam.pb2.parcial;
import static org.junit.Assert.*;
import org.junit.Test;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaAncestral;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaDomesticada;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaSalvaje;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;
import ar.edu.unlam.pb2.parcial.maestros.DesbordeDeEnergiaException;

public class CriaturaElementalTest {
	
	@Test
	public void creoUnaCriaturaSalvajeYValidoSusDatos() {
		CriaturaElemental criatura1 = new CriaturaSalvaje("Pikachu", 40, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
		
		assertEquals("Pikachu", criatura1.getNombre());
		assertEquals(40, criatura1.getEnergia());
		assertEquals(AfinidadElemental.AGUA, criatura1.getAfinidadPrincipal());
		assertEquals(ComportamientoEmocional.TRANQUILO, criatura1.getComportamiento());
	}
	
	@Test
	public void creoUnaCriaturaDomesticadaYSiempreSuComportamientoEmocionalVaASerTranquilo() {
		CriaturaElemental criatura1 = new CriaturaDomesticada("Pikachu", 40, AfinidadElemental.AGUA, ComportamientoEmocional.INESTABLE);		
		
		assertEquals(ComportamientoEmocional.TRANQUILO, criatura1.getComportamiento());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void creoUnaCriaturaAncestralYSiLaCreoConMenosDe100DeEnergiaSeTiraUnaIllegalArgumentExcepcion() {
		CriaturaElemental criatura1 = new CriaturaAncestral("Pikachu", 40, AfinidadElemental.AGUA, ComportamientoEmocional.INESTABLE);			
	}
	 
	@Test 
	public void alEntrenarUnaCriaturaSalvajeAumenteSuEnergia() {
		CriaturaElemental criatura1 = new CriaturaSalvaje("Pikachu", 100, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
		criatura1.entrenar(20);		
		assertEquals(120, criatura1.getEnergia());
	}
	
	@Test (expected = DesbordeDeEnergiaException.class)
	public void alEntrenarUnaCriaturaSalvajeYSuperoA200LanzaUncheckedException() {
		CriaturaElemental criatura1 = new CriaturaSalvaje("Pikachu", 190, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
		criatura1.entrenar(20);		
	}
	
	@Test
	public void alEntrenarUnaCriaturaDomesticadaAumenteSuENergiaEstablemente() {
		CriaturaElemental criatura1 = new CriaturaDomesticada("Pikachu", 190, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
		criatura1.entrenar(20);		
		assertEquals(210, criatura1.getEnergia());
	}

	@Test
	public void crearUnaCriaturaAncestralExitosamente() {
		CriaturaElemental criatura1 = new CriaturaAncestral("Pikachu", 190, AfinidadElemental.FUEGO, ComportamientoEmocional.INESTABLE);
		criatura1.entrenar(20);		
		assertEquals(210, criatura1.getEnergia());
	}
	
	
	
	
	
}
