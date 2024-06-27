package fr.afpa.account;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class AccountMain{
	public static void main(String[] args) 
	{System.out.println("\n----- Exercice de programmation objet -account ");
	
		// TODO instancier des objets de la classe "Account"
		Account account1 = new Account("fr756sdds48", 150, -500);
		System.out.println("votre montant est de : " + account1.getIban()+ "euros.");
		System.out.println("votre montant est de : " + account1.getBalance()+ "euros.");
		System.out.println("votre montant est de : " + account1.getOverdraftAuthorization()+ "euros.");
		
		// TODO instancier des objets de la classe "Customer"
		
		// TODO ajouter un ou plusieurs objet de "Account" à des "Customer"

		// TODO afficher les informations des employés avec System.out.println

		System.out.println("votre solde est à présent de :" + account1.AddMoney(500));
	}
}

 