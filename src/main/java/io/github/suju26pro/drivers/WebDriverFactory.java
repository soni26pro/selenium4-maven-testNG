package io.github.suju26pro.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.suju26pro.enums.Browsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

/**
 * Factory class for creating WebDriver instances based on different browsers.
 */
public final class WebDriverFactory {

  private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
  private static final String HUB_URL = "http://localhost:4444/wd/hub";
  private static final Logger LOG = LogManager.getLogger("DriverManager.class");
  private static final String NO_SANDBOX = "--no-sandbox";
  private static final String DISABLE_DEV_SHM = "--disable-dev-shm-usage";
  private static final String CUSTOM_WINDOW_SIZE = "--window-size=1050,600";
  private static final String HEADLESS = "--headless";

  private WebDriverFactory() {
    // Private constructor to prevent instantiation
  }

  /**
   * Creates a WebDriver instance based on the specified browser.
   *
   * @param browser The browser to be used for creating the WebDriver instance
   */
  public static void createDriver(final Browsers browser) {
    switch (browser) {
      case FIREFOX -> setupFirefoxDriver();
      case EDGE -> setupEdgeDriver();
      case OPERA -> setupOperaDriver();
      case REMOTE_CHROME -> setupRemoteChrome();
      case REMOTE_FIREFOX -> setupRemoteFirefox();
      case REMOTE_EDGE -> setupRemoteEdge();
      default -> setupChromeDriver();
    }
    setupBrowserTimeouts();
  }

  /**
   * Retrieves the WebDriver instance.
   *
   * @return The WebDriver instance
   */
  public static WebDriver getDriver() {
    return DRIVER.get();
  }

  /**
   * Sets the WebDriver instance.
   *
   * @param driver The WebDriver instance to be set
   */
  private static void setDriver(final WebDriver driver) {
    DRIVER.set(driver);
  }

  /**
   * Quits the WebDriver instance.
   */
  public static void quitDriver() {
    if (null != DRIVER.get()) {
      LOG.info("Closing the driver...");
      getDriver().quit();
      DRIVER.remove();
    }
  }

  /**
   * Sets up browser timeouts.
   */
  private static void setupBrowserTimeouts() {
    LOG.info("Setting Browser Timeouts....");
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
  }

  /**
   * Sets up Chrome WebDriver.
   */
  private static void setupChromeDriver() {
    LOG.info("Setting up Chrome Driver....");
    final var isHeadless = Boolean.parseBoolean(Objects.requireNonNullElse(System.getProperty("headless"), "true"));
    final var chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("safebrowsing.enabled", "true");
    chromePrefs.put("download.prompt_for_download", "false");
    chromePrefs.put("download.default_directory", String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));

    final var options = new ChromeOptions();
    options.addArguments(NO_SANDBOX);
    options.addArguments(DISABLE_DEV_SHM);
    options.addArguments(CUSTOM_WINDOW_SIZE);
    if (isHeadless) {
      options.addArguments(HEADLESS);
    }
    options.addArguments("--safebrowsing-disable-download-protection");
    options.setExperimentalOption("prefs", chromePrefs);

    setDriver(WebDriverManager.chromedriver().capabilities(options).create());
    LOG.info("Chrome Driver created successfully!");
  }

  /**
   * Sets up Edge WebDriver.
   */
  private static void setupEdgeDriver() {
    LOG.info("Setting up Edge Driver....");
    setDriver(WebDriverManager.edgedriver().create());
    LOG.info("Edge Driver created successfully!");
  }

  /**
   * Sets up Firefox WebDriver.
   */
  private static void setupFirefoxDriver() {
    LOG.info("Setting up Firefox Driver....");
    final var options = new FirefoxOptions();
    options.addArguments(NO_SANDBOX);
    options.addArguments(DISABLE_DEV_SHM);
    options.addArguments(CUSTOM_WINDOW_SIZE);
    options.addArguments(HEADLESS);
    setDriver(WebDriverManager.firefoxdriver().capabilities(options).create());
    LOG.info("Firefox Driver created successfully!");
  }

  /**
   * Sets up Opera WebDriver.
   */
  private static void setupOperaDriver() {
    LOG.info("Setting up Opera Driver....");
    setDriver(WebDriverManager.operadriver().create());
    LOG.info("Opera Driver created successfully!");
  }

  /**
   * Sets up Remote Chrome WebDriver.
   */
  private static void setupRemoteChrome() {
    try {
      LOG.info("Setting up Remote Chrome Driver....");
      final var options = new ChromeOptions();
      options.addArguments(NO_SANDBOX);
      options.addArguments(DISABLE_DEV_SHM);
      setDriver(new RemoteWebDriver(new URL(HUB_URL), options));
      LOG.info("Remote Chrome Driver created successfully!");
    } catch (final MalformedURLException e) {
      LOG.error("Error setting remote_chrome", e);
    }
  }

  /**
   * Sets up Remote Edge WebDriver.
   */
  private static void setupRemoteEdge() {
    try {
      LOG.info("Setting up Remote Edge Driver....");
      final var edgeOptions = new EdgeOptions();
      edgeOptions.addArguments(NO_SANDBOX);
      edgeOptions.addArguments(DISABLE_DEV_SHM);
      setDriver(new RemoteWebDriver(new URL(HUB_URL), edgeOptions));
      LOG.info("Remote Edge Driver created successfully!");
    } catch (final MalformedURLException e) {
      LOG.error("Error setting remote_edge", e);
    }
  }

  /**
   * Sets up Remote Firefox WebDriver.
   */
  private static void setupRemoteFirefox() {
    try {
      LOG.info("Setting up Remote Firefox Driver....");
      final var firefoxOptions = new FirefoxOptions();
      firefoxOptions.addArguments(NO_SANDBOX);
      firefoxOptions.addArguments(DISABLE_DEV_SHM);
      setDriver(new RemoteWebDriver(new URL(HUB_URL), firefoxOptions));
      LOG.info("Remote Firefox Driver created successfully!");
    } catch (final MalformedURLException e) {
      LOG.error("Error setting remote_firefox", e);
    }
  }
}
