import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Game {

    // class variables
    public static Map<String, Double> characters;

    // public final
    public final static int NUMBER_OF_CHARS = 1;

    // accessor and modifier methods

    // game specific and setup methods
    public void startGame() {

    }

    public static void main(String[] args) {
        setUpGame();
        promptStartGame();
    }

    // setup game method
    public static ArrayList<Fighter> getFighterData() {

        // deserialize
        Fighter tempFighter = null;
        ArrayList<Fighter> characterArray = new ArrayList<Fighter>();

        // get data from file to store in character array
        int n = 0;
        while (n < NUMBER_OF_CHARS) {
            try {
                FileInputStream fileIn = new FileInputStream("pokemon/FighterData.ser");
                // starts object input stream
                ObjectInputStream in = new ObjectInputStream(fileIn);

                // cast to onject
                tempFighter = (Fighter) in.readObject();
                in.close();
                fileIn.close();

            } catch (IOException i) { // catch exceptions
                i.printStackTrace();
                return characterArray;
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
                return characterArray;
            }
            n++;
        }

        // check data in map to ensure correctness

        // return data
        return characterArray;

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
