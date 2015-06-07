package chars;

import consts.Consts;
import entities.Item;
import entities.Magic;
import entities.StatusEffect;
import entities.Weapon;
import labels.Labels;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Martin on 25/04/2015.
 */
public class Character {

    String name;
    LinkedHashMap<String, Integer> baseStats = new LinkedHashMap();
    LinkedHashMap<String, Integer> modStats = new LinkedHashMap();
    LinkedHashMap<Item, Integer> inventory = new LinkedHashMap();
    LinkedHashMap<Magic, Integer> magic = new LinkedHashMap();
    Weapon equippedWeapon_L;
    Weapon equippedWeapon_R;
    ArrayList<StatusEffect> statusEffects;

    /**
     * Creates a new instance of a character with no affinities
     *
     * @param Name The full name of the character
     * @param Stats LinkedHashMap of Stat names and value pairs
     * @param Inventory LinkedHashMap of Items and quantity pairs
     * @param Magic LinkedHashMap of Magic and quantity pairs
     */
    public Character(String Name, LinkedHashMap Stats, LinkedHashMap Inventory, LinkedHashMap Magic) {
        this.name = Name;
        if (Stats == null) { Stats = new LinkedHashMap(); }
        if (Inventory == null) { Inventory = new LinkedHashMap(); }
        if (Magic == null) { Magic = new LinkedHashMap(); }
        this.baseStats = Stats;
        this.modStats = this.baseStats;
        this.inventory = Inventory;
        this.magic = Magic;
    }

