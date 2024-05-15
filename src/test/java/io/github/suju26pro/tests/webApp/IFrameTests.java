package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.IFramePage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class IFrameTests extends TestSuiteSetup {

  @BeforeClass
  public void setupTests() {
    final String website = "http://the-internet.herokuapp.com/";
    getDriver().get(website);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Frames");
    mainPage.clickLink("iFrame");
  }

  @Test
  public void testIFrame() {
    final IFramePage iframe = new IFramePage();
    iframe.switchToiFrame();
    final String text = "Hello 123, entering value in iFrame!!";
    iframe.enterTextInIFrame(text);
    Assert.assertEquals(iframe.getTextValue(), text);
  }
}