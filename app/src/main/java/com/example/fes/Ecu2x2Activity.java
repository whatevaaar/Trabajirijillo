package com.example.fes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ecu2x2Activity extends AppCompatActivity {
    private Button btIniciar;
    EditText inputx1;
    EditText inputx2;
    EditText inputy1;
    EditText inputy2;
    EditText inputc1;
    EditText inputc2;

    TextView textResX;
    TextView textResY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ecu2x2);

        inputx1 = (EditText) findViewById(R.id.editTextX1);
        inputx2 = (EditText) findViewById(R.id.editTextX2);
        inputy1 = (EditText) findViewById(R.id.editTextY1);
        inputy2 = (EditText) findViewById(R.id.editTextY2);

        inputc1 = (EditText) findViewById(R.id.editTextC1);
        inputc2 = (EditText) findViewById(R.id.editTextC2);

        textResX = (TextView) findViewById(R.id.textViewResX);
        textResY = (TextView) findViewById(R.id.textViewResY);

        btIniciar = (Button) findViewById(R.id.buttonCalc2x2);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        try {
            double celdax1 = Double.parseDouble(inputx1.getText().toString()); //gets you the contents of edit text
            double celdax2 = Double.parseDouble(inputx2.getText().toString()); //gets you the contents of edit text
            double celday1 = Double.parseDouble(inputy1.getText().toString()); //gets you the contents of edit text
            double celday2 = Double.parseDouble(inputy2.getText().toString()); //gets you the contents of edit text
            double celdac1 = Double.parseDouble(inputc1.getText().toString()); //gets you the contents of edit text
            double celdac2 = Double.parseDouble(inputc2.getText().toString()); //gets you the contents of edit text
            textResX.setText("X= " + calcula_determinante(celdax1,celday1,celdac1,celdax2,celday2,celdac2,1));
            textResY.setText("Y= " + calcula_determinante(celdax1,celday1,celdac1,celdax2,celday2,celdac2,2));

        }catch (Exception e){
            return;
        }
    }

    protected  String calcula_determinante(double a,double b, double c, double d, double e, double f, double var){
        double det,x,y,m;

        det=a*e - b*d;

        if (det!=0){
            x = (e * c - b * f) / det;
            y = (a * f - d * c) / det;

            if(var==1){
                return String.valueOf(x);

            }else if(var==2){
                return String.valueOf(y);
            }
        }else{
            m = d / a;
            if (m*c==f){
                return "El sistema tiene infinitas soluciones";


            }else{
                return "El sistema no tiene solucion";
            }

        }
        return "error";
    }


}
