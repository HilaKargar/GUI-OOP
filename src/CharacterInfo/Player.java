package CharacterInfo;

import GUI.TextAdventure;

public class Player extends Characters implements CombatInterface{
    public Player(String name, int health, int damage, TextAdventure game, int level){
        super(name,health,damage,game,1);
        this.xp = 0;
        this.maxXp = 50;
        this.inventory = new Inventory<Item<?>>(50,game);
    }
    private int xp;
    public int getXp(){return this.xp; }
    public void setXp(int enemeyLevel){this.xp = this.xp + (enemeyLevel*25); }
    private int maxXp;
    public int getMaxXp(){return this.maxXp; }
    public void setMaxXp(int amount){this.maxXp = amount; }\
    public void gainXp(Enemy e){
        if(!e.getStatus()){
            this.setXp(e.getLevel());
            if(this.maxXp <= this.xp){
                this.xp = 0;
                this.setLevel(this.getLevel()+1);
                this.getGame().handleLevelUp();
            }
        }
    }
    public void increaseHealth(){
        this.setMaxHealth(this.getMaxHealth()+15);
        this.setCurHealth(this.getMaxHealth());
    }
    public void increaseAttack(){
        this.setAttackDamage(this.getAttackDamage()+5);
        this.setCurHealth(this.getMaxHealth());
    }
    public void equipItem(Equippable item){
        item.handleEquip(this);
    }
    public void equipItem(Equippable firstItem, Equippable secondItem){
        firstItem.handleEquip(this);
        secondItem.handleEquip(this);
    }
    @Override
    public void attack(Characters c) {
        if (this.getStatus()) {
            this.dealDamage(c,this.getAttackDamage());
        }
}
