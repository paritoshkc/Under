package ie.tcd.cs7cs3.under.storage;

// TODO: make this class package-private

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserRating")
public class UserRatingEntity {
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String fromUuid;
  private String toUuid;
  private int rating;
  // TODO: add rating time

  public UserRatingEntity(final String fromUuid, final String toUuid, final int rating) {
    this.fromUuid = fromUuid;
    this.toUuid = toUuid;
    this.rating = rating;
  }

  long getId() {
    return id;
  }

  void setId(final long newID) {
    this.id = newID;
  }

  String getFromUuid() {
    return fromUuid;
  }

  String getToUuid() {
    return toUuid;
  }

  int getRating() {
    return rating;
  }
}
