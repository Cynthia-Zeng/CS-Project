//Name: Cynthia Zeng
//Project: ISU Store
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Let user enter store
        System.out.println("Welcome User! Type \"Begin\" to start your experience:");
        String action = sc.nextLine();
        // If not correct , make use try again
        while (!action.equals("Begin")) {
            System.out.println("Invalid input, please try again.");
            action = sc.nextLine();
        }
        // Categories
        String[] category = {"Electronics", "Clothing", "Books"};
        // Electronics Products, Price, Stock
        String[] electronicP = {"Computer", "Phone", "Tablet"};
        double[] ePrice = {279.99, 197.00, 119.99};
        ArrayList<Integer> eStock = new ArrayList<>();
        // Stock Random
        for (int i = 0; i < 3; i++)
            eStock.add((int)(Math.random() * 10 + 0));
        // Clothing Products, Price, Stock
        String[] clothingP = {"T-shirt", "Sweater", "Shoes"};
        double[] cPrice = {19.90, 39.90, 130.00};
        ArrayList<Integer> cStock = new ArrayList<>();
        // Stock Random
        for (int i = 0; i < 3; i++)
            cStock.add((int)(Math.random() * 10 + 0));
        // Books Products, Price, Stock
        String[] bookP = {"Harry Potter", "Percy Jackson", "Hunger Games"};
        double[] bPrice = {11.79, 20.24, 25.89};
        ArrayList<Integer> bStock = new ArrayList<>();
        // Stock Random
        for (int i = 0; i < 3; i++)
            bStock.add((int)(Math.random() * 10 + 0));
        // Cart
        int j = 0;
        int item;
        int stockAmount;
        double total = 0.0;
        // Cart items
        ArrayList<String> cart = new ArrayList<>();
        // Prices of different individual items
        ArrayList<Double> cartPrice = new ArrayList<>();
        // Price of all items
        ArrayList<Double> cartTotal = new ArrayList<>();
        // Stock of items in cart
        ArrayList<Integer> cartStock = new ArrayList<>();
        int i = 1;
        while (!action.equals("End")) {
            //Chose Category
            System.out.println("To see the selection of products, Type the name of the category:");
            //Print out Category
            for (String categories : category)
                System.out.println("\"" + categories + "\"");
            //Choose
            action = sc.nextLine();
            // If not correct , make user try again
            while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
                System.out.println("Invalid input, please try again.");
                action = sc.nextLine();
            }
            // Loop until ready to Check out
            while (!action.equals("Buy") && !action.equals("End")) {
                switch (action) {
                    case "Electronics":
                        // Show Products, Price, and Stock
                        for (String items : electronicP) {
                            //Show Products & Price
                            System.out.print("\"" + i + "\" " + items + "\nPrice: $" + ePrice[i - 1]);
                            // Show Stock
                            if (eStock.get(i - 1) == 0)
                                // Stock = 0
                                System.out.println("\nStock: Out of Stock");
                            else
                                // Stock > 0
                                System.out.println("\nStock: " + eStock.get(i - 1));
                            i++;
                        }
                        // Purchase, Categories, Cart, or End
                        System.out.println("Would you like to \"Purchase\", browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                        action = sc.nextLine();
                        // If not correct , make user try again
                        while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                            System.out.println("Invalid input, please try again.");
                            action = sc.nextLine();
                        }
                        // While Purchasing within chosen Category
                        while (action.equals("Purchase")) {
                            System.out.println("Enter the number of the item you like to buy:");
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
                            // Check if # of item goes over stock
                            while (eStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                //If larger than stock or -ve, make user try again
                                System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                            }
                            // Confirmation to add to cart, change stock or cancel purchase
                            System.out.println("Would you like to add " + stockAmount + " item(s) of " + electronicP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount of items, or \"Cancel\" purchase:");
                            sc.nextLine();
                            action = sc.nextLine();
                            // If not correct , make user try again
                            while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                System.out.println("Invalid input, please try again.");
                                action = sc.nextLine();
                            }
                            // If unhappy with stock
                            while (action.equals("Change")) {
                                // # of items
                                System.out.println("Enter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                                // Check if # of item goes over stock
                                while (eStock.get(item - 1) - stockAmount < 0) {
                                    //If larger than stock or -ve, make user try again
                                    System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                    stockAmount = sc.nextInt();
                                }
                                // Confirmation to add to cart, change stock or cancel purchase
                                System.out.println("Would you like to add " + stockAmount + " items of " + electronicP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount of items, or \"Cancel\" purchase:");
                                sc.nextLine();
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                            // If unhappy with purchase
                            if (action.equals("Cancel")) {
                                // Purchase, Categories, Cart, or End
                                System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                            // if happy with purchase
                            if (action.equals("Yes")) {
                                // Updated Stock
                                eStock.set(item - 1, eStock.get(item - 1) - stockAmount);
                                //Add item to cart
                                cart.add(electronicP[item - 1]);
                                //Add price of item to cart
                                cartPrice.add(ePrice[item - 1]);
                                //Add stock of item to cart
                                cartStock.add(stockAmount);
                                // add total of item price * stock
                                cartTotal.add(ePrice[item - 1] * stockAmount);
                                // Purchase, Categories, Cart, or End
                                System.out.println("Added to Cart.\nWould you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                        }
                        i = 1;
                        break;
                    case "Clothing":
                        // Show Products, Price, and Stock
                        for (String items : clothingP) {
                            //Show Products & Price
                            System.out.print("\"" + i + "\" " + items + "\nPrice: $" + cPrice[i - 1]);
                            // Show Stock
                            if (cStock.get(i - 1) == 0)
                                // Stock = 0
                                System.out.println("\nStock: Out of Stock");
                            else
                                // Stock > 0
                                System.out.println("\nStock: " + cStock.get(i - 1));
                            i++;
                        }
                        // Purchase, Categories, Cart, or End
                        System.out.println("Would you like to \"Purchase\", browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                        action = sc.nextLine();
                        // If not correct , make user try again
                        while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                            System.out.println("Invalid input, please try again.");
                            action = sc.nextLine();
                        }
                        // While Purchasing within chosen Category
                        while (action.equals("Purchase")) {
                            System.out.println("Enter the number of the item you like to buy:");
                            // # in front of item when shown
                            item = sc.nextInt();
                            // If not correct , make user try again
                            while (item != 1 && item != 2 && item != 3) {
                                System.out.println("Invalid input, please try again.");
                                item = sc.nextInt();
                            }
                            // Check Stock
                            while (cStock.get(item - 1) == 0) {
                                System.out.println("Item out of Stock. Choose a different product.\nEnter the number of the item you like to buy:");
                                item = sc.nextInt();
                            }
                            // # of items
                            System.out.println("Enter the amount you like to buy:");
                            stockAmount = sc.nextInt();
                            // Check if # of item goes over stock
                            while (cStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                //If larger than stock or -ve, make user try again
                                System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                            }
                            // Confirmation to add to cart, change stock or cancel purchase
                            System.out.println("Would you like to add " + stockAmount + " item(s) of " + clothingP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount of items, or \"Cancel\" purchase:");
                            sc.nextLine();
                            action = sc.nextLine();
                            // If not correct , make user try again
                            while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                System.out.println("Invalid input, please try again.");
                                action = sc.nextLine();
                            }
                            // If unhappy with stock
                            while (action.equals("Change")) {
                                // # of items
                                System.out.println("Enter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                                // Check if # of item goes over stock
                                while (cStock.get(item - 1) - stockAmount < 0) {
                                    //If larger than stock or -ve, make user try again
                                    System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                    stockAmount = sc.nextInt();
                                }
                                // Confirmation to add to cart, change stock or cancel purchase
                                System.out.println("Would you like to add " + stockAmount + " item(s) of " + clothingP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount of items, or \"Cancel\" purchase:");
                                sc.nextLine();
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                            // If unhappy with purchase
                            if (action.equals("Cancel")) {
                                // Purchase, Categories, Cart, or End
                                System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                            // if happy with purchase
                            if (action.equals("Yes")) {
                                // Updated Stock
                                cStock.set(item - 1, cStock.get(item - 1) - stockAmount);
                                //Add item to cart
                                cart.add(clothingP[item - 1]);
                                //Add price of item to cart
                                cartPrice.add(cPrice[item - 1]);
                                //Add stock of item to cart
                                cartStock.add(stockAmount);
                                // add total of item price * stock
                                cartTotal.add(cPrice[item - 1] * stockAmount);
                                // Purchase, Categories, Cart, or End
                                System.out.println("Added to Cart.\nWould you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                        }
                        i = 1;
                        break;
                    case "Books":
                        // Show Products, Price, and Stock
                        for (String items : bookP) {
                            //Show Products & Price
                            System.out.print("\"" + i + "\" " + items + "\nPrice: $" + bPrice[i - 1]);
                            // Show Stock
                            if (bStock.get(i - 1) == 0)
                                // Stock = 0
                                System.out.println("\nStock: Out of Stock");
                            else
                                // Stock > 0
                                System.out.println("\nStock: " + bStock.get(i - 1));
                            i++;
                        }
                        // Purchase, Categories, Cart, or End
                        System.out.println("Would you like to \"Purchase\", browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                        action = sc.nextLine();
                        // If not correct , make user try again
                        while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                            System.out.println("Invalid input, please try again.");
                            action = sc.nextLine();
                        }
                        // While Purchasing within chosen Category
                        while (action.equals("Purchase")) {
                            System.out.println("Enter the number of the item you like to buy:");
                            // # in front of item when shown
                            item = sc.nextInt();
                            // If not correct , make user try again
                            while (item != 1 && item != 2 && item != 3) {
                                System.out.println("Invalid input, please try again.");
                                item = sc.nextInt();
                            }
                            // Check Stock
                            while (bStock.get(item - 1) == 0) {
                                System.out.println("Item out of Stock. Choose a different product.\nEnter the number of the item you like to buy:");
                                item = sc.nextInt();
                            }
                            // # of items
                            System.out.println("Enter the amount you like to buy:");
                            stockAmount = sc.nextInt();
                            // Check if # of item goes over stock
                            while (bStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                //If larger than stock or -ve, make user try again
                                System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                            }
                            // Confirmation to add to cart, change stock or cancel purchase
                            System.out.println("Would you like to add " + stockAmount + " item(s) of " + bookP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount of items, or \"Cancel\" purchase:");
                            sc.nextLine();
                            action = sc.nextLine();
                            // If not correct , make user try again
                            while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                System.out.println("Invalid input, please try again.");
                                action = sc.nextLine();
                            }
                            // If unhappy with stock
                            while (action.equals("Change")) {
                                // # of items
                                System.out.println("Enter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                                // Check if # of item goes over stock
                                while (bStock.get(item - 1) - stockAmount < 0) {
                                    //If larger than stock or -ve, make user try again
                                    System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                    stockAmount = sc.nextInt();
                                }
                                // Confirmation to add to cart, change stock or cancel purchase
                                System.out.println("Would you like to add " + stockAmount + " items of " + bookP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount of items, or \"Cancel\" purchase:");
                                sc.nextLine();
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                            // If unhappy with purchase
                            if (action.equals("Cancel")) {
                                // Purchase, Categories, Cart, or End
                                System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                            // if happy with purchase
                            if (action.equals("Yes")) {
                                // Updated Stock
                                bStock.set(item - 1, bStock.get(item - 1) - stockAmount);
                                //Add item to cart
                                cart.add(bookP[item - 1]);
                                //Add price of item to cart
                                cartPrice.add(bPrice[item - 1]);
                                //Add stock of item to cart
                                cartStock.add(stockAmount);
                                // add total of item price * stock
                                cartTotal.add(bPrice[item - 1] * stockAmount);
                                // Purchase, Categories, Cart, or End
                                System.out.println("Added to Cart.\nWould you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                action = sc.nextLine();
                                // If not correct , make user try again
                                while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again.");
                                    action = sc.nextLine();
                                }
                            }
                        }
                        i = 1;
                        break;
                    case "Categories":
                        //Chose Category
                        System.out.println("To see the selection of products, Type the name of the category");
                        //Print out Category
                        for (String categories : category)
                            System.out.println("\"" + categories + "\"");
                        //Choose
                        action = sc.nextLine();
                        // If not correct , make user try again
                        while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
                            System.out.println("Invalid input, please try again.");
                            action = sc.nextLine();
                        }
                        break;
                    case "Cart":
                        if (cart.size() == 0) {
                            System.out.println("You have no items in your cart.");
                            //Categories or End
                            System.out.println("Would you like to browse \"Categories\" or \"End\" experience:");
                            action = sc.nextLine();
                            // If not correct , make user try again
                            while (!action.equals("Categories") && !action.equals("End")) {
                                System.out.println("Invalid input, please try again.");
                                action = sc.nextLine();
                            }
                            break;
                        }
                        System.out.println("My Cart.\nItem:");
                        System.out.println("j:cart.size()"+j + " " + cart.size());
                        while (j < cart.size()) {
                            System.out.println("1j:cart.size()"+j + " " + cart.size());
                            System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nTotal: $" + cartTotal.get(j));
                            total += cartTotal.get(j);
                            j++;
                            System.out.println("2j:cart.size()"+j + " " + cart.size());
                        }
                        System.out.println("Total: $" + total);
                        // Buy, Change, Categories, or End
                        System.out.println("Would you like to \"Buy\", \"Change\" amounts of items, browse \"Categories\", or \"End\" experience:");
                        action = sc.nextLine();
                        // If not correct , make user try again
                        while (!action.equals("Buy") && !action.equals("Change") && !action.equals("Categories") && !action.equals("End")) {
                            System.out.println("Invalid input, please try again.");
                            action = sc.nextLine();
                        }
                        break;
                }
            }
            System.out.println("Thank you for ordering form our store!");
        }
        sc.close();
    }
}