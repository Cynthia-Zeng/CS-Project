//Name: Cynthia Zeng
//Project: ISU Store
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\"User\" or \"Admin\"");
        String user = sc.nextLine();
        // Try again
        while (!user.equals("User") && !user.equals("Admin")) {
            System.out.println("Invalid input, please try again:");
            user= sc.nextLine();
        }
        String action = "Continue";
        // user && continuing to shop
        while (user.equals("User") && action.equals("Continue")) {
            // User experience begin
            System.out.println("Welcome User! Type \"Begin\" to start your experience:");
            action = sc.nextLine();
            // Try again
            while (!action.equals("Begin")) {
                System.out.println("Invalid input, please try again:");
                action = sc.nextLine();
            }
            // Categories
            String[] category = {"Electronics", "Clothing", "Books"};
            // Products, price, stock
            String[] electronicP = {"Computer", "Phone", "Tablet"};
            double[] ePrice = {279.99, 197.00, 119.99};
            // Random
            ArrayList<Integer> eStock = new ArrayList<>();
            for (int i = 0; i < 3; i++)
                eStock.add((int) (Math.random() * 10 + 0));
            String[] clothingP = {"T-shirt", "Sweater", "Shoes"};
            double[] cPrice = {19.90, 39.90, 130.00};
            ArrayList<Integer> cStock = new ArrayList<>();
            for (int i = 0; i < 3; i++)
                cStock.add((int) (Math.random() * 10 + 0));
            String[] bookP = {"Harry Potter", "Percy Jackson", "Hunger Games"};
            double[] bPrice = {11.79, 20.24, 25.89};
            ArrayList<Integer> bStock = new ArrayList<>();
            for (int i = 0; i < 3; i++)
                bStock.add((int) (Math.random() * 10 + 0));
            // Cart
            int j;
            int item;
            int stockAmount;
            double total = 0.0;
            String newStock;
            ArrayList<String> cart = new ArrayList<>();
            ArrayList<Double> cartPrice = new ArrayList<>();
            ArrayList<Double> cartTotal = new ArrayList<>();
            ArrayList<Integer> cartStock = new ArrayList<>();
            int i = 1;
            // Loop until use done
            while (!action.equals("End")) {
                // Print out category
                System.out.println("Categories:");
                for (String categories : category)
                    //name
                    System.out.println("\"" + categories + "\"");
                System.out.println("To see the selection of products, Type the name of the category:");
                action = sc.nextLine();
                // try again
                while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
                    System.out.println("Invalid input, please try again:");
                    action = sc.nextLine();
                }
                //loop until buy, or ending experience
                while (!action.equals("Buy") && !action.equals("End")) {
                    switch (action) {
                        //show category
                        case "Electronics":
                            //show product
                            System.out.println("Products:");
                            for (String items : electronicP) {
                                // #, name, price
                                System.out.print("\"" + i + "\" " + items + "\nPrice: $" + ePrice[i - 1]);
                                // Out of stock
                                if (eStock.get(i - 1) == 0)
                                    System.out.println("\nStock: Out of Stock");
                                // stock = 0
                                else
                                    System.out.println("\nStock: " + eStock.get(i - 1));
                                i++;
                            }
                            // Purchase, browse, cart, end
                            System.out.println("Would you like to \"Purchase\", browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                            action = sc.nextLine();
                            // try again
                            while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                System.out.println("Invalid input, please try again:");
                                action = sc.nextLine();
                            }
                            // Purchase
                            while (action.equals("Purchase")) {
                                System.out.println("Enter the number of the item you like to buy:");
                                item = sc.nextInt();
                                // try again
                                while (item != 1 && item != 2 && item != 3) {
                                    System.out.println("Invalid input, please try again:");
                                    item = sc.nextInt();
                                }
                                //Item out of stock
                                while (eStock.get(item - 1) == 0) {
                                    System.out.println("Item out of Stock. Choose a different product.\nEnter the number of the item you like to buy:");
                                    item = sc.nextInt();
                                }
                                // Stock
                                System.out.println("Enter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                                // If stock - new stock > avaliable or < 0
                                while (eStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                    // stock - new stock > avaliable
                                    if (eStock.get(item - 1) - stockAmount < 0)
                                        System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                    // new stock < 0
                                    else
                                        System.out.println("Invalid input, please try again:");
                                    stockAmount = sc.nextInt();
                                }
                                System.out.println("Would you like to add " + stockAmount + " item(s) of " + electronicP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount, or \"Cancel\":");
                                sc.nextLine();
                                action = sc.nextLine();
                                // try again
                                while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                                // If unhappy with stock
                                while (action.equals("Change")) {
                                    // Stock
                                    System.out.println("Enter the amount you like to buy:");
                                    stockAmount = sc.nextInt();
                                    // If stock > avaliable or < 0
                                    while (eStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                        // stock > avaliable
                                        if (eStock.get(item - 1) - stockAmount < 0)
                                            System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                        // stock < 0
                                        else
                                            System.out.println("Invalid input, please try again:");
                                        stockAmount = sc.nextInt();
                                    }
                                    System.out.println("Would you like to add " + stockAmount + " item(s) of " + electronicP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount, or \"Cancel\":");
                                    sc.nextLine();
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // If unhappy with purchase
                                if (action.equals("Cancel")) {
                                    i = 1;
                                    // show products
                                    System.out.println("Products:");
                                    for (String items : electronicP) {
                                        // #, name
                                        System.out.print("\"" + i + "\" " + items + "\nPrice: $" + ePrice[i - 1]);
                                        // out of stock
                                        if (eStock.get(i - 1) == 0)
                                            System.out.println("\nStock: Out of Stock");
                                        //stock
                                        else
                                            System.out.println("\nStock: " + eStock.get(i - 1));
                                        i++;
                                    }
                                    System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    //try again
                                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // If happy with purchase
                                if (action.equals("Yes")) {
                                    // If cart already has item
                                    if (cart.contains(electronicP[item - 1])) {
                                        // Updated Stock
                                        eStock.set(item - 1, eStock.get(item - 1) - stockAmount);
                                        // Update stock in cart
                                        cartStock.set(cart.indexOf(electronicP[item - 1]), cartStock.get(cart.indexOf(electronicP[item - 1])) + stockAmount);
                                        // Update total
                                        cartTotal.set(cart.indexOf(electronicP[item - 1]), ePrice[item - 1] * stockAmount + cartTotal.get(cart.indexOf(electronicP[item - 1])));
                                    }
                                    // No item already
                                    else {
                                        // Updated Stock
                                        eStock.set(item - 1, eStock.get(item - 1) - stockAmount);
                                        // Add item to cart
                                        cart.add(electronicP[item - 1]);
                                        // Add price of item to cart
                                        cartPrice.add(ePrice[item - 1]);
                                        // Add stock of item to cart
                                        cartStock.add(stockAmount);
                                        // Add total of item price * stock
                                        cartTotal.add(ePrice[item - 1] * stockAmount);
                                    }
                                    // Confirm
                                    System.out.println("Added to Cart.");
                                    // Show Cart
                                    System.out.println("Your Cart:\nItem(s):");
                                    // Loop util 1 less than cart size
                                    for (j = 0; j < cart.size(); j++) {
                                        // #, name, price, stock, item total
                                        System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                        // Sum up total
                                        total += cartTotal.get(j);
                                    }
                                    // Total of Cart
                                    System.out.println("Total: $" + total + "\n");
                                    total = 0;
                                    i = 1;
                                    // show products
                                    for (String items : electronicP) {
                                        // #, name, price
                                        System.out.print("\"" + i + "\" " + items + "\nPrice: $" + ePrice[i - 1]);
                                        //out of stock
                                        if (eStock.get(i - 1) == 0)
                                            System.out.println("\nStock: Out of Stock");
                                        //stock
                                        else
                                            System.out.println("\nStock: " + eStock.get(i - 1));
                                        i++;
                                    }
                                    System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    //try again
                                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                            }
                            i = 1;
                            break;
                        // Show category
                        case "Clothing":
                            // Show product
                            System.out.println("Products:");
                            for (String items : clothingP) {
                                // #, name, price
                                System.out.print("\"" + i + "\" " + items + "\nPrice: $" + cPrice[i - 1]);
                                // Out of stock
                                if (cStock.get(i - 1) == 0)
                                    System.out.println("\nStock: Out of Stock");
                                // Stock
                                else
                                    System.out.println("\nStock: " + cStock.get(i - 1));
                                i++;
                            }
                            // Purchase, browse, cart, end
                            System.out.println("Would you like to \"Purchase\", browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                            action = sc.nextLine();
                            //try again
                            while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                System.out.println("Invalid input, please try again:");
                                action = sc.nextLine();
                            }
                            // Purchase
                            while (action.equals("Purchase")) {
                                System.out.println("Enter the number of the item you like to buy:");
                                item = sc.nextInt();
                                //try again
                                while (item != 1 && item != 2 && item != 3) {
                                    System.out.println("Invalid input, please try again:");
                                    item = sc.nextInt();
                                }
                                // Item out of stock
                                while (cStock.get(item - 1) == 0) {
                                    System.out.println("Item out of Stock. Choose a different product.\nEnter the number of the item you like to buy:");
                                    item = sc.nextInt();
                                }
                                // Stock
                                System.out.println("Enter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                                // If stock - new stock > avaliable or < 0
                                while (cStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                    //stock - new stock > avaliable
                                    if (cStock.get(item - 1) - stockAmount < 0)
                                        System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                    // new stock < 0
                                    else
                                        System.out.println("Invalid input, please try again:");
                                    stockAmount = sc.nextInt();
                                }
                                System.out.println("Would you like to add " + stockAmount + " item(s) of " + clothingP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount, or \"Cancel\":");
                                sc.nextLine();
                                action = sc.nextLine();
                                // try again
                                while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                                // If unhappy with stock
                                while (action.equals("Change")) {
                                    // stock
                                    System.out.println("Enter the amount you like to buy:");
                                    stockAmount = sc.nextInt();
                                    // If stock - new stock > avaliable or < 0
                                    while (cStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                        // stock - new stock > avaliable
                                        if (cStock.get(item - 1) - stockAmount < 0)
                                            System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                        // new stock < 0
                                        else
                                            System.out.println("Invalid input, please try again:");
                                        stockAmount = sc.nextInt();
                                    }
                                    System.out.println("Would you like to add " + stockAmount + " item(s) of " + clothingP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount, or \"Cancel\":");
                                    sc.nextLine();
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // If unhappy with purchase
                                if (action.equals("Cancel")) {
                                    i = 1;
                                    // show products
                                    System.out.println("Products:");
                                    for (String items : clothingP) {
                                        //#,name,price
                                        System.out.print("\"" + i + "\" " + items + "\nPrice: $" + cPrice[i - 1]);
                                        //out of stock
                                        if (cStock.get(i - 1) == 0)
                                            System.out.println("\nStock: Out of Stock");
                                        // stock
                                        else
                                            System.out.println("\nStock: " + cStock.get(i - 1));
                                        i++;
                                    }
                                    System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    //try again
                                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // if happy with purchase
                                if (action.equals("Yes")) {
                                    // if cart already has item
                                    if (cart.contains(clothingP[item - 1])) {
                                        // Updated Stock
                                        cStock.set(item - 1, cStock.get(item - 1) - stockAmount);
                                        // Update stock in cart
                                        cartStock.set(cart.indexOf(clothingP[item - 1]), cartStock.get(cart.indexOf(clothingP[item - 1])) + stockAmount);
                                        // Update total
                                        cartTotal.set(cart.indexOf(clothingP[item - 1]), cPrice[item - 1] * stockAmount + cartTotal.get(cart.indexOf(clothingP[item - 1])));
                                    }
                                    // no item already
                                    else {
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
                                    }
                                    // Confirm
                                    System.out.println("Added to Cart.");
                                    // Show Cart
                                    System.out.println("Your Cart:\nItem(s):");
                                    // Loop util 1 less than cart size
                                    for (j = 0; j < cart.size(); j++) {
                                        // #, name, price, stock, item total
                                        System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                        // Sum up total
                                        total += cartTotal.get(j);
                                    }
                                    //Total of Cart
                                    System.out.println("Total: $" + total + "\n");
                                    total = 0;
                                    i = 1;
                                    //show product
                                    for (String items : clothingP) {
                                        //#, name, price
                                        System.out.print("\"" + i + "\" " + items + "\nPrice: $" + cPrice[i - 1]);
                                        // out of stock
                                        if (cStock.get(i - 1) == 0)
                                            System.out.println("\nStock: Out of Stock");
                                        // stock
                                        else
                                            System.out.println("\nStock: " + cStock.get(i - 1));
                                        i++;
                                    }
                                    System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                            }
                            i = 1;
                            break;
                        // Show category
                        case "Book":
                            // Show product
                            System.out.println("Products:");
                            for (String items : clothingP) {
                                // #, name, price
                                System.out.print("\"" + i + "\" " + items + "\nPrice: $" + bPrice[i - 1]);
                                // Out of stock
                                if (bStock.get(i - 1) == 0)
                                    System.out.println("\nStock: Out of Stock");
                                // Stock
                                else
                                    System.out.println("\nStock: " + bStock.get(i - 1));
                                i++;
                            }
                            // Purchase, browse, cart, end
                            System.out.println("Would you like to \"Purchase\", browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                            action = sc.nextLine();
                            while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                System.out.println("Invalid input, please try again:");
                                action = sc.nextLine();
                            }
                            // Purchase
                            while (action.equals("Purchase")) {
                                System.out.println("Enter the number of the item you like to buy:");
                                item = sc.nextInt();
                                // try again
                                while (item != 1 && item != 2 && item != 3) {
                                    System.out.println("Invalid input, please try again:");
                                    item = sc.nextInt();
                                }
                                // Item out of stock
                                while (bStock.get(item - 1) == 0) {
                                    System.out.println("Item out of Stock. Choose a different product.\nEnter the number of the item you like to buy:");
                                    item = sc.nextInt();
                                }
                                // Stock
                                System.out.println("Enter the amount you like to buy:");
                                stockAmount = sc.nextInt();
                                // If stock - new stock > avaliable or < 0
                                while (bStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                    // stock - new stock > avaliable
                                    if (bStock.get(item - 1) - stockAmount < 0)
                                        System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                    // new stock < 0
                                    else
                                        System.out.println("Invalid input, please try again:");
                                    stockAmount = sc.nextInt();
                                }
                                System.out.println("Would you like to add " + stockAmount + " item(s) of " + bookP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount, or \"Cancel\":");
                                sc.nextLine();
                                action = sc.nextLine();
                                // try again
                                while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                                // If unhappy with stock
                                while (action.equals("Change")) {
                                    // stock
                                    System.out.println("Enter the amount you like to buy:");
                                    stockAmount = sc.nextInt();
                                    // If stock - new stock > avaliable or < 0
                                    while (bStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                        //stock - new stock > avaliable
                                        if (bStock.get(item - 1) - stockAmount < 0)
                                            System.out.println("Not enough stock, please try again.\nEnter the amount you like to buy:");
                                        // new stock < 0
                                        else
                                            System.out.println("Invalid input, please try again:");
                                        stockAmount = sc.nextInt();
                                    }
                                    System.out.println("Would you like to add " + stockAmount + " item(s) of " + bookP[item - 1] + " to your cart.\n\"Yes\", \"Change\" the amount, or \"Cancel\":");
                                    sc.nextLine();
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Yes") && !action.equals("Change") && !action.equals("Cancel")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // If unhappy with purchase
                                if (action.equals("Cancel")) {
                                    i = 1;
                                    //show products
                                    System.out.println("Products:");
                                    for (String items : bookP) {
                                        //#, name, price
                                        System.out.print("\"" + i + "\" " + items + "\nPrice: $" + bPrice[i - 1]);
                                        //out of stock
                                        if (bStock.get(i - 1) == 0)
                                            System.out.println("\nStock: Out of Stock");
                                        // stock
                                        else
                                            System.out.println("\nStock: " + bStock.get(i - 1));
                                        i++;
                                    }
                                    System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // if happy with purchase
                                if (action.equals("Yes")) {
                                    // if cart already has item
                                    if (cart.contains(bookP[item - 1])) {
                                        // Updated Stock
                                        bStock.set(item - 1, bStock.get(item - 1) - stockAmount);
                                        // Update stock in cart
                                        cartStock.set(cart.indexOf(bookP[item - 1]), cartStock.get(cart.indexOf(bookP[item - 1])) + stockAmount);
                                        // Update total
                                        cartTotal.set(cart.indexOf(bookP[item - 1]), bPrice[item - 1] * stockAmount + cartTotal.get(cart.indexOf(bookP[item - 1])));
                                    }
                                    // no item already
                                    else {
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
                                    }
                                    // Confirm
                                    System.out.println("Added to Cart.");
                                    // Show Cart
                                    System.out.println("Your Cart:\nItem(s):");
                                    // Loop util 1 less than cart size
                                    for (j = 0; j < cart.size(); j++) {
                                        // #, name, price, stock, item total
                                        System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                        // Sum up total
                                        total += cartTotal.get(j);
                                    }
                                    //Total of Cart
                                    System.out.println("Total: $" + total + "\n");
                                    total = 0;
                                    i = 1;
                                    // show products
                                    for (String items : bookP) {
                                        //#, name, $
                                        System.out.print("\"" + i + "\" " + items + "\nPrice: $" + bPrice[i - 1]);
                                        // no stock
                                        if (bStock.get(i - 1) == 0)
                                            System.out.println("\nStock: Out of Stock");
                                        //stock
                                        else
                                            System.out.println("\nStock: " + bStock.get(i - 1));
                                        i++;
                                    }
                                    System.out.println("Would you like to \"Purchase\" other items, browse \"Categories\", head to \"Cart\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    //try again
                                    while (!action.equals("Purchase") && !action.equals("Categories") && !action.equals("Cart") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                            }
                            i = 1;
                            break;
                        case "Categories":
                            // Show Categories
                            System.out.println("Categories:");
                            for (String categories : category)
                                //name
                                System.out.println("\"" + categories + "\"");
                            System.out.println("To see the selection of products, Type the name of the category:");
                            action = sc.nextLine();
                            //try again
                            while (!action.equals("Electronics") && !action.equals("Clothing") && !action.equals("Books")) {
                                System.out.println("Invalid input, please try again:");
                                action = sc.nextLine();
                            }
                            break;
                        case "Cart":
                            //If cart empty
                            if (cart.size() == 0) {
                                System.out.println("My Cart:\nYour cart is empty.");
                                System.out.println("Would you like to browse \"Categories\" or \"End\" experience:");
                                action = sc.nextLine();
                                while (!action.equals("Categories") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                                break;
                            }
                            // Show cart
                            System.out.println("My Cart:\nItem(s):");
                            for (j = 0; j < cart.size(); j++) {
                                System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                total += cartTotal.get(j);
                            }
                            //cart toal
                            System.out.println("Total: $" + total + "\n");
                            total = 0;
                            // Buy, stock, remove, categories, end
                            System.out.println("Would you like to \"Buy\", \"Change\" amounts, \"Remove\" an item, browse \"Categories\", or \"End\" experience:");
                            action = sc.nextLine();
                            //try again
                            while (!action.equals("Buy") && !action.equals("Change") && !action.equals("Remove") && !action.equals("Categories") && !action.equals("End")) {
                                System.out.println("Invalid input, please try again:");
                                action = sc.nextLine();
                            }
                            // change
                            while (action.equals("Change")) {
                                System.out.println("Enter the number of the item you like to change:");
                                item = sc.nextInt();
                                while (item <= 0 || item > cart.size()) {
                                    System.out.println("Invalid input, please try again:");
                                    item = sc.nextInt();
                                }
                                // down. up, cancel
                                System.out.println("Stock \"-\" " + cartStock.get(item - 1) + " \"+\", or \"Cancel\"");
                                sc.nextLine();
                                action = sc.nextLine();
                                //try again
                                while (!action.equals("-") && !action.equals("+") && !action.equals("Cancel")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                                // Have less stock
                                if (action.equals("-")) {
                                    System.out.println("Enter how much less stock you want:");
                                    stockAmount = sc.nextInt();
                                    // Cart stock - new stock < 0 or new stock < 0
                                    while (cartStock.get(item - 1) - stockAmount < 0 || stockAmount < 0) {
                                        // Cart stock - new stock < 0
                                        if (cartStock.get(item - 1) - stockAmount < 0)
                                            System.out.println("Not enough stock, please try again:");
                                        // new stock < 0
                                        else
                                            System.out.println("Invalid input, please try again:");
                                        stockAmount = sc.nextInt();
                                    }
                                    // Cart stock - new stock > 0
                                    if (cartStock.get(item - 1) - stockAmount > 0) {
                                        // change cart stock of item, to cart stock - new stock
                                        cartStock.set(item - 1, cartStock.get(item - 1) - stockAmount);
                                        // Change item total to be new cart stock * item price
                                        cartTotal.set(item - 1, cartStock.get(item - 1) * cartPrice.get(item - 1));
                                        // search electronics Product
                                        for (j = 0; j < electronicP.length; j++) {
                                            newStock = electronicP[j];
                                            // if product = changed cart item
                                            if (newStock.equals(cart.get(item - 1))) {
                                                // update product stock
                                                eStock.set(eStock.get(j), eStock.get(j) + stockAmount);
                                                break;
                                            }
                                        }
                                        // search clothing Product
                                        for (j = 0; j < clothingP.length; j++) {
                                            newStock = clothingP[j];
                                            // if product = changed cart item
                                            if (newStock.equals(cart.get(item - 1))) {
                                                // update product stock
                                                eStock.set(eStock.get(j), eStock.get(j) + stockAmount);
                                                break;
                                            }
                                        }
                                        // check product
                                        for (j = 0; j < bookP.length; j++) {
                                            newStock = bookP[j];
                                            // if product = changed cart item
                                            if (newStock.equals(cart.get(item - 1))) {
                                                // update product stock
                                                bStock.set(bStock.get(j), bStock.get(j) + stockAmount);
                                                break;
                                            }
                                        }
                                    }
                                    // updated stock make item = 0
                                    else {
                                        // remove from cart
                                        cart.remove(item - 1);
                                        cartPrice.remove(item - 1);
                                        cartStock.remove(item - 1);
                                        cartTotal.remove(item - 1);
                                    }
                                    // if new cart has no items
                                    if (cart.size() == 0) {
                                        System.out.println("My Cart:\nYour cart is empty.");
                                        System.out.println("Would you like to browse \"Categories\" or \"End\" experience:");
                                        action = sc.nextLine();
                                        //try again
                                        while (!action.equals("Categories") && !action.equals("End")) {
                                            System.out.println("Invalid input, please try again:");
                                            action = sc.nextLine();
                                        }
                                        break;
                                    }
                                    // show cart
                                    else {
                                        System.out.println("My Cart:\nItem(s):");
                                        // loop unitl all items shown
                                        for (j = 0; j < cart.size(); j++) {
                                            //#, name,$, stock, Total
                                            System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                            //sum up total
                                            total += cartTotal.get(j);
                                        }
                                    }
                                    //total
                                    System.out.println("Total: $" + total + "\n");
                                    total = 0;
                                    System.out.println("Would you like to \"Buy\", \"Change\" amounts, \"Remove\" an item, browse \"Categories\", or \"End\" experience:");
                                    sc.nextLine();
                                    action = sc.nextLine();
                                    //try again
                                    while (!action.equals("Buy") && !action.equals("Change") && !action.equals("Remove") && !action.equals("Categories") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                // adding stock
                                else if (action.equals("+")) {
                                    System.out.println("Enter how much more stock you want:");
                                    stockAmount = sc.nextInt();
                                    int count = 0;
                                    // check electronic products
                                    for (j = 0; j < electronicP.length; j++) {
                                        newStock = electronicP[j];
                                        // if items =
                                        if (newStock.equals(cart.get(item - 1))) {
                                            // check for stock
                                            while (eStock.get(j) < stockAmount || stockAmount < 0) {
                                                if (eStock.get(j) < stockAmount)
                                                    System.out.println("Not enough stock, please try again.");
                                                else
                                                    System.out.println("Invalid input, please try again.");
                                                System.out.println("Enter how much more stock you want:");
                                                stockAmount = sc.nextInt();
                                            }
                                            //update stock and counter
                                            eStock.set(j, eStock.get(j) - stockAmount);
                                            count++;
                                            break;
                                        }
                                    }
                                    // if above product no update
                                    if (count == 0)
                                        // check products
                                        for (j = 0; j < clothingP.length; j++) {
                                            newStock = clothingP[j];
                                            // check item =
                                            if (newStock.equals(cart.get(item - 1))) {
                                                // check stock
                                                while (cStock.get(j) < stockAmount || stockAmount < 0) {
                                                    if (cStock.get(j) < stockAmount)
                                                        System.out.println("Not enough stock, please try again.");
                                                    else
                                                        System.out.println("Invalid input, please try again.");
                                                    System.out.println("Enter how much more stock you want:");
                                                    stockAmount = sc.nextInt();
                                                }
                                                // updated stock and counter
                                                cStock.set(j, cStock.get(j) - stockAmount);
                                                count++;
                                                break;
                                            }
                                        }
                                    //counter no update
                                    if (count == 0)
                                        // check product
                                        for (j = 0; j < bookP.length; j++) {
                                            newStock = bookP[j];
                                            // check items
                                            if (newStock.equals(cart.get(item - 1))) {
                                                // check stock
                                                while (bStock.get(j) < stockAmount || stockAmount < 0) {
                                                    if (bStock.get(j) < stockAmount)
                                                        System.out.println("Not enough stock, please try again.");
                                                    else
                                                        System.out.println("Invalid input, please try again.");
                                                    System.out.println("Enter how much more stock you want:");
                                                    stockAmount = sc.nextInt();
                                                }
                                                // update stock
                                                bStock.set(j, bStock.get(j) - stockAmount);
                                                break;
                                            }
                                        }
                                    // change cart stock
                                    cartStock.set(item - 1, cartStock.get(item - 1) + stockAmount);
                                    // change cart total
                                    cartTotal.set(item - 1, cartStock.get(item - 1) * cartPrice.get(item - 1));
                                    //show cart
                                    System.out.println("My Cart:\nItem(s):");
                                    for (j = 0; j < cart.size(); j++) {
                                        System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                        total += cartTotal.get(j);
                                    }
                                    System.out.println("Total: $" + total + "\n");
                                    total = 0;
                                    System.out.println("Would you like to \"Buy\", \"Change\" amounts, \"Remove\" an item, browse \"Categories\", or \"End\" experience:");
                                    sc.nextLine();
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Buy") && !action.equals("Change") && !action.equals("Remove") && !action.equals("Categories") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                    break;
                                }
                                // cancel
                                else if (action.equals("Cancel")) {
                                    System.out.println("Would you like to \"Buy\", \"Change\" amounts, \"Remove\" an item, browse \"Categories\", or \"End\" experience:");
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("Buy") && !action.equals("Change") && !action.equals("Remove") && !action.equals("Categories") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                            }
                            // remove item
                            while (action.equals("Remove")) {
                                // #
                                System.out.println("Enter the number of the item you like to remove:");
                                item = sc.nextInt();
                                // try again
                                while (item <= 0 || item > cart.size()) {
                                    System.out.println("Invalid input, please try again:");
                                    item = sc.nextInt();
                                }
                                int count = 0;
                                //check product
                                for (j = 0; j < electronicP.length; j++) {
                                    newStock = electronicP[j];
                                    // check item
                                    if (newStock.equals(cart.get(item - 1))) {
                                        // update stock
                                        eStock.set(j, eStock.get(j) + cartStock.get(item - 1));
                                        count++;
                                        break;
                                    }
                                }
                                // counter no update
                                if (count == 0)
                                    // check product
                                    for (j = 0; j < clothingP.length; j++) {
                                        newStock = clothingP[j];
                                        // check item
                                        if (newStock.equals(cart.get(item - 1))) {
                                            // update stock
                                            cStock.set(j, cStock.get(j) + cartStock.get(item - 1));
                                            count++;
                                            break;
                                        }
                                    }
                                // counter no update
                                if (count == 0)
                                    // check product
                                    for (j = 0; j < bookP.length; j++) {
                                        newStock = bookP[j];
                                        // check item
                                        if (newStock.equals(cart.get(item - 1))) {
                                            // update stock
                                            bStock.set(j, bStock.get(j) + cartStock.get(item - 1));
                                            break;
                                        }
                                    }
                                // remove form cart
                                cart.remove(item - 1);
                                cartPrice.remove(item - 1);
                                cartStock.remove(item - 1);
                                cartTotal.remove(item - 1);
                                // empty cart
                                if (cart.size() == 0) {
                                    System.out.println("My Cart:\nYour cart is empty.");
                                    System.out.println("Would you like to browse \"Categories\" or \"End\" experience:");
                                    action = sc.nextLine();
                                    //try again
                                    while (!action.equals("Categories") && !action.equals("End")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                    break;
                                }
                                //show cart
                                System.out.println("My Cart:\nItem(s):");
                                for (j = 0; j < cart.size(); j++) {
                                    System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                    total += cartTotal.get(j);
                                }
                                // totals
                                System.out.println("Total: $" + total + "\n");
                                total = 0;
                                System.out.println("Would you like to \"Buy\", \"Change\" amounts, \"Remove\" an item, browse \"Categories\", or \"End\" experience:");
                                sc.nextLine();
                                action = sc.nextLine();
                                // try again
                                while (!action.equals("Buy") && !action.equals("Change") && !action.equals("Remove") && !action.equals("Categories") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                            }
                            break;
                        case "Buy":
                            // bought
                            if (action.equals("Buy")) {
                                // Show invoice
                                System.out.println("Invoice:\nItem(s):");
                                for (j = 0; j < cart.size(); j++) {
                                    // #,name,$, stock, item totals
                                    System.out.println("\"" + (j + 1) + "\" " + cart.get(j) + "\nPrice: $" + cartPrice.get(j) + "\nStock: " + cartStock.get(j) + "\nItem Total: $" + cartTotal.get(j));
                                    //sum up $
                                    total += cartTotal.get(j);
                                }
                                // totals
                                System.out.println("Total: $" + total + "\n");
                                total = 0;
                                System.out.println("Would you like to place the order? \"Buy\", browse \"Categories\", or \"End\" your experience:");
                                action = sc.nextLine();
                                //Try again
                                while (!action.equals("Buy") && !action.equals("Categories") && !action.equals("End")) {
                                    System.out.println("Invalid input, please try again:");
                                    action = sc.nextLine();
                                }
                                if (action.equals("Buy")) {
                                    for (j = 0; j < cart.size(); j++) {
                                        cart.remove(j);
                                        cartPrice.remove(j);
                                        cartStock.remove(j);
                                        cartTotal.remove(j);
                                    }
                                    System.out.println("Thank you for ordering from our store!\nWould you like to \"End\" your experience or \"Continue\"");
                                    action = sc.nextLine();
                                    // try again
                                    while (!action.equals("End") && !action.equals("Continue")) {
                                        System.out.println("Invalid input, please try again:");
                                        action = sc.nextLine();
                                    }
                                }
                                break;
                            }
                    }
                }
                // bought
                if (action.equals("Buy")) {
                    for (j = 0; j < cart.size(); j++) {
                        cart.remove(j);
                        cartPrice.remove(j);
                        cartStock.remove(j);
                        cartTotal.remove(j);
                    }
                    System.out.println("Thank you for ordering from our store!\nWould you like to \"End\" your experience or \"Continue\"");
                    action = sc.nextLine();
                    // try again
                    while (!action.equals("End") && !action.equals("Continue")) {
                        System.out.println("Invalid input, please try again:");
                        action = sc.nextLine();
                    }
                }
            }
        }
        while (user.equals("Admin") && !action.equals("End")) {
            // Admin experience begin
            System.out.println("Welcome Admin! Enter your password to login:");
            action = sc.nextLine();
            // Try again
            while (!action.equals("adminrocks!1")) {
                System.out.println("Incorrect password, please try again:");
                action = sc.nextLine();
            }
            action = "Menu";
            int count = 0;
            while (action.equals("Menu") && !action.equals("End")) {
                System.out.println("Menu:\nHere are the pending order(s)\n\"1\" Order 1\\nPlease enter the number to view the order:");
                int userNum = sc.nextInt();
                // Try again
                while (userNum < 1) {
                    System.out.println("Invalid input, please try again:");
                    userNum = sc.nextInt();
                }
                //user order
                //Not shipped yet
                if (count == 0) {
                    if (userNum == 1) {
                        //Order
                        String[] Order1 = {"\"1\" Computer", "Price: $279.99", "Stock: 1", "Total: $$279.99"};
                        for (String items : Order1) {
                            // show order
                            System.out.println(items);
                        }
                        System.out.println("\"Ship\", \"Menu\", \"End\" Experience");
                        sc.nextLine();
                        action = sc.nextLine();
                        //try again
                        while (!action.equals("Ship") && !action.equals("Menu") && !action.equals("End")) {
                            System.out.println("Invalid input, please try again:");
                            action = sc.nextLine();
                        }
                        if (action.equals("Ship")) {
                            count++;
                            System.out.println("Orders Shipped Out. Will arrive to customer in 2 - 3 weeks.\n\"Menu\" or \"End\" experience");
                            action = sc.nextLine();
                            //try again
                            while (!action.equals("Menu") && !action.equals("End")) {
                                System.out.println("Invalid input, please try again:");
                                action = sc.nextLine();
                            }
                        }
                    }
                } else {
                    System.out.println("Order Shipped.\n\"Menu\" or \"End\" experience");
                    action = sc.nextLine();
                    //try again
                    while (!action.equals("Menu") && !action.equals("End")) {
                        System.out.println("Invalid input, please try again:");
                        action = sc.nextLine();
                    }
                }
            }
        }
        System.out.println("Have a good day!");
        sc.close();
    }
}