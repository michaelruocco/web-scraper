package uk.co.mruoc.html;

public class DefaultHtmlGetter implements HtmlGetter {

    private final ChromeWebDriver webDriver;

    public DefaultHtmlGetter(ChromeWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public String getHtml(String url) {
        return webDriver.getHtml(url);
    }

}