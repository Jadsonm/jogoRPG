package characters;

public class Paladin extends Character {
    private double doubleAttackChance = 0.4;

    public Paladin(String name) {
        super(name, 100, 25, 12);
    }

    @Override
    public void attacking(Character other) {
        if (Math.random() < doubleAttackChance) {
            System.out.println("Nome: " + name + "\nLife: " + life);
            int doubleAttackDamage = attack * 2;
            System.out.println("O " + name + " atacou duas vezes e causou " + doubleAttackDamage + " de dano");
            System.out.println("__________________________________________");
            other.receiveDamage(doubleAttackDamage);
        } else {
            super.attacking(other);
        }
    }
}
