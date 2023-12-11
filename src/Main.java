import game.dice.StandardDice;
import game.player.Player;
import game.player.RealPlayer;
import game.player.VirtualPlayer;
import game.referee.HeadReferee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int MAX_NUMBER_PLAYER = 4;
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        // Set up game

        // Dice types
        StandardDice[] dices = {
                new StandardDice(new double[]{0.2, 0.16, 0.16, 0.16, 0.16, 0.16}),
                new StandardDice(new double[]{0.16, 0.2, 0.16, 0.16, 0.16, 0.16}),
                new StandardDice(new double[]{0.16, 0.16, 0.2, 0.16, 0.16, 0.16}),
                new StandardDice(new double[]{0.16, 0.16, 0.16, 0.2, 0.16, 0.16})
        };

        // Head Referee
        HeadReferee ref = new HeadReferee();
        ref.setNumberOfDice(dices.length-1);

        // Set up player
        System.out.print("Enter the number of players: ");
        int numRealPlayers = sc.nextInt();
        while(numRealPlayers > MAX_NUMBER_PLAYER || numRealPlayers < 0){
            System.out.println("The number of players have to be from 0 to 4");
            System.out.print("Please re-enter: ");
            numRealPlayers = sc.nextInt();
        }

        List<Player> playersList = new ArrayList<>();

        // Create real Players
        sc.nextLine(); // Consume the newline character
        for(int i = 0 ; i < numRealPlayers ; i++){

            System.out.print("Enter player " + (i+1) + " name: ");
            RealPlayer player = new RealPlayer( sc.nextLine() );
            playersList.add(player);
        }

        // Create virtual Players
        for(int i = 0 ; i < MAX_NUMBER_PLAYER - numRealPlayers ; i++){
            VirtualPlayer player = new VirtualPlayer("Virtual Player " + (i+1));
            playersList.add(player);
        }


        // Set up done
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Player information: ");
        for(Player player : playersList){
            System.out.println(player.getName());
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        // Start game
        System.out.print("Enter \"start\" to start the game: ");
        while (!sc.nextLine().equals("start")){
            System.out.print("! Incorrect syntax !, please re-enter: ");
        }

        while (true){
            for(int i = 0 ; i < MAX_NUMBER_PLAYER ; i++ ){

                Player player = playersList.get(i);
                ref.performTurn(player);

                // Choose a standard dice for the player
                int chosenDice = ref.chooseDice();

                if(player instanceof RealPlayer) {

                    RealPlayer realPlayer = (RealPlayer) player;

                    System.out.println("The dice chosen are: " + chosenDice);
                    System.out.print("Enter \"roll\" to roll the dice: ");
                    while (!sc.nextLine().equals("roll")){
                        System.out.print("! Incorrect syntax !, please re-enter: ");
                    }

                    // Roll the dice and get the result
                    int res = realPlayer.rollDice(dices[chosenDice]);

                    // Display the result and update the score for the RealPlayer
                    System.out.println("Your Result: " + res);
                    realPlayer.setScore((realPlayer.getScore() + res <= 21) ? (realPlayer.getScore() + res) : 0);
                    System.out.println("Your score is currently: " + realPlayer.getScore());
                    System.out.println("------------------------------------------");

                    if(ref.isWinner(realPlayer)) {
                        ref.declareWinner(realPlayer);
                        for(Player indexPlayer : playersList)
                                if(indexPlayer instanceof VirtualPlayer)
                                    ((VirtualPlayer) indexPlayer).expressDefeat(indexPlayer);
                        System.exit(0);
                    }
                }
                else {

                    VirtualPlayer virtualPlayer = (VirtualPlayer) player;

                    // Display information for the VirtualPlayer
                    System.out.println("The dice chosen are: " + chosenDice);

                    // Roll the dice and get the result
                    int res = virtualPlayer.rollDice(dices[chosenDice]);

                    // Display the result and update the score for the VirtualPlayer
                    System.out.println(virtualPlayer.getName() + " Result: " + res);
                    virtualPlayer.setScore((virtualPlayer.getScore() + res <= 21) ? (virtualPlayer.getScore() + res) : 0);
                    System.out.println(virtualPlayer.getName() + " score is currently: " + virtualPlayer.getScore());
                    System.out.println("------------------------------------------");

                    if(ref.isWinner(virtualPlayer)){
                        ref.declareWinner(virtualPlayer);
                        for(Player indexPlayer : playersList)
                            if(indexPlayer instanceof VirtualPlayer && indexPlayer != virtualPlayer)
                                ((VirtualPlayer) indexPlayer).expressDefeat(indexPlayer);
                        System.exit(0);
                    }
                }
            }
        }
    }
}