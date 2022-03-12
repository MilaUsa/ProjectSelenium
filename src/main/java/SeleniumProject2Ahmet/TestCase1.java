package SeleniumProject2Ahmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1 {
    @Test
    public void test1(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement login= driver.findElement(By.name("user-name"));
        login.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton= driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement aTozButton= driver.findElement(By.xpath("//select"));
        aTozButton.click();
        Select select=new Select(aTozButton);
        select.selectByIndex(1);
        List<WebElement> items=driver.findElements(By.className("inventory_item_name"));
        for(WebElement item:items){
            System.out.println(item.getText());
            boolean actualValidation=item.isDisplayed();
            String expectedValidation="true";
            Assert.assertEquals(actualValidation,expectedValidation);



        }



    }
}
