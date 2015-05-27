package main;

import chars.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import labels.Dialogs;

import java.util.Map;

public class RPGWindow extends ApplicationAdapter implements Input.TextInputListener {
	private BitmapFont font;

	private OrthographicCamera camera;
	private SpriteBatch batch;
	boolean firstTouch = true;
	Player player = null;
	int frameRenderCount = 0;

	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);

		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("news.fnt"));

		//TODO: May not be needed depending on final game structure
		Gdx.graphics.setContinuousRendering(false);
		Gdx.graphics.requestRendering();
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		frameRenderCount++;

		batch.begin();
		batch.setColor(Color.BLUE);
		font.draw(batch, "Hello World! Test custom font :)", 100, 400);
		font.draw(batch, "Frame render count: " + frameRenderCount, 10, 1070);
		batch.end();

		if(Gdx.input.isTouched() || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			if (firstTouch == true) {
				Gdx.input.getTextInput(this, Dialogs.playerCharacterNameTitle, Dialogs.playerCharacterNameInitialValue, "");
				firstTouch = false;
			}
			double xPos = Gdx.input.getX();
			double yPos = Gdx.input.getY();
			batch.begin();
			//font.dispose();
			String message = "You are pressing left mouse/touching the screen at X:" + xPos + " Y:" + yPos;
			font.draw(batch, message, 100, 800);
			batch.end();
		} else {
			batch.begin();
			font.draw(batch, "Click the left mouse button/Touch the screen", 100, 800);
			batch.end();
		}

		//Draw player character details (if it exists)
		if (player != null) {
			batch.begin();
			font.draw(batch, "Player name: " + player.getName(), 1200, 800);
			batch.end();
			int heightPosition = 200;
			for (Map.Entry<String, Integer> entry :  player.getBaseStats().entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				batch.begin();
				font.draw(batch, "Stat " + entry.getKey() + ": " + entry.getValue(), 1200, heightPosition);
				batch.end();
				heightPosition += 35;
			}
		}

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	public void input(String name) {
		this.player = SimpleCreateCharacter.runGame(name);
	}

	public void canceled() {
	}

}
