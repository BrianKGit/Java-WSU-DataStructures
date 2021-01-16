package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PurpleBox implements PurpleBoxAdminInterface, PurpleBoxUserInterface {
	
	ArrayList<Media> inventory;
	ArrayList<Media> userCart;
	String promo;
	double discount;
	
	double dvdPrice;
	double bluRayPrice;
	double xboxPrice;
	double ps4Price;
	
	boolean getsDiscount;
	boolean enabled;
	
	public PurpleBox() {
		inventory = new ArrayList<Media>();
		userCart = new ArrayList<Media>();
		enabled = false;
		getsDiscount = false;
		
		dvdPrice = 1;
		bluRayPrice = 1.5;
		xboxPrice = 1.25;
		ps4Price = 1.25;
	}

	@Override
	public ArrayList<Media> searchByName(String name) {
		ArrayList<Media> returnArray = new ArrayList<Media>();
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getName().contains(name)) {
				returnArray.add(inventory.get(i));
			}
		}
		return returnArray;
	}
	
	@Override
	public ArrayList<Media> browseByGenre(String genre) {
		ArrayList<Media> returnArray = new ArrayList<Media>();
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getGenre().equals(genre)) {
				returnArray.add(inventory.get(i));
			}
		}
		return returnArray;
	}

	@Override
	public ArrayList<Media> browseByDate() {
		Collections.sort(inventory, new MediaComparatorDate());
		return inventory;
	}

	@Override
	public ArrayList<Media> browseByRating() {
		Collections.sort(inventory, new MediaComparatorScore());
		return inventory;
	}

	@Override
	public ArrayList<Media> browseByAlphabetical() {
		Collections.sort(inventory, new MediaComparatorName());
		return inventory;
	}

	@Override
	public ArrayList<Media> browseByType(String type) {
		ArrayList<Media> returnList = new ArrayList<Media>();
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getType().equals(type)) {
				returnList.add(inventory.get(i));
			}
		}
		Collections.sort(returnList, new MediaComparatorDate());
		return returnList;
	}

	@Override
	public void addToCart(Media item) {
		userCart.add(item);
		
	}

	@Override
	public void removeFromCart(Media item) {
		userCart.remove(item);
	}

	@Override
	public void clearCart() {
		userCart = new ArrayList<Media>();
		
	}

	@Override
	public void returnMedia(Media item) {
		inventory.add(item);
		
	}

	@Override
	public void applyPromo(String promo) {
		if(promo.equals(this.promo)) {
			getsDiscount = true;
			System.out.println("Promo offer was successfully applied.");
		} else {
			System.out.println("No matching promo code was found\nReturning to menu.");
		}
	}

	@Override
	public void checkout() {
		double cartTotal = 0;
		System.out.println(mediaListToString(userCart));
		for(int i=0; i<userCart.size(); i++) {
			if(userCart.get(i).getType().equals("DVD")) {
				cartTotal += dvdPrice;
			}
			if(userCart.get(i).getType().equals("Blu-ray")) {
				cartTotal += bluRayPrice;
			}
			if(userCart.get(i).getType().equals("X-Box")) {
				cartTotal += xboxPrice;
			}
			if(userCart.get(i).getType().equals("PS4")) {
				cartTotal += ps4Price;
			}
		}
		if(getsDiscount) {
			String formattedDiscount = String.format("%.2f", discount*userCart.size());
			System.out.println("Promo applied. Your savings are: $" + formattedDiscount);
			cartTotal -= (userCart.size() * discount);
			if(cartTotal < 0) {
				cartTotal = 0;
			}
		}
		String output = String.format("%.2f", cartTotal);
		System.out.println("Your total is: $" + output +"\n");
		clearCart();
	}

	@Override
	public void addInventory(Media item) {
		inventory.add(item);
		
	}

	@Override
	public void removeInventory(Media item) {
		inventory.remove(item);
		
	}

	@Override
	public void setPrice(String type, double price) {
		if(type.equals("DVD")) {
			dvdPrice = price;
		}
		if(type.equals("Blu-ray")) {
			bluRayPrice = price;
		}
		if(type.equals("X-Box")) {
			xboxPrice = price;
		}
		if(type.equals("PS4")) {
			ps4Price = price;
		}
	}

	@Override
	public void setPromo(String promo, double discount) {
		this.promo = promo;
		this.discount = discount;
		
	}

	@Override
	public void enable(Boolean enabled) {
		this.enabled = enabled;
		
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public String mediaListToString(ArrayList<Media> list) {
		String returnString = "";
		String header = "";
		header = header + padRight("Title", 48) + padRight("| Type", 12) + padRight("| Critic Score", 16) + padRight("| Release Date", 20) +
											"| Price";
		returnString += header + "\n";
		for(int i=0; i<list.size(); i++) {
			returnString += i+1 + " : ";
			String formattedName = padRight(list.get(i).getName(), 40);
			returnString += formattedName;
			String formattedType = padRight(list.get(i).getType(), 10);
			String score = "" + list.get(i).getCriticScore();
			String formattedScore = padRight(score, 14);
			returnString = returnString + "\t| " + formattedType + "| " + formattedScore + 
					"| " + list.get(i).getReleaseDate().getYear() + "\t";
			if(list.get(i).getType().equals("DVD")) {
				String output = String.format("%.2f", dvdPrice);
				returnString = returnString + "\t| $" + output;
			}
			if(list.get(i).getType().equals("Blu-ray")) {
				String output = String.format("%.2f", bluRayPrice);
				returnString = returnString + "\t| $" + output;
			}
			if(list.get(i).getType().equals("X-Box")) {
				String output = String.format("%.2f", xboxPrice);
				returnString = returnString + "\t| $" + output;
			}
			if(list.get(i).getType().equals("PS4")) {
				String output = String.format("%.2f", ps4Price);
				returnString = returnString + "\t| $" + output;
			}
			returnString += '\n';
		}
		
		return returnString;
	}
	
	public ArrayList<Media> getInventory(){
		return inventory;
	}
	
	public ArrayList<Media> getUserCart(){
		return userCart;
	}
	
	public void Preload() {
		Media media1 = new Media("Shrek", "Comedy", "DVD", 95, new Date(2002,2,24));
		Media media2 = new Media("Shrek 2", "Comedy", "Blu-ray", 96, new Date(2004,4,20));
		Media media3 = new Media("Call of Duty 4", "FPS", "X-Box", 92, new Date(2009, 5, 21));
		Media media4 = new Media("Little Big Planet", "Platformer", "PS4", 90, new Date(2010, 8, 20));
		Media media5 = new Media("Saw", "Horror", "DVD", 89, new Date(2004, 5, 12));
		Media media6 = new Media("A Quiet Place", "Horror", "Blu-ray", 85, new Date(2018, 2, 3));
		Media media7 = new Media("Star Wars: The Last Jedi", "Sci-fi", "Blu-ray", 89, new Date(2017, 2, 6));
		Media media8 = new Media("Black Panther", "Action", "DVD", 91, new Date(2018, 5, 20));
		Media media9 = new Media("Paddington 2", "Kids", "DVD", 79, new Date(2018, 6, 22));
		Media media10 = new Media("Spider-Man", "Action", "PS4", 80, new Date(2018, 5, 5));
		Media media11 = new Media("Minecraft", "Kids", "X-Box", 96, new Date(2009, 5, 6));
		Media media12 = new Media("Grand Theft Auto V", "Action", "X-Box", 91, new Date(2013, 7, 17));
		Media media13 = new Media("FIFA 19", "Sports", "PS4", 89, new Date(2018, 7, 28));
		
		inventory.add(media4);
		inventory.add(media3);
		inventory.add(media2);
		inventory.add(media1);
		inventory.add(media5);
		inventory.add(media6);
		inventory.add(media7);
		inventory.add(media8);
		inventory.add(media9);
		inventory.add(media10);
		inventory.add(media11);
		inventory.add(media12);
		inventory.add(media13);
		
		browseByAlphabetical();
	}
	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}
	
	
	
}
