package inputOrder;

import javax.xml.bind.annotation.*;

public class Product {

    private String description;
    private long gtin;
    private Price price;
    private String supplier;

    public Product() {
    }

    public Product(String description, long gtin, Price price, String supplier) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getGtin() {
        return gtin;
    }

    public void setGtin(long gtin) {
        this.gtin = gtin;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @XmlElement(name="price")
    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
