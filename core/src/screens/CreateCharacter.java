package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import consts.Consts;
import labels.Dialogs;
import main.Camera;

/**
 * Created by Martin on 06/06/2015.
 */
public class CreateCharacter implements Screen{
    private Stage stage = new Stage();

    private Skin skin = new Skin(Gdx.files.internal("skins/Create_Character_Skin.json"),
            new TextureAtlas(Gdx.files.internal("skins/Create_Character_Skin.pack")));

    private TextButton buttonOK = new TextButton(Dialogs.ok, skin),
            buttonCancel  = new TextButton(Dialogs.cancel, skin);

    private TextField charName = new TextField(Dialogs.playerCharacterNameInitialValue, skin);

    private Label enterName = new Label(Dialogs.playerCharacterNameTitle, skin);

    private Table tableLayout = new Table();

    private BitmapFont inputFont;

    private Camera camera = new Camera(Consts.WINDOW_WIDTH, Consts.WINDOW_HEIGHT);

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();

        stage.getBatch().begin();
        stage.getBatch().setProjectionMatrix(camera.combined);
        stage.getBatch().end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().setCamera(new Camera(Consts.WINDOW_WIDTH, Consts.WINDOW_HEIGHT));
        tableLayout.invalidateHierarchy();
        tableLayout.setSize(Consts.WINDOW_WIDTH, Consts.WINDOW_HEIGHT);
    }

    @Override
    public void show() {

        //Button listeners
        createListeners();

        inputFont = new BitmapFont(Gdx.files.internal("fonts/news_black.fnt"), false);

        //Skin for the input field, json doesn't seem to work
        TextField.TextFieldStyle inputFieldStyle = new TextField.TextFieldStyle();
        inputFieldStyle.background = skin.getDrawable("text_input_box");
        inputFieldStyle.font = inputFont;
        inputFieldStyle.fontColor = Color.BLACK;
        charName.setStyle(inputFieldStyle);

        //tableLayout.setDebug(true);
        tableLayout.add(enterName).padBottom(75).row();
        tableLayout.add(charName).size(300,100).padBottom(20).row();
        tableLayout.add(buttonOK).size(300,100).padBottom(20).row();
        tableLayout.add(buttonCancel).size(300,100).padBottom(20).row();

        //tableLayout.setFillParent(true);
        stage.addActor(tableLayout);

        Gdx.input.setInputProcessor(stage);
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
        buttonOK.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Go to debug screen
                Consts.CHAR_NAME = charName.getText();  //Lazy workaround, shouldn't use global variables like this
                ((Game) Gdx.app.getApplicationListener()).setScreen(new DebugScreen());
            }
        });
        buttonCancel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new SplashScreen());
            }
        });
    }

}
