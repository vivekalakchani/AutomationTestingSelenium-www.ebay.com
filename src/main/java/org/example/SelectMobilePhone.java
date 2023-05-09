package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectMobilePhone extends Main {

    // Launch the ToolsQA WebSite
    @Test(priority = 1)
    @Parameters({"url"})
    public void getUrl(String url) {
        driver.get(url);
        System.out.println(url);
    }

    // verify url (if it is the correct page that is opened)
    @Test(priority = 2)
    @Parameters({"url"})
    public void verifyUrl(String url) {

        Assert.assertEquals(driver.getCurrentUrl(), url);
        System.out.println("The correct page that is opened");
    }

    // Select “Cell Phones & Accessories” from main drop-down box
    @Test(priority = 3)
    public void selectCategory() {
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
        System.out.println("Select Cell Phones & Accessories");
    }

    // search “Mobile phone” on search bar
    @Test(priority = 4)
    public void searchMobilePhone() {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        System.out.println("Search “Mobile phone”");

        // Click on Search button icon
        driver.findElement(By.id("gh-btn")).click();
        System.out.println("Click on Search button");

    }

    // Select brand as “Apple” from side panel
    @Test(priority = 5)
    public void selectApplePhone() {
        WebElement appleCheckBox = driver.findElement(By.xpath("/html/body/div[8]/div[3]/ul/li[1]/ul/li[2]/ul/li[1]/div[2]/ul/li[1]/div/a/div"));
        appleCheckBox.click();
    }

    //Select the first search item
    @Test(priority = 6)
    public void selectFirstElement() throws InterruptedException {
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div"));
        firstElement.click();
        Thread.sleep(5000);

        // Navigate to a new window
        for (String winHandel : driver.getWindowHandles()) {
            driver.switchTo().window(winHandel);
        }
    }

}
