package SeleniumProject2Ahmet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase5 {
 @Test
    public void task5(){
     WebDriver driver=new ChromeDriver();
     driver.get("https://demoqa.com/select-menu");
     driver.manage().window().maximize();
  WebElement optionButton= driver.findElement(By.id("react-select-2-input"));
  Actions actions=new Actions(driver);
  optionButton.sendKeys(""+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.RETURN);




  

 }
}
