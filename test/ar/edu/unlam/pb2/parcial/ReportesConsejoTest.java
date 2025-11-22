package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaAncestral;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaDomesticada;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;
import ar.edu.unlam.pb2.parcial.enums.TipoTransformacion;
import ar.edu.unlam.pb2.parcial.maestros.MaestroElemental;
import ar.edu.unlam.pb2.parcial.reportes.ReportesConsejo;

public class ReportesConsejoTest {

	@Test
    public void ObtenerTodasLasCriaturas() {
        MaestroElemental maestro1 = new MaestroElemental("Aang", 100, AfinidadElemental.AIRE);
        MaestroElemental maestro2 = new MaestroElemental("Korra", 120, AfinidadElemental.AGUA);

        CriaturaElemental agua = new CriaturaDomesticada("Nami", 50, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
        CriaturaElemental fuego = new CriaturaDomesticada("Pyro", 80, AfinidadElemental.FUEGO, ComportamientoEmocional.INESTABLE);
        CriaturaElemental tierra = new CriaturaAncestral("Golem", 150, AfinidadElemental.TIERRA, ComportamientoEmocional.TRANQUILO);

        maestro1.agregarCriatura(agua);
        maestro1.agregarCriatura(fuego);
        maestro2.agregarCriatura(tierra);

        ReportesConsejo reportes = new ReportesConsejo(Arrays.asList(maestro1, maestro2));

        List<CriaturaElemental> criaturas = reportes.obtenerTodasLasCriaturas();

        assertEquals(3, criaturas.size());
        assertTrue(criaturas.contains(agua));
        assertTrue(criaturas.contains(fuego));
        assertTrue(criaturas.contains(tierra));
    }

    @Test
    public void ObtenerCriaturaMayorEnergia() {
        MaestroElemental m = new MaestroElemental("Korra", 100, AfinidadElemental.AGUA);

        CriaturaElemental a = new CriaturaDomesticada("Nami", 60, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
        CriaturaElemental b = new CriaturaAncestral("Golem", 200, AfinidadElemental.TIERRA, ComportamientoEmocional.TRANQUILO);

        m.agregarCriatura(a);
        m.agregarCriatura(b);

        ReportesConsejo reportes = new ReportesConsejo(List.of(m));

        assertEquals(b, reportes.obtenerCriaturaMayorEnergia());
    }

    @Test
    public void ObtenerMaestroMasTransformaciones() {
        MaestroElemental maestro1 = new MaestroElemental("Aang", 100, AfinidadElemental.AIRE);
        MaestroElemental maestro2 = new MaestroElemental("Korra", 120, AfinidadElemental.AGUA);

        CriaturaElemental agua = new CriaturaDomesticada("Nami", 50, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
        CriaturaElemental fuego = new CriaturaDomesticada("Pyro", 80, AfinidadElemental.FUEGO, ComportamientoEmocional.INESTABLE);
        CriaturaElemental tierra = new CriaturaDomesticada("Rocky", 90, AfinidadElemental.TIERRA, ComportamientoEmocional.TRANQUILO);

        maestro1.agregarCriatura(agua);
        maestro1.transformarCriatura("Nami", TipoTransformacion.LLAMA_INTERNA);

        maestro2.agregarCriatura(fuego);
        maestro2.agregarCriatura(tierra);
        maestro2.transformarCriatura("Pyro", TipoTransformacion.BENDICION_DEL_RIO);
        maestro2.transformarCriatura("Rocky", TipoTransformacion.VINCULO_TERRESTRE);

        ReportesConsejo reportes = new ReportesConsejo(List.of(maestro1, maestro2));

        assertEquals(maestro2, reportes.obtenerMaestroMasTransformaciones(List.of(maestro1, maestro2)));
    }

    @Test
    public void ObtenerCantidadPorAfinidad() {
        MaestroElemental maestro = new MaestroElemental("Aang", 100, AfinidadElemental.AIRE);

        CriaturaElemental agua = new CriaturaDomesticada("Nami", 50, AfinidadElemental.AGUA, ComportamientoEmocional.TRANQUILO);
        CriaturaElemental fuego = new CriaturaDomesticada("Pyro", 80, AfinidadElemental.FUEGO, ComportamientoEmocional.INESTABLE);
        CriaturaElemental tierra = new CriaturaAncestral("Golem", 150, AfinidadElemental.TIERRA, ComportamientoEmocional.TRANQUILO);

        maestro.agregarCriatura(agua);
        maestro.agregarCriatura(fuego);
        maestro.agregarCriatura(tierra);

        ReportesConsejo reportes = new ReportesConsejo(List.of(maestro));

        Map<AfinidadElemental, Integer> conteo = reportes.obtenerCantidadPorAfinidad();

        assertEquals(3, conteo.size());
        assertEquals(1, conteo.get(AfinidadElemental.AGUA), 0.01);
        assertEquals(1, conteo.get(AfinidadElemental.FUEGO), 0.01);
        assertEquals(1, conteo.get(AfinidadElemental.TIERRA), 0.01);
    }

}
