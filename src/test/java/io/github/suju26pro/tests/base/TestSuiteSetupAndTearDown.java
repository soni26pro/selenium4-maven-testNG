package io.github.suju26pro.tests.base;

import io.github.suju26pro.drivers.ChromeDevToolsManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * This class handles the setup and tear-down operations for test suites using Chrome DevTools.
 */
public class TestSuiteSetupAndTearDown {

    /**
     * Sets up the test suite by creating a Chrome DevTools driver.
     */
    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        ChromeDevToolsManager.createDriver();
    }

    /**
     * Tears down the test suite by quitting the Chrome DevTools driver.
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        ChromeDevToolsManager.quitDriver();
    }
}
