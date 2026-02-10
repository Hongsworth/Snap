import javax.swing.text.SimpleAttributeSet;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.*;

public class Snap extends CardGame{
    boolean run;
    boolean win;
    Scanner scanner;
    Card currCard, prevCard;
    String input;
    PlayerList players;
    Player player1, player2;
    int turn;

    public Snap() throws IOException {
        super();
        scanner = new Scanner(System.in);
        run = false;
        this.players = new PlayerList();
        turn = 0;
    }

private Player checkWin() {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future<String> futureInput = executor.submit(() -> {
        return scanner.nextLine();
    });

    try {
        input = futureInput.get(2, TimeUnit.SECONDS);
        win = input.equals("snap");
    } catch (TimeoutException e) {
        // No input within 2 seconds
        win = false;
        futureInput.cancel(true);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        executor.shutdownNow();
    }

    if ((turn % 2 == 1 && win) || (turn % 2 == 0 && !win)) {
        player1.addWin();
        player2.addLoss();
        return player1;
    } else {
        player2.addWin();
        player1.addLoss();
        return player2;
    }
}

    public void runGame() throws IOException {
        this.shuffleDeck();
        this.run = true;
        System.out.println("Please enter player 1 name: ");
        player1 = players.getPlayerInfo(scanner.nextLine());
        System.out.println("Please enter player 2 name: ");
        player2 = players.getPlayerInfo(scanner.nextLine());
        System.out.println("Game starting...");
        while(this.run){
            turn += 1;
            if(turn%2 == 1){
                System.out.printf("turn %d: %s's turn\n",turn, player1.name);
            }
            else{
                System.out.printf("turn %d: %s's turn\n",turn, player2.name);
            }
            if(this.getDeck().isEmpty()){
                run = false;
                System.out.println("No more cards left in the deck.");
                System.out.println("You lose");
                break;
            }
            prevCard = currCard;
            currCard = dealCard();
            System.out.printf("Your next card is the %s of %s\n", currCard.symbol, currCard.suit);
            if(prevCard != null) {
//                if (prevCard.value == currCard.value) {
//                    System.out.println("You win!");
//                    run = false;
//
//                }
                if (prevCard.value == currCard.value) {
                    System.out.printf("%s Wins\n", checkWin().name);
                    players.updateList(player1.toJSON());
                    players.updateList(player2.toJSON());
                    players.storeList();
                    run = false;
                }
            }
            if(run){
                input = scanner.nextLine();
            }
        };
    }
}
