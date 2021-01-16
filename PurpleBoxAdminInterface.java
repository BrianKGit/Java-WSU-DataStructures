package assignment3;


public interface PurpleBoxAdminInterface {
    
    /**
     * 
     * @param item User input adds Media to inventory
     * Ensure: item is added to inventory
     */
    public void addInventory(Media item);
    
    /**
     * 
     * @param item Admin input removes Media from inventory
     * Ensure: item is removed from inventory
     */
    public void removeInventory(Media item);
    
    /**
     * 
     * @param type Admin input Media type of DVD, Blu-ray, X-Box, or PS4
     * @param price sets price of selected media type
     * Require: Admin sets price as positive double
     * Require: Admin sets type as DVD, Blu-ray, X-Box, or PS4
     */
    public void setPrice(String type, double price);
    
    /**
     * 
     * @param promo Admin input sets a String for User to apply discount
     * @param discount sets double amount to deduct from price
     * Require: Admin sets discount as positive double
     */
    public void setPromo(String promo, double discount);
    
    /**
     * 
     * @param enabled Sets flag for PurpleBoxUser to be disabled
     */
    public void enable(Boolean enabled);
    
}
