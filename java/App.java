import java.util.Random;
import java.util.Scanner;

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

    static String capitalize(String s) {
        if (s.length() == 0)
            return s;
        else
            return Character.toUpperCase(s.charAt(0)) +
                s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Voulez-vous jouer avec le puits ? ");
        String rep = sc.nextLine().toLowerCase();
        Coup[] poss;
        boolean puits;
        //Class<? extends Coup> cl = Standard.class; //TODO essayer
        if (rep.equals("oui") || rep.equals("yes")) {
            poss = Coup.values();
            puits = true;
        }
        else {
            if (!rep.equals("non") && !rep.equals("no"))
                System.out.println("On va dire que non...");
            poss = Standard.values();
            puits = false;
        }
        System.out.println("Petit rappel des règles :");
        afficheTableau(poss);
        Random ran = new Random();
        int ordi = 0, joueur = 0;
        while (true) {
            Coup mien = poss[ran.nextInt(poss.length)]; //pas de triche !
            System.out.print("Que jouez-vous ? ");
            String cmd = sc.nextLine();
            if (cmd.length() == 0)
                break;
            try {
                cmd = capitalize(cmd);
                Coup sien = puits ? Coup.valueOf(cmd) : Standard.valueOf(cmd);
                System.out.println("J'avais choisi " +
                    //toLowerCase sinon on se demande de quel Pierre on parle !
                    mien.toString().toLowerCase() + ".");
                if (mien.gagneContre(sien)) {
                    System.out.println("J'ai gagné !");
                    ordi++;
                }
                else if (sien.gagneContre(mien)) {
                    System.out.println("Vous avez gagné...");
                    joueur++;
                }
                else
                    System.out.println("Égalité");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Pas compris...");
            }
        }
        System.out.println("Votre score : " + joueur);
        System.out.println("Mon score : " + ordi);
        sc.close();
    }
}
