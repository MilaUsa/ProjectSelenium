package SeleniumProject2Ahmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase3 {
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement login = driver.findElement(By.name("user-name"));
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement aTozButton = driver.findElement(By.xpath("//select"));
        aTozButton.click();
        Select select = new Select(aTozButton);
        select.selectByIndex(2);
        List<WebElement> producPrice = driver.findElements(By.className("inventory_item_price"));

        for(int i=0;i<producPrice.size();i++){
            System.out.println(producPrice.get(i).getText());
        }
        WebElement cheapestItem1= driver.findElement(By.name("add-to-cart-sauce-labs-onesie"));
        cheapestItem1.click();
        WebElement cheapestItem2= driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        cheapestItem2.click();
        WebElement shoppingCard= driver.findElement(By.className("shopping_cart_link"));
        shoppingCard.click();
        List<WebElement> twoItemsInCard=driver.findElements(By.className("inventory_item_name"));
        for(WebElement two:twoItemsInCard){
            System.out.println(two.getText());
            boolean actualValidation=two.isDisplayed();
            Assert.assertTrue(actualValidation);
    }}
}