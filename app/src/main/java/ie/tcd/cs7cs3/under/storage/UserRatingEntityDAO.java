package ie.tcd.cs7cs3.under.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserRatingEntityDAO {
  String sqlForUuid = "SELECT id, fromUuid, toUuid, rating FROM UserRating WHERE toUuid = :toUuid;";
  String sqlAll = "SELECT id, fromUuid, toUuid, rating FROM UserRating;";

  @Insert
  void insert(final UserRatingEntity... userRatingEntities);

  @Query(sqlForUuid)
  List<UserRatingEntity> forUuid(final String toUuid);

  @Query(sqlAll)
  List<UserRatingEntity> all();

}
