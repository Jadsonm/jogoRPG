package characters;

public class Mage extends Character {
    private int mana = 50;

    public Mage(String name) {
        super(name, 80, 35, 8);
    }

    @Override
    public void attacking(Character other) {
        if (mana >= 25) {
            System.out.println("Nome: " + name + "\nLife: " + life);
            int magicDamage = attack + 10;
            System.out.println("O " + name + " lancou uma magia e causou " + magicDamage + " de dano");
            System.out.println("__________________________________________");
            other.receiveDamage(magicDamage);
            mana -= 25;
        } else {
            super.attacking(other);

        }
    }
}
