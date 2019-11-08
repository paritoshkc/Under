package ie.tcd.cs7cs3.under.Storage;

import android.content.Context;

import androidx.room.Room;

import org.junit.After;
import org.junit.Before;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

public class UserDaoTest {
    private UserDao userDao;
    private AppDatabase db;

    @Before
    public void setUp() throws Exception {
        Context context = getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.getUserDao();
    }

    @After
    public void tearDown() throws Exception {
        db.close();
    }
}