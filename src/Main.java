import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        // collection of simple java classes (in this case a collection of ExampleRecord classes)
        final Collection<ExampleRecord> data = new ArrayList<>();
        data.add(new ExampleRecord("foo 1", "1", new BigDecimal("1"), "kg", new BigDecimal("1.23")));
        data.add(new ExampleRecord("foo 2", "2", new BigDecimal("10"), "kg", new BigDecimal("2.23")));
        data.add(new ExampleRecord("foo 3", "3", new BigDecimal("20"), "kg", new BigDecimal("3.23")));

        final ArrayList<TextTable.Col<ExampleRecord>> cols = new ArrayList<>();

        // -------------------------------------------------------------------------------------------------------------------------------
        // defining columns:
        // heading, attribute extractor and column orientation
        // -------------------------------------------------------------------------------------------------------------------------------

        cols.add(new TextTable.Col<>("Description", ExampleRecord::getDescription, TextTable.Col.Orientation.LEFT));
        cols.add(new TextTable.Col<>("Material No", ExampleRecord::getMaterialNo, TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Total Quantity", r -> String.format("%.2f", r.getTotalQuantity().doubleValue()),
                TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Unit", ExampleRecord::getUnit, TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Unit Price", r -> String.format("%.2f", r.getUnitPrice().doubleValue()),
                TextTable.Col.Orientation.RIGHT));

        // -------------------------------------------------------------------------------------------------------------------------------
        // output
        // -------------------------------------------------------------------------------------------------------------------------------
        new TextTable<ExampleRecord>(cols).print(data, s -> System.out.println(s));
        // alternatively log via "s -> LOG.debug(s)" or the like

    }
}
