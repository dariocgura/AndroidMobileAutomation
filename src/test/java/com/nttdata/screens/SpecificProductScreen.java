package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SpecificProductScreen extends PageObject {

    ProductsScreen productsScreen = new ProductsScreen();

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    public WebElement addItemButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    public WebElement addCarButton;



    public void addProduct(int numberClicks) {

        for (int i = 0; i < numberClicks; i++) {
            addItemButton.click();
        }
    }




    public void addToCar(){

        addCarButton.click();

    }





}
