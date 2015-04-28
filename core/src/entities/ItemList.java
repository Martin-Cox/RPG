package entities;

import labels.*;

import java.util.ArrayList;

/**
 * All items in the game will be taken from a master list. That way we can get items using getters from properties such as name etc.
 *
 * @author Martin Cox
 * @since 2015-04-28
 */
public class ItemList {

    public static ArrayList itemList;

    public ItemList() {
        itemList = new ArrayList<Item>();
    }

    public ArrayList getItemList() {
        return itemList;
    }

    /**
     * Gets a item object from a given label (as found in labels.Items)
     * the label will be in the format when taken from the database e.g. itemNameElixir
     * NOT labels.Item.itemNameElixir
     *
     * @param label the label (as found in labels.Items)
     * @return If the item exists then the item is returned, otherwise null
     */
    public Item getItemFromListByLabel(String label) {
        String itemName = labels.Items.getLabelValue(label).toString();

        for (int i = 0; i < itemList.size(); i++) {
            Item currItem = (Item) itemList.get(i);
            if (currItem.getName().equalsIgnoreCase(itemName)) {
                return currItem;
            }
        }

        return null;
    }

    /**
     * Gets a item object from a given item name either in raw string format e.g. "Elixir"
     * or in labels version e.g. labels.Item.itemNameElixir
     *
     * @param itemName the name of the item
     * @return If the item exists then the item is returned, otherwise null
     */
    public Item getMagicFromListByMagicName(String itemName) {
        for (int i = 0; i < itemList.size(); i++) {
            Item currItem = (Item) itemList.get(i);
            if (currItem.getName().equalsIgnoreCase(itemName)) {
                return currItem;
            }
        }

        return null;
    }
}
