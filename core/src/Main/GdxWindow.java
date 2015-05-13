package Main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxWindow extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("coval.fnt"));
	}

	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);

		batch.begin();
		font.draw(batch, "Hello World! Test custom font :)", 100, 400);
		batch.end();
	}

}
