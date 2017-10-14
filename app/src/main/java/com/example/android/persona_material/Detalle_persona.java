package com.example.android.persona_material;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class Detalle_persona extends AppCompatActivity {
private CollapsingToolbarLayout collapsingToolbarLayout;
    private Persona p;
    private String cedula,nombre,apellido,sexo;
    private Bundle bundle;
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

        i = getIntent();
        bundle = i.getBundleExtra("datos");
        cedula = bundle.getString("cedula");
        nombre = bundle.getString("nombre");
        apellido = bundle.getString("apellido");
        sexo = bundle.getString("sexo");
        fot = bundle.getInt("foto");

       // foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
        collapsingToolbarLayout.setTitle(nombre+" "+apellido);
    }
}
