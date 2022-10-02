package Examen1.presentation.DepartamentoSegunda;

import Examen1.logic.Departamento;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel implements javax.swing.table.TableModel {
    List<Departamento> rows;
    int[] cols;

    public TableModel(int[] cols, List<Departamento> rows){
        initColNames();
        this.cols=cols;
        this.rows=rows;
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            default: return super.getColumnClass(col);
        }
    }

    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Departamento d = rows.get(row);
        switch (cols[col]){
            case CODIGO: return d.getCodigo();
            case NOMBRE: return d.getNombre();
            case AUDITADO: return d.isAuditado();
            case PRESUPUESTO: return d.getPresupuesto();
            default: return "";
        }
    }

    public static final int CODIGO=0;
    public static final int NOMBRE=1;

    public static final int AUDITADO=2;

    public static final int PRESUPUESTO=3;



    String[] colNames = new String[4];
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre";
        colNames[AUDITADO]= "Auditado";
        colNames[PRESUPUESTO]= "Presupuesto";
    }

}
