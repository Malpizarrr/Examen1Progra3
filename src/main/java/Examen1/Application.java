package Examen1;



import javax.swing.*;

import Examen1.logic.Service;
import Examen1.presentation.Departamentos.Controller;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Application {

    public static Examen1.presentation.main.Controller mainController;

    public static Examen1.presentation.Departamentos.Controller departamentosController;
    public static JFrame ventanaPrincipal;


    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static Examen1.presentation.Departamento.Controller departamentoController;

    public static void main(String[] args) {



        Examen1.presentation.Departamentos.Model modeld = new Examen1.presentation.Departamentos.Model();
        Examen1.presentation.Departamentos.view viewD = new Examen1.presentation.Departamentos.view();
        departamentosController = new Controller(viewD, modeld);



        Examen1.presentation.main.Model model = new Examen1.presentation.main.Model();
        Examen1.presentation.main.View view = new Examen1.presentation.main.View();

        Examen1.presentation.Departamento.View viewD1 = new Examen1.presentation.Departamento.View();
        Examen1.presentation.Departamento.Model modelD1 = new Examen1.presentation.Departamento.Model();

        departamentoController = new Examen1.presentation.Departamento.Controller(viewD1, modelD1);

        mainController = new Examen1.presentation.main.Controller(model, view);
        view.getPanel().add("Departamentos",viewD.getPanel());

        ventanaPrincipal = new JFrame();
        ventanaPrincipal.setSize(600, 600);
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaPrincipal.setVisible(true);
        mainController.show();


    }
}



