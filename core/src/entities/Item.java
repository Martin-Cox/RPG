package entities;

/**
 * Instance of an item
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Item {

    String name;
    String description;

    boolean canBeUsedInBattle;      //Can the item be used in battle
    boolean canBeUsedInWorld;       //Can the item be used in the world

    /**
     * Create a new item
     *
     * @param Name The name of the item
     * @param Description The items description
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     */
    public Item(String Name, String Description, boolean CanBeUsedInBattle, boolean CanBeUsedInWorld) {
        name = Name;
        description = Description;
        canBeUsedInBattle = CanBeUsedInBattle;
        canBeUsedInWorld = CanBeUsedInWorld;
    }

    /**
     * Returns value of the name property
     *
     * @return String
     */
    public String getName() { return this.name; }
}
