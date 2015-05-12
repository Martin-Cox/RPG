package Main;

import chars.NPC;
import chars.Player;
import entities.*;
import labels.Items;
import labels.Labels;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Entry point of game
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class RunGame_OLD {

    public void runGame() {

        ItemList itemList = Setup.createItems();
        MagicList magicList = Setup.createMagic();
        //TODO: Create a list of status effects here with values taken from DB similar to how Magic and Items lists are created

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your characters name: ");
        System.out.flush();
        String charName = scanner.nextLine();

        Player player = new Player(charName);

        System.out.println("Hello " + player.getName() + ".");

        System.out.println("Your stats are: ");

        for (Map.Entry<String, Integer> entry :  player.getStats().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Stat Name: \"" + key + "\" Value: " + value);
        }

        System.out.println();
        System.out.println("You have nothing in your inventory! Lets give you some basic items");

        LinkedHashMap<Item, Integer> playerInventory = player.getInventory();
        playerInventory.put(itemList.getItemFromListByItemName(Items.itemNameHealthPotion), 3);
        playerInventory.put(itemList.getItemFromListByItemName(Items.itemNameElixir), 5);
        playerInventory.put(itemList.getItemFromListByItemName(Items.itemNameMagicStone), 3);
        playerInventory.put(itemList.getItemFromListByItemName(Items.weaponNameRustyDagger), 1);
        playerInventory.put(itemList.getItemFromListByItemName(Items.weaponNameRustyRevolver), 1);


        System.out.println();
        System.out.println("You have " + player.getInventory().size() + " item/s in your inventory. They are as follows: ");

        for (Map.Entry<Item, Integer> entry :  player.getInventory().entrySet()) {
            String key = entry.getKey().getName();
            Integer value = entry.getValue();
            System.out.println("Item Name: \"" + key + "\" Quantity: " + value);
        }

        System.out.println();
        System.out.println("You don't know any magic! Lets teach you some spells");


        player.updateMagic(magicList.getMagicFromListByMagicName("Fireball"), 8);
        player.updateMagic(magicList.getMagicFromListByMagicName(labels.Magic.magicNameCure), 3);

        System.out.println();
        System.out.println("You have " + player.getMagic().size() + " magic in your inventory. They are as follows: ");

        for (Map.Entry<Magic, Integer> entry :  player.getMagic().entrySet()) {
            String key = entry.getKey().getName();
            Integer value = entry.getValue();
            System.out.println("Magic Name: \"" + key + "\" Quantity: " + value);
        }

        System.out.println();
        System.out.println("Changing the amount of " + magicList.getMagicFromListByMagicName("Tornado").getName() + " in your inventory");

        player.updateMagic(magicList.getMagicFromListByMagicName(labels.Magic.magicNameTornado), -3);


        System.out.println("Equipping " + itemList.getItemFromListByItemName(Items.weaponNameRustyDagger).getName() + " in your right hand");
        player.equipWeapon(Labels.rightHand, (Weapon) itemList.getItemFromListByItemName(Items.weaponNameRustyDagger));


        System.out.println();
        System.out.println("-------------------MAKING NPC's-------------------");

        NPC NPC_1 = new NPC();
        System.out.println("NPC is: " + NPC_1.getName());

        NPC NPC_2 = new NPC();
        System.out.println("NPC is: " + NPC_2.getName());

        NPC NPC_3 = new NPC();
        System.out.println("NPC is: " + NPC_3.getName());

        NPC NPC_4 = new NPC();
        System.out.println("NPC is: " + NPC_4.getName());

        NPC NPC_5 = new NPC();
        System.out.println("NPC is: " + NPC_5.getName());

        NPC NPC_6 = new NPC();
        System.out.println("NPC is: " + NPC_6.getName());

        NPC NPC_7 = new NPC();
        System.out.println("NPC is: " + NPC_7.getName());

        NPC NPC_8 = new NPC();
        System.out.println("NPC is: " + NPC_8.getName());

        NPC NPC_9 = new NPC();
        System.out.println("NPC is: " + NPC_9.getName());

        NPC NPC_10 = new NPC();
        System.out.println("NPC is: " + NPC_10.getName());

    }
}
