package fr.afpa.account;

/**
 * Classe représentant un compte bancaire
 */
class Account {
    // TODO à compléter

    private String iban;
    private int balance;
    /**
     * découvert autorisé (entier positif)
     */
    private int overdraftAuthorization;

    // constructeur de la classe
    public Account(String iban, int balance, int overdraftAuthorization) {
        this.iban = iban;
        this.balance = balance;
        this.overdraftAuthorization = overdraftAuthorization;
    }

    @Override
    public String toString() {
        return "Account [iban=" + this.iban + ", balance=" + this.balance + ", overdraftAuthorization="
                + this.overdraftAuthorization
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

    public int addMoney(int amount) {
        // amount représente l'ajout d'argent; l'attribut balance de l'object account...
        this.balance = this.balance + amount;
        // retourne le nouveau montant du compte en banque après l'addition du montant.
        return this.balance;
    }

    // ----------------------------------------------------------------------------------------------
    /**
     * Cette fonction retire de l'argent dans le compte à condition que le
     * solde(balance) et le découvert autorisé le permettent.
     * 
     * @param amount représente ici le montant que je souhaite retirer.
     * @return le nouveau montant du solde.
     * @throws Exception si le solde est insuffisant.
     */
    public int removeMoney(int amount) throws Exception {

        // situation pb et qui jette une exception thrwow Exeption si le montant est
        // supérieur à la somme du solde et du découvert
        if (amount > this.balance + this.overdraftAuthorization) {

            throw new Exception("Votre est insuffisant");

        } else {
            this.balance = this.balance - amount;
            // this.balance += amount; c'est la même expression.
        }
        // nouveau solde
        return this.balance;
    }

    /**
     * cette foncntion est une opération de retrait améliorée mais intègre en plus en 
     * paramètre le compte vers lequel sera transféré l'argent et le montant à  transferer.
     * @param account2 représente le compte en banque vers lequel sera exécuté le transfert.
     * @param amount représente le montant du transfert.
     * @throws Exception renvoie à l'exception votre solde est insuffisant.
     */
    public void transferMoney(Account account2, int amount ) throws Exception{
        if (amount > this.balance + this.overdraftAuthorization) {

            throw new Exception("Votre est insuffisant");

        } else {
            this.balance = this.balance - amount;
            account2 = new Account("1515dsfsd515", 0, 0);
            account2.balance = this.balance + amount; 
            // this.balance += amount; c'est la même expression.
        }

    }
    }


