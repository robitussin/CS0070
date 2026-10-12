package characters;

public class Monster {

    // Attributes
    public String type;
    public int hp;
    public int attack;

    public Monster(String monsterType, int health, int damage) {
        this.type = monsterType;
        this.hp = health;
        this.attack = damage;
    }
}