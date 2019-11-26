package ie.tcd.cs7cs3.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
interface UserEntityDAO {
  String sqlFindCurrent = "SELECT id, uuid, current, name, age, gender, address, addressLat, addressLng from User WHERE current = 1";
  String sqlFindByUUID = "SELECT id, uuid, current, name, age, gender, address, addressLat, addressLng from User WHERE uuid = :uuid";
  String sqlAll = "SELECT id, uuid, current, name, age, gender, address, addressLat, addressLng from User;";

  @Insert
  void insert(final UserEntity... UserEntities);

  @Query(sqlFindByUUID)
  UserEntity findByUUID(final String uuid);

  @Query(sqlFindCurrent)
  UserEntity findCurrent();

  @Query(sqlAll)
  List<UserEntity> all();
}
