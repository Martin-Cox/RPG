package entities;

import main.Labels;

import java.util.LinkedHashMap;

/**
 * Instance of a magic spell
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Magic {

    private String name;
    private String description;

    private boolean canBeUsedInBattle;      //Can the item be used in battle
    private boolean canBeUsedInWorld;       //Can the item be used in the world

    private String element;
    private String statusEffectName;

    private double baseDamage;
    private double statusEffectBaseChance;

    private LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();

    /**
     * Create a new magic spell
     *
     * @param Name The name of the spell
     * @param Description The magic spell's description
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     * @param StatModifiers A LinkedHashMap of Stat names and Junction modifier values
     * @param Element The element this magic corresponds to
     * @param StatusEffectName The name (if any) of the status effect this magic may cause
     * @param BaseDamage The base damage this magic does (before being modified by any bonuses/resistances)
     * @param StatusEffectBaseChance The base chance this magic has of causing the status effect
     */
    public Magic(String Name, String Description, boolean CanBeUsedInBattle, boolean CanBeUsedInWorld, LinkedHashMap StatModifiers, String Element, String StatusEffectName, double BaseDamage, double StatusEffectBaseChance) {
        name = Labels.getLabelValue(Name).toString();
        description = Labels.getLabelValue(Description).toString();
        canBeUsedInBattle = CanBeUsedInBattle;
        canBeUsedInWorld = CanBeUsedInWorld;
        statModifiers = StatModifiers;
        element =  Labels.getLabelValue(Element).toString();
        statusEffectName = Labels.getLabelValue(StatusEffectName).toString();
        baseDamage = BaseDamage;
        statusEffectBaseChance = StatusEffectBaseChance;
    }

    public String getName() {
        return this.name;
    }
}
