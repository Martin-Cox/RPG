package entities;

import labels.Labels;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Status effects are only applied in battle. At the start of a characters turn (when they have selected an action) the status effect
 * base damage is applied modified by if the characters weakness to the element. If the damage is a minus number, then it will actually
 * heal the character. The base chance to cause the status effect comes from the magic spell or item itself. Once applied, it will
 * ALWAYS trigger unless removed or runs out of turns.
 *
 * Created by Martin on 12/05/2015.
 */
public class StatusEffect {

    private String name;
    private String description;
    private String element;

    private double baseDamage;

    private int numberOfTurns;

    private LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();

    //TODO: Implement randomiseNumberOfTurns method that should gen a random number each time the status effect is applied should be influenced by attacking creatures MAGIC (only if applied by a magic spell) AND LUCK stats as well as defending creatures SPIRIT


    /**
     * Create a new status effect
     *
     * @param Name The name of the status effect
     * @param Description The status effect's description
     * @param Element The element this status effect corresponds to
     * @param BaseDamage The base damage this status effect does (before being modified by any bonuses/resistances)
     * @param StatModifiers A LinkedHashMap of Stat names and Junction modifier values
     * @param NumberOfTurns The number of turns/actions to apply this status effect for
     */
    public StatusEffect(String Name, String Description, String Element, double BaseDamage, LinkedHashMap StatModifiers, int NumberOfTurns) {
        name = labels.Status.getLabelValue(Name).toString();
        description = labels.Status.getLabelValue(Description).toString();
        if (Element.equalsIgnoreCase("")) {
            element = Labels.elementNone;
        } else {
            element = Labels.getLabelValue(Element).toString();
        }
        baseDamage = BaseDamage;
        statModifiers = StatModifiers;
        numberOfTurns = NumberOfTurns;
    }

    /**
     * Returns value of the name property
     *
     * @return String
     */
    public String getName() { return this.name; }
}

