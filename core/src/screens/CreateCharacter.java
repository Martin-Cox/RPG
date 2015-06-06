package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import labels.Dialogs;

/**
 * Created by Martin on 06/06/2015.
 */
public class CreateCharacter implements Screen{
    private Stage stage = new Stage();

    private Skin skin = new Skin(Gdx.files.internal("skins/Create_Character_Skin.json"),
            new TextureAtlas(Gdx.files.internal("skins/Create_Character_Skin.pack")));

    private TextButton buttonOK = new TextButton(Dialogs.mainMenuNewGame, skin),
            buttonCancel  = new TextButton(Dialogs.mainMenuLoadGame, skin);

    private Label enterName = new Label(Dialogs.playerCharacterNameTitle, skin);

    private Table tableLayout = new Table();

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

        //Button listeners
        createListeners();

        tableLayout.setFillParent(true);
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
                ((Game)Gdx.app.getApplicationListener()).setScreen(new SplashScreen());
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
