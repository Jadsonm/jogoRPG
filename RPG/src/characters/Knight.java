package characters;

public class Knight extends Character {
    double criticalChance = 0.2;

    public Knight(String name) {
        super(name, 150, 15, 18);
    }

    @Override
    public void attacking(Character other) {
        if (Math.random() < criticalChance) {
            int critialDamage = attack * 2;
            System.out.println("Nome: " + name + "\nLife: " + life);
            System.out.println("Golpe Critico! Causou " + critialDamage + " de dano");
            System.out.println("__________________________________________");
            other.receiveDamage(critialDamage);
        } else {
            super.attacking(other);
        }
    }
}
