package labels;


import java.lang.reflect.Field;

/**
 * Dialog text for all conversations in the game. To implement translations, you should change these values
 *
 * @author Martin Cox
 * @since 2015-04-25
 */
public class Dialogs {



    /**
     * Gets the flavour text for a given label
     *
     * @param Label The label to be parsed
     * @return The string value of the label name Label
     */
    public static Object getLabelValue(String Label) {
        Object labels = new Dialogs();

        try {
            Field field = labels.getClass().getField(Label);
            return field.get(labels);
        } catch (Exception e) {
            return "PARSE_LABEL_ERROR";
        }
    }
}
