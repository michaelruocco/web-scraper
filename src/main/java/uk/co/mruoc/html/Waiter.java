package uk.co.mruoc.html;

import uk.co.mruoc.ScraperException;

public class Waiter {

    private static final int TWO_SECONDS = 2000;

    public void waitTwoSeconds() {
        wait(TWO_SECONDS);
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new ScraperException(e);
        }
    }

}
