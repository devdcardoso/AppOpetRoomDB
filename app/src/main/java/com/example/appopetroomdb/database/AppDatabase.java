package com.example.appopetroomdb.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appopetroomdb.dao.CarroDAO;
import com.example.appopetroomdb.model.Carro;

@Database(entities = {Carro.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CarroDAO carroDAO();
    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,AppDatabase.class,"carro_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
