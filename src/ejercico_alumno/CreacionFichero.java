package ejercico_alumno;

import java.io.File;
import java.io.IOException;

public class CreacionFichero {


	public static void creaFichero(String directorio,String nombre){
		File ruta;
		File fichero;
		
		try{
			ruta = new File(directorio);
			fichero = new File(nombre+".dat");

			if(!ruta.exists() && ruta.isDirectory()){
				
				if(ruta.mkdirs()){
					
					if(fichero.createNewFile())
						System.out.println("CREADO");
					else
						System.out.println("NO SE PUEDE CREAR EL FICHERO");
				}
				else
					System.out.println("NO SE PUEDE CREAR EL DIRECTORIO");
			}
			else{
				
				if(fichero.createNewFile())
					System.out.println("CREADO");
				else
					System.out.println("NO SE PUEDE CREAR EL FICHERO");
			}
				
		}
		catch(NullPointerException | IOException npe){
			npe.printStackTrace();
		}
	}
	
	public static void main(String[] args){
	
			String directorio="";
			creaFichero(directorio,"Alumnos");	
	}
}
