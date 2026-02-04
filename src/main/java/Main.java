import java.util.HashMap;

public class Main {
    public static void main(){
        CardGame game = new CardGame();
//        System.out.println(game.getDeck().getFirst().toString());
//        System.out.println(game.dealCard().toString());
//        System.out.println(game.getDeck().getFirst().toString());
        game.shuffleDeck();
        System.out.println(game.getDeck().toString());
        game.sortDeckInNumberOrder();
        System.out.println(game.getDeck().toString());
        game.sortDeckInSuitOrder();
        System.out.println(game.getDeck().toString());
    }
}
