package Examen1.presentation.main;

import Examen1.Application;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }

    public Controller(Examen1.presentation.Departamento.View viewD1, Examen1.presentation.Departamento.Model modelD1) {
    }

    public void show(){
        Application.ventanaPrincipal.setContentPane(view.getPanel());
    }
}

