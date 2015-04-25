package entities;

import java.util.LinkedHashMap;

/**
 * Ranged weapon type. All ranged  weapons will be this type.
 */
public class RangedWeapon extends Weapon {

    Item ammo;

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
     * @param Ammo The Item that this weapon uses as ammo
     */
    public RangedWeapon (String Name, String Description, Boolean CanBeUsedInBattle, Boolean CanBeUsedInWorld, Double BaseDamage, Double Durability, LinkedHashMap StatModifiers, Boolean DualHanded, Item Ammo) {
        super (Name, Description, CanBeUsedInBattle, CanBeUsedInWorld, BaseDamage, Durability, StatModifiers, DualHanded);
        this.ammo = Ammo;
    }

    /**
     * Returns the value of the ammo property
     *
     * @return Item
     */
    public Item getAmmo() { return this.ammo; }

}
