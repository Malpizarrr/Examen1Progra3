package Examen1.presentation.Departamento;

import Examen1.Application;
import Examen1.logic.Departamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements java.util.Observer {
    private JPanel panel1;
    private JLabel Codigolbl;
    private JTextField codtxtfld;
    private JLabel nombrelbl;
    private JTextField nombretxt;
    private JLabel auditadolbl;
    private JCheckBox auditadocheckbox;
    private JLabel Presupuestolbl;
    private JTextField presupuestotxt;
    private JButton guardarboton;
    private JButton CancelarBoton;
    Controller controller;

    Model model;

    public View() {
        guardarboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Departamento d = new Departamento();
                d=take();
                try{
                    controller.guardar(d);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        CancelarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.hide();
            }
        });

    }

    public JPanel getPanel() {
        return panel1;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model){
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(java.util.Observable updatedModel,Object parametros){
        Departamento current = model.getCurrent();
        codtxtfld.setEnabled(model.getModo() == Application.MODO_AGREGAR);
        //codtxtfld.setText(current.getCodigo());
        //nombretxt.setText(current.getNombre());
        //auditadocheckbox.setSelected(current.isAuditado());
        //presupuestotxt.setText(String.valueOf(current.getPresupuesto()));
    }

    public Departamento take() {
        Departamento e = new Departamento();
        e.setCodigo(codtxtfld.getText());
        e.setNombre(nombretxt.getText());
        e.setAauditado(auditadocheckbox.isSelected());
        e.setPresupuesto(Integer.parseInt(String.valueOf(presupuestotxt.getText())));
        return e;
    }


}
