package fr.afpa.account;

import java.util.ArrayList;

/**
 * Classe qui représente un client, propriétaire de comptes bancaires
 */
public class Customer {
    //attributs
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts = new ArrayList<Account>();


    //constructeur
    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", accounts=" + accounts
                + "]";
    }

    //getters
    public int getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
       return this.lastName;
    }

    //setters
    public void setLastName(String lastName){
        this.lastName = lastName; 
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    public void addAccount(Account accountToAdd){
        this.accounts.add(accountToAdd);
    }

    public void removeAccount(Account accountToRemove){
        this.accounts.remove(accountToRemove);
    }


}   
