package mainPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nd5152wx
 */
public interface WeaponInterface extends ItemInterface {
    
	/**
	 * Returns the highest damage that this weapon can deal
	 * @return Highest damage value
	 */
    public int getHighDamage();
    
    /**
     * Sets the highest damage value for this weapon
     * @param highDamage Highest damage value
     */
    public void setHighDamage(int highDamage);
    
    /**
     * Each weapon has a sound associated with it to add flavor to combat text.
     * @return Sound the weapon makes when it hits something.
     */
    public String getWeaponSound();
    
}
