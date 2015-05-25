package main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxWindow extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font;
	private BitmapFont font2;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("coval.fnt"));
		font2 = new BitmapFont(Gdx.files.internal("coval.fnt"));
	}

	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);

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
