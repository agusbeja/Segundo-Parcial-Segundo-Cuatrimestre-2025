package ar.edu.unlam.pb2.parcial.transformaciones;

import ar.edu.unlam.pb2.parcial.criaturas.CriaturaElemental;
import ar.edu.unlam.pb2.parcial.enums.AfinidadElemental;
import ar.edu.unlam.pb2.parcial.enums.ComportamientoEmocional;

public abstract class Transformacion extends CriaturaElemental {

    protected CriaturaElemental criaturaBase;

    public Transformacion(CriaturaElemental criatura) {
        super(
            criatura.getNombre(),
            criatura.getEnergia(),
            criatura.getAfinidadPrincipal(),
            criatura.getComportamiento()
        );
        this.criaturaBase = criatura;
    }

    @Override
    public abstract int getEnergia();

    @Override
    public abstract AfinidadElemental getAfinidadPrincipal();

    @Override
    public abstract ComportamientoEmocional getComportamiento();

    @Override
    public void entrenar(int energiaAgregada) {
        criaturaBase.entrenar(energiaAgregada);
    }

    @Override
    public void pacificar() {
        criaturaBase.pacificar();
    }
}
