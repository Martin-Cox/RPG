package main;

import java.lang.reflect.Field;

/**
 * Labels for all entities in the game. To implement translations, you should change these values
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Labels {

    //Character Stats
    public static final String HP = "Hit Points";
    public static final String level = "Level";
    public static final String agility = "Agility";
    public static final String defence = "Defence";
    public static final String evasion = "Evasion";
    public static final String hitRate = "Hit Rate";
    public static final String luck = "Luck";
    public static final String magic = "Magic";
    public static final String spirit = "Spirit";
    public static final String strength = "Strength";


    //Item Names
    public static final String itemNameHealthPotion = "Health Potion";
    public static final String itemNameElixir = "Elixir";
    public static final String itemNameMagicStone = "Magic Stone";


    //Item Descriptions
    public static final String itemDescHealthPotion = "Restores 200HP";
    public static final String itemDescElixir = "Removes any negative status effects";
    public static final String itemDescMagicStone = "Adds 1 point permanently to the " + Labels.magic + " stat";


    //Item Types
    public static final String itemTypeWeapon = "Weapon";
    public static final String itemTypeAmmo = ".38 Revolver Ammo";


    //Magic Names
    public static final String magicNameFireball = "Fireball";
    public static final String magicNameTornado = "Tornado";
    public static final String magicNameCure = "Cure";


    //Magic Descriptions
    public static final String magicDescFireball = "A burning ball of fire is launched at a single target";
    public static final String magicDescTornado = "A deadly tornado does massive damage to all enemies";
    public static final String magicDescCure = "Restores 200HP";


    //Elements
    public static final String elementHealing = "Healing";
    public static final String elementFire = "Fire";
    public static final String elementWind = "Wind";


    //Status Effects
    public static final String statusBurning = "Burning";
    public static final String statusNone = "None";




    /**
     * Gets the flavour text for a given label
     *
     * @param Label The label to be parsed
     * @return The string value of the label name Label
     */
    public static Object getLabelValue(String Label) {
        Object labels = new Labels();

        try {
            Field field = labels.getClass().getField(Label);
            return field.get(labels);
        } catch (Exception e) {
            return "PARSE_LABEL_ERROR";
        }
    }

}
