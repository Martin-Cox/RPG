package entities;

import labels.*;

import java.util.ArrayList;

/**
 * All magic in the game will be taken from a master list. That way we can get magic using getters from properties such as name etc.
 *
 * @author Martin Cox
 * @since 2015-04-28
 */
public class MagicList {

    public static ArrayList magicList;

    public MagicList() {
       magicList = new ArrayList<Magic>();
    }

    public ArrayList getMagicList() {
        return magicList;
    }

    /**
     * Gets a magic object from a given label (as found in labels.Magic)
     * the label will be in the format when taken from the database e.g. magicNameFireball
     * NOT labels.Magic.magicNameFireball
     *
     * @param label the label (as found in labels.Magic)
     * @return If the magic exists then the magic is returned, otherwise null
     */
    public Magic getMagicFromListByLabel(String label) {
        String magicName = labels.Magic.getLabelValue(label).toString();

        for (int i = 0; i < magicList.size(); i++) {
            Magic currMagic = (Magic) magicList.get(i);
            if (currMagic.getName().equalsIgnoreCase(magicName)) {
                return currMagic;
            }
        }

        return null;
    }

    /**
     * Gets a magic object from a given magic name either in raw string format e.g. "Fireball"
     * or in labels version e.g. labels.Magic.MagicNameFireball
     *
     * @param magicName the name of the magic
     * @return If the magic exists then the magic is returned, otherwise null
     */
    public Magic getMagicFromListByMagicName(String magicName) {
        for (int i = 0; i < magicList.size(); i++) {
            Magic currMagic = (Magic) magicList.get(i);
            if (currMagic.getName().equalsIgnoreCase(magicName)) {
                return currMagic;
            }
        }

        return null;
    }
}
