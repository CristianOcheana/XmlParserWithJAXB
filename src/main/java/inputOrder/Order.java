package inputOrder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

public class Order {

    private Date created;
    private long id;
    private List<Product> products;

    public Order() {
    }

    public Order(Date created, long id, List<Product> products) {
        this.created = created;
        this.id = id;
        this.products = products;
    }

    public Date getCreated() {
        return created;
    }

    @XmlAttribute
    public void setCreated(Date created) {
        this.created = created;
    }

    public long getId() {
        return id;
    }

    @XmlAttribute(name = "ID")
    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

   @XmlElement(name = "product")
    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
