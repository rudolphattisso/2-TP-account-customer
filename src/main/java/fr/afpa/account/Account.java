package fr.afpa.account;

import java.util.Scanner;

/**
 * Classe représentant un compte bancaire
 */
class Account {
    // TODO à compléter

    public Scanner sc = new Scanner(System.in);

    private String iban;
    private int balance;
    private int overdraftAuthorization;

    // constructeur de la classe
    public Account(String iban, int balance, int overdraftAuthorization) {
        this.iban = iban;
        this.balance = balance;
        this.overdraftAuthorization = overdraftAuthorization;
    }

    @Override
    public String toString() {
        return "Account [iban=" + iban + ", balance=" + balance + ", overdraftAuthorization=" + overdraftAuthorization
                + "]";
    }

    // getters
    public String getIban() {
        return this.iban;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getOverdraftAuthorization() {
        return this.overdraftAuthorization;
    }

    // setters

    public void setIban(String iban) {
        this.iban = iban;

    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOverdraftAuthorization(int overdraftAuthorization) {

        this.overdraftAuthorization = overdraftAuthorization;
    }

    public int AddMoney(int balance) {
        this.balance = balance;
        System.out.println("Combien voulez vous rajouter sur votre compte");
        int addMoney = sc.nextInt();
        return this.balance = balance + addMoney;
    }

    // ----------------------------------------------------------------------------------------------
    public int RemoveMoney(int amount) throws Exception {

    int isMoneyRemoved = sc.nextInt();
    // solde superieur ou égale à l'autorisation de découvert
    if (amount >= this.overdraftAuthorization) {
    //on récupèr balance pour
    amount = this.balance - isMoneyRemoved;
    }
    // solde superieur ou égale à l'autorisation de découvert
    else {
    throw new Exception("Votre est insuffisant");
    }return amount;
    }
    //
    // ----------------------------------------------------------------------------------------------

    //     //1) Si le montant est inférieur au découvert autorisé:
    // public boolean checkBalance(int amount) {
    //     //variable booléenne permettant de verifier si la retrait est possible ou pas
    //     boolean isMoneyRemoved = false;
    //     int removedMoney = sc.nextInt();
    //     amount =  this.balance - removedMoney;
    //     //stocker la variable booléenne IsMoneyRemoved la valeur true; donc l'opération est possible 
    //     if (amount >= this.overdraftAuthorization) {
    //         isMoneyRemoved = true;
    //     //sinon stocker la valeur false; l'oération de retrait est donc impossible;
    //     } else {
    //         return false;
    //     }
    //     return isMoneyRemoved;
    // }

    // public boolean checkBalance(int amount) throws Exception{
    //     //variable booléenne permettant de verifier si la retrait est possible ou pas
    //     boolean isMoneyRemoved = false;
    //     System.out.println("combien voulez-vous retirer?");
    //     int removedMoney = sc.nextInt();
    //     amount =  this.balance - removedMoney;
    //     //stocker la variable booléenne IsMoneyRemoved la valeur true; donc l'opération est possible 
    //     if (amount >= this.overdraftAuthorization) {
    //         isMoneyRemoved = true;
    //     //sinon stocker la valeur false; l'oération de retrait est donc impossible;
    //     } else { throw new Exception("Votre solde est insuffisant");
            
    //     }
    //     return isMoneyRemoved;
    // }

}
