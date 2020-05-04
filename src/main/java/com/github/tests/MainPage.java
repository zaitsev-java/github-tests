package com.github.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signInButton = By.xpath("//a[contains(text(),'Sign in')]");
    private final By signUpButton = By.xpath("//body//header//a[2]");

    private final By userNameField = By.id("user[login]");
    private final By emailField = By.id("user[email]");
    private final By passwordField = By.id("user[password]");

    //    private final By signUpFormButton = By.xpath("//button[@data-ga-click=\"Signup, Attempt, location:home hero\"]");
    private final By signUpFormButton = By.xpath("//html//body//div//main//div//div//form//div//div//button[contains(text(),'Sign up for GitHub')]");


    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }


    public MainPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typePassword(String username) {
        driver.findElement(passwordField).sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String username) {
        driver.findElement(emailField).sendKeys(username);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpButton();
        return new SignUpPage(driver);
    }
}
