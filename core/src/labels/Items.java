package labels;

import java.lang.reflect.Field;

/**
 * Item text for all items in the game. To implement translations, you should change these values
 *
 * @author Martin Cox
 * @since 2015-04-25
 */
public class Items {

    //Item Names
    public static final String itemNameHealthPotion = "Health Potion";
    public static final String itemNameElixir = "Elixir";
    public static final String itemNameMagicStone = "Magic Stone";

    //Item Descriptions
    public static final String itemDescHealthPotion = "Restores 200HP";
    public static final String itemDescElixir = "Removes any negative status effects";
    public static final String itemDescMagicStone = "Adds 1 point permanently to the " + Labels.magic + " stat";

    //Item Types
    public static final String itemtypeItem = "Item";
    public static final String itemtypeConsumable = "Consumable";
    public static final String itemtypeWeapon = "Melee Weapon";
    public static final String itemtypeRangedWeapon = "Ranged Weapon";
    public static final String itemtypeAmmo = "Ammo";


    //Weapon Names
    public static final String weaponNameRustyRevolver = "Rusty Revolver";
    public static final String weaponNameRustyDagger = "Rusty Dagger";
    //Weapon Descriptions
    public static final String weaponDescRustyRevolver = "An old revolver. It's almost falling to pieces, but can  still put a bullet into somebody";
    public static final String weaponDescRustyDagger = "An old and rusty iron dagger";


    //Ammo Names
    public static final String ammoName38Ammo = ".38 Ammo";
    //Ammo Descriptions
    public static final String ammoDesc38Ammo = "Common revolver ammunition";


    /**
     * Gets the flavour text for a given label
     *
     * @param Label The label to be parsed
     * @return The string value of the label name Label
     */
    public static Object getLabelValue(String Label) {
        Object labels = new Items();

        try {
            Field field = labels.getClass().getField(Label);
            return field.get(labels);
        } catch (Exception e) {
            return "PARSE_LABEL_ERROR";
        }
    }
}
