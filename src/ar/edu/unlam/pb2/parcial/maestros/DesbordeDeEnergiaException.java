package ar.edu.unlam.pb2.parcial.maestros;
import ar.edu.unlam.pb2.parcial.criaturas.CriaturaSalvaje;

public class DesbordeDeEnergiaException extends RuntimeException {
	public DesbordeDeEnergiaException(String mensaje) {
        super(mensaje);
    }
}
