package io.github.suju26pro.tests.base;

import io.github.suju26pro.enums.Browsers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static io.github.suju26pro.drivers.WebDriverFactory.createDriver;
import static io.github.suju26pro.drivers.WebDriverFactory.quitDriver;

/**
 * This class handles the setup and teardown operations for test suites based on the specified browser.
 */
public class TestSuiteSetup {

  /**
   * Sets up the test suite with the specified browser.
   *
   * @param browser The browser to be used for the test suite.
   */
  @Parameters("browser")
  @BeforeClass(alwaysRun = true)
  public void setupTestSuite(final String browser) {
    createDriver(Browsers.valueOf(browser.toUpperCase()));
  }

  /**
   * Tears down the test suite.
   */
  @AfterClass(alwaysRun = true)
  public void tearDownTestSuite() {
    quitDriver();
  }
}
