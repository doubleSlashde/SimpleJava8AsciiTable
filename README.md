# SimpleJava8AsciiTable

The class TextTable in this repository is a simple generic solution for outputting tabluar data as ASCII using Java 8.
Example: Required output:

    Description | Material No | Total Quantity | Unit | Unit Price
    foo 1       |           1 |           1,00 |   kg |       1,23
    foo 2       |           2 |          10,00 |   kg |       2,23
    foo 3       |           3 |          20,00 |   kg |       3,23


This can be achieved by using TextTable as follows (see class Main for a runnable example):

    // collection of simple java classes (in this case a collection of ExampleRecord classes)
    final Collection<ExampleRecord> data = new ArrayList<>();
    // adding some sample data
    data.add(new ExampleRecord("foo 1", "1", new BigDecimal("1"), "kg", new BigDecimal("1.23")));
    data.add(new ExampleRecord("foo 2", "2", new BigDecimal("10"), "kg", new BigDecimal("2.23")));
    data.add(new ExampleRecord("foo 3", "3", new BigDecimal("20"), "kg", new BigDecimal("3.23")));
     
    final ArrayList<Col<SumSheetEntry>> cols = new ArrayList<>();

    // -------------------------------------------------------------------------------------------------------------------------------
    // defining columns:    
    //                  heading,          attribute extractor                                                 and column orientation
    // -------------------------------------------------------------------------------------------------------------------------------
    cols.add(new Col<>("Description",     SumSheetEntry::getDescription,                                      Col.Orientation.LEFT));
    cols.add(new Col<>("Material No",     SumSheetEntry::getMaterialNo,                                       Col.Orientation.RIGHT));
    cols.add(new Col<>("Spare Code",      SumSheetEntry::getSpareCode,                                        Col.Orientation.RIGHT));
    cols.add(new Col<>("Total Quantity",  r -> String.format("%.2f", r.getTotalQuantity().doubleValue()),     Col.Orientation.RIGHT));
    cols.add(new Col<>("Unit",            SumSheetEntry::getUnit,                                             Col.Orientation.RIGHT));
    cols.add(new Col<>("Unit Price",      r -> String.format("%.2f", r.getUnitPrice().doubleValue()),         Col.Orientation.RIGHT));

    // -------------------------------------------------------------------------------------------------------------------------------
    // output
    // -------------------------------------------------------------------------------------------------------------------------------   
    // via LOG.debug
    new TextTable<SumSheetEntry>(cols).print(data, s -> LOG.debug(s));
    // to stdout
    new TextTable<SumSheetEntry>(cols).print(data, s -> System.out.println(s));
     
    