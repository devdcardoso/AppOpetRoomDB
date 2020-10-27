package com.example.appopetroomdb;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.appopetroomdb.dao.CarroDAO;
import com.example.appopetroomdb.database.AppDatabase;
import com.example.appopetroomdb.model.Carro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private CarroDAO carroDAO;
    private AppDatabase db;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.appopetroomdb", appContext.getPackageName());
    }

    @Before
    public void createDB(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        carroDAO = db.carroDAO();
    }

    @After
    public void closeDB() throws IOException{
        db.close();
    }

    @Test
    public void createCarro() throws Exception{
        Carro c1 = new Carro("Ford","Focus",2008,"AAA-0000");
        carroDAO.insert(c1);
        Carro c2 = carroDAO.getCarroById(1);
        assertEquals("Ford",c2.getMarca());
    }

    @Test
    public void createCarros() throws Exception{
        Carro c1 = new Carro("Ford","Focus",2008,"AAA-0000");
        Carro c2 = new Carro("Ford","Focus",2007,"AAA-0000");
        Carro c3 = new Carro("Ford","Focus",2006,"AAA-0000");
        carroDAO.insert(c1);
        carroDAO.insert(c2);
        carroDAO.insert(c3);

        List<Carro> carroList = carroDAO.getAll();

        assertEquals(3,carroList.size());
    }

    @Test
    public void listCarros() throws Exception{
        Carro c1 = new Carro("Ford","Focus",2008,"AAA-0000");
        Carro c2 = new Carro("Ford","Focus",2007,"AAA-0000");
        Carro c3 = new Carro("Ford","Focus",2006,"AAA-0000");
        carroDAO.insert(c1);
        carroDAO.insert(c2);
        carroDAO.insert(c3);

        List<Carro> carroList = carroDAO.getCarroByAno(2007);

        assertEquals(2,carroList.size());
    }

    @Test
    public void updateCarro() throws Exception{
        Carro c1 = new Carro("Ford","Focus",2008,"AAA-0000");
        carroDAO.insert(c1);
        Carro c2 = carroDAO.getCarroById(1);
        c2.setAno(2015);
        carroDAO.update(c2);
        Carro c3 = carroDAO.getCarroById(1);
        assertEquals(2015,c3.getAno());
    }

    @Test
    public void deleteCarro() throws Exception{
        Carro c1 = new Carro("Ford","Focus",2008,"AAA-0000");
        carroDAO.insert(c1);
        Carro c2 = carroDAO.getCarroById(1);
        carroDAO.delete(c2);
        List<Carro> carroList = carroDAO.getAll();
        assertEquals(0,carroList.size());
    }
}