package fr.afpa.account;

import java.math.BigInteger;

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

    // nosu permettra d'afficher le code sur un terminal à l'aide la méthode
    // toString
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
     * solde(balance) en fonction du autorisé le permettent.
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
     * cette foncntion est une opération de retrait d'argent améliorée mais intègre
     * en plus
     * en paramètre le compte vers lequel sera transféré l'argent et le montant à
     * transferer.
     * 
     * @param account2 représente le compte en banque vers lequel sera exécuté le
     *                 transfert.
     * @param amount   représente le montant du transfert.
     * @throws Exception renvoie à l'exception votre solde est insuffisant.
     */
    public void transferMoney(Account account2, int amount) throws Exception {
        if (amount > this.balance + this.overdraftAuthorization) {

            throw new Exception("Le solde de votre compte est insuffisant");

        } else {
            this.balance = this.balance - amount;
            account2 = new Account("1515dsfsd515", 0, 0);
            account2.balance = this.balance + amount;
            // this.balance += amount; c'est la même expression.
        }

    }

    /**
     * Ceci est l'algoorithme de vérification de l'IBAN.
     * 1) Enlever les caractères indésirables (espaces, tirets),
     * 2) Déplacer les 4 premiers caractères à la fin du compte,
     * 3) Remplacer les lettres par des chiffres au moyen d'une table de conversion
     * (A=10, B=11, C=12 etc.),
     * 4) Diviser le nombre ainsi obtenu par 97,
     * 5) Si le reste n'est pas égal à 1 l'IBAN est incorrect : Modulo de 97 égal à
     * 1.
     * 
     * @param stringTocheck est l'iban à vérifier
     * @return la valeur ibanIschecked qui est un booleen qui permet de déterminer
     *         si la l'iban est correct ou non.
     */
    public static boolean checkIban(String stringTocheck) {

        // algo de vérification de l'Iban:
        // étape 1 suppression des caractères indésirables avec la methode de la classe
        // String replaceall
        stringTocheck = stringTocheck.replaceAll("[*\sàâäÄÀÂéèêëÈÊËìîïÌÏÎòöôÒÖÔùüûÙÜÛç!#$€%&'`(),;:/@...]", "");
        // Initialisation en amont des variables pour le point 3) sur la transformation
        // des F et R en leur valeur numérique
        // les variables sont déclarée en haut dans un soucis de compilation
        char charF = stringTocheck.charAt(0);
        char charR = stringTocheck.charAt(1);
        
        String stringForConcatenate76 = stringTocheck.substring(2, 4);
        // 2 de la vérification de vérification de l'IBAN; placer les 4 prmemières
        // caractères en fin de chaine.
        String stringTocheckPart1 = stringTocheck.substring(0, 4);
        String stringTocheckPart2 = stringTocheck.substring(4, stringTocheck.length());
        stringTocheck = stringTocheckPart2 + stringTocheckPart1;
        // 3) remplacer les lettres par des chiffres (initatialisation de la variable
        // string to converter pour recuperer le fr)

        int numericValueChar1 = Character.getNumericValue(charF);
        int numericValueChar2 = Character.getNumericValue(charR);
        String numericValueConcatenateFR = Integer.toString(numericValueChar1) + Integer.toString(numericValueChar2);
        String stringToCheckFinal = stringTocheckPart2 + numericValueConcatenateFR + stringForConcatenate76;// faire
                                                                                                            // la
                                                                                                            // concatenation
        // 4= convertion de de stringtocheckfinal (string) en big Integer car sa valeur
        // est trop grande pourêtre contenue dans un int;
        BigInteger intForModulo = new BigInteger(stringToCheckFinal);
        BigInteger mod97 = new BigInteger("97");
        BigInteger modulo = intForModulo.mod(mod97);
        int moduloInt = modulo.intValue();

        boolean ibanIsChecked = false;
        if (moduloInt == 1) {
            ibanIsChecked = true;

        } else {
            return false;
        }

        return ibanIsChecked;
    }

}
