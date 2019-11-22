package ie.tcd.cs7cs3.storage;

import android.annotation.SuppressLint;
import ie.tcd.cs7cs3.under.GroupManager.UserInterface;
import java.util.Optional;

public class Store implements StoreInterface {
  private final UserEntityDAO userEntityDAO;
  private final UserRatingEntityDAO userRatingEntityDAO;

  public Store(final AppDatabase appDatabase) {
    this.userEntityDAO = appDatabase.getUserEntityDao();
    this.userRatingEntityDAO = appDatabase.getUserRatingEntityDao();
  }

  @Override
  public UserInterface getCurrentUser() {
    return null;
  }

  @SuppressLint("NewApi")
  @Override
  public Optional<UserInterface> getUser(String uuid) {
    return Optional.empty();
  }

  @Override
  public void rateUser(UserInterface from, int rating) {

  }
}
