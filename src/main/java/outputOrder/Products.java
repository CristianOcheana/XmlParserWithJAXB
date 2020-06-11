package outputOrder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
public class Products {

    private List<Product> product;

    public Products() {
    }

    public Products(List<Product> product) {
        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }


    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
