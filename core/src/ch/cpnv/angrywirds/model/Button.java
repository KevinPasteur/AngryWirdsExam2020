package ch.cpnv.angrywirds.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.awt.HeadlessException;

public final class Button extends TextualObject {
    private String value;
    public static final int WIDTH = 300/2;
    public static final int HEIGHT = 298/3;
    private static final String SPRITE_NAME = "rubber.png";

    public Button(Vector2 point, String value){
        super(new Vector2(point.x,point.y),WIDTH,HEIGHT,SPRITE_NAME,value);
        this.value = value;
    }

    public void draw(Batch batch) {
        super.draw(batch);
    }


    public String getValue(){
        return this.value;
    }

    public Boolean isTouched(Vector2 point){
        return this.getBoundingRectangle().contains(new Vector2(point.x-WIDTH, point.y-HEIGHT));
    }

}
