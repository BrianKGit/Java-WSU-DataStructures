/*
*
*
*
*/

public interface UserInterface {
   
   /**
   * @return name The name of the User
   * 
   */
   public String getUserName();
   
   /**
   * @param userName Sets the name of the User
   */
   public void setUserName(String userName);
   
   /**
   * @return firstName The first name of the User
   */
   public String getFirstName();
   
   /**
   * @param firstName Sets the first name of the User
   */
   public void setFirstName(String firstName);
   
   /**
   * @return lastName The last name of the User
   */
   public String getLastName();
   
   /**
   * @param lastName Sets the last name of the User
   */
   public void setLastName(String lastName);
   
   /**
   * Require: newBid greater than 0
   * @param newBid sends newBid to setHighBid() in Item
   * @param item Item to bid on
   */
   public void bid(Item item, double newBid);
   
   /**
   * @param item Adds item to buyList
   */
   public void addPurchase(Item item);
   
   /**
   * @return item Prints the last item added to buyList
   */
   public Item getLastPurchase();
   
   /**
   * @return String purchaseList Prints all items in buyList
   */
   public String getAllPurchases();
   
   /**
    * @return String user information
    */
   public String toString();
   
}
