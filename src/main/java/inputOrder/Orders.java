package inputOrder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Orders {

 private List<Order> order;

    public Orders() {
    }

    public Orders(List<Order> order) {
        this.order = order;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }


}
