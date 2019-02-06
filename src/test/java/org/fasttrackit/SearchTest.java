package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

@Test

    public void  searchByOneKeywordTest() {

    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
       driver.get("https://fasttrackit.org/selenium-test/");
String keyword = "vase";
    driver.findElement(By.id("search")).sendKeys(keyword);
    driver.findElement(By.tagName("button")).click();
    List<WebElement> productNameContainers = driver.findElements(By.cssSelector("h2.product-name >a"));
    for (WebElement container: productNameContainers){
        String productName = container.getText();

        assertThat("Some of the product names do not contain the search keyword",productName, containsString(keyword.toUpperCase()));

    }
    }

    }

