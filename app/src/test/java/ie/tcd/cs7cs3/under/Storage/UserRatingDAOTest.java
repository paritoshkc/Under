package ie.tcd.cs7cs3.under.Storage;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import android.database.Cursor;
import androidx.room.Room;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.Currency;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import ie.tcd.cs7cs3.under.storage.AppDatabase;
import ie.tcd.cs7cs3.under.storage.UserEntity;
import ie.tcd.cs7cs3.under.storage.UserEntityDAO;
import ie.tcd.cs7cs3.under.storage.UserRatingEntity;
import ie.tcd.cs7cs3.under.storage.UserRatingEntityDAO;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UserRatingDAOTest {
  private final String sampleUUID = "deadbeef";
  private final UserEntity[] testUsers = new UserEntity[]{
    new UserEntity(sampleUUID, true, "joe", 23, "male", "123 Main Street", 1.0, 1.0),
    new UserEntity(sampleUUID, false, "jane", 34, "female", "234 Old Street", 1.0, 2.0),
  };

  private UserRatingEntityDAO userRatingDAO;
  private UserEntityDAO userDAO;
  private AppDatabase db;

  @Before
  public void setUp() throws Exception {
    final Context ctx = getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase.class).allowMainThreadQueries().build();
    userRatingDAO = db.getUserRatingEntityDao();
    userDAO = db.getUserEntityDao();
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
    final UserEntity rater = userDAO.findByUUID(testUsers[0].getUuid());
    final UserEntity ratee = userDAO.findByUUID(testUsers[1].getUuid());
    userRatingDAO.insert(new UserRatingEntity(rater.getUuid(), ratee.getUuid(), 5));
    Assert.assertEquals(1, userRatingDAO.forUuid(ratee.getUuid()).size());
  }
}
