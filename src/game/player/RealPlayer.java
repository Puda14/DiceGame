package game.player;

import game.dice.StandardDice;

import java.util.Random;

public class RealPlayer extends Player implements PlayerAction  {

    public RealPlayer(String name){
        super(name);
    }

    @Override
    public int rollDice(StandardDice dice){
        return dice.roll();
    }
}
