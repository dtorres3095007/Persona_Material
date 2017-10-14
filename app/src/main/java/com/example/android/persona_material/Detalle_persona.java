package com.example.android.persona_material;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle_persona extends AppCompatActivity {
private CollapsingToolbarLayout collapsingToolbarLayout;
    private Persona p;
    private String cedula,nombre,apellido,sexo;
    private Bundle bundle;
    private TextView nom,ced,apel,se;
    private Intent i;
    private int fot;
    private ImageView foto;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        res = this.getResources();
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbard);
        foto = (ImageView) findViewById(R.id.fotopersona);
        nom = (TextView) findViewById(R.id.txt_tbl_nombre);
        ced = (TextView) findViewById(R.id.txt_tbl_cedula);
        apel = (TextView) findViewById(R.id.txt_tbl_apellido);
        se = (TextView) findViewById(R.id.txt_tbl_sexo);
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        cedula = bundle.getString("cedula");
        nombre = bundle.getString("nombre");
        apellido = bundle.getString("apellido");
        sexo = bundle.getString("sexo");
        fot = bundle.getInt("foto");
        nom.setText(nombre);
        ced.setText(cedula);
        apel.setText(apellido);
        se.setText(sexo);

        foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
        collapsingToolbarLayout.setTitle(nombre+" "+apellido);
    }

    public void Eliminar(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_eliminar_persona));
        builder.setMessage(res.getString(R.string.eliminar_mensaje));
       String positivo= res.getString(R.string.si_eliminar);
        String negativo =res.getString(R.string.no_eliminar);

        builder.setPositiveButton(positivo,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface,int i){
                Persona p = new Persona(cedula);
               Datos.EliminarPersona(p);

                onBackPressed();

            }
        });


        builder.setNegativeButton(negativo,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface,int i){
            }
        });



        AlertDialog dialog = builder.create();
        dialog.show();;
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(Detalle_persona.this,Principal.class);
        startActivity(i);
    }


}
