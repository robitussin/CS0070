package characters;

import weapons.Weapon;

public class Player {

    // Attributes
    public String name;
    public int strength;
    public int agility;
    public int intelligence;

    public Weapon equippedWeapon;

    // Constructor
    public Player(String characterName, int str, int agi, int intel) {
        name = characterName;
        this.strength = str;
        this.agility = agi;
        this.intelligence = intel;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

}