package main;

import chars.*;
import db.DB;
import entities.Item;
import entities.Magic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Entry point of game
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class Main {

    public static void main(String[] args) {

        ArrayList items = Setup.createItemsBasic();
        ArrayList magic = Setup.createMagic();

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
        playerInventory.put((Item) items.get(0), 3);
        playerInventory.put((Item) items.get(1), 2);
        playerInventory.put((Item) items.get(2), 6);
        playerInventory.put((Item) items.get(3), 1);
        playerInventory.put((Item) items.get(4), 40);

        System.out.println();
        System.out.println("You have " + player.getInventory().size() + " item/s in your inventory. They are as follows: ");

        for (Map.Entry<Item, Integer> entry :  player.getInventory().entrySet()) {
            String key = entry.getKey().getName();
            Integer value = entry.getValue();
            System.out.println("Item Name: \"" + key + "\" Quantity: " + value);
        }

        System.out.println();
        System.out.println("You don't know any magic! Lets teach you some spells");

        player.updateMagic((Magic) magic.get(0), 8);
        player.updateMagic((Magic) magic.get(2), 3);

        System.out.println();
        System.out.println("You have " + player.getMagic().size() + " magic in your inventory. They are as follows: ");

        for (Map.Entry<Magic, Integer> entry :  player.getMagic().entrySet()) {
            String key = entry.getKey().getName();
            Integer value = entry.getValue();
            System.out.println("Magic Name: \"" + key + "\" Quantity: " + value);
        }

        System.out.println();
        System.out.println("Changing the amount of " + ((Magic) magic.get(1)).getName() + " in your inventory");

        player.updateMagic((Magic) magic.get(1), -3);


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

    }
}
