package game.player;

import game.dice.StandardDice;

import java.util.Random;

public class VirtualPlayer extends Player implements PlayerAction{

    public VirtualPlayer(String name){
        super(name);
    }

    public void expressDefeat(Player player) {
        System.out.println(">>>" + player.getName()+ ": " + "I lost !, you're so good");
    }

    @Override
    public int rollDice(StandardDice dice){
        return dice.roll();
    }
}
