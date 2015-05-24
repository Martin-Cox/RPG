package chars;

import labels.Labels;

import java.util.LinkedHashMap;

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

        super(Name, null, null, null);

        LinkedHashMap stats = new LinkedHashMap();

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

        super.baseStats = stats;
        super.modStats = stats;

    }
}
