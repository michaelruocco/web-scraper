package uk.co.mruoc;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverServiceFactory {

    private static final String MAC_DRIVER_PATH = "/drivers/chrome/mac32/chromedriver";
    private static final String WINDOWS_DRIVER_PATH = "/drivers/chrome/win32/chromedriver.exe";

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
