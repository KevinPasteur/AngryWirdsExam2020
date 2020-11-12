package ch.cpnv.angrywirds.model.Data;

public class Language {
    private String displayName;
    private String ISO_639_1;

    public Language(String ISO, String name)
    {
        this.displayName = name;
        this.ISO_639_1 = ISO;
    }

    public String getDisplayName(){
        return this.displayName;
    }

    public String getISO_639_1(){
        return this.ISO_639_1;
    }
}
