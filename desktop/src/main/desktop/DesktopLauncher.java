package main.desktop;

		import main.RunGame_OLD;
		import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
		import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
		import main.RPGWindow;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "RPG";
		config.width = 1920;
		config.height = 1080;
		config.fullscreen = true;
		config.resizable = false;
		new LwjglApplication(new RPGWindow(), config);

		RunGame_OLD runGame = new RunGame_OLD();
		runGame.runGame();
	}
}
