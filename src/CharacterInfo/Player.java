package CharacterInfo;

import GUI.TextAdventure;

public class Player extends Characters implements CombatInterface{
    public Player(String name, int health, int damage, TextAdventure game, int level){
        super(name,health,damage,game,1);
        this.xp = 0;
        this.maxXp = 50;
        this.inventory = new Inventory<Item<?>>(50,game);
    }
}
