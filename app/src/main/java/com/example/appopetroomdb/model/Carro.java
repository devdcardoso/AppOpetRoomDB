package com.example.appopetroomdb.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Carro {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "carro_marca")
    private String marca;
    @ColumnInfo(name = "carro_modelo")
    private String modelo;
    @ColumnInfo(name = "carro_ano")
    private int ano;
    @ColumnInfo(name = "carro_placa")
    private String placa;

    public Carro(){}

    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
