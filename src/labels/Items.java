package labels;

import java.lang.reflect.Field;

/**
 * Created by Martin on 25/04/2015.
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
