package main;

import db.DB;
import entities.*;
import labels.Items;
import labels.Labels;

import java.util.ArrayList;
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
    public static ItemList createItems() {

        ItemList itemList = new ItemList();
        StatusEffectList statusEffectList = createStatusEffects();

        ArrayList<ArrayList> rows = DB.getItems();

        //TODO: Will need to sort rows so that ammo type items are made before RangedWeapons


        for (int i = 0; i < rows.size(); i++) {
            ArrayList<ArrayList> row = rows.get(i);

            //Get Values
            String[] stringRow = new String[row.size()];
            stringRow = row.toArray(stringRow);

            String name = stringRow[0];
            String type = stringRow[1];
            String desc = stringRow[2];

            Boolean battleUse = false;
            Boolean worldUse = false;
            if (stringRow[3].equalsIgnoreCase("true")) {
                battleUse = true;
            }
            if (stringRow[4].equalsIgnoreCase("true")) {
                worldUse = true;
            }
            //String element = stringRow[13];
            double baseDamage = Double.parseDouble(stringRow[5]);
            double durability = Double.parseDouble(stringRow[6]);

            Boolean twoHanded = false;
            if (stringRow[7].equalsIgnoreCase("true")) {
                twoHanded = true;
            }

            String ammo = stringRow[8];
            String statusEffectName = stringRow[18];
            StatusEffect statusEffect = statusEffectList.getStatusEffectFromListByLabel(statusEffectName);

            //Assign Stat Values
            LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();
            statModifiers.put(Labels.agility, Double.parseDouble(stringRow[9]));
            statModifiers.put(Labels.defence, Double.parseDouble(stringRow[10]));
            statModifiers.put(Labels.evasion, Double.parseDouble(stringRow[11]));
            statModifiers.put(Labels.HP, Double.parseDouble(stringRow[12]));
            statModifiers.put(Labels.hitRate, Double.parseDouble(stringRow[13]));
            statModifiers.put(Labels.luck, Double.parseDouble(stringRow[14]));
            statModifiers.put(Labels.magic, Double.parseDouble(stringRow[15]));
            statModifiers.put(Labels.spirit, Double.parseDouble(stringRow[16]));
            statModifiers.put(Labels.strength, Double.parseDouble(stringRow[17]));

            Item item = null;
            String typeValue = (String) Items.getLabelValue(type);
            if (typeValue.equalsIgnoreCase(Items.itemtypeConsumable)) {
                item = new Consumable(name, desc, battleUse, worldUse, baseDamage, statusEffect);
            } else if (typeValue.equalsIgnoreCase(Items.itemtypeWeapon)) {
                item = new Weapon(name, desc, battleUse, worldUse, baseDamage, durability, statModifiers, twoHanded);
            } else if (typeValue.equalsIgnoreCase(Items.itemtypeRangedWeapon)) {
                item = new RangedWeapon(name, desc, battleUse, worldUse, baseDamage, durability, statModifiers, twoHanded, null);
                //item.setAmmo
            } else if (typeValue.equalsIgnoreCase(Items.itemtypeItem)) {
                item = new Item(name, desc, battleUse, worldUse);
            }
            //else if (typeValue.equalsIgnoreCase(Items.itemtypeAmmo) {
            //TODO: Add Ammo constructor

            itemList.getItemList().add(item);
        }
        return itemList;
    }


    /**
     * Retrieves all magic entries in the DB and converts them into an list of Magic objects.
     *
     * @return MagicList A list of all the magic
     */
    public static MagicList createMagic() {

        MagicList magicList = new MagicList();
        StatusEffectList statusEffectList = createStatusEffects();

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
            StatusEffect statusEffect = statusEffectList.getStatusEffectFromListByLabel(statusEffectName);
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
            Magic magicItem = new Magic(name, desc, battleUse, worldUse, statModifiers, element, statusEffect, baseDamage, statusEffectBaseChance);
            magicList.getMagicList().add(magicItem);
        }
        return magicList;
    }

    /**
     * Retrieves all status effect entries in the DB and converts them into an list of Status Effect objects.
     *
     * @return StatusEffectList A list of all the status effects
     */
    public static StatusEffectList createStatusEffects() {

        StatusEffectList statusEffectList = new StatusEffectList();

        ArrayList<ArrayList> rows = DB.getStatusEffects();

        for (int i = 0; i < rows.size(); i++) {
            ArrayList<ArrayList> row = rows.get(i);

            //Get Values
            String[] stringRow = new String[row.size()];
            stringRow = row.toArray(stringRow);

            String name = stringRow[0];
            String desc = stringRow[1];
            String element = stringRow[2];
            double baseDamage = Double.parseDouble(stringRow[3]);
            int numTurns;
            try {
                numTurns = Integer.parseInt(stringRow[4]);
            } catch (Exception e) {
                //If NUMBER_OF_TURNS in DB was null, then set it to -1 so we can choose constructor later to randomly gen numTurns
                numTurns = -1;
            }


            //Assign Stat Values
            LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();
            statModifiers.put(Labels.agility, Double.parseDouble(stringRow[5]));
            statModifiers.put(Labels.defence, Double.parseDouble(stringRow[6]));
            statModifiers.put(Labels.evasion, Double.parseDouble(stringRow[7]));
            statModifiers.put(Labels.hitRate, Double.parseDouble(stringRow[8]));
            statModifiers.put(Labels.luck, Double.parseDouble(stringRow[9]));
            statModifiers.put(Labels.magic, Double.parseDouble(stringRow[10]));
            statModifiers.put(Labels.spirit, Double.parseDouble(stringRow[11]));
            statModifiers.put(Labels.strength, Double.parseDouble(stringRow[12]));
            statModifiers.put(Labels.HP, Double.parseDouble(stringRow[13]));


            //Create a statusEffectItem and add it to the ArrayList
            StatusEffect statusEffectItem = new StatusEffect(name, desc, element, baseDamage, statModifiers, numTurns);

            statusEffectList.getStatusEffectList().add(statusEffectItem);
        }
        return statusEffectList;
    }
}
