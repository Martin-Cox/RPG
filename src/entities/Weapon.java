package entities;

import java.util.LinkedHashMap;

/**
 * Instance of a standard weapon
 *
 * @author Martin Cox
 * @since 2015-04-25
 */
public class Weapon extends Item {

    Double baseDamage;
    Double durability;

    private LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();

    Boolean dualHanded;

    /**
     * Crates a new instance of a weapon.
     *
     * @param Name The name of the weapon
     * @param Description The description of the weapon
     * @param CanBeUsedInBattle If true the item can be used in battle
     * @param CanBeUsedInWorld If true the item can be used in the world
     * @param BaseDamage Base damage of the weapon before any modifiers
     * @param Durability The durability of the weapon
     * @param StatModifiers Any modifiers this weapon applies to the character equipping it's stats.
     * @param DualHanded If true then the weapon has to be used with both hands
     */
    public Weapon (String Name, String Description, Boolean CanBeUsedInBattle, Boolean CanBeUsedInWorld, Double BaseDamage, Double Durability, LinkedHashMap StatModifiers, Boolean DualHanded) {
        super(Name, Description, CanBeUsedInBattle, CanBeUsedInWorld);
        this.baseDamage = BaseDamage;
        this.durability = Durability;
        this.statModifiers = StatModifiers;
        this.dualHanded = DualHanded;
    }

    /**
     * Returns the value of the dualHanded property
     *
     * @return Boolean
     */
    public Boolean getDualHanded() { return this.dualHanded; }

}
