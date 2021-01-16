import java.util.ArrayList;

public class Seller extends User implements SellerInterface {

    ArrayList<Item> sellList;
    
    //Default constructor
    public Seller() {
    	userName = "";
    	firstName = "";
    	lastName = "";
    	buyList = new ArrayList<Item>();
    	sellList = new ArrayList<Item>();
    	
    }
    
    //Overloaded constructor
    public Seller(String username, String firstName, String lastName) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        buyList = new ArrayList<Item>();
        sellList = new ArrayList<Item>();
    }
    
    //check if sellList is at 20 capacity
    //if not then add item to sellList
	@Override
	public void sellAnItem(Item item) {
		if(sellList.size()>=20) {
			System.out.println("Your sell list is at capacity.");
		} else {
			sellList.add(item);
			item.setSeller(this);
		}
	}

	//creates and returns a String of names for all items in sellList
	@Override
	public String getItemsForSale() {
		String saleList = "";
		for(int i=0; i<sellList.size(); i++) {
			saleList += sellList.get(i).getName() + "\n";
			
		}
		return saleList;
	}
	
	//when called removes the passed item from sellList
	@Override
	public void removeItem(Item item) {
		sellList.remove(item);
		
	}
}
