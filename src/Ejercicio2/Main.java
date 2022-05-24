package Ejercicio2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {
       try{
           File f;
           f = null;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

        FileWriter fw=null;
        FileReader fr=null;

          //  Cliente c1 = new Cliente("Eva", "Ramos", "cf12", 1, "C/mostrenco");
          //  GestionarFicheros.altaCliente(fw, c1);

         //   Cliente c2 = new Cliente("Manu", "Lopez", "cf13", 2, "C/mostrenco2");
         //   GestionarFicheros.altaCliente(fw, c2);

          //  GestionarFicheros.consultarElementoPorApellido(fr,"Ramos");
       // System.out.println( GestionarFicheros.buscarElementoPorApellido(fr,"Lopez"));

      //  Cliente cliente3=new Cliente("Virginia","Delgado", "cf10",3,"C/mostrenco3");
      //  GestionarFicheros.insertarModificacionCliente(fw,cliente3);

      //  System.out.println(GestionarFicheros.transformarAObjeto(GestionarFicheros.buscarElementoPorApellido(fr,"Ramos")));
      // Set<Cliente> lista = new TreeSet<>();
      //  lista.add(new Cliente("Paco","Albiñana","cf15", 5, "C/mostrenco5"));
       // lista.add(new Cliente("Paca","Albiñana","cf15", 5, "C/mostrenco5"));
//GestionarFicheros.transformarAObjeto1("Eva,Ramos,cf12,1,C/mostrenco");
        System.out.println(GestionarFicheros.transformarAObjeto(GestionarFicheros.buscarElementoPorApellido(fr,"Ramos")));




    }
}
