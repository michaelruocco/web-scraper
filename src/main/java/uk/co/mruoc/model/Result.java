package uk.co.mruoc.model;

public class Result {

    private String title;
    private String description;
    private double unitPrice;
    private double size;

    private Result(ResultBuilder builder) {
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

    public static class ResultBuilder {

        private String title;
        private String description;
        private double unitPrice;
        private double size;

        public ResultBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ResultBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ResultBuilder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public ResultBuilder setSize(double size) {
            this.size = size;
            return this;
        }

        public Result build() {
            return new Result(this);
        }

    }

}