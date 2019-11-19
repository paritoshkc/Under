package ie.tcd.cs7cs3.storage;

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
public class UserEntityDaoTest {
  private final String sampleUUID = "123-qwerty-456";
  private UserEntityDAO userEntityDao;
  private AppDatabase db;

  @Before
  public void setUp() throws Exception {
    Context context = getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
    userEntityDao = db.getUserDao();
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
    final UserEntity u = new UserEntity(sampleUUID,"Joe", 23, "male", "123 Main Street");
    userEntityDao.insert(u);
    final UserEntity v = userEntityDao.findByUUID("123-qwerty-456");
    assertThat(v, equalTo(u));
  }

  @Test(expected=android.database.sqlite.SQLiteConstraintException.class)
  public void testUniqueUUIDs() {
    final UserEntity u1 = new UserEntity(sampleUUID,"Joe", 23, "male", "123 Main Street");
    final UserEntity u2 = new UserEntity(sampleUUID,"Jane", 23, "female", "123 Main Street");
    userEntityDao.insert(u1);
    userEntityDao.insert(u2); // boom
  }
}
