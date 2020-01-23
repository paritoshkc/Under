package ie.tcd.cs7cs3.storage;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import androidx.room.Room;
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
public class UserEntityRatingDAOTest {
  private final UserEntity[] testUserEntities = new UserEntity[]{
    new UserEntity("sample UUID 1", true, "joe", 23, "male", "123 Main Street", 1.0F, -1.0F),
    new UserEntity("sample UUID 2", false ,"jane", 34, "female", "234 Old Street", 2.0F, -2.0F),
  };

  private UserRatingEntityDAO userRatingEntityDAO;
  private UserEntityDAO userEntityDAO;
  private AppDatabase db;

  @Before
  public void setUp() throws Exception {
    final Context ctx = getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase.class).allowMainThreadQueries().build();
    userRatingEntityDAO = db.getUserRatingEntityDao();
    userEntityDAO = db.getUserEntityDao();
    userEntityDAO.insert(testUserEntities);
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
    final UserEntity rater = userEntityDAO.findByUUID(testUserEntities[0].getUuid());
    final UserEntity ratee = userEntityDAO.findByUUID(testUserEntities[1].getUuid());
    userRatingEntityDAO.insert(new UserRatingEntity(rater.getUuid(), ratee.getUuid(), 5));
    Assert.assertEquals(1, userRatingEntityDAO.forUuid(ratee.getUuid()).size());
  }
}
