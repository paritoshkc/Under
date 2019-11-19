package ie.tcd.cs7cs3.storage;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import androidx.room.Room;
import ie.tcd.cs7cs3.storage.AppDatabase;
import ie.tcd.cs7cs3.storage.User;
import ie.tcd.cs7cs3.storage.UserDAO;
import ie.tcd.cs7cs3.storage.UserRating;
import ie.tcd.cs7cs3.storage.UserRatingDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UserRatingDAOTest {
  private final User[] testUsers = new User[]{
    new User("joe", 23, "male", "123 Main Street"),
    new User("jane", 34, "female", "234 Old Street"),
  };

  private UserRatingDAO userRatingDAO;
  private UserDAO userDAO;
  private AppDatabase db;

  @Before
  public void setUp() throws Exception {
    final Context ctx = getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase.class).allowMainThreadQueries().build();
    userRatingDAO = db.getUserRatingDao();
    userDAO = db.getUserDao();
    userDAO.insert(testUsers);
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
  public void testAddNewUserRating() {
    final User rater = userDAO.findByUUID(testUsers[0].getUuid());
    final User ratee = userDAO.findByUUID(testUsers[1].getUuid());
    userRatingDAO.insert(new UserRating(rater.getUuid(), ratee.getUuid(), 5));
    Assert.assertEquals(1, userRatingDAO.forUuid(ratee.getUuid()).size());
  }
}
