# SimpleJava8AsciiTable

The class TextTable in this repository is a simple generic solution for outputting tabluar data as ASCII using Java 8.
Example: Required output:

    Description       | Material No | Spare Code | Total Quantity | Unit | Unit Price | Total Price
    Foo Bar           |    20204065 |          V |           2,00 |   ST |       3,00 |        6,00
    Bar Foo           |    20270808 |          E |           1,00 |   ST |       1,00 |        1,00
    Foo               |    20204066 |          E |           8,20 |    M |       4,00 |       32,80
    Bar               |    20204069 |          V |          12,00 |   ST |       2,00 |       24,00

This can be achieved by using TextTable as follows:

    // collection of simple java classes (in this case a collection of SumSheetEntry classes)
    final Collection<SumSheetEntry> data = ... // add some data here
     
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
    cols.add(new Col<>("Total Price",     r -> String.format("%.2f", r.getTotalPrice().doubleValue()),        Col.Orientation.RIGHT));

    // -------------------------------------------------------------------------------------------------------------------------------
    // output
    // -------------------------------------------------------------------------------------------------------------------------------   
    // via LOG.debug
    new TextTable<SumSheetEntry>(cols).print(data, s -> LOG.debug(s));
    // to stdout
    new TextTable<SumSheetEntry>(cols).print(data, s -> System.out.println(s));
     
    