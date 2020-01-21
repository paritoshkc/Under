/** Capsules all group LISTS related activities.
 * @author Stefan Spirkl
 * @param latitude the latitude of the destination we want to find groups for
 * @param longitude the latitude of the destination we want to find groups for
 * @return a list of groups that fit that destination / have a a similar destination
 */
package ie.tcd.cs7cs3.under.GroupManager;
import java.util.ArrayList;
import java.util.List;

public class GroupManager implements GroupManagerInterface {
    /** this is the list that contains _all_ the groups in our system */
    private static List<Group> listOfAllGroups = new ArrayList<>();

    /** Capsules all group LISTS related activities.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param latitude the latitude of the destination we want to find groups for
     * @param longitude the latitude of the destination we want to find groups for
     * @return a list of groups that fit that destination / have a a similar destination
     */
    public static List<Group> findSimilarDestinationGroups(float latitude, float longitude) {
        /* TODO: currently is returning all groups */
        return listOfAllGroups;
    }

    /** Adds a group to the global list once it is created.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param groupToAdd a newly created group to be added to the global list
     */
    public void addGroup(final Group groupToAdd) {
        listOfAllGroups.add(groupToAdd);
    }

    /** Removes a group from the global list, for example when it arrives at the last hop.
     * @author Stefan Spirkl
     * @author Ashwin Ramasubramanian
     * @param groupToRemove a group to remove from the global list
     */
    public void removeGroup(final Group groupToRemove) {
        listOfAllGroups.remove(groupToRemove);
    }
}
