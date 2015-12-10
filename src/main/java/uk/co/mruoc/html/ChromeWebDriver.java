package uk.co.mruoc.html;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import uk.co.mruoc.ScraperException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ChromeWebDriver implements AutoCloseable {

    private final Waiter waiter = new Waiter();

    private static final String OS_NAME = System.getProperty("os.name");
    private static final String MAC_DRIVER_PATH = "/drivers/chromedriver_mac32";
    private static final String LINUX_DRIVER_PATH = "/drivers/chromedriver_linux32";
    private static final String WINDOWS_DRIVER_PATH = "/drivers/chromedriver.exe";

    private final DriverService driverService;
    private final WebDriver webDriver;

    public ChromeWebDriver() {
        try {
            this.driverService = getChromeDriverService();
            driverService.start();
            this.webDriver = new RemoteWebDriver(driverService.getUrl(), DesiredCapabilities.chrome());
        } catch (IOException e) {
            throw new ScraperException(e);
        }
    }

    public String getHtml(String url) {
        webDriver.get(url);
        waiter.waitHalfSecond();
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
        driverService.stop();
    }

    private DriverService getChromeDriverService() {
        File executable = getDriverExecutable();
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(executable)
                .usingAnyFreePort()
                .build();
    }

    private File getDriverExecutable() {
        try {
            URL url = this.getClass().getResource(getDriverPath());
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new ScraperException(e);
        }
    }

    private String getDriverPath() {
        if (SystemUtils.IS_OS_MAC)
            return MAC_DRIVER_PATH;

        if (SystemUtils.IS_OS_LINUX)
            return LINUX_DRIVER_PATH;

        if (SystemUtils.IS_OS_WINDOWS)
            return WINDOWS_DRIVER_PATH;

        throw new ScraperException("unsupported os " + OS_NAME);
    }

}
