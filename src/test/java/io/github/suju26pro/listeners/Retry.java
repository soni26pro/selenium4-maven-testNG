package io.github.suju26pro.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements TestNG's IRetryAnalyzer interface to retry failed tests up to a certain number of times.
 */
public class Retry implements IRetryAnalyzer {

  private static final Logger LOG = LogManager.getLogger(Retry.class);
  private static final int MAX_RETRY_ATTEMPTS = 3;
  private int count = 0;

  /**
   * Gets the result status name based on the status code.
   *
   * @param status The status code.
   * @return The name of the result status.
   */
  public String getResultStatusName(final int status) {
    switch (status) {
      case 1:
        return "SUCCESS";
      case 2:
        return "FAILURE";
      case 3:
        return "SKIP";
      default:
        return "UNKNOWN";
    }
  }

  @Override
  public boolean retry(final ITestResult iTestResult) {
    if (!iTestResult.isSuccess()) {
      if (count < MAX_RETRY_ATTEMPTS) {
        LOG.info("Retrying test '" + iTestResult.getName() + "' with status '" +
                getResultStatusName(iTestResult.getStatus()) + "' for the " + (count + 1) + " time(s).");
        count++;
        return true;
      }
    }
    return false;
  }
}
