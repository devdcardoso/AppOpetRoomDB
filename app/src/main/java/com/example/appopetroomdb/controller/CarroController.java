package com.example.appopetroomdb.controller;

import android.content.Context;

import com.example.appopetroomdb.dao.CarroDAO;
import com.example.appopetroomdb.database.AppDatabase;
import com.example.appopetroomdb.model.Carro;

import java.util.List;

public class CarroController {
    private AppDatabase db;
    private CarroDAO dao;

    public CarroController(Context context){
        db = AppDatabase.getInstance(context);
        dao = db.carroDAO();
    }

    public long inserir(Carro carro){
        return dao.insert(carro);
    }

    public List<Carro> findAll(){
        return dao.getAll();
    }

    public List<Carro> findByAno(int ano){
        return dao.getCarroByAno(ano);
    }
}
