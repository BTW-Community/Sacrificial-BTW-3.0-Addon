package btw.community.example;

import btw.entity.mob.villager.trade.TradeProvider;
import btw.item.BTWItems;
import net.minecraft.src.EntityVillager;

public class NewVillagerTrades {
    public static void AddVilagerTrades(){
        EntityVillager.addCustomTrade(2, TradeProvider.getBuilder().profession(2).level(1).buy().item(BTWItems.soulforgedSteelIngot.itemID).emeraldCost(5, 6).mandatory().build());
    }

}
