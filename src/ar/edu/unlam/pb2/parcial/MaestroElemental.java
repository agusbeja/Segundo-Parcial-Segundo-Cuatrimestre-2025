package ar.edu.unlam.pb2.parcial;

import java.util.HashMap;
import java.util.Map;

public class MaestroElemental {

	private String nombre;
	private int maestria;
	private AfinidadElemental afinidad;
	private Map<String, CriaturaElemental> criaturas;

	public MaestroElemental(String nombre, int maestria, AfinidadElemental afinidad) {
		this.nombre = nombre;
		this.maestria = maestria;
		this.afinidad = afinidad;
		this.criaturas = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getMaestria() {
		return maestria;
	}

	public AfinidadElemental getAfinidadPrincipal() {
		return afinidad;
	}

	public void agregarCriatura(CriaturaElemental criatura) {
		if (criatura == null || criatura.getNombre() == null) {
			throw new IllegalArgumentException("La criatura y su nombre no pueden ser nulos");
		}
		this.criaturas.put(criatura.getNombre(), criatura);
	}

	public CriaturaElemental buscarCriatura(String nombreCriatura) {
		return this.criaturas.get(nombreCriatura);
	}

	public void entrenarCriatura(String nombreCriatura, int puntos) throws MaestriaInsuficienteException {
		if (puntos <= 0) {
			throw new IllegalArgumentException("Los puntos de entrenamiento deben ser positivos");
		}

		if (this.maestria < puntos) {
			throw new MaestriaInsuficienteException(
					"Maestría insuficiente: nivel " + this.maestria + " < puntos de entrenamiento " + puntos);
		}
		CriaturaElemental criatura = this.criaturas.get(nombreCriatura);
		if (criatura == null) {
			throw new IllegalArgumentException("La criatura " + nombreCriatura + " no existe");
		}

		criatura.entrenar(puntos);
	}

	public void pacificarCriatura(String nombreCriatura) {
		CriaturaElemental criatura = this.criaturas.get(nombreCriatura);
		if (criatura == null) {
			throw new IllegalArgumentException("La criatura " + nombreCriatura + " no existe");
		}
		criatura.pacificar();
	}
}