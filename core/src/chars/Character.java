package chars;

import entities.Item;
import entities.Magic;
import entities.Weapon;
import labels.Labels;

import java.util.LinkedHashMap;

/**
 * Created by Martin on 25/04/2015.
 */
public class Character {

    String name;
    LinkedHashMap<String, Integer> stats = new LinkedHashMap();
    LinkedHashMap<Item, Integer> inventory = new LinkedHashMap();
    LinkedHashMap<Magic, Integer> magic = new LinkedHashMap();
    Weapon equippedWeapon_L;
    Weapon equippedWeapon_R;

    /**
     *
     * @param Name The full name of the character
     * @param Stats LinkedHashMap of Stat names and value pairs
     * @param Inventory LinkedHashMap of Items and quantity pairs
     * @param Magic LinkedHashMap of Magic and quantity pairs
     */
    public Character(String Name, LinkedHashMap Stats, LinkedHashMap Inventory, LinkedHashMap Magic, Weapon EquippedWeapon_L, Weapon EquippedWeapon_R) {
        this.name = Name;
        if (Stats == null) { Stats = new LinkedHashMap(); }
        if (Inventory == null) { Inventory = new LinkedHashMap(); }
        if (Magic == null) { Magic = new LinkedHashMap(); }
        this.stats = Stats;
        this.inventory = Inventory;
        this.magic = Magic;
        this.equippedWeapon_L = EquippedWeapon_L;
        this.equippedWeapon_R = EquippedWeapon_R;
    }

    /**
     * Gets character name
     *
     * @return String name
     */
    public String getName() { return this.name; }

    /**
     * Gets stats
     *
     * @return LinkedHashMap of stats
     */
    public LinkedHashMap<String, Integer> getStats() { return this.stats; }

    /**
     * Gets the inventory
     *
     * @return LinkedHashMap of the inventory with Item, Quantity pairs
     */
    public LinkedHashMap<Item, Integer> getInventory() { return this.inventory; }

    /**
     * Gets the magic inventory
     *
     * @return LinkedHashMap of the magic inventory with Magic, Quantity pairs
     */
    public LinkedHashMap<Magic, Integer> getMagic() { return this.magic; }

    /**
     * Sets the magic inventory
     *
     * @param newMagic LinkedHashMap of Magic, Value pairs
     */
    public void setMagic(LinkedHashMap<Magic, Integer> newMagic) { this.magic = newMagic; }

    /**
     * Updates characters magic inventory by setting the quantity of a given magic
     *
     * @param magic The magic to be updated to the characters inventory
     * @param quantity The number of this magic the player will have in their inventory
     */
    public void setMagicQuantity(Magic magic, Integer quantity) {
        if (quantity >= 0 && quantity <= 255) { this.magic.put(magic, quantity); }
    }

    /**
     * Updates characters magic inventory by adding the magic and quantity.
     * Does not allow the quantity of magic in the characters inventory to go below 0.
     * If a situation does occur where the characters quantity will go below 0, then
     * the characters quantity is set to 0 instead.
     *
     * @param magic The magic to be updated/added to the characters inventory
     * @param quantity The number of this magic to add or remove
     */
    public void updateMagic(Magic magic, Integer quantity) {
        Integer updatedQuantity;
        try {
            updatedQuantity = this.magic.get(magic).intValue() + quantity;
            if (updatedQuantity < 0)  {updatedQuantity = 0; }
            if (updatedQuantity > 255)  {updatedQuantity = 255; }
        } catch(NullPointerException e) {
            //This just means that the character didn't already have this magic in their inventory

            //If character does not have any of the spell and we are trying to remove some, then add the magic to the inventory but with 0 quantity
            if (quantity > 0) {
                if (quantity <= 255) {
                    updatedQuantity = quantity;
                } else {
                    updatedQuantity = 255;
                }
            } else {
                updatedQuantity = 0;
            }
        }
        this.magic.put(magic, updatedQuantity);
        try {
            //If player.getJunctions.contains(Magic) {
            //this.updateStats();           //PLAYER STATS WILL NEED TO BE UPDATED AFTER PLAYER MAGIC CHANGES AND THAT MAGIC IS JUNCTIONED
            //}
        } catch (Exception e) {
            //Don't really know how to handle this exception :/
        }
    }

    /**
     * Equips a weapon in the characters left or right hand and removes 1 quantity from characters inventory.
     * If the weapon has to be used with both hands then update both hands to reflect this.
     * If character currently has an equipped weapon then that weapon is put back into the inventory.
     *
     * @param HandToEquip A string value from Labels to determine which hand to equip the weapon in
     * @param Weapon The weapon to equip
     */
    public void equipWeapon(String HandToEquip, Weapon Weapon) {
        if (HandToEquip == Labels.leftHand) {
            //Equip weapon in left hand

            //Remove currently equipped weapon (if any) and place it back into the inventory
            //Weapon equippedItemToReplace = this.equippedWeapon_L;
            //if (equippedItemToReplace != null) { this.updateInventory(equippedItemToReplace, 1);

            //Remove weapon to equip from inventory and equip item
            //this.updateInventory(Weapon, -1);
            this.equippedWeapon_L = Weapon;
            if (Weapon.getDualHanded()) {
                this.equippedWeapon_R = Weapon;
            }
        } else if (HandToEquip == Labels.rightHand) {
            //Equip weapon in right hand

            //Remove currently equipped weapon (if any) and place it back into the inventory
            //Weapon equippedItemToReplace = this.equippedWeapon_R;
            //if (equippedItemToReplace != null) { this.updateInventory(equippedItemToReplace, 1);

            //Remove weapon to equip from inventory and equip item
            //this.updateInventory(Weapon, -1);
            this.equippedWeapon_R = Weapon;
            if (Weapon.getDualHanded()) {
                this.equippedWeapon_L = Weapon;
            }
        }
    }
}
