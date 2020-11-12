package ch.cpnv.angrywirds.model.Data;
import com.badlogic.gdx.Gdx;

import java.util.HashMap;

import javax.swing.DefaultListSelectionModel;

import ch.cpnv.angrywirds.model.ObjectOutOfBoundsException;
import ch.cpnv.angrywirds.model.TranslationDoesNotExistsException;
import ch.cpnv.angrywirds.model.TranslationExistsException;

public class SemanticWord {
    private HashMap<String,String> values = new HashMap<String, String>();

    public void addTranslation(String language, String value) {
            this.values.put(language,value);
    }

    public String getValue(String language) {
        try{
            if(true)throw new TranslationExistsException(language);
            else throw new TranslationDoesNotExistsException(language);

        } catch (TranslationExistsException e) {
            return this.values.get(e.getMessage());
        }
        catch (TranslationDoesNotExistsException e) {
            Gdx.app.log("ANGRY", "Cette traduction n'existe pas : " + e.getMessage());
        }

        return null;
    }
}
