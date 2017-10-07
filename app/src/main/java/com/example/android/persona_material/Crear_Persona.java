package com.example.android.persona_material;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Crear_Persona extends AppCompatActivity {
    private EditText cajaNombre;
    private  EditText cajaApellido;
    private TextInputLayout icajaNombre;
    private TextInputLayout icajaApellido;
    ArrayList<Integer> foto;
    private  Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__persona);
        cajaNombre = (EditText)findViewById(R.id.txtnombre);
        cajaApellido = (EditText)findViewById(R.id.txtapellido);
         res = this.getResources();

        foto = new ArrayList<>();
        foto.add(R.drawable.images);
        foto.add(R.drawable.images2);
        foto.add(R.drawable.images3);

        icajaNombre = (TextInputLayout)findViewById(R.id.cajanombre);
        icajaApellido = (TextInputLayout)findViewById(R.id.cajaapellido);

    }

    public void Guardar(View v){
        Persona p = new Persona(cajaNombre.getText().toString().trim(),cajaApellido.getText().toString().trim(),Metodos.fotoAleatoria(foto));
        p.guardar();
        Snackbar.make(v,res.getString(R.string.mensaje_exito),Snackbar.LENGTH_LONG).setAction("action",null).show();
        limpiar();
    }
    public void limpiar(){
        cajaNombre.setText("");
        cajaApellido.setText("");
    }
    public void Limpiar(View v){
        limpiar();
    }

    public void  onBackPressed(){
        finish();
        Intent i = new Intent(Crear_Persona.this,Principal.class);
        startActivity(i);
    }

}
