package com.example.appopetroomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.appopetroomdb.model.Carro;

import java.util.List;

@Dao
public interface CarroDAO {

    @Query("SELECT * FROM carro")
    List<Carro> getAll();

    @Query("SELECT * FROM carro WHERE carro_ano = :ano")
    List<Carro> getCarroByAno(int ano);

    @Query("SELECT * FROM carro WHERE id = :id LIMIT 1")
    Carro getCarroById(long id);

    @Insert
    long insert(Carro carro);

    @Delete
    void delete(Carro carro);

    @Query("DELETE FROM carro WHERE id = :id")
    void deleteById(long id);

    @Update
    void update(Carro carro);
}
