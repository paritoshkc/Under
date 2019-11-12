/** Capsules all group LISTS related activities.
 * @author Stefan Spirkl
 * @param latitude / the latitude of the destination we want to find groups for
 * @param longitude / the latitude of the destination we want to find groups for
 * @return a list of groups that fit that destination / have a a similar destination
 */
package ie.tcd.cs7cs3.under;
import java.util.List;

public class GroupManager implements GroupManagerInterface {
    /** this is the list that contains _all_ the groups in our system */
    private static List<Group> listOfAllGroups;

    /** Capsules all group LISTS related activities.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param latitude / the latitude of the destination we want to find groups for
     * @param longitude / the latitude of the destination we want to find groups for
     * @return a list of groups that fit that destination / have a a similar destination
     */
    public List<Group> findSimilarDestinationGroups(float latitude, float longitude) {
        /* TODO: implementation */
        return null;
    }
}
