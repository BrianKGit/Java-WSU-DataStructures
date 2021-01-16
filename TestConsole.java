package assignment3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestConsole {
	static PurpleBox pBox = new PurpleBox();
	static PurpleBoxUserInterface userBox = pBox;
	static PurpleBoxAdminInterface adminBox = pBox;
	
    public static void main(String[] args) {
    	ArrayList<Media> test = new ArrayList<Media>();
		pBox.Preload();
		
        String name = "";
 
        try {
 
            boolean flag = true;
            String command;
            Scanner console = new Scanner(System.in);
 
            while (flag) {
 
                displayMainMenu();
 
                command = console.next();
 
                switch (command) {
                    case "1":
                        boolean flag1 = true;
                        String command1;
                        Scanner console1 = new Scanner(System.in);
                        BufferedReader console4 = new BufferedReader(new InputStreamReader(System.in));
 
                        while (flag1) {
                            displayAdminMenu();
 
                            command1 = console1.next();
                            String title, genre, type, promo;
                            double score, price, discount;
                            int month, day, year, num;
                            Date date;
 
                            switch (command1) {
                                case "1":
                                	pageBreak();
                                    System.out.println("Enter Title:");
                                    title = console4.readLine();
 
                                    System.out.println("Enter Genre:");
                                    genre = console1.next();
 
                                    System.out.println("Enter Type(DVD, Blu-ray, X-Box, or PS4): ");
                                    
                                    type = console1.next();
 
                                    System.out.println("Enter Critic Score:");
                                    score = console1.nextDouble();
 
                                    System.out.println("Enter Release Date Month(for example: January = \"01\"):");
                                    month = console1.nextInt();
 
                                    System.out.println("Enter Release Date Day(for example: 12th = \"12\"):");
                                    day = console1.nextInt();
 
                                    System.out.println("Enter Release Date Year(for example: 1999 = \"1999\"):");
                                    year = console1.nextInt();
 
                                    date = new Date(year, month, day);
 
                                    Media media = new Media(title, genre, type, score, date);
 
                                    adminBox.addInventory(media);
                                    pBox.browseByAlphabetical();
 
                                    break;
                                case "2":
                                	pageBreak();
                                    userBox.browseByAlphabetical();
 
                                    System.out.println(pBox.mediaListToString(pBox.getInventory()));
 
                                    System.out.println("Enter Number of Media to remove: ");
 
                                    num = console1.nextInt();
 
                                    adminBox.removeInventory(pBox.getInventory().get(num - 1));
 
                                    break;
                                case "3":
                                	pageBreak();
                                    System.out.println("Enter Type to change price: ");
 
                                    type = console1.next();
 
                                    System.out.println("Enter new price: $");
 
                                    price = console1.nextDouble();
 
                                    adminBox.setPrice(type, price);
 
                                    break;
                                case "4":
                                	pageBreak();
                                    System.out.println("Enter new Promo Code: ");
 
                                    promo = console1.next();
 
                                    System.out.println("Enter discount dollar value: $");
 
                                    discount = console1.nextDouble();
 
                                    adminBox.setPromo(promo, discount);
 
                                    break;
                                case "5":
                                	pageBreak();
                                    adminBox.enable(!pBox.isEnabled());
 
                                    if (pBox.isEnabled()) {
                                        System.out.println("User access is now enabled.");
                                    } else {
                                        System.out.println("User access is now disabled.");
                                    }
 
                                    break;
                                case "0":
                                	pageBreak();
                                    flag1 = false;
 
                                    System.out.println("Thank you Admin!");
 
                                    break;
                                default:
                                    System.out.println("Invalid command, please try again.");
                            }//end 1st inner switch
 
                        }//end 1st inner while
 
                        break;
 
                    case "2":
                    	pageBreak();
                        if (pBox.isEnabled() == false) {
                            System.out.println("Sorry, Purple Box is down for maintenance.");
                            flag1 = false;
                            break;
                            
                        } else {
                            boolean flag2 = true;
                            String command2;
                            BufferedReader console2 = new BufferedReader(new InputStreamReader(System.in));
                            Scanner console3 = new Scanner(System.in);
                            String title, genre, type;
                            double score;
                            int month, day, year;
                            Date date;
                            while (flag2) {
                                displayUserMenu();
 
                                command2 = console2.readLine();
                                String input;
                                int num;
                                ArrayList<Media> results;
 
                                switch (command2) {
                                    case "1":
                                    	pageBreak();
                                        System.out.println("Enter Title to search for: ");
 
                                        input = console2.readLine();
 
                                        results = userBox.searchByName(input);
 
                                        System.out.println(pBox.mediaListToString(results));
 
                                        System.out.println("Enter corresponding number of Title to add or \"0\" to return:");
 
                                        num = console3.nextInt();
 
                                        if (num == 0) {
                                            break;
                                        }
                                        try {
                                        	userBox.addToCart(results.get(num-1));
                                            adminBox.removeInventory(results.get(num-1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error adding item to cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
                                        
 
                                        break;
                                    case "2":
                                    	pageBreak();
                                        System.out.println("Enter Genre to search for: ");
 
                                        input = console2.readLine();
 
                                        results = userBox.browseByGenre(input);
 
                                        System.out.println(pBox.mediaListToString(results));
 
                                        System.out.println("Enter corresponding number of Title to add or \"0\" to return:");
 
                                        num = console3.nextInt();
 
                                        if (num == 0) {
                                            break;
                                        }
 
                                        try {
                                        	userBox.addToCart(results.get(num-1));
                                            adminBox.removeInventory(results.get(num-1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error adding item to cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
                                        
                                        break;
                                    case "3":
                                    	pageBreak();
                                        results = userBox.browseByDate();
 
                                        System.out.println(pBox.mediaListToString(results));
 
                                        System.out.println("Enter corresponding number of Title to add or \"0\" to return:");
 
                                        num = console3.nextInt();
 
                                        if (num == 0) {
                                            break;
                                        }
 
                                        try {
                                        	userBox.addToCart(results.get(num-1));
                                            adminBox.removeInventory(results.get(num-1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error adding item to cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
 
                                        break;
                                    case "4":
                                    	pageBreak();
                                        results = userBox.browseByRating();
 
                                        System.out.println(pBox.mediaListToString(results));
 
                                        System.out.println("Enter corresponding number of Title to add or \"0\" to return:");
 
                                        num = console3.nextInt();
 
                                        if (num == 0) {
                                            break;
                                        }
 
                                        try {
                                        	userBox.addToCart(results.get(num-1));
                                            adminBox.removeInventory(results.get(num-1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error adding item to cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
 
                                        break;
                                    case "5":
                                    	pageBreak();
                                        System.out.println("Enter Type to search for (Movie, Blu-ray, X-Box, PS4): ");
 
                                        input = console2.readLine();
 
                                        results = userBox.browseByType(input);
 
                                        System.out.println(pBox.mediaListToString(results));
 
                                        System.out.println("Enter corresponding number of Title to add or \"0\" to return:");
 
                                        num = console3.nextInt();
 
                                        if (num == 0) {
                                            break;
                                        }
                                        
                                        try {
                                        	userBox.addToCart(results.get(num-1));
                                            adminBox.removeInventory(results.get(num-1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error adding item to cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
                                        
                                        break;
                                    case "6":
                                    	pageBreak();
                                        results = userBox.browseByAlphabetical();
 
                                        System.out.println(pBox.mediaListToString(results));
 
                                        System.out.println("Enter corresponding number of Title to add or \"0\" to return:");
 
                                        num = console3.nextInt();
 
                                        if (num == 0) {
                                            break;
                                        }
 
                                        try {
                                        	userBox.addToCart(results.get(num-1));
                                            adminBox.removeInventory(results.get(num-1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error adding item to cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
                                        
                                        break;
                                    case "7":
                                    	pageBreak();
                                        userBox.browseByAlphabetical();
 
                                        System.out.println(pBox.mediaListToString(pBox.getUserCart()));
 
                                        System.out.println("Enter Number of Media to remove: ");
 
                                        num = console3.nextInt();
                                        
                                        try {
                                        	adminBox.addInventory(pBox.getUserCart().get(num - 1));
                                            userBox.removeFromCart(pBox.getUserCart().get(num - 1));
                                        } catch(IndexOutOfBoundsException e) {
                                        	System.out.println("Error removing item from cart.\nReturning to menu.");
                                        	pageBreak();
                                        }
                                        
 
                                        break;
                                    case "8":
                                    	pageBreak();
                                    	for(int i=0; i<pBox.getUserCart().size(); i++) {
                                    		adminBox.addInventory(pBox.getUserCart().get(i));
                                    	}
                                        userBox.clearCart();
                                        
 
                                        System.out.println("Your Cart has been cleared.");
 
                                        break;
                                    case "9":
                                    	pageBreak();
                                        System.out.println("Enter Title:");
                                        //title = console2.next();
                                        title = console2.readLine();
                                        
                                        System.out.println("Enter Genre:");
                                        genre = console2.readLine();
 
                                        System.out.println("Enter Type:");
                                        type = console2.readLine();
 
                                        System.out.println("Enter Critic Score:");
                                        score = console3.nextDouble();
 
                                        System.out.println("Enter Release Date Month(for example: January = \"01\"):");
                                        month = console3.nextInt();
 
                                        System.out.println("Enter Release Date Day(for example: 12th = \"12\"):");
                                        day = console3.nextInt();
 
                                        System.out.println("Enter Release Date Year(for example: 1999 = \"1999\"):");
                                        year = console3.nextInt();
 
                                        date = new Date(year, month, day);
 
                                        Media media = new Media(title, genre, type, score, date);
 
                                        userBox.returnMedia(media);
                                        pBox.browseByAlphabetical();
 
                                        break;
                                    case "10":
                                    	pageBreak();
                                        System.out.println("Enter Promo Code: ");
                                        
                                        input = console2.readLine();
                                       
                                        userBox.applyPromo(input);
 
                                        break;
                                    case "11":
                                    	pageBreak();
                                        userBox.checkout();
 
                                        break;
                                    case "0":
                                    	pageBreak();
                                        flag2 = false;
 
                                        break;
                                    default:
                                    	pageBreak();
                                        System.out.println("Invalid command, please try again.");
                                }//end 2nd inner switch
 
                            }//end 2nd inner while
 
                            break;
                        }
 
                    case "0":
                    	pageBreak();
                        flag = false;
 
                        System.out.println("Thank you for using this program. "
                                + "\nHave a wonderful day!");
 
                        break;
 
                    default:
                    	pageBreak();
                        System.out.println("Invalid command, please try again.");
 
                }//end switch
 
            }//end while
        } catch (Exception e) {
 
        }
 
    }//end main
 
    private static void displayMainMenu() {
 
        System.out.print("\n\n"
                + "1 -- Sign in as ADMIN\n"
                + "2 -- Sign in as USER\n"
                + "0 -- Exit\n\n"
                + "Enter Command:");
 
    }//end displayMainMenu
 
    private static void displayAdminMenu() {
    	pageBreak();
    	System.out.println("Current Inventory:");
        System.out.print(pBox.mediaListToString(pBox.getInventory())
                + "\n\n"
                + "1 -- Add to Inventory\n"
                + "2 -- Remove from Inventory\n"
                + "3 -- Set Prices\n"
                + "4 -- Set Promo\n"
                + "5 -- Enable/Disable Machine\n"
                + "0 -- Exit\n\n"
                + "Enter Command:");
 
    }//end displayAdminMenu
 
    private static void displayUserMenu() {
    	pageBreak();
        System.out.println("Your Cart:\n" + pBox.mediaListToString(pBox.getUserCart())
                + "\n\n"
                + "1  -- Search by Title\n"
                + "2  -- Browse by Genre\n"
                + "3  -- Browse by Release Date\n"
                + "4  -- Browse by Critic Score\n"
                + "5  -- Browse by Media Type\n"
                + "6  -- Browse Alphabetically\n"
                + "7  -- Remove from Cart\n"
                + "8  -- Clear Cart\n"
                + "9  -- Return Media\n"
                + "10 -- Apply Promo\n"
                + "11 -- Checkout\n"
                + "0  -- Exit\n\n"
                + "Enter Command:");
 
    }//end displayUserMenu
    
    public static void pageBreak() {
    	System.out.println("\n\n\n------------------------------------------------\n\n\n");
    }
 
    public void addToCart() {
        Scanner console = new Scanner(System.in);
        int num;
 
        System.out.println("Enter corresponding number of Title to add :");
 
        num = console.nextInt();
 
        pBox.addToCart(pBox.getInventory().get(num));
    }
}