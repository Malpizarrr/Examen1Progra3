package Examen1.presentation.main;

public class Model extends java.util.Observable {
    public Model() {
    }

    public void commit(){
        setChanged();
        notifyObservers();
    }

    @Override
    public void addObserver(java.util.Observer o){
        super.addObserver(o);
        commit();
    }




}
