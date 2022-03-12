package ProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
    @Test
    public void test(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        driver.manage().window().maximize();
        String actualTitle= driver.getTitle();
        String expectTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectTitle);
        WebElement name= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        name.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement viewAllProduct= driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewAllProduct.click();
        String actualUrl= driver.getCurrentUrl();
        String expectUrl="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        Assert.assertEquals(actualUrl,expectUrl);
        WebElement product= driver.findElement(By.xpath("//h2"));
        product.getText();
        String actualHeader= product.getText();
        String expectHeader="List of Products";
        Assert.assertEquals(actualHeader,expectHeader);
        String actualResult=driver.getCurrentUrl();
                boolean checkUrl=actualResult.contains("Products");
                Assert.assertTrue(checkUrl);






    }
}
