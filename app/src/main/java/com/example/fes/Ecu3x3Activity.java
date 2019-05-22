package com.example.fes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ecu3x3Activity extends AppCompatActivity {
    private Button btCalc;
    EditText inputx1;
    EditText inputx2;
    EditText inputx3;
    EditText inputy1;
    EditText inputy2;
    EditText inputy3;

    EditText inputz1;
    EditText inputz2;
    EditText inputz3;

    EditText inputc1;
    EditText inputc2;
    EditText inputc3;
    TextView textResX;
    TextView textResY;
    TextView textResZ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ecu3x3);

        inputx1 = (EditText) findViewById(R.id.etx1);
        inputx2 = (EditText) findViewById(R.id.etx2);
        inputx3 = (EditText) findViewById(R.id.etx3);

        inputy1 = (EditText) findViewById(R.id.ety1);
        inputy2 = (EditText) findViewById(R.id.ety2);
        inputy3 = (EditText) findViewById(R.id.ety3);

        inputz1 = (EditText) findViewById(R.id.etz1);
        inputz2 = (EditText) findViewById(R.id.etz2);
        inputz3 = (EditText) findViewById(R.id.etz3);

        inputc1 = (EditText) findViewById(R.id.etc1);
        inputc2 = (EditText) findViewById(R.id.etc2);
        inputc3 = (EditText) findViewById(R.id.etc3);

        textResX = (TextView) findViewById(R.id.textViewResX3);
        textResY = (TextView) findViewById(R.id.textViewResY3);
        textResZ = (TextView) findViewById(R.id.textViewResZ3);

        btCalc = (Button) findViewById(R.id.button3x3Calc);
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcula();
                //Toast.makeText(getApplicationContext(),"Que pedo",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void calcula() {

        try {
            double celdax1 = Double.parseDouble(inputx1.getText().toString()); //gets you the contents of edit text
            double celdax2 = Double.parseDouble(inputx2.getText().toString()); //gets you the contents of edit text
            double celdax3 = Double.parseDouble(inputx3.getText().toString()); //gets you the contents of edit text

            double celday1 = Double.parseDouble(inputy1.getText().toString()); //gets you the contents of edit text
            double celday2 = Double.parseDouble(inputy2.getText().toString()); //gets you the contents of edit text
            double celday3 = Double.parseDouble(inputy3.getText().toString()); //gets you the contents of edit text

            double celdac1 = Double.parseDouble(inputc1.getText().toString()); //gets you the contents of edit text
            double celdac2 = Double.parseDouble(inputc2.getText().toString()); //gets you the contents of edit text
            double celdac3 = Double.parseDouble(inputc3.getText().toString()); //gets you the contents of edit text

            double celdaz1 = Double.parseDouble(inputz1.getText().toString()); //gets you the contents of edit text
            double celdaz2 = Double.parseDouble(inputz2.getText().toString()); //gets you the contents of edit text
            double celdaz3 = Double.parseDouble(inputz3.getText().toString()); //gets you the contents of edit text

            //determinante solucion = new determinante();
            double RD = calcula_determinante(celdax1,celday1,celdaz1,celdax2,celday2,celdaz2,celdax3,celday3,celdaz3);
            double RDx = calcula_determinante(celdac1,celday1,celdaz1,celdac2,celday2,celdaz2,celdac3,celday3,celdaz3);
            double RDy = calcula_determinante(celdax1,celdac1,celdaz1,celdax2,celdac2,celdaz2,celdax3,celdac3,celdaz3);
            double RDz = calcula_determinante(celdax1,celday1,celdac1,celdax2,celday2,celdac2,celdax3,celday3,celdac3);
            //Toast.makeText(getApplicationContext(),"Que pedo2",Toast.LENGTH_LONG).show();


            double resX = RDx/RD;
            double resY = RDy/RD;
            double resZ = RDz/RD;
            if(RD==0){
                Toast.makeText(getApplicationContext(),"El sistema NO tiene solución",Toast.LENGTH_LONG).show();
            }else{
                textResX.setText("X= "+ (resX));
                textResY.setText("Y= "+ (resY));
                textResZ.setText("Z= "+ (resZ));
            }

        }catch (Exception e){
            return;
        }
    }
    protected double calcula_determinante(double A1, double B1, double C1, double A2, double B2, double C2,double A3, double B3, double C3){
        double resultado;
        resultado=(A1*B2*C3+B1*C2*A3+A2*B3*C1)-(C1*B2*A3 + B1*A2*C3 + C2*B3*A1);
        return resultado;
    }


}