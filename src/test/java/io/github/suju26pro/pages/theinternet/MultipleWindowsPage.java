package io.github.suju26pro.pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;

public class MultipleWindowsPage {

    private final WebDriverWait wait;

    public MultipleWindowsPage () {
        this.wait = new WebDriverWait (getDriver (), Duration.ofSeconds (10));
    }

    public boolean checkNewWindowTitle (final String newWindowTitle) {
        return this.wait.until (ExpectedConditions.titleIs (newWindowTitle));
    }

    public WebElement link (final String text) {
        return getDriver ().findElement (By.linkText (text));
    }
    
    public void openLinkInNewWindow (final String linkText) {
        final String originalWindow = getDriver ().getWindowHandle ();
        link (linkText).click ();
        this.wait.until (ExpectedConditions.numberOfWindowsToBe (2));
        for (final String windowHandle : getDriver ().getWindowHandles ()) {
            if (!originalWindow.contentEquals (windowHandle)) {
                getDriver ().switchTo ()
                    .window (windowHandle);
                break;
            }
        }
    }

    public WebElement pageHeader () {
        return getDriver ().findElement (By.tagName ("h3"));
    }
}