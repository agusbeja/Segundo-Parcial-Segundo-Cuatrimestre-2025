package ar.edu.unlam.pb2.parcial.transformaciones;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public class LlamaInterna extends Transformacion {

	public LlamaInterna(CriaturaElemental criatura) {
		super(criatura);
		
	}

	@Override
	public int getEnergia() {
		if(criaturaBase.getAfinidadPrincipal()==AfinidadElemental.FUEGO) {
			 return criaturaBase.getEnergia() + 30;
		}
		return criaturaBase.getEnergia();
	}

	@Override
	public AfinidadElemental getAfinidadPrincipal() {		
		return criaturaBase.getAfinidadPrincipal();
	}

	@Override
	public ComportamientoEmocional getComportamiento() {
		if(criaturaBase.getAfinidadPrincipal() != AfinidadElemental.FUEGO) {
            return ComportamientoEmocional.INESTABLE;
        }
        return criaturaBase.getComportamiento();
	}

}
