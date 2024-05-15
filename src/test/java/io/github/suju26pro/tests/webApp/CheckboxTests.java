package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.CheckboxPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.*;

public class CheckboxTests extends TestSuiteSetup {

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Checkboxes");
  }

  @Test
  public void testCheckboxes() {
    final CheckboxPage checkboxPage = new CheckboxPage();
    final String pageHeader = checkboxPage.pageHeader();
    assertEquals(pageHeader, "Checkboxes");

    checkboxPage.checkboxOne().click();
    assertTrue(checkboxPage.checkboxOne().isSelected());

    assertTrue(checkboxPage.checkboxTwo().isSelected());

    checkboxPage.checkboxOne().click();
    assertFalse(checkboxPage.checkboxOne().isSelected());

    checkboxPage.checkboxTwo().click();
    assertFalse(checkboxPage.checkboxOne().isSelected());
  }
}