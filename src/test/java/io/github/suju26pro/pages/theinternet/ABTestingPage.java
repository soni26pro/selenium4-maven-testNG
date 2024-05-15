package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class ABTestingPage {

  public String pageHeader() {
    return getDriver().findElement(By.tagName("h3"))
            .getText();
  }
}