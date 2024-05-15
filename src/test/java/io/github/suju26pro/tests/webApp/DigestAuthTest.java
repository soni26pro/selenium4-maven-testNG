package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class DigestAuthTest extends TestSuiteSetup {

    @BeforeClass
    public void testSetup() {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        final MainPage mainPage = new MainPage();
        mainPage.clickLink("Basic Auth");
    }

    @Test
    public void testAuthentication() {
        getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        final String successMessageText = getDriver().findElement(By.cssSelector(".example p")).getText();
        assertEquals(successMessageText, "Congratulations! You must have the proper credentials.");
    }
}