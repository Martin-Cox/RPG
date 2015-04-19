package entities;

/**
 * Instance of an item
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Item {

    private String name;
    private String description;

    private boolean canBeUsedInBattle;      //Can the item be used in battle
    private boolean canBeUsedInWorld;       //Can the item be used in the world

    private String itemType;
    private Double damage;

    /**
     * Create a new item
     *
     * @param Name The name of the item
     * @param Description The items description
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     * @param ItemType Defines the type of item e.g. "Weapon", "Tool"
     */
    public Item(String Name, String Description, boolean CanBeUsedInBattle, boolean CanBeUsedInWorld, String ItemType) {
        name = Name;
        description = Description;
        canBeUsedInBattle = CanBeUsedInBattle;
        canBeUsedInWorld = CanBeUsedInWorld;
        itemType = ItemType;
    }

    /**
     * Create a new item
     *
     * @param Name The name of the item
     * @param Description The items description
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     * @param ItemType Defines the type of item e.g. "Weapon", "Tool"
     * @param Damage The base damage this item does when used in battle
     */
    public Item(String Name, String Description, boolean CanBeUsedInBattle, boolean CanBeUsedInWorld, String ItemType, Double Damage) {
        name = Name;
        description = Description;
        canBeUsedInBattle = CanBeUsedInBattle;
        canBeUsedInWorld = CanBeUsedInWorld;
        damage = Damage;
        itemType = ItemType;
    }



    public String getName() {
        return this.name;
    }
}
