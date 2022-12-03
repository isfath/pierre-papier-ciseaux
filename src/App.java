public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Standard.Pierre.gagneContre(Standard.Ciseaux));
        System.out.println(Coup.valueOf("Pierre"));
        System.out.println(Puits.INSTANCE.gagneContre(Standard.Ciseaux));
        for (Coup col : Coup.VALUES)
            System.out.print("\t" + col);
        System.out.println();
        for (Coup x : Coup.VALUES) {
            System.out.print(x + "\t");
            for (Coup y : Coup.VALUES) {
                if (x == y)
                    System.out.print('\t');
                else
                    System.out.print((x.gagneContre(y) ? "<" : "|") + "\t");
            }
            System.out.println();
        }
    }
}
