package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InformationMobilePhone extends Main {

    private String itemName;
    private String itemPrice;
    private String itemCondition;
    private String itemQuantity;

    // Select Model of Apple Phone from drop-down box
    @Test(priority = 7)
    public void selectModelPhone() {
        try {
            WebElement selectModel = driver.findElement(By.cssSelector("select[selectboxlabel='Model']"));
            Select selectModelLabel = new Select(selectModel);
            selectModelLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Model not found");
        }

    }


    // Select Carrier of Apple Phone from drop-down box
    @Test(priority = 8)
    public void selectCarrier() {
        try {
            WebElement selectCarrier = driver.findElement(By.cssSelector("select[selectboxlabel='Carrier']"));
            Select selectCarrierLabel = new Select(selectCarrier);
            selectCarrierLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Carrier not found");
        }

    }


    // Select Storage Capacity of Apple Phone from drop-down box
    @Test(priority = 9)
    public void selectStorageCapacity() {
        try {
            WebElement selectStorageCapacity = driver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity']"));
            Select selectStorageCapacityLabel = new Select(selectStorageCapacity);
            selectStorageCapacityLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage Capacity not found");
        }

    }


    // Select Color of  Apple Phone from drop-down box
    @Test(priority = 10)
    public void selectColor() {
        try {
            WebElement selectColor = driver.findElement(By.cssSelector("select[selectboxlabel='Color']"));
            Select selectColorLabel = new Select(selectColor);
            selectColorLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Color not found");
        }

    }

    // Select Cosmetic of  Apple Phone from drop-down box
    @Test(priority = 11)
    public void selectCosmetic() {
        try {
            WebElement selectCosmetic = driver.findElement(By.cssSelector("select[selectboxlabel='Cosmetic']"));
            Select selectCosmeticLabel = new Select(selectCosmetic);
            selectCosmeticLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Cosmetic not found");
        }

    }

    //get Item Name (title)

    @Test(priority = 12)
    public void getItemName() {
        itemName = driver.findElement(By.cssSelector("h1.x-item-title__mainTitle")).getText().trim();
        System.out.println("Item Title is " + itemName);
    }

    //get Item price

    @Test(priority = 13)
    public void getItemPrice() {
        itemPrice = driver.findElement(By.cssSelector(".x-price-primary > span:nth-child(1)")).getText().trim();
        System.out.println("Item Price is " + itemPrice);
    }

    //get Item Condition

    @Test(priority = 14)
    public void getItemCondition() {
        itemCondition = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[1]/div[1]/div/div[2]/div[1]")).getText().trim();
        System.out.println("Item Condition is " + itemCondition);
    }

    //get Item Quantity

    @Test(priority = 15)
    public void getItemQuantity() {
        itemQuantity = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item Quantity is " + itemQuantity);
    }

    //Select “Add to cart”

    @Test(priority = 16)
    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div"));
        addToCartButton.click();
    }

    // check Item name
    @Test(priority = 17)
    public void checkItemName() {
        String name = driver.findElement(By.className("item-title")).getText().trim();
        Assert.assertEquals(name, itemName);
        System.out.println("Name equal to item name");

    }

    // check Item price
    @Test(priority = 18)
    public void checkItemPrice() {
        String price = driver.findElement(By.cssSelector("div.total-row:nth-child(2)")).getText().trim();
        Assert.assertEquals(price, itemPrice);
        System.out.println("Subtotal equal to item price");

    }

    //check Quantity
    @Test(priority = 19)
    public void checkItemQuantity() {
        WebElement quantity = driver.findElement(By.xpath("//label[text()='Qty']//following-sibling::span/select"));
        String option = quantity.getAttribute("value");
        Assert.assertEquals(option, itemQuantity);
        System.out.println("Quantity equal to item Quantity");

    }

    //get Shipping Value
    @Test(priority = 20)
    public void getShippingValue() {
        WebElement ShippingValue = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[2]/div[2]"));
        String shipping = ShippingValue.getText().trim();
        System.out.println("Shipping Value is " + shipping);

    }

}
