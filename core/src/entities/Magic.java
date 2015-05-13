package entities;

import labels.Labels;

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
    private StatusEffect statusEffect;

    private double baseDamage;
    private double statusEffectBaseChance;

    private LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();

    /**
     * Create a new magic spell
     *
     * @param Name The name of the spell
     * @param Description The magic spells description
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     * @param StatModifiers A LinkedHashMap of Stat names and Junction modifier values
     * @param Element The element this magic corresponds to
     * @param StatusEffect The object of the status effect this magic may cause
     * @param BaseDamage The base damage this magic does (before being modified by any bonuses/resistances)
     * @param StatusEffectBaseChance The base chance this magic has of causing the status effect
     */
    public Magic(String Name, String Description, boolean CanBeUsedInBattle, boolean CanBeUsedInWorld, LinkedHashMap StatModifiers, String Element, StatusEffect StatusEffect, double BaseDamage, double StatusEffectBaseChance) {
        name = labels.Magic.getLabelValue(Name).toString();
        description = labels.Magic.getLabelValue(Description).toString();
        canBeUsedInBattle = CanBeUsedInBattle;
        canBeUsedInWorld = CanBeUsedInWorld;
        statModifiers = StatModifiers;
        element =  Labels.getLabelValue(Element).toString();
        statusEffect = StatusEffect;   //TODO: Get status effect from a list of status effects
        baseDamage = BaseDamage;
        statusEffectBaseChance = StatusEffectBaseChance;
    }

    /**
     * Returns value of the name property
     *
     * @return String
     */
    public String getName() { return this.name; }
}
