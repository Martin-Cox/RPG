package entities;

import java.util.LinkedHashMap;

/**
 * Created by Martin on 25/04/2015.
 */
public class Weapon extends Item {

    Double baseDamage;
    Double durability;

    private LinkedHashMap<String, Double> statModifiers = new LinkedHashMap();

    Boolean dualHanded;

    public Weapon (String Name, String Description, Boolean CanBeUsedInBattle, Boolean CanBeUsedInWorld, Double BaseDamage, Double Durability, LinkedHashMap StatModifiers, Boolean DualHanded) {
        super(Name, Description, CanBeUsedInBattle, CanBeUsedInWorld);
        this.baseDamage = BaseDamage;
        this.durability = Durability;
        this.statModifiers = StatModifiers;
        this.dualHanded = DualHanded;
    }

    public Boolean getDualHanded() {
        return this.dualHanded;
    }

}
