package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.pages.theinternet.MultipleWindowsPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertTrue;

public class MultipleWindowTests extends TestSuiteSetup {

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Multiple Windows");
  }

  @Test
  public void testMultipleWindows() throws InterruptedException {
    final MultipleWindowsPage multipleWindowPage = new MultipleWindowsPage();
    multipleWindowPage.openLinkInNewWindow("Click Here");
    assertTrue(multipleWindowPage.checkNewWindowTitle("New Window"));
  }
}