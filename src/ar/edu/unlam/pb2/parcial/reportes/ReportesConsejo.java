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
			for (CriaturaElemental c : m.getCriaturasRegistradas()) {
                criaturas.add(c);
            }
		}
		return criaturas;
	}

	public CriaturaElemental obtenerCriaturaMayorEnergia() {
		List<CriaturaElemental> criaturas = obtenerTodasLasCriaturas();
		
        if (criaturas.isEmpty()) {
            return null;
        }

        CriaturaElemental mayor = criaturas.get(0);

        for (CriaturaElemental c : criaturas) {
            if (c.getEnergia() > mayor.getEnergia()) {
                mayor = c;
            }
        }
        return mayor;
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

        List<CriaturaElemental> criaturas = obtenerTodasLasCriaturas();

        for (CriaturaElemental c : criaturas) {

            AfinidadElemental afinidad = c.getAfinidadPrincipal();

            if (!conteo.containsKey(afinidad)) {
                conteo.put(afinidad, 1);
            } else {
                int valorActual = conteo.get(afinidad);
                conteo.put(afinidad, valorActual + 1);
            }
        }

        return conteo;
	}
}
