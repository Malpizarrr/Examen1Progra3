package Examen1.data;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jdk.dynalink.linker.LinkerServices;

import javax.swing.*;
import java.awt.event.WindowStateListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class XmlPersistence {
    private String path;
    private static XmlPersistence instancia;

    private XmlPersistence(){
        path="cuentas.xml";
    }
    public static XmlPersistence getInstancia(){
        if(instancia==null){
            instancia=new XmlPersistence();
        }
        return instancia;
    }
    public Data load()throws Exception{
        JAXBContext context= JAXBContext.newInstance(Data.class);
        FileInputStream target= new FileInputStream(path);
        Unmarshaller unmarshaller= context.createUnmarshaller();
        Data datos= (Data)unmarshaller.unmarshal(target);//Deserializa, esta vez solo necesito el archivo desde donde voy a levantar
        return datos;
    }

    public void save(Data data) throws Exception{
        //Proceso de creacion del marshaller(Serializador)
        JAXBContext context= JAXBContext.newInstance(Data.class);
        FileOutputStream target= new FileOutputStream(path);//Archivo objetivo donde se escriben los datos
        Marshaller marshaller= context.createMarshaller();//Serializador hecho a partir del contexto brindado por data

        marshaller.marshal(data,target);//Serializacion y escritura
        target.flush();
        target.close();
    }


}
