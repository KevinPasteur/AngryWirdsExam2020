package ch.cpnv.angrywirds;

import com.badlogic.gdx.Game;

import java.util.Random;
import java.util.Stack;

import ch.cpnv.angrywirds.activities.MenuLanguage;

public class AngryWirds extends Game {

    public static Random alea; // random generator object. Static for app-wide use

    public static Stack<Game> pages;

    @Override
    public void create() {
        alea = new Random();
        pages = new Stack<Game>();
        pages.push(new MenuLanguage());
    }

    @Override
    public void render() {
        pages.peek().render();
    }

}
