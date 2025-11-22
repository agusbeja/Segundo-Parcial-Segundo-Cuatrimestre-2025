package ar.edu.unlam.pb2.parcial.maestros;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaSalvaje;

public class MaestriaInsuficienteException extends Exception {
	public MaestriaInsuficienteException(String mensaje) {
		super(mensaje);
	}
}