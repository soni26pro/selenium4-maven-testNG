package io.github.suju26pro.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Builder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.log.Log;

import java.util.Objects;

/**
 * Manager class for handling Chrome WebDriver and DevTools setup.
 */
@Builder
public final class ChromeDevToolsManager {

  private static final Logger LOG = LogManager.getLogger("DevToolsSetup.class");
  private static ChromeDriver chromeDriver;

  private ChromeDevToolsManager() {
    // Private constructor to prevent instantiation
  }

  /**
   * Creates a Chrome WebDriver instance with configured DevTools.
   */
  public static void createDriver() {
    final boolean isHeadless = Boolean.parseBoolean(
            Objects.requireNonNullElse(System.getProperty("headless"), "true"));
    WebDriverManager.chromedriver()
            .setup();
    final ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--window-size=1050,600");
    if (isHeadless) {
      options.addArguments("--headless");
    }
    options.addArguments("--safebrowsing-disable-download-protection");

    chromeDriver = new ChromeDriver(options);
    final DevTools chromeDevTools = chromeDriver.getDevTools();
    chromeDevTools.createSession();
    chromeDevTools.send(Log.enable());
    chromeDevTools.addListener(Log.entryAdded(), logEntry -> {
      LOG.error(logEntry.getText());
      LOG.error(logEntry.getLevel());
    });
  }

  /**
   * Retrieves the created Chrome WebDriver instance.
   *
   * @return The Chrome WebDriver instance
   */
  public static ChromeDriver getDriver() {
    return chromeDriver;
  }

  /**
   * Quits the Chrome WebDriver instance.
   */
  public static void quitDriver() {
    if (null != chromeDriver) {
      chromeDriver.quit();
    }
  }
}