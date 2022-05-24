package Ejercicio2;

import java.io.Serializable;

public class Cliente implements Comparable, Serializable {

    private String nombre;
    private String apellido;
    private String cif;
    private int categoria;
    private String direccion;

    private static StringBuffer sb;

    public Cliente() {
        this.nombre="";
        this.apellido="";
        this.cif="";
        this.categoria=0;
        this.direccion="";
    }

    public Cliente(String nombre, String apellido, String cif, int categoria, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cif = cif;
        this.categoria = categoria;
        this.direccion = direccion;
    }

    public String getNombre() {

        sb=new StringBuffer();
        sb.append(nombre);
        sb.setLength(50);
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        sb=new StringBuffer();
        sb.append(apellido);
        sb.setLength(50);
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCif() {
        sb=new StringBuffer();
        sb.append(cif);
        sb.setLength(50);
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        sb=new StringBuffer();
        sb.append(direccion);
        sb.setLength(50);
        this.direccion = direccion;
    }

    @Override
    public int compareTo(Object o) {

        int comparacion=0;

        if (o instanceof Cliente){
            Cliente cliente=(Cliente) o;
            comparacion=this.cif.compareTo(cliente.cif);
          /*  if(comparacion==0){
                comparacion=this.nombre.compareTo(cliente.nombre);
                if (comparacion==0){
                    comparacion=this.apellido.compareTo(cliente.apellido);

                }
            }*/
        }
        return comparacion;
    }




    @Override
    public String toString() {
        return
                "nombre= " + nombre +", apellido= " + apellido  +", cif= " + cif + ", categoria= " + categoria +", direccion= " + direccion +System.lineSeparator();
    }


}
