package assignment3;

import java.util.ArrayList;
import java.util.Date;

public class TestCase {
	public static void main(String[] args) {
		/*
		 * One class that implements two interfaces
		 * example: PurpleBoxUserInterface userBox = new PurpleBox(); <--constructor
		 * This will restrict access to user and admin but allow them to act on the same Object
		 * 
		 */
		ArrayList<Media> test = new ArrayList<Media>();
		
		int j = 5;
		j += 2;
		System.out.println(j);
		
		PurpleBox pBox = new PurpleBox();
		PurpleBoxUserInterface userBox = pBox;
		PurpleBoxAdminInterface adminBox = pBox;
		
		Media shrek1 = new Media("Shrek", "Comedy", "DVD", 90, new Date(2001, 04, 22));
		Media shrek2 = new Media("Shrek 2", "Comedy", "DVD", 85, new Date(2004, 05, 19));
		Media shrek3 = new Media("Shrek 3", "Comedy", "Blu-ray", 100, new Date(2007, 05, 18));
		adminBox.addInventory(shrek2);
		adminBox.addInventory(shrek1);
		adminBox.addInventory(shrek3);
		test = userBox.browseByAlphabetical();
		
		System.out.println(pBox.mediaListToString(test));
		
		userBox.addToCart(shrek2);
		userBox.addToCart(shrek3);
		adminBox.setPromo("test", .25);
		userBox.applyPromo("test");
		
		userBox.checkout();
		
		userBox.browseByAlphabetical();
		adminBox.removeInventory(pBox.getInventory().get(2));
		test = userBox.browseByAlphabetical();
		
		System.out.println(pBox.mediaListToString(test));
		
		
	}
}
