package com.selenium.pageObject;

import com.example.base.BaseTClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseTClass {
    public static WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Login or register']")
    WebElement cLogReg;

    @FindBy(xpath = "//input[@name='loginname']")
    WebElement iUser;

    @FindBy(xpath = "//input[@name='password']")
    WebElement iPass;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    WebElement btnLogin1;

    @FindBy(xpath = "//span[.='My Account']")
    WebElement veriLog;

    @FindBy(xpath = "//div[@class='alert alert-error alert-danger']")
    WebElement alertMessage;

    String baseUrl;
    public void vHome(){
        String a = driver.getCurrentUrl();
        baseUrl = a;
        Assert.assertEquals(a, baseUrl);
    }
    public void cLogReg(){
        cLogReg.click();
        cLogReg.isDisplayed();
        String a = driver.getCurrentUrl();
        assertTrue(a.contains("account/login"));
    }

    public void inUserPass(String username, String password){
        iUser.sendKeys(username);
        iPass.sendKeys(password);
    }

    public void btnLogin(){
        btnLogin1.click();
    }

    public void assertLogin(){
        veriLog.isDisplayed();
        Assert.assertEquals(veriLog.getText(),"MY ACCOUNT");
    }

    public void assertVailed(){
        String a = alertMessage.getText();
        Assert.assertEquals("×\nError: Incorrect login or password provided.",a);
    }



}
