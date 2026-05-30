package com.viraj.bank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        boolean running = true;
        while(running)
        {
            System.out.println("==== BANKING SYSTEM ====");
            System.out.println("1. Create Account:");
            System.out.println("2. Deposit:");
            System.out.println("3. Withdrawal:");
            System.out.println("4. Show Balance:");
            System.out.println("5. Exit:");
            int input = sc.nextInt();
            sc.nextLine();
            switch(input)
            {
                case 1:
                    createAccount(accounts);
                    break;
                case 2:
                    depositAccount(accounts);
                    break;
                case 3:
                    withdrawAccount(accounts);
                    break;
                case 4:
                    showBalance(accounts);
                    break;
                case 5:
                    System.out.println("See you Again");
                    running = false;
                    break;

            }

        }
    }

    public static void createAccount(ArrayList<BankAccount>accounts)
    {
        String name;
        double balance;
        while(true)
        {
            System.out.println("Enter Your Name:");
            name = sc.nextLine();
            if (!name.isEmpty() && !name.matches(".*\\d.*")) {
                break;
            }
            System.out.println("Name cannot be empty or numbers");
        }
        while(true)
        {
            System.out.println("Enter Initial Account Balance");
            balance = sc.nextDouble();
            if (balance > 0)
            {
               break;
            }
            System.out.println("Balance Cannot be empty or negative");
        }
        sc.nextLine();
        BankAccount ba = new BankAccount(name, balance);
        accounts.add(ba);
    }
    public static void depositAccount(ArrayList<BankAccount>accounts)
    {
        System.out.println("Enter Account Number");
        int ac_number = sc.nextInt();
        BankAccount account = findAccount(accounts,ac_number);
            if (account != null)
            {
                System.out.println("Enter Amount to Deposit");
                double depositAmount = sc.nextDouble();
                if (depositAmount > 0)
                {
                    account.balance += depositAmount;
                    System.out.println("Account Name:" +account.name);
                    System.out.println("Account Number:"+account.ac_number);
                    System.out.println("Balance:"+account.balance);
                }
                else
                {
                    System.out.println("Enter valid Amount");
                }
            }
            else
            {
                System.out.println("Account Does not Exists");
            }
    }
    public static void withdrawAccount(ArrayList<BankAccount>accounts)
    {
        System.out.println("Enter Account Number");
        int ac_number = sc.nextInt();
        BankAccount account = findAccount(accounts,ac_number);
            if (account != null)
            {
                System.out.println("Enter Amount to Withdraw");
                double withdrawAmount = sc.nextDouble();
                if (withdrawAmount < account.balance)
                {
                    account.balance -= withdrawAmount;
                    System.out.println("Account Name:" + account.name);
                    System.out.println("Account Number:" + account.ac_number);
                    System.out.println("Balance:" + account.balance);
                }
                else
                {
                    System.out.println("Balane is not enough");
                }

            }

            else
            {
                System.out.println("Account Does not Exists");
            }

    }
    public static void showBalance(ArrayList<BankAccount>accounts)
    {

        System.out.println("Enter Account Number:");
        int ac_number = sc.nextInt();
        BankAccount account = findAccount(accounts,ac_number);
        if (account != null)
        {
            System.out.println("Account Name:" +account.name);
            System.out.println("Account Number:"+account.ac_number);
            System.out.println("Balance:"+account.balance);
        }

        else
        {
            System.out.println("Account Does not Exists");
        }
    }

    public static BankAccount findAccount (ArrayList<BankAccount>accounts,int ac_number)
    {
        for (int i=0;i<accounts.size();i++) {
            if (ac_number == accounts.get(i).ac_number) {
                return accounts.get(i);
            }
        }
        return null;
    }

}
