package ie.tcd.cs7cs3.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
interface UserEntityDAO {
  String sqlFindByUUID = "SELECT id, uuid, name, age, gender, address from User WHERE uuid = :uuid";
  String sqlAll = "SELECT id, uuid, name, age, gender, address from User;";

  @Insert
  void insert(final UserEntity... UserEntities);

  @Query(sqlFindByUUID)
  UserEntity findByUUID(final String uuid);

  @Query(sqlAll)
  List<UserEntity> all();
}
