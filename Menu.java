
import java.util.*;

public class Menu 
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();

        Scanner input = new Scanner(System.in);
        boolean programRuns = true, shopOptionsMenu = true;
        String operationChoice;
        String shopOptionsChoice;

        System.out.println("Welcome to the Shop Finding and Navigation System!");

        printOptions();

        while(programRuns)
        {
            // User choice for adding, removing or updating a shop.
            System.out.print("\nOperation: ");
            operationChoice = input.nextLine();

            if(operationChoice.equals("1"))
            {
                System.out.println("\n(Adding a shop)");

                // Every time the user chooses to add a shop, the user has to enter the number,
                // name, category, location and rating. Once they are valid and entered, it is added
                // to the graph.
                System.out.println("\nEnter new shop's number.");
                int shopNumber = shopNumber(input);

                // Only continue adding the other shop details if it is unique (i.e., never existed)
                if(graph.getVertex(shopNumber) == null)
                {
                    System.out.println("\nEnter new shop's name.");
                    String shopName = shopName(input);

                    System.out.println("\nEnter new shop's category.");
                    String shopCategory = shopCategory(input);

                    System.out.println("\nEnter new shop's location.");
                    String shopLocation = shopLocation(input);

                    System.out.println("\nEnter new shop's rating (1 to 5 stars).");
                    int shopRating = shopRating(input);

                    Shop newShop = new Shop(shopNumber, shopName, shopCategory, shopLocation, shopRating);

                    graph.addVertex(newShop.getNumber(), newShop);
                }
                else
                {
                    System.out.println("That shop number already exists! Please enter a unique one.");
                }
            }
            else if(operationChoice.equals("2"))
            {
                System.out.println("\n(Removing a shop)");

                System.out.println("Enter shop number to be removed.");
                int shopNumberToRemove = shopNumber(input);

                // Check if shop even exists before removing it
                if(graph.getVertex(shopNumberToRemove) == null)
                {
                    System.out.println("This shop does not even exist! Please add the shop first.");
                }
                else
                {
                    graph.removeVertex(shopNumberToRemove);
                }
            }
            else if(operationChoice.equals("3"))
            {
                System.out.println("\n(Updating a shop's information)");

                System.out.println("Enter shop number to be updated.");
                int shopNumber = shopNumber(input);

                // Check if shop even exists before updating it
                if(graph.getVertex(shopNumber) == null)
                {
                    System.out.println("This shop does not even exist! Please add the shop first.");
                }
                else
                {
                    printUpdateShopOptions();

                    while(shopOptionsMenu)
                    {
                        System.out.print("\nUpdate operation: ");
                        shopOptionsChoice = input.nextLine();

                        switch(shopOptionsChoice)
                        {
                            case "1":
                                int updatedShopNumber = shopNumber(input);
                                // Update the shop number
                                graph.getVertex(shopNumber).setLabel(updatedShopNumber);
                                
                                break;

                            case "2":
                                String updatedShopName = shopName(input);
                                // Update the shop name
                                graph.getVertex(shopNumber).getValue().setName(updatedShopName);

                                break;

                            case "3":
                                String updatedShopCategory = shopCategory(input);
                                // Update the shop category
                                graph.getVertex(shopNumber).getValue().setCategory(updatedShopCategory);

                                break;

                            case "4":
                                String updatedShopLocation = shopLocation(input);
                                // Update the shop location
                                graph.getVertex(shopNumber).getValue().setLocation(updatedShopLocation);

                                break;

                            case "5":
                                int updatedShopRating = shopRating(input);
                                // Update the shop rating
                                graph.getVertex(shopNumber).getValue().setRating(updatedShopRating);

                                break;

                            case "6":
                                shopOptionsMenu = false;
                                break;
                            
                            default:
                                System.out.println("Invalid choice!");
                                break;
                        }
                    }
                }
            }
            else if(operationChoice.equals("4"))
            {
                graph.displayAsList();
            }
            else if(operationChoice.equals("5"))
            {
                programRuns = false;
            }
            else
            {
                System.out.println("Invalid choice!");
            }
        }
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
        System.out.println("4) Display the list");
        System.out.println("5) Quit program");

        System.out.println();

        System.out.println("Please type the number for your desired operation.");
        System.out.println("e.g. '1' for adding a shop.");
        System.out.println("------------------------------------------------------------");
    }

    // Function that prints options available if user chooses to update shop information.
    public static void printUpdateShopOptions()
    {
        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println("Would you like to update:");
        System.out.println("1) Shop number");
        System.out.println("2) Shop name");
        System.out.println("3) Shop category");
        System.out.println("4) Shop location");
        System.out.println("5) Shop rating");
        System.out.println("6) Quit updating");

        System.out.println();

        System.out.println("Please type the number for your desired operation.");
        System.out.println("e.g. '1' for updating shop number");
        System.out.println("------------------------------------------------------------");
    }

    public static int shopNumber(Scanner input)
    {
        int shopNumber = 0;
        boolean validInput = false;

        while(!validInput)
        {
            try
            {
                System.out.print("Number: ");
                shopNumber = input.nextInt();
                input.nextLine();

                validInput = true;
            }
            catch(InputMismatchException error)
            {
                System.out.println("Shop number must only be an integer!");
                input.nextLine();
            }
        }

        return shopNumber;
    }

    public static String shopName(Scanner input)
    {
        String shopName;

        System.out.print("Name: ");
        shopName = input.nextLine();

        return shopName;
    }
    public static String shopCategory(Scanner input)
    {
        String shopCategory;

        System.out.print("Category: ");
        shopCategory = input.nextLine();

        return shopCategory;
    }
    public static String shopLocation(Scanner input)
    {
        String shopLocation;

        System.out.print("Location: ");
        shopLocation = input.nextLine();

        return shopLocation;
    }
    public static int shopRating(Scanner input)
    {
        int shopRating = 0;
        boolean validInput = false;

        while(!validInput)
        {
            try
            {
                System.out.print("Rating: ");
                shopRating = input.nextInt();
                input.nextLine();

                if((shopRating >= 0) && (shopRating <= 5))
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("Rating can only be an integer from 1 to 5!");
                }
            }
            catch(InputMismatchException error)
            {
                System.out.println("Rating can only be an integer from 1 to 5!");
                input.nextLine();
            }
        }

        return shopRating;
    }
}
