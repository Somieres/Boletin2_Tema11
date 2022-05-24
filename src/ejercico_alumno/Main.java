package ejercico_alumno;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CreacionFichero.creaFichero("","Alumnos");

        Alumno a = new Alumno(1,"Eva","Ramos",new int[]{3,4,7,7});
        Alumno a1 = new Alumno(2,"Manu","Lopez",new int[]{8,5,7,9});
        Alumno a2 = new Alumno(3,"Paco","Albiñana",new int[]{5,3,9,8});

        GestonarAlumnos.escribirAlumnosEnFichero("Alumnos.dat",a);
        GestonarAlumnos.escribirAlumnosEnFichero("Alumnos.dat",a1);
        GestonarAlumnos.escribirAlumnosEnFichero("Alumnos.dat",a2);


        System.out.println(GestonarAlumnos.leerAlumnoDeFichero("Alumnos.dat",1));
        System.out.println(GestonarAlumnos.leerAlumnoDeFichero("Alumnos.dat",3));


        List<Alumno> alumnos = GestonarAlumnos.buscarAlumnoYAñadirloALaLista("Alumnos.dat", "Roberto");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}
