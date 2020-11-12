package ch.cpnv.angrywirds.activities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.model.Button;

public class MenuLanguage extends Game implements InputProcessor {

    public static final float WORLD_WIDTH = 1600;
    public static final float WORLD_HEIGHT = 900;

    private SpriteBatch batch;
    private Texture background;
    private BitmapFont title,subtitle;
    private String language1 = "(Choisir)";
    private String language2 = "(Choisir)";
    private Boolean selected1 = false, selected2 =false;
    private Button btnFR1,btnEN1,btnES1,btnGO;
    private Button btnFR2,btnEN2,btnES2;
    private BitmapFont lbtnFR,lbtnEN,lbtnES,lbtnGo;

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

        lbtnEN = lbtnES = lbtnFR = lbtnGo = new BitmapFont();
        lbtnEN.setColor(Color.ROYAL);
        lbtnES.setColor(Color.ROYAL);
        lbtnFR.setColor(Color.ROYAL);
        lbtnEN.getData().setScale(2);
        lbtnES.getData().setScale(2);
        lbtnFR.getData().setScale(2);

        lbtnGo.setColor(Color.ROYAL);
        lbtnGo.getData().setScale(2);
        btnGO = new Button(new Vector2(WORLD_WIDTH/7,(WORLD_HEIGHT/2+150)),"GO");

        btnEN1 = new Button(new Vector2(WORLD_WIDTH/4,WORLD_HEIGHT/2+100),"en");
        btnFR1 = new Button(new Vector2(WORLD_WIDTH/4,WORLD_HEIGHT/2-50),"fr");
        btnES1 = new Button(new Vector2(WORLD_WIDTH/4,WORLD_HEIGHT/2-200),"es");

        btnEN2 = new Button(new Vector2(WORLD_WIDTH/2,WORLD_HEIGHT/2+100),"en");
        btnFR2 = new Button(new Vector2(WORLD_WIDTH/2,WORLD_HEIGHT/2-50),"fr");
        btnES2 = new Button(new Vector2(WORLD_WIDTH/2,WORLD_HEIGHT/2-200),"es");

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void create() {

    }

    public void update()
    {

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

        btnEN1.draw(batch);
        btnFR1.draw(batch);
        btnES1.draw(batch);

        btnEN2.draw(batch);
        btnFR2.draw(batch);
        btnES2.draw(batch);

        if(selected1&&selected2)
        {
            btnGO.draw(batch);
            lbtnEN.draw(batch, "GO",WORLD_WIDTH/7,(WORLD_HEIGHT/2+150));
        }

        lbtnEN.draw(batch, "Anglais",WORLD_WIDTH/2+25,WORLD_HEIGHT/2-150);
        lbtnEN.draw(batch, "Anglais",WORLD_WIDTH/4+25,WORLD_HEIGHT/2-150);

        lbtnES.draw(batch, "Espagnol",WORLD_WIDTH/2+25,WORLD_HEIGHT/2+150);
        lbtnES.draw(batch, "Espagnol",WORLD_WIDTH/4+25,WORLD_HEIGHT/2+150);

        lbtnFR.draw(batch, "Français",WORLD_WIDTH/2+25,WORLD_HEIGHT/2);
        lbtnFR.draw(batch, "Français",WORLD_WIDTH/4+25,WORLD_HEIGHT/2);

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
        if(btnEN1.isTouched(new Vector2(screenX,screenY)))
        {
            language1 = "Anglais";
            selected1 = true;
        }
        if(btnES1.isTouched(new Vector2(screenX,screenY)))
        {
            language1 = "Espagnol";
            selected1 = true;
        }
        if(btnFR1.isTouched(new Vector2(screenX,screenY)))
        {
            language1 = "Français";
            selected1 = true;
        }

        if(btnEN2.isTouched(new Vector2(screenX,screenY))){
            language2 = "Anglais";
            selected2 = true;
        }
        if(btnES2.isTouched(new Vector2(screenX,screenY))){
            language2 = "Espagnol";
            selected2 = true;
        }
        if(btnFR2.isTouched(new Vector2(screenX,screenY))){
            language2 = "Français";
            selected2 = true;
        }

        if(btnGO.isTouched(new Vector2(screenX,screenY)))
        {
            Gdx.app.log("ANGRY", "Test du nouveau voc ");
            AngryWirds.pages.push(new Play(language1,language2));
        }
        //AngryWirds.pages.push(new Play());


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
