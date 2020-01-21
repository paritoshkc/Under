/**
 * The Group  class instantiates and handles activities related
 * to a SINGLE group object.
 * @author Stefan Spirkl
 * @author Ashwin Ramasubramanian
 */

package ie.tcd.cs7cs3.under.GroupManager;

import java.util.ArrayList;
import java.util.List;

public class Group implements GroupInterface {
    private float startingPointLatitude;
    private float startingPointLongitude;
    private String recurringInterval;
    private String transportMode;
    private boolean femaleOnly;
    private boolean groupIsAcceptingNewMembersAndNotMoving = true;
    private int capacity;

    private List<User> usersInThatGroup = new ArrayList<>();

    /** Constructor
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     */
    public Group(final float startingPointLatitude, final float startingPointLongitude, final int capacity,
                 final String recurringInterval, final String transportMode,final boolean femaleOnly, final User firstUserOfGroup) {
        this.startingPointLatitude = startingPointLatitude;
        this.startingPointLongitude = startingPointLongitude;
        this.capacity = capacity;
        this.recurringInterval = recurringInterval;
        this.transportMode = transportMode;
        this.femaleOnly = femaleOnly;

        addUserToGroup(firstUserOfGroup);
    }

    /** Adds a single User to the group object that owns the method.
     * We call this method when a user joins a group.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param userToAddToThisGroup a User object that should be attached
     * @return true if the join was successful, false if it failed and the user did not join this group
     */
    public boolean addUserToGroup(final User userToAddToThisGroup) {
        /* basic check whether the group accepts this user */
        boolean userMayJoin = true;
        if (femaleOnly && userToAddToThisGroup.getGender() == "male") userMayJoin = false;
        if (usersInThatGroup.size() == capacity) userMayJoin = false;
        if (!groupIsAcceptingNewMembersAndNotMoving) userMayJoin = false;

        if (userMayJoin) {
            usersInThatGroup.add(userToAddToThisGroup);
            return true;
        } else {
            return false;
        }
    }

    /** Static method that removes a single User from the group object that owns the method.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param userToRemoveFromThisGroup a User object that should be attached
     */
    public void removeUserFromGroup(final User userToRemoveFromThisGroup) {
        usersInThatGroup.remove(userToRemoveFromThisGroup);
    }

    /** Static method that starts the journey for the group object that owns the method.
     * We call this method when a group decides to move in space.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     */
    public void startJourney() {
        groupIsAcceptingNewMembersAndNotMoving = false;
    }

    /** Getter Method
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     */
    public List<User> getUsersOfGroup() {
        return usersInThatGroup;
    }

}
