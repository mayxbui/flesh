import java.util.Scanner;

public class Driver {
    public static Location currentLocation;
    public static ContainerItem myInventory;

    public static void createWorld() {
        // Location Descriptions
        Location Living_room = new Location("Living Room",
                "Moonlight set on the curtain and enlighten the place. A room redden in blood and tainted by parts which once belonged inside human body. The furnitures suggest this was once a mundane, normal living room before it was plunged into chaos.");
        Location Kitchen = new Location("Kitchen",
                "A cold and dark kitchen, shattered dished littered the floor, cans and pots lying in disorder on the table and counter.");
        Location Porch = new Location("Porch",
                "A small wooden porch with a few small chairs, dried leaves surround your feet.");
        Location Garage = new Location("Garage",
                "A garage, or at least you guess so from its various tools lying around, you find no vehicles inside. Perhaps whatever was constructed here has been taken elsewhere.");
        Location Bedroom = new Location("Bedroom", "A bedroom littered with gabage bag and shattered papers.");

        // Item Descriptions
        Item Couch = new Item("Couch", "Furniture",
                "Leather-made, blood-stained couch. The cushion and side arms are tattered, revealing the foam core inside.");
        Item TV = new Item("TV", "Furniture",
                "The lyquid-crystal display lies in silence without the energy it needs, reflecting your figure in the dimly lit room. You cannot see your face on the screen.");
        Item DeadBody = new Item("Dead_Body", "Evidence",
                "Inanimated body of a human, organs scattered and blood has dried in the chill of the night but the figure recognizable, lying silently under your feet. You pinch your nose against its foul smell.");
        Item Leaf = new Item("Leaf", "Miscellaneous",
                "Dried leaf detached from a dying tree, nothing special about it except its dirtiness on your hand.");
        Item Broken_dish = new Item("Broken_Dish", "Miscellaneous",
                "Pieces of a shattered ceramic dish, the coldness of it lies on your fingertips.");
        Item Knife = new Item("Knife", "Evidence",
                "A kitchen knife, dull and rusty and sharp enough to cut one's finger.");
        Item Wrench = new Item("Wrench", "Evidence",
                "A wrench, a tool with many usages that leave you wonder of its uses.");
        Item Trash_bag = new Item("Trash_Bag", "Miscellaneous",
                "Black plastic bags, lying against the wall concealing whatever sight and smell inside.");
        Item Lamp = new Item("Lamp", "Miscellaneous",
                "An electric lamp with its cable cut off, it probably will never light up again.");

        ContainerItem Broken_Car = new ContainerItem("Broken_Car", "Inventory",
                "A black four-seat car lying flat on the ground with its tires detached and scattered. Perhaps the front seats may hold something of value.");
        ContainerItem Wooden_Wardrobe = new ContainerItem("Wooden_Wardrobe", "Inventory",
                "A wardrobe made of brown wood. The aloma of good wood is not here in contrast to its luxurious appearance. You wonder what clothes remain in it.");
        ContainerItem Freezer = new ContainerItem("Freezer", "Inventory",
                "A refridgerator, its cable unplugged violently from the socket with the connector bent to one side. It may hold some food inside.");

        Item Finger_In_Jar = new Item("Finger_In_Jar", "Evidence",
                "Human fingers without the palm, white bones stick out below the freezed flesh. The nails are cleanly cut short.");
        Item Photo_Album = new Item("Photo_Album", "Miscellaneous",
                "An album half-filled with photos both in colors and in black and white. It is too dark to examine the photos right now.");
        Item Bloody_Tee = new Item("Bloody_Tee", "Evidence",
                "A white T-shirt drenched in dried blood. There is no decorative words or patterns on it, just plain white under redness.");
        Item Driver_License = new Item("Driver_License", "Miscellaneous",
                "A driver license of a certain man, issued a year ago. You don't recognize his face.");
        Item ID = new Item("ID", "Miscellaneous", "An ID issued four years ago of a woman. You do not recognize her.");

        // Connect Directions to the Rooms
        Living_room.connect("east", Kitchen);
        Kitchen.connect("west", Living_room);
        Living_room.connect("west", Bedroom);
        Bedroom.connect("east", Living_room);
        Living_room.connect("north", Garage);
        Garage.connect("south", Living_room);
        Living_room.connect("south", Porch);
        Porch.connect("north", Living_room);

        // Default Items in Locations
        Living_room.addItem(Couch);
        Living_room.addItem(TV);
        Living_room.addItem(DeadBody);
        Bedroom.addItem(Trash_bag);
        Bedroom.addItem(Lamp);
        Bedroom.addItem(Wooden_Wardrobe);
        Garage.addItem(Wrench);
        Garage.addItem(Broken_Car);
        Kitchen.addItem(Freezer);
        Kitchen.addItem(Broken_dish);
        Kitchen.addItem(Knife);
        Porch.addItem(Leaf);

        // Default Item in Containers
        Wooden_Wardrobe.addItem(Photo_Album);
        Wooden_Wardrobe.addItem(Bloody_Tee);
        Broken_Car.addItem(Driver_License);
        Broken_Car.addItem(ID);
        Freezer.addItem(Finger_In_Jar);

        // Starting point + Suitcase
        currentLocation = Living_room;
        myInventory = new ContainerItem("Suitcase", "Inventory",
                "An empty leather suitcase that you always bring on your investigation.");
    }

    public static void help() {
        System.out.println("List of available commands:");
        System.out.println("+ 'Look' - prints a description of your surroundings.\n" + //
                "+ 'Inventory' - lists of object in your belonging.\n" + //
                "+ 'Examine (item/container)' - prints a description of the item.\n" + //
                "+ 'Take (item)' - to take an item and put it in your inventory.\n" + //
                "+ 'Take (item) from (container)' - to take an item from a container and put it in your inventory.\n" + //
                "+ 'Put (item) in (container)' - to put an item in a container.\n" + //
                "+ 'Drop (item)' - to take an item out of your inventory and drop it.\n" + //
                "+ 'Go (North/South/East/West)' - to travel in that direction.\n" + //
                "+ 'Quit' - to exit the game.");
    }

    public static void main(String[] args) {
        createWorld();

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(currentLocation.getName() + "\nYou are in the living room where the crime happens.\n" +
                    "Enter 'help' for more information.\n" +
                    "Enter command: ");
            String command = scan.nextLine();

            String[] splt_command = command.split(" ");

            if (splt_command.length == 1 && splt_command[0].equals("quit")) {
                System.out.println("You go to sleep for the night.");
                break;
            }
            switch (splt_command[0].toLowerCase()) {
                // LOOK
                case "look":
                    System.out.println(
                            currentLocation.getName() + " - " + currentLocation.getDescription() + " Items in sight: ");
                    for (int i = 0; i < currentLocation.numItems(); i++) {
                        System.out.println("- " + currentLocation.getItem(i).getName());
                    }
                    break;

                // EXAMINE
                case "examine":
                    if (splt_command.length > 1) {
                        if (currentLocation.hasItem(splt_command[1].toString())) {
                            if (currentLocation.getItem(splt_command[1]) instanceof ContainerItem) {
                                System.out.println("\n" + String.format("%s [%s]: %s",
                                        currentLocation.getItem(splt_command[1]).getName(),
                                        currentLocation.getItem(splt_command[1]).getType(),
                                        currentLocation.getItem(splt_command[1]).getDescription()));
                                System.out.println(currentLocation.getItem(splt_command[1]).toString());
                            } else {
                                System.out.println(currentLocation.getItem(splt_command[1]).toString());
                            }

                        } else {
                            System.out.println("Certainly desirable, sadly it exits nowhere in sight.");

                        }
                    } else {
                        System.out.println("One must wish to examine something to examine.");

                    }
                    break;

                // GO
                case "go":
                    if (splt_command.length > 1) {
                        if (currentLocation.canMove(splt_command[1])) {
                            currentLocation = currentLocation.getLocation(splt_command[1]);
                            System.out.println("You've reached the " + currentLocation.getName().toLowerCase() + ".");
                        } else if (splt_command[1].toLowerCase().equals("north")
                                || splt_command[1].toLowerCase().equals("west")
                                || splt_command[1].toLowerCase().equals("south")
                                || splt_command[1].toLowerCase().equals("east")) {
                            System.out.println("There is no available path in that direction.");
                        } else {
                            System.out.println("Sounds intriguing, but you have never heard of such direction before.");
                        }
                    } else {
                        System.out.println("It is normal to contemplate about where to go.");
                    }
                    break;

                // INVENTORY
                case "inventory":
                    System.out.println(myInventory.toString());
                    break;

                // TAKE
                case "take":
                    if (splt_command.length > 1) {
                        if (splt_command.length > 3 && splt_command[2].equalsIgnoreCase("from")) {
                            if (currentLocation.hasItem(splt_command[3])
                                    && currentLocation.getItem(splt_command[3]) instanceof ContainerItem) {
                                ContainerItem container = (ContainerItem) currentLocation.getItem(splt_command[3]);
                                if (container.hasItem(splt_command[1])) {
                                    myInventory.addItem(container.removeItem(splt_command[1]));
                                    System.out.println(
                                            "You take the " + splt_command[1] + " from the " + splt_command[3] + ".");
                                } else {
                                    System.out
                                            .println("One container may not hold anything in the world.");
                                }
                            } else {
                                System.out.println("Unfortunately there is no such such container in sight.");
                            }
                        } else {
                            if (currentLocation.hasItem(splt_command[1])) {
                                myInventory.addItem(currentLocation.removeItem(splt_command[1]));
                                System.out.println(
                                        "You take the " + splt_command[1] + " from the "
                                                + currentLocation.getName().toLowerCase()
                                                + ".");
                            } else {
                                System.out
                                        .println(
                                                "Sometimes the eyes can be deceptive and see things where they are not.");
                            }
                        }
                    } else {
                        System.out.println("Is it taking if you take nothing?");
                    }
                    break;

                // DROP
                case "drop":
                    if (splt_command.length > 1) {
                        if (myInventory.hasItem(splt_command[1])) {
                            currentLocation.addItem(myInventory.removeItem(splt_command[1]));
                            System.out.println(
                                    "You drop the " + splt_command[1] + " at the "
                                            + currentLocation.getName().toLowerCase() + ".");
                        } else {
                            System.out.println(
                                    "You can't find it no matter how many times you rummage over your belongings.");
                        }
                    } else {
                        System.out.println("Is it dropping if you drop nothing?");
                    }
                    break;

                // PUT
                case "put":
                    if (splt_command.length > 3 && splt_command[2].toLowerCase().equals("in")) {
                        if (myInventory.hasItem(splt_command[1])) {
                            Item itemToPut = myInventory.removeItem(splt_command[1]);
                            if (currentLocation.hasItem(splt_command[3])) {
                                Item targetContainer = currentLocation.getItem(splt_command[3]);
                                if (targetContainer instanceof ContainerItem) {
                                    ((ContainerItem) targetContainer).addItem(itemToPut);
                                    System.out.println(
                                            "You put the " + splt_command[1] + " into the " + splt_command[3] + ".");
                                } else {
                                    System.out.println("There exists objects that cannot hold things in the world, "
                                            + splt_command[3] + " is cetainly one of them.");
                                    myInventory.addItem(itemToPut);
                                }
                            } else {
                                System.out.println("There exists no " + splt_command[3] + " in sight.");
                                myInventory.addItem(itemToPut);
                            }
                        } else {
                            System.out.println(
                                    "You can't find " + splt_command[1] + ", even with all your pockets inside out.");
                        }
                    } else {
                        System.out.println(
                                "It might be wise to reserve 'put' for when you see a container for your object.");
                    }
                    break;

                // HELP
                case "help":
                    help();
                    break;

                default:
                    System.out.println("Sometime one's wish is not ready to be materialized.");
                    break;
            }
        }
    }
}