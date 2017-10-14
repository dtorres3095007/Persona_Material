package com.example.android.persona_material;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class Datos {
    private static ArrayList<Persona> personas = new ArrayList();

    public static void guardarPersona(Persona p){
        personas.add(p);
    }

    public static ArrayList<Persona> obtenerPersonas(){
        return personas;
    }
    public static boolean EliminarPersona(Persona p){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(p.getCedula())){
                personas.remove(i);
                return true;
            }
        }
        return false;

    }

    public static boolean ExistePersona(String cedula){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)){
                return true;
            }
        }
        return false;

    }
    public static int ExistePersonaIndex(String cedula){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)){
                return i;
            }
        }
        return -1;

    }
public static int Modificar(String nombre,String apellido,String cedula,String cedulaV){

   int i =ExistePersonaIndex(cedula);
    if (i>-1) {
        int existe =ExistePersonaIndex(cedulaV);
        if (existe==i || existe==-1){
            Persona p = personas.get(i);
            p.setApellido(apellido);
            p.setCedula(cedulaV);
            p.setNombre(nombre);
            return 1;
        }
        return 3;
    }
    return 2;


}
public static void Vaciar(){
    personas.clear();
}
}
