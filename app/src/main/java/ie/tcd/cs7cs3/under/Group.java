/**
 * The Group  class instantiates and handles activities related
 * to a SINGLE group object.
 * @author Stefan Spirkl
 * @author Ashwin Ramasubramanian
 */

package ie.tcd.cs7cs3.under;

import java.util.List;

public class Group implements GroupInterface {
    private float startingPointLatitude;
    private float startingPointLongitude;
    private String recurringInterval;
    private String transportMode;
    private boolean femaleOnly;
    private boolean groupIsAcceptingNewMembersAndNoMoving = true;

    private List<User> usersInThatGroup;

    /** Constructor
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     */
    public Group(final float startingPointLatitude, final float startingPointLongitude,
                 final String recurringInterval, final String transportMode,final boolean femaleOnly) {
        this.startingPointLatitude = startingPointLatitude;
        this.startingPointLongitude = startingPointLongitude;
        this.recurringInterval = recurringInterval;
        this.transportMode = transportMode;
        this.femaleOnly = femaleOnly;
    }

    /** Static method that adds a single User to the group object that owns the method.
     * We call this method when a user joins a group.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param userToAddToThisGroup a User object that should be attached
     * @return true if the join was successful, false if it failed and the user did not join this group
     */
    public boolean addUserToGroup(final User userToAddToThisGroup) {
        // TODO: extend this into a check whether the user is allowed to join the group
        boolean userMayJoin = true;

        if (userMayJoin) {
            usersInThatGroup.add(userToAddToThisGroup);
            return true;
        } else {
            return false;
        }
    }

    /** Static method that starts the journey for the group object that owns the method.
     * We call this method when a group decides to move in space.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     */
    public void startJourney() {
        groupIsAcceptingNewMembersAndNoMoving = false;
    }
}
