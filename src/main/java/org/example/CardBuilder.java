package org.example;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class CardBuilder implements Builder{
    Map<Integer,Integer> cardData =new HashMap<Integer,Integer>(
            Map.ofEntries(
                    entry(1234, 10),
                    entry(1618,90)
            )
    );
    public DiscountCard getResult(int id) throws Exception {
        Integer discount = cardData.get(id);
        if (discount == null) {
            throw new Exception("Invalid card ID!");
        }
        return new DiscountCard(id, discount);
    }
}
