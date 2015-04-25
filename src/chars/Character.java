package chars;

import entities.Item;
import entities.Magic;

import java.util.LinkedHashMap;

/**
 * Created by Martin on 25/04/2015.
 */
public class Character {

    String name;
    LinkedHashMap<String, Integer> stats = new LinkedHashMap();
    LinkedHashMap<Item, Integer> inventory = new LinkedHashMap();
    LinkedHashMap<Magic, Integer> magic = new LinkedHashMap();

    /**
     *
     * @param Name The full name of the character
     * @param Stats LinkedHashMap of Stat names and value pairs
     * @param Inventory LinkedHashMap of Items and quantity pairs
     * @param Magic LinkedHashMap of Magic and quantity pairs
     */
    public Character(String Name, LinkedHashMap Stats, LinkedHashMap Inventory, LinkedHashMap Magic) {
        this.name = Name;
        if (Stats == null) { Stats = new LinkedHashMap(); }
        if (Inventory == null) { Inventory = new LinkedHashMap(); }
        if (Magic == null) { Magic = new LinkedHashMap(); }
        this.stats = Stats;
        this.inventory = Inventory;
        this.magic = Magic;
    }

}
