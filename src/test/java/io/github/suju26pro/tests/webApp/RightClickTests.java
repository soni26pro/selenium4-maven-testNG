package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.ContextMenuPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class RightClickTests extends TestSuiteSetup {

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Context Menu");
  }

  @Test
  public void testRightClick() {
    final ContextMenuPage contextMenuPage = new ContextMenuPage();
    contextMenuPage.rightClick();
    contextMenuPage.checkForAlert();
    assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
  }
}