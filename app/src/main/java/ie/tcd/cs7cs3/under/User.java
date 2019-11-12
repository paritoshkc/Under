/**
 * The User  class instantiates and handles activities related
 * to a SINGLE USER object.
 * @author Stefan Spirkl
 * @author Ashwin Ramasubramanian
 */

package ie.tcd.cs7cs3.under;

public class User implements UserInterface {

    private float currentLocationLatitude;
    private float currentLocationLongitude;
    private float homeLocationLatitude;
    private float homeLocationLongitude;
    /* gender is non-binary :-) */
    private String gender;
    /* a rating o 0 means no rating */
    private float averageRatingOfUser;
    /* TBD what preferences actually are */
    private String preferences;

    /* constructor for a new User object */
    public User(final float currentLocationLatitude, final float currentLocationLongitude,
                final float homeLocationLatitude, final float homeLocationLongitude,
                final String gender, final String preferences) {

        this.currentLocationLatitude = currentLocationLatitude;
        this.currentLocationLongitude = currentLocationLongitude;
        this.homeLocationLatitude = homeLocationLatitude;
        this.homeLocationLongitude = homeLocationLongitude;
        this.gender = gender;
        this.preferences = preferences;
        averageRatingOfUser = 0;
    }

    public void addNewRating(int rating) {

    }
}
