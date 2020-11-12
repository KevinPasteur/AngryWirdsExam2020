package ch.cpnv.angrywirds.model.Data;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;

/**
 * Created by Xavier on 07.06.18.
 */

public class Vocabulary {
    String vocName;
    ArrayList<SemanticWord> words;

    public Vocabulary(String vocName){
        this.vocName = vocName;
        this.words = new ArrayList<SemanticWord>();
    }

    public void addWord(SemanticWord semword) {
        words.add(semword);
    }

    public SemanticWord pickAWord() {
        return words.get(AngryWirds.alea.nextInt(words.size()));
    } // TODO pick a non-allocated word
}
