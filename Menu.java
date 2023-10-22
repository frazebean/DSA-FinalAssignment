
import java.util.*;

public class Menu 
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();

        int tableSize = 1000;
        DSAHashTable table = new DSAHashTable(tableSize);

        Scanner input = new Scanner(System.in);
        boolean programRuns = true;;
        String operationChoice;
        String shopOptionsChoice;

        System.out.println("Welcome to the Shop Finding and Navigation System!");

        printOptions();

        while(programRuns)
        {
            // User choice for adding, removing or updating a shop.
            System.out.println("\n(Type 'help' to display the help screen)");
            System.out.print("\nOperation: ");
            operationChoice = input.nextLine();

            if(operationChoice.equals("1"))  // Adding a shop node
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
                    table.put(newShop.getCategory(), newShop);
                }
                else
                {
                    System.out.println("That shop number already exists! Please enter a unique one.");
                }
            }
            else if(operationChoice.equals("2"))  // Removing a shop node
            {
                System.out.println("\n(Removing a shop)");

                System.out.println("\nEnter shop number to be removed.");
                int shopNumberToRemove = shopNumber(input);

                // Check if shop even exists before removing it
                if(graph.getVertex(shopNumberToRemove) == null)
                {
                    System.out.println("This shop does not exist! Unable to remove.");
                }
                else
                {
                    // Code responsible for removing shop from table.
                    String category = graph.getVertex(shopNumberToRemove).getValue().getCategory();
                    table.remove(category, shopNumberToRemove);

                    // Code responsible for removing shop from graph
                    graph.removeVertex(shopNumberToRemove);
                }
            }
            else if(operationChoice.equals("3"))  // Updating a shop's information
            {
                boolean shopOptionsMenu = true;

                System.out.println("\n(Updating a shop's information)");

                System.out.println("\nEnter shop number to be updated.");
                int shopNumberToUpdate = shopNumber(input);

                // Check if shop even exists before updating it
                if(graph.getVertex(shopNumberToUpdate) == null)
                {
                    System.out.println("This shop does not exist! Unable to update.");
                }
                else
                {
                    printUpdateShopOptions();

                    while(shopOptionsMenu)
                    {
                        System.out.println("\n(Type 'help' to display the help screen)");
                        System.out.print("Update operation: ");
                        shopOptionsChoice = input.nextLine();

                        switch(shopOptionsChoice)
                        {
                            case "1":
                                System.out.println("Enter updated shop number.");
                                int updatedShopNumber = shopNumber(input);
                                // Update the shop number LABEL (the graph key)
                                DSAGraphVertex vertex = graph.getVertex(shopNumberToUpdate);
                                vertex.setLabel(updatedShopNumber);
                                // Update the shop number VALUE (the graph value)
                                Shop newShop = vertex.getValue();
                                newShop.setNumber(updatedShopNumber);

                                break;

                            case "2":
                                System.out.println("Enter updated shop name.");
                                String updatedShopName = shopName(input);
                                // Update the shop name
                                graph.getVertex(shopNumberToUpdate).getValue().setName(updatedShopName);

                                break;

                            case "3":
                                System.out.println("Enter updated shop category.");
                                String updatedShopCategory = shopCategory(input);

                                // First, we remove the shop with old category from the graph
                                table.remove(graph.getVertex(shopNumberToUpdate).getValue().getCategory(), shopNumberToUpdate);

                                // Updating shop category via the graph
                                Shop updatedShop = graph.getVertex(shopNumberToUpdate).getValue();
                                updatedShop.setCategory(updatedShopCategory);

                                // Place this category with its new shop into a new linked list.
                                table.put(updatedShopCategory, updatedShop);

                                break;

                            case "4":
                                System.out.println("Enter updated shop location.");
                                String updatedShopLocation = shopLocation(input);
                                // Update the shop location
                                graph.getVertex(shopNumberToUpdate).getValue().setLocation(updatedShopLocation);

                                break;

                            case "5":
                                System.out.println("Enter updated shop rating.");
                                int updatedShopRating = shopRating(input);
                                // Update the shop rating
                                graph.getVertex(shopNumberToUpdate).getValue().setRating(updatedShopRating);

                                break;

                            case "6":
                                shopOptionsMenu = false;
                                break;

                            case "HELP": case "help":
                                printUpdateShopOptions();
                                break;
                            
                            default:
                                System.out.println("Invalid choice!");
                                break;
                        }
                    }
                }
            }
            else if(operationChoice.equals("4"))  // Adding pathways between shops (edges)
            {
                System.out.println("\n(Adding pathways between shops)");

                System.out.println("\nEnter the first shop's number.");
                int firstShop = shopNumber(input);

                // Do not add edges to the first shop if it does not exist.
                if(graph.getVertex(firstShop) == null)
                {
                    System.out.println("First shop does not exist! Unable to add pathway.");
                }
                else
                {
                    System.out.println("Enter the second shop's number.");
                    int secondShop = shopNumber(input);

                    // Do not add edges to the second shop if it does not exist
                    if(graph.getVertex(secondShop) == null)
                    {
                        System.out.println("Second shop does not exist! Unable to add pathway.");
                    }
                    // If the second shop input is the same as the first shop, don't add edges.
                    // (two edges cannot be added to the same shop)
                    else if(secondShop == firstShop)
                    {
                        System.out.println("Second shop cannot be the same as the first shop!");
                    }
                    else
                    {
                        graph.addEdge(firstShop, secondShop);
                    }
                }
            }
            else if(operationChoice.equals("5")) // Removing pathways between shops (edges)
            {
                System.out.println("\n(Removing pathways between shops)");

                System.out.println("\nEnter the first shop's number.");
                int firstShop = shopNumber(input);

                if(graph.getVertex(firstShop) == null)
                {
                    System.out.println("First shop does not exist! Unable to remove edge.");
                }
                else
                {
                    System.out.println("Enter the second shop's number.");
                    int secondShop = shopNumber(input);

                    if(graph.getVertex(secondShop) == null)
                    {
                        System.out.println("Second shop does not exist! Unable to remove edge.");
                    }
                    else if(secondShop == firstShop)
                    {
                        System.out.println("Second shop cannot be the same as the first shop!");
                    }
                    else
                    {
                        graph.removeEdge(firstShop, secondShop);
                    }
                }
            }
            else if(operationChoice.equals("6"))
            {
                System.out.println("\n(Displaying the path between two shops)");

                System.out.println("\nEnter the first shop's number.");
                int firstShop = shopNumber(input);

                if(graph.getVertex(firstShop) == null)
                {
                    System.out.println("First shop does not exist! Unable to display paths");
                }
                else
                {
                    System.out.println("Enter the second shop's number.");
                    int secondShop = shopNumber(input);

                    if(graph.getVertex(secondShop) == null)
                    {
                        System.out.println("Second shop does not exist! Unable to display paths");
                    }
                    else if(secondShop == firstShop)
                    {
                        System.out.println("Second shop cannot be the same as the first shop!");
                    }
                    else
                    {
                        DSACircularQueue dfsOutput = graph.depthFirstSearch(firstShop, secondShop);
                        DSACircularQueue bfsOutput = graph.breadthFirstSearch(firstShop, secondShop);

                        /* This section is responsible for printing the traversal path (and notifying if there is no path) */
                        /* ------------------------------------------------------------------------------------------------------ */
                        if((shopExists(firstShop, dfsOutput)) && (shopExists(secondShop, dfsOutput)))
                        {
                            System.out.println();
                            System.out.print("Depth-first search path: ");
                            printGraphTraversal(dfsOutput);
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("There is no valid DFS pathway shop " + firstShop + " and shop " + secondShop);
                        }

                        if((shopExists(firstShop, bfsOutput)) && (shopExists(secondShop, bfsOutput)))
                        {
                            System.out.println();
                            System.out.print("Breadth-first search path: ");
                            printGraphTraversal(bfsOutput);
                            System.out.println();
                        }
                        else
                        {
                            System.out.println("There is no valid BFS pathway shop " + firstShop + " and shop " + secondShop);
                        }
                        /* ------------------------------------------------------------------------------------------------------ */

                        printShorterPath(dfsOutput, bfsOutput);
                    }
                }
            }
            else if(operationChoice.equals("7"))
            {
                System.out.println("\n(Instant search by category)");

                System.out.println("\nEnter the category.");
                String categoryInput = shopCategory(input);

                boolean categoryExists = table.checkIfCategoryExists(categoryInput);

                if(categoryExists)
                {
                    System.out.println("\nShowing shops in the " + "'" + categoryInput + "'" + " category.");
                    System.out.println("NOTE: Shops are displayed like this: Number, Name, Location, Rating");
                    System.out.println();
                    System.out.println("------------------------------------------------------");
                    table.printTable(categoryInput);
                    System.out.println("------------------------------------------------------");

                    boolean seekingValidInput = true;
                    while(seekingValidInput)
                    {
                        // Give option for user to sort the shops in the chosen category.
                        System.out.print("\nWould you like to sort this category by ratings? (Y/N): ");
                        String choice = input.nextLine();

                        if(choice.equals("Y") || choice.equals("y"))
                        {
                            System.out.println("\nNOTE: As you are displaying by ratings, shops are displayed");
                            System.out.println("like this: Rating, Number, Name, Location");
                            System.out.println();
                            System.out.println("------------------------------------------------------");
                            table.sortCategory(categoryInput);
                            System.out.println("------------------------------------------------------");
                            seekingValidInput = false;
                        }
                        else if(choice.equals("N") || choice.equals("n"))
                        {
                            System.out.println("'No' chosen. Not sorting category by ratings.");

                            seekingValidInput = false;
                        }
                        else
                        {
                            System.out.println("Invalid choice!");
                        }
                    }
                }
                else
                {
                    System.out.println("\nThis category does not exist!");
                }
            }
            else if(operationChoice.equals("8"))
            {
                graph.displayAsList();
            }
            else if(operationChoice.equals("QUIT"))
            {
                programRuns = false;
            }
            else if(operationChoice.equals("HELP") || operationChoice.equals("help"))
            {
                printOptions();
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
        System.out.println("4) Add pathways between shops");
        System.out.println("5) Removing pathways between shops");
        System.out.println("6) Display the path between two shops");
        System.out.println("7) Search by category");
        System.out.println("8) Display the list");
        
        System.out.println("\nPlease type 'QUIT' (in all capitals) to quit the program!");

        System.out.println();

        System.out.println("Please type the number for your desired operation.");
        System.out.println("e.g. '1' for adding a shop.\n");

        System.out.println("NOTE: Please type 'help' for this same manual to display.");
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
        System.out.println("e.g. '1' for updating shop number.\n");

        System.out.println("NOTE: Please type 'help' for this update manual to display.");
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

    public static boolean shopExists(int shop, DSACircularQueue graphTraversalOutput)
    {
        boolean shopExistence = false;

        for(int i = 0; i < graphTraversalOutput.queue.count(); i++)
        {
            if(graphTraversalOutput.queue.get(i).getLabel() == shop)
            {
                shopExistence = true;
            }
        }

        return shopExistence;
    }

    public static void printGraphTraversal(DSACircularQueue outputQueue)
    {
        for(int i = 0; i < outputQueue.queue.count(); i++)
        {
            System.out.print(outputQueue.queue.get(i).getLabel());

            if(i < outputQueue.queue.count() - 1)
            {
                System.out.print(" -> ");
            }
        }
    }

    public static void printShorterPath(DSACircularQueue dfsOutput, DSACircularQueue bfsOutput)
    {
        int numOfPathsDFS = dfsOutput.queue.count();
        int numOfPathsBFS = bfsOutput.queue.count();

        if(numOfPathsDFS < numOfPathsBFS)
        {
            System.out.println("\nThe Depth-First Search algorithm has the shorter path: ");
            printGraphTraversal(dfsOutput);
            System.out.println();
        }
        else if(numOfPathsBFS < numOfPathsDFS)
        {
            System.out.println("\nThe Breadth-First Search algorithm has the shorter path: ");
            printGraphTraversal(bfsOutput);
            System.out.println();
        }
        else
        {
            System.out.println("\nBoth traversal algorithms have the same length.");
            System.out.println();
        }
    }
}
