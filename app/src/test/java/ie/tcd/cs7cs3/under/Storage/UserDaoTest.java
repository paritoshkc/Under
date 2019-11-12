package ie.tcd.cs7cs3.under.Storage;

import android.content.Context;

import androidx.room.Room;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
  private UserDAO userDao;
  private AppDatabase db;

  @Before
  public void setUp() throws Exception {
    Context context = getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
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
    final User u = new User(1, "Joe", 23, "male", "123 Main Street");
    userDao.insert(u);
    final List<User> users = userDao.findByName("Joe");
    assertThat(users.get(0), equalTo(u));
  }
}
