package org.example;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class ItemBuilder implements Builder {
        Map<Integer,HashMap> itemData =new HashMap<Integer,HashMap>(
                Map.ofEntries(
                entry(1, new HashMap<String,Object>(
                        Map.ofEntries(
                                entry("description","Milk"),
                                entry("price",12.3f),
                                entry("discount",false)
                        )
                )),
                entry(2, new HashMap<String,Object>(
                        Map.ofEntries(
                                entry("description","Bread"),
                                entry("price",7.1f),
                                entry("discount",false)
                        )
                )),
                entry(3, new HashMap<String,Object>(
                        Map.ofEntries(
                                entry("description","Nutella"),
                                entry("price",53.1f),
                                entry("discount",true)
                        )
                ))
                )
        );


        public Item getResult(int id) throws Exception {
                HashMap data = itemData.get(id);
                if (data == null) {
                        throw new Exception("Invalid item ID!");
                }
                return new Item(id, (String) data.get("description"), (Float) data.get("price"), (Boolean) data.get("discount"));
        }
    }
