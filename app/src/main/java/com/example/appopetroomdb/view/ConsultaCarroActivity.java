package com.example.appopetroomdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.appopetroomdb.R;
import com.example.appopetroomdb.adapter.CarroAdapter;
import com.example.appopetroomdb.controller.CarroController;

public class ConsultaCarroActivity extends AppCompatActivity {

    private ListView lvCarros;
    private CarroAdapter adapter;
    private CarroController controller;
    private EditText editAnoConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_carro);

        lvCarros = findViewById(R.id.listCarros);
        controller = new CarroController(this);
        adapter = new CarroAdapter(this,R.layout.carro_item,controller.findAll());
        editAnoConsulta = findViewById(R.id.editAnoConsulta);

        lvCarros.setAdapter(adapter);
    }

    public void consultarPeloAno(View view) {
        adapter.clear();
        int ano = Integer.parseInt(editAnoConsulta.getText().toString());
        adapter.addAll(controller.findByAno(ano));

        adapter.notifyDataSetChanged();
    }
}