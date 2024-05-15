package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.KeyPressPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class KeyPressTests extends TestSuiteSetup {

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Key Presses");
  }

  @Test
  public void keyPressTest() {
    final KeyPressPage keyPressPage = new KeyPressPage();
    keyPressPage.pressKeys(Keys.ARROW_DOWN);
    assertEquals(keyPressPage.resultText(), "You entered: DOWN");
    keyPressPage.pressKeys(Keys.F3);
    assertEquals(keyPressPage.resultText(), "You entered: F3");
    keyPressPage.pressKeys(Keys.ALT);
    assertEquals(keyPressPage.resultText(), "You entered: ALT");
    keyPressPage.pressKeys(Keys.CONTROL);
    assertEquals(keyPressPage.resultText(), "You entered: CONTROL");
    keyPressPage.pressKeys(Keys.SPACE);
    assertEquals(keyPressPage.resultText(), "You entered: SPACE");
    keyPressPage.pressKeys(Keys.LEFT_SHIFT);
    assertEquals(keyPressPage.resultText(), "You entered: SHIFT");
  }
}