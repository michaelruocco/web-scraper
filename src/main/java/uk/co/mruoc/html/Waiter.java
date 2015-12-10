package uk.co.mruoc.html;

import uk.co.mruoc.ScraperException;

public class Waiter {

    private static final int HALF_SECOND = 500;

    public void waitHalfSecond() {
        wait(HALF_SECOND);
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new ScraperException(e);
        }
    }

}
