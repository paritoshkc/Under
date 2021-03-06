package ie.tcd.cs7cs3.under.storage;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
          entities = {UserEntity.class, UserRatingEntity.class},
        version = 1)
public abstract class AppDatabase extends RoomDatabase {
  private static AppDatabase INSTANCE;

  public abstract UserEntityDAO getUserEntityDao();
  public abstract UserRatingEntityDAO getUserRatingEntityDao();

  public static AppDatabase getAppDatabase(Context context) {
    if (null != INSTANCE) {
      return INSTANCE;
    }
    // demo database builder for now
    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "underdb-demo")
            .allowMainThreadQueries() // XXX: this is bad and we shouldn't do this
            .build();
    return INSTANCE;
  }
}
