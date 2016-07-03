/**
 *  A class to test the group removal
 */

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.data.GroupData;

import java.util.List;

import static ru.stqa.pft.addressbook.generator.BaseGenerator.generateRandom;

public class GroupDeletionTests extends BaseTests {
    @BeforeMethod
    public void ensurePrecondition() {
        app.getNavigationHelper().gotoGroupPage();

        //  Checking for the presence of at least one group with the subsequent creation
        if (!app.getGroupHelper().isThereAGroup()) {
            GroupCreationTests.testGroupCreation();
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> beforeGroupList = app.getGroupHelper().getGroupList();

        int index = generateRandom(beforeGroupList.size());

        app.getGroupHelper().selectGroupByIndex(index);
        app.getGroupHelper().deleteGroup();

        app.getNavigationHelper().returnToGroupPage();

        List<GroupData> afterGroupList = app.getGroupHelper().getGroupList();

        // Check on the number of elements
        Assert.assertEquals(afterGroupList.size(), beforeGroupList.size() - 1);

        // Removing non-existent element
        beforeGroupList.remove(index);

        // Check elements for identity verification
        Assert.assertEquals(beforeGroupList, afterGroupList);
        /*
        for (int i = 0; i < afterGroupList.size(); i++) {
            Assert.assertEquals(beforeGroupList.get(i), afterGroupList.get(i));
        }
        */
    }
}
