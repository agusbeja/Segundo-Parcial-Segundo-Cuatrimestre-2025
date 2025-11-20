package ar.edu.unlam.pb2.parcial;

public class CriaturaSalvaje extends CriaturaElemental {

	public CriaturaSalvaje(String nombre, int energia, AfinidadElemental afinidadPrincipal,
			ComportamientoEmocional comportamiento) {
		super(nombre, energia, afinidadPrincipal, comportamiento);		
	}

	@Override
	public void entrenar(int energiaAgregada) {
		if ((this.energia+energiaAgregada) > 200) {
			throw new DesbordeDeEnergiaException("La criatura salvaje superó la energia máxima permitida");
		} else {
			energia += energiaAgregada;
		}
	}

	@Override
	public void pacificar() {
		this.comportamiento = ComportamientoEmocional.TRANQUILO;		
	}

}
