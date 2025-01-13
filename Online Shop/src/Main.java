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

        if (action.equals("Electronics")) {
            for (String items: electronicP)
                System.out.println(items +
                        "\n Price: $" + Math.round((Math.random() * 124 + 370.99) * 100) / 100);
                if ((int)(Math.random() * 9 + 0) == 0)
                    System.out.println("Stock: Out of Stock");
                else
                    System.out.println("\n Stock: " + (int)(Math.random() * 9 + 0));
            action = sc.nextLine();
        }
        sc.close();
        }
    }