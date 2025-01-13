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
        // categories
        String[] category = {"Electronics", "Clothing", "Books"};
        // let users browse categories
        System.out.println("In order to see the selection of products, please enter the name of the category");
        for (String categories: category)
            System.out.println(categories);
        action = sc.nextLine();
        // If not correct , make use enter again
        while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
            System.out.println("Invalid input, please try again.");
            action = sc.nextLine();
        }

        String[] electronicP = {"Computer", "Phone", "Tablet"};
        String[] clothingP = {"T-shirt", "Sweater", "Shoes"};
        String[] bookP = {"Harry Potter", "Percy Jackson", "Hunger Games"};
        int stock;
        if (action.equals("Electronics")) {
            for (String items: electronicP) {
                System.out.print(items +
                        "\nPrice: $" + (double)Math.round((Math.random() * 124 + 370.99) * 100) / 100);
                stock = (int)(Math.random() * 10 + 0);
                if (stock == 0)
                    System.out.println("\nStock: Out of Stock");
                else
                    System.out.println("\nStock: " + stock);
            }
        } else if (action.equals("Clothing")) {
            for (String items: clothingP) {
                System.out.print(items +
                        "\nPrice: $" + (double)Math.round((Math.random() * 100 + 20.99) * 100) / 100);
                stock = (int)(Math.random() * 10 + 0);
                if (stock == 0)
                    System.out.println("\nStock: Out of Stock");
                else
                    System.out.println("\nStock: " + stock);
            }
        } else if (action.equals("Books")) {
            for (String items: bookP) {
                System.out.print(items +
                        "\nPrice: $" + (double)Math.round((Math.random() * 30 + 20.99) * 100) / 100);
                stock = (int)(Math.random() * 10 + 0);
                if (stock == 0)
                    System.out.println("\nStock: Out of Stock");
                else
                    System.out.println("\nStock: " + stock);
            }
        }
        sc.close();
        }
    }