package ProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    @Test
    public void name(){
     System.setProperty("webdriver.chrome.driver","chromedriver");
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
        String actualTitle1=driver.getTitle();
        String expectTitle1="Web Orders";
        Assert.assertEquals(actualTitle1,expectTitle1);
        WebElement header= driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        header.getText();
        String actualHeader=header.getText();
        String expectHeader="List of All Orders";
        Assert.assertEquals(actualHeader,expectHeader);




    }
}
