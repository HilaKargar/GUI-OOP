package CharacterInfo;
import GUI.TextAdventure;

public abstract class Characters {
    public Characters(String name, int health, int damage, TextAdventure game, int level){
        this.name = name;
        this.maxHealth = health;
        this.curHealth = health;
        this.attackDamage = damage;
        this.status = true;
        this.game = game;
        this.level = level;

    }
    private TextAdventure game;
    public final void setGame(TextAdventure game){
        this.game = game;
    }
    public final TextAdventure getGame(){
        return this.game;
    }
    private int level;
    public final int getLevel(){return this.level; }
    public final  void setLevel(int amount){this.level = amount; }
    // status of the character ( dead = False, alive = True )
    private boolean status;
    public final boolean getStatus(){
        return this.status;
    }
    public final void setStatus(boolean isAlive){
        this.status = isAlive;
    }
    public void checkstatus() {
        if (this.curHealth <= 0){
            this.status = false;
            this.setCurHealth(0);
        }
    }
    private int maxHealth;
    public final int getMaxHealth(){
        return this.maxHealth;
    }
    public final void setMaxHealth(int amount){
        this.maxHealth = amount;

    }
    private int curHealth;
    public final int getCurHealth(){
        return this.curHealth;
    }
    public final void setCurHealth(int amount){
        this.curHealth = amount;
        if (this.curHealth == 0){
            this.setStatus(false);
        }
    }
    private int attackDamage;
    public final int getAttackDamage(){
        return this.attackDamage;
    }
    public final void setAttackDamage(int amount){
        this.attackDamage = amount;
    }
    public void receiveDamage(int Damage){
        this.curHealth -= Damage;
        if (this.curHealth <= 0){
            this.die();
        }
    }
    private String name;
    public final String getName(){
        return this.name;
    }
    public final void setName(String name){
        this.name = name;
    }
    private void die(){
        if (this.getClass()== Player.class){
            this.setStatus(false);
            System.exit(0);
        } else if (this.getClass() == Enemy.class) {
            this.setStatus(false);
            this.game.displayMessage("you defeated "+this.getName());

        }
    }
    public void handleReceiveDamage(int damage){
        this.receiveDamage(damage);
    }
    public void dealDamage(Characters target,int damage){
        target.handleReceiveDamage(damage);
    }
}

