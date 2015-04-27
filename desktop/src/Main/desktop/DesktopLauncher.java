package Main.desktop;

import Main.RunGame_DialogTest;
import Main.RunGame_OLD;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import Main.GdxWindow;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GdxWindow(), config);

		RunGame_OLD runGame = new RunGame_OLD();
		runGame.runGame();
	}
}
