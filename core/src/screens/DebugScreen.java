package screens;

import chars.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import consts.Consts;
import labels.Dialogs;
import main.SimpleCreateCharacter;

import java.util.Map;

/**
 * Created by Martin on 05/06/2015.
 */
public class DebugScreen implements Screen{
    private Stage stage = new Stage();

    private int xPos;
    private int yPos;
    private int frameCount = 0;
    private BitmapFont font;
    private Texture charImage;
    private Rectangle charIcon;
    private boolean touchSprite = false;
    Vector3 touchPos = new Vector3();

    private SpriteBatch batch;

    private Skin skin = new Skin(Gdx.files.internal("skins/Main_Menu_Skin.json"),
            new TextureAtlas(Gdx.files.internal("skins/Main_Menu_Skin.pack")));

    private TextButton buttonExit = new TextButton(Dialogs.mainMenuExit, skin, "menu_button");

    private Label title = new Label(Dialogs.mainMenuTitle + " Debug", skin, "title");
    private Label mousePos = new Label("", skin, "other");
    private Label frameCountLabel = new Label("", skin, "other");

    private Table tableLayout = new Table();

    private Player player;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

        frameCount++;
        frameCountLabel.setText("Frame count: " + frameCount);
        stage.addActor(frameCountLabel);

        if(Gdx.input.isTouched() || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            xPos = Gdx.input.getX();
            yPos = Gdx.input.getY();
        } else {
            xPos = 0;
            yPos = 0;
        }

        mousePos.setText("Position X: " + xPos + " Y: " + yPos);
        stage.addActor(mousePos);

        batch.begin();
        batch.draw(charImage, charIcon.x, charIcon.y);
        batch.end();

        //Display character stats
        int heightPosition = 200;
        for (Map.Entry<String, Integer> entry :  player.getBaseStats().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            batch.begin();
            font.draw(batch, "Stat " + entry.getKey() + ": " + entry.getValue(), 100, heightPosition);
            batch.end();
            heightPosition += 35;
        }
        batch.begin();
        font.draw(batch, "Player name: " + player.getName(), 100, heightPosition);
        batch.end();

        Gdx.input.setInputProcessor(stage);

        //Click and drag character sprite
        if(Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (touchPos.x > charIcon.getX() && touchPos.x < (charIcon.getX() + charIcon.getWidth())) {
                if (touchPos.y > (Consts.WINDOW_HEIGHT - (charIcon.getY() + charIcon.getHeight())) && touchPos.y < (Consts.WINDOW_HEIGHT - charIcon.getY())) {
                    touchSprite = true;
                }
            }
            if (touchSprite == true) {
                charIcon.x = touchPos.x - 225 / 2;
                charIcon.y = Consts.WINDOW_HEIGHT - touchPos.y - 225 / 2;
            }
        } else {
            if (touchSprite == true) {
                touchSprite = false;
            }
        }

        //Char icon position
        batch.begin();
        font.draw(batch, "Char X position:" + charIcon.getX() + " to " + (charIcon.getX() + charIcon.getWidth()), 10, 990);
        font.draw(batch, "Char Y position:" + (Consts.WINDOW_HEIGHT - (charIcon.getY() + charIcon.getHeight()) + " to " + (Consts.WINDOW_HEIGHT - charIcon.getY())), 10, 960);
        font.draw(batch, "Touch sprite: " + touchSprite, 10, 930);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

        //Button listeners
        createListeners();

        //Create Character
        player = SimpleCreateCharacter.runGame(Consts.CHAR_NAME);

        //Add Title and Buttons to tableLayout
        //tableLayout.setDebug(true);
        tableLayout.add(title).padBottom(75).row();
        tableLayout.add(buttonExit).size(300, 100).padBottom(20).row();

        tableLayout.setFillParent(true);
        stage.addActor(tableLayout);

        frameCountLabel.setPosition(10, 1050);
        mousePos.setPosition(10, 1020);

        batch = new SpriteBatch();

        charImage = new Texture(Gdx.files.internal("Character.png"));

        charIcon = new Rectangle();
        charIcon.x = 600;
        charIcon.y = 100;
        charIcon.width = 225;
        charIcon.height = 225;

        font = new BitmapFont(Gdx.files.internal("fonts/news.fnt"));

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public void createListeners() {
        buttonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

}
