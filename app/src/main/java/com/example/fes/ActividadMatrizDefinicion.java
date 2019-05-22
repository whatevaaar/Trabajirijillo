package com.example.fes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActividadMatrizDefinicion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_matriz_definicion);

        Button botonCalcular2x2 = (Button) findViewById(R.id.botonCalcular2x2);
        botonCalcular2x2.setText("Calcular 2x2");
        Button botonCalcular3x3 = (Button) findViewById(R.id.botonCalcular3x3);
        botonCalcular3x3.setText("Calcular 3x3");
        TextView textoTitulo = (TextView) findViewById(R.id.celda2x2);
        textoTitulo.setText("Matrices");
        TextView textoDefinicion = (TextView) findViewById(R.id.textoDefinicion);
        textoDefinicion.setText("En matemática, una matriz es un arreglo bidimensional de números. Dado que puede definirse tanto la suma como el producto de matrices, en mayor generalidad se dice que son elementos de un anillo. Una matriz se representa por medio de una letra mayúscula (A,B, …) y sus elementos con la misma letra en minúscula (a,b, …), con un doble subíndice donde el primero indica la fila y el segundo la columna a la que pertenece. ");


        botonCalcular2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadMatrizDefinicion.this, ActividadMatrizOperaciones2x2.class);
                startActivity(intent);
            }
        });

        botonCalcular3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadMatrizDefinicion.this, ActividadMatrizOperaciones3x3.class);
                startActivity(intent);
            }
        });
    }
}
