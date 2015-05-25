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
	private BitmapFont font2;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("coval.fnt"));
		font2 = new BitmapFont(Gdx.files.internal("coval.fnt"));
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.setColor(Color.BLUE);
		font.draw(batch, "Hello World! Test custom font :)", 100, 400);
		batch.end();


		if(Gdx.input.isTouched() || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			batch.begin();
			font.dispose();
			font2.draw(batch, "You are pressing left mouse/touching the screen", 100, 400);
			batch.end();
		}
	}

}
