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
    private Card card;
}
