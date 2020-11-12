package ch.cpnv.angrywirds.activities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.model.Button;

public class MenuLanguage extends Game implements InputProcessor {

    public static final float WORLD_WIDTH = 1600;
    public static final float WORLD_HEIGHT = 900;

    private SpriteBatch batch;
    private Texture background;
    private BitmapFont title,subtitle;
    private Button button;
    private String language1 = "(Choisir)";
    private String language2 = "(Choisir)";
    private Button btnFR,btnEN,btnES;

    private OrthographicCamera camera;

    public MenuLanguage() {

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("background.jpg"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        title= new BitmapFont();
        title.setColor(Color.ROYAL);
        title.getData().setScale(6);

        subtitle= new BitmapFont();
        subtitle.setColor(Color.ROYAL);
        subtitle.getData().setScale(6);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void create() {

    }

    public void update() {
        float dt = Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render() {
        update();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(batch,"AngryWirds",WORLD_WIDTH/2.5f,WORLD_HEIGHT/1.5f + 250);
        subtitle.draw(batch,"Exercice de "+language1 + " en " +language2,WORLD_WIDTH/8,WORLD_HEIGHT/1.5f+150);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        AngryWirds.pages.push(new Play());
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
