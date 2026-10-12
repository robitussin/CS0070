import characters.Player; // Telling Java: "Go into the characters folder and grab Player"
import characters.Monster; // Telling Java: "Go into the characters folder and grab Monster"
import weapons.Weapon; // Telling Java: "Go into the weapons folder and grab Weapon"

public class Game {
    public static void main(String[] args) {

        Player myHero = new Player("Mario", 1, 2, 3);
        System.out.println(myHero.name);

        Monster myMonster = new Monster("Dragon", 10, 2);
        System.out.println(myMonster.type);

        Weapon myWeapon = new Weapon("Sword", 5);

        myHero.equipWeapon(myWeapon);

        System.out.println(myHero.equippedWeapon.name);

    }
}