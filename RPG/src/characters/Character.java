package characters;

import java.util.Random;
import java.util.Scanner;

public abstract class Character {
    protected String name;
    protected int life;
    protected int attack;
    protected int defense;
    protected int usePotCount = 1;
    protected final int maxPot = 3;

    public Character(String name, int life, int attack, int defense) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.defense = defense;
    }

    public void attacking(Character other) {
        System.out.println("Nome: " + name + "\nLife: " + life);
        int damage = attack - other.defense;
        if (damage <= 0) {
            System.out.println("O " + name + " não causou nenhum dano devido a defesa do adversário");
            System.out.println("__________________________________________");
        } else {
            System.out.println("O " + name + " deu apenas um ataque básico e causou " + damage + " de dano");
            System.out.println("__________________________________________");
            other.receiveDamage(damage);
        }
    }

    public void receiveDamage(int damage) {
        life -= damage;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void usePotion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Atencão, você apenas pode usar 3 pocões!\nEscolha a pocão: \n1- Pocão de vida (recupera 30 pontos de vida)\n2- Pocão de ataque (aumenta seu ataque em 10)");
        int value = scanner.nextInt();
        switch (value) {
            case 1:
                if (maxPot == usePotCount) {
                    System.out.println("Você já usou todas as suas pocões");
                } else {
                    life += 30;
                    System.out.println("O " + name + " usou pocão de vida e recuperou 30 pontos de vida");
                    System.out.println("Você já usou " + usePotCount + " pocões");
                    System.out.println("__________________________________________");
                    usePotCount++;
                }
                break;
            case 2:
                if (maxPot == usePotCount) {
                    System.out.println("Você já usou todas as suas pocões");
                } else {
                    attack += 10;
                    System.out.println("O " + name + " usou pocão de ataque e aumentou seu ataque em 10");
                    System.out.println("Você já usou " + usePotCount + " pocões");
                    System.out.println("__________________________________________");
                    usePotCount++;
                }
                break;
        }

    }

    public void usePotionRandom(int usePotp2) {
        Random random = new Random();
        int value = random.nextInt(2);
        switch (value) {
            case 0:
                if (maxPot == usePotp2) {
                    System.out.println("Você já usou todas as suas pocões");
                } else {
                    life += 30;
                    System.out.println("O " + name + " usou pocão de vida e recuperou 30 pontos de vida");
                    System.out.println("__________________________________________");
                }
                break;
            case 1:
                if (maxPot == usePotp2) {
                    System.out.println("Você já usou todas as suas pocões");
                } else {
                    attack += 10;
                    System.out.println("O " + name + " usou pocão de ataque e aumentou seu ataque em 10");
                    System.out.println(name + " já usou " + usePotCount + " pocões");
                    System.out.println("__________________________________________");
                }
                break;
        }
    }

    public void attakingOrUsePotionRandom(Character other) {
        Random random = new Random();
        if (usePotCount == maxPot) {
            attacking(other);
        } else {
            int value = random.nextInt(2);
            switch (value) {
                case 0 -> attacking(other);
                case 1 -> {
                    usePotionRandom(usePotCount);
                    usePotCount++;
                }
            }
        }

    }

    public static Character getRandomCharacter() {
        Random random = new Random();
        int value = random.nextInt(3);
        return switch (value) {
            case 0 -> new Knight("Zaraki Kenpachi");
            case 1 -> new Mage("Gandalf");
            case 2 -> new Paladin("Legolas");
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }
}
