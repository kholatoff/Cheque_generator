package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardBuilderTests {
    private CardBuilder cBuilder = new CardBuilder();
    @Test
    public void cardBuilder_getResult_test() {
        Integer expectedResult = 10;
        try {
            Integer actualResult = cBuilder.getResult(1234).discount;
            Assertions.assertEquals(expectedResult, actualResult);
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Test
    public void cardBuilder_getResult_invalidID_test() {
        Assertions.assertThrows(Exception.class, () -> {cBuilder.getResult(9999);});
    }
}
