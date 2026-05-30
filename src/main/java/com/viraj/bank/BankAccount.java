package com.viraj.bank;

import java.security.PublicKey;
import java.util.Scanner;

public class BankAccount
{
    static int nxtnumber = 100;
    String name;
    double balance;
    int ac_number;

  public BankAccount(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
        ac_number = nxtnumber;
        nxtnumber++;
        System.out.println("Account Created Successfully");
        System.out.println("Account Number:" +ac_number);

    }



}
