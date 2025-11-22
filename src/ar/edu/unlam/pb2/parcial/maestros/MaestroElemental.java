package ar.edu.unlam.pb2.parcial.maestros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.TipoTransformacion;
import ar.edu.unlam.pb2.parcial.transformaciones.AscensoDelViento;
import ar.edu.unlam.pb2.parcial.transformaciones.BendicionDelRio;
import ar.edu.unlam.pb2.parcial.transformaciones.LlamaInterna;
import ar.edu.unlam.pb2.parcial.transformaciones.VInculoTerrestre;

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
		//EN EQUIPO DECIDIMOS QUE CUANDO UN MAESTRO CON CIERTO GRADO DE MAESTRIA
		//INTENTA INTRENAR A UNA CRIATURA AGREGANDO MAS PUNTOS QUE SU GRADO DE MAESTRIA ENTONCES NO 
		//TIENE MAESTRIA SUFICIENTE Y POR LO TANTO SE LANZA UN MAESTRIAINSUFICIENTEEXCEPTION
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

	public void transformarCriatura(String nombre, TipoTransformacion tipo) {
		CriaturaElemental original = this.criaturas.get(nombre);
		if (original == null) {
			throw new IllegalArgumentException("La criatura " + nombre + " no existe");
		}

		CriaturaElemental transformada;

		switch (tipo) {
		case BENDICION_DEL_RIO:
			transformada = new BendicionDelRio(original);
			break;
		case LLAMA_INTERNA:
			transformada = new LlamaInterna(original);
			break;
		case VINCULO_TERRESTRE:
			transformada = new VInculoTerrestre(original);
			break;
		case ASCENSO_DEL_VIENTO:
			transformada = new AscensoDelViento(original);
			break;
		default:
			throw new IllegalArgumentException("Tipo de transformación no soportado: " + tipo);
		}

		this.criaturas.put(nombre, transformada);
	}

	public List<CriaturaElemental> getCriaturasRegistradas() {
		List<CriaturaElemental> lista = new ArrayList<CriaturaElemental>();

        for (CriaturaElemental criatura : this.criaturas.values()) {
            lista.add(criatura);
        }

		return lista;
	}

	public int getCantidadDeTransformadas() {
		int cantidad = 0;
		for (CriaturaElemental criatura : this.criaturas.values()) {
			if (criatura.estaTransformada()) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    MaestroElemental otro = (MaestroElemental) obj;
	    return nombre.equals(otro.nombre);
	}

	@Override
	public int hashCode() {
	    return nombre.hashCode();
	}

}