package uk.co.mruoc.html;

public class WebDriverHtmlGetter implements HtmlGetter {

    private final FirefoxWebDriver webDriver;

    public WebDriverHtmlGetter(FirefoxWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public String getHtml(String url) {
        return webDriver.getHtml(url);
    }

}