package gr.constantina.home.atm.model;

import gr.constantina.home.atm.repository.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private Atm atm;
    private Accounts accounts;
}
