package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.DragAndDropPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class DragAndDropTests extends TestSuiteSetup {

  private DragAndDropPage dragAndDropPage;

  @BeforeClass
  public void setupTests() {
    final String website = "http://the-internet.herokuapp.com/";
    getDriver().get(website);
    final MainPage mainPage = new MainPage();
    mainPage.clickLink("Drag and Drop");
    this.dragAndDropPage = new DragAndDropPage();
  }

  @Test
  public void dragAndDropBoxAToB() {
    this.dragAndDropPage.dragBoxADropInBoxB();
    assertEquals(this.dragAndDropPage.getHeaderOfBoxA(), "B");
    assertEquals(this.dragAndDropPage.getHeaderOfBoxB(), "A");
  }

  @Test
  public void dragAndDropBoxBToA() {
    this.dragAndDropPage.dragBoxBDropInBoxA();
    assertEquals(this.dragAndDropPage.getHeaderOfBoxA(), "A");
    assertEquals(this.dragAndDropPage.getHeaderOfBoxB(), "B");
  }
}