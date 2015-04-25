package labels;

import java.lang.reflect.Field;

/**
 * Created by Martin on 25/04/2015.
 */
public class Magic {

    //Magic Names
    public static final String magicNameFireball = "Fireball";
    public static final String magicNameTornado = "Tornado";
    public static final String magicNameCure = "Cure";

    //Magic Descriptions
    public static final String magicDescFireball = "A burning ball of fire is launched at a single target";
    public static final String magicDescTornado = "A deadly tornado does massive damage to all enemies";
    public static final String magicDescCure = "Restores 200HP";

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
