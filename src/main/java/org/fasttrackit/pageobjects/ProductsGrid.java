package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGrid {

    @FindBy(css = "h2.product-name >a")
    private List<WebElement> productNameContainers;


    public List<WebElement> getProductNameContainers() {
        return productNameContainers;
    }
}
