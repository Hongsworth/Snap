import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private final ArrayList<Card> deck;
    public CardGame(){
        this.deck = new ArrayList<>();
        String[] suits = {"Heart", "Spade", "Club", "Diamond"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for(String suit : suits){
            for(int i = 0; i< symbols.length; i++){
                deck.add(new Card(suit, symbols[i], i+2));
            }
        }
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public Card dealCard(){
        return deck.removeFirst();
    }

    public void sortDeckInNumberOrder(){
        deck.sort(Comparator.comparingInt(a -> a.value));
    }

    public void sortDeckInSuitOrder(){
        deck.sort(Comparator.comparing(card -> card.suit));
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
}
