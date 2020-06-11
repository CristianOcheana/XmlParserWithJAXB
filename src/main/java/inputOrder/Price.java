package inputOrder;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


public class Price {

    private String currency;

    private double price;

    public Price() {

    }

    public String getCurrency() {
        return currency;
    }

    @XmlAttribute
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    @XmlValue
    public void setPrice(double price) {
        this.price = price;
    }
}
