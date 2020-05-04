package com.github.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTests {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

//        driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("testuser", "testmail", "testpass");
        String mainError = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", mainError);

    }

    @Test
    public void signUpEmptyUsernameTest() {
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String loginError = signUpPage.getUserNameErr();
        Assert.assertEquals("Username can't be blank", loginError);
    }

    @Test
    public void signUpEmptyEmailTest() {
        SignUpPage signUpPage = mainPage.register("ses", "", "pass");
        String loginError = signUpPage.getEmailEmptyErr();
        Assert.assertEquals("Email can't be blank", loginError);
    }

    @Test
    public void signUpEmptyPassTest() {
        SignUpPage signUpPage = mainPage.register("ses", "mail", "");
        String loginError = signUpPage.getPassEmptyErr();
        Assert.assertEquals("Password can't be blank", loginError);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
