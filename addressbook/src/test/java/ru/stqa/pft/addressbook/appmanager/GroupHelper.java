/**
 *  The class implements the action with groups
 */

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.data.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.*;

public class GroupHelper extends BaseHelper {

    GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData groupData) {
        if (!wd.findElement(By.name("group_name")).getText().equals(groupData.getGroupName())) {
            System.out.println("groupName: " + groupData.getGroupName());

            type(By.name("group_name"), groupData.getGroupName());
            type(By.name("group_header"), groupData.getHeader());
            type(By.name("group_footer"), groupData.getFooter());
        }
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        /*
        if (!wd.findElement(By.xpath("//div[@id='content']/form/span[" + numGroup + "]/input")).isSelected()) {
           click(By.xpath("//div[@id='content']/form/span[" + numGroup + "]/input"));
        }
        */
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groupList = new ArrayList<>();
        AllGroups(groupList);
        return groupList;
    }

    public Set<GroupData> getGroupSet() {
        Set<GroupData> groupSet = new HashSet<>();
        AllGroups(groupSet);
        return groupSet;
    }

    public Groups all() {
        Groups groups = new Groups();
        AllGroups(groups);
        return groups;
    }

    private void AllGroups(Collection<GroupData> collection) {
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));

        for (WebElement element : elements) {
            int groupId = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            collection.add(new GroupData()
                    .setGroupId(groupId)
                    .setGroupName(name));
        }
    }
}
