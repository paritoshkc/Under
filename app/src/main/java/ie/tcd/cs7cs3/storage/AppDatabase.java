package ie.tcd.cs7cs3.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
    entities = {UserEntity.class, UserRatingEntity.class},
    version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract UserEntityDAO getUserDao();
  public abstract UserRatingEntityDAO getUserRatingDao();
}
