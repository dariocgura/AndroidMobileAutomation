package com.nttdata.steps;

import com.nttdata.screens.ProductsScreen;
import org.junit.Assert;

public class CartSteps {

    ProductsScreen productsScreen;


    public void validateProductGalleryIsDisplayed() {
        Assert.assertTrue("La galería de productos no está visible", productsScreen.isProductGalleryDisplayed());
    }

    public void addProductToCart(String productName, int quantity) {
        productsScreen.selectProduct(productName);
        for (int i = 1; i < quantity; i++) {
            productsScreen.increaseQuantity();
        }
        productsScreen.addToCart();
    }

    public void validateCartQuantity() {
        int actualQuantity = productsScreen.getCartQuantity(); // Obtén la cantidad actual del carrito
        Assert.assertTrue("La cantidad del carrito debe ser mayor a 0", actualQuantity > 0);
    }


}
