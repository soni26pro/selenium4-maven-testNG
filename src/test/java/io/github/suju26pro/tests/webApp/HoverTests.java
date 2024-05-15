package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.HoverPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class HoverTests extends TestSuiteSetup {

  @BeforeClass
  public void testSetup() {
    final String websiteLink = "http://the-internet.herokuapp.com/";
    getDriver().get(websiteLink);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Hovers");

  }

  @Test
  public void mouseHoverTests() {
    final HoverPage hoverPage = new HoverPage();
    hoverPage.hoverOnImage(hoverPage.imageOne());
    assertEquals(hoverPage.getImageOneName(), "name: user1");

    hoverPage.hoverOnImage(hoverPage.imageTwo());
    assertEquals(hoverPage.getImageTwoName(), "name: user2");

    hoverPage.hoverOnImage(hoverPage.imageThree());
    assertEquals(hoverPage.getImageThreeName(), "name: user3");
  }
}