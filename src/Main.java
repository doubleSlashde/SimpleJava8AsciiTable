import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    
    public static void main(String[] args) {
        
     // Eine Collection mit Pojos (in meinem Fall SumSheetEntry)
        final Collection<SumSheetEntry> data = new ArrayList<>();
        data.add(new SumSheetEntry("foo 1", "1", new BigDecimal("1"), "kg",
                new BigDecimal("10.23"), new BigDecimal("102.3")) );
        
         
        final ArrayList<TextTable.Col<SumSheetEntry>> cols = new ArrayList<>();
                 
        // Spaltendef:     Überschrift,       Attribut als String Extraktor via Lambda/Methodenreferenz,          Spaltenorientierung                                     
        cols.add(new TextTable.Col<>("Description",     SumSheetEntry::getDescription,                                      TextTable.Col.Orientation.LEFT));
        cols.add(new TextTable.Col<>("Material No",     SumSheetEntry::getMaterialNo,                                       TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Total Quantity",  r -> String.format("%.2f", r.getTotalQuantity().doubleValue()),     TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Unit",            SumSheetEntry::getUnit,                                             TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Unit Price",      r -> String.format("%.2f", r.getUnitPrice().doubleValue()),         TextTable.Col.Orientation.RIGHT));
        cols.add(new TextTable.Col<>("Total Price",     r -> String.format("%.2f", r.getTotalPrice().doubleValue()),        TextTable.Col.Orientation.RIGHT));
         
        // Die Collection mit den oben definierten Spalten als Tabellen über LOG.debug ausgeben:
        new TextTable<SumSheetEntry>(cols).print(data, s -> System.out.println(s));
         
        // statt LOG.debug könnte man oben natürlich auch LOG.info o.ä. hineingeben
    }
}
