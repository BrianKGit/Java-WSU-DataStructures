import java.util.Date;

public class TestCases {
	public static void main(String[] args) {
		User user1 = new User("ThomasWin", "Thomas", "Winters");
		Seller seller1 = new Seller("BrianKlein", "Brian", "Klein");
		Seller seller2 = new Seller("ChrisJ", "Chris", "Johnson");
		double buynow = 9999.99;
		Date end = new Date();
		Item toy1 = new Item("iPhone9", "This is a real phone", "Syberia", buynow, 50.00, seller1, end);
		Item realPhone = new Item("iPhoneX", "Actual phone", "China", buynow, 60.00, seller1, end);
		seller1.sellAnItem(toy1);
		seller1.sellAnItem(realPhone);
		System.out.println("Sell List\n" + seller1.getItemsForSale());
		
		user1.bid(toy1, 100.00);
		System.out.println("$"+toy1.getHighBid());
		user1.bid(realPhone, 100000);
		
		System.out.println("Sell List\n" + seller1.getItemsForSale());
		
		
		System.out.println("Purchase list\n" + user1.getAllPurchases());
		System.out.println(toy1.toString());
		
		user1.bid(toy1, 150);
		user1.bid(realPhone, 83847473);
		
		Item item01 = new Item();
		Item item02 = new Item();
		Item item03 = new Item();
		Item item04 = new Item();
		Item item05 = new Item();
		Item item06 = new Item();
		Item item07 = new Item();
		Item item08 = new Item();
		Item item09 = new Item();
		Item item10 = new Item();
		Item item11 = new Item();
		Item item12 = new Item();
		Item item13 = new Item();
		Item item14 = new Item();
		Item item15 = new Item();
		Item item16 = new Item();
		Item item17 = new Item();
		Item item18 = new Item();
		Item item19 = new Item();
		Item item20 = new Item();
		
		
		seller1.sellAnItem(item01);
		System.out.println("Hi");
		seller1.sellAnItem(item02);
		seller1.sellAnItem(item03);
		seller1.sellAnItem(item04);
		seller1.sellAnItem(item05);
		seller1.sellAnItem(item06);
		seller1.sellAnItem(item07);
		seller1.sellAnItem(item08);
		seller1.sellAnItem(item09);
		seller1.sellAnItem(item10);
		seller1.sellAnItem(item11);
		seller1.sellAnItem(item12);
		seller1.sellAnItem(item13);
		seller1.sellAnItem(item14);
		seller1.sellAnItem(item15);
		seller1.sellAnItem(item16);
		seller1.sellAnItem(item17);
		seller1.sellAnItem(item18);
		seller1.sellAnItem(item19);
		seller1.sellAnItem(item20);	
		System.out.println(seller1.getItemsForSale());
		System.out.println(item10.getSeller().getFirstName());
		
		
		user1.bid(item01, 900000);
		user1.bid(item02, 900000);
		user1.bid(item03, 900000);
		user1.bid(item04, 900000);
		user1.bid(item05, 900000);
		user1.bid(item06, 900000);
		
		user1.bid(item07, 900000);
		user1.bid(item08, 900000);
		user1.bid(item09, 900000);
		user1.bid(item10, 900000);
		user1.bid(item11, 900000);
		user1.bid(item12, 900000);
		
		System.out.println(user1.getAllPurchases());
		
		System.out.println(user1.toString());
		
		System.out.println(seller1.toString());
		
		seller2.bid(toy1, 999999999);
		
		
	}
	
}
