package uk.co.mruoc.html;

public class WebDriverHtmlGetter implements HtmlGetter {

    private final ChromeWebDriver webDriver;

    public WebDriverHtmlGetter(ChromeWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public String getHtml(String url) {
        return webDriver.getHtml(url);
    }

}