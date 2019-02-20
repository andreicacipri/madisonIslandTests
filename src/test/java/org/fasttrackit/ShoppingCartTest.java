package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {
    @Test
    public void addToCartFromSearchResultsTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        String keyword = "vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword+ Keys.ENTER);
        System.out.println("Pressed enter in search field. ");

        String productToCart ="Herald Glass Vase";
        driver.findElement(By.xpath(
                "//div[@class='product-info'and .//a[text()='"+productToCart+"']]//button[@title='Add to Cart']")).click();

       String cart = driver.findElement(By.className("success-msg")).getText();

       assertThat("Succes messege is not display",cart,is((""+productToCart+" was added to your shopping cart.")));
        String product = driver.findElement(By.xpath("//tr[@class='first last odd']//h2[@class='product-name']//a[text()='"+productToCart+"']")).getText();
        assertThat("Succes messege is not display",product,is(productToCart.toUpperCase()));

        WebElement productNameInCart = driver.findElement(By.xpath(("//table[@id='shopping-cart-table']//a[text()='"+productToCart+"']")));
        assertThat("prod",productNameInCart.isDisplayed());




    }
}
