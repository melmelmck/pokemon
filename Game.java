import java.util.*;

import java.io.*;

public class Game {

    // class variables
    public Map<Double, Fighter> characters;

    // public final
    public final static int NUMBER_OF_CHARS = 8;

    // accessor and modifier methods

    // game specific and setup methods
    public void startGame() {
        getFighterData();
        getMoveData();

        System.out.println("Game Loaded!");
        promptStartGame();

        System.out.println("Thanks for playing!");

    }

    public static void main(String[] args) {

        Game g = new Game();
        g.startGame();

    }

    // setup game method

    public void promptStartGame() {

        Scanner sc = new Scanner(System.in); // can change this later to be compatible with graphs
        System.out.println("What is you name?");

        String userName = sc.next();

        System.out.println("Welome " + userName + "!");

        // display character list
        System.out.println("Which character would you like to choose?(Enter Number!)");

        for (int i = 1; i <= NUMBER_OF_CHARS; i++) {
            System.out.println("Character " + i + " : " + characters.get(i - 1.0).getName());
        }

        int characterChoice = Integer.parseInt(sc.next());

        System.out.println("You have chosen: " + characters.get(characterChoice - 1.0).getName() + "!");

        User user = new User(userName, characters.get(characterChoice - 1.0));

        boolean userPlaying = true; // while user plays game

        while (userPlaying) {
            System.out.println("Would you like to fight a round?");
            String response = sc.next();

            if (response.equals("yes")) {
                boolean gameResult = playRound(); // true for wine, false for loss

                if (gameResult) {
                    user.wonRound();
                } else {
                    System.out.println("Better Luck Next time!");
                }

                user.playedRound();
            } else {
                System.out.println("Well done! Here are your stats");
                userPlaying = false;
                return;
            }

        }
    }

    public boolean playRound() {

        boolean won = false; // true or false if won or not

        return won;

    }

    // data for game methods

    public ArrayList<Fighter> getFighterData() {

        ArrayList<Fighter> characterArray = new ArrayList<Fighter>();

        File fighterData = new File("/Users/laasya/repos/GitHub/pokemon/FighterData.txt");

        try {
            Scanner sc = new Scanner(fighterData);
            // testing System.out.println(sc.nextLine());

            String tempName;
            String tempStrength;
            String tempSpeed;
            String tempStamina;
            String tempFlying;
            String tempTech;
            String tempCombat;

            double index = 0;

            while (sc.hasNext()) {
                sc.next();
                tempName = sc.next();
                tempStrength = sc.next();
                tempSpeed = sc.next();
                tempStamina = sc.next();
                tempFlying = sc.next();
                tempTech = sc.next();
                tempCombat = sc.next();

                Fighter tempFighter = new Fighter(tempName, Integer.parseInt(tempStrength), Integer.parseInt(tempSpeed),
                        Integer.parseInt(tempStamina), Integer.parseInt(tempFlying), Integer.parseInt(tempTech),
                        Integer.parseInt(tempCombat));

                characterArray.add(tempFighter);
                characters.put(index, tempFighter);
                index = index + 1;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find fighter data file.");
        }

        return characterArray;

    }

    public Game() {
        this.characters = new HashMap<Double, Fighter>();
    }

    public ArrayList<Fighter> getMoveData() {

        ArrayList<Fighter> characterArray = new ArrayList<Fighter>();

        File moveData = new File("/Users/laasya/repos/GitHub/pokemon/MoveData.txt");

        try {
            Scanner sc = new Scanner(moveData);
            // testing System.out.println(sc.nextLine());

            String characterName;
            String moveName;
            String critRateString;
            String critDamageString;

            int size = characters.size();

            for (int i = 0; i < size; i++) {

                // get
                characterName = sc.next();

                Fighter fighter = characters.get(i + 0.0);

                for (int j = 0; j < 3; j++) {
                    moveName = sc.next();
                    critRateString = sc.next();
                    critDamageString = sc.next();

                    Move tempMove = new Move(moveName, Double.parseDouble(critRateString),
                            Double.parseDouble(critDamageString));

                    fighter.addMove(tempMove);

                    System.out.println("Move: " + moveName + " added to character " + fighter.getName());

                }

            }
        } catch (

        FileNotFoundException e) {
            System.out.println("Cannot find fighter data file.");
        }

        return characterArray;

    }

    public ArrayList<Fighter> getSerialFighterData() {

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

}
