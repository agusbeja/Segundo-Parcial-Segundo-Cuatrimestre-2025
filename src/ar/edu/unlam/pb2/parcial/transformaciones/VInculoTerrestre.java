package ar.edu.unlam.pb2.parcial.transformaciones;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public class VInculoTerrestre extends Transformacion {

	public VInculoTerrestre(CriaturaElemental criatura) {
		super(criatura);		
	}

	@Override
	public int getEnergia() {
		int energiaActual = criaturaBase.getEnergia();
		
	    if (energiaActual < 50) {
	        return 50;
	    } else {
	        return energiaActual;
	    }		
	}

	@Override
	public AfinidadElemental getAfinidadPrincipal() {		
		 return criaturaBase.getAfinidadPrincipal();
	}

	@Override
	public ComportamientoEmocional getComportamiento() {		
		return criaturaBase.getComportamiento();
	}

}
