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
  private boolean current;
  private String uuid;
  private String name;
  private int age;
  private String address;
  private float addressLat;
  private float addressLng;
  private String gender;

  // XXX: required by Room. Not for public consumption.
  public UserEntity() { }

  @Ignore
  UserEntity(String uuid, boolean current, String name, int age, String gender, String address, float addressLat, float addressLng) {
    this.uuid = uuid;
    this.current = current;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
    this.addressLat = addressLat;
    this.addressLng = addressLng;
  }

  long getId() {
    return id;
  }

  void setId(final long newId) {
    id = newId;
  }
  String getUuid() {
    return uuid;
  }

  void setUuid(final String newUUID) {
    uuid = newUUID;
  }

  boolean isCurrent() {
    return current;
  }

  void setCurrent(boolean current) {
    this.current = current;
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

  float getAddressLat() {
    return addressLat;
  }

  void setAddressLat(float addressLat) {
    this.addressLat = addressLat;
  }

  float getAddressLng() {
    return addressLng;
  }

  void setAddressLng(float addressLng) {
    this.addressLng = addressLng;
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
