package uk.co.mruoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.io.IOException;

public class HtmlGetter implements AutoCloseable {

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
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
        driverService.stop();
    }

}