/**
 *  The class implements to the site
 */

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if (!isElementPresent(By.tagName("h1")) || !wd.findElement(By.tagName("h1")).getText().equals("Groups") || !isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public void gotoHomePage() {
        if (!isElementPresent(By.id("maintable"))) {
            click(By.linkText("home"));
        }
    }
}
