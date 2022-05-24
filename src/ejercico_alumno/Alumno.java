package ejercico_alumno;

import java.util.Arrays;

public class Alumno {

	private static int LONGMAXNOMBRE = 20;
	private static int LONGMAXAPELLIDO = 30;
	public static int LONGITUD = 45+(4*5);

	private int matricula;
	private String nombre;
	private String apellidos;
	private int[] notas;
	private double notaMedia;

	public Alumno (int matricula,String nombre,String apellidos,int[] notas){

		this.notas=notas;
		this.notaMedia = getNotaMedia();
		this.matricula=matricula;
		this.nombre=nombre;
		this.apellidos=apellidos;
		darLongitudFija();

	}

	public Alumno() {
		this.matricula=0;
		this.nombre="";
		this.apellidos="";
		this.notas = null;
		this.notaMedia = 0;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}

	public double getNotaMedia(){
		int suma = 0;
		for (int i = 0; i < notas.length; i++) {
			suma = suma + notas[i];
		}
		return ((double)suma/notas.length);
	}
	 

	private void darLongitudFija(){
		
		if(nombre.length()> LONGMAXNOMBRE){
			nombre.substring(0, LONGMAXNOMBRE);
		}
		else{
			for (int i = nombre.length(); i < LONGMAXNOMBRE; i++) {
				nombre=nombre+" ";
			}
		}
		if(apellidos.length()> LONGMAXAPELLIDO){
			apellidos.substring(0, LONGMAXAPELLIDO);
		}
		else{
			for (int i = apellidos.length(); i < LONGMAXAPELLIDO; i++) {
				apellidos=apellidos+" ";
			}
		}
	}

	public String toString(){
		

		return "Matricula : " + matricula + " | " + "Nombre : " + nombre + " | " + "Apellidos : " + apellidos + " | " + "Notas : " + Arrays.toString(notas) + " | " +
				"Nota media : " + getNotaMedia();
		
	}

}