    /**
     * Creates a new instance of a character with no affinities
     *
     * @param Name The full name of the character
     * @param Stats LinkedHashMap of Stat names and value pairs
     * @param Inventory LinkedHashMap of Items and quantity pairs
     * @param Magic LinkedHashMap of Magic and quantity pairs
     * @param EquippedWeapon_L A weapon to be equipped by default in this characters left hand
     * @param EquippedWeapon_R A weapon to be equipped by default in this characters right hand
     */
    public Character(String Name, LinkedHashMap Stats, LinkedHashMap Inventory, LinkedHashMap Magic, Weapon EquippedWeapon_L, Weapon EquippedWeapon_R) {
        this.name = Name;
        if (Stats == null) { Stats = new LinkedHashMap(); }
        if (Inventory == null) { Inventory = new LinkedHashMap(); }
        if (Magic == null) { Magic = new LinkedHashMap(); }
        this.baseStats = Stats;
        this.modStats = this.baseStats;
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
     * Gets characters base stats
     *
     * @return LinkedHashMap of stats
     */
    public LinkedHashMap<String, Integer> getBaseStats() { return this.baseStats; }

    /**
     * Gets characters modified stats for use in battle
     *
     * @return LinkedHashMap of stats
     */
    public LinkedHashMap<String, Integer> getModStatsStats() { return this.modStats; }


    /**
     * Gets the inventory
     *
     * @return LinkedHashMap of the inventory with Item, Quantity pairs
     */
    public LinkedHashMap<Item, Integer> getInventory() { return this.inventory; }

    /**
     * Sets the characters inventory
     *
     * @param newInv LinkedHashMap of Item, Value pairs
     */
    public void setInventory(LinkedHashMap<Item, Integer> newInv) { this.inventory = newInv; }

    /**
     * Updates characters inventory by setting the quantity of a given item
     *
     * @param item The item to be updated to the characters inventory
     * @param quantity The number of this item the player will have in their inventory
     */
    public void setItemQuantity(Item item, Integer quantity) {
        if (quantity >= 0 && quantity <= 255) { this.inventory.put(item, quantity); }
    }

    /**
     * Updates characters inventory by adding the item and quantity.
     * Does not allow the quantity of item in the characters inventory to go below 0.
     * If a situation does occur where the characters quantity will go below 0, then
     * the characters quantity is set to 0 instead.
     *
     * @param item The magic to be updated/added to the characters inventory
     * @param quantity The number of this magic to add or remove
     */
    public void updateInventory(Item item, Integer quantity) {
        Integer updatedQuantity;
        try {
            updatedQuantity = this.inventory.get(item).intValue() + quantity;
            if (updatedQuantity < 0)  {updatedQuantity = 0; }
            if (updatedQuantity > Consts.MAX_ITEM_QUANTITY)  {updatedQuantity = Consts.MAX_ITEM_QUANTITY; }
        } catch(NullPointerException e) {
            //This just means that the character didn't already have this item in their inventory

            //If character does not have any of the item and we are trying to remove some, then add the item to the inventory but with 0 quantity
            if (quantity > 0) {
                if (quantity <= Consts.MAX_ITEM_QUANTITY) {
                    updatedQuantity = quantity;
                } else {
                    updatedQuantity = Consts.MAX_ITEM_QUANTITY;
                }
            } else {
                updatedQuantity = 0;
            }
        }
        this.inventory.put(item, updatedQuantity);
    }

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
            if (updatedQuantity > Consts.MAX_SPELL_QUANTITY)  {updatedQuantity = Consts.MAX_SPELL_QUANTITY; }
        } catch(NullPointerException e) {
            //This just means that the character didn't already have this magic in their inventory

            //If character does not have any of the spell and we are trying to remove some, then add the magic to the inventory but with 0 quantity
            if (quantity > 0) {
                if (quantity <= Consts.MAX_SPELL_QUANTITY) {
                    updatedQuantity = quantity;
                } else {
                    updatedQuantity = Consts.MAX_SPELL_QUANTITY;
                }
            } else {
                updatedQuantity = 0;
            }
        }
        this.magic.put(magic, updatedQuantity);
        try {
            //If player.getAffinities.contains(Magic) {
            //this.updateStats();           //PLAYER STATS WILL NEED TO BE UPDATED AFTER PLAYER MAGIC CHANGES AND THAT MAGIC IS AN AFFINITY
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
        //TODO: Need to check if item is in the characters inventory first
        if (HandToEquip.equalsIgnoreCase(Labels.leftHand)) {
            //Equip weapon in left hand

            Weapon returnWeapon_L = null;
            Weapon returnWeapon_R = null;

            if (this.equippedWeapon_L != null) {
                returnWeapon_L = this.equippedWeapon_L;
            }

            this.equippedWeapon_L = Weapon;
            if (Weapon.getDualHanded()) {
                if (this.equippedWeapon_R != null) {
                    returnWeapon_R = this.equippedWeapon_R;
                }
                this.equippedWeapon_R = Weapon;
            }

            if (returnWeapon_L != null) {
                updateInventory(returnWeapon_L, 1);
            }

            if (returnWeapon_R != null) {
                updateInventory(returnWeapon_R, 1);
            }

        } else if (HandToEquip.equalsIgnoreCase(Labels.rightHand)) {
            //Equip weapon in right hand

            Weapon returnWeapon_L = null;
            Weapon returnWeapon_R = null;

            if (this.equippedWeapon_R != null) {
                returnWeapon_R = this.equippedWeapon_R;
            }

            this.equippedWeapon_R = Weapon;
            if (Weapon.getDualHanded()) {
                if (this.equippedWeapon_L != null) {
                    returnWeapon_L = this.equippedWeapon_L;
                }
                this.equippedWeapon_L = Weapon;
            }

            if (returnWeapon_L != null) {
                updateInventory(returnWeapon_L, 1);
            }

            if (returnWeapon_R != null) {
                updateInventory(returnWeapon_R, 1);
            }
        }
    }

    /**
     * Gets the characters status effects
     *
     * @return ArrayList of status effects as Strings
     */
    public ArrayList<StatusEffect> getStatusEffects() { return this.statusEffects; }

    /**
     * Sets the characters status effects
     *
     * @param StatusEffects ArrayList of status effects as Strings
     */
    public void setStatusEffects(ArrayList<StatusEffect> StatusEffects) { this.statusEffects = StatusEffects; }

    /**
     * Removes all status effects
     */
    public void removeStatusEffects() { this.statusEffects = new ArrayList<StatusEffect>(); }

    /**
     * Removes a status effect
     *
     * @param StatusEffect A status effect to remove from this character
     */
    public void removeStatusEffect(String StatusEffect) {
        if (this.statusEffects.contains(StatusEffect)) {
            this.statusEffects.remove(StatusEffect);
        }
    }

    /**
     * Adds a status effect
     *
     * @param StatusEffect A status effect to give to this character
     */
    public void addStatusEffect(StatusEffect StatusEffect) {
        if (!this.statusEffects.contains(StatusEffect)) {
            this.statusEffects.add(StatusEffect);
        }
    }
}
