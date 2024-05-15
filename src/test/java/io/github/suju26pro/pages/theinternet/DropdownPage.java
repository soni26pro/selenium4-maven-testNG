package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class DropdownPage {

  public Select dropDownbox() {
    final WebElement dropdown = getDriver().findElement(By.id("dropdown"));
    return new Select(dropdown);
  }

  public String getSelectedOption() {
    return dropDownbox().getFirstSelectedOption()
            .getText();
  }
}