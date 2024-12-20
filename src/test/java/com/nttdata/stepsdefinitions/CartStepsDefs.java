package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CartStepsDefs {

    @Steps
    CartSteps cartSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_sauce_labs() {

    }
    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        cartSteps.validateProductGalleryIsDisplayed();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(int quantity, String productName) {
        cartSteps.addProductToCart(productName, quantity);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        cartSteps.validateCartQuantity();
    }
}
