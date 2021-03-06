package screens;

/**
 * Created by Martin on 05/06/2015.
 */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import consts.Consts;
import main.Camera;

public class SplashScreen implements Screen {

    private Texture texture = new Texture(Gdx.files.internal("Splash_Test_Image.png"));
    private Image splashImage = new Image(texture);
    private Stage stage = new Stage();
    private Table tableLayout = new Table();

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
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

        //tableLayout.setDebug(true);
        //tableLayout.setFillParent(true);
        stage.addActor(tableLayout);

        tableLayout.add(splashImage);

        splashImage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(0.5f), Actions.delay(2), Actions.fadeOut(0.5f), Actions.run(new Runnable() {
            @Override
            public void run() {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
            }
        })));

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
        texture.dispose();
        stage.dispose();
    }
}