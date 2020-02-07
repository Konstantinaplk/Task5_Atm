package gr.constantina.home.atm.service;

import gr.constantina.home.atm.model.Account;
import gr.constantina.home.atm.model.Atm;
import gr.constantina.home.atm.model.Card;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AtmServices {
    private Atm atm;
    public AtmServices(Atm atm){
        this.atm=atm;
    }
    public void insert(Card card){
        atm.setCard(card);
    }

    public Account findRelevantAccount(Card card) throws FileNotFoundException {
           AccountsReader accountsReader = new AccountsReader();
        Account account = accountsReader
                .readAccounts("accounts.csv")
                .getAccounts()
                .stream()
                .filter(accounte -> accounte.getNumber().equals(atm.getCard().getNumber()))
                .findFirst()
                .get();
        return account;
    }

    public boolean confirmPin(int pin, Card card) throws FileNotFoundException {
        int i = 0;
        boolean pinOk = false;
        Account account = new Account();
        account = findRelevantAccount(card);
        if (account == null) return false;
        do {
            if (account.getPin()==pin){
                pinOk = true;
                i=3;
            } else {
                i += 1;
                System.out.println("Wrong Pin, Try Again");
            }
        }while (i<3);
        return pinOk;
    }

    public int readWithdrawAmount() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("amount.csv"));
        int amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }


//    public void withdrawFromAccount(int amount, Card card) throws FileNotFoundException {
//        Atm atm = readAtmFromDb();
//        atm.insert(card);
//        checkpin
//        Account account = findRelevantAccount(card);
//        account.setBalance(account.getBalance() - amount);
//    }

    public String showMessage(String message){
        return message;
    }

    public void ejectCard(){

    }
}
