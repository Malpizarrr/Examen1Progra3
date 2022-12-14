package Examen1.presentation.Departamentos;


import Examen1.Application;
import Examen1.logic.Departamento;
import Examen1.logic.Service;

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

    public void ensenarr(int row){
        String cedula = Model.getDepartamentos().get(row).getCodigo();
        Departamento e=null;
        try {
            //e= Service.instance().DepartaGet(cedula);
            Application.depasegundaController.show();
        } catch (Exception ex) {
        }
    }

    public void editar(int row){
        String cedula = Model.getDepartamentos().get(row).getCodigo();
        Departamento e=null;
        try {
            e= Service.instance().DepartaGet(cedula);

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


    public void show(){
        Application.ventanaPrincipal.setContentPane(View.getPanel());
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
