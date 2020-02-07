package gr.constantina.home.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int id;
    private String number;
    private String holder;
    private double balance;
    private int pin;
}
