import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Game {

    // class variables
    public static Map<String, Double> characters;

    // accessor and modifier methods

    // game specific and setup methods
    public void startGame() {

    }

    public static void main(String[] args) {
        setUpGame();
        promptStartGame();
    }

    // setup game method
    public static void setUpGame() {

        // declare files

        // get data from file to store in character array

        // check data in map to ensure correctness

    }

    public static void promptStartGame() {

        Scanner sc = new Scanner(System.in); // can change this later to be compatible with graphs
        System.out.println("What is you name?");

        String userName = sc.next();

        System.out.println("Welome " + userName + "!");

        // display character list
        System.out.println("Which character would you like to choose?(Enter Number!)");

        for (int i = 1; i <= characters.size(); i++) {
            System.out.println("Character " + i + " : " + characters.get(i - 1));
        }

    }

    // data for game methods

    public void getDataFromFile(File file) {

    }

}
