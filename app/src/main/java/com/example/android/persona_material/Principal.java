package com.example.android.persona_material;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements  AdaptadorPersona.OnPersonaClickListener{
private RecyclerView listado;
    private ArrayList<Persona> personas;
    private Resources res;
    private AdaptadorPersona adapter;
    private LinearLayoutManager llm;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        res = this.getResources();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listado = (RecyclerView) findViewById(R.id.opciones);

        personas = Datos.obtenerPersonas();


        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new AdaptadorPersona(getApplicationContext(),personas,this);

        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Principal.this,Crear_Persona.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPersonaClick(Persona p) {
        Intent i = new Intent(Principal.this,Detalle_persona.class);
        Bundle b = new Bundle();
        b.putString("cedula",p.getCedula());
        b.putString("nombre",p.getNombre());
        b.putString("apellido",p.getApellido());

        b.putInt("sexo", p.getSexo());
        b.putInt("foto",p.getFoto());
        i.putExtra("datos",b);
        startActivity(i);

    }
}
