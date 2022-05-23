package Ejercicio2;

import java.io.*;
import java.net.PortUnreachableException;
import java.util.Scanner;

public class GestionarFicheros {


    static BufferedWriter bw=null;
    static BufferedReader br=null;
    static Scanner sc=null;

    public static void escribirFichero(){

    }

    public static void altaCliente(FileWriter fw,Cliente cliente){



        try {
            fw=new FileWriter("Cliente.txt", true);
            bw=new BufferedWriter(fw);
            bw.write(cliente.getNombre()+",");
            bw.write(cliente.getApellido()+",");
            bw.write(cliente.getCif()+",");
            bw.write(cliente.getCategoria()+",");
            bw.write(cliente.getDireccion());
            bw.newLine();


        } catch (IOException ex) {
            ex.getMessage();
        }
        finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("error cierre ficheros, modulo altaCliente");;
            }
        }
    }

    public static void elementoPorApellido(FileReader fr,String apellido){

        try {

            apellido=apellido+", ";

            fr =new FileReader("Clientes.txt");
            br=new BufferedReader(fr);
            String linea= br.readLine();
           while (linea!=null) {
               sc = new Scanner(linea);

               if(sc.hasNext())


               linea= br.readLine();
           }



        }catch (IOException ex){
            System.out.println("Error al abrir el archivo");
        }

    }

}
