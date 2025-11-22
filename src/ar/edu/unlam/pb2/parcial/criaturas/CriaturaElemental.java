package ar.edu.unlam.pb2.parcial.criaturas;

import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;
import ar.edu.unlam.pb2.parcial.transformaciones.Transformacion;

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
	
	 public boolean esAncestral() {
	        return false;
	    }
	 public boolean puedeVolverseInestable() {
	        return true;
	    }
	 
	public void interactuarCon(CriaturaElemental otra) {
		if (this == otra) {
	        throw new IllegalArgumentException("Una criatura no puede interactuar consigo misma");	        
	    }
		if (this.esAncestral() && !otra.esAncestral()) {
            dominarInteraccion(this, otra);            
        }
        if (!this.esAncestral() && otra.esAncestral()) {
            dominarInteraccion(otra, this);            
        }
		
		if (this.afinidadPrincipal == otra.afinidadPrincipal) {
			this.energia += 10;
			otra.setEnergia(otra.getEnergia() + 10);			
		}
		if (sonOpuestas(this.afinidadPrincipal, otra.afinidadPrincipal)) {
           
            if (this.puedeVolverseInestable()) {
                this.comportamiento = ComportamientoEmocional.INESTABLE;
            }
            if (otra.puedeVolverseInestable()) {
                otra.comportamiento = ComportamientoEmocional.INESTABLE;
            }           
        }
	}

	private boolean sonOpuestas(AfinidadElemental a, AfinidadElemental b) {
		boolean sonOpuestos = false;
		if (a == AfinidadElemental.FUEGO && b == AfinidadElemental.AGUA
				|| a == AfinidadElemental.AGUA && b == AfinidadElemental.FUEGO) {
			sonOpuestos = true;
		} else if (a == AfinidadElemental.AIRE && b == AfinidadElemental.TIERRA
				|| a == AfinidadElemental.TIERRA && b == AfinidadElemental.AIRE) {
			sonOpuestos = true;
		}
		return sonOpuestos;
	}
	
	private void dominarInteraccion(CriaturaElemental ancestral, CriaturaElemental otra) {
        ancestral.setEnergia(ancestral.getEnergia() + 20);

        int energiaRestante = otra.getEnergia() - 15;
        if (energiaRestante < 0) {
            energiaRestante = 0;
        }
        otra.setEnergia(energiaRestante);
    }

	public abstract void entrenar(int energiaAgregada);

	public abstract void pacificar();

	public boolean estaTransformada() {
		return this instanceof Transformacion;
	}
}
