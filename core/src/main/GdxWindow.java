package main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxWindow extends ApplicationAdapter {
	private BitmapFont font;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);

		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("news.fnt"));
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.setColor(Color.BLUE);
		font.draw(batch, "Hello World! Test custom font :)", 100, 400);
		batch.end();


		if(Gdx.input.isTouched() || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
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

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}

	}

}
