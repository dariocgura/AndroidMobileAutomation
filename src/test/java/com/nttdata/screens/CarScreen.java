package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class CarScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]")
    public WebElement productCarTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    public WebElement productCarQty;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    public WebElement carButton;

    public void irACarro() {
        carButton.click();
    }

    public boolean verificoProducto(String producto) {

        String productTxt = productCarTxt.getText();


        if (productTxt.equals(producto)) {

            System.out.println("Añadio correctamente" +" "+producto);
            return true;

        } else {
            System.out.println("No se añadio correctamente");
            return false;
        }



    }
}
