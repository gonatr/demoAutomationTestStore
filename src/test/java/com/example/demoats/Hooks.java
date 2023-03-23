package com.example.demoats;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    public static Properties properties;

    public Hooks(){
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream("src\\test\\java\\com\\example\\config\\config.properties");
            properties.load(inputStream);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Before
    public void setBrowser(){
        System.out.println("Starting Driver");

        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--remote-allow-origins=*");
        chrome_options.addArguments("--start-maximized");
        chrome_options.addArguments("--disable-extensions");
        chrome_options.addArguments("--disable-web-security");
        chrome_options.addArguments("--disable-popup-blocking");
        chrome_options.addArguments("--ignore-certificate-errors");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chrome_options);
        driver.get(properties.getProperty("baseUrl"));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
