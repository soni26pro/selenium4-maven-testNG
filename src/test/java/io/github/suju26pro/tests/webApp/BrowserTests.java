package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.ABTestingPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class BrowserTests extends TestSuiteSetup {

  private static final String websiteLink = "http://the-internet.herokuapp.com/";

  @Test
  public void browserNavigationTests() {
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Challenging DOM");
    final ABTestingPage abTestingPage = new ABTestingPage();
    final String abTestingPageHeader = abTestingPage.pageHeader();
    assertEquals(abTestingPageHeader, "Challenging DOM");

    getDriver().navigate()
            .back();
    final String mainPageHeader = mainPage.mainPageHeader();
    assertEquals(mainPageHeader, "Available Examples");

    getDriver().navigate()
            .forward();
    assertEquals(abTestingPageHeader, "Challenging DOM");

    getDriver().navigate()
            .refresh();
    assertEquals(abTestingPageHeader, "Challenging DOM");
  }

  @Test
  public void checkTitleAndWebsiteUrlTest() {
    final String title = "The Internet";
    final String actualWebsiteLink = getDriver().getCurrentUrl();
    final String actualTitle = getDriver().getTitle();

    assertEquals(actualWebsiteLink, websiteLink);
    assertEquals(actualTitle, title);

  }

  @BeforeClass
  public void testSetup() {
    getDriver().get(websiteLink);
  }

}