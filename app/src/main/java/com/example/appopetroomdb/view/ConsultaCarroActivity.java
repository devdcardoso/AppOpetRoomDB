package com.example.appopetroomdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appopetroomdb.R;
import com.example.appopetroomdb.adapter.CarroAdapter;
import com.example.appopetroomdb.controller.CarroController;
import com.example.appopetroomdb.model.Carro;

public class ConsultaCarroActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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

        lvCarros.setOnItemClickListener(this);
    }

    public void consultarPeloAno(View view) {
        adapter.clear();
        int ano = Integer.parseInt(editAnoConsulta.getText().toString());
        adapter.addAll(controller.findByAno(ano));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Carro carro = (Carro)adapterView.getItemAtPosition(i);
        //Toast.makeText(this, String.valueOf(carro.getId()), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ConsultaCarroActivity.this,InsereCarroActivity.class);
        intent.putExtra("ID",carro.getId());
        startActivity(intent);
    }
}