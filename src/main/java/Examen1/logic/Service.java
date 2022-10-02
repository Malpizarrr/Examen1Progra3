package Examen1.logic;

import Examen1.data.Data;
import Examen1.data.XmlPersister;


import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static Service theInstance;
    public static Service instance(){
        if (theInstance == null){
            theInstance = new Service();
        }
        return theInstance;
    }
    private Data data;
    private Service(){
        try{
            data = XmlPersister.instance().load();
        }
        catch(Exception e){
            data=new Data();
        }
    }


    public Departamento DepartaGet(String cedula) throws Exception{
        Departamento result = data.getDepartamento().stream().filter(e->e.getCodigo().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Persona no existe");
    }

    public void DapaAdd(Departamento persona) throws Exception{
        Departamento result = data.getDepartamento().stream().filter(e->e.getCodigo().equals(persona.getCodigo())).findFirst().orElse(null);
        if (result==null) data.getDepartamento().add(persona);
        else throw new Exception("Departa ya existe");
    }

    public void Depadel(Departamento persona) throws Exception{
        Departamento result = data.getDepartamento().stream().filter(e->e.getCodigo().equals(persona.getCodigo())).findFirst().orElse(null);
        if (result!=null) data.getDepartamento().remove(persona);
        else throw new Exception("Persona no existe");
    }

    public void Depaupdt(Departamento persona) throws Exception{

        Departamento result;
        try{
            result = this.DepartaGet(persona.getCodigo());
            data.getDepartamento().remove(result);
            data.getDepartamento().add(persona);
        }catch (Exception e) {
            throw new Exception("Persona no existe");
        }
    }

    public List<Departamento> empleadosSearch(String filtro) {
        if (data.getDepartamento().stream().filter(e -> e.getNombre().contains(filtro)).count() != 0){
            return data.getDepartamento().stream().filter(e -> e.getNombre().contains(filtro)).collect(Collectors.toList());
        }
        else if(data.getDepartamento().stream().filter(e -> e.getCodigo().contains(filtro)).count() != 0) {
            return data.getDepartamento().stream().filter(e -> e.getCodigo().contains(filtro)).collect(Collectors.toList());
        }
        return List.of();
    }

    public void store(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
