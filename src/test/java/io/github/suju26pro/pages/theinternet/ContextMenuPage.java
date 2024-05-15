package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class ContextMenuPage {

  private Alert alert;

  public void checkForAlert() {
    final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.alertIsPresent());
    this.alert = getDriver().switchTo()
            .alert();
  }

  public String getAlertText() {
    return this.alert.getText();
  }

  public void rightClick() {
    final Actions actions = new Actions(getDriver());
    actions.contextClick(box())
            .perform();
  }

  private WebElement box() {
    return getDriver().findElement(By.id("hot-spot"));
  }
}