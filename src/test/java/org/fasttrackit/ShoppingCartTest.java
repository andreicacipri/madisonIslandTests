package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {
    @Test
    public void addToCartFromSearchResultsTest(){
        System.setProperty("webdriver.chrome.driver",AppConfig.getChromeDriverPath());

        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());
        Header header = PageFactory.initElements(driver,Header.class);
        String keyword = "vase";
        header.search(keyword);
        System.out.println("Pressed enter in search field. ");

        String productName ="Herald Glass Vase";
        ProductsGrid productsGrid = PageFactory.initElements(driver,ProductsGrid.class);
        productsGrid.addProductToCart(productName,driver);

       String cart = driver.findElement(By.className("success-msg")).getText();

       assertThat("Succes messege is not display",cart,is((""+productName+" was added to your shopping cart.")));
        String product = driver.findElement(By.xpath("//tr[@class='first last odd']//h2[@class='product-name']//a[text()='"+productName+"']")).getText();
        assertThat("Succes messege is not display",product,is(productName.toUpperCase()));

        WebElement productNameInCart = driver.findElement(By.xpath(("//table[@id='shopping-cart-table']//a[text()='"+productName+"']")));
        assertThat("prod",productNameInCart.isDisplayed());




    }
}
