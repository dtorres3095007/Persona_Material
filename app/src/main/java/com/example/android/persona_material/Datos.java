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
}
