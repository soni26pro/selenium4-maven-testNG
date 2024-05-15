package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.DropdownPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class DropdownTests extends TestSuiteSetup {

  private DropdownPage dropdownPage;

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Dropdown");
    this.dropdownPage = new DropdownPage();
  }

  @Test
  public void selectByOptionTest() {
    final String visibleText = "Option 1";
    this.dropdownPage.dropDownbox().selectByVisibleText("Option 1");
    assertEquals(this.dropdownPage.getSelectedOption(), visibleText);
  }

  @Test
  public void selectByIndexText() {
    this.dropdownPage.dropDownbox().selectByIndex(1);
    assertEquals(this.dropdownPage.getSelectedOption(), "Option 1");
  }

  @Test
  public void selectByValueTest() {
    this.dropdownPage.dropDownbox().selectByValue("1");
    assertEquals(this.dropdownPage.getSelectedOption(), "Option 1");
  }
}