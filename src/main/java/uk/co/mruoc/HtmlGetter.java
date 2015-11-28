package uk.co.mruoc;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.io.IOException;

public class HtmlGetter {

    private final DriverServiceFactory driverServiceFactory = new DriverServiceFactory();

    public String getHtml(String url) {
        DriverService service = driverServiceFactory.getChromeDriverService();
        try {
            service.start();
            WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
            driver.get(url);
            return driver.getPageSource();
        } catch (IOException e) {
            throw new ScraperException(e);
        } finally {
            service.stop();
        }
    }

}