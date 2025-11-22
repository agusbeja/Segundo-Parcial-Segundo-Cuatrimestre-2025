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
	 public void interactuarCon(CriaturaElemental otra) {		   
		    if (this.afinidadPrincipal == otra.afinidadPrincipal) {
		        this.energia += 10;
		        otra.setEnergia(otra.getEnergia() + 10);
		        return;
		    }		    
		    if (sonOpuestas(this.afinidadPrincipal, otra.afinidadPrincipal)) {
		        this.comportamiento = ComportamientoEmocional.INESTABLE;
		        otra.comportamiento = ComportamientoEmocional.INESTABLE;
		        return;
		    }
		}
	 
	 private boolean sonOpuestas(AfinidadElemental a, AfinidadElemental b) {
		 boolean sonOpuestos = false;
		 if (a == afinidadPrincipal.FUEGO && b == AfinidadElemental.AGUA || a == AfinidadElemental.AGUA && b == AfinidadElemental.FUEGO) {
			 sonOpuestos = true;
		 } else if (a == AfinidadElemental.AIRE && b == AfinidadElemental.TIERRA || a == AfinidadElemental.TIERRA && b == AfinidadElemental.AIRE) {
			 sonOpuestos = true;
		 }		   
		 return sonOpuestos;
		}
    
	 public abstract void entrenar(int energiaAgregada);
	 public abstract void pacificar();
}
