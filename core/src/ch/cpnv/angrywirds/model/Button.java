package ch.cpnv.angrywirds.model;

import com.badlogic.gdx.math.Vector2;

public class Button extends TextualObject {
    private String value;
    public static final int WIDTH = 300/2;
    public static final int HEIGHT = 298 / 3;
    private static final String SPRITE_NAME = "rubber.png";

    public Button(Vector2 point, String value){
        super(new Vector2(point.x,point.y),WIDTH,HEIGHT,SPRITE_NAME,value);

    }

    public String getValue(){
        return this.value;
    }

    public Boolean isTouched(Vector2 point){
        return true;
    }

}
