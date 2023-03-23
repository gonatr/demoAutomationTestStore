package com.example.base;

import org.openqa.selenium.WebDriver;

public class BaseTClass {
    public static WebDriver driver;

    public BaseTClass(WebDriver driver){
        BaseTClass.driver = driver;
    }

}
