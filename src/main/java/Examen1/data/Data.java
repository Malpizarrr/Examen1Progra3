package Examen1.data;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.FIELD)
public class Data {

    private List<Examen1.logic.Departamento> departamento;

    public Data() {
        departamento = new ArrayList<>();
    }

    public List<Examen1.logic.Departamento> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<Examen1.logic.Departamento> departamento) {
        this.departamento = departamento;
    }
}
