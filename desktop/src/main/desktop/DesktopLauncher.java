package main.desktop;

import main.RunGame_OLD;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.RPGWindow;
import consts.Consts;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Consts.WINDOW_TITLE;
		config.width = Consts.WINDOW_WIDTH;
		config.height = Consts.WINDOW_HEIGHT;
		config.fullscreen = true;
		config.resizable = false;
		new LwjglApplication(new RPGWindow(), config);

		RunGame_OLD runGame = new RunGame_OLD();
		runGame.runGame();
	}
}
