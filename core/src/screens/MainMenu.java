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
 * Created by Martin on 05/06/2015.
 */
public class MainMenu implements Screen{
    private Stage stage = new Stage();

    private Skin skin = new Skin(Gdx.files.internal("skins/Main_Menu_Skin.json"),
            new TextureAtlas(Gdx.files.internal("skins/Main_Menu_Skin.pack")));

    private TextButton buttonNew  = new TextButton(Dialogs.mainMenuNewGame, skin, "menu_button"),
            buttonLoad  = new TextButton(Dialogs.mainMenuLoadGame, skin, "menu_button"),
            buttonExit = new TextButton(Dialogs.mainMenuExit, skin, "menu_button");

    private Label title = new Label(Dialogs.mainMenuTitle, skin, "title");

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

        //Add Title and Buttons to tableLayout
        //tableLayout.setDebug(true);
        tableLayout.add(title).padBottom(75).row();
        tableLayout.add(buttonNew).size(300, 100).padBottom(20).row();
        tableLayout.add(buttonLoad).size(300,100).padBottom(20).row();
        tableLayout.add(buttonExit).size(300,100).padBottom(20).row();

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
        buttonNew.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new CreateCharacter());
            }
        });

        buttonLoad.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Gdx.app.exit();
                //Display not functioning yet message here
            }
        });

        buttonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

}
