package uk.co.mruoc.model;

public class ProductPage {

    private String title;
    private String description;
    private double unitPrice;
    private double size;

    private ProductPage(ProductPageBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.unitPrice = builder.unitPrice;
        this.size = builder.size;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSize() {
        return size;
    }

    public static class ProductPageBuilder {

        private String title;
        private String description;
        private double unitPrice;
        private double size;

        public ProductPageBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductPageBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductPageBuilder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public ProductPageBuilder setSize(double size) {
            this.size = size;
            return this;
        }

        public ProductPage build() {
            return new ProductPage(this);
        }

    }

}