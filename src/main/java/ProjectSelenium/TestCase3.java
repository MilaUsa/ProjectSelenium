package ProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase3 {
    @Test
    public void tes3() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        String expectTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectTitle);
        WebElement name = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        name.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//li/a"));
        for (WebElement link : allLinks) {
            //System.out.println(link.isDisplayed());
            System.out.println(link.getText());
        }
            //String actualValue=link.getAttribute("href");

            List<WebElement> allHref = driver.findElements(By.tagName("href"));
//            for(WebElement href:allHref){
//                System.out.println(href.getAttribute());
//            }
            //Assert.assertEquals(allLinks,allHref);

          //  String selected=link.getAttribute("") ;
            //System.out.println(selected);
            // if(link.getAttribute("href").equals("false")) {


        }
    }
