package com.example.appopetroomdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appopetroomdb.R;
import com.example.appopetroomdb.controller.CarroController;
import com.example.appopetroomdb.model.Carro;

public class InsereCarroActivity extends AppCompatActivity {

    private CarroController controller;

    private EditText editMarca, editModelo, editAno, editPlaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_carro);

        controller = new CarroController(this);

        editMarca = findViewById(R.id.editMarca);
        editModelo = findViewById(R.id.editModelo);
        editAno = findViewById(R.id.editAno);
        editPlaca = findViewById(R.id.editPlaca);
    }

    public void salvarCarroDB(View view) {
        Carro carro = new Carro();
        carro.setMarca(editMarca.getText().toString());
        carro.setModelo(editModelo.getText().toString());
        carro.setPlaca(editPlaca.getText().toString());
        carro.setAno(Integer.parseInt(editAno.getText().toString()));

        if(controller.inserir(carro) > 0){
            mensagem("Carro inserido com sucesso!");
            clearFields();
        }else{
            mensagem("Não foi possível inserir o carro.");
        }

    }

    private void mensagem(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        editPlaca.setText("");
        editMarca.setText("");
        editModelo.setText("");
        editAno.setText("");
    }
}