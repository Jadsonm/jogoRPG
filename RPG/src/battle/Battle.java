package battle;

import java.util.Scanner;
import characters.Character;


public class Battle {
    public static void iniciarBatalha(Character p1, Character p2) {
        int MaxPotion = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("INICIAR BATALHA!!");
        while (p1.isAlive() && p2.isAlive()) {
            System.out.println("Escolha a opcão: \n1- Atacar \n2- Usar pocão");
            System.out.println("Sua vida: " + p1.getLife());
            int value = scanner.nextInt();
            scanner.nextLine();
            switch (value) {
                case 1 -> p1.attacking(p2);
                case 2 -> p1.usePotion();
            }
            if (p2.isAlive()) {
                p2.attakingOrUsePotionRandom(p1);
            }
        }
        if (p1.isAlive()) {
            System.out.println("Parabéns " + p1.getName() + ", Você venceu!!");
        } else {
            System.out.println("Que pena! O " + p2.getName() + " venceu!");
        }
    }
}
