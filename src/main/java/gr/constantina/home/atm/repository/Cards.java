package gr.constantina.home.atm.repository;

import gr.constantina.home.atm.model.Card;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cards {
    private List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card c){
        cards.add(c);
    }
}
