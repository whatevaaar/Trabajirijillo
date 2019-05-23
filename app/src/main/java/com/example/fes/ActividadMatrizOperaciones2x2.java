package com.example.fes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadMatrizOperaciones2x2 extends AppCompatActivity {

    EditText inputCelda1x1;
    EditText inputCelda1x2;
    EditText inputCelda2x1;
    EditText inputCelda2x2;

    TextView textMatrizTraspuesta;
    TextView textTraza;
    TextView textMatrizInversa;
    TextView textDeterminante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_matriz_operaciones2x2);
        Button botonCalcular = (Button) findViewById(R.id.botonCalcular2x2);
         inputCelda1x1 = (EditText) findViewById(R.id.celda1x1);
         inputCelda1x2 = (EditText) findViewById(R.id.celda1x2);
         inputCelda2x1 = (EditText) findViewById(R.id.celda2x1);
         inputCelda2x2 = (EditText) findViewById(R.id.celda2x2);

         textMatrizTraspuesta = (TextView) findViewById(R.id.matrizTraspuesta);
         textTraza= (TextView) findViewById(R.id.traza);
         textMatrizInversa= (TextView) findViewById(R.id.matrizInversa);
         textDeterminante= (TextView) findViewById(R.id.determinante);
        botonCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarOperaciones();
            }
        });

    }

    protected void realizarOperaciones(){

        try {
            double celda1x1 = Double.parseDouble(inputCelda1x1.getText().toString()); //gets you the contents of edit text
            double celda1x2 = Double.parseDouble(inputCelda1x2.getText().toString()); //gets you the contents of edit text
            double celda2x1 = Double.parseDouble(inputCelda2x1.getText().toString()); //gets you the contents of edit text
            double celda2x2 = Double.parseDouble(inputCelda2x2.getText().toString()); //gets you the contents of edit text
            double determinante = calcularDeterminante(celda1x1,celda2x2, celda1x2, celda2x1);
            textTraza.setText("Traza: " + calcularTraza(celda1x1,celda2x2));
            textMatrizInversa.setText(calcularInversa(celda1x1, celda1x2, celda2x1,celda2x2, determinante));
            textMatrizTraspuesta.setText(calcularTraspuesta(celda1x1,celda1x2, celda2x1, celda2x2));
            textDeterminante.setText("Determinante: " + determinante);
        }catch (Exception e){
            return;
        }
    }

    protected String calcularTraspuesta(double celda1x1, double celda1x2, double celda2x1, double celda2x2){
        return celda1x1 + "\t\t" + celda2x1 + "\n" + celda1x2 + "\t\t" + celda2x2;
    }

    protected double calcularTraza(double celda1x1, double celda2x2){
        return celda1x1 + celda2x2;
    }

    protected String calcularInversa(double celda1x1, double celda1x2, double celda2x1, double celda2x2, double determinante){
       double multiplicador = 1/ determinante;
       return (celda2x2 * multiplicador) + "\t\t" + (celda1x2 * -1 * multiplicador) + "\n" + (celda2x1 * -1 * multiplicador) + "\t\t" + (celda1x1 * multiplicador);
    }

    protected double calcularDeterminante(double celda1x1, double celda2x2, double celda2x1, double celda1x2) {
        return celda1x1 * celda2x2 - celda1x2 * celda2x1;
    }
}
