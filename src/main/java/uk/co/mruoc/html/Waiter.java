package uk.co.mruoc.html;

import uk.co.mruoc.ScraperException;

public class Waiter {

    private static final int QUARTER_SECOND = 250;

    public void waitQuarterSecond() {
        wait(QUARTER_SECOND);
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new ScraperException(e);
        }
    }

}
