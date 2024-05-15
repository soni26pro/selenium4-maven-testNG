package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class FormAuthenticationPage {

  public String getFlashMessage() {
    return getDriver().findElement(By.id("flash"))
            .getText();
  }

  public SecurePage login(final String userName, final String password) {
    userNameField().click();
    userNameField().clear();
    userNameField().sendKeys(userName);
    passwordField().click();
    passwordField().clear();
    passwordField().sendKeys(password);
    loginBtn().click();
    return new SecurePage();
  }

  private WebElement loginBtn() {
    return getDriver().findElement(By.cssSelector("#login > button"));
  }

  private WebElement passwordField() {
    return getDriver().findElement(By.id("password"));
  }

  private WebElement userNameField() {
    return getDriver().findElement(By.id("username"));
  }
}