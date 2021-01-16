
/*
*
*
*
*/

public interface SellerInterface extends UserInterface{
   
   /**
   * @param item Add item to sellList
   */
   public void sellAnItem(Item item);
   
   /**
   * @return sellList.toString() Prints all items in sellList
   */
   public String getItemsForSale();
   
   /**
   * @param item Removes item from sellList
   */
   public void removeItem(Item item);
   
}
