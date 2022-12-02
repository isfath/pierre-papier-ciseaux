public enum Coup {
    Pierre,
    Papier,
    Ciseaux;

    public boolean gagneContre(Coup autre) {
        return
            (this == Pierre && autre == Ciseaux ||
            this == Ciseaux && autre == Papier ||
            this == Papier && autre == Pierre);
    }

    /* on ne peut pas redéfinir compare : une enum hérite de java.lang.Enum
       qui implémente déjà Comparable et elle est marquée final. */
}
