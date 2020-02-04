package gr.constantina.home.atm.model;


import gr.constantina.home.atm.service.AccountsReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atm {
    private String location;

    public String insert(Card card){
        return card.getNumber();
    }

    Card card = new Card();
    public boolean confirmPin(int tries, int readPin) throws FileNotFoundException {
        Atm atm = new Atm();
        AccountsReader accountsReader = new AccountsReader();
        int i = 0;
        boolean pinOk = false;
        Account account = accountsReader
                .readAccounts("accounts.csv")
                .getAccounts()
                .stream()
                .filter(accounts -> accounts.getNumber().equals(atm.insert(card)))
                .findFirst()
                .get()
                ;
        do {

            if (account.getPin()==readPin){
                pinOk = true;
                i=tries;
            } else {
                i += 1;
                System.out.println("Wrong Pin, Try Again");
            }
        }while (i<tries);
        return pinOk;
    }

    public int readWithdrawAmount() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("amount.csv"));
        int amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }

    Account account = new Account();
    public void withdrawFromAccount(int amount){
        account.setBalance(account.getBalance() - amount);
    }

    public String showMessage(String message){
        return message;
    }

    public void ejectCard(){

    }


}
