package entities;

/**
 * Created by Martin on 30/04/2015.
 */
public class Consumable extends Item {

    double baseDamage;
    String statusEffect;

    /**
     * Crates a new instance of a consumable item.
     *
     * @param Name The name of the weapon
     * @param Description The description of the weapon
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     * @param BaseDamage Base damage of the weapon before any modifiers
     * @param StatusEffect The status effect this item applies (if any)
     */
    public Consumable (String Name, String Description, Boolean CanBeUsedInBattle, Boolean CanBeUsedInWorld, Double BaseDamage, String StatusEffect) {
        super(Name, Description, CanBeUsedInBattle, CanBeUsedInWorld);
        this.baseDamage = BaseDamage;
        this.statusEffect = labels.Labels.getLabelValue(StatusEffect).toString();
    }

}
