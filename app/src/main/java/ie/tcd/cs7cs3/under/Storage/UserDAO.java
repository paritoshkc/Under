package ie.tcd.cs7cs3.under.Storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDAO {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  public void insert(final User... users);

  @Query("SELECT id, name, age, gender, address from user WHERE name = :name")
  public List<User> findByName(final String name);
}
