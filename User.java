import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class User implements UserInterface {
	
    String userName, firstName, lastName;
    ArrayList<Item> buyList;
    
    //Default constructor
    public User() {
    	userName = "";
    	firstName = "";
    	lastName = "";
    	buyList = new ArrayList<Item>();
    }
    
    //Overloaded constructor
    public User(String username, String firstName, String lastName) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        buyList = new ArrayList<Item>();
    }
    
    //Getters and setters
    @Override
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //Passes the bidPrice to the Item for further evaluation
	@Override
	public void bid(Item item, double bidPrice) {
		item.setHighBid(bidPrice, this);
			
	}
	
	//Adds the purchased Item to the buyList and if buyList.size() is greater than 10 remove the oldest Item in buyList
	@Override
	public void addPurchase(Item item) {
		buyList.add(item);
		if(buyList.size()>10) {
			buyList.remove(0);
		}
	}
	
	//Returns the most recent Item purchased
	@Override
	public Item getLastPurchase() {
		return buyList.get(buyList.size()-1);
	}
	
	//Returns a string representation of the last ten items purchased
	@Override
	public String getAllPurchases() {
		String purchaseList = "";
		for(int i=0; i<buyList.size(); i++) {
			purchaseList += buyList.get(i).getName() + "\n";
			
		}
		return purchaseList;
	}
	
	//toString dump of user information
	public String toString() {
		String userString = userName + "\n" +
							firstName + "\n" +
							lastName;
		return userString;
	}


}
