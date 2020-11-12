package ch.cpnv.angrywirds.model.Data;
import java.util.HashMap;

public class SemanticWord {
    private HashMap<String,String> values = new HashMap<String, String>();

    public void addTranslation(String language, String value) {
        this.values.put("language","value");
    }

    public String getValue(String language) {
        return this.values.get("language");
    }
}
