/**
 * The User  class instantiates and handles activities related
 * to a SINGLE USER object.
 * @author Stefan Spirkl
 */

package ie.tcd.cs7cs3.under;

public interface UserInterface {
    /** Static method that adds a rating to the User object that owns the method.
     * We call this method when a User rate another User.
     * @author Stefan Spirkl
     * @param rating a 1-5 int that is higher the better the rating is
     */
    void addNewRating(final int rating);

}
