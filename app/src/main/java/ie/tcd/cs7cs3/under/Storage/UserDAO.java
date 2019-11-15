package ie.tcd.cs7cs3.under.Storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDAO {
  String sqlFindByUUID = "SELECT id, uuid, name, age, gender, address from User WHERE uuid = :uuid";
  String sqlAll = "SELECT id, uuid, name, age, gender, address from User;";

  @Insert
  void insert(final User... users);

  @Query(sqlFindByUUID)
  User findByUUID(final String uuid);

  @Query(sqlAll)
  List<User> all();
}
