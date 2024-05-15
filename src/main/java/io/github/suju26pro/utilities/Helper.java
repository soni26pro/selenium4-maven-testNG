package io.github.suju26pro.utilities;

/**
 * Utility class providing helper methods.
 */
public final class Helper {

    private Helper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Pauses the current thread for the specified duration.
     *
     * @param timeInMillis The duration to pause the thread in milliseconds.
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
    public static void pause(final long timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }
}
