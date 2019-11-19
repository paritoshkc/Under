package ie.tcd.cs7cs3.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserRatingDAO {
  String sqlForUuid = "SELECT id, fromUuid, toUuid, rating FROM UserRating WHERE toUuid = :toUuid;";
  String sqlAll = "SELECT id, fromUuid, toUuid, rating FROM UserRating;";

  @Insert
  void insert(final UserRating ... userRatings);

  @Query(sqlForUuid)
  List<UserRating> forUuid(final String toUuid);

  @Query(sqlAll)
  List<UserRating> all();

}
