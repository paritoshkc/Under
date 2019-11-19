package ie.tcd.cs7cs3.storage;

// TODO: make this class package-private

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(indices = {@Index(value={"uuid"},unique = true)}, tableName = "User")
class UserEntity {
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String uuid;
  private String name;
  private int age;
  private String address;
  private String gender;

  // public-facing constructor, this is the only one that should be used externally
  UserEntity(String name, int age, String gender, String address) {
    this.uuid = UUID.randomUUID().toString();
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  // only used for unit tests
  @Ignore
  UserEntity(String uuid, String name, int age, String gender, String address) {
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

  String getUuid() {
    return uuid;
  }

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  int getAge() {
    return age;
  }

  void setAge(int age) {
    this.age = age;
  }

  String getGender() {
    return gender;
  }

  void setGender(String gender) {
    this.gender = gender;
  }

  String getAddress() {
    return address;
  }

  void setAddress(String address) {
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
    UserEntity UserEntity = (UserEntity) o;
    return uuid.equals(UserEntity.uuid)
        && age == UserEntity.age
        && name.equals(UserEntity.name)
        && address.equals(UserEntity.address)
        && gender.equals(UserEntity.gender);
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
