
import inputOrder.Orders;
import outputOrder.Products;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Processor processor = new Processor();
        System.out.println("Press q to stop...\nRunning...");

        while(true) {
            //get current list of files in input folder
            List<File> inputFiles = null;
            try {
                inputFiles = Files.walk(Paths.get("src\\main\\resources\\input\\"))
                        .filter(Files::isRegularFile)
                        .map(Path::toFile)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (File item : inputFiles) {
                //convert file to object
                Orders orders = processor.convertXmlToObject(item);
                //sort products by supplier
                Map<String, Products> suppliers = processor.sortFile(orders);

                suppliers.forEach((k, v) -> {
                    System.out.println("Processing supplier: " + k);
                    //create output filename
                    String inputfilename = item.getName();
                    String orderno = inputfilename.toString().substring(inputfilename.toString().indexOf('s') + 1, inputfilename.toString().indexOf('.'));
                    String filename = "src\\main\\resources\\output\\" + k + orderno + ".xml";
                    //convert object to xml file
                    processor.convertObjectToXml(filename.toLowerCase(), v);
                });
                //move processed file to processed folder
                item.renameTo(new File("src\\main\\resources\\processed\\" + item.getName()));

            }

            //Stop condition
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();

            if ( inputString.toLowerCase().equals("q")) {
                //q was pressed... exit program
                break;
            }
        }


    }


}
