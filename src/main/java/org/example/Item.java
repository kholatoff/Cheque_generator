package org.example;

public class Item
{
    public int id;
    public String description;
    public float price;
    public boolean discount;

    public Item(int identifier, String descr, float value, boolean sale) {
        id = identifier;
        description = descr;
        price = value;
        discount = sale;
    }
}
