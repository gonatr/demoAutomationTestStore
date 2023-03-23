package com.selenium.stepDefinitions;

import com.example.demoats.Hooks;
import com.selenium.pageObject.AddToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddToCart {
    public static WebDriver driver;

    public AddToCart(){
        this.driver = Hooks.driver;
    }

    AddToCartPage addItem;

    @When("User click Apparel & accessories")
    public void userClickApparelAccessories() {
        addItem = new AddToCartPage(driver);
        addItem.sProductItems();
    }

    @And("User click Shooes")
    public void userClickShooes() {
        addItem.cProductItem();
    }

    @And("User choose product Items")
    public void userChooseProductItems() {
        addItem.selectProduct();
    }

    @And("User set Size, Colour, QTY and click add to chart button")
    public void userSetSizeColourAndQTY() {
        addItem.setItems();
    }

    @And("User confirm Item click checkout")
    public void userConfirmItemClickCheckout() {
        addItem.assertCart();
        addItem.cObtn();
    }

    @Then("User get the result Items")
    public void userGetTheResultItems() {
        addItem.messageSuccessOrder();
    }
}
