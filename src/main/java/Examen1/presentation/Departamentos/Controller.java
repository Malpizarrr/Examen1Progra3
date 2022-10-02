package Examen1.presentation.Departamentos;


import Examen1.Application;
import Examen1.logic.Departamento;
import Examen1.logic.Service;

public class Controller {
    view View;
    Model Model;

    public Controller(view view, Model model) {
        this.View = view;
        this.Model = model;
        view.setController(this);
        view.setModel(model);
    }



//    public void buscar(String filtro){
//        List<Empleado> rows = Service.instance().empleadosSearch(filtro);
//        model.setEmpleados(rows);
//        model.commit();
//    }

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

}
