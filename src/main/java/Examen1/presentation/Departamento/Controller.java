package Examen1.presentation.Departamento;

import Examen1.Application;
import Examen1.logic.Departamento;

import javax.swing.*;
import java.awt.*;

public class Controller {

    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void preAgregar(){
        model.setModo(Application.MODO_AGREGAR);
        model.setCurrent(new Departamento());
        model.commit();
        this.show();
    }

    JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.ventanaPrincipal,"Sucursal", true);
        dialog.setSize(900,650);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setContentPane(view.getPanel());
        Point location = Application.ventanaPrincipal.getLocation();
        dialog.setLocation( location.x+400,location.y+100);
        dialog.setVisible(true);
    }

    public void hide(){
      dialog.dispose();
    }

    public void guardar(Departamento e) throws Exception {
        switch (model.getModo()) {
            case Application.MODO_AGREGAR:
                Examen1.logic.Service.instance().DapaAdd(e);
                model.setCurrent(new Departamento());
                break;
            case Application.MODO_EDITAR:
                Examen1.logic.Service.instance().Depaupdt(e);
                model.setCurrent(e);
                break;
        }
        model.commit();
    }

    public void editar(Departamento e) {
        model.setModo(Application.MODO_EDITAR);
        model.setCurrent(e);
        model.commit();
        this.show();
    }
}
