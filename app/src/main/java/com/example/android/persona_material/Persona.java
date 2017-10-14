package com.example.android.persona_material;

/**
 * Created by android on 07/10/2017.
 */

public class Persona {

    private int foto;
    private String cedula;
    private String nombre;
    private String apellido;
    private int sexo;

    public Persona(String cedula, String nombre, String apellido, int sexo,int foto){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.sexo=sexo;
        this.foto = foto;
    }

    public Persona( String nombre, String apellido,int foto){
        this.cedula="";
        this.nombre=nombre;
        this.apellido=apellido;
        this.sexo=0;
        this.foto = foto;
    }
    public Persona(String cedula){
        this.cedula=cedula;

    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void guardar(){
        Datos.guardarPersona(this);
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
