package main;

import battle.Battle;
import characters.Character;
import characters.Knight;
import characters.Mage;
import characters.Paladin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja Bem-vindo ao Jogo de RPG, primeiro, qual o seu nome?");
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome + "! \nAgora escolha sua classe digitando uma das opcões abaixo:\n1- Knight\n2- Mage\n3- Paladin");
        int value = scanner.nextInt();
        Character player = switch (value) {
            case 1 -> new Knight(nome);
            case 2 -> new Mage(nome);
            case 3 -> new Paladin(nome);
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
        Character opponent = Character.getRandomCharacter();
        System.out.println("Você irá lutar contra: " + opponent.getClass().getSimpleName() + " nome " + opponent.getName());

        Battle.iniciarBatalha(player, opponent);

    }
}
