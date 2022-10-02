package Examen1.presentation.DepartamentoSegunda;

import Examen1.logic.Departamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Model extends Observable {

    private List<Departamento> departamentos;
    //private boolean editar;

    //public boolean isEditar() {
    // return editar;
    // }

    //public void setEditar(boolean editar) {
    // this.editar = editar;
    //}


    public Model(){
        this.setDepartamento(new ArrayList<Departamento>());
    }



    @Override
    public void addObserver(java.util.Observer o){
        super.addObserver(o);
        this.commit();
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamento(List<Departamento> departamento) {
        this.departamentos = departamento;
    }

    public void commit(){
        super.setChanged();
        super.notifyObservers(null);
    }

}
