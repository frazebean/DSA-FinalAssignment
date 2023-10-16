
import java.util.*;

public class Menu 
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();

        Scanner input = new Scanner(System.in);
        boolean programRuns = true;
        int operationChoice;

        System.out.println("Welcome to the Shop Finding and Navigation System!");

        printOptions();

        while(programRuns)
        {
            // User choice for adding, removing or updating a shop.
            System.out.print("\nOperation: ");
            operationChoice = input.nextInt();
            input.nextLine();

            if(operationChoice == 1)
            {
                System.out.println("\n(Adding a shop)");

                // Every time the user chooses to add a shop, the user has to enter the number,
                // name, category, location and rating. Once they are valid and entered, it is added
                // to the graph.
                int shopNumber = addShopNumber(input);
                String shopName = addShopName(input);
                String shopCategory = addShopCategory(input);
                String shopLocation = addShopLocation(input);
                int shopRating = addShopRating(input);

                Shop newShop = new Shop(shopNumber, shopName, shopCategory, shopLocation, shopRating);

                graph.addVertex(newShop.getNumber(), newShop);
            }
            else if(operationChoice == 2)
            {
                System.out.println("\n(Removing a shop)");

                System.out.print("Enter shop number: ");
                int shopNumber = input.nextInt();
                input.nextLine();

                graph.removeVertex(shopNumber);
            }
            else if(operationChoice == 3)
            {
                System.out.println("\n(Updating a shop's information)");
            }
        }

        graph.displayAsList();
    }

    // Function that prints options available for user to choose.
    public static void printOptions()
    {
        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println("Would you like to:");
        System.out.println("1) Add a shop");
        System.out.println("2) Remove a shop");
        System.out.println("3) Update a shop's information");

        System.out.println();

        System.out.println("Please type the number for your desired operation.");
        System.out.println("e.g. '1' for adding a shop.");
        System.out.println("------------------------------------------------------------");
    }

    public static int addShopNumber(Scanner input)
    {
        int shopNumber;

        System.out.print("Enter shop number: ");
        shopNumber = input.nextInt();
        input.nextLine();

        return shopNumber;
    }
    public static String addShopName(Scanner input)
    {
        String shopName;

        System.out.print("Enter shop name: ");
        shopName = input.nextLine();

        return shopName;
    }
    public static String addShopCategory(Scanner input)
    {
        String shopCategory;

        System.out.print("Enter shop category: ");
        shopCategory = input.nextLine();

        return shopCategory;
    }
    public static String addShopLocation(Scanner input)
    {
        String shopLocation;

        System.out.print("Enter shop location: ");
        shopLocation = input.nextLine();

        return shopLocation;
    }
    public static int addShopRating(Scanner input)
    {
        int shopRating;

        System.out.print("Enter shop rating: ");
        shopRating = input.nextInt();
        input.nextLine();

        return shopRating;
    }
}
