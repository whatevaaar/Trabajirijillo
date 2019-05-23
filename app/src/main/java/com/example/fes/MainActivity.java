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
        textoDefinicion.setText("\tIntegrantes:\n\nEstrada Tepec William Brando\nGarnica Arriaga Joel Giovanni\nCastro Hernández Christian\nCortez López Óscar Mauricio\nPérez Gutiérrez Alan Alejandro" +
                                "\nPérez Vázquez Arturo\nMorales Pérez Leonardo\nLopez Chaparro Sebastian.");
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
