package game.referee;
import game.dice.StandardDice;
import game.player.Player;

public interface RefereeAction {

    void performTurn(Player player);
    int chooseDice();
    public void countScore(Player player, int newScore);
    void declareWinner(Player player);
    public boolean isWinner(Player player);
}
