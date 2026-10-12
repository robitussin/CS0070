## Java Packages

Java packages are similar to folders on your computer for organizing your files.

Imagine you have a computer where you just throw every single file—photos, homework, tax forms, and video games—onto the desktop. It would quickly become a huge mess! To fix this, you create folders: Photos, School, Finances, and Games.

In Java, packages are just folders used to organize your code classes.

Imagine you are building a small game. You have a Player class and a Monster class. Instead of putting them all together in one giant workspace, you organize them into folders (packages):

```
my-java-project/
│
├── characters/         <-- Package for game characters
│   ├── Monster.java    <-- package characters;
│   └── Player.java     <-- package characters;
│
├── weapons/            <-- Package for items/gear
│   └── Weapon.java     <-- package weapons;
│
└── Game.java           <-- Main entry point (default package or root)
```

## How It Works in Code

- 📁 **characters folder:** Contains classes related to entities in the game. Inside both Monster.java and Player.java, you will see package characters; at the very top.

- 📁 **weapons folder:** Contains gear classes. Inside Weapon.java, you will see package weapons;.

* **Game.java:** Sits outside the subfolders. To use classes from the other folders, it needs to import them using statements like:

```
import characters.Player;
import characters.Monster;
import weapons.Weapon;
```
