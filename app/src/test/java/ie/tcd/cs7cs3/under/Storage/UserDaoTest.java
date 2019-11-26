package ie.tcd.cs7cs3.under.Storage;

import android.content.Context;

import androidx.room.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UserDaoTest {
  private final String sampleUUID = "123-qwerty-456";
  private UserDAO userDao;
  private AppDatabase db;

  @Before
  public void setUp() throws Exception {
    Context context = getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
    userDao = db.getUserDao();
  }

  @After
  public void tearDown() {
    try {
      db.close();
    } catch (final Exception e) {
      System.out.println("tearDown: closing db: " + e.getMessage());
    }
  }

  @Test
  public void testCreateAndReadUser() {
    final User u = new User(sampleUUID,"Joe", 23, "male", "123 Main Street");
    userDao.insert(u);
    final User v = userDao.findByUUID("123-qwerty-456");
    assertThat(v, equalTo(u));
  }

  @Test(expected=android.database.sqlite.SQLiteConstraintException.class)
  public void testUniqueUUIDs() {
    final User u1 = new User(sampleUUID,"Joe", 23, "male", "123 Main Street");
    final User u2 = new User(sampleUUID,"Jane", 23, "female", "123 Main Street");
    userDao.insert(u1);
    userDao.insert(u2); // boom
  }
}
