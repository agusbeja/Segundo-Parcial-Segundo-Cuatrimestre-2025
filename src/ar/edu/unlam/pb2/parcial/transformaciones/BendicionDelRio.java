package ar.edu.unlam.pb2.parcial.transformaciones;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public class BendicionDelRio extends Transformacion {

	public BendicionDelRio(CriaturaElemental criatura) {
		super(criatura);		
	}

	@Override
	public int getEnergia() {	
		int energiaAumentada;
		if ((criaturaBase.getEnergia()*2)>180) {
			energiaAumentada = 180;
		} else {
			energiaAumentada = criaturaBase.getEnergia()*2;
		}
		return energiaAumentada;
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
