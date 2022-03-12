import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Browserutils {
    @Test
    public void TestCase1() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        WebElement actualSelectIndia= driver.findElement(By.xpath("//select[@id='countriesSingle']//option[@value='india']"));
        actualSelectIndia.click();
        boolean expectedIndia=true;
        Assert.assertTrue(actualSelectIndia.isSelected());
        List<WebElement> allCountries= driver.findElements(By.xpath("//select[@id='countriesSingle']/option"));

        Set<String> countries=new LinkedHashSet<>();
        int count=0;
        for(WebElement all:allCountries){
            countries.add(all.getText().trim());
            count++;
        }
        Set<String> expectedCountries=new LinkedHashSet<>();
        expectedCountries.add("India");
        expectedCountries.add("United states of America");
        expectedCountries.add("China");
        expectedCountries.add("England");
        Assert.assertEquals(countries,expectedCountries);
        int size=4;
        Assert.assertEquals(count,size);

        WebElement china = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
        BrowserUtils.selectBy(china,"2","index");
        Thread.sleep(2000);
        WebElement england = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
        BrowserUtils.selectBy(england,"england","value");
        Thread.sleep(2000);
        WebElement usa = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
        BrowserUtils.selectBy(usa,"United states of America","text");

    }
    @Test
    public void TestCase2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        List<WebElement> allCountries = driver.findElements(By.xpath("//select[@id='countriesMultiple']/option"));

        Set<String> countries = new LinkedHashSet<>();
        for (WebElement all : allCountries) {
            countries.add(all.getText().trim());
        }
        Set<String> expectedCountries = new LinkedHashSet<>();
        expectedCountries.add("India");
        expectedCountries.add("United states of America");
        expectedCountries.add("China");
        expectedCountries.add("England");
        Assert.assertEquals(countries, expectedCountries);

        WebElement china = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.selectBy(china, "2", "index");

        Thread.sleep(2000);
        WebElement england = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.selectBy(england, "england", "value");

        Thread.sleep(2000);
        Select select = new Select(england);
        select.deselectAll();
        Thread.sleep(2000);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            option.click();
        }

        Thread.sleep(2000);
        WebElement IsDisplayed = driver.findElement(By.xpath("//div[@id='result']"));
        boolean actualIsDisplayed = IsDisplayed.isDisplayed();
        Assert.assertTrue(actualIsDisplayed);

        Thread.sleep(2000);
        select.deselectByIndex(2);

        Thread.sleep(2000);
        select.deselectByIndex(3);


    }



}




