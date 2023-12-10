package game.referee;

import game.dice.StandardDice;

public class ProbabilityTest {

    public static void main(String[] args) {
        double[] probabilities = {0.16, 0.16, 0.20, 0.16, 0.16, 0.16};
        StandardDice dice = new StandardDice(probabilities);

        int numRolls = 1000000;

        int[] frequency = new int[6];

        for (int i = 0; i < numRolls; i++) {
            int result = dice.roll();
            frequency[result - 1]++;
        }

        for (int i = 0; i < 6; i++) {
            double observedProbability = (double) frequency[i] / numRolls;
            System.out.println("Face " + (i + 1) + ": Observed Probability = " + observedProbability +
                    ", Theoretical Probability = " + probabilities[i]);
        }
    }
}
