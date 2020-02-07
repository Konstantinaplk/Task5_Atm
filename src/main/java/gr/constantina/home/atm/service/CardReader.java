package gr.constantina.home.atm.service;

import gr.constantina.home.atm.model.Account;
import gr.constantina.home.atm.model.Card;
import gr.constantina.home.atm.repository.Accounts;
import gr.constantina.home.atm.repository.Cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CardReader {
    Accounts accounts ;
    Cards cards = new Cards();
    public CardReader(Accounts accounts){
        this.accounts=accounts;
    }

    public Cards readCards(String filenameCards) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filenameCards));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            Card card = new Card();
            card.setNumber(words[0].trim());
            Account ac= accounts.searchById(Integer.parseInt(words[1].trim()));
            card.setAccount(ac);

            cards.addCard(card);
        }
        scanner.close();
        System.out.println(cards);
        return cards;
    }





}
