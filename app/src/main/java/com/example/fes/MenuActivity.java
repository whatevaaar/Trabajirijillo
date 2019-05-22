package com.example.fes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button btIniciar;
    private Button botonMatrices;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        btIniciar = (Button) findViewById(R.id.buttonEcLineales);
        botonMatrices = (Button) findViewById(R.id.buttonMatrices);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,EcuActivity.class);

                startActivity(intent);
            }
        });

         botonMatrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,ActividadMatrizDefinicion.class);

                startActivity(intent);
            }
        });
    }
}
