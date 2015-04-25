package chars;

import java.util.LinkedHashMap;

import entities.Magic;
import labels.Labels;
import entities.Item;

/**
 * The player character instance. It is only initialised once.
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Player extends Character{

     /**
     * Create a new player character instance. Only 1 should be initialised.
     *
     * @param Name The player characters name. Entered by the player.
     */
    public Player(String Name) {

        super(Name, null, null, null);

        //Players starting stats
        super.stats.put(Labels.HP, 400);
        super.stats.put(Labels.level, 1);
        super.stats.put(Labels.agility, 100);
        super.stats.put(Labels.defence, 90);
        super.stats.put(Labels.evasion, 35);
        super.stats.put(Labels.hitRate, 255);
        super.stats.put(Labels.luck, 60);
        super.stats.put(Labels.magic, 90);
        super.stats.put(Labels.spirit, 50);
        super.stats.put(Labels.strength, 110);
    }

    /**
     * Gets player character name
     *
     * @return String Player name
     */
    public String getName() { return this.name; }

    /**
     * Gets player stats
     *
     * @return LinkedHashMap of player stats
     */
    public LinkedHashMap<String, Integer> getStats() { return this.stats; }

    /**
     * Gets the players inventory
     *
     * @return LinkedHashMap of the players inventory with Item, Quantity pairs
     */
    public LinkedHashMap<Item, Integer> getInventory() { return this.inventory; }

    /**
     * Gets the players magic inventory
     *
     * @return LinkedHashMap of the players magic inventory with Magic, Quantity pairs
     */
    public LinkedHashMap<Magic, Integer> getMagic() { return this.magic; }

    /**
     * Sets the players magic inventory
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
        if (quantity >= 0) { this.magic.put(magic, quantity); }
    }

    /**
     * Updates characters magic inventory by adding the magic and quantity.
     * Does not allow the quantity of magic in the players inventory to go below 0.
     * If a situation does occur where the players quantity will go below 0, then
     * the players quantity is set to 0 instead.
     *
     * @param magic The magic to be updated/added to the characters inventory
     * @param quantity The number of this magic to add or remove
     */
    public void updateMagic(Magic magic, Integer quantity) {
        Integer updatedQuantity;
        try {
            updatedQuantity = this.magic.get(magic).intValue() + quantity;
            if (updatedQuantity < 0)  {updatedQuantity = 0; }
        } catch(NullPointerException e) {
            //This just means that the character didn't already have this magic in their inventory

            //If character does not have any of the spell and we are trying to remove some, then add the magic to the inventory but with 0 quantity
            if (quantity > 0) {
                updatedQuantity = quantity;
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
            //Don't really know how to handle an exception :/
        }
    }
}
