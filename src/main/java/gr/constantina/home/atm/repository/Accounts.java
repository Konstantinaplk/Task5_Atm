package gr.constantina.home.atm.repository;

import gr.constantina.home.atm.model.Account;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Data

public class Accounts {
    private List<Account> accounts;

    public Accounts() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account a){
        accounts.add(a);
    }

    public Account searchById(int id){
        return accounts.stream()
                .filter(account -> account.getId()==id)
                .findFirst()
                .get()
                ;
    }
}
