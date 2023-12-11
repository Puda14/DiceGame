package game.referee;

import game.player.Player;
import java.util.Random;

public class HeadReferee implements RefereeAction{

    private Random random = new Random();

    private int numberOfDice;

    @Override
    public void performTurn(Player player){
        System.out.println(">>> HeadReferee : \""+player.getName() + " Turn \"");
    }

    @Override
    public int chooseDice(){
        return random.nextInt(numberOfDice) + 1;
    }

    @Override
    public void countScore(Player player, int newScore){
        int tmp = player.getScore() + newScore;
        player.setScore( tmp );
        System.out.println("Your current score: " + tmp);
    }

    @Override
    public void declareWinner(Player player){
        System.out.println("===================================");
        System.out.println("THE WINNER IS " + player.getName() + " !");
        System.out.println("! END GAME !");
        System.out.println("===================================");
    };

    @Override
    public boolean isWinner(Player player) {
        return player.getScore() == 21;
    }


    // Getter and Setter
    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
}
