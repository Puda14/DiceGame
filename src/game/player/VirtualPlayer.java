package game.player;

import game.dice.StandardDice;

import java.util.Random;

public class VirtualPlayer extends Player implements PlayerAction{

    public VirtualPlayer(String name){
        super(name);
    }

    public void expressDefeat() {
    }

    @Override
    public int rollDice(StandardDice dice){
        return dice.roll();
    }
}
