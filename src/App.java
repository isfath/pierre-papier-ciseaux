public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Standard.Pierre.gagneContre(Standard.Ciseaux));
        System.out.println(Standard.Pierre);
        System.out.println(Puits.INSTANCE.gagneContre(Standard.Ciseaux));
    }
}
