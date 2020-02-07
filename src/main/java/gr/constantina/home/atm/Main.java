package gr.constantina.home.atm;

import gr.constantina.home.atm.model.Account;
import gr.constantina.home.atm.model.Atm;
import gr.constantina.home.atm.model.Card;
import gr.constantina.home.atm.repository.Accounts;
import gr.constantina.home.atm.repository.Cards;
import gr.constantina.home.atm.service.AccountsReader;
import gr.constantina.home.atm.service.AtmServices;
import gr.constantina.home.atm.service.CardReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AccountsReader accountsReader = new AccountsReader();
        Accounts accounts = new Accounts();
        accounts = accountsReader.readAccounts("accounts.csv");
        CardReader cardReader = new CardReader(accounts);
        Cards cards = new Cards();
        cards = cardReader.readCards("cards.csv");
        Atm atm = new Atm();
        atm.setLocation("Nea Smyrni");
        Account account = new Account();
        Card card = new Card();
        card.setNumber("999999");
        AtmServices atmServices = new AtmServices(atm);
        atmServices.insert(card);
    }
}
