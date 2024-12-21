package com.nttdata.steps;

import com.nttdata.screens.CarScreen;
import com.nttdata.screens.ProductsScreen;
import com.nttdata.screens.SpecificProductScreen;
import org.junit.Assert;

public class ShopSteps {

    ProductsScreen productsScreen = new ProductsScreen();

    SpecificProductScreen specificProductScreen = new SpecificProductScreen();
    CarScreen carScreen = new CarScreen();

    public void isAppReady(){
        System.out.println("App is ready");
        Assert.assertTrue(productsScreen.validarApp());
    }


    //    Valida este disponible los productos

    public void isProductDisplay(){

        Assert.assertTrue(productsScreen.validarProductos());

    }
//Selecciona e ingresa el producto

    public void selectAndAdd(int unidades, String producto){
        productsScreen.selectProduct(producto);

        specificProductScreen.addProduct(unidades);

        specificProductScreen.addToCar();


    }
    //Ingresa al carrito y verifica el producto
    public void verificoCar(String producto){
        carScreen.irACarro();
        Assert.assertTrue(carScreen.verificoProducto(producto));
    }

}
