package uk.co.mruoc.html;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import uk.co.mruoc.ScraperException;

import java.io.IOException;

public class HtmlGetter implements AutoCloseable {

    private static final int QUARTER_SECOND = 250;

    private final DriverService driverService;
    private final WebDriver driver;

    public HtmlGetter() {
        this(new DriverServiceFactory());
    }

    public HtmlGetter(DriverServiceFactory driverServiceFactory) {
        try {
            this.driverService = driverServiceFactory.getChromeDriverService();
            driverService.start();
            this.driver = new RemoteWebDriver(driverService.getUrl(), DesiredCapabilities.chrome());
        } catch (IOException e) {
            throw new ScraperException(e);
        }
    }

    public String getHtml(String url) {
        driver.get(url);
        wait(QUARTER_SECOND);
        return driver.getPageSource();
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new ScraperException(e);
        }
    }

    @Override
    public void close() {
        driver.close();
        driverService.stop();
    }

}