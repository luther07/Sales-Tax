/***********************************************************
 * Author:      Mark Johnson
 * Date:        10/07/12
 * Modified:    10/21/12 
 *
 * Compilation: javac ReceiptMaker.java
 * Execution:   not applicable
 *
 * Defines a type for generating receipts.
 **********************************************************/

package salestax;

import java.io.Console;
import java.io.IOException;
import java.util.LinkedList;

public class ReceiptMaker {
    private LinkedList<Product> products = new LinkedList<Product>();

    public void print() {
        System.out.println("OUTPUT:");

        for (Product item : products) {
            System.out.println(item.toString());
        }

        System.out.println("Sales Taxes: " + this.totalSalesTax());
        System.out.println("Total: " + this.receiptTotal());
    }

    public double receiptTotal() {
        double runningTotal = 0.0;
        for (Product item : products) {
            runningTotal += item.quantity() * item.price();
        }
        return runningTotal;
    }

    public double totalSalesTax() {
        double runningTotal = 0.0;
        for (Product item : products) {
            runningTotal += item.quantity() * item.tax();
        }
        return runningTotal;
    }

    public void addProduct(String[] productInput) {
        boolean isExempt = parseExempt(productInput);
        int quantity = parseQuantity(productInput);
        boolean imported = parseImported(productInput);
        String name = parseName(productInput);
        double price = parsePrice(productInput);

        if (isExempt) {
            products.add(new ProductExempt(quantity, imported, name, price));
        } else {
            products.add(new ProductNonExempt(quantity, imported, name, price));
        }
    }

    static boolean parseExempt(String[] inputLine) {
        boolean isExempt = false;
        for (String item : inputLine) {
            if (item.equalsIgnoreCase("pills") || item.equalsIgnoreCase("book") 
                || item.equalsIgnoreCase("books") || item.equalsIgnoreCase("chocolate")
                || item.equalsIgnoreCase("chocolates"))
                { isExempt = true; } 
        }
        return isExempt;
    }

    static double parsePrice(String[] inputLine) {
        double inputPrice = 0.0;
        try {
            inputPrice = Double.parseDouble(inputLine[inputLine.length-1]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return inputPrice;
    }

    static boolean parseImported(String[] inputLine) {
        boolean isImported = false;
        for (String item : inputLine) {
            if (item.equalsIgnoreCase("imported"))
                isImported = true;
        }
        return isImported;
    }

    static String parseName(String[] inputLine) {
        String inputName = "";
        for (int i = 1; i <= inputLine.length - 3; i++) {
            inputName += inputLine[i] + " ";
        }
        return inputName;
    }

    static int parseQuantity(String[] inputLine) {
        int parseInteger = 0;
        try { 
            parseInteger = Integer.parseInt(inputLine[0]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return parseInteger;
    }

    public static void main(String[] args) throws IOException {

        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        System.out.println("How many items on this order?");
        String numberOfItems = c.readLine();
        int parsedNumber = 0;
        try {
            parsedNumber = Integer.parseInt(numberOfItems);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ReceiptMaker receipt = new ReceiptMaker();

        for (int j = 1; j <= parsedNumber; j++) {
            String line = c.readLine();
            String[] tokenArray = line.split(" ");
            receipt.addProduct(tokenArray);
        }

        receipt.print();
    }
}