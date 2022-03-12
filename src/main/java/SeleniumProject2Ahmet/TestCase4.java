package SeleniumProject2Ahmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase4 {
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
        select.selectByIndex(3);
        WebElement expensivitem1= driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        expensivitem1.click();
        WebElement expensivitem2= driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        expensivitem2.click();
        WebElement shoppingCard= driver.findElement(By.className("shopping_cart_link"));
        shoppingCard.click();
        WebElement checkOutButton= driver.findElement(By.id("checkout"));
        checkOutButton.click();
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Milana");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Usekeeva");
        WebElement zipCode= driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("60656");
        WebElement continueButton= driver.findElement(By.name("continue"));
       continueButton.click();

//        List<WebElement> choosedItemsPrice=driver.findElements(By.className("inventory_item_price"));
//        for(int i=0;i<choosedItemsPrice.size();i++){
//            System.out.println(choosedItemsPrice.get(i).getText());
//        }
       WebElement itemPrice= driver.findElement(By.className("summary_subtotal_label"));
        System.out.println(itemPrice.getText());
        String actualValidation=itemPrice.getText();
//        String expectedValidation=""
//        WebElement totalPrice= driver.findElement(By.className("summary_total_label"));
//        System.out.println(totalPrice.getText());
    }
}
