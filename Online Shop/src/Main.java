//Cynthia Zeng ISU Store
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. Let user enter store
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
        ArrayList<String> cart = new ArrayList<>();
        ArrayList<Integer> cartPrice = new ArrayList<>();
        ArrayList<Integer> cartStock = new ArrayList<>();
        int i = 1;
        System.out.println("In order to see the selection of products, please enter the name of the category");
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
                    for (String items: electronicP) {
                        System.out.print("\""+ i + "\" " + items + "\nPrice: $" + ePrice[i - 1]);
                        if (eStock.get(i-1) == 0)
                            System.out.println("\nStock: Out of Stock");
                        else
                            System.out.println("\nStock: " + eStock.get(i - 1));
                        i ++;
                    }
                    System.out.println("Would you like to \"Purchase\" or check out other \"Categories\" or head to \"Checkout\": ");
                    action = sc.nextLine();
                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Checkout")) {
                        System.out.println("Invalid input, please try again.");
                        action = sc.nextLine();
                    }
                    if (action.equals("Purchase")) {
                        System.out.println("Enter the number of the item you like to buy: ");
                        item = sc.nextInt();
                        while (item != 1 && item != 2 && item != 3) {
                            System.out.println("Invalid input, please try again.");
                            item = sc.nextInt();
                        }
                        System.out.println("Enter the number of the items you like to buy: ");
                        cart.add(cart.get(item-1));
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