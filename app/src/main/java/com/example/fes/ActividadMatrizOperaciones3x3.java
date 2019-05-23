package com.example.fes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadMatrizOperaciones3x3 extends AppCompatActivity {

    EditText inputCelda1x1;
    EditText inputCelda1x2;
    EditText inputCelda1x3;
    EditText inputCelda2x1;
    EditText inputCelda2x2;
    EditText inputCelda2x3;
    EditText inputCelda3x1;
    EditText inputCelda3x2;
    EditText inputCelda3x3;
    TextView textMatrizTraspuesta;
    TextView textTraza;
    TextView textMatrizInversa;
    TextView textDeterminante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_matriz_operaciones);
        Button botonCalcular = (Button) findViewById(R.id.botonCalcular3x3);
        inputCelda1x1 = (EditText) findViewById(R.id.celda1x1);
        inputCelda1x2 = (EditText) findViewById(R.id.celda1x2);
        inputCelda1x3 = (EditText) findViewById(R.id.celda1x3);
        inputCelda2x1 = (EditText) findViewById(R.id.celda2x1);
        inputCelda2x2 = (EditText) findViewById(R.id.celda2x2);
        inputCelda2x3 = (EditText) findViewById(R.id.celda2x3);
        inputCelda3x1 = (EditText) findViewById(R.id.celda3x1);
        inputCelda3x2 = (EditText) findViewById(R.id.celda3x2);
        inputCelda3x3 = (EditText) findViewById(R.id.celda3x3);
        textMatrizTraspuesta = (TextView) findViewById(R.id.matrizTraspuesta);
        textTraza = (TextView) findViewById(R.id.traza);
        textMatrizInversa = (TextView) findViewById(R.id.matrizInversa);
        textDeterminante = (TextView) findViewById(R.id.determinante);
        botonCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarOperaciones();
            }
        });

    }

    protected void realizarOperaciones() {

        try {
            double celda1x1 = Double.parseDouble(inputCelda1x1.getText().toString()); //gets you the contents of edit text
            double celda1x2 = Double.parseDouble(inputCelda1x2.getText().toString()); //gets you the contents of edit text
            double celda1x3 = Double.parseDouble(inputCelda1x3.getText().toString()); //gets you the contents of edit text
            double celda2x1 = Double.parseDouble(inputCelda2x1.getText().toString()); //gets you the contents of edit text
            double celda2x2 = Double.parseDouble(inputCelda2x2.getText().toString()); //gets you the contents of edit text
            double celda2x3 = Double.parseDouble(inputCelda2x3.getText().toString()); //gets you the contents of edit text
            double celda3x1 = Double.parseDouble(inputCelda3x1.getText().toString()); //gets you the contents of edit text
            double celda3x2 = Double.parseDouble(inputCelda3x2.getText().toString()); //gets you the contents of edit text
            double celda3x3 = Double.parseDouble(inputCelda3x3.getText().toString()); //gets you the contents of edit text
            double determinante = calcularDeterminante(celda1x1, celda1x2, celda1x3,
                    celda2x1, celda2x2, celda2x3,
                    celda3x1, celda3x2, celda3x3);
            textTraza.setText("Traza: " + calcularTraza(celda1x1, celda2x2, celda3x3));
            textMatrizInversa.setText(calcularInversa(celda1x1, celda1x2, celda1x3,
                    celda2x1, celda2x2, celda2x3,
                    celda3x1, celda3x2, celda3x3, determinante));
            textMatrizTraspuesta.setText(calcularTraspuesta(celda1x1, celda1x2, celda1x3,
                    celda2x1, celda2x2, celda2x3,
                    celda3x1, celda3x2, celda3x3));
            textDeterminante.setText("Determinante: " + determinante);
        } catch (Exception e) {
            return;
        }
    }

    protected String calcularTraspuesta(double celda1x1, double celda1x2, double celda1x3, double celda2x1, double celda2x2,
                                        double celda2x3, double celda3x1, double celda3x2, double celda3x3) {
        return celda1x1 + "\t\t" + celda2x1 + "\t\t" + celda3x1 + "\n" +
                celda1x2 + "\t\t" + celda2x2 + "\t\t" + celda3x2 + "\n" +
                celda1x3 + "\t\t" + celda2x3 + "\t\t" + celda3x3;
    }

    protected double calcularTraza(double celda1x1, double celda2x2, double celda3x3) {
        return celda1x1 + celda2x2 + celda3x3;
    }

    protected String calcularInversa(double celda1x1, double celda1x2, double celda1x3,
                                     double celda2x1, double celda2x2, double celda2x3,
                                     double celda3x1, double celda3x2, double celda3x3, double determinante) {
double termino1x1 =  calcularCoofactor(celda2x2, celda2x3, celda3x2, celda3x3);
double termino1x2 = -1  * calcularCoofactor(celda1x2, celda1x3, celda2x2, celda2x3);
double termino1x3 =  calcularCoofactor(celda1x2, celda1x3, celda2x2, celda2x3);
double termino2x1 = -1  * calcularCoofactor(celda2x1, celda2x3, celda3x1, celda3x3);
double termino2x2 =  calcularCoofactor(celda1x1, celda1x3, celda3x1, celda3x3);
double termino2x3 = -1  * calcularCoofactor(celda1x1, celda1x3, celda2x1, celda2x3);
double termino3x1 =  calcularCoofactor(celda2x1, celda2x2, celda3x1, celda3x2);
double termino3x2 = -1  * calcularCoofactor(celda1x1, celda1x2, celda3x1, celda3x2);
double termino3x3 =  calcularCoofactor(celda1x1, celda1x2, celda2x1, celda2x2);
        return termino1x1 + "\t\t" + termino2x1 + "\t\t" + termino3x1 + "\n" +
                termino1x2 + "\t\t" + termino2x2 + "\t\t" + termino3x2 + "\n" +
                termino1x3 + "\t\t" + termino2x3 + "\t\t" + termino3x3;
    }

    protected double calcularCoofactor(double a0, double a1, double b0, double b1) {
        return a0 * b1 - b0 * a1;
    }

    protected double calcularDeterminante(double celda1x1, double celda1x2, double celda1x3, double celda2x1, double celda2x2,
                                       double celda2x3, double celda3x1, double celda3x2, double celda3x3) {
        double termino1 = celda1x1 * calcularCoofactor(celda2x2, celda2x3, celda3x2, celda3x3);
        double termino2 = celda1x2 * calcularCoofactor(celda2x1, celda2x3, celda3x1, celda3x3);
        double termino3 = celda1x3 * calcularCoofactor(celda2x1, celda2x2, celda3x1, celda3x2);
        return termino1 - termino2 + termino3;

    }

}