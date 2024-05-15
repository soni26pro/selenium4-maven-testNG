package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.JSAlertPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class JSAlertTests extends TestSuiteSetup {

  private JSAlertPage jsAlertPage;

  @BeforeClass
  private void setupTest() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("JavaScript Alerts");
    this.jsAlertPage = new JSAlertPage();
  }

  @Test
  public void alertTest() {
    this.jsAlertPage.jsAlertButton().click();
    this.jsAlertPage.checkForAlert();
    final String alertText = this.jsAlertPage.getAlertText();
    assertEquals(alertText, "I am a JS Alert");
    this.jsAlertPage.acceptAlert();
    assertEquals(this.jsAlertPage.resultText(), "You successfully clicked an alert");
  }

  @Test
  public void confirmAlertTest() {
    this.jsAlertPage.jsConfirmButton().click();
    this.jsAlertPage.checkForAlert();
    final String alertText = this.jsAlertPage.getAlertText();
    assertEquals(alertText, "I am a JS Confirm");
    this.jsAlertPage.acceptAlert();
    assertEquals(this.jsAlertPage.resultText(), "You clicked: Ok");
  }

  @Test
  public void dismissAlertTest() {
    this.jsAlertPage.jsConfirmButton().click();
    this.jsAlertPage.checkForAlert();
    final String alertText = this.jsAlertPage.getAlertText();
    assertEquals(alertText, "I am a JS Confirm");
    this.jsAlertPage.dismissAlert();
    assertEquals(this.jsAlertPage.resultText(), "You clicked: Cancel");
  }

  @Test
  public void jsPromptTypeAndAcceptTest() {
    this.jsAlertPage.jspromptButton().click();
    this.jsAlertPage.checkForAlert();
    final String alertText = this.jsAlertPage.getAlertText();
    assertEquals(alertText, "I am a JS prompt");
    final String text = "Testing by typing text in JS Alert";
    this.jsAlertPage.typeTextInAlert(text);
    this.jsAlertPage.acceptAlert();
    assertEquals(this.jsAlertPage.resultText(), "You entered: " + text);
  }

  @Test
  public void jsPromptDismissTest() {
    this.jsAlertPage.jspromptButton().click();
    this.jsAlertPage.checkForAlert();
    final String alertText = this.jsAlertPage.getAlertText();
    assertEquals(alertText, "I am a JS prompt");
    this.jsAlertPage.dismissAlert();
    assertEquals(this.jsAlertPage.resultText(), "You entered: null");
  }
}