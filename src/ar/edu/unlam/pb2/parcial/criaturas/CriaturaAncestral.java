package ar.edu.unlam.pb2.parcial.criaturas;

import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public class CriaturaAncestral extends CriaturaElemental {

	public CriaturaAncestral(String nombre, int energia, AfinidadElemental afinidadPrincipal,
			ComportamientoEmocional comportamiento) {
		super(nombre, validarEnergiaInicial(energia), afinidadPrincipal, comportamiento);		
	}
	
	private static int validarEnergiaInicial(int energia) {
        if (energia < 100) {
            throw new IllegalArgumentException("Una criatura ancestral no puede tener menos de 100 de energía");
        }
        return energia;
    }

	@Override
	public void entrenar(int energiaAgregada) {
		energia += energiaAgregada;
	}

	@Override
	public void pacificar() {
		this.comportamiento = ComportamientoEmocional.TRANQUILO;
	}
	
	@Override
	public void interactuarCon(CriaturaElemental otra) {
	    this.energia += 20;

	    int energiaRestante = otra.getEnergia() - 15;
	    if (energiaRestante < 0) {
	    	energiaRestante = 0;
	    }

	    otra.setEnergia(energiaRestante);
	}

}
