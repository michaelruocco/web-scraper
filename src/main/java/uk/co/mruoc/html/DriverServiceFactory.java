package uk.co.mruoc.html;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;
import uk.co.mruoc.ScraperException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverServiceFactory {

    private static final String MAC_DRIVER_PATH = "/drivers/chromedriver";
    private static final String WINDOWS_DRIVER_PATH = "/drivers/chromedriver.exe";

    public DriverService getChromeDriverService() {
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
        return WINDOWS_DRIVER_PATH;
    }

}
