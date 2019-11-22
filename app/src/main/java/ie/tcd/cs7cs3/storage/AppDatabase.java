package ie.tcd.cs7cs3.storage;

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

  public static AppDatabase getInMemoryAppDatabase(Context context) {
    if (null != INSTANCE) {
      return INSTANCE;
    }
    // inmemory database builder for now
    INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
        .allowMainThreadQueries() // XXX: this is bad
        .build();
    return INSTANCE;
  }
}
