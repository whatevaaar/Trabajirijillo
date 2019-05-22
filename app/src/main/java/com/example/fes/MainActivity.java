package com.example.fes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIniciar = (Button) findViewById(R.id.buttonIniciar);
        TextView textoDefinicion = (TextView) findViewById(R.id.textViewNombres);
        textoDefinicion.setText("\tIntegrantes:\n\nGarnica Arriaga Joel Giovanni\nChristian Castro Hernández\nÓscar Mauricio Cortez López\nAlan Alejandro Pérez Gutiérrez " +
                                "\nPérez Vázquez Arturo\nMorales Pérez Leonardo\nWilliam Brando Estrada Tepec,");
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
