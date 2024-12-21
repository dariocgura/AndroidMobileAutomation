Feature: app test

  @test_success
  Scenario Outline: Agregar productos al carrito

    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente "<PRODUCTO>"

    Examples:
      | PRODUCTO                  | PRODUCTO                  | UNIDADES |
      | Sauce Labs Backpack       | Sauce Labs Backpack       | 1        |
      | Sauce Labs Bolt - T-Shirt | Sauce Labs Bolt - T-Shirt | 1        |
      | Sauce Labs Bike Light     | Sauce Labs Bike Light     | 2        |
