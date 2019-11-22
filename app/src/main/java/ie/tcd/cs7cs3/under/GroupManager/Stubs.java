package ie.tcd.cs7cs3.under.GroupManager;

import java.util.List;

public class Stubs {

    private GroupManager allGroups;

    /* TODO: add method to create a hard-coded group. This is called from front-end. */
    /* when sb clicks "Create Group" Button */
    public void createExampleGroup() {
        User exampleUser1 = new User(50, -6, 10,10, "female", "");
        Group exampleGroup = new Group(50, -6, 4, "", "car", false, exampleUser1);

        allGroups = new GroupManager();
        allGroups.addGroup(exampleGroup);

    }

    /* TODO: add method to join a hard-coded group. This is called from front-end. */
    public void joinExampleGroup() {
        /* Create a group we can join and a user to do so :) */
        createExampleGroup();
        User exampleUser2 = new User(52, -7, 10,10, "female", "");

        /* Get groups from GroupManager */
        List<Group> groupsWeCanJoin = allGroups.findSimilarDestinationGroups(51, 51);

        /* Join it */
        groupsWeCanJoin.get(0).addUserToGroup(exampleUser2);
    }

}
