package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class DragAndDropPage {

  private final Actions action;

  public DragAndDropPage() {
    this.action = new Actions(getDriver());
  }

  public void dragBoxADropInBoxB() {
    this.action.dragAndDrop(boxA(), boxB())
            .build()
            .perform();
  }

  public void dragBoxBDropInBoxA() {
    this.action.dragAndDrop(boxB(), boxA())
            .build()
            .perform();
  }

  public String getHeaderOfBoxA() {
    final WebElement header = getDriver().findElement(By.cssSelector("#column-a > header"));
    return header.getText();
  }

  public String getHeaderOfBoxB() {
    final WebElement header = getDriver().findElement(By.cssSelector("#column-b > header"));
    return header.getText();
  }

  private WebElement boxA() {
    return getDriver().findElement(By.id("column-a"));
  }

  private WebElement boxB() {
    return getDriver().findElement(By.id("column-b"));
  }
}