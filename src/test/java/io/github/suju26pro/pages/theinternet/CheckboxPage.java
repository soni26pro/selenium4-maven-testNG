package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class CheckboxPage {

  public WebElement checkboxOne() {
    return checkboxes().get(0);
  }

  public WebElement checkboxTwo() {
    return checkboxes().get(1);
  }

  public String pageHeader() {
    return getDriver().findElement(By.tagName("h3"))
            .getText();
  }

  private List<WebElement> checkboxes() {
    return getDriver().findElements(By.cssSelector("#checkboxes > input[type=checkbox]"));
  }
}