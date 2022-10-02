package Examen1.logic;

public class Departamento {
    private String nombre;
    private String codigo;
    private boolean Auditado;
    private int Presupuesto;
    private Departamento departamento;

    public Departamento(String nombre, String codigo, boolean Auditado, int Presupuesto, Departamento departamento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.Auditado = Auditado;
        this.Presupuesto = Presupuesto;
        if (departamento == null) {
            this.departamento = null;
        } else {
            this.departamento = departamento;
        }
    }

    public Departamento(){
        this.nombre = "";
        this.codigo = "";
        this.Auditado = false;
        this.Presupuesto = 0;
        this.departamento = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isAuditado() {
        return Auditado;
    }
    public void setAauditado(boolean Auditado) {
        this.Auditado = Auditado;
    }

    public int getPresupuesto(){
        return Presupuesto;
    }

    public void setPresupuesto(int Presupuesto){
        this.Presupuesto = Presupuesto;
    }

    public Departamento getDepartamento(){
        return departamento;
    }

    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }

}
