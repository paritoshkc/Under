/**
 * The Group Manager class provides group related functionality.
 * @author Stefan Spirkl
 */

package ie.tcd.cs7cs3.under;
import java.util.List;

public interface GroupManagerInterface {
        /** Capsules all group LISTS related activities.
        * @author Stefan Spirkl
        * @param latitude / the latitude of the destination we want to find groups for
        * @param longitude / the latitude of the destination we want to find groups for
        * @return a list of groups that fit that destination / have a a similar destination
        */
        List<Group> findSimilarDestinationGroups(final float latitude, final float longitude);
}
