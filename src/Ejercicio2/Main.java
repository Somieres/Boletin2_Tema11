package Ejercicio2;

import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) {
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

        System.out.println(GestionarFicheros.transformarAObjeto(GestionarFicheros.buscarElementoPorApellido(fr,"Ramos")));
    }
}
