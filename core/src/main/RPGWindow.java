package main;

import com.badlogic.gdx.Game;
import screens.SplashScreen;


public class RPGWindow extends Game {

	@Override
	public void create() {
		setScreen(new SplashScreen());
	}
}