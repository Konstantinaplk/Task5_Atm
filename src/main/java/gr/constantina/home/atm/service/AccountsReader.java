package gr.constantina.home.atm.service;

import gr.constantina.home.atm.model.Account;
import gr.constantina.home.atm.repository.Accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountsReader {

    public Accounts readAccounts(String filenameAccounts) throws FileNotFoundException {
        Accounts accounts = new Accounts();
        Scanner scanner = new Scanner(new File(filenameAccounts));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            Account account = new Account();
            account.setId(Integer.parseInt(words[0].trim()));
            account.setNumber(words[1].trim());
            account.setHolder(words[2].trim());
            account.setBalance(Double.parseDouble(words[3].trim()));
            account.setPin(Integer.parseInt(words[4].trim()));
            accounts.addAccount(account);
        }
        scanner.close();
        System.out.println("accounts");
        System.out.println(accounts);
        return accounts;
    }
}
