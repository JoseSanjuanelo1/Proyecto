package com.example.josesanjuanelo.proyectomovil;

import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Popayan extends AppCompatActivity {
    private RadioButton r1, r2, r3, r4, r5;
    private Double puntos;
    private String sql1;
    private TextView resp;
    private ArrayList<Puntuacion> k = new ArrayList();
    SQLiteDatabase db;
    Double total;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popayan);

        buscar();

        res = this.getResources();
        resp = (TextView)findViewById(R.id.lblPuntuacionPopayan);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
        r4 = (RadioButton)findViewById(R.id.r4);
        r5 = (RadioButton)findViewById(R.id.r5);




    }


    public void buscar (){;
        String nombre="PY";
        Puntuacion p;
        p = DatosPuntacion.buscar(getApplicationContext(), nombre);
        if(p!=null) {
            puntos = p.getPuntuacion();
            total = p.getTotal();
        }
    }

    public void puntuar(View v){
        String resultado;
        double form;

        if(r1.isChecked()) puntos = puntos+1;
        if(r2.isChecked()) puntos = puntos+2;
        if(r3.isChecked()) puntos = puntos+3;
        if(r4.isChecked()) puntos = puntos+4;
        if(r5.isChecked()) puntos = puntos+5;

        total = total+1;

        Puntuacion n = new Puntuacion ("PY", puntos, total);
        n.modificar(getApplicationContext());
        form = (puntos/total);
        resultado = res.getString(R.string.calificacionActual)+" : "+form;
        resp.setText(resultado);
        r3.setFocusable(true);
    }
}
