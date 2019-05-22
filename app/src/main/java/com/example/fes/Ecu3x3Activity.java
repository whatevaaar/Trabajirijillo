package com.example.fes;
/*
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            int celdax1 = Integer.parseInt(inputx1.getText().toString()); //gets you the contents of edit text
            int celdax2 = Integer.parseInt(inputx2.getText().toString()); //gets you the contents of edit text
            int celday1 = Integer.parseInt(inputy1.getText().toString()); //gets you the contents of edit text
            int celday2 = Integer.parseInt(inputy2.getText().toString()); //gets you the contents of edit text
            int celdac1 = Integer.parseInt(inputc1.getText().toString()); //gets you the contents of edit text
            int celdac2 = Integer.parseInt(inputc2.getText().toString()); //gets you the contents of edit text

            textResX.setText("X= " + calcula_determinante(celdax1,celday1,celdac1,celdax2,celday2,celdac2,1));
            textResY.setText("Y= " + calcula_determinante(celdax1,celday1,celdac1,celdax2,celday2,celdac2,2));

        }catch (Exception e){
            return;
        }
    }
    protected int calcularXY(int celdax1, int celdax2, int celday1, int celday2,int celdac1, int celdac2, int var){
        return celdax1 + celdax2;
    }

    protected  String calcula_determinante(int a,int b, int c, int d, int e, int f, int var){
        int det,x,y,m;

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
                return "El sistema no infinitas soluciones";
            }

        }
        return "error";
    }


}
*/