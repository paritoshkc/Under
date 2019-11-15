package ie.tcd.cs7cs3.under.Storage;

// TODO: move this whole package to ie.tcd.cs7cs3.storage
// TODO: make this class package-private

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(indices = {@Index(value={"uuid"},unique = true)})
public class User {
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String uuid;
  private String name;
  private int age;
  private String address;
  private String gender;

  // public-facing constructor, this is the only one that should be used externally
  public User(String name, int age, String gender, String address) {
    this.uuid = UUID.randomUUID().toString();
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  // only used for unit tests
  @Ignore
  User(String uuid, String name, int age, String gender, String address) {
    this.uuid = uuid;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  long getId() {
    return id;
  }

  void setId(final long newId) {
    id = newId;
  }

  void setUuid(final String newUUID) {
    uuid = newUUID;
  }

  public String getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return uuid.equals(user.uuid)
        && age == user.age
        && name.equals(user.name)
        && address.equals(user.address)
        && gender.equals(user.gender);
  }

  @Override
  public int hashCode() {
    // XXX: not using Objects.hash for backward compatibility
    int result = 17;
    result = 31 * result + age;
    result = 31 * result + name.hashCode();
    result = 31 * result + address.hashCode();
    result = 31 * result + gender.hashCode();
    return result;
  }
}
