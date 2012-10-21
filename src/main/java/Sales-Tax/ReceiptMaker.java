package salestax;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.LinkedList;

public class ReceiptMaker {
    private static LinkedList<Product> products = new LinkedList<Product>();

    public void addProduct(String[] productInput) {
        if (parseExempt(productInput)) {
	    products.add(new ProductExempt(parseQuantity(productInput), parseImported(productInput), parseName(productInput), parsePrice(productInput)));          
	} else {
       	    products.add(new ProductNonExempt(parseQuantity(productInput), parseImported(productInput), parseName(productInput), parsePrice(productInput)));
	}
    }

    static boolean parseExempt(String[] inputLine) {
        boolean isExempt = false;
        for (String item : inputLine) {
            if (item.equalsIgnoreCase("pills") || item.equalsIgnoreCase("book") ||
                item.equalsIgnoreCase("books") || item.equalsIgnoreCase("chocolate") ||
                item.equalsIgnoreCase("chocolates"))
                { isExempt = true; } 
	}
        return isExempt;
    }

    static double parsePrice(String[] inputLine) {
        double inputPrice = 0.0;
        int inputSize = inputLine.length;
        try {
            inputPrice = Double.parseDouble(inputLine[inputSize-1]);
	} catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
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
        String[] input = inputLine;
        for(int i = 1; i <= input.length - 3; i++) {
            inputName += inputLine[i];
        }
        return inputName;
    }

    static int parseQuantity(String[] inputLine) {
       int parseInteger = 0;
       try { 
            parseInteger = Integer.parseInt(inputLine[0]);
	} catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
	}
        return parseInteger;
    }

    /*************************************************************
     *
     * @returns the receipt total for all products in a receipt.
     *
     ************************************************************/
    public double receiptTotal() {
        double runningTotal = 0;
        for (Product item : products) {
            runningTotal += item.quantity() * item.price();
	}
        return runningTotal;
    }

    /*************************************************************
     *
     * @returns the total sales tax for all products in a receipt.
     *
     ************************************************************/
    public double totalSalesTax() {
        double runningTotal = 0;
        for (Product item : products) {
            runningTotal += item.quantity() * item.tax();
	}
        return runningTotal;
    }

    public static void main(String[] args) throws IOException{
        String line;
        String[] tokenArray;
        double totalTax = 0.0;
        double totalAmount = 0.0;

        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        System.out.println("How many items on this order?");
        String numberOfItems = c.readLine();
        Integer parsedNumber = 0;
        try {
            parsedNumber = Integer.parseInt(numberOfItems);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ReceiptMaker receipt = new ReceiptMaker();

        for(int j = 1; j <= parsedNumber; j++) {
            line = c.readLine();
            tokenArray = line.split(" ");
            receipt.addProduct(tokenArray);
	}

        System.out.println("OUTPUT:");
            for (Product item : products) {
                System.out.println(item.toString());
                totalTax += item.tax();
                totalAmount += item.quantity() * item.price();
            }

        System.out.println("Sales Taxes: " + totalTax);
        System.out.println("Total: " + totalAmount);
    }
}