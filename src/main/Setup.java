package main;

import db.DB;
import entities.Item;
import entities.Magic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * A setup script to be ran at the launch of the game. Creates entities and performs one time tasks.
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Setup {

    /**
     * Creates an ArrayList of all the items in the game
     *
     * @return Arraylist of item objects
     */
    public static ArrayList createItemsBasic() {

        Item item_1 = new Item(Labels.itemNameHealthPotion, "Restores 200HP", true, true);
        Item item_2 = new Item(Labels.itemNameElixir, "Removes any negative status effects", true, true);
        Item item_3 = new Item(Labels.itemNameMagicStone, "Adds 1 point permanently to the " + Labels.magic +" stat", false, true);

        ArrayList<Item> items = new ArrayList<>(
                Arrays.asList(item_1, item_2, item_3));

        return items;
    }


    /**
     * Retrieves all magic entries in the DB and converts them into an ArrayList of Magic objects.
     *
     * @return Arraylist of magic objects
     */
    public static ArrayList createMagic() {

        ArrayList<Magic> magic = new ArrayList<>();

        ArrayList<ArrayList> rows = DB.getMagic();

        for (int i = 0; i < rows.size(); i++) {
            ArrayList<ArrayList> row = rows.get(i);

            //Get Values
            String[] stringRow = new String[row.size()];
            stringRow = row.toArray(stringRow);

            String name = stringRow[0];
            String desc = stringRow[1];
            Boolean battleUse = false;
            Boolean worldUse = false;
            if (stringRow[2].equalsIgnoreCase("true")) {
                battleUse = true;
            }
            if (stringRow[3].equalsIgnoreCase("true")) {
                worldUse = true;
            }
            String element = stringRow[13];
            double baseDamage = Double.parseDouble(stringRow[14]);
            String statusEffectName = stringRow[15];
            double statusEffectBaseChance = Double.parseDouble(stringRow[16]);

            //Assign Stat Values
            LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();
            statModifiers.put(Labels.agility, Double.parseDouble(stringRow[4]));
            statModifiers.put(Labels.defence, Double.parseDouble(stringRow[5]));
            statModifiers.put(Labels.evasion, Double.parseDouble(stringRow[6]));
            statModifiers.put(Labels.hitRate, Double.parseDouble(stringRow[7]));
            statModifiers.put(Labels.luck, Double.parseDouble(stringRow[8]));
            statModifiers.put(Labels.magic, Double.parseDouble(stringRow[9]));
            statModifiers.put(Labels.spirit, Double.parseDouble(stringRow[10]));
            statModifiers.put(Labels.strength, Double.parseDouble(stringRow[11]));
            statModifiers.put(Labels.HP, Double.parseDouble(stringRow[12]));


            //Create a magicItem and add it to the ArrayList
            Magic magicItem = new Magic(name, desc, battleUse, worldUse, statModifiers, element, statusEffectName, baseDamage, statusEffectBaseChance);
            magic.add(magicItem);
        }

        return magic;
    }
}
