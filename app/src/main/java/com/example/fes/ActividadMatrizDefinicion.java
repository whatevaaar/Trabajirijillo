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
        botonCalcular3x3.setText("Calcular 2x2");
        TextView textoTitulo = (TextView) findViewById(R.id.textoTitulo);
        botonCalcular3x3.setText("Matrices");
        TextView textoDefinicion = (TextView) findViewById(R.id.textoDefinicion);
        botonCalcular3x3.setText("Matrices");


        botonCalcular2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassingDataSourceActivity.this, PassingDataTargetActivity.class);
                intent.putExtra("message", "This message comes from PassingDataSourceActivity's first button");
                startActivity(intent);
            }
        });

    }
}
