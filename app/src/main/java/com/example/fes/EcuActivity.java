package com.example.fes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EcuActivity extends AppCompatActivity {
    private Button btIniciar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_definicionecu);

        btIniciar = (Button) findViewById(R.id.button2x2ec);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EcuActivity.this,Ecu2x2Activity.class);

                startActivity(intent);
            }
        });
    }
}
