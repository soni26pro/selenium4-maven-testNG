package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class JSAlertPage {

  private final WebDriverWait wait;
  private Alert alert;

  public JSAlertPage() {
    this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
  }

  public WebElement jsAlertButton() {
    return getDriver().findElement(By.cssSelector("ul > li:nth-child(1) > button"));
  }

  public WebElement jsConfirmButton() {
    return getDriver().findElement(By.cssSelector("ul > li:nth-child(2) > button"));
  }

  public WebElement jspromptButton() {
    return getDriver().findElement(By.cssSelector("ul > li:nth-child(3) > button"));
  }

  public void checkForAlert() {
    this.wait.until(ExpectedConditions.alertIsPresent());
    this.alert = getDriver().switchTo().alert();
  }

  public void acceptAlert() {
    this.alert.accept();
  }

  public void dismissAlert() {
    this.alert.dismiss();
  }

  public String getAlertText() {
    return this.alert.getText();
  }

  public void typeTextInAlert(final String text) {
    this.alert.sendKeys(text);
  }

  public String resultText() {
    return getDriver().findElement(By.id("result")).getText();
  }
}