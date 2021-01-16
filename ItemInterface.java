import java.util.Date;


public interface ItemInterface {
	
	
	/**
	 * @return name The name of the Item
	 */
	public String getName();
	
	/**
	 * @param name Sets the name of the Item
	 */
	public void setName(String name);
	
	/**
	 * @return description The description of the item
	 */
	public String getDescription();
	
	/**
	 * @param description Sets the description of the Item as a string
	 */
	public void setDescription(String description);
	
	/**
	 * @return highBid Shows the current high bid
	 */
	public double getHighBid();
	
	/**
	 * @param newBid Sets a new high bid as a double
         * @param user The user who set the highBid
	 * @return boolean Tell whether or not the bid was successful
	 */
	public boolean setHighBid(double newBid, User user);
	
	/**
	 * @return buyNowPrice Shows the price to buy now
	 */
	public double getBuyNowPrice();
	
	/**
	 * @param buyNowPrice The price to buy the Item
	 * Require: buyNowPrice greater than 0
	 */
	public void setBuyNowPrice(double buyNowPrice);
	
	/**
	 * @return Returns the location of the item as a string
	 */
	public String getLocation();
	
	/**
	 * @param location The location of the Item
	 */
	public void setLocation(String location);
	
	
	/**
	 * @return the end date of the item auction as type Date
	 */
	public Date getEndDate();
	
	/**
         * Require: endDate.after(new Date())
	 * @param endDate The date that the Item auction ends
	 */
	public void setEndDate(Date endDate);
	
	/**
	 * Sets the seller for the item
	 * @param seller The seller of the item
	 */
	public void setSeller(Seller seller);
	
	/**
	 * @return Seller returns the seller of the item
	 */
	public Seller getSeller();
	
	/**
	 * Ensure: Item is removed from sellList and added to buyList when endDate is reached
	 */
	public void updateTime();
	
	/**
	 * @return String Item information
	 */
	public String toString();
	
	
}
