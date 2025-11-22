package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaAncestral;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaDomesticada;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaSalvaje;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;


public class InteraccionesTest {
	@Test
	public void queDosCriatuasConLasMismaAFinidadDeENergiaInteractuenYsumen10DeENergia() {
		CriaturaElemental criatura1 = new CriaturaSalvaje("A", 50, AfinidadElemental.FUEGO, ComportamientoEmocional.TRANQUILO);
	    CriaturaElemental criatura2 = new CriaturaDomesticada("B", 70, AfinidadElemental.FUEGO, ComportamientoEmocional.TRANQUILO);

	    criatura1.interactuarCon(criatura2);

	    assertEquals(60, criatura1.getEnergia());
	    assertEquals(80, criatura2.getEnergia());
	}
	
	@Test
	public void queDosCriaturasConAfinidadesOpuestasSeVuelvanInestables() {
	    CriaturaElemental agua = new CriaturaDomesticada("pikachu", 50, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
	    CriaturaElemental fuego = new CriaturaSalvaje("raychu", 80, AfinidadElemental.FUEGO, ComportamientoEmocional.TRANQUILO);

	    agua.interactuarCon(fuego);

	    assertEquals(ComportamientoEmocional.INESTABLE, agua.getComportamiento());
	    assertEquals(ComportamientoEmocional.INESTABLE, fuego.getComportamiento());
	}
	
	@Test
	public void queUnaCriaturaAncestralInteraccioneConOtroTipoDeCriaturaYQueEstaDomine() {
	    CriaturaElemental ancestral = new CriaturaAncestral("rayquaza", 120, AfinidadElemental.TIERRA, ComportamientoEmocional.TRANQUILO);
	    CriaturaElemental normal = new CriaturaSalvaje("pikachu", 90, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);

	    ancestral.interactuarCon(normal);
	    normal.interactuarCon(ancestral);

	    assertEquals(140, ancestral.getEnergia());   
	    assertEquals(75, normal.getEnergia());       
	}
}
