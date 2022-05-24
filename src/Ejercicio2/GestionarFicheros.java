package Ejercicio2;

import javax.imageio.event.IIOReadProgressListener;
import java.io.*;
import java.net.PortUnreachableException;
import java.util.Scanner;

public class GestionarFicheros {


    static BufferedWriter bw = null;
    static BufferedReader br = null;
    static Scanner sc = null;

    public static void escribirFichero() {

    }

    public static void altaCliente(FileWriter fw, Cliente cliente) {


        try {
            fw = new FileWriter("Cliente.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(cliente.getNombre() + ", ");
            bw.write(cliente.getApellido() + ", ");
            bw.write(cliente.getCif() + ", ");
            bw.write(cliente.getCategoria() + ", ");
            bw.write(cliente.getDireccion());
            bw.newLine();


        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("error cierre ficheros, modulo altaCliente");
                ;
            }
        }
    }

    public static void consultarElementoPorApellido(FileReader fr, String ape) {

        try {

            String apellido;
            ape = ape + ",";
            fr = new FileReader("Cliente.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                sc = new Scanner(linea);
                if (sc.hasNext()) {
                    sc.next();
                }
                if (sc.hasNext()) {
                    apellido = sc.next();
                    if (apellido.equals(ape)) {
                        System.out.println(linea);
                    }

                }
                linea = br.readLine();
            }

        } catch (IOException ex) {
            System.out.println("Error al abrir el archivo");
        }

    }

    public static String buscarElementoPorApellido(FileReader fr, String ape) {

        String salida = "";
        try {

            String apellido;
            ape = ape + ",";
            fr = new FileReader("Cliente.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                sc = new Scanner(linea);
                if (sc.hasNext()) {
                    sc.next();
                }
                if (sc.hasNext()) {
                    apellido = sc.next();
                    if (apellido.equals(ape)) {
                        salida = linea;
                    }

                }
                linea = br.readLine();
            }

        } catch (IOException ex) {
            System.out.println("Error al abrir el archivo");
        }
        return salida;
    }

    public static void consultaElementoPorCif(FileReader fr, String cifCliente) {


             try {
                 String cif_;
                 cifCliente = cifCliente + ",";

                 fr = new FileReader("Cliente.txt");

                 br = new BufferedReader(fr);
                 String linea = br.readLine();
                 while (linea != null) {
                     sc = new Scanner(linea);

                     if (sc.hasNext()) {
                         sc.next();
                     }
                     if (sc.hasNext()) {
                         sc.next();
                     }
                     if (sc.hasNext()) {
                         cif_=sc.next();
                         if (cifCliente.equals(cif_)){
                             System.out.println(linea);
                         }
                     }
                     linea= br.readLine();

                 }
             }catch(IOException ex){
                     System.out.println("Error al abrir el archivo");
             }



    }
    public static String buscarElementoPorCif(FileReader fr, String cifCliente) {

        String salida="";
        try {
            String cif_;
            cifCliente = cifCliente + ",";

            fr = new FileReader("Cliente.txt");

            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                sc = new Scanner(linea);

                if (sc.hasNext()) {
                    sc.next();
                }
                if (sc.hasNext()) {
                    sc.next();
                }
                if (sc.hasNext()) {
                    cif_=sc.next();
                    if (cifCliente.equals(cif_)){
                        salida=linea;
                    }
                }
                linea= br.readLine();

            }
        }catch(IOException ex){
            System.out.println("Error al abrir el archivo");
        }

        return salida;

    }

    public static void insertarModificacionCliente(FileWriter fw,Cliente cliente){

          try{
            fw = new FileWriter("ClienteModificados.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(cliente.getNombre()+", ");
            bw.write(cliente.getApellido()+", ");
            bw.write(cliente.getCif()+", ");
            bw.write(cliente.getCategoria()+", ");
            bw.write(cliente.getDireccion());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error general");
        }finally {
            try {
                bw.close();
            }catch (IOException ex){
                System.out.println("Error al cierre del fichero");
            }
        }
    }

    public static void realizarModificaciones(FileWriter cliente, FileReader modificaciones){

         try {
             cliente=new FileWriter("Cliente.txt",true);
             modificaciones=new FileReader("ClienteModificados.txt");
             bw=new BufferedWriter(cliente);
             br=new BufferedReader(modificaciones);
             String linea= br.readLine();
             while (linea!=null){
                 bw.write(linea);
                 linea=br.readLine();
             }
         }catch (IOException ex){
             System.out.println("Error general");
         }finally {
             try {
                 br.close();
                 bw.close();
             }catch (IOException ex){
                 System.out.println("error al cierre del fichero");
             }
         }

     }

    public static void insertarBajaCliente(FileWriter fw, Cliente cliente){

        try {

            fw=new FileWriter("ClienteBaja.txt", true);
            bw=new BufferedWriter(fw);

            bw.write(cliente.getNombre());
            bw.write(cliente.getApellido());
            bw.write(cliente.getCif());
            bw.write(cliente.getCategoria());
            bw.write(cliente.getDireccion());
            bw.newLine();


        }catch (IOException ex){
            System.out.println("Error general");
        }finally {
            try{
                bw.close();
            }catch (IOException ex){
                System.out.println("error al cierre del archivo");
            }
        }


    }

    public static void realizarBajas(FileWriter cliente, FileReader bajas){

        try {
            cliente=new FileWriter("Cliente.txt",true);
            bajas=new FileReader("ClientesBaja.txt");
            bw=new BufferedWriter(cliente);
            br=new BufferedReader(bajas);

            String linea=br.readLine();
            while (linea!=null){
                bw.write(linea);
                linea=br.readLine();
            }

        }catch (IOException ex){
            System.out.println("Error general");
        }finally {
            try {
                bw.close();
                br.close();
                cliente.close();
                bajas.close();
            }catch (IOException ex){
                System.out.println("error al cerrar el fichero");
            }
        }

    }

    public static Cliente transformarAObjeto(String registro){

        String nombre="";
        String apellido="";
        String cif="";
        char categoria=0;
        String direccion="";

            sc=new Scanner(registro);
            if (sc.hasNext()){
                nombre=sc.next();
            }
            if (sc.hasNext()){
                apellido=sc.next();
            }
            if (sc.hasNext()){
                cif=sc.next();
            }
            if (sc.hasNextLine()){
                categoria=sc.next().charAt(0);
            }
            if (sc.hasNextLine()){
                direccion=sc.nextLine();
            }
         return new Cliente(nombre, apellido,cif,Character.getNumericValue(categoria),direccion);
    }

}