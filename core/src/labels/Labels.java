package labels;

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


    //Elements
    public static final String elementHealing = "Healing";
    public static final String elementFire = "Fire";
    public static final String elementWind = "Wind";


    //Status Effects
    public static final String statusBurning = "Burning";
    public static final String statusNone = "None";


    //Misc labels
    public static final String leftHand = "Left Hand";
    public static final String rightHand = "Right Hand";

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
