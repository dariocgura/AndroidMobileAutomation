package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ShopSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CartStepsDefs {

    @Steps
    ShopSteps shopSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_sauce_labs() {
        shopSteps.isAppReady();

    }
    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        shopSteps.isProductDisplay();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(int quantity, String productName) {
        shopSteps.selectAndAdd(quantity, productName);
    }




    @Then("valido el carrito de compra actualice correctamente {string}")
    public void validoElCarritoDeCompraActualiceCorrectamente(String producto) {
        shopSteps.verificoCar(producto);
    }
}
