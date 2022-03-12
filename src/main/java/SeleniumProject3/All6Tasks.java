package SeleniumProject3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class All6Tasks {
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        List<WebElement> allprices =driver.findElements(By.xpath("//span[@class=\"price product-price\"]"));
      //28
        List<WebElement> displayedPrices = new ArrayList<>();
        List<Double> doublePrices = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i <allprices.size() ; i++) {
            if (allprices.get(i).isDisplayed()){
                displayedPrices.add(allprices.get(i));
                doublePrices.add( Double.parseDouble(allprices.get(i).getText().replace("$","").trim()) );
                sum+= Double.parseDouble(allprices.get(i).getText().replace("$","").trim());
            }


        }
        Assert.assertTrue(196.38==sum);

    }
    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        List<WebElement> allprices =driver.findElements(By.xpath("//span[@class=\"price product-price\"]"));
        //28
        List<WebElement> displayedPrices = new ArrayList<>();
        List<Double> doublePrices = new ArrayList<>();

        for (int i = 0; i <allprices.size() ; i++) {
            if (allprices.get(i).isDisplayed()){
                displayedPrices.add(allprices.get(i));
                doublePrices.add( Double.parseDouble(allprices.get(i).getText().replace("$","").trim()) );
            }
        }
       Collections.sort(doublePrices);
        System.out.println(doublePrices.get(0));


    }
    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
       // WebElement cardButton=driver.findElement(By)

    }
    @Test
    public void test4() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        WebElement womanButton=driver.findElement(By.xpath("//a[@class='sf-with-ul' and .='Women']"));
       Actions actions=new Actions(driver);
       actions.moveToElement(womanButton).perform();
       WebElement summerDresses= driver.findElement(By.xpath("//a[@title='Summer Dresses']"));
       actions.moveToElement(summerDresses).click().perform();
       WebElement firstItem=driver.findElement(By.xpath("//img[@alt='Printed Summer Dress']"));
       actions.moveToElement(firstItem);
      WebElement addToCard=driver.findElement(By.xpath("//span[.='Add to cart']"));
       actions.moveToElement(addToCard).click().perform();
      WebElement text=driver.findElement(By.xpath("//h2"));
//        System.out.println(text.getText());
//        System.out.println(text.isDisplayed());
//     boolean actualValidation= text.isDisplayed();
//
//       String expectedValidation="true";
//       Assert.assertEquals(actualValidation,expectedValidation);

        System.out.println(text.getCssValue("color"));
        String actualValidation=text.getCssValue("color");
       String expectedcolorValidation="#46a74e";
       Assert.assertEquals(actualValidation,expectedcolorValidation);




    }
    @Test
    public void Case6() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        Actions actions = new Actions(driver);

        WebElement women = driver.findElement(By.xpath("//a[.=\"Women\"]"));

        actions.moveToElement(women).perform();
        Thread.sleep(150);
        WebElement summerDress = driver.findElement(By.xpath("//a[@title=\"Summer Dresses\"]"));
        summerDress.click();
        WebElement sliderSquareOnLeft = driver.findElement(By.xpath("//a[@class=\"ui-slider-handle ui-state-default ui-corner-all\"][1]"));

        WebElement sliderPriceText = driver.findElement(By.xpath("//span[@id=\"layered_price_range\"]"));

        while (!sliderPriceText.getText().startsWith("$20.00")) {

            actions.click(sliderSquareOnLeft).perform();
            actions.sendKeys(Keys.ARROW_RIGHT).perform();


        }

    }
}












