package fr.afpa.account;

import java.util.Scanner;

/**
 * Classe principale du projet, contient la fonction "main"
 */

class AccountMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\n----- Exercice de programmation objet -account ");

		// TODO instancier des objets de la classe "Account"
		Account account1 = new Account("fr756sdds48", 150, 500);
		
		System.out.println("votre montant est de : " + account1.getIban() + "euros.");
		System.out.println("votre montant est de : " + account1.getBalance() + "euros.");
		System.out.println("votre montant est de : " + account1.getOverdraftAuthorization() + "euros.");
		System.out.println(account1.toString());

		Account account2 = new Account("fr755eeds4", 7500, 000);
		System.out.println("votre montant est de : " + account2.getIban() + "euros.");
		System.out.println("votre montant est de : " + account2.getBalance() + "euros.");
		System.out.println("votre montant est de : " + account2.getOverdraftAuthorization() + "euros.");
		System.out.println(account1.toString());
		// TODO instancier des objets de la classe "Customer"

		// TODO ajouter un ou plusieurs objet de "Account" à des "Customer"

	
		// TODO afficher les informations des employés avec System.out.println
		// System.out.println("Combien voulez vous rajouter sur votre compte");
		// int moneyToAdd = sc.nextInt();
		int moneyToAdd = 56;
		System.out.println("votre solde est à présent de :" + account1.addMoney(moneyToAdd));
		System.out.println("votre solde est à présent de :" + account1.addMoney(moneyToAdd));
		// System.out.println("votre solde est à présent de :" +

	    // comme la méthod eremove money jette un exception, il faut la recuperer dans
		// un try catch pour que la main puisse gerer cette exception.
		try {
			account1.removeMoney(30010);
		} catch (Exception soldException) {
			System.out.println(soldException.getMessage());
		}
		try {
			account1.transferMoney(account1, moneyToAdd);;
		} catch (Exception soldException) {
			System.out.println(soldException.getMessage());
		}

		account1.checkIban("FR76 3000 1007 9412-3456 7890 185");

	}
}
