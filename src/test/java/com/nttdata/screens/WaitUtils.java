package com.nttdata.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait explicitWait;

    // Constructor para inicializar el WebDriver y configuraciones de espera
    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Configurar espera implícita
    public void setImplicitWait(int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    }

    // Espera explícita para visibilidad de un elemento
    public WebElement waitForVisibility(WebElement element) {
        return explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    // Espera explícita para que un elemento sea clickeable
    public WebElement waitForClickability(WebElement element) {
        return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Método para manejar excepciones si el elemento no es encontrado
    public boolean isElementVisible(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Elemento no visible: " + e.getMessage());
            return false;
        }
    }
}