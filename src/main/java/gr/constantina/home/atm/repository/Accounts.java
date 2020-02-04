package gr.constantina.home.atm.repository;

import gr.constantina.home.atm.model.Account;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data

public class Accounts {
    private List<Account> accounts;

    public Accounts() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account a){
        accounts.add(a);
    }
}
