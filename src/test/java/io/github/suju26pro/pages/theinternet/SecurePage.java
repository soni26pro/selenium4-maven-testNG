package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class SecurePage {

  public String getFlashMessage() {
    return getDriver().findElement(By.id("flash"))
            .getText();
  }

  public String getHeaderText() {
    return getDriver().findElement(By.tagName("h2"))
            .getText();
  }

  public String getSubHeaderText() {
    return getDriver().findElement(By.tagName("h4"))
            .getText();
  }

  public WebElement logoutBtn() {
    return getDriver().findElement(By.linkText("Logout"));
  }

}