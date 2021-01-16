import java.util.Date;

public class Item implements ItemInterface {
	
	private String name;
	private String description;
	private String location;
	private double buyNowPrice;
	private double highBid;
	private User highBidder;
	private Seller seller;
	private Date endDate;
	private boolean sold;
	
	
	//Default constructor
	public Item(){
		name = "<NoItemName>";
		description = "<NoItemDescription>";
		location = "<NoItemLocation>";
		buyNowPrice = 0;
		highBid = 0;
		highBidder = null;
		seller = null;
		endDate = null;
		sold = false;
	}
	//Overloaded constructor
	public Item(String name, String description, String location, double buyNowPrice, 
			double highBid, Seller seller, Date endDate){
		this.name = name;
		this.description = description;
		this.location = location;
		this.buyNowPrice = buyNowPrice;
		this.highBid = highBid;
		this.seller = seller;
		this.endDate = endDate;
		this.sold = false;
	}
	
	//Getters and setters
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public double getHighBid() {
		return highBid;
	}

	//Tests to see if the bid passed is over the current high bid
	//If it is, update the highBid and highBidder
	//Additionally, if the newBid is above the buyNowPrice complete the purchase
	//				by removing item from sellList and adding to buyList
	//Otherwise if the bid is too low, inform the user and do nothing
	@Override
	public boolean setHighBid(double newBid, User user) {
		if(sold) {
			System.out.println("This item is already sold.");
			return false;
		}
		
		if(newBid > highBid) {
			highBidder = user;
			if(newBid<buyNowPrice) {
				this.highBid = newBid;
				System.out.println("Your bid of $" + newBid + " was successful.");
				return true;
			} else {
				highBidder.addPurchase(this);
				seller.removeItem(this);
				sold = true;
				System.out.println("Congratulations, purchase of "+ name + " was successful");
				return true;
			}
		} else {
			System.out.println("Bid of $" + newBid + " is too low.");
			return false;
		}
	}

	//More getters and setters
	@Override
	public double getBuyNowPrice() {
		return buyNowPrice;
	}

	@Override
	public void setBuyNowPrice(double buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
		System.out.println("Seller has been set.");
	}
	
	public Seller getSeller() {
		return seller;
	}
	
	//Called by system periodically to see if the endDate has been reached
	//If it has then remove the item from sell list and add to the highBidder.buyList
	//Changes the sold flag to true if the endDate has passed
	public void updateTime() {
		if(new Date().after(endDate)) {
			highBidder.addPurchase(this);
			seller.removeItem(this);
			sold = true;
			
		}
	}
	//A toString dump of all the information
	public String toString() {
		return "name: " + name +"\n" +
				"description: " + description +"\n" +
				"location: " + location + "\n" +
				"buy now price: $" + buyNowPrice + "\n" +
				"current bid: $" + highBid + "\n" +
				"current high bidder: " + highBidder.getUserName() + "\n" + 
				"seller: " + seller.getUserName() + "\n" +
				"end date: " + endDate.toString();
	}

}
