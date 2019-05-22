package com.example.fes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EcuActivity extends AppCompatActivity {
    private Button btIniciar;
    private Button btIniciar2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_definicionecu);

        TextView textoDefinicion = (TextView) findViewById(R.id.textViewEcuDesc);
        textoDefinicion.setText("En matemáticas y álgebra lineal, un sistema de ecuaciones lineales, también conocido como sistema lineal de ecuaciones o simplemente sistema lineal, es un conjunto de ecuaciones lineales (es decir, un sistema de ecuaciones en donde cada ecuación es de primer grado), definidas sobre un cuerpo o un anillo conmutativo." +
                "El problema consiste en encontrar los valores desconocidos de las variables que satisfacen las ecuaciones.\n" +
                "\n" +"El problema de los sistemas lineales de ecuaciones es uno de los más antiguos de la matemática y tiene una infinidad de aplicaciones, como en procesamiento digital de señales, análisis estructural, estimación, predicción y más generalmente en programación lineal así como en la aproximación de problemas no lineales de análisis numérico. ");

        btIniciar = (Button) findViewById(R.id.button2x2ec);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EcuActivity.this,Ecu2x2Activity.class);

                startActivity(intent);
            }
        });

        btIniciar2 = (Button) findViewById(R.id.button3x3ec);
        btIniciar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(EcuActivity.this,Ecu3x3Activity.class);

                startActivity(intent2);
            }
        });
    }
}
