import java.util.Scanner;

public class Snap extends CardGame{
    boolean run;
    Scanner scanner;
    Card currCard, prevCard;
    String input;
    public Snap(){
        super();
        scanner = new Scanner(System.in);
        run = false;
    }

    public void runGame(){
        this.shuffleDeck();
        this.run = true;
        while(this.run){
            if(this.getDeck().isEmpty()){
                run = false;
                System.out.println("No more cards left in the deck.");
                System.out.println("You lose");
                break;
            }
            prevCard = currCard;
            currCard = dealCard();
            System.out.printf("Your next card is the %s of %s", currCard.symbol, currCard.suit);
            input = scanner.nextLine();
            if(prevCard != null) {
                if (prevCard.value == currCard.value) {
                    System.out.println("You win!");
                    run = false;
                }
            }
        };
    }
}
