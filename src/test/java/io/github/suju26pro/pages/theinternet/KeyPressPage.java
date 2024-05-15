package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class KeyPressPage {

  public void pressKeys(final Keys keys) {
    textBox().sendKeys(keys);
  }

  public String resultText() {
    return result().getText();
  }

  private WebElement result() {
    return getDriver().findElement(By.id("result"));
  }

  private WebElement textBox() {
    return getDriver().findElement(By.id("target"));
  }
}