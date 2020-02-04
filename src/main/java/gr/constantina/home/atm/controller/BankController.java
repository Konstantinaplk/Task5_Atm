package gr.constantina.home.atm.controller;

import gr.constantina.home.atm.model.Account;
import gr.constantina.home.atm.repository.Accounts;
import gr.constantina.home.atm.service.AccountsReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController

public class BankController {

    @GetMapping("start")
    public Accounts accountsController() throws FileNotFoundException {
        AccountsReader accountsReader = new AccountsReader();
        return accountsReader.readAccounts("accounts.csv");
    }

}

