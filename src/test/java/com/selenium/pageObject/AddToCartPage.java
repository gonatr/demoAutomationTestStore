package com.selenium.pageObject;

import com.example.base.BaseTClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class AddToCartPage extends BaseTClass {
    public static WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='nav-pills categorymenu']//a[contains(.,'Apparel & accessories')]")
    WebElement sProduct;

    @FindBy(xpath = "//a[contains(.,'Shoes')]")
    WebElement cProduct;

    @FindBy(xpath = "//div[@class='thumbnails grid row list-inline']//img[@src='//automationteststore.com/image/thumbnails/18/78/shoe_1_jpg-100228-250x250.jpg']")
    WebElement selProduct;

    @FindBy(xpath = "//input[@value='747']")
    WebElement sSize;

    @FindBy(xpath = "//select[@name='option[346]']")
    WebElement sColour;

    @FindBy(xpath = "//input[@id='product_quantity']")
    WebElement sQty;

    @FindBy(xpath = "//i[@class='fa fa-cart-plus fa-fw']")
    WebElement addCart;

    @FindBy(xpath = "//a[@id='cart_checkout1']")
    WebElement btnCheckout;

    @FindBy(xpath = "//button[@id='checkout_btn']")
    WebElement confirmBtn;

    @FindBy(xpath = "//span[@class='maintext']")
    WebElement verifText1;

    @FindBy(xpath = "//span[@class='maintext']")
    WebElement verifTextSuccess;


    public void sProductItems(){
        Actions a = new Actions(driver);
        a.moveToElement(sProduct).perform();
    }

    public void cProductItem(){
        Actions a = new Actions(driver);
        a.moveToElement(cProduct).perform();
        cProduct.isDisplayed();
        cProduct.click();
    }

    public void selectProduct(){
        selProduct.click();
    }

    public void setItems(){
        Select a = new Select(sColour);
        a.selectByValue("761");
        sQty.click();
        sQty.clear();
        sQty.sendKeys("2");
        sQty.isDisplayed();
        addCart.click();
    }

    public void assertCart(){
        String a = driver.getCurrentUrl();
        assertTrue(a.contains("checkout/cart"));
    }

    public void cObtn(){
        btnCheckout.click();
        String a = driver.getCurrentUrl();
        assertTrue(a.contains("checkout/confirm"));
        verifText1.isDisplayed();
        String b = verifText1.getText();
        Assert.assertEquals("CHECKOUT CONFIRMATION", b);
        confirmBtn.click();
    }

    public void messageSuccessOrder(){
        String c = driver.getCurrentUrl();
        assertTrue(c.contains("checkout/confirm"));
        verifTextSuccess.isDisplayed();
    }



}
