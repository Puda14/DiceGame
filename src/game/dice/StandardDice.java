package game.dice;

import java.util.Random;

public class StandardDice implements Dice {
    private static final int NUM_SIDES = 6;
    private static final int[] SIDE_VALUES = {1, 2, 3, 4, 5, 6};
    private double[] probabilities;

    private Random random = new Random();

    public StandardDice( double[] probabilities) {
        if (probabilities.length != NUM_SIDES) {
            throw new IllegalArgumentException("Probabilities array must have exactly 6 elements.");
        }
        this.probabilities = probabilities;
    }

    @Override
    public int roll() {
        double randomValue = random.nextDouble();
        double cumulativeProbability = 0.0;

        for (int i = 0; i < NUM_SIDES; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue <= cumulativeProbability) {
                return SIDE_VALUES[i];
            }
        }

        return SIDE_VALUES[NUM_SIDES - 1];
    }
}