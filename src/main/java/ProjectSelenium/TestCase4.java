package ProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase4 {

//    Navigate to
//"http://secure.smartbearsoftware.com/samples/TestCom
//    plete11/WebOrders/Login.aspx?"
//    Input username "Tester"
//    Input password "Test"
//    Click login button
//    Click "Order" button
//    Select product "Screen Saver"
//    Input quantity 5
//    Input Customer name "Techtorial Academy"
//    Input Street "2200 E devon"
//    Input City "Des Plaines"
//    Input State "Illinois"
//    Input Zip "60018"
//    Select MasterCard
//    Input card number "444993876233"
//    Input expiration date "03/21"
//    Click Process button
//    Test Scenario
    @Test
    public void test4(){
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

       WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
      orderButton.click();
       WebElement selectName = driver.findElement(By.xpath("//select"));
       selectName.click();
       selectName.sendKeys("ScreenSaver");
       selectName.submit();
       WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
       quantity.click();
       quantity.sendKeys("5");
       quantity.submit();

        WebElement  customerName= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
       customerName.sendKeys("Techtorial Academy");
       WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement  state= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
       zipCode.sendKeys("60018");
       WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
      cardNumber.sendKeys("444993876233");
        WebElement experationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        experationDate.sendKeys("03/21");
        WebElement processButton= driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        WebElement validation= driver.findElement(By.xpath("//strong"));
        boolean actualValidation=validation.isDisplayed();
       boolean  expectValidation=true;
       Assert.assertEquals(actualValidation,expectValidation);
       WebElement viewOrderButton= driver.findElement(By.xpath("//a[@href=\"Default.aspx\"]"));
       viewOrderButton.click();

        List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement box:boxes) {
            System.out.println(box.isDisplayed());


           //Assert.assertEquals(box.getAttribute("Techtorial Academy"),true);


//         

            }
}}
