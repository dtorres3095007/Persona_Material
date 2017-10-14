package com.example.android.persona_material;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //TEST CORRECTO DE EXISTE PERSONA CON VALOR TRUE
    @Test
    public void existe_persona_isCorrect_true() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertTrue(Datos.ExistePersona("1143454688"));
    }
    //TEST CORRECTO DE EXISTE PERSONA CON VALOR FALSE
    @Test
    public void existe_persona_is_Correct_false() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertFalse(Datos.ExistePersona("118"));
    }


    //TEST INCORRECTO DE EXISTE PERSONA CON VALOR TRUE
    @Test
    public void existe_persona_is_not_Correct_true() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertNotEquals(false,Datos.ExistePersona("1143454688"));
    }
    //TEST INCORRECTO DE EXISTE PERSONA CON VALOR FALSE
    @Test
    public void existe_persona_is_not_Correct_false() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertNotEquals(true,Datos.ExistePersona("118"));
    }
//TEST DE MODIFICAR PERSONA CORRECTO VALOR 1
    @Test
    public void modificar_persona_is_Correct_1() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertEquals(1,Datos.Modificar("oscar","cantillo","1143454688","11434554"));
    }
    //TEST DE MODIFICAR PERSONA CORRECTO VALOR 2
    @Test
    public void modificar_persona_is_Correct_2() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertEquals(2,Datos.Modificar("oscar","cantillo","1145488","11434554"));
    }
    //TEST DE MODIFICAR PERSONA CORRECTO VALOR 3
    @Test
    public void modificar_persona_is_Correct_3() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertEquals(3,Datos.Modificar("oscar","cantillo","1143454688","1554454548"));
    }
    //TEST DE MODIFICAR PERSONA inCORRECTO VALOR 1
    @Test
    public void modificar_persona_is_not_Correct_1() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertNotEquals(3,Datos.Modificar("oscar","cantillo","1143454688","11434554"));
    }
    //TEST DE MODIFICAR PERSONA INCORRECTO VALOR 2
    @Test
    public void modificar_persona_is_not_Correct_2() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertNotEquals(1,Datos.Modificar("oscar","cantillo","1145488","11434554"));
    }
    //TEST DE MODIFICAR PERSONA INCORRECTO VALOR 3
    @Test
    public void modificar_persona_is_not_Correct_3() throws Exception {
        Datos.Vaciar();
        Persona p1 = new Persona("1143454688","damian","torres",1,1);
        p1.guardar();
        Persona p2 = new Persona("1148985635","juan","oquendo",1,1);
        p2.guardar();
        Persona p3 = new Persona("1554454548","pedro","ferrer",1,1);
        p3.guardar();
        Persona p4 = new Persona("9744526455","lucas","perez",1,1);
        p4.guardar();

        assertNotEquals(6,Datos.Modificar("oscar","cantillo","1143454688","1554454548"));
    }
}