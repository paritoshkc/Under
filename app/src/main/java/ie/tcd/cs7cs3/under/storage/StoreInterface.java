package ie.tcd.cs7cs3.under.storage;

import ie.tcd.cs7cs3.under.GroupManager.UserInterface;
import java.util.Optional;

/**
 * StoreInterface is the public interface to the storage package. All storage-related operations go through this.
 */
public interface StoreInterface {

  /**
   * getCurrentUser() returns the currently 'active' user of the device.
   * @return UserInterface containing information of current user.
   */
  public UserInterface getCurrentUser();

  /**
   * getUser() returns the user identified by @param uuid
   * @return Optional<UserInterface> containing information of given user if it is present.
   * Otherwise, returns Optional.absent()
   */
  public Optional<UserInterface> getUser(String uuid);

  /**
   * rateUser() provides a rating for the device's current user.
   * @param from the User giving the rating
   * @param rating the rating of the target user.
   */
  public void rateUser(UserInterface from, int rating);
}
