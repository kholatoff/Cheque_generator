package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static java.util.Map.entry;

public class MainPrintTest {
    @Test
    public void Main_generateChequeLines_test() {
        Main main = new Main();
        String expectedResult = "2   Milk                 12,30   24,60\n";
        ArrayList<Map> shoplist = new ArrayList<Map>();
        shoplist.add(
                Map.ofEntries(
                        entry(new String("item"), Map.ofEntries(
                                entry(new String("description"), new String("Milk")),
                                entry(new String("price"), new Float(12.3f)),
                                entry(new String("discount"), new Boolean(false))
                        )),
                        entry(new String("quantity"), "2")
                )
        );
        try {
            ArrayList<String> actualResult = main.generateChequeLines(shoplist);
            Assertions.assertEquals(expectedResult, actualResult);
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }
}
