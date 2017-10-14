package com.example.android.persona_material;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Crear_Persona extends AppCompatActivity {
    private EditText txtnombre;
    private  EditText txtapellido,txtcedula;
    private TextInputLayout icajaNombre;
    private TextInputLayout icajaApellido;
    private TextInputLayout icajacedula;
    ArrayList<Integer> foto;
    private  Resources res;
    private Spinner genero_spiner;
    private String genero_vector[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__persona);
        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtcedula = (EditText)findViewById(R.id.txtcedula);
        txtapellido = (EditText)findViewById(R.id.txtapellido);
        genero_spiner=(Spinner) findViewById(R.id.cbxsexo);
         res = this.getResources();
        genero_vector=res.getStringArray(R.array.sexo);
        IniciarFotos();
        ArrayAdapter<String> adapter_genero = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,genero_vector);
        genero_spiner.setAdapter(adapter_genero);
        icajaNombre = (TextInputLayout)findViewById(R.id.cajanombre);
        icajaApellido = (TextInputLayout)findViewById(R.id.cajaapellido);
        icajacedula = (TextInputLayout)findViewById(R.id.cajacedula);

    }
public void IniciarFotos(){
    foto = new ArrayList<>();
    foto.add(R.drawable.images);
    foto.add(R.drawable.images2);
    foto.add(R.drawable.images3);
}
    public void Guardar(View v){
        if (Validar()) {
            int opcion_genero = genero_spiner.getSelectedItemPosition();
            //int cedula = Integer.parseInt(cajacedula.getText().toString());
            Persona p = new Persona(txtcedula.getText().toString(), txtnombre.getText().toString().trim(), txtapellido.getText().toString().trim(), opcion_genero, Metodos.fotoAleatoria(foto));
            p.guardar();
            Snackbar.make(v, res.getString(R.string.mensaje_exito), Snackbar.LENGTH_LONG).setAction("action", null).show();
            limpiar();
        }
    }
    public void limpiar(){
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        genero_spiner.setSelection(0);
        txtnombre.requestFocus();
    }
    public void Limpiar(View v){
        limpiar();
    }

    public void  onBackPressed(){
        finish();
        Intent i = new Intent(Crear_Persona.this,Principal.class);
        startActivity(i);
    }
    public boolean Validar(){
        if (Validar_aux(txtnombre,icajaNombre))return false;
        else if (Validar_aux(txtapellido,icajaApellido))return false;
        else if (Validar_aux(txtcedula,icajacedula))return false;
        else if(Datos.ExistePersona(txtcedula.getText().toString())){icajacedula.setError(res.getString(R.string.existe_persona)); return false;}
        return true;
    }

    public boolean Validar_aux(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            ct.setError(res.getString(R.string.no_vacio));
            return  true;
        }
        ct.setError("");
        return false;
    }
}
