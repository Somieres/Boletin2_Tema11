package Ejercicio2;

import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) {
        FileWriter fw=null;
        FileReader fr=null;

            Cliente c1 = new Cliente("Eva", "Ramos", "cf12", 1, "C/mostrenco");
            GestionarFicheros.altaCliente(fw, c1);

            Cliente c2 = new Cliente("Manu", "Lopez", "cf13", 2, "C/mostrenco2");
            GestionarFicheros.altaCliente(fw, c2);

            GestionarFicheros.elementoPorApellido(fr,"Ramos");

    }
}
