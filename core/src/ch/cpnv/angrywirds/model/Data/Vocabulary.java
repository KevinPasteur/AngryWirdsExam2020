package ch.cpnv.angrywirds.model.Data;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;

/**
 * Created by Xavier on 07.06.18.
 */

public class Vocabulary {
    private String vocName;
    private ArrayList<SemanticWord> words;

    public Vocabulary(String vocName){
        this.vocName = vocName;
        this.words = new ArrayList<SemanticWord>();
    }

    public void addSemanticWord(SemanticWord semword) {
        words.add(semword);
    }

    public SemanticWord pickAWord() {
        return words.get(AngryWirds.alea.nextInt(words.size()));
    } // TODO pick a non-allocated word
}
