package week7.assigment_problems;

public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            currentHealth -= amount;
            if (currentHealth < 0) {
                currentHealth = 0;
            }
            System.out.println("c.takeDamage(" + amount + ") -> health = " + currentHealth + (currentHealth == 0 ? " (floored)" : ""));
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            currentHealth += amount;
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth;
            }
            System.out.println("c.heal(" + amount + ") -> health = " + currentHealth + (currentHealth == maxHealth ? " (capped)" : ""));
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}