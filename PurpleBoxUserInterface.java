package assignment3;

import java.util.ArrayList;

public interface PurpleBoxUserInterface {
    
    /**
     * 
     * @param name User input to search for
     * @return ArrayList<Media> list of movies and games containing user input.
     */
    public ArrayList<Media> searchByName(String name);
    
    /**
     * 
     * @param genre User inputs genre to search by
     * @return ArrayList<Media> list of movies and games of the selected genre
     * Require: User enters a valid genre
     */
    public ArrayList<Media> browseByGenre(String genre);
    
    /**
     * 
     * @return ArrayList<Media> list of movies and games sorted by most recent 
     * release date to oldest release date
     */
    public ArrayList<Media> browseByDate();
    
    /**
     * 
     * @return ArrayList<Media> list of movies and games sorted by critic 
     * ratings from highest to lowest
     */
    public ArrayList<Media> browseByRating();
    
    /**
     * 
     * @return ArrayList<Media> list of movies and games sorted from A-Z
     */
    public ArrayList<Media> browseByAlphabetical();
    
    /**
     * 
     * @param type User input choosing type from DVD, Blu-ray, X-Box, or PS4
     * @return ArrayList<Media> list of movies and games of the selected type
     * Require: User enters a valid Media type (DVD, Blu-ray, X-Box, or PS4)
     */
    public ArrayList<Media> browseByType(String type);
    
    /**
     * 
     * @param item User input movie or game to add to shopping cart
     * Ensure: item is added to User cart
     */
    public void addToCart(Media item);
    
    /**
     * 
     * @param item User input movie or game to remove from shopping cart
     * Ensure: item is no longer in User cart
     */
    public void removeFromCart(Media item);
    
    /**
     * Method removes all Media from User's ArrayList<Media>
     * Ensure: User cart is empty
     */
    public void clearCart();
    
    /**
     * 
     * @param item User input returns movie or game to inventory
     * Ensure: item is added to inventory
     */
    public void returnMedia(Media item);
    
    /**
     * 
     * @param promo User input applies discount to price of movie or game
     * Ensure: discount is subtracted from price or Media
     */
    public void applyPromo(String promo);
    
    /**
     * Accepts payment for total cart price and removes movies and games 
     * from inventory
     * Ensure: all items in cart are removed from inventory
     */
    public void checkout();
    
}
