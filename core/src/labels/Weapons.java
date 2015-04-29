package labels;

import java.lang.reflect.Field;

/**
 * Item text for all weapons in the game. To implement translations, you should change these values
 *
 * @author Martin Cox
 * @since 2015-04-29
 */
public class Weapons {

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