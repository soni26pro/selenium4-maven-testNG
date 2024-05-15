package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class MainPage {

  public void clickLink(final String linkName) {
    final WebElement link = getDriver().findElement(By.linkText(linkName));
    link.click();
  }

  public String mainPageHeader() {
    return getDriver().findElement(By.tagName("h2"))
            .getText();
  }

}