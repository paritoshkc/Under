/**
 * The Group  class instantiates and handles activities related
 * to a SINGLE group object.
 * @author Stefan Spirkl
 * @author Ashwin Ramasubramanian
 */

package ie.tcd.cs7cs3.under;

public class Group implements GroupInterface {
    private float startingPointLatitude;
    private float startingPointLongitude;
    private String recurringInterval;
    private String transportMode;
    private boolean femaleOnly;


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
     * @param userToAddToThisGroup a User object that should be attached
     * @return true if the join was successful, false if it failed and the user did not join this group
     */
    public boolean addUserToGroup(User userToAddToThisGroup) {
        return false;
    }

    /** Static method that starts the jouney for the group object that owns the method.
     * We call this method when a group decides to move in space.
     * @author Stefan Spirkl
     */
    public void startJourney() {

    }
}
