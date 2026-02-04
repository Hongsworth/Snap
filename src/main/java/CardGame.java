import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    ArrayList<Card> deck = new ArrayList<>();
    String[] suits = {"Heart", "Spade", "Club", "Diamond"};
    String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public CardGame(){
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
        deck.sort((a,b) -> {return a.value < b.value?-1:1;});
    }

    public void sortDeckInSuitOrder(){
        deck.sort(Comparator.comparing(card -> card.suit));
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
}
