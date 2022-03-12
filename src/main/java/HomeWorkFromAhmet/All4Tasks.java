package HomeWorkFromAhmet;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class All4Tasks {


    @Test
    public void TestCase1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select");
        driver.manage().window().maximize();

        WebElement India = driver.findElement(By.xpath("//select[@id='countriesSingle']//option[@value='india']"));
        String actualCountry = BrowserUtils.getTextMethod(India);
        String expectedCountry = "India";

        Assert.assertEquals(actualCountry, expectedCountry);


        // WebElement dropDown = driver.findElement(By.id("countriesSingle"));
        Select select = new Select(driver.findElement(By.id("countriesSingle")));
        List<WebElement> selectCounties = select.getOptions();
        System.out.println(selectCounties.size());
        int actualSizeOfDropBox = selectCounties.size();
        int expectedSizeOfDropBox = 4;
        Assert.assertEquals(actualSizeOfDropBox, expectedSizeOfDropBox);

        List<WebElement> countries = driver.findElements(By.id("countriesSingle"));

        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i).getText().trim());

            String actualCountries = countries.get(i).getText().trim();
            String expectedCounties = "India\n" +
                    "        United states of America\n" +
                    "        China\n" +
                    "        England";

            Assert.assertEquals(actualCountries, expectedCounties);

        }
        WebElement dropDown = driver.findElement(By.id("countriesSingle"));
        BrowserUtils.selectBy(dropDown, "2", "index");
        BrowserUtils.selectBy(dropDown, "england", "value");
        BrowserUtils.selectBy(dropDown, "United states of America", "text");
    }


    @Test
    public void case2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        WebElement multiCountries = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        Select select = new Select(multiCountries);
        select.getAllSelectedOptions();
        System.out.println(multiCountries.getText());
        String actualMulti = multiCountries.getText().trim();
        String expectedMulti = "India\n" +
                "United states of America\n" +
                "China\n" +
                "England";
        Assert.assertEquals(actualMulti, expectedMulti);
        // System.out.println(multiCountries.getText());
        BrowserUtils.selectBy(multiCountries, "2", "index");
        BrowserUtils.selectBy(multiCountries, "england", "value");


        WebElement countryC = driver.findElement(By.xpath("//select[@id='countriesSingle']/option[@value='china']"));
        boolean china = countryC.isDisplayed();
        Assert.assertTrue(china);
        WebElement countryE = driver.findElement(By.xpath("//select[@id='countriesSingle']/option[@value='england']"));
        boolean england = countryE.isDisplayed();
        Assert.assertTrue(england);


        Thread.sleep(1000);
        select.deselectAll();

        Thread.sleep(1000);
        BrowserUtils.selectBy(multiCountries, "India", "text");
        BrowserUtils.selectBy(multiCountries, "1", "index");
        BrowserUtils.selectBy(multiCountries, "2", "index");
        BrowserUtils.selectBy(multiCountries, "3", "index");

        boolean multiValiadate = multiCountries.isDisplayed();
        Assert.assertTrue(multiValiadate);


        Thread.sleep(2000);
        select.deselectByValue("england");
        Thread.sleep(1000);
        select.deselectByIndex(2);

    }

    @Test
    public void case3() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement certifiedCars = driver.findElement(By.id("make-model-search-stocktype"));

        BrowserUtils.selectBy(certifiedCars, "Certified cars", "text");
        WebElement allMakes = driver.findElement(By.name("makes[]"));
        BrowserUtils.selectBy(allMakes, "Toyota", "text");
        WebElement dropDown = driver.findElement(By.name("models[]"));
        BrowserUtils.selectBy(dropDown, "Corolla", "text");
        WebElement price = driver.findElement(By.id("make-model-max-price"));
        BrowserUtils.selectBy(price, "$30,000", "text");
        WebElement miles = driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(miles, "40 miles", "text");
        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.id("make-model-zip"));
        zipCode.sendKeys("60018");
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-cpo-make']"));
        searchButton.click();


        String actualTextofTitle = "Certified used Toyota Corolla for Sale Near Me | Cars.com";
        boolean expectedTextofTitle = actualTextofTitle.contains("Certified used");
        Assert.assertTrue(expectedTextofTitle);

        boolean actualText = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']")).isDisplayed();
        Assert.assertTrue(actualText);

        WebElement mile = driver.findElement(By.xpath("//select[@id='location-distance']/option[.='40 miles']"));
        boolean validatemiles = mile.isSelected();
        Assert.assertTrue(validatemiles);
        WebElement certifBUtton = driver.findElement(By.xpath("//option[.='Certified']"));
        boolean validate = certifBUtton.isSelected();
        Assert.assertTrue(validate);

        WebElement toyota = driver.findElement(By.xpath("//select[@name='makes[]']//optgroup//option[.='Toyota']"));
        boolean validateToyota = toyota.isSelected();
        Assert.assertTrue(validateToyota);

        WebElement corolla = driver.findElement(By.xpath("//input[@id='model_toyota-corolla']"));
        boolean validateCorolla = corolla.isSelected();
        Assert.assertTrue(validateCorolla);
    }


    @Test
    public void case4() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement certifiedCars = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(certifiedCars, "1", "index");
        Thread.sleep(1000);

        WebElement allMakes = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(allMakes, "lexus", "value");
        Thread.sleep(1000);

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(dropDown, "lexus-es_350", "value");
        Thread.sleep(1000);

        WebElement maxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(maxPrice, "50000", "value");
        Thread.sleep(1000);

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "50", "value");
        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.clear();
        zipCode.sendKeys("60016");

        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.xpath("//button[.='Search']"));
        searchButton.click();

        List<WebElement> actualAllCars = driver.findElements(By.xpath("//h2[@class='title']"));
       // int count = 0;
        for (int i = 0; i < actualAllCars.size(); i++) {
             System.out.println(actualAllCars.size());

            if (actualAllCars.size() <= 20) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");

                // count++;
            }

            // System.out.println(count);
            System.out.println(actualAllCars.get(i).getText().trim());
        }
            List<WebElement> allNames = driver.findElements(By.xpath("//h2[@class='title']"));

            for (WebElement names : allNames) {
                System.out.println(names.getText());
                if (names.getText().contains("Lexus ES 350")) {
                    System.out.println("Passed");
                } else {
                    System.out.println("Failed");
                }
            }

            List<WebElement> mileDistanseEveryCar = driver.findElements(By.xpath("//div[@class='miles-from ']"));

            for (int j= 0; j < mileDistanseEveryCar.size(); j++) {
                System.out.println(mileDistanseEveryCar.get(j).getText().trim());


            }
            System.out.println(mileDistanseEveryCar.size() + "-------------");

           List <WebElement> price=driver.findElements(By.xpath("//span[@class='primary-price']"));
           Set<String> sortedprice=new TreeSet<>();
           for(int k=0; k< price.size();k++) {
               System.out.println(price.get(k).getText().trim());
               


           }


        }


    }























