package chars;

import java.util.LinkedHashMap;

import entities.Magic;
import main.Labels;
import entities.Item;

/**
 * The player character instance. It is only initialised once.
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Player {

    private String name;
    private LinkedHashMap<String, Integer> stats = new LinkedHashMap();
    private LinkedHashMap<Item, Integer> inventory = new LinkedHashMap();
    private LinkedHashMap<Magic, Integer> magic = new LinkedHashMap();

    /**
     * Create a new player character instance. Only 1 should be initialised.
     *
     * @param charName The player characters name. Entered by the player.
     */
    public Player(String charName) {

        //Players chosen character name
        name = charName;

        //Players starting stats
        stats.put(Labels.HP, 400);
        stats.put(Labels.level, 1);
        stats.put(Labels.agility, 100);
        stats.put(Labels.defence, 90);
        stats.put(Labels.evasion, 35);
        stats.put(Labels.hitRate, 255);
        stats.put(Labels.luck, 60);
        stats.put(Labels.magic, 90);
        stats.put(Labels.spirit, 50);
        stats.put(Labels.strength, 110);
    }

    public String getName() {
        return this.name;
    }

    public LinkedHashMap<String, Integer> getStats() {
        return this.stats;
    }

    public LinkedHashMap<Item, Integer> getInventory() {
        return this.inventory;
    }

    public LinkedHashMap<Magic, Integer> getMagic() {
        return this.magic;
    }
}
