package gr.constantina.home.atm.service;

import gr.constantina.home.atm.model.Account;
import gr.constantina.home.atm.model.Card;
import gr.constantina.home.atm.repository.Cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CardReader {
    public Cards readCards(String filenameCards) throws FileNotFoundException {
        Cards cards = new Cards();
        Scanner scanner = new Scanner(new File(filenameCards));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            Card card = new Card();
            card.setNumber(words[0].trim());
//            card.setAccount(words[1].trim()); do it for account with Registry

            cards.addCard(card);
        }
        scanner.close();
        return cards;

    }
}
