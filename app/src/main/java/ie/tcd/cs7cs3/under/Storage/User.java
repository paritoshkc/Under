package ie.tcd.cs7cs3.under.Storage;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

@Entity
public class User {
  @PrimaryKey private final long id;
  private String name;
  private int age;
  private String address;
  private String gender;

  public User(long id, String name, int age, String gender, String address) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  public long getId() {
    return id;
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
    return id == user.id
        && age == user.age
        && name.equals(user.name)
        && address.equals(user.address)
        && gender.equals(user.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, address, gender);
  }
}
