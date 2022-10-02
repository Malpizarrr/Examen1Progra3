package Examen1.presentation.main;

import Examen1.Application;
import Examen1.logic.Service;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
            Application.ventanaPrincipal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    Service.instance().store();
                }
            });
        }

}

