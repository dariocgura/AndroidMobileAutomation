package com.nttdata.screens;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.nttdata.utils.WaitUtils;


public class ProductsScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    public WebElement ProductsTXT;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]")
    public WebElement SauceLabsBackPack;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Bike Light\"]")
    public WebElement SauceLabsBikeLight;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Bolt T-Shirt\"]")
    public WebElement SauceLabsBoltTShirt;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Fleece Jacket\"]")
    public WebElement SauceLabsFleecejacket;

    private WaitUtils waitUtils;
    public ProductsScreen() {
        waitUtils = new WaitUtils(getDriver(), 10);
    }




    public boolean validarApp(){
        waitUtils.setImplicitWait(10);
        return ProductsTXT.isDisplayed();
    }

    public boolean validarProductos(){



        boolean todosDisponibles = true;
        if (SauceLabsBackPack.isEnabled())
        {
            System.out.println("Esta disponible primer elemento");
        }
        else
        {
            System.out.println("No disponible primer elemento");
            todosDisponibles = false;
        }

        if (SauceLabsBikeLight.isEnabled())
        {
            System.out.println("Esta disponible segundo elemento");
        }
        else
        {
            System.out.println("No disponible segundo elemento");
            todosDisponibles = false;
        }

        if (SauceLabsBoltTShirt.isEnabled())
        {
            System.out.println("Esta disponible tercero elemento");
        }
        else
        {
            System.out.println("No disponible tercero elemento");
            todosDisponibles = false;
        }

        if (SauceLabsFleecejacket.isEnabled())
        {
            System.out.println("Esta disponible cuarto elemento");
        }
        else
        {
            System.out.println("No disponible cuarto elemento");
            todosDisponibles = false;
        }

        return todosDisponibles;


    }

    public void selectProduct(String product) {
        switch (product) {
            case "Sauce Labs Backpack":
                SauceLabsBackPack.click();
                break;
            case "Sauce Labs Bike Light":
                SauceLabsBikeLight.click();
                break;
            case "Sauce Labs Bolt T-Shirt":
                SauceLabsBoltTShirt.click();
                break;
            case "Sauce Labs Fleece Jacket":
                SauceLabsFleecejacket.click();
                break;
            default:
                System.out.println("Producto no encontrado: " + product);
                break;
        }
    }

}


