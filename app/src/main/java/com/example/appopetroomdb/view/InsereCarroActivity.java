package com.example.appopetroomdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.appopetroomdb.R;
import com.example.appopetroomdb.controller.CarroController;
import com.example.appopetroomdb.model.Carro;

public class InsereCarroActivity extends AppCompatActivity {

    private CarroController controller;

    private EditText editMarca, editModelo, editAno, editPlaca;

    private LinearLayout layoutInserir, layoutAtualizar;

    private Carro c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_carro);

        controller = new CarroController(this);

        editMarca = findViewById(R.id.editMarca);
        editModelo = findViewById(R.id.editModelo);
        editAno = findViewById(R.id.editAno);
        editPlaca = findViewById(R.id.editPlaca);

        layoutInserir = findViewById(R.id.layoutInserir);
        layoutAtualizar = findViewById(R.id.layoutAtualizar);

        long id = getIntent().getLongExtra("ID",0);

        if(id != 0) {
            layoutInserir.setVisibility(View.GONE);
            preencherDados(id);
        }else{
            layoutAtualizar.setVisibility(View.GONE);
        }
    }

    private void preencherDados(long id) {
        c1 = controller.findById(id);
        editMarca.setText(c1.getMarca());
        editModelo.setText(c1.getModelo());
        editPlaca.setText(c1.getPlaca());
        editAno.setText(String.valueOf(c1.getAno()));
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

    public void atualizarCarroDB(View view) {
        c1.setModelo(editModelo.getText().toString());
        c1.setMarca(editMarca.getText().toString());
        c1.setPlaca(editPlaca.getText().toString());
        c1.setAno(Integer.parseInt(editAno.getText().toString()));

        controller.atualizar(c1);

        novatela();
    }

    private void novatela() {
        Intent intent = new Intent(InsereCarroActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void removerCarroDB(View view) {
        controller.remover(c1);
        novatela();
    }
}