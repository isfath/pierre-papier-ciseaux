public class App {
    //static car appelée sans instance (ici par main)
    static void afficheTableau(Coup[] coups) {
        for (Coup col : coups)
            System.out.print("\t" + col);
        System.out.println();
        for (Coup x : coups) {
            System.out.print(x + "\t");
            for (Coup y : coups) {
                if (x == y)
                    System.out.print('\t');
                else
                    System.out.print((x.gagneContre(y) ? "<" : "|") + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Standard.Pierre.gagneContre(Standard.Ciseaux));
        System.out.println(Coup.valueOf("Pierre"));
        System.out.println(Puits.INSTANCE.gagneContre(Standard.Ciseaux));
        afficheTableau(Standard.values());
        afficheTableau(Coup.values());
    }
}
