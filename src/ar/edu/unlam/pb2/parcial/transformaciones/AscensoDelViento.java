package ar.edu.unlam.pb2.parcial.transformaciones;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public class AscensoDelViento extends Transformacion {

	public AscensoDelViento(CriaturaElemental criatura) {
		super(criatura);		
	}

	@Override
	public int getEnergia() {		
		return criaturaBase.getEnergia();
	}

	@Override
	public AfinidadElemental getAfinidadPrincipal() {		
		return AfinidadElemental.AIRE;
	}

	@Override
	public ComportamientoEmocional getComportamiento() {		
		return criaturaBase.getComportamiento();
	}

}
