/**
 * The HopOff class instantiates and handles activities related
 * to a single hop-off (journey end) of a single user of a single group.
 * @author Stefan Spirkl
 * @author Ashwin Ramasubramanian
 */
package ie.tcd.cs7cs3.under;

public class HopOff implements HopOffInterface {

    private float destinationOfTripLatitude;
    private float destinationOfTripLongitude;
    private String arrivalTime;

    /* constructor for a new destination where a User will get off */
    public HopOff(final User userWhoTravels, final float destinationOfTripLatitude, final float destinationOfTripLongitude) {
        this.destinationOfTripLatitude = destinationOfTripLatitude;
        this.destinationOfTripLongitude = destinationOfTripLongitude;
    }

    /** Static method that signals that a user has arrived.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     */
    public void arriveAtDestination() {

    }
}
