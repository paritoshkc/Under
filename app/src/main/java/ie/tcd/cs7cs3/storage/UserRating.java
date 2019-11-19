package ie.tcd.cs7cs3.storage;

// TODO: make this class package-private

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserRating {
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String fromUuid;
  private String toUuid;
  private int rating;
  // TODO: add rating time

  public UserRating(final String fromUuid, final String toUuid, final int rating) {
    this.fromUuid = fromUuid;
    this.toUuid = toUuid;
    this.rating = rating;
  }

  public long getId() {
    return id;
  }

  void setId(final long newID) {
    this.id = newID;
  }

  public String getFromUuid() {
    return fromUuid;
  }

  public String getToUuid() {
    return toUuid;
  }

  public int getRating() {
    return rating;
  }
}
