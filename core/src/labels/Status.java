package labels;

import java.lang.reflect.Field;

/**
 * Created by Martin on 12/05/2015.
 */
public class Status {

    //Status Effect Names
    public static final String statusNameBurning = "Burning";
    public static final String statusNameHealing = "Healing";
    public static final String statusNameBoostStat = "Boost Stat";
    public static final String statusNameRemoveStatusEffects = "Purify";
    public static final String statusNameNone = "None";

    //Status Effect Names
    public static final String statusDescBurning = "Hot fire damages the target and weakens their defence";
    public static final String statusDescHealing = "Healing desc.";
    public static final String statusDescBoostStat = "Boosts the value of a stat by a given value";
    public static final String statusDescRemoveStatusEffects = "Remove all status effects from a target";
    public static final String statusDescNone = "No effect";

    /**
     * Gets the flavour text for a given label
     *
     * @param Label The label to be parsed
     * @return The string value of the label name Label
     */
    public static Object getLabelValue(String Label) {
        Object labels = new Status();

        try {
            Field field = labels.getClass().getField(Label);
            return field.get(labels);
        } catch (Exception e) {
            return "PARSE_LABEL_ERROR";
        }
    }

}
