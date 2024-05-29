package Game;

import Items.ItemTypes;

public class DamageGenericClass implements ItemTypes {
    private int value;
    public DamageGenericClass(int value){
        this.value = value;
    }
    @Override
    public int getValue(){
        return this.value;
    }
}
