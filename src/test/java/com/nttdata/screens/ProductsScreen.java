package com.nttdata.screens;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductsScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement allProducts;

    private String productByName = "//android.widget.ImageView[@content-desc='%s']";

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement btnIncreaseQuantity;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAddToCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/cartTV\"]")
    private WebElement btnCartBadge;

    public boolean isProductGalleryDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(allProducts));
        return allProducts.isDisplayed();
    }

    public void selectProduct(String productName) {
        String productXPath = String.format(productByName, productName);
        WebElement product = null;

        try {
            product = findBy(productXPath);
            waitFor(ExpectedConditions.visibilityOf(product));
            product.click();
        } catch (NoSuchElementException e) {
            // Si el producto no se encuentra, registramos el error y lo reportamos
            throw new NoSuchElementException("Product not found: " + productName);
        } catch (WebDriverException e) {
            // Si hay un error relacionado con el WebDriver (por ejemplo, un crash de la app)
            throw new WebDriverException("Error during click on product: " + productName, e);
        } catch (Exception e) {
            // Cualquier otro error inesperado
            throw new RuntimeException("Unexpected error during product selection: " + productName, e);
        }
    }

    public void increaseQuantity() {

        btnIncreaseQuantity.click();
    }

    public void addToCart() {

        btnAddToCart.click();
    }

    public int getCartQuantity() {
        String quantityText = btnCartBadge.getText();
        return Integer.parseInt(quantityText);
    }
}


