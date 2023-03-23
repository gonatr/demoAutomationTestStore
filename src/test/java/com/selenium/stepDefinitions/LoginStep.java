package com.selenium.stepDefinitions;

import com.example.demoats.Hooks;
import com.selenium.pageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    public static WebDriver driver;
    public LoginStep(){
        this.driver = Hooks.driver;
    }

    LoginPage log;
    @Given("User on Page Automation Test Store")
    public void userOnPageLuna() {
        log = new LoginPage(driver);
        log.vHome();
    }

    @And("User click sign")
    public void userClickSign() {
        log.cLogReg();
    }

    @When("^User Input set username (.*), set password (.*) click login btn$")
    public void userInputSetUsernameTest_user_wsbAndSetPasswordTest_pass_wsb(String username, String password) {
        log.inUserPass(username, password);
        log.btnLogin();
    }

    @And("User click Btn Login")
    public void userClickBtnLogin() {
        log.btnLogin();
    }

    @Then("User get the result Resource")
    public void userGetTheResultResource() {
        String asertLogin = driver.getCurrentUrl();
        if(asertLogin.contains("account/account")){
            log.assertLogin();
        } else if (asertLogin.contains("account/login")){
            log.assertVailed();
        }
    }

    @When("^User input user (.*), pass (.*) and click login btn$")
    public void userInputUsernameAndPassword(String username, String password) {
        log.inUserPass(username, password);
        log.btnLogin();
    }
}
