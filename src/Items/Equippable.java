package Items;

import CharacterInfo.*;

public interface Equippable {
    void handleEquip(Player p);
    void handleUnequip(Player p,Inventory<Item<?>> inv);
}
