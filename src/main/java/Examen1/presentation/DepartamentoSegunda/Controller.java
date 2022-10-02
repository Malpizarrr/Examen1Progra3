package Examen1.presentation.DepartamentoSegunda;


import Examen1.Application;
import Examen1.logic.Departamento;
import Examen1.logic.Service;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    view View;
    Model Model;

    public Controller(view view, Model model) {
        model.setDepartamento(Service.instance().empleadosSearch(""));
        this.View = view;
        this.Model = model;
        view.setController(this);
        view.setModel(model);
    }



    public void buscar(String filtro){
        List<Departamento> rows = Service.instance().empleadosSearch(filtro);
        Model.setDepartamento(rows);
        Model.commit();
    }

    public void preAgregar(){
        Application.departamentoController.preAgregar();
    }

    public void editar(int row){
        String cedula = Model.getDepartamentos().get(row).getCodigo();
        Departamento e=null;
        try {
            e= Service.instance().DepartaGet(cedula);
            Application.departamentoController.editar(e);
        } catch (Exception ex) {
        }
    }

    public void editar2(int row){
        String cedula = Model.getDepartamentos().get(row).getCodigo();
        Departamento e=null;
        try {
            e= Service.instance().DepartaGet(cedula);
            Application.departamentoController.editar(e);
        } catch (Exception ex) {
        }
    }

//    public void verEmpleado(int row){
//        String cedula = model.getEmpleados().get(row).getCedula();
//        Empleado e=null;
//        try {
//            e= Service.instance().empleadoGet(cedula);
//            Application.empleadoController.editar(e);
//        } catch (Exception ex) {}
//    }


//    public void eliminar(int row) throws Exception {
//        String cedula = model.getEmpleados().get(row).getCedula();
//        Empleado e=null;
//        try {
//            e= Service.instance().empleadoGet(cedula);
//            Application.empleadoController.eliminar(e);
//        } catch (Exception ex) {}
//    }

    JDialog dialog;
    public void show(){
        dialog = new JDialog(Application.ventanaPrincipal,"Departamento", true);
        dialog.setSize(900,650);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setContentPane(View.getPanel());
        Point location = Application.ventanaPrincipal.getLocation();
        dialog.setLocation( location.x+400,location.y+100);
        dialog.setVisible(true);
    }

    public void eliminar(int row) throws Exception {
        String cedula = Model.getDepartamentos().get(row).getCodigo();
        Departamento e=null;
        try {
            e= Service.instance().DepartaGet(cedula);
            Application.departamentoController.eliminar(e);
        } catch (Exception ex) {}
    }
}
