package Ejercicio2;

import java.io.FileWriter;
import java.io.IOException;

public class GestionarFicheros {


    FileWriter fw=null;

    public static void escribirFichero(){

    }

    public static void altaCliente(FileWriter fw,Cliente cliente){

        try {

            fw = new FileWriter("Clientes.txt", true);
            fw.write(cliente.getNombre() + ", ");
            fw.write(cliente.getApellido() + ", ");
            fw.write(cliente.getCif() + ", ");
            fw.write(cliente.getCategoria() + ", ");
            fw.write(cliente.getDireccion() + ".");



        }catch (IOException ex){
            ex.getMessage();
        }

    }

}
