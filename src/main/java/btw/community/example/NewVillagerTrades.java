package btw.community.example;

import btw.entity.mob.villager.trade.TradeProvider;
import btw.item.BTWItems;
import net.fabricmc.example.items.Butchery;
import net.fabricmc.example.items.KnowledgeTome;
import net.fabricmc.example.items.PermafreshBlood;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.Item;

public class NewVillagerTrades {
    public static void AddVilagerTrades(Butchery b, PermafreshBlood p, KnowledgeTome k){
        var profession = 0;
        {
            EntityVillager.removeLevelUpTrade(profession, 1);
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.dirtPile.itemID, 15).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.carrot.itemID, 2).emeraldCost(2, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.bowDrill.itemID, 1).emeraldCost(2, 1).mandatory().addAsLevelUpTrade();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.creeperOysters.itemID, 3).emeraldCost(1, 1).mandatory().addToTradeList();
            EntityVillager.removeLevelUpTrade(profession, 2);
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(BTWItems.boiledPotato.itemID, 2).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.flint.itemID, 4).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.hoeIron.itemID, 4).emeraldCost(3, 4).mandatory().addAsLevelUpTrade();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.brick.itemID, 4).emeraldCost(1, 2).mandatory().mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(BTWItems.padding.itemID, 2).emeraldCost(1, 2).mandatory().mandatory().addToTradeList();
            EntityVillager.removeLevelUpTrade(profession, 3);
            TradeProvider.getBuilder().profession(profession).level(3).sell().item(BTWItems.tastySandwich.itemID, 3).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).sell().item(BTWItems.chickenFeed.itemID, 4).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).sell().item(BTWItems.breadDough.itemID, 3).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).sell().item(BTWItems.boiledPotato.itemID, 6).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).sell().item(BTWItems.carrotSeeds.itemID, 2).emeraldCost(1, 1).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 4);
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(BTWItems.boneFishHook.itemID, 1).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(BTWItems.baitedFishingRod.itemID, 1).emeraldCost(1, 1).mandatory().weight(0.25f).addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.fishCooked.itemID, 6).emeraldCost(2, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.cake.itemID, 1).emeraldCost(1, 2).mandatory().addAsLevelUpTrade();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.pumpkinPie.itemID, 2).emeraldCost(1, 1).mandatory().addToTradeList();

        }
        profession = 1;
        {
            EntityVillager.removeLevelUpTrade(profession, 1);
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(Item.paper.itemID, 3).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.fabric.itemID, 2).emeraldCost(2, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.cutLeather.itemID, 2).emeraldCost(2, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(Item.writableBook.itemID, 1).emeraldCost(1, 1).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 2);
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.feather.itemID, 4).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(BTWItems.boiledPotato.itemID, 4).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.book.itemID, 1).emeraldCost(1, 2).mandatory().mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 3);
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(BTWItems.candle.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(Item.blazeRod.itemID, 4).emeraldCost(3, 4).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(Item.ghastTear.itemID, 1).emeraldCost(4, 5).mandatory().mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(k.itemID, 1).emeraldCost(15, 20).mandatory().mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 4);
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.eyeOfEnder.itemID, 1).emeraldCost(4, 5).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.appleGold.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();

        }
        profession = 2;
        {
            EntityVillager.removeLevelUpTrade(profession, 1);
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(Item.bone.itemID, 7).emeraldCost(1, 2).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.fabric.itemID, 2).emeraldCost(2, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.creeperOysters.itemID, 4).emeraldCost(2, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(Item.compass.itemID, 1).emeraldCost(3, 4).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 2);
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.skull.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(BTWItems.boiledPotato.itemID, 4).emeraldCost(1, 1).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.book.itemID, 1).emeraldCost(1, 2).mandatory().mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 3);
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(BTWItems.candle.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(BTWItems.netherSludge.itemID, 4).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(p.itemID, 4).emeraldCost(15, 20).mandatory().mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 4);
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.appleGold.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();

        }
        profession = 3;
        {
            EntityVillager.removeLevelUpTrade(profession, 1);
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(Item.stick.itemID, 7).itemCount(7, 8).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.ironOreChunk.itemID, 1).emeraldCost(1, 2).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 2);
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.pickaxeIron.itemID, 1).emeraldCost(9, 12).mandatory().addAsLevelUpTrade();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.ingotIron.itemID, 2).emeraldCost(2, 3).mandatory().addToTradeList();
            EntityVillager.removeLevelUpTrade(profession, 3);
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(BTWItems.goldOreChunk.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(Item.brick.itemID, 8).emeraldCost(2, 3).mandatory().mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 4);
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.axeDiamond.itemID, 1).emeraldCost(3, 4).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.plateDiamond.itemID, 1).emeraldCost(4, 5).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(BTWItems.soulDust.itemID, 20).emeraldCost(4, 5).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 5);
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.plateBreastplate.itemID, 1).emeraldCost(10, 15).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.plateHelmet.itemID, 1).emeraldCost(10, 15).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.plateLeggings.itemID, 1).emeraldCost(10, 15).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.plateBoots.itemID, 1).emeraldCost(10, 15).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.mattock.itemID, 1).emeraldCost(10, 15).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.steelSword.itemID, 1).emeraldCost(10, 15).mandatory().addToTradeList();


        }
        profession = 4;
        {
            EntityVillager.removeLevelUpTrade(profession, 1);
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(Item.stick.itemID, 7).itemCount(7, 8).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(1).buy().item(BTWItems.burnedMeat.itemID, 1).emeraldCost(3, 4).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 2);
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.porkRaw.itemID, 1).emeraldCost(1, 1).mandatory().addAsLevelUpTrade();
            TradeProvider.getBuilder().profession(profession).level(2).buy().item(Item.beefRaw.itemID, 2).emeraldCost(1, 2).mandatory().addToTradeList();
            EntityVillager.removeLevelUpTrade(profession, 3);
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(BTWItems.curedMeat.itemID, 1).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(3).buy().item(b.itemID, 3).emeraldCost(15, 20).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 4);
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.beefCooked.itemID, 3).emeraldCost(3, 4).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.porkCooked.itemID, 3).emeraldCost(3, 4).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(4).sell().item(Item.appleGold.itemID, 3).emeraldCost(2, 3).mandatory().addAsLevelUpTrade();
            EntityVillager.removeLevelUpTrade(profession, 5);
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.porkDinner.itemID, 4).emeraldCost(1, 2).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.steakDinner.itemID, 2).emeraldCost(1, 2).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.hamAndEggs.itemID, 7).emeraldCost(2, 3).mandatory().addToTradeList();
            TradeProvider.getBuilder().profession(profession).level(5).sell().item(BTWItems.cookedScrambledEggs.itemID, 2).emeraldCost(1, 1).mandatory().addToTradeList();


        }
    }

}
