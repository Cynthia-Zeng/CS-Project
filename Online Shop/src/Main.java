//Name: Cynthia Zeng
//Project: ISU Store
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Let user enter store
        System.out.println("Welcome User! Type \"Begin\" to start your experience");
        String action = sc.nextLine();
        // If not correct , make use enter again
        while (!action.equals("Begin")) {
            System.out.println("Invalid input, please try again.");
            action = sc.nextLine();
        }
        // Categories
        String[] category = {"Electronics", "Clothing", "Books"};
        // Products, Price, Stock
        String[] electronicP = {"Computer", "Phone", "Tablet"};
        double[] ePrice = {279.99, 197.00, 119.99};
        ArrayList<Integer> eStock = new ArrayList<>();
        // Stock Random
        for (int i = 0; i < 3; i++)
            eStock.add((int)(Math.random() * 10 + 0));
        String[] clothingP = {"T-shirt", "Sweater", "Shoes"};
        double[] cPrice = {19.90, 39.90, 130.00};
        ArrayList<Integer> cStock = new ArrayList<>();
        // Stock Random
        for (int i = 0; i < 3; i++)
            cStock.add((int)(Math.random() * 10 + 0));
        String[] bookP = {"Harry Potter", "Percy Jackson", "Hunger Games"};
        double[] bPrice = {11.79, 20.24, 25.89};
        ArrayList<Integer> bStock = new ArrayList<>();
        // Stock Random
        for (int i = 0; i < 3; i++)
            bStock.add((int)(Math.random() * 10 + 0));
        // Cart
        int item;
        int stockAmount;
        ArrayList<String> cart = new ArrayList<>();
        ArrayList<Double> cartPrice = new ArrayList<>();
        ArrayList<Double> cartTotal = new ArrayList<>();
        ArrayList<Integer> cartStock = new ArrayList<>();
        int i = 1;
        //Chose Category
        System.out.println("To see the selection of products, enter the name of the category");
        for (String categories: category)
            System.out.println("\""+categories+"\"");
        action = sc.nextLine();
        // If not correct , make user try again
        while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
            System.out.println("Invalid input, please try again.");
            action = sc.nextLine();
        }
        while (action.equals("Electronics") || action.equals("Clothing") || action.equals("Books") || action.equals("Categories") || action.equals("Checkout")) {
            switch (action) {
                case "Electronics":
                    // Show Products, Price, and Stock
                    for (String items: electronicP) {
                        //Show Products & Price
                        System.out.print("\""+ i + "\" " + items + "\nPrice: $" + ePrice[i - 1]);
                        // Show Stock
                        if (eStock.get(i - 1) == 0)
                            // Stock = 0
                            System.out.println("\nStock: Out of Stock");
                        else
                            // Stock > 0
                            System.out.println("\nStock: " + eStock.get(i - 1));
                        i ++;
                    }
                    // Purchase, Categories, or Checkout
                    System.out.println("Would you like to \"Purchase\", check out other \"Categories\" or head to \"Checkout\": ");
                    action = sc.nextLine();
                    // If not correct , make user try again
                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Checkout")) {
                        System.out.println("Invalid input, please try again.");
                        action = sc.nextLine();
                    }
                    while (action.equals("Purchase")) {
                        System.out.println("Enter the number of the item you like to buy: ");
                        // # in front of item when shown
                        item = sc.nextInt();
                        // If not correct , make user try again
                        while (item != 1 && item != 2 && item != 3) {
                            System.out.println("Invalid input, please try again.");
                            item = sc.nextInt();
                        }
                        // Check Stock
                        while (eStock.get(item - 1) == 0) {
                            System.out.println("Item out of Stock. Choose a different product.\nEnter the number of the item you like to buy:");
                            item = sc.nextInt();
                        }
                        // # of items
                        System.out.println("Enter the amount you like to buy:");
                        stockAmount = sc.nextInt();
                        while (eStock.get(item - 1) - stockAmount < 0) {
                            System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                            stockAmount = sc.nextInt();
                        }
                        cart.add(electronicP[item - 1]);
                        cartPrice.add(ePrice[item - 1]);
                        cartStock.add(stockAmount);
                        cartTotal.add(ePrice[item - 1] * stockAmount);
                        System.out.println("Added to cart.\nWould you like to \"Purchase\" more or check out other \"Categories\" or head to \"Checkout\": ");
                        action = sc.nextLine();
                        while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Checkout")) {
                            System.out.println("Invalid input, please try again.");
                            action = sc.nextLine();
                        }
                    }
                    i = 1;
                    break;
                case "Clothing":
                    for (String items: clothingP) {
                        System.out.print("\""+ i + "\" \"" + items + "\"\nPrice: $" + cPrice);
                        i ++;
                        if (cStock.get(i-1) == 0)
                            System.out.println("\nStock: Out of Stock");
                        else
                            System.out.println("\nStock: " + cStock.get(i-1));
                    }
                    i = 1;
                    break;
                case "Books":
                    for (String items: bookP) {
                        System.out.print("\""+ i + "\" \"" + items + "\"\nPrice: $" + bPrice);
                        i ++;
                        if (bStock.get(i-1) == 0)
                            System.out.println("\nStock: Out of Stock");
                        else
                            System.out.println("\nStock: " + bStock.get(i-1));
                    }
                    i = 1;
                    break;
                case "Categories":
                    System.out.println("In order to see the selection of products, please enter the name of the category");
                    for (String categories: category)
                        System.out.println("\""+categories+"\"");
                    action = sc.nextLine();
                    // If not correct , make user try again
                    while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
                        System.out.println("Invalid input, please try again.");
                        action = sc.nextLine();
                    }
                    break;
                case "Checkout":
                    break;
            }
            if (action.equals("Checkout"))
                break;
        }
        sc.close();
    }
}