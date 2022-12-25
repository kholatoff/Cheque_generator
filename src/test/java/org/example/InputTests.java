package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTests {
    @Test
    public void input_getInput_test() {
        Input input = new Input();
        String expectedResult = "1-2";
        try {
            String actualResult = input.getInput("input.txt").get(0);
            Assertions.assertEquals(expectedResult, actualResult);
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }
    @Test
    public void input_getInput_noFile_test() {
        Input input = new Input();
        Assertions.assertEquals(0, input.getInput("fakename.txt").size());
    }
}
