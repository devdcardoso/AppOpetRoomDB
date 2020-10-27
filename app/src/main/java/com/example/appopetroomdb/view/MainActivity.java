package com.example.appopetroomdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appopetroomdb.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void abrirTelaInsereCarro(View view) {
        Intent intent = new Intent(MainActivity.this,InsereCarroActivity.class);
        startActivity(intent);
    }

    public void abrirTelaConsultaCarro(View view) {
        Intent intent = new Intent(MainActivity.this,ConsultaCarroActivity.class);
        startActivity(intent);
    }
}