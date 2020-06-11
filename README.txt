How to run:
Start application.
Put input file in folder: src\main\resources\input\
To stop application press q
Output files will be created in src\main\resources\output
Processed files will be moved to src\main\resources\processed

What it does:
In main function there is an infinite loop which breaks when q is input from keyboard.
In the loop it will read the contents of src\main\resources\input folder. For each file found in the folder, application will:
-	Transform the xml file into an Orders object using JAXB parser -> function processor.convertXmlToObject(current file)
-	Sorts products by supplier and returns a map of supplier name and product list -> function processor.convertXmlToObject(Orders object)
-	Writes xml file using JAXB parser -> function processor.convertObjectToXml(filename, Products object) :
o	Sorts products for each supplier by timestamp and price descendant
o	Writes file
Application has 2 sets of objects:
-	One for reading from file: inputOrder folder. Classes map the xml structure
-	One for writing to file: outputOrder folder. Classes map the xml structure
