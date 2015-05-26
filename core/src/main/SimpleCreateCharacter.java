package main;

import chars.NPC;
import chars.Player;
import entities.*;
import labels.Items;
import labels.Labels;

import java.util.Map;
import java.util.Scanner;

/**
 * Entry point of game
 *
 * @author Martin Cox
 * @since 2015-04-18
 */
public class SimpleCreateCharacter {

    public static Player runGame(String charName) {

        Player player = new Player(charName);

        return player;
    }
}
