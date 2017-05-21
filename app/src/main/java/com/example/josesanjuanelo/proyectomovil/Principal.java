package com.example.josesanjuanelo.proyectomovil;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    TabHost th;
    private Spinner cbxDepartamentos;
    private Resources res;
    private ArrayList<Ciudad> k = new ArrayList();
    private ArrayAdapter<String> ad1;
    private String [] opc1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res = this.getResources();

        cbxDepartamentos = (Spinner)findViewById(R.id.spnDepartamentos);

        opc1 = this.getResources().getStringArray(R.array.deptos);

        ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc1);

        cbxDepartamentos.setAdapter(ad1);

        th = (TabHost)findViewById(R.id.tabhPrincipal);
        th.setup();
        TabHost.TabSpec ts1=th.newTabSpec("Tab1");
        ts1.setIndicator("Inicio");
        ts1.setContent(R.id.tab1);

        th.addTab(ts1);

        th.setup();
        TabHost.TabSpec ts2=th.newTabSpec("Tab2");
        ts2.setIndicator("Fotos");
        ts2.setContent(R.id.tab2);

        th.addTab(ts2);

        th.setup();
        TabHost.TabSpec ts3=th.newTabSpec("Tab3");
        ts3.setIndicator("Temporada");
        ts3.setContent(R.id.tab3);

        th.addTab(ts3);
    }

    public  void mostrarRegistro1(View v){
        Intent i = new Intent(Principal.this, RegistroCiudades.class);
        startActivity(i);
    }
    public  void mostrarListado1(View v){
        Intent i = new Intent(Principal.this, ListarCiudad.class);
        startActivity(i);
    }
}
