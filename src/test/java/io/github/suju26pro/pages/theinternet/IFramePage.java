package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class IFramePage {

  public void enterTextInIFrame(final String text) {
    textArea().click();
    textArea().clear();
    textArea().sendKeys(text);
  }

  public String getTextValue() {
    return getDriver().findElement(By.cssSelector("#tinymce > p"))
            .getText();
  }

  public void switchToiFrame() {
    getDriver().switchTo()
            .frame(iFrame());
  }

  private WebElement iFrame() {
    return getDriver().findElement(By.id("mce_0_ifr"));
  }

  private WebElement textArea() {
    return getDriver().findElement(By.id("tinymce"));
  }
}