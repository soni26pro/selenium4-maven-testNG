package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.FormAuthenticationPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.pages.theinternet.SecurePage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormAuthenticationTests extends TestSuiteSetup {

  private static final String PASSWORD = "SuperSecretPassword!";
  private static final String USERNAME = "tomsmith";
  private FormAuthenticationPage formAuthenticationPage;
  private SecurePage securePage;

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Form Authentication");
    this.formAuthenticationPage = new FormAuthenticationPage();
  }

  @Test
  public void blankUserAndPasswordTest() {
    this.formAuthenticationPage.login(" ", " ");
    assertTrue(this.formAuthenticationPage.getFlashMessage()
            .contains("Your username is invalid!"));
  }

  @Test
  public void invalidLoginCredentialsTest() {
    this.formAuthenticationPage.login(USERNAME, "InvalidPass");
    assertTrue(this.formAuthenticationPage.getFlashMessage()
            .contains("Your password is invalid!"));
  }

  @DataProvider
  public Iterator<Object[]> loginData() {
    final List<Object[]> testData = new ArrayList<>();
    testData.add(new Object[]{" ", PASSWORD, false});
    testData.add(new Object[]{USERNAME, " ", false});
    testData.add(new Object[]{" ", " ", false});
    testData.add(new Object[]{USERNAME, "invalid", false});
    testData.add(new Object[]{USERNAME, PASSWORD, true});
    return testData.iterator();
  }

  @Test(dataProvider = "loginData")
  public void loginTests(final String userName, final String password, final boolean isValid) {
    this.securePage = this.formAuthenticationPage.login(userName, password);

    if (!isValid) {
      assertTrue(this.formAuthenticationPage.getFlashMessage()
              .contains(" is invalid!"));
    } else {
      assertTrue(this.securePage.getFlashMessage()
              .contains("You logged into a secure area!"));
      assertEquals(this.securePage.getHeaderText(), "Secure Area");
      assertEquals(this.securePage.getSubHeaderText(),
              "Welcome to the Secure Area. When you are done click logout below.");
      assertTrue(this.securePage.logoutBtn()
              .isDisplayed());
      this.securePage.logoutBtn()
              .click();
      assertTrue(this.formAuthenticationPage.getFlashMessage()
              .contains("You logged out of the secure area!"));
    }
  }

  @Test
  public void loginWithCorrectCredentials() {
    this.securePage = this.formAuthenticationPage.login(USERNAME, PASSWORD);
    assertTrue(this.securePage.getFlashMessage()
            .contains("You logged into a secure area!"));
    assertEquals(this.securePage.getHeaderText(), "Secure Area");
    assertEquals(this.securePage.getSubHeaderText(),
            "Welcome to the Secure Area. When you are done click logout below.");
    assertTrue(this.securePage.logoutBtn()
            .isDisplayed());
  }

  @Test
  public void passwordNotValidTest() {
    this.formAuthenticationPage.login(USERNAME, " ");
    assertTrue(this.formAuthenticationPage.getFlashMessage()
            .contains("Your password is invalid!"));
  }

  @Test
  public void userNameNotValidTest() {
    this.formAuthenticationPage.login(" ", PASSWORD);
    assertTrue(this.formAuthenticationPage.getFlashMessage()
            .contains("Your username is invalid!"));
  }
}