package com.github.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {


    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");


        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.register("juhuh", "jhgjj", "hgygyggygy");

        //driver.quit();


    }

}






