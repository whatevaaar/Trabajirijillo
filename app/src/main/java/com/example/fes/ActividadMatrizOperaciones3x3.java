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
            int celda1x1 = Integer.parseInt(inputCelda1x1.getText().toString()); //gets you the contents of edit text
            int celda1x2 = Integer.parseInt(inputCelda1x2.getText().toString()); //gets you the contents of edit text
            int celda1x3 = Integer.parseInt(inputCelda1x3.getText().toString()); //gets you the contents of edit text
            int celda2x1 = Integer.parseInt(inputCelda2x1.getText().toString()); //gets you the contents of edit text
            int celda2x2 = Integer.parseInt(inputCelda2x2.getText().toString()); //gets you the contents of edit text
            int celda2x3 = Integer.parseInt(inputCelda2x3.getText().toString()); //gets you the contents of edit text
            int celda3x1 = Integer.parseInt(inputCelda3x1.getText().toString()); //gets you the contents of edit text
            int celda3x2 = Integer.parseInt(inputCelda3x2.getText().toString()); //gets you the contents of edit text
            int celda3x3 = Integer.parseInt(inputCelda3x3.getText().toString()); //gets you the contents of edit text
            int determinante = calcularDeterminante(celda1x1, celda1x2, celda1x3,
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

    protected String calcularTraspuesta(int celda1x1, int celda1x2, int celda1x3, int celda2x1, int celda2x2,
                                        int celda2x3, int celda3x1, int celda3x2, int celda3x3) {
        return celda1x1 + "\t" + celda2x1 + "\t" + celda3x1 + "\n" +
                celda1x2 + "\t" + celda2x2 + "\t" + celda3x2 + "\n" +
                celda1x3 + "\t" + celda2x3 + "\t" + celda3x3;
    }

    protected int calcularTraza(int celda1x1, int celda2x2, int celda3x3) {
        return celda1x1 + celda2x2 + celda3x3;
    }

    protected String calcularInversa(int celda1x1, int celda1x2, int celda1x3,
                                     int celda2x1, int celda2x2, int celda2x3,
                                     int celda3x1, int celda3x2, int celda3x3, int determinante) {
int termino1x1 =  calcularCoofactor(celda2x2, celda2x3, celda3x2, celda3x3);
int termino1x2 = -1  * calcularCoofactor(celda1x2, celda1x3, celda2x2, celda2x3);
int termino1x3 =  calcularCoofactor(celda1x2, celda1x3, celda2x2, celda2x3);
int termino2x1 = -1  * calcularCoofactor(celda2x1, celda2x3, celda3x1, celda3x3);
int termino2x2 =  calcularCoofactor(celda1x1, celda1x3, celda3x1, celda3x3);
int termino2x3 = -1  * calcularCoofactor(celda1x1, celda1x3, celda2x1, celda2x3);
int termino3x1 =  calcularCoofactor(celda2x1, celda2x2, celda3x1, celda3x2);
int termino3x2 = -1  * calcularCoofactor(celda1x1, celda1x2, celda3x1, celda3x2);
int termino3x3 =  calcularCoofactor(celda1x1, celda1x2, celda2x1, celda2x2);
        return termino1x1 + "\t" + termino2x1 + "\t" + termino3x1 + "\n" +
                termino1x2 + "\t" + termino2x2 + "\t" + termino3x2 + "\n" +
                termino1x3 + "\t" + termino2x3 + "\t" + termino3x3;
    }

    protected int calcularCoofactor(int a0, int a1, int b0, int b1) {
        return a0 * b1 - b0 * a1;
    }

    protected int calcularDeterminante(int celda1x1, int celda1x2, int celda1x3, int celda2x1, int celda2x2,
                                       int celda2x3, int celda3x1, int celda3x2, int celda3x3) {
        int termino1 = celda1x1 * calcularCoofactor(celda2x2, celda2x3, celda3x2, celda3x3);
        int termino2 = celda1x2 * calcularCoofactor(celda2x1, celda2x3, celda3x1, celda3x3);
        int termino3 = celda1x3 * calcularCoofactor(celda2x1, celda2x2, celda3x1, celda3x2);
        return termino1 - termino2 + termino3;

    }

}