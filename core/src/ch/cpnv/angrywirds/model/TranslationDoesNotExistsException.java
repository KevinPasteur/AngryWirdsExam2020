package ch.cpnv.angrywirds.model;

public class TranslationDoesNotExistsException extends Exception {
    public TranslationDoesNotExistsException(String msg) {
        super(msg);
    }
}
