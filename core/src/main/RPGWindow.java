package main;

import com.badlogic.gdx.Game;
import screens.SplashScreen;


public class RPGWindow extends Game {

	@Override
	public void create() {
		setScreen(new SplashScreen());
	}
}


	//LEGACY - WILL FORM DEBUG SCREEN AFTER CLICK "NEW GAME" ON  MAIN MENU
	/*private BitmapFont font;


	private SpriteBatch batch;
	Player player = null;
	int frameRenderCount = 0;

	private Texture charImage;
	private Rectangle charIcon;
	private boolean touchSprite = false;

	public void create() {


		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("news.fnt"));

		charImage = new Texture(Gdx.files.internal("Character.png"));

		charIcon = new Rectangle();
		charIcon.x = 600;
		charIcon.y = 100;
		charIcon.width = 225;
		charIcon.height = 225;

		//TODO: May not be needed depending on final game structure
		Gdx.graphics.setContinuousRendering(false);
		Gdx.graphics.requestRendering();
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update(); //Should do this once per frame

		frameRenderCount++;

		batch.begin();
		batch.draw(charImage, charIcon.x, charIcon.y);
		font.draw(batch, "Hello World! Test custom font :)", 100, 400);
		font.draw(batch, "Frame render count: " + frameRenderCount, 10, 1070);
		font.draw(batch, "Char icon x: " + charIcon.getX(), 10, 1040);
		font.draw(batch, "Char icon y: " + charIcon.getY(), 10, 1010);
		font.draw(batch, "CLICK/TOUCH CHARACTER ICON TO START!", 10, 970);
		batch.end();

		if(Gdx.input.isTouched() || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			double xPos = Gdx.input.getX();
			double yPos = Gdx.input.getY();
			batch.begin();
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

		//Click and drag character sprite
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();	//TODO: Really shouldn't do this, every time the frame re-renders we create a new object, meaning garbage collector has to kick in frequently
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if (touchPos.x > charIcon.getX() && touchPos.x < charIcon.getX() + charIcon.getWidth()) {
				if (touchPos.y > charIcon.getY() && touchPos.y < charIcon.getY() + charIcon.getHeight()) {
					touchSprite = true;
				}
			}
			if (touchSprite == true) {
				//clicked on sprite
				if (player == null) {
					Gdx.input.getTextInput(this, Dialogs.playerCharacterNameTitle, Dialogs.playerCharacterNameInitialValue, "");
				}
				charIcon.x = touchPos.x - 225 / 2;
				charIcon.y = touchPos.y - 225 / 2;
			}
		} else {
			if (touchSprite == true) {
				touchSprite = false;
			}
		}
		//Close program by pressing Esc key
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	public void input(String name) {
		this.player = SimpleCreateCharacter.runGame(name);
	}

	public void canceled() {
	}*/
