package uk.co.mruoc.html;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FirefoxWebDriver implements AutoCloseable {

    private final WebDriver webDriver = new FirefoxDriver();

    public String getHtml(String url) {
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(10, SECONDS);
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

}
