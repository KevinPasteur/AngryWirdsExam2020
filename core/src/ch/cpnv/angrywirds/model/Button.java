package ch.cpnv.angrywirds.model;

import com.badlogic.gdx.math.Vector2;

public class Button extends TextualObject {
    private String value;


    public Button(Vector2 point, String value){
        super(new Vector2(point.x,point.y),50,50,"",value);

    }

    public String getValue(){
        return this.value;
    }

    public Boolean isTouched(Vector2 point){
        return true;
    }

}
