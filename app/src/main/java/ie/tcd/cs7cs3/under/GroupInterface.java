/**
 * The Group  class instantiates and handles activities related
 * to a SINGLE group object.
 * @author Stefan Spirkl
 */

package ie.tcd.cs7cs3.under;

public interface GroupInterface {
    /** Static method that adds a single User to the group object that owns the method.
     * We call this method when a user joins a group.
     * @author Stefan Spirkl
     * @param userToAddToThisGroup a User object that should be attached
     * @return true if the join was successful, false if it failed and the user did not join this group
     */
    boolean addUserToGroup(final User userToAddToThisGroup);

    /** Static method that starts the jouney for the group object that owns the method.
     * We call this method when a group decides to move in space.
     * @author Stefan Spirkl
     */
    void startJourney();
}
