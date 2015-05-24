package main;

import com.badlogic.gdx.Gdx;
import labels.Dialogs;

/**
 * Created by Martin on 26/04/2015.
 */
public class RunGame_DialogTest {

    public void RunGame() {

        String playerName = "";

        SimpleTextInputListener listener = new SimpleTextInputListener();
        Gdx.input.getTextInput(listener, Dialogs.playerCharacterNameTitle, Dialogs.playerCharacterNameInitialValue, "");

    }

}
