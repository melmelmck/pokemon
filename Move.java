import java.util.concurrent.ThreadLocalRandom;

public class Move {

    // classs variables
    public String moveName;
    private double critRate;
    private double critDamage;

    public Move() {
        this.setCritRate(critRate);
        this.setCritDamage(critDamage);
    }

    // constructor 2
    public Move(String name, double critRate, double critDamage) {
        this.moveName = name;
        this.critRate = critRate;
        this.critDamage = critDamage;

    }

    public String getMoveName() {
        return this.moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public double getCritRate() {
        return this.critRate;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public double getCritDamage() {
        return this.critDamage;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    public void calculateDefensePercentage() {
        // notes: should probably have user/computer hp as passed in an argument
        int hp = 90;
        if (hp >= 90) {
            hp = hp - (int) (this.critDamage * 0.2);
        } else if (hp < 90 && hp >= 75) {
            hp = hp - (int) (this.critDamage * 0.6);
        } else if (hp < 75 && hp >= 40) {
            hp = hp - (int) (this.critDamage * 0.8);
        } else {
            hp = hp - (int) this.critDamage;
        }
    }

    public void calculateAttackDamage() {
        double probability = (double) ThreadLocalRandom.current().nextInt(1, 101); // hopefully this gives a random
                                                                                   // number 1-100
        System.out.println(probability);
        if (probability >= this.critRate) {
            // attack successful; calculate critDamage
            calculateDefensePercentage();
        } else {
            // give a random amount of damage either 0/1
        }
    }
}
