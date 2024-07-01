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
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
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
        lastName = this.lastName; 
    }

    public void setFirstName(String firstName){
        firstName = this.firstName;
    }


    public static ArrayList<String> addAccount(){
        ArrayList<String> accountaArrayList = new ArrayList<String>();
        accountaArrayList.add("firstName");
        accountaArrayList.add("lastName");
        accountaArrayList.add("id");
        return accountaArrayList;
    }

    public static ArrayList<String> removeAccount(){
        ArrayList<String> accountaArrayList = new ArrayList<String>();
       String firstName = accountaArrayList.remove(0);
       String lastName =  accountaArrayList.remove(1);
       String id = accountaArrayList.remove(2);

        return accountaArrayList;
    }


}   
