package outputOrder;

import inputOrder.Price;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(propOrder = {"description", "gtin", "price", "orderid"})
public class Product {

    private Date created;
    private String description;
    private long gtin;
    private long orderid;
    private Price price;

    public Product() {
    }

    public Product(String description, long gtin, Price price, long orderid) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.orderid = orderid;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderId) {
        this.orderid = orderId;
    }

    @XmlTransient
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
