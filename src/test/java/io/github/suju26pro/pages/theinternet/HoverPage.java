package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class HoverPage {

  public String getImageOneName() {
    return getDriver().findElement(By.cssSelector("div:nth-child(3) > div > h5"))
            .getText();
  }

  public String getImageThreeName() {
    return getDriver().findElement(By.cssSelector("div:nth-child(5) > div > h5"))
            .getText();
  }

  public String getImageTwoName() {
    return getDriver().findElement(By.cssSelector("div:nth-child(4) > div > h5"))
            .getText();
  }

  public void hoverOnImage(final WebElement element) {
    final Actions action = new Actions(getDriver());
    action.moveToElement(element)
            .click()
            .build()
            .perform();
  }

  public WebElement imageOne() {
    return getDriver().findElement(By.cssSelector("div:nth-child(3) > img"));
  }

  public WebElement imageThree() {
    return getDriver().findElement(By.cssSelector("div:nth-child(5) > img"));
  }

  public WebElement imageTwo() {
    return getDriver().findElement(By.cssSelector("div:nth-child(4) > img"));
  }
}