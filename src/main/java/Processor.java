import inputOrder.Order;
import inputOrder.Orders;
import outputOrder.Product;
import outputOrder.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class Processor {

    /*
    Function to convert XML file to Object
    Input: XML file
    Output: Orders object populated from XML
     */
    public Orders convertXmlToObject(File file) {
        Orders orders = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Orders.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            orders = (Orders) unmarshaller.unmarshal(file);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return orders;

    }

    /*
    Function to write an object to XML file
    Input:
        path to file
        object with the information to write
     */
    public void convertObjectToXml(String path, Products products) {
        //first sort products
        Collections.sort(products.getProduct(), Comparator.comparing(Product::getCreated).thenComparing(l->l.getPrice().getPrice()).reversed());

        //write file
        try {
            File file = new File(path);

            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(products, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /*
    Function to sort the orders by suppliers
    Input: orders object with all orders from a file
    Output: map with suppliers and their products
     */
    public Map<String, Products> sortFile(Orders orders) {
        //map for each supplier's products
        Map<String, Products> supplierMap = new HashMap<String, Products>();
        List<Product> list = new ArrayList<Product>();

        Products products = null;

        for (Order item : orders.getOrder()) {
            for (inputOrder.Product i : item.getProducts()) {
                //new supplier - add to map
                if (!supplierMap.containsKey(i.getSupplier())){
                    products = new Products(new ArrayList<>());
                    supplierMap.put(i.getSupplier(), products);
                }

                //add product
                products = supplierMap.get(i.getSupplier());
                Product product = new Product();
                product.setDescription(i.getDescription());
                product.setGtin(i.getGtin());
                product.setPrice(i.getPrice());
                product.setOrderid(item.getId());
                product.setCreated(item.getCreated());
                products.getProduct().add(product);

            }
        }

        return supplierMap;
    }

}
