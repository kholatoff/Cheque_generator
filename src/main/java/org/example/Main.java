package org.example;


import java.util.ArrayList;
import java.util.Map;
import java.text.DecimalFormat;

import static java.util.Map.entry;

public class Main {
    private static final DecimalFormat decimal = new DecimalFormat("0.00");
    static Double summary = 0d;
    static Boolean discountFlag = false;
    static ArrayList<String> chequeStrings = new ArrayList<String>();
    public static ArrayList<String> generateChequeLines(ArrayList<Map> shoplist){
        for(Map itemdata : shoplist){
            Item item = (Item) itemdata.get("item");
            Integer quantity = (Integer) itemdata.get("quantity");
            if ((item.discount == true) && (quantity >= 5)) {
                summary += (item.price*quantity*0.9);
            } else {
                summary += (item.price*quantity);
            }
            String output = String.format("%-3d %-20s %5.2f   %5.2f\n", quantity, item.description, item.price, item.price*quantity);
            System.out.print(output);
            if ((item.discount == true) && (quantity >= 5)) {
                System.out.println("    10% discount applied!");
                output += "    10% discount applied!\n";
            }
            chequeStrings.add(output);
        }
        return chequeStrings;
    }
    public static void main(String[] args) throws Exception {
        ItemBuilder ibuilder = new ItemBuilder();
        CardBuilder cbuilder = new CardBuilder();
        ChequeFileGen chequeGen = new ChequeFileGen();
        Input input = new Input();
        ArrayList<String> inputData = new ArrayList<>();
        ArrayList<Map> shoplist = new ArrayList<Map>();
        DiscountCard card = new DiscountCard(0,0);

        if (args[0].equals("--file")){
            inputData = input.getInput(args[1]);
        } else {
            for(String arg : args) {inputData.add(arg);}
        }

        for(String arg : inputData) {
            String[] splitted = arg.split("-");
            String identifier = new String((splitted[0]).toLowerCase());
            if (identifier.equals("card")) {
                card = cbuilder.getResult(Integer.parseInt(splitted[1]));
                discountFlag = true;
                continue;
            }
            Integer id = Integer.parseInt(splitted[0]);
            Integer quantity = Integer.parseInt(splitted[1]);
            Item item = ibuilder.getResult(id);
            shoplist.add(
                    Map.ofEntries(
                            entry(new String("item"), item),
                            entry(new String("quantity"), quantity)
                    )
            );
        }
        chequeStrings = generateChequeLines(shoplist);
        if (discountFlag == true){
            summary = (summary*(100-card.discount))/100;
            System.out.println("Discount card applied!");
            chequeStrings.add("\nDiscount card applied!\n");
        }
        System.out.println("Your grand total is "+ decimal.format(summary));
        chequeStrings.add("\nYour grand total is "+ decimal.format(summary));
        chequeGen.generateFile(chequeStrings);
    }
}