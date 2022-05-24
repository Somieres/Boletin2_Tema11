package ejercico_alumno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class GestonarAlumnos {

	public static void escribirAlumnosEnFichero(String ruta, Alumno a){
		File f = null;
		RandomAccessFile raf = null;
		int[] notas = a.getNotas();
		
		try{
			f = new File(ruta);
			raf = new RandomAccessFile(f, "rw");
			raf.seek(raf.length());
			raf.writeInt(a.getMatricula());
			raf.writeBytes(a.getApellidos()+"\n");
			raf.writeBytes(a.getNombre()+"\n");
			for (int nota : notas) {
				raf.writeInt(nota);
			}
		} catch(NullPointerException | FileNotFoundException npe){
			System.out.println("EL ARCHIVO NO SE HA ENCONTRADO O ES NULL");
		} catch (IOException e) {
			System.out.println("ERROR GENERAL AL escribirAlumnosEnFichero()");
		} finally{
			try{
				raf.close();
			}catch(IOException ioe){
				System.out.println("ERROR AL CERRAR EL FICHERO AL escribirAlumnosEnFichero()");
			}
		}
	}
	

	public static Alumno leerAlumnoDeFichero(String ruta, int puntero){
				
		File fichero;
		RandomAccessFile raf = null;
		
		int matricula = 0;
		int[] notas = {0,0,0,0};
		String nombre = "", apellidos = "";

		
		try{
			fichero = new File(ruta);
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0);
			raf.seek((long) (Alumno.LONGITUD + 2) *(puntero));
			matricula=raf.readInt();
			apellidos=raf.readLine();
			nombre=raf.readLine();
			for (int i = 0; i < notas.length; i++) {
				notas[i]=raf.readInt();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FICHERO NO ENCONTRADO AL leeAlumno()");
		} catch (IOException e) {
			System.out.println("ERROR GENERAL AL leeAlumno()");
		} finally{
			try{
				raf.close();
			} catch (IOException e) {
				System.out.println("ERROR AL CERRAR EL FICHERO AL leeAlumno()");
			}

		}
		
		return (new Alumno(matricula,nombre,apellidos,notas));
	}

	public static List<Alumno> buscarAlumnoYAñadirloALaLista(String ruta, String nombreAl){

		File fichero;
		RandomAccessFile raf = null;
		long longitudFichero;
		int matricula;
		int[] notas = {0,0,0,0};
		String nombre, apellidos;
		double notaMedia=0;
		List <Alumno> listaAlumnos = new ArrayList<>();
		
		try{
			fichero = new File(ruta);
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0);
			longitudFichero=raf.length();
			while(raf.getFilePointer()<longitudFichero){
				
				matricula=raf.readInt();
				apellidos=raf.readLine();
				nombre=raf.readLine();

				for (int i = 0; i < notas.length; i++)
				{
					notas[i]=raf.readInt();
				}

				if(nombre.contains(nombreAl)){
					listaAlumnos.add(new Alumno(matricula,nombre,apellidos,notas));
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FICHERO NO ENCONTRADO AL buscaAlumnosPorNombre()");
		} catch (IOException e) {
			System.out.println("ERROR GENERAL AL buscaAlumnosPorNombre()");
		} finally{
			try{
				raf.close();
			} catch (IOException e) {
				System.out.println("ERROR AL CERRAR EL FICHERO AL buscaAlumnosPorNombre()");
			}
		}
		return listaAlumnos;
	}
}
