package entities;

import labels.Items;
import labels.Status;

import java.util.ArrayList;

/**
 * All Status Effects in the game will be taken from a master list. That way we can get Status Effects using getters from properties such as name etc.
 *
 * @author Martin Cox
 * @since 2015-05-13
 */
public class StatusEffectList {

    public static ArrayList statusEffectList;

    public StatusEffectList() {
        statusEffectList = new ArrayList<StatusEffect>();
    }

    public ArrayList getStatusEffectList() {
        return statusEffectList;
    }

    /**
     * Gets a status effect object from a given label (as found in labels.Status)
     * the label will be in the format when taken from the database e.g. statusNameHealing
     * NOT labels.Status.statusNameHealing
     *
     * @param label the label (as found in labels.Items)
     * @return If the status exists then the item is returned, otherwise null
     */
    public Item getStatusEffectFromListByLabel(String label) {
        String statusEffectName = Status.getLabelValue(label).toString();

        for (int i = 0; i < statusEffectList.size(); i++) {
            Item currItem = (Item) statusEffectList.get(i);
            if (currItem.getName().equalsIgnoreCase(statusEffectName)) {
                return currItem;
            }
        }

        return null;
    }

    /**
     * Gets a status effect object from a given status effect name either in raw string format e.g. "Burning"
     * or in labels version e.g. labels.Status.statusNameBurning
     *
     * @param statusEffectName the name of the item
     * @return If the item exists then the item is returned, otherwise null
     */
    public Item getStatusEffectmFromListByItemName(String statusEffectName) {
        for (int i = 0; i < statusEffectList.size(); i++) {
            Item currItem = (Item) statusEffectList.get(i);
            if (currItem.getName().equalsIgnoreCase(statusEffectName)) {
                return currItem;
            }
        }

        return null;
    }
}
