package Ejercicio2;

import com.sun.source.util.Trees;

import javax.imageio.event.IIOReadProgressListener;
import java.io.*;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class GestionarFicheros {


    static BufferedWriter bw = null;
    static BufferedReader br = null;
    static Scanner sc = null;
    static TreeSet<Cliente> listaClientes=new TreeSet<>();
    static List<Cliente> listaOrdenada=new ArrayList<>(listaClientes);
    static File f;
    static ObjectOutputStream oos;
    static ObjectInputStream ois;
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
   /* public static Cliente transformarAObjeto1(String registro){

         Cliente cliente = new Cliente();

        cliente.setNombre(registro.split(",")[0]);
        cliente.setApellido(registro.split(",")[1]);
        cliente.setCif(registro.split(",")[2]);
        cliente.setCategoria(Integer.parseInt(registro.split(",")[3]));
        cliente.setDireccion(registro.split(",")[4]);
        return cliente;
    }*/

    public static void ordenarFicheroLEctura(FileReader fr,FileWriter fw,String nombreFichero){

        try{

            f = new File(nombreFichero+".txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea = br.readLine();

            while(linea != null){

                listaClientes.add(transformarAObjeto(linea));
                linea = br.readLine();
            }

            f = new File(nombreFichero+".dat");
            oos = new ObjectOutputStream(new FileOutputStream(f));

            listaOrdenada = new ArrayList<>(listaClientes);
            for (int i = 0; i < listaOrdenada.size(); i++) {
                oos.writeObject(listaOrdenada.get(i));
            }

            ois = new ObjectInputStream(new FileInputStream(f));
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());


        } catch (FileNotFoundException e) {
            System.out.println("FICHERO NO ENCONTRADO AL ordenarFichero()");
        } catch (IOException e) {
            System.out.println("ERROR GENERAL AL ordenarFichero()");
        } catch (ClassNotFoundException e) {
            System.out.println("CLASE NO ENCONTRADA AL ordenarFichero()");
        } finally {
            try{
                fr.close();
                br.close();
                oos.close();
            } catch (IOException e) {
                System.out.println("ERROR AL CERRAR EL FICHERO AL ordenarFichero()");
            }
        }

    }
    public static void ordenarFichero(FileReader fr,FileWriter fw,String nombreFichero){

        try{
            File f = new File(nombreFichero+".txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea = br.readLine();

            while(linea != null){

                listaClientes.add(transformarAObjeto(linea));
                linea = br.readLine();
            }

            f = new File(nombreFichero+".dat");
            oos = new ObjectOutputStream(new FileOutputStream(f));

            listaOrdenada = new ArrayList<>(listaClientes);
            for (int i = 0; i < listaOrdenada.size(); i++) {
                oos.writeObject(listaOrdenada.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("FICHERO NO ENCONTRADO AL ordenarFichero()");
        } catch (IOException e) {
            System.out.println("ERROR GENERAL AL ordenarFichero()");
        }finally {
            try{
                fr.close();
                br.close();
                oos.close();
            } catch (IOException e) {
                System.out.println("ERROR AL CERRAR EL FICHERO AL ordenarFichero()");
            }
        }

    }

}