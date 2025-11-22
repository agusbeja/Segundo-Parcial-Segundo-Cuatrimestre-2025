package ar.edu.unlam.pb2.parcial.criaturas;

import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public abstract class CriaturaElemental {
	protected String nombre;
    protected int energia;
    protected AfinidadElemental afinidadPrincipal;
    protected ComportamientoEmocional comportamiento;
    
	public CriaturaElemental(String nombre, int energia, AfinidadElemental afinidadPrincipal,
			ComportamientoEmocional comportamiento) {
		super();
		this.nombre = nombre;
		this.energia = energia;
		this.afinidadPrincipal = afinidadPrincipal;
		this.comportamiento = comportamiento;
	}
	
	 public String getNombre() {
	     return nombre;
	 }
	 public int getEnergia() {
	     return energia;
	 }

	 protected void setEnergia(int energia) {
	     this.energia = energia;
	 }

	 public AfinidadElemental getAfinidadPrincipal() {
	    return afinidadPrincipal;
	 }

	 public ComportamientoEmocional getComportamiento() {
	    return comportamiento;
	 }
    
	 public abstract void entrenar(int energiaAgregada);
	 public abstract void pacificar();
}
