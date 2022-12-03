interface Coup {
    static final Coup[] VALUES = {
        Puits.INSTANCE,
        Standard.Pierre, Standard.Papier, Standard.Ciseaux,
    };

    default boolean gagneContre(Coup autre) {
        if (autre == Puits.INSTANCE)
            return false;
        else if (this == Puits.INSTANCE)
            return true;
        else
            return ((Standard)this) //on voit la méthode qui prend Standard
                .gagneContre((Standard)autre); //on donne Standard, pas Coup !
                /* le choix de la méthode à appeler (method overloading)
                   se fait à la compilation, selon les types déclarés */
    }

    /* une interface n'a pas de code dans ses méthodes non-default
       les méthodes statiques ne sont pas concernées par cette règle ! */
    static Coup valueOf(String str) {
        if (str == "Puits")
            return Puits.INSTANCE;
        else
            return Standard.valueOf(str);
    }
}

class Puits implements Coup {
    public static final Puits INSTANCE = new Puits();

    //on empêche les autres de faire new Puits();
    private Puits() {
        //constructeur qui ne fait rien de spécial
    }

    //on ne veut pas voir l'adresse mémoire
    @Override //rappel : on veut une erreur si on a fait une faute de frappe
    public String toString() {
        return "Puits";
    }
}