package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemBuilderTests {
    private ItemBuilder iBuilder = new ItemBuilder();
    @Test
    public void itemBuilder_getResult_test() {
        Float expectedResult = 12.3f;
        try {
            Float actualResult = iBuilder.getResult(1).price;
            Assertions.assertEquals(expectedResult, actualResult);
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Test
    public void itemBuilder_getResult_invalidID_test() {
        Assertions.assertThrows(Exception.class, () -> {iBuilder.getResult(9999);});
    }
}
