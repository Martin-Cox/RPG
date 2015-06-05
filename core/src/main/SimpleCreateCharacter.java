package main;

import chars.Player;

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
