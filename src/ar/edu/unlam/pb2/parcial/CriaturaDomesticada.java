package ar.edu.unlam.pb2.parcial;

public class CriaturaDomesticada extends CriaturaElemental {

	public CriaturaDomesticada(String nombre, int energia, AfinidadElemental afinidadPrincipal,
			ComportamientoEmocional comportamiento) {
		super(nombre, energia, afinidadPrincipal, comportamiento);		
	}

	@Override
	public void entrenar(int energiaAgregada) {
		energia += energiaAgregada;
	}

	@Override
	public void pacificar() {
		// TODO Auto-generated method stub

	}

}
