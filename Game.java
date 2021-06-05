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
                boolean gameResult = playRound(user.getFighter(), sc); // true for wine, false for loss

                if (gameResult) {
                    user.wonRound();
                } else {
                    System.out.println("Better Luck Next time!");
                }

                user.playedRound();
            } else {
                System.out.println("Well done! Here are your stats");
                user.printStats();
                sc.close();
                userPlaying = false;
                return;
            }

        }
    }

    public boolean playRound(Fighter self, Scanner sc) {

        boolean won = false; // true or false if won or not

        int randomEnemyChoice = 1 + (int) (Math.random() * 8);
        Fighter enemy = characters.get(randomEnemyChoice - 1.0);
        System.out.println("Your enemy is...: " + enemy.getName() + "!");

        // start battle
        System.out.println("Start Fighting!");

        boolean gameOngoing = true;

        while (gameOngoing) {
            System.out.println();

            // USER MOVE
            int numberOfMoves = self.getMoves().size();
            for (int i = 1; i < numberOfMoves + 1; i++) {
                String moveName = self.getMoves().get(i - 1).getMoveName();
                System.out.println("Move " + i + " is: " + moveName);
            }

            System.out.println("What would you like to do?");
            String smoveChose = sc.next();
            int smoveChosen = Integer.parseInt(smoveChose) - 1;
            String selfChosenMoveName = self.getMoves().get(smoveChosen).getMoveName();

            // Enemy MOVE - randomly chosen
            int enemymoveChosen = 0 + (int) (Math.random() * 2);
            String enemyChosenMoveName = enemy.getMoves().get(enemymoveChosen).getMoveName();

            // print their moves
            System.out.println("You have chosen: " + selfChosenMoveName);
            System.out.println("The enemy has chosen: " + enemyChosenMoveName);

            // ATTACK effects
            // self get attacked
            self.getAttacked(enemy.getMoves().get(enemymoveChosen));
            // enemy gets attacked
            enemy.getAttacked(self.getMoves().get(smoveChosen));

            // print health
            self.printHealthStatus();
            enemy.printHealthStatus();
            System.out.println();

            // winning or losing check

            if (enemy.getHP() < 10) {
                System.out.println("Enemy in Critical state!");
            }
            if (enemy.getHP() < 1) {
                System.out.println("Enemy has been defeated");
                won = true;

                // resets health of both players for next battle
                enemy.resetFighterHealth();
                self.resetFighterHealth();
                gameOngoing = false;
            }

            if (self.getHP() < 10) {
                System.out.println("We are in Critical state!");
            }
            if (self.getHP() < 1) {
                System.out.println("We have been defeated");
                won = false;

                // resets health of both players for next battle
                enemy.resetFighterHealth();
                self.resetFighterHealth();
                gameOngoing = false;
            }
            System.out.println();
        }
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
