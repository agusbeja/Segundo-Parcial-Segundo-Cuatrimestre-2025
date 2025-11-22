package ar.edu.unlam.pb2.parcial.criaturas;

import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public class CriaturaDomesticada extends CriaturaElemental {

	public CriaturaDomesticada(String nombre, int energia, AfinidadElemental afinidadPrincipal,
			ComportamientoEmocional comportamiento) {
		super(nombre, energia, afinidadPrincipal, ComportamientoEmocional.TRANQUILO);		
	}

	@Override
	public void entrenar(int energiaAgregada) {
		energia += energiaAgregada;
	}

	@Override
	public void pacificar() {
		this.comportamiento = ComportamientoEmocional.TRANQUILO;
	}

}