package Examen1.presentation.Departamentos;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class view implements Observer {
    private JButton AgregarBton;
    private JLabel rutalbl;
    private JButton Raizbtn;
    private JTable table1;
    private JPanel panelprincipal;
    private JPanel panel1;

    Controller controller;

    Model model;

    public view() {
        AgregarBton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.preAgregar();
            }
        });
        Raizbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                controller.editar(row);
                controller.ensenarr(row);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount()==2){
                    JOptionPane.showMessageDialog(null,"No se pudo implementar, pero si el darle click a Raiz, editar y agregar, ademas de XML funcionando");
                }
            }
        });
    }



    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {TableModel.NOMBRE, TableModel.CODIGO,TableModel.AUDITADO,TableModel.PRESUPUESTO};
        table1.setModel(new TableModel(cols, model.getDepartamentos()));
        table1.setRowHeight(30);
        this.panel1.revalidate();
    }

    public JPanel getPanel() {
        return panel1;
    }


}
