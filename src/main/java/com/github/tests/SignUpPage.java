package com.github.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By mainError = By.xpath("//div[contains(text(),'There were problems creating your account.')]");
    private final By heading = By.xpath("//h1[contains(text(),'Create your account')]");

    private final By userNameLabel = By.xpath("//label[@name='user[login]");
    private final By userNameField = By.xpath("//input[@id='user_login']");
    private final By userNameEmptyErr = By.xpath("//dd[contains(text(),\"Username can't be blank\")]"); //Username can't be blank
    private final By userNameWrongErr = By.xpath("//div[contains(@class,'mb-1')]");

    private final By emailLabel = By.xpath("//label[@name='user[email]");
    private final By emailField = By.xpath("//input[@id='user_email']");
    private final By emailEmptyErr = By.xpath("//dd[contains(text(),\"Email can't be blank\")]");  //Email can't be blank
    private final By emailWrongErr = By.xpath("//dd[@id='input-check-372']");    //Email is invalid or already taken

    private final By passwordLabel = By.xpath("//label[@name='user[password]");
    private final By passwordField = By.xpath("//input[@id='user_password']");
    private final By passwordEmptyErr = By.xpath("//dd[contains(text(),\"Password can't be blank\")]");    //Password can't be blank

    private final By signUpButton = By.xpath("//body/div/main/div/div/div/form[@id='signup-form']/div[3]");

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String username) {
        driver.findElement(passwordField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String username) {
        driver.findElement(emailField).sendKeys(username);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameErr() {
        return driver.findElement(userNameEmptyErr).getText();
    }

    public String getEmailEmptyErr() {
        return driver.findElement(emailEmptyErr).getText();
    }

    public String getPassEmptyErr() {
        return driver.findElement(passwordEmptyErr).getText();
    }




}
