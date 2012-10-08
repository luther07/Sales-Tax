package salestax;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.LinkedList;

public class ReceiptMaker {

    public static void main(String[] args) throws IOException{
    String line;
    String[] tokenArray = {"my", "name", "is", "mark"};
    int quantity = 0;
    LinkedList<Product> products = new LinkedList<Product>();
    double totalTax = 0.0;
    double totalAmount = 0.0;
    boolean imported = false;
    boolean exempt = false;
    String name = "";
    double price = 0.0;

    Console c = System.console();
    if (c == null) {
        System.err.println("No console.");
        System.exit(1);
    }

    line = c.readLine();
    tokenArray = line.split(" ");

    /*
     * Loop through tokenArray, in order to create Product.
     */
    for (int i = 0; i < tokenArray.length; i++) {

        /************************************************
        * Parse quantity, if at first index.
        ************************************************/
        if (i == 0) {
            try {
                quantity = Integer.parseInt(tokenArray[0]);
            } catch (java.lang.NumberFormatException e) {
                System.err.println("NumberFormatException: string does not contain parsable integer");
                System.exit(1);
            }
        }


	/************************************************
        * Parse price, if at last index.
        * Add Product to products list, if at last index.
        ************************************************/
        else if (i == tokenArray.length-1) {
            try {
                price = Double.parseDouble(tokenArray[i]);
            } catch (java.lang.NumberFormatException e) {
                System.err.println("NumberFormatException: String does not contain parsable double");
                System.exit(1);
            }
            if (exempt)
                products.add(new ProductExempt(quantity, imported, name, price));
            else
                products.add(new ProductNonExempt(quantity, imported, name, price));
        }

	/*************************************************
        * Set variables exempt and imported to true, if token matches specified string.
        * Concatenate string to name variable.
        * Must include conditions for books, food, and medical products.
        *************************************************/
        else {
            if (tokenArray[i].equalsIgnoreCase("imported")) {
                imported = true;
                name = name + " " + tokenArray[i];
            } else if ((tokenArray[i].equalsIgnoreCase("pills") ||
                        tokenArray[i].equalsIgnoreCase("book") ||
                        tokenArray[i].equalsIgnoreCase("chocolate") ||
                        tokenArray[i].equalsIgnoreCase("chocolates"))) {
                exempt = true;
                name = name + " " + tokenArray[i];
            } else if (tokenArray[i].equalsIgnoreCase("at")) {
                name = name + "";
            } else {
                name = name + " " + tokenArray[i];
            }
        }

    } // end loop on tokenArray
    System.out.println("OUTPUT:");
        for (Product item : products) {
            System.out.println(item.toString());
            totalTax += item.tax() * item.quantity();
            totalAmount += item.quantity() * item.price();
        }

        System.out.println("Sales Taxes: " + totalTax);
        System.out.println("Total: " + totalAmount);
    }
}