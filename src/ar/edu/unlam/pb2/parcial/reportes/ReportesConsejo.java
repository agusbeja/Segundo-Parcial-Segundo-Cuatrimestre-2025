package ar.edu.unlam.pb2.parcial.reportes;

import java.util.*;
import ar.edu.unlam.pb2.parcial.criaturas.*;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.maestros.MaestroElemental;

public class ReportesConsejo {

	private List<MaestroElemental> maestros;

	public ReportesConsejo(List<MaestroElemental> maestros) {
		this.maestros = maestros;
	}

	public List<CriaturaElemental> obtenerTodasLasCriaturas() {
		List<CriaturaElemental> criaturas = new ArrayList<>();
		for (MaestroElemental m : maestros) {
			criaturas.addAll(m.getCriaturasRegistradas());
		}
		return criaturas;
	}

	public CriaturaElemental obtenerCriaturaMayorEnergia() {
		return obtenerTodasLasCriaturas().stream().max(Comparator.comparingInt(c -> c.getEnergia())).orElse(null);
	}

	public MaestroElemental obtenerMaestroMasTransformaciones(List<MaestroElemental> maestros) {
	    MaestroElemental mejor = null;
	    int max = -1;

	    for (MaestroElemental m : maestros) {
	        int cantidad = m.getCantidadDeTransformadas();
	        if (cantidad > max) {
	            max = cantidad;
	            mejor = m;
	        }
	    }

	    return mejor;
	}
	public Map<AfinidadElemental, Integer> obtenerCantidadPorAfinidad() {
		Map<AfinidadElemental, Integer> conteo = new HashMap<>();

		for (CriaturaElemental c : obtenerTodasLasCriaturas()) {
			conteo.merge(c.getAfinidadPrincipal(), 1, Integer::sum);
		}
		return conteo;
	}
}
