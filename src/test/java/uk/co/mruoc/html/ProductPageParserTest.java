package uk.co.mruoc.html;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageParserTest {

    private static final String PRODUCT_PAGE_PATH = "/apricot_page.html";

    private static final String TITLE = "Sainsbury's Apricot Ripe & Ready x5";
    private static final String DESCRIPTION = "Apricots";
    private static final double UNIT_PRICE = 3.5;
    private static final double PAGE_SIZE = 137163;

    private HtmlLoader htmlLoader = new HtmlLoader();

    @Test
    public void shouldParseTitleFromProductPage() {
        String html = loadProductPageHtml();

        ProductPageParser parser = new ProductPageParser(html);

        assertThat(parser.getTitle()).isEqualTo(TITLE);
    }

    @Test
    public void shouldParseDescriptionFromProductPage() {
        String html = loadProductPageHtml();

        ProductPageParser parser = new ProductPageParser(html);

        assertThat(parser.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    public void shouldParseUnitPriceFromProductPage() {
        String html = loadProductPageHtml();

        ProductPageParser parser = new ProductPageParser(html);

        assertThat(parser.getPricePerUnit()).isEqualTo(UNIT_PRICE);
    }

    @Test
    public void shouldParsePageSizeFromProductPage() {
        String html = loadProductPageHtml();

        ProductPageParser parser = new ProductPageParser(html);

        assertThat(parser.getPageSize()).isEqualTo(PAGE_SIZE);
    }

    private String loadProductPageHtml() {
        return htmlLoader.loadHtml(PRODUCT_PAGE_PATH);
    }

}
