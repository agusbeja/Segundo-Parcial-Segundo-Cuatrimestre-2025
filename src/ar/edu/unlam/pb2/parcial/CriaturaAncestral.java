package ar.edu.unlam.pb2.parcial;

public class CriaturaAncestral extends CriaturaElemental {

	public CriaturaAncestral(String nombre, int energia, AfinidadElemental afinidadPrincipal,
			ComportamientoEmocional comportamiento) {
		super(nombre, energia, afinidadPrincipal, comportamiento);		
	}

	@Override
	public void entrenar(int energiaAgregada) {
		energia += energiaAgregada;
	}

	@Override
	public void pacificar() {
		
	}

}
