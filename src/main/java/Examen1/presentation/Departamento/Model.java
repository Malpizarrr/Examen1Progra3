package Examen1.presentation.Departamento;

import Examen1.logic.Departamento;

import java.util.Observable;

public class Model extends Observable {

    Departamento current;

    int modo;

    public Model() {
    }

    public void setCurrent(Departamento current) {
        this.current = current;
    }

    public Departamento getCurrent() {
        return current;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public int getModo() {
        return modo;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit(){
        setChanged();
        notifyObservers(null);
    }
}
