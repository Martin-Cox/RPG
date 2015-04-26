package chars;

import java.util.LinkedHashMap;

import entities.Magic;
import labels.Labels;
import entities.Item;

/**
 * The player character instance. It is only initialised once.
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Player extends Character{

     /**
     * Create a new player character instance. Only 1 should be initialised.
     *
     * @param Name The player characters name. Entered by the player.
     */
    public Player(String Name) {

        super(Name, null, null, null, null, null);

        //Players starting stats
        super.stats.put(Labels.HP, 400);
        super.stats.put(Labels.level, 1);
        super.stats.put(Labels.agility, 100);
        super.stats.put(Labels.defence, 90);
        super.stats.put(Labels.evasion, 35);
        super.stats.put(Labels.hitRate, 255);
        super.stats.put(Labels.luck, 60);
        super.stats.put(Labels.magic, 90);
        super.stats.put(Labels.spirit, 50);
        super.stats.put(Labels.strength, 110);
    }
}
