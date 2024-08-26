package btw.community.example;

import btw.AddonHandler;
import btw.BTWAddon;
import btw.block.BTWBlocks;
import btw.block.tileentity.WickerBasketTileEntity;
import btw.crafting.recipe.RecipeManager;
import btw.item.BTWItems;
import btw.world.biome.BiomeDecoratorBase;
import net.fabricmc.example.Sacrificial;
import net.fabricmc.example.SacrificialItem;
import net.fabricmc.example.SacrificialKnife;
import net.minecraft.src.*;

import java.util.Random;

public class ExampleAddon extends BTWAddon {
    private static ExampleAddon instance;

    private int sacrificialId = 666;
    private int sacrificialKnifeId = 668;
    private Sacrificial sacrificial;

    private SacrificialItem sacrificialItem;

    public ExampleAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");

        sacrificial = new Sacrificial(sacrificialId, Material.rock);
        sacrificialItem = new SacrificialItem(sacrificialId + 1, sacrificialId);
        var sacrificialKnife = new SacrificialKnife(sacrificialKnifeId, EnumToolMaterial.SOULFORGED_STEEL);
        RecipeManager.addShapelessRecipe(new ItemStack(sacrificialItem, 1), new Object[] {BTWBlocks.looseCobblestone, Block.dragonEgg});
        RecipeManager.addShapelessRecipe(new ItemStack(sacrificialKnife, 1), new Object[] {BTWItems.sharpStone, BTWItems.soulUrn});
    }

    @Override
    public void decorateWorld(BiomeDecoratorBase decorator, World world, Random rand, int x, int y, BiomeGenBase biome) {

        if (x / 16 == world.getSpawnPoint().posX / 16 && y / 16 == world.getSpawnPoint().posZ / 16)
            spawnPillar(world, world.getSpawnPoint().posX, world.getSpawnPoint().posZ);

        if (biome.biomeName.equals("Ocean"))
            return;

        if (!world.doChunksNearChunkExist(x, 0, y, 0))
            return;

        if (rand.nextInt(400) == 1)
            spawnShrine(world, x, y);

        if (rand.nextInt(800) == 1)
            spawnOutcastHouse(world, x, y);

        if (rand.nextInt(300) == 1)
            spawnRuins1(world, x, y, rand);

        if (rand.nextInt(400) == 1)
            spawnRuins2(world, x, y, rand);

        if (rand.nextInt(600) == 1)
            spawnCastle(world, x, y, rand);

        if (rand.nextInt(800) == 1)
            spawnFlought(world, x, y, rand);

        if (rand.nextInt(800) == 1)
            spawnTower1(world, x, y, rand);

        if (rand.nextInt(700) == 1)
            spawnSurfaceDungeon(world, x, y, rand);

        if (rand.nextInt(800) == 1)
            spawnHouse1(world, x, y, rand);
    }

    private void spawnPillar(World world, int x1, int z1)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        int y;
        for (y = 0; y <= 100; ++y)
        {
            world.setBlock(x1 + 2, y, z1 + 2, 4);
            world.setBlock(x1 + -2, y, z1 + 2, 4);
            world.setBlock(x1 + 2, y, z1 + -2, 4);
            world.setBlock(x1 + -2, y, z1 + -2, 4);

            if (y == 80 || y == 95)
            {
                world.setBlock(x1 + -1, y, z1 + -2, 4);
                world.setBlock(x1 + 0, y, z1 + -2, 4);
                world.setBlock(x1 + 1, y, z1 + -2, 4);

                world.setBlock(x1 + -1, y, z1 + 2, 4);
                world.setBlock(x1 + 0, y, z1 + 2, 4);
                world.setBlock(x1 + 1, y, z1 + 2, 4);

                world.setBlock(x1 + -2, y, z1 + -1, 4);
                world.setBlock(x1 + -2, y, z1 + 0, 4);
                world.setBlock(x1 + -2, y, z1 + 1, 4);

                world.setBlock(x1 + 2, y, z1 + -1, 4);
                world.setBlock(x1 + 2, y, z1 + 0, 4);
                world.setBlock(x1 + 2, y, z1 + 1, 4);
            }

            for (int x = -1; x <= 1; ++x)
            {
                for (int z = -1; z <= 1; ++z)
                {
                    world.setBlock(x1 + x, y, z1 + z, 1166);
                }
            }
        }
    }

    private void spawnShrine(World world, int x1, int z1)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        //Base
        for (int layer = height - 10; layer <= height; ++layer)
        {
            for (int x2 = 1; x2 <= 7; ++x2)
            {
                for (int z2 = 1; z2 <= 7; ++z2)
                {
                    world.setBlock(x1+x2, layer, z1+z2, 4);
                }
            }
        }

        // Second base
        for (int x2 = 2; x2 <= 6; ++x2)
        {
            for (int z2 = 2; z2 <= 6; ++z2)
            {
                world.setBlock(x1+x2, height+1, z1+z2, 98);
            }
        }

        //Pillars
        world.setBlock(x1+2, height+2, z1+2, 17);
        world.setBlock(x1+6, height+2, z1+2, 17);
        world.setBlock(x1+2, height+2, z1+6, 17);
        world.setBlock(x1+6, height+2, z1+6, 17);

        world.setBlock(x1+2, height+3, z1+2, 17);
        world.setBlock(x1+6, height+3, z1+2, 17);
        world.setBlock(x1+2, height+3, z1+6, 17);
        world.setBlock(x1+6, height+3, z1+6, 17);

        world.setBlock(x1+2, height+4, z1+2, 17);
        world.setBlock(x1+6, height+4, z1+2, 17);
        world.setBlock(x1+2, height+4, z1+6, 17);
        world.setBlock(x1+6, height+4, z1+6, 17);

        world.setBlock(x1+2, height+5, z1+2, 87);
        world.setBlock(x1+6, height+5, z1+2, 87);
        world.setBlock(x1+2, height+5, z1+6, 87);
        world.setBlock(x1+6, height+5, z1+6, 87);

        world.setBlock(x1+2, height+6, z1+2, 51);
        world.setBlock(x1+6, height+6, z1+2, 51);
        world.setBlock(x1+2, height+6, z1+6, 51);
        world.setBlock(x1+6, height+6, z1+6, 51);

        // Loot
        world.setBlock(x1+4, height+2, z1+4, 1031);
        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+4, height+2, z1+4);
        var loot = new ItemStack(BTWItems.ironChisel);
        chest.setStorageStack(loot);
    }

    private void spawnOutcastHouse(World world, int x1, int z1)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        // Base
        for (int layer = height - 10; layer <= height; ++layer)
        {
            for (int x2 = 1; x2 <= 11; ++x2)
            {
                for (int z2 = 1; z2 <= 11; ++z2)
                {
                    world.setBlock(x1+x2, layer, z1+z2, 4);
                }
            }
        }

        // Walls
        for (int x2 = 1; x2 <= 11; ++x2)
        {
            world.setBlock(x1+x2, height + 1, z1+11, 4);
            world.setBlock(x1+x2, height + 2, z1+11, 5);
            world.setBlock(x1+x2, height + 3, z1+11, 5);
        }
        for (int x2 = 1; x2 <= 11; ++x2)
        {
            world.setBlock(x1+x2, height + 1, z1+1, 4);
            world.setBlock(x1+x2, height + 2, z1+1, 5);
            world.setBlock(x1+x2, height + 3, z1+1, 5);
        }

        for (int z2 = 1; z2 <= 11; ++z2)
        {
            world.setBlock(x1+11, height + 1, z1+z2, 4);
            world.setBlock(x1+11, height + 2, z1+z2, 5);
            world.setBlock(x1+11, height + 3, z1+z2, 5);
        }
        for (int z2 = 1; z2 <= 11; ++z2)
        {
            world.setBlock(x1+1, height + 1, z1+z2, 4);
            world.setBlock(x1+1, height + 2, z1+z2, 5);
            world.setBlock(x1+1, height + 3, z1+z2, 5);
        }

        // Fill with air
        for (int y2 = 1; y2 <= 3; ++y2)
        {
            for (int x2 = 2; x2 <= 10; ++x2)
            {
                for (int z2 = 2; z2 <= 10; ++z2)
                {
                    world.setBlock(x1+x2, height + y2, z1+z2, 0);
                }
            }
        }

        // Roof
        for (int z2 = 1; z2 <= 11; ++z2)
        {
            world.setBlock(x1+12, height + 3, z1+z2, 45);
        }
        for (int z2 = 1; z2 <= 11; ++z2)
        {
            world.setBlock(x1, height + 3, z1+z2, 45);
        }
        for (int x2 = 1; x2 <= 11; ++x2)
        {
            for (int z2 = 1; z2 <= 11; ++z2)
            {
                world.setBlock(x1+x2, height + 4, z1+z2, 45);
            }
        }
        for (int x2 = 2; x2 <= 10; ++x2)
        {
            for (int z2 = 1; z2 <= 11; ++z2)
            {
                world.setBlock(x1+x2, height + 5, z1+z2, 45);
            }
        }
        for (int x2 = 3; x2 <= 9; ++x2)
        {
            for (int z2 = 1; z2 <= 11; ++z2)
            {
                world.setBlock(x1+x2, height + 6, z1+z2, 45);
            }
        }
        for (int x2 = 4; x2 <= 8; ++x2)
        {
            for (int z2 = 1; z2 <= 11; ++z2)
            {
                world.setBlock(x1+x2, height + 7, z1+z2, 45);
            }
        }
        for (int x2 = 5; x2 <= 7; ++x2)
        {
            for (int z2 = 1; z2 <= 11; ++z2)
            {
                world.setBlock(x1+x2, height + 8, z1+z2, 45);
            }
        }
        for (int z2 = 1; z2 <= 11; ++z2)
        {
            world.setBlock(x1+6, height + 9, z1+z2, 45);
        }

        // Door
        world.setBlock(x1+1, height + 1, z1+4, 0);
        world.setBlock(x1+1, height + 2, z1+4, 0);

        // Windows
        world.setBlock(x1+11, height + 2, z1+2, 102);
        world.setBlock(x1+1, height + 2, z1+2, 102);

        world.setBlock(x1+3, height + 2, z1+11, 102);
        world.setBlock(x1+3, height + 2, z1+1, 102);

        world.setBlock(x1+8, height + 2, z1+11, 102);
        world.setBlock(x1+8, height + 2, z1+1, 102);

        // Glowstone Lamps
        world.setBlock(x1+4, height+4, z1+4, 89);
        world.setBlock(x1+7, height+4, z1+7, 89);

        // Kitchen
        world.setBlock(x1+10, height+1, z1+2, 17);
        world.setBlock(x1+10, height+1, z1+3, 17);
        world.setBlock(x1+10, height+1, z1+4, 139);
        world.setBlock(x1+10, height+2, z1+4, 139);
        world.setBlock(x1+10, height+3, z1+4, 139);
        world.setBlock(x1+10, height+3, z1+4, 139);

        // Tables
        world.setBlock(x1+4, height+1, z1+5, 5);
        world.setBlock(x1+4, height+1, z1+6, 5);

        world.setBlock(x1+7, height+1, z1+4, 5);
        world.setBlock(x1+6, height+1, z1+4, 5);

        // Loot
        world.setBlock(x1+10, height+1, z1+9, 1031);
        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+10, height+1, z1+9);
        var loot = new ItemStack(BTWItems.diamondIngot, 4);
        chest.setStorageStack(loot);

        var outcast = new EntityVillager(world, 1);
        outcast.setLocationAndAngles(x1+10, height+1, z1+9, 0, 0);
        world.spawnEntityInWorld(outcast);
    }

    private void spawnRuins1(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1);

        world.setBlock(x1+0, height+0, z1+0, 4);
        world.setBlock(x1+1, height+0, z1+0, 4);
        world.setBlock(x1+2, height+0, z1+0, 4);
        world.setBlock(x1+3, height+0, z1+0, 4);
        world.setBlock(x1+4, height+0, z1+0, 98);
        world.setBlock(x1+5, height+0, z1+0, 4);
        world.setBlock(x1+0, height+0, z1+1, 4);
        world.setBlock(x1+0, height+0, z1+2, 4);
        world.setBlock(x1+0, height+0, z1+3, 4);
        world.setBlock(x1+0, height+0, z1+4, 4);
        world.setBlock(x1+0, height+0, z1+5, 4);
        world.setBlock(x1+1, height+0, z1+5, 4);
        world.setBlock(x1+2, height+0, z1+5, 4);
        world.setBlock(x1+3, height+0, z1+5, 4);
        world.setBlock(x1+4, height+0, z1+5, 4);
        world.setBlock(x1+5, height+0, z1+5, 4);
        world.setBlock(x1+5, height+0, z1+4, 4);
        world.setBlock(x1+5, height+0, z1+3, 4);
        world.setBlock(x1+5, height+1, z1+3, 98);
        world.setBlock(x1+5, height+1, z1+4, 4);
        world.setBlock(x1+5, height+1, z1+5, 4);
        world.setBlock(x1+5, height+2, z1+5, 4);
        world.setBlock(x1+4, height+1, z1+5, 4);
        world.setBlock(x1+3, height+1, z1+5, 4);
        world.setBlock(x1+2, height+1, z1+5, 98);
        world.setBlock(x1+2, height+2, z1+5, 4);
        world.setBlock(x1+2, height+2, z1+5, 4);
        world.setBlock(x1+2, height+3, z1+5, 4);
        world.setBlock(x1+1, height+1, z1+5, 4);
        world.setBlock(x1+0, height+1, z1+5, 4);
        world.setBlock(x1+0, height+2, z1+5, 4);
        world.setBlock(x1+0, height+1, z1+3, 98);
        world.setBlock(x1+0, height+1, z1+4, 4);
        world.setBlock(x1+0, height+1, z1+1, 4);
        world.setBlock(x1+2, height+1, z1+0, 4);

        // Loot
        world.setBlock(x1+1, height+0, z1+1, 1031);

        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+1, height+0, z1+1);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.diamondIngot, 4);

        var randomLoot = rand.nextInt(1, 3);

        if (randomLoot == 1)
            loot = new ItemStack(BTWItems.ironNugget, 3);
        if (randomLoot == 2)
            loot = new ItemStack(Item.silk);
        if (randomLoot == 3)
            loot = new ItemStack(Item.bone, 3);

        chest.setStorageStack(loot);
    }

    private void spawnRuins2(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1);

        world.setBlock(x1+0, height+0, z1+0, 4);
        world.setBlock(x1+1, height+0, z1+0, 4);
        world.setBlock(x1+2, height+0, z1+0, 4);
        world.setBlock(x1+3, height+0, z1+0, 4);
        world.setBlock(x1+4, height+0, z1+0, 98);
        world.setBlock(x1+5, height+0, z1+0, 4);
        world.setBlock(x1+0, height+0, z1+1, 4);
        world.setBlock(x1+0, height+0, z1+2, 4);
        world.setBlock(x1+0, height+0, z1+3, 4);
        world.setBlock(x1+0, height+0, z1+4, 4);
        world.setBlock(x1+0, height+0, z1+5, 4);
        world.setBlock(x1+1, height+0, z1+5, 4);
        world.setBlock(x1+2, height+0, z1+5, 4);
        world.setBlock(x1+3, height+0, z1+5, 4);
        world.setBlock(x1+4, height+0, z1+5, 4);
        world.setBlock(x1+5, height+0, z1+5, 4);
        world.setBlock(x1+5, height+0, z1+4, 4);
        world.setBlock(x1+5, height+0, z1+3, 4);
        world.setBlock(x1+5, height+1, z1+3, 98);
        world.setBlock(x1+5, height+1, z1+4, 4);
        world.setBlock(x1+5, height+1, z1+5, 4);
        world.setBlock(x1+5, height+2, z1+5, 4);
        world.setBlock(x1+4, height+1, z1+5, 4);
        world.setBlock(x1+3, height+1, z1+5, 4);
        world.setBlock(x1+2, height+1, z1+5, 98);
        world.setBlock(x1+2, height+2, z1+5, 4);
        world.setBlock(x1+2, height+2, z1+5, 4);
        world.setBlock(x1+2, height+3, z1+5, 4);
        world.setBlock(x1+1, height+1, z1+5, 4);
        world.setBlock(x1+0, height+1, z1+5, 4);
        world.setBlock(x1+0, height+2, z1+5, 4);
        world.setBlock(x1+0, height+1, z1+3, 98);
        world.setBlock(x1+0, height+1, z1+4, 4);
        world.setBlock(x1+5, height+0, z1+2, 4);
        world.setBlock(x1+5, height+0, z1+1, 4);
        world.setBlock(x1+5, height+1, z1+1, 4);
        world.setBlock(x1+5, height+2, z1+1, 4);
        world.setBlock(x1+5, height+2, z1+2, 4);
        world.setBlock(x1+5, height+1, z1+0, 4);
        world.setBlock(x1+4, height+1, z1+0, 4);
        world.setBlock(x1+4, height+2, z1+0, 4);
        world.setBlock(x1+4, height+3, z1+0, 4);
        world.setBlock(x1+4, height+4, z1+0, 4);
        world.setBlock(x1+5, height+4, z1+0, 98);
        world.setBlock(x1+5, height+3, z1+0, 4);
        world.setBlock(x1+5, height+3, z1+1, 4);
        world.setBlock(x1+5, height+2, z1+3, 4);
        world.setBlock(x1+5, height+3, z1+3, 4);
        world.setBlock(x1+5, height+3, z1+4, 4);
        world.setBlock(x1+3, height+2, z1+5, 4);
        world.setBlock(x1+3, height+3, z1+5, 4);
        world.setBlock(x1+4, height+3, z1+5, 4);
        world.setBlock(x1+1, height+3, z1+5, 4);
        world.setBlock(x1+2, height+4, z1+5, 4);
        world.setBlock(x1+0, height+2, z1+4, 4);
        world.setBlock(x1+0, height+2, z1+1, 4);
        world.setBlock(x1+0, height+1, z1+0, 4);
        world.setBlock(x1+0, height+3, z1+1, 4);
        world.setBlock(x1+0, height+4, z1+1, 4);
        world.setBlock(x1+0, height+5, z1+1, 4);
        world.setBlock(x1+0, height+5, z1+0, 98);
        world.setBlock(x1+1, height+5, z1+0, 4);
        world.setBlock(x1+2, height+5, z1+0, 4);
        world.setBlock(x1+3, height+5, z1+0, 4);
        world.setBlock(x1+4, height+5, z1+0, 4);
        world.setBlock(x1+5, height+5, z1+0, 4);
        world.setBlock(x1+5, height+6, z1+0, 4);
        world.setBlock(x1+3, height+6, z1+0, 4);
        world.setBlock(x1+1, height+6, z1+0, 4);
        world.setBlock(x1+0, height+6, z1+0, 4);
        world.setBlock(x1+0, height+6, z1+1, 4);
        world.setBlock(x1+5, height+6, z1+1, 4);
        world.setBlock(x1+5, height+5, z1+1, 4);
        world.setBlock(x1+5, height+5, z1+2, 4);
        world.setBlock(x1+5, height+4, z1+3, 4);
        world.setBlock(x1+5, height+5, z1+3, 4);
        world.setBlock(x1+5, height+6, z1+3, 98);
        world.setBlock(x1+5, height+5, z1+4, 4);
        world.setBlock(x1+4, height+4, z1+5, 4);
        world.setBlock(x1+4, height+5, z1+5, 4);
        world.setBlock(x1+4, height+6, z1+5, 4);
        world.setBlock(x1+2, height+5, z1+5, 4);
        world.setBlock(x1+3, height+5, z1+5, 4);
        world.setBlock(x1+2, height+6, z1+5, 4);
        world.setBlock(x1+0, height+1, z1+1, 4);
        world.setBlock(x1+2, height+1, z1+0, 4);
        world.setBlock(x1+3, height+6, z1+5, 1031);

        // Loot
        world.setBlock(x1+3, height+6, z1+5, 1031);

        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+3, height+6, z1+5);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.diamondIngot, 4);

        var randomLoot = rand.nextInt(1, 3);

        if (randomLoot == 1)
            loot = new ItemStack(BTWItems.ironNugget, 3);
        if (randomLoot == 2)
            loot = new ItemStack(Item.silk);
        if (randomLoot == 3)
            loot = new ItemStack(Item.bone, 3);

        chest.setStorageStack(loot);
    }

    private void spawnCastle(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        world.setBlock(x1+3, height+0, z1+1, 4);
        world.setBlock(x1+1, height+0, z1+1, 4);
        world.setBlock(x1+1, height+0, z1+2, 4);
        world.setBlock(x1+1, height+0, z1+3, 4);
        world.setBlock(x1+1, height+0, z1+4, 4);
        world.setBlock(x1+1, height+0, z1+5, 4);
        world.setBlock(x1+1, height+0, z1+6, 4);
        world.setBlock(x1+2, height+0, z1+6, 4);
        world.setBlock(x1+2, height+1, z1+6, 4);
        world.setBlock(x1+1, height+1, z1+6, 4);
        world.setBlock(x1+1, height+1, z1+3, 4);
        world.setBlock(x1+1, height+2, z1+3, 4);
        world.setBlock(x1+1, height+2, z1+4, 4);
        world.setBlock(x1+1, height+3, z1+4, 4);
        world.setBlock(x1+1, height+3, z1+5, 4);
        world.setBlock(x1+1, height+3, z1+6, 4);
        world.setBlock(x1+1, height+2, z1+6, 4);
        world.setBlock(x1+1, height+4, z1+6, 4);
        world.setBlock(x1+2, height+4, z1+6, 4);
        world.setBlock(x1+3, height+4, z1+6, 4);
        world.setBlock(x1+5, height+4, z1+6, 4);
        world.setBlock(x1+4, height+4, z1+6, 4);
        world.setBlock(x1+6, height+4, z1+6, 4);
        world.setBlock(x1+6, height+5, z1+7, 4);
        world.setBlock(x1+5, height+5, z1+7, 4);
        world.setBlock(x1+4, height+5, z1+7, 4);
        world.setBlock(x1+3, height+5, z1+7, 4);
        world.setBlock(x1+2, height+5, z1+7, 4);
        world.setBlock(x1+1, height+5, z1+7, 4);
        world.setBlock(x1+0, height+5, z1+7, 4);
        world.setBlock(x1+7, height+5, z1+7, 4);
        world.setBlock(x1+6, height+5, z1+0, 4);
        world.setBlock(x1+5, height+5, z1+0, 4);
        world.setBlock(x1+4, height+5, z1+0, 4);
        world.setBlock(x1+3, height+5, z1+0, 98);
        world.setBlock(x1+2, height+5, z1+0, 4);
        world.setBlock(x1+1, height+5, z1+0, 4);
        world.setBlock(x1+0, height+5, z1+0, 4);
        world.setBlock(x1+0, height+5, z1+1, 4);
        world.setBlock(x1+0, height+5, z1+2, 4);
        world.setBlock(x1+0, height+5, z1+3, 4);
        world.setBlock(x1+0, height+5, z1+4, 4);
        world.setBlock(x1+0, height+5, z1+5, 4);
        world.setBlock(x1+0, height+5, z1+6, 4);
        world.setBlock(x1+7, height+5, z1+1, 98);
        world.setBlock(x1+7, height+5, z1+2, 4);
        world.setBlock(x1+7, height+5, z1+3, 4);
        world.setBlock(x1+7, height+5, z1+4, 4);
        world.setBlock(x1+7, height+5, z1+5, 4);
        world.setBlock(x1+7, height+5, z1+6, 4);
        world.setBlock(x1+7, height+5, z1+0, 4);
        world.setBlock(x1+6, height+6, z1+7, 4);
        world.setBlock(x1+5, height+6, z1+7, 4);
        world.setBlock(x1+4, height+6, z1+7, 4);
        world.setBlock(x1+3, height+6, z1+7, 98);
        world.setBlock(x1+2, height+6, z1+7, 4);
        world.setBlock(x1+1, height+6, z1+7, 4);
        world.setBlock(x1+0, height+6, z1+7, 4);
        world.setBlock(x1+7, height+6, z1+7, 4);
        world.setBlock(x1+6, height+6, z1+0, 4);
        world.setBlock(x1+5, height+6, z1+0, 4);
        world.setBlock(x1+4, height+6, z1+0, 4);
        world.setBlock(x1+3, height+6, z1+0, 4);
        world.setBlock(x1+2, height+6, z1+0, 4);
        world.setBlock(x1+1, height+6, z1+0, 4);
        world.setBlock(x1+0, height+6, z1+0, 4);
        world.setBlock(x1+0, height+6, z1+1, 4);
        world.setBlock(x1+0, height+6, z1+2, 4);
        world.setBlock(x1+0, height+6, z1+3, 4);
        world.setBlock(x1+0, height+6, z1+4, 4);
        world.setBlock(x1+0, height+6, z1+5, 4);
        world.setBlock(x1+0, height+6, z1+6, 4);
        world.setBlock(x1+7, height+6, z1+1, 4);
        world.setBlock(x1+7, height+6, z1+2, 4);
        world.setBlock(x1+7, height+6, z1+3, 4);
        world.setBlock(x1+7, height+6, z1+4, 4);
        world.setBlock(x1+7, height+6, z1+5, 4);
        world.setBlock(x1+7, height+6, z1+6, 4);
        world.setBlock(x1+7, height+6, z1+0, 4);
        world.setBlock(x1+6, height+7, z1+7, 4);
        world.setBlock(x1+5, height+7, z1+7, 4);
        world.setBlock(x1+4, height+7, z1+7, 4);
        world.setBlock(x1+3, height+7, z1+7, 4);
        world.setBlock(x1+2, height+7, z1+7, 4);
        world.setBlock(x1+1, height+7, z1+7, 4);
        world.setBlock(x1+0, height+7, z1+7, 4);
        world.setBlock(x1+7, height+7, z1+7, 4);
        world.setBlock(x1+6, height+7, z1+0, 4);
        world.setBlock(x1+5, height+7, z1+0, 4);
        world.setBlock(x1+4, height+7, z1+0, 4);
        world.setBlock(x1+3, height+7, z1+0, 4);
        world.setBlock(x1+2, height+7, z1+0, 4);
        world.setBlock(x1+1, height+7, z1+0, 4);
        world.setBlock(x1+0, height+7, z1+0, 4);
        world.setBlock(x1+0, height+7, z1+1, 4);
        world.setBlock(x1+0, height+7, z1+2, 4);
        world.setBlock(x1+0, height+7, z1+3, 4);
        world.setBlock(x1+0, height+7, z1+4, 98);
        world.setBlock(x1+0, height+7, z1+5, 4);
        world.setBlock(x1+0, height+7, z1+6, 4);
        world.setBlock(x1+7, height+7, z1+1, 4);
        world.setBlock(x1+7, height+7, z1+2, 4);
        world.setBlock(x1+7, height+7, z1+3, 4);
        world.setBlock(x1+7, height+7, z1+4, 4);
        world.setBlock(x1+7, height+7, z1+5, 98);
        world.setBlock(x1+7, height+7, z1+6, 4);
        world.setBlock(x1+7, height+7, z1+0, 4);
        world.setBlock(x1+1, height+4, z1+5, 4);
        world.setBlock(x1+2, height+4, z1+5, 4);
        world.setBlock(x1+3, height+4, z1+5, 4);
        world.setBlock(x1+5, height+4, z1+5, 4);
        world.setBlock(x1+4, height+4, z1+5, 4);
        world.setBlock(x1+6, height+4, z1+5, 4);
        world.setBlock(x1+1, height+4, z1+4, 4);
        world.setBlock(x1+2, height+4, z1+4, 4);
        world.setBlock(x1+3, height+4, z1+4, 4);
        world.setBlock(x1+5, height+4, z1+4, 4);
        world.setBlock(x1+6, height+5, z1+5, 4);
        world.setBlock(x1+6, height+6, z1+6, 4);
        world.setBlock(x1+5, height+7, z1+6, 4);
        world.setBlock(x1+4, height+4, z1+4, 4);
        world.setBlock(x1+6, height+4, z1+4, 4);
        world.setBlock(x1+1, height+4, z1+3, 4);
        world.setBlock(x1+2, height+4, z1+3, 4);
        world.setBlock(x1+3, height+4, z1+3, 4);
        world.setBlock(x1+5, height+4, z1+3, 4);
        world.setBlock(x1+4, height+4, z1+3, 4);

        world.setBlock(x1+2, height+5, z1+3, 52);
        var spawner1 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+2, height+5, z1+3);
        spawner1.getSpawnerLogic().setMobID("Zombie");

        world.setBlock(x1+2, height+5, z1+4, 52);
        var spawner2 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+2, height+5, z1+4);
        spawner2.getSpawnerLogic().setMobID("Zombie");

        world.setBlock(x1+2, height+9, z1+3, 52);
        var spawner3 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+2, height+9, z1+3);
        spawner3.getSpawnerLogic().setMobID("Skeleton");

        world.setBlock(x1+2, height+9, z1+4, 1031);
        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+2, height+9, z1+4);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.diamondIngot, 5);

        var randomLoot = rand.nextInt(1, 4);

        if (randomLoot == 1)
            loot = new ItemStack(BTWItems.ironNugget, 3);
        if (randomLoot == 2)
            loot = new ItemStack(Item.ingotIron, 2);
        if (randomLoot == 3)
            loot = new ItemStack(Item.bone, 1);
        if (randomLoot == 4)
            loot = new ItemStack(Item.ingotGold, 4);
        if (randomLoot == 5)
            loot = new ItemStack(Item.swordIron, 1);

        chest.setStorageStack(loot);

        world.setBlock(x1+1, height+4, z1+2, 4);
        world.setBlock(x1+2, height+4, z1+2, 4);
        world.setBlock(x1+3, height+4, z1+2, 4);
        world.setBlock(x1+5, height+4, z1+2, 4);
        world.setBlock(x1+4, height+4, z1+2, 4);
        world.setBlock(x1+1, height+4, z1+1, 4);
        world.setBlock(x1+2, height+4, z1+1, 4);
        world.setBlock(x1+3, height+4, z1+1, 4);
        world.setBlock(x1+5, height+4, z1+1, 4);
        world.setBlock(x1+4, height+4, z1+1, 4);
        world.setBlock(x1+1, height+8, z1+6, 4);
        world.setBlock(x1+2, height+8, z1+6, 4);
        world.setBlock(x1+3, height+8, z1+6, 4);
        world.setBlock(x1+4, height+8, z1+6, 4);
        world.setBlock(x1+1, height+8, z1+5, 4);
        world.setBlock(x1+2, height+8, z1+5, 4);
        world.setBlock(x1+3, height+8, z1+5, 4);
        world.setBlock(x1+5, height+8, z1+5, 4);
        world.setBlock(x1+4, height+8, z1+5, 4);
        world.setBlock(x1+1, height+8, z1+4, 4);
        world.setBlock(x1+2, height+8, z1+4, 4);
        world.setBlock(x1+3, height+8, z1+4, 4);
        world.setBlock(x1+5, height+8, z1+4, 4);
        world.setBlock(x1+4, height+8, z1+4, 4);
        world.setBlock(x1+6, height+8, z1+4, 4);
        world.setBlock(x1+7, height+8, z1+5, 4);
        world.setBlock(x1+7, height+8, z1+6, 4);
        world.setBlock(x1+6, height+8, z1+7, 4);
        world.setBlock(x1+5, height+8, z1+7, 4);
        world.setBlock(x1+1, height+8, z1+3, 4);
        world.setBlock(x1+2, height+8, z1+3, 4);
        world.setBlock(x1+3, height+8, z1+3, 4);
        world.setBlock(x1+5, height+8, z1+3, 4);
        world.setBlock(x1+4, height+8, z1+3, 4);
        world.setBlock(x1+6, height+8, z1+3, 4);
        world.setBlock(x1+1, height+8, z1+2, 4);
        world.setBlock(x1+2, height+8, z1+2, 4);
        world.setBlock(x1+3, height+8, z1+2, 4);
        world.setBlock(x1+5, height+8, z1+2, 4);
        world.setBlock(x1+4, height+8, z1+2, 4);
        world.setBlock(x1+6, height+8, z1+2, 4);
        world.setBlock(x1+1, height+8, z1+1, 4);
        world.setBlock(x1+2, height+8, z1+1, 4);
        world.setBlock(x1+3, height+8, z1+1, 4);
        world.setBlock(x1+5, height+8, z1+1, 4);
        world.setBlock(x1+4, height+8, z1+1, 4);
        world.setBlock(x1+6, height+8, z1+1, 4);
        world.setBlock(x1+6, height+9, z1+7, 4);
        world.setBlock(x1+5, height+9, z1+7, 4);
        world.setBlock(x1+4, height+9, z1+7, 4);
        world.setBlock(x1+3, height+9, z1+7, 4);
        world.setBlock(x1+2, height+9, z1+7, 4);
        world.setBlock(x1+1, height+9, z1+7, 4);
        world.setBlock(x1+0, height+9, z1+7, 4);
        world.setBlock(x1+7, height+9, z1+7, 4);
        world.setBlock(x1+6, height+9, z1+0, 4);
        world.setBlock(x1+5, height+9, z1+0, 4);
        world.setBlock(x1+4, height+9, z1+0, 4);
        world.setBlock(x1+3, height+9, z1+0, 4);
        world.setBlock(x1+2, height+9, z1+0, 4);
        world.setBlock(x1+1, height+9, z1+0, 4);
        world.setBlock(x1+0, height+9, z1+0, 4);
        world.setBlock(x1+0, height+9, z1+1, 4);
        world.setBlock(x1+0, height+9, z1+2, 4);
        world.setBlock(x1+0, height+9, z1+3, 4);
        world.setBlock(x1+0, height+9, z1+4, 4);
        world.setBlock(x1+0, height+9, z1+5, 4);
        world.setBlock(x1+0, height+9, z1+6, 98);
        world.setBlock(x1+7, height+9, z1+1, 4);
        world.setBlock(x1+7, height+9, z1+2, 4);
        world.setBlock(x1+7, height+9, z1+3, 4);
        world.setBlock(x1+7, height+9, z1+4, 98);
        world.setBlock(x1+7, height+9, z1+5, 4);
        world.setBlock(x1+7, height+9, z1+6, 4);
        world.setBlock(x1+7, height+9, z1+0, 4);
        world.setBlock(x1+6, height+10, z1+7, 4);
        world.setBlock(x1+5, height+10, z1+7, 4);
        world.setBlock(x1+4, height+10, z1+7, 4);
        world.setBlock(x1+3, height+10, z1+7, 4);
        world.setBlock(x1+2, height+10, z1+7, 4);
        world.setBlock(x1+1, height+10, z1+7, 4);
        world.setBlock(x1+0, height+10, z1+7, 4);
        world.setBlock(x1+7, height+10, z1+7, 4);
        world.setBlock(x1+6, height+10, z1+0, 4);
        world.setBlock(x1+5, height+10, z1+0, 98);
        world.setBlock(x1+4, height+10, z1+0, 4);
        world.setBlock(x1+3, height+10, z1+0, 4);
        world.setBlock(x1+2, height+10, z1+0, 4);
        world.setBlock(x1+1, height+10, z1+0, 4);
        world.setBlock(x1+0, height+10, z1+0, 4);
        world.setBlock(x1+0, height+10, z1+1, 4);
        world.setBlock(x1+0, height+10, z1+2, 4);
        world.setBlock(x1+0, height+10, z1+3, 4);
        world.setBlock(x1+0, height+10, z1+4, 4);
        world.setBlock(x1+0, height+10, z1+5, 4);
        world.setBlock(x1+0, height+10, z1+6, 4);
        world.setBlock(x1+7, height+10, z1+1, 4);
        world.setBlock(x1+7, height+10, z1+2, 4);
        world.setBlock(x1+7, height+10, z1+3, 4);
        world.setBlock(x1+7, height+10, z1+4, 4);
        world.setBlock(x1+7, height+10, z1+5, 4);
        world.setBlock(x1+7, height+10, z1+6, 4);
        world.setBlock(x1+7, height+10, z1+0, 4);
        world.setBlock(x1+6, height+11, z1+7, 4);
        world.setBlock(x1+5, height+11, z1+7, 4);
        world.setBlock(x1+4, height+11, z1+7, 4);
        world.setBlock(x1+3, height+11, z1+7, 4);
        world.setBlock(x1+2, height+11, z1+7, 4);
        world.setBlock(x1+1, height+11, z1+7, 4);
        world.setBlock(x1+0, height+11, z1+7, 4);
        world.setBlock(x1+7, height+11, z1+7, 4);
        world.setBlock(x1+6, height+11, z1+0, 4);
        world.setBlock(x1+5, height+11, z1+0, 4);
        world.setBlock(x1+4, height+11, z1+0, 4);
        world.setBlock(x1+3, height+11, z1+0, 4);
        world.setBlock(x1+2, height+11, z1+0, 4);
        world.setBlock(x1+1, height+11, z1+0, 4);
        world.setBlock(x1+0, height+11, z1+0, 4);
        world.setBlock(x1+0, height+11, z1+1, 4);
        world.setBlock(x1+0, height+11, z1+2, 4);
        world.setBlock(x1+0, height+11, z1+3, 4);
        world.setBlock(x1+0, height+11, z1+4, 4);
        world.setBlock(x1+0, height+11, z1+5, 4);
        world.setBlock(x1+0, height+11, z1+6, 4);
        world.setBlock(x1+7, height+11, z1+1, 4);
        world.setBlock(x1+7, height+11, z1+2, 4);
        world.setBlock(x1+7, height+11, z1+3, 4);
        world.setBlock(x1+7, height+11, z1+4, 4);
        world.setBlock(x1+7, height+11, z1+5, 4);
        world.setBlock(x1+7, height+11, z1+6, 4);
        world.setBlock(x1+7, height+11, z1+0, 4);
        world.setBlock(x1+1, height+12, z1+6, 4);
        world.setBlock(x1+2, height+12, z1+6, 4);
        world.setBlock(x1+3, height+12, z1+6, 4);
        world.setBlock(x1+5, height+12, z1+6, 4);
        world.setBlock(x1+4, height+12, z1+6, 4);
        world.setBlock(x1+6, height+12, z1+6, 98);
        world.setBlock(x1+1, height+12, z1+5, 4);
        world.setBlock(x1+2, height+12, z1+5, 4);
        world.setBlock(x1+3, height+12, z1+5, 4);
        world.setBlock(x1+5, height+12, z1+5, 4);
        world.setBlock(x1+4, height+12, z1+5, 4);
        world.setBlock(x1+6, height+12, z1+5, 4);
        world.setBlock(x1+1, height+12, z1+4, 4);
        world.setBlock(x1+2, height+12, z1+4, 4);
        world.setBlock(x1+3, height+12, z1+4, 4);
        world.setBlock(x1+5, height+12, z1+4, 4);
        world.setBlock(x1+4, height+12, z1+4, 4);
        world.setBlock(x1+6, height+12, z1+4, 4);
        world.setBlock(x1+1, height+12, z1+3, 4);
        world.setBlock(x1+0, height+12, z1+0, 4);
        world.setBlock(x1+0, height+13, z1+0, 4);
        world.setBlock(x1+0, height+12, z1+2, 4);
        world.setBlock(x1+0, height+13, z1+2, 4);
        world.setBlock(x1+0, height+12, z1+4, 4);
        world.setBlock(x1+0, height+13, z1+4, 4);
        world.setBlock(x1+0, height+12, z1+7, 4);
        world.setBlock(x1+0, height+13, z1+7, 4);
        world.setBlock(x1+2, height+12, z1+7, 4);
        world.setBlock(x1+2, height+13, z1+7, 4);
        world.setBlock(x1+5, height+12, z1+7, 4);
        world.setBlock(x1+5, height+13, z1+7, 4);
        world.setBlock(x1+7, height+12, z1+7, 4);
        world.setBlock(x1+7, height+13, z1+7, 4);
        world.setBlock(x1+7, height+12, z1+5, 4);
        world.setBlock(x1+7, height+13, z1+5, 4);
        world.setBlock(x1+7, height+12, z1+2, 4);
        world.setBlock(x1+7, height+13, z1+2, 4);
        world.setBlock(x1+7, height+12, z1+0, 4);
        world.setBlock(x1+7, height+13, z1+0, 4);
        world.setBlock(x1+5, height+12, z1+0, 4);
        world.setBlock(x1+5, height+13, z1+0, 4);
        world.setBlock(x1+3, height+12, z1+0, 4);
        world.setBlock(x1+3, height+13, z1+0, 4);
        world.setBlock(x1+2, height+12, z1+3, 4);
        world.setBlock(x1+3, height+12, z1+3, 4);
        world.setBlock(x1+5, height+12, z1+3, 4);
        world.setBlock(x1+4, height+12, z1+3, 4);
        world.setBlock(x1+6, height+12, z1+3, 4);
        world.setBlock(x1+1, height+12, z1+2, 4);
        world.setBlock(x1+2, height+12, z1+2, 98);
        world.setBlock(x1+3, height+12, z1+2, 4);
        world.setBlock(x1+5, height+12, z1+2, 4);
        world.setBlock(x1+4, height+12, z1+2, 4);
        world.setBlock(x1+6, height+12, z1+2, 4);
        world.setBlock(x1+1, height+12, z1+1, 4);
        world.setBlock(x1+2, height+12, z1+1, 4);
        world.setBlock(x1+3, height+12, z1+1, 4);
        world.setBlock(x1+5, height+12, z1+1, 4);
        world.setBlock(x1+4, height+12, z1+1, 4);
        world.setBlock(x1+6, height+12, z1+1, 4);
        world.setBlock(x1+7, height+0, z1+0, 4);
        world.setBlock(x1+7, height+1, z1+0, 4);
        world.setBlock(x1+7, height+2, z1+0, 4);
        world.setBlock(x1+7, height+3, z1+0, 4);
        world.setBlock(x1+7, height+4, z1+0, 4);
        world.setBlock(x1+0, height+0, z1+0, 4);
        world.setBlock(x1+0, height+1, z1+0, 4);
        world.setBlock(x1+0, height+2, z1+0, 4);
        world.setBlock(x1+0, height+3, z1+0, 4);
        world.setBlock(x1+0, height+4, z1+0, 4);
        world.setBlock(x1+0, height+0, z1+7, 4);
        world.setBlock(x1+0, height+1, z1+7, 4);
        world.setBlock(x1+0, height+2, z1+7, 4);
        world.setBlock(x1+0, height+3, z1+7, 4);
        world.setBlock(x1+0, height+4, z1+7, 4);
        world.setBlock(x1+7, height+0, z1+7, 4);
        world.setBlock(x1+7, height+1, z1+7, 4);
        world.setBlock(x1+7, height+2, z1+7, 4);
        world.setBlock(x1+7, height+3, z1+7, 4);
        world.setBlock(x1+7, height+4, z1+7, 4);
        world.setBlock(x1+4, height+0, z1+1, 4);
        world.setBlock(x1+5, height+0, z1+1, 98);
        world.setBlock(x1+6, height+0, z1+1, 4);
        world.setBlock(x1+4, height+0, z1+6, 4);
        world.setBlock(x1+5, height+0, z1+6, 4);
        world.setBlock(x1+6, height+0, z1+6, 4);
        world.setBlock(x1+6, height+0, z1+5, 4);
        world.setBlock(x1+6, height+0, z1+4, 4);
        world.setBlock(x1+6, height+1, z1+4, 98);
        world.setBlock(x1+6, height+1, z1+5, 4);
        world.setBlock(x1+6, height+1, z1+6, 4);
        world.setBlock(x1+6, height+2, z1+6, 4);
        world.setBlock(x1+5, height+1, z1+6, 4);
        world.setBlock(x1+4, height+1, z1+6, 4);
        world.setBlock(x1+6, height+0, z1+3, 4);
        world.setBlock(x1+6, height+0, z1+2, 4);
        world.setBlock(x1+6, height+1, z1+2, 4);
        world.setBlock(x1+6, height+2, z1+2, 4);
        world.setBlock(x1+6, height+2, z1+3, 4);
        world.setBlock(x1+6, height+1, z1+1, 4);
        world.setBlock(x1+5, height+1, z1+1, 4);
        world.setBlock(x1+6, height+2, z1+4, 4);
        world.setBlock(x1+6, height+3, z1+4, 4);
        world.setBlock(x1+6, height+3, z1+3, 4);
        world.setBlock(x1+6, height+3, z1+5, 4);
        world.setBlock(x1+5, height+3, z1+6, 4);
    }

    private void spawnFlought(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        world.setBlock(x1+0, height+7, z1+4, 4);
        world.setBlock(x1+0, height+7, z1+5, 98);
        world.setBlock(x1+0, height+8, z1+6, 4);
        world.setBlock(x1+0, height+9, z1+7, 4);
        world.setBlock(x1+0, height+10, z1+7, 4);
        world.setBlock(x1+0, height+7, z1+7, 4);
        world.setBlock(x1+0, height+6, z1+7, 4);
        world.setBlock(x1+0, height+5, z1+7, 4);
        world.setBlock(x1+0, height+4, z1+6, 4);
        world.setBlock(x1+0, height+3, z1+6, 4);
        world.setBlock(x1+0, height+2, z1+5, 4);
        world.setBlock(x1+0, height+5, z1+5, 4);
        world.setBlock(x1+0, height+6, z1+6, 4);
        world.setBlock(x1+0, height+10, z1+4, 155);
        world.setBlock(x1+0, height+13, z1+4, 4);
        world.setBlock(x1+0, height+13, z1+3, 4);
        world.setBlock(x1+0, height+12, z1+2, 4);
        world.setBlock(x1+0, height+11, z1+1, 4);
        world.setBlock(x1+0, height+10, z1+1, 4);
        world.setBlock(x1+0, height+12, z1+1, 4);
        world.setBlock(x1+0, height+13, z1+0, 4);
        world.setBlock(x1+0, height+15, z1+0, 4);
        world.setBlock(x1+0, height+14, z1+1, 4);
        world.setBlock(x1+0, height+16, z1+1, 4);
        world.setBlock(x1+0, height+17, z1+1, 4);
        world.setBlock(x1+0, height+14, z1+3, 4);
        world.setBlock(x1+0, height+19, z1+3, 4);
        world.setBlock(x1+0, height+18, z1+3, 4);
    }

    private void spawnTower1(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        world.setBlock(x1+2, height+0, z1+0, 4);
        world.setBlock(x1+3, height+0, z1+0, 4);
        world.setBlock(x1+4, height+0, z1+0, 4);
        world.setBlock(x1+5, height+0, z1+0, 4);
        world.setBlock(x1+6, height+0, z1+0, 4);
        world.setBlock(x1+7, height+0, z1+0, 4);
        world.setBlock(x1+8, height+0, z1+0, 4);
        world.setBlock(x1+9, height+0, z1+1, 4);
        world.setBlock(x1+10, height+0, z1+2, 4);
        world.setBlock(x1+10, height+0, z1+3, 4);
        world.setBlock(x1+10, height+0, z1+4, 4);
        world.setBlock(x1+10, height+0, z1+5, 4);
        world.setBlock(x1+10, height+0, z1+6, 4);
        world.setBlock(x1+10, height+0, z1+7, 4);
        world.setBlock(x1+10, height+0, z1+8, 4);
        world.setBlock(x1+9, height+0, z1+9, 4);
        world.setBlock(x1+8, height+0, z1+10, 4);
        world.setBlock(x1+7, height+0, z1+10, 4);
        world.setBlock(x1+6, height+0, z1+10, 4);
        world.setBlock(x1+5, height+0, z1+10, 4);
        world.setBlock(x1+4, height+0, z1+10, 4);
        world.setBlock(x1+3, height+0, z1+10, 4);
        world.setBlock(x1+2, height+0, z1+10, 4);
        world.setBlock(x1+1, height+0, z1+1, 4);
        world.setBlock(x1+1, height+0, z1+9, 4);
        world.setBlock(x1+0, height+0, z1+2, 4);
        world.setBlock(x1+0, height+0, z1+3, 4);
        world.setBlock(x1+0, height+0, z1+4, 4);
        world.setBlock(x1+0, height+0, z1+6, 4);
        world.setBlock(x1+0, height+0, z1+7, 4);
        world.setBlock(x1+0, height+0, z1+8, 4);
        world.setBlock(x1+2, height+1, z1+0, 4);
        world.setBlock(x1+3, height+1, z1+0, 4);
        world.setBlock(x1+4, height+1, z1+0, 4);
        world.setBlock(x1+5, height+1, z1+0, 4);
        world.setBlock(x1+6, height+1, z1+0, 4);
        world.setBlock(x1+7, height+1, z1+0, 4);
        world.setBlock(x1+8, height+1, z1+0, 4);
        world.setBlock(x1+9, height+1, z1+1, 4);
        world.setBlock(x1+10, height+1, z1+2, 4);
        world.setBlock(x1+10, height+1, z1+3, 4);
        world.setBlock(x1+10, height+1, z1+4, 4);
        world.setBlock(x1+10, height+1, z1+5, 4);
        world.setBlock(x1+10, height+1, z1+6, 4);
        world.setBlock(x1+10, height+1, z1+7, 4);
        world.setBlock(x1+10, height+1, z1+8, 4);
        world.setBlock(x1+9, height+1, z1+9, 4);
        world.setBlock(x1+8, height+1, z1+10, 4);
        world.setBlock(x1+7, height+1, z1+10, 4);
        world.setBlock(x1+6, height+1, z1+10, 4);
        world.setBlock(x1+5, height+1, z1+10, 4);
        world.setBlock(x1+4, height+1, z1+10, 4);
        world.setBlock(x1+3, height+1, z1+10, 4);
        world.setBlock(x1+2, height+1, z1+10, 4);
        world.setBlock(x1+1, height+1, z1+1, 4);
        world.setBlock(x1+1, height+1, z1+9, 4);
        world.setBlock(x1+0, height+1, z1+2, 4);
        world.setBlock(x1+0, height+1, z1+3, 4);
        world.setBlock(x1+0, height+1, z1+4, 4);
        world.setBlock(x1+0, height+1, z1+6, 4);
        world.setBlock(x1+0, height+1, z1+7, 4);
        world.setBlock(x1+0, height+1, z1+8, 4);
        world.setBlock(x1+2, height+2, z1+0, 4);
        world.setBlock(x1+3, height+2, z1+0, 4);
        world.setBlock(x1+4, height+2, z1+0, 4);
        world.setBlock(x1+5, height+2, z1+0, 4);
        world.setBlock(x1+6, height+2, z1+0, 4);
        world.setBlock(x1+7, height+2, z1+0, 4);
        world.setBlock(x1+8, height+2, z1+0, 4);
        world.setBlock(x1+9, height+2, z1+1, 4);
        world.setBlock(x1+10, height+2, z1+2, 4);
        world.setBlock(x1+10, height+2, z1+3, 4);
        world.setBlock(x1+10, height+2, z1+4, 4);
        world.setBlock(x1+10, height+2, z1+5, 4);
        world.setBlock(x1+10, height+2, z1+6, 4);
        world.setBlock(x1+10, height+2, z1+7, 4);
        world.setBlock(x1+10, height+2, z1+8, 4);
        world.setBlock(x1+9, height+2, z1+9, 4);
        world.setBlock(x1+8, height+2, z1+10, 4);
        world.setBlock(x1+7, height+2, z1+10, 4);
        world.setBlock(x1+6, height+2, z1+10, 4);
        world.setBlock(x1+5, height+2, z1+10, 4);
        world.setBlock(x1+4, height+2, z1+10, 4);
        world.setBlock(x1+3, height+2, z1+10, 4);
        world.setBlock(x1+2, height+2, z1+10, 4);
        world.setBlock(x1+1, height+2, z1+1, 4);
        world.setBlock(x1+1, height+2, z1+9, 4);
        world.setBlock(x1+0, height+2, z1+2, 4);
        world.setBlock(x1+0, height+2, z1+3, 4);
        world.setBlock(x1+0, height+2, z1+4, 4);
        world.setBlock(x1+0, height+2, z1+6, 4);
        world.setBlock(x1+0, height+2, z1+7, 4);
        world.setBlock(x1+0, height+2, z1+8, 4);
        world.setBlock(x1+2, height+3, z1+0, 4);
        world.setBlock(x1+3, height+3, z1+0, 4);
        world.setBlock(x1+4, height+3, z1+0, 4);
        world.setBlock(x1+5, height+3, z1+0, 4);
        world.setBlock(x1+6, height+3, z1+0, 4);
        world.setBlock(x1+7, height+3, z1+0, 4);
        world.setBlock(x1+8, height+3, z1+0, 4);
        world.setBlock(x1+9, height+3, z1+1, 4);
        world.setBlock(x1+10, height+3, z1+2, 4);
        world.setBlock(x1+10, height+3, z1+3, 4);
        world.setBlock(x1+10, height+3, z1+4, 4);
        world.setBlock(x1+10, height+3, z1+5, 4);
        world.setBlock(x1+10, height+3, z1+6, 4);
        world.setBlock(x1+10, height+3, z1+7, 4);
        world.setBlock(x1+10, height+3, z1+8, 4);
        world.setBlock(x1+9, height+3, z1+9, 4);
        world.setBlock(x1+8, height+3, z1+10, 4);
        world.setBlock(x1+7, height+3, z1+10, 4);
        world.setBlock(x1+6, height+3, z1+10, 4);
        world.setBlock(x1+5, height+3, z1+10, 4);
        world.setBlock(x1+4, height+3, z1+10, 4);
        world.setBlock(x1+3, height+3, z1+10, 4);
        world.setBlock(x1+2, height+3, z1+10, 4);
        world.setBlock(x1+1, height+3, z1+1, 4);
        world.setBlock(x1+1, height+3, z1+9, 4);
        world.setBlock(x1+0, height+3, z1+2, 4);
        world.setBlock(x1+0, height+3, z1+3, 4);
        world.setBlock(x1+0, height+3, z1+4, 4);
        world.setBlock(x1+0, height+3, z1+5, 4);
        world.setBlock(x1+0, height+3, z1+6, 4);
        world.setBlock(x1+0, height+3, z1+7, 4);
        world.setBlock(x1+0, height+3, z1+8, 4);
        world.setBlock(x1+2, height+4, z1+0, 4);
        world.setBlock(x1+3, height+4, z1+0, 4);
        world.setBlock(x1+4, height+4, z1+0, 4);
        world.setBlock(x1+5, height+4, z1+0, 4);
        world.setBlock(x1+6, height+4, z1+0, 4);
        world.setBlock(x1+7, height+4, z1+0, 4);
        world.setBlock(x1+8, height+4, z1+0, 4);
        world.setBlock(x1+9, height+4, z1+1, 4);
        world.setBlock(x1+10, height+4, z1+2, 4);
        world.setBlock(x1+10, height+4, z1+3, 4);
        world.setBlock(x1+10, height+4, z1+4, 4);
        world.setBlock(x1+10, height+4, z1+5, 4);
        world.setBlock(x1+10, height+4, z1+6, 4);
        world.setBlock(x1+10, height+4, z1+7, 4);
        world.setBlock(x1+10, height+4, z1+8, 4);
        world.setBlock(x1+9, height+4, z1+9, 4);
        world.setBlock(x1+8, height+4, z1+10, 4);
        world.setBlock(x1+7, height+4, z1+10, 4);
        world.setBlock(x1+6, height+4, z1+10, 4);
        world.setBlock(x1+5, height+4, z1+10, 4);
        world.setBlock(x1+4, height+4, z1+10, 4);
        world.setBlock(x1+3, height+4, z1+10, 4);
        world.setBlock(x1+3, height+4, z1+9, 4);
        world.setBlock(x1+7, height+4, z1+1, 4);
        world.setBlock(x1+6, height+4, z1+1, 4);
        world.setBlock(x1+4, height+4, z1+9, 4);
        world.setBlock(x1+2, height+4, z1+10, 4);
        world.setBlock(x1+1, height+4, z1+1, 4);
        world.setBlock(x1+1, height+4, z1+9, 4);
        world.setBlock(x1+0, height+4, z1+2, 4);
        world.setBlock(x1+0, height+4, z1+3, 4);
        world.setBlock(x1+0, height+4, z1+4, 4);
        world.setBlock(x1+0, height+4, z1+5, 4);
        world.setBlock(x1+0, height+4, z1+6, 4);
        world.setBlock(x1+0, height+4, z1+7, 4);
        world.setBlock(x1+1, height+4, z1+7, 4);
        world.setBlock(x1+2, height+4, z1+7, 4);
        world.setBlock(x1+2, height+4, z1+8, 4);
        world.setBlock(x1+1, height+4, z1+8, 4);
        world.setBlock(x1+1, height+4, z1+2, 4);
        world.setBlock(x1+2, height+4, z1+2, 4);
        world.setBlock(x1+2, height+4, z1+3, 4);
        world.setBlock(x1+1, height+4, z1+3, 4);
        world.setBlock(x1+8, height+4, z1+2, 4);
        world.setBlock(x1+9, height+4, z1+2, 4);
        world.setBlock(x1+9, height+4, z1+3, 4);
        world.setBlock(x1+8, height+4, z1+3, 4);
        world.setBlock(x1+8, height+4, z1+7, 4);
        world.setBlock(x1+9, height+4, z1+7, 4);
        world.setBlock(x1+9, height+4, z1+8, 4);
        world.setBlock(x1+8, height+4, z1+8, 4);
        world.setBlock(x1+6, height+4, z1+8, 4);
        world.setBlock(x1+7, height+4, z1+8, 4);
        world.setBlock(x1+7, height+4, z1+9, 4);
        world.setBlock(x1+6, height+4, z1+9, 4);
        world.setBlock(x1+6, height+4, z1+6, 4);
        world.setBlock(x1+7, height+4, z1+6, 4);
        world.setBlock(x1+8, height+3, z1+6, 4);
        world.setBlock(x1+8, height+2, z1+5, 4);
        world.setBlock(x1+8, height+1, z1+4, 4);
        world.setBlock(x1+9, height+0, z1+4, 4);
        world.setBlock(x1+7, height+4, z1+7, 4);
        world.setBlock(x1+6, height+4, z1+7, 4);
        world.setBlock(x1+6, height+4, z1+4, 4);
        world.setBlock(x1+7, height+4, z1+4, 4);
        world.setBlock(x1+7, height+4, z1+5, 4);
        world.setBlock(x1+6, height+4, z1+5, 4);
        world.setBlock(x1+6, height+4, z1+2, 4);
        world.setBlock(x1+7, height+4, z1+2, 4);
        world.setBlock(x1+7, height+4, z1+3, 4);
        world.setBlock(x1+6, height+4, z1+3, 4);
        world.setBlock(x1+3, height+4, z1+1, 4);
        world.setBlock(x1+4, height+4, z1+1, 4);
        world.setBlock(x1+4, height+4, z1+2, 4);
        world.setBlock(x1+3, height+4, z1+2, 4);
        world.setBlock(x1+3, height+4, z1+3, 4);
        world.setBlock(x1+4, height+4, z1+3, 4);
        world.setBlock(x1+4, height+4, z1+4, 4);
        world.setBlock(x1+3, height+4, z1+4, 4);
        world.setBlock(x1+3, height+4, z1+5, 4);
        world.setBlock(x1+4, height+4, z1+5, 4);
        world.setBlock(x1+5, height+4, z1+5, 4);
        world.setBlock(x1+5, height+4, z1+7, 4);
        world.setBlock(x1+5, height+4, z1+3, 4);
        world.setBlock(x1+4, height+4, z1+6, 4);
        world.setBlock(x1+3, height+4, z1+6, 4);
        world.setBlock(x1+3, height+4, z1+7, 4);
        world.setBlock(x1+4, height+4, z1+7, 4);
        world.setBlock(x1+4, height+4, z1+8, 4);
        world.setBlock(x1+3, height+4, z1+8, 4);
        world.setBlock(x1+0, height+4, z1+8, 4);
        world.setBlock(x1+2, height+5, z1+0, 4);
        world.setBlock(x1+3, height+5, z1+0, 4);
        world.setBlock(x1+4, height+5, z1+0, 4);
        world.setBlock(x1+5, height+5, z1+0, 4);
        world.setBlock(x1+6, height+5, z1+0, 4);
        world.setBlock(x1+7, height+5, z1+0, 4);
        world.setBlock(x1+8, height+5, z1+0, 4);
        world.setBlock(x1+9, height+5, z1+1, 4);
        world.setBlock(x1+10, height+5, z1+2, 4);
        world.setBlock(x1+10, height+5, z1+3, 4);
        world.setBlock(x1+10, height+5, z1+4, 4);
        world.setBlock(x1+10, height+5, z1+5, 4);
        world.setBlock(x1+10, height+5, z1+6, 4);
        world.setBlock(x1+10, height+5, z1+7, 4);
        world.setBlock(x1+10, height+5, z1+8, 4);
        world.setBlock(x1+9, height+5, z1+9, 4);
        world.setBlock(x1+8, height+5, z1+10, 4);
        world.setBlock(x1+7, height+5, z1+10, 4);
        world.setBlock(x1+6, height+5, z1+10, 4);
        world.setBlock(x1+5, height+5, z1+10, 4);
        world.setBlock(x1+4, height+5, z1+10, 4);
        world.setBlock(x1+3, height+5, z1+10, 4);
        world.setBlock(x1+2, height+5, z1+10, 4);
        world.setBlock(x1+1, height+5, z1+1, 4);
        world.setBlock(x1+1, height+5, z1+9, 4);
        world.setBlock(x1+0, height+5, z1+2, 4);
        world.setBlock(x1+0, height+5, z1+3, 4);
        world.setBlock(x1+0, height+5, z1+4, 4);
        world.setBlock(x1+0, height+5, z1+5, 4);
        world.setBlock(x1+0, height+5, z1+6, 4);
        world.setBlock(x1+0, height+5, z1+7, 4);
        world.setBlock(x1+0, height+5, z1+8, 4);
        world.setBlock(x1+2, height+6, z1+0, 4);
        world.setBlock(x1+3, height+6, z1+0, 4);
        world.setBlock(x1+4, height+6, z1+0, 4);
        world.setBlock(x1+5, height+6, z1+0, 4);
        world.setBlock(x1+6, height+6, z1+0, 4);
        world.setBlock(x1+7, height+6, z1+0, 4);
        world.setBlock(x1+8, height+6, z1+0, 4);
        world.setBlock(x1+9, height+6, z1+1, 4);
        world.setBlock(x1+10, height+6, z1+2, 4);
        world.setBlock(x1+10, height+6, z1+3, 4);
        world.setBlock(x1+10, height+6, z1+4, 4);
        world.setBlock(x1+10, height+6, z1+5, 4);
        world.setBlock(x1+10, height+6, z1+6, 4);
        world.setBlock(x1+10, height+6, z1+7, 4);
        world.setBlock(x1+10, height+6, z1+8, 4);
        world.setBlock(x1+9, height+6, z1+9, 4);
        world.setBlock(x1+8, height+6, z1+10, 4);
        world.setBlock(x1+7, height+6, z1+10, 4);
        world.setBlock(x1+6, height+6, z1+10, 4);
        world.setBlock(x1+5, height+6, z1+10, 4);
        world.setBlock(x1+4, height+6, z1+10, 4);
        world.setBlock(x1+3, height+6, z1+10, 4);
        world.setBlock(x1+2, height+6, z1+10, 4);
        world.setBlock(x1+1, height+6, z1+1, 4);
        world.setBlock(x1+1, height+6, z1+9, 4);
        world.setBlock(x1+0, height+6, z1+2, 4);
        world.setBlock(x1+0, height+6, z1+3, 4);
        world.setBlock(x1+0, height+6, z1+4, 4);
        world.setBlock(x1+0, height+6, z1+5, 4);
        world.setBlock(x1+0, height+6, z1+6, 4);
        world.setBlock(x1+0, height+6, z1+7, 4);
        world.setBlock(x1+0, height+6, z1+8, 4);
        world.setBlock(x1+2, height+7, z1+0, 4);
        world.setBlock(x1+3, height+7, z1+0, 4);
        world.setBlock(x1+4, height+7, z1+0, 4);
        world.setBlock(x1+5, height+7, z1+0, 4);
        world.setBlock(x1+6, height+7, z1+0, 4);
        world.setBlock(x1+7, height+7, z1+0, 4);
        world.setBlock(x1+8, height+7, z1+0, 4);
        world.setBlock(x1+9, height+7, z1+1, 4);
        world.setBlock(x1+10, height+7, z1+2, 4);
        world.setBlock(x1+10, height+7, z1+3, 4);
        world.setBlock(x1+10, height+7, z1+4, 4);
        world.setBlock(x1+10, height+7, z1+5, 4);
        world.setBlock(x1+10, height+7, z1+6, 4);
        world.setBlock(x1+10, height+7, z1+7, 4);
        world.setBlock(x1+10, height+7, z1+8, 4);
        world.setBlock(x1+9, height+7, z1+9, 4);
        world.setBlock(x1+8, height+7, z1+10, 4);
        world.setBlock(x1+7, height+7, z1+10, 4);
        world.setBlock(x1+6, height+7, z1+10, 4);
        world.setBlock(x1+5, height+7, z1+10, 4);
        world.setBlock(x1+4, height+7, z1+10, 4);
        world.setBlock(x1+3, height+7, z1+10, 4);
        world.setBlock(x1+2, height+7, z1+10, 4);
        world.setBlock(x1+1, height+7, z1+1, 4);
        world.setBlock(x1+1, height+7, z1+9, 4);
        world.setBlock(x1+0, height+7, z1+2, 4);
        world.setBlock(x1+0, height+7, z1+3, 4);
        world.setBlock(x1+0, height+7, z1+4, 4);
        world.setBlock(x1+0, height+7, z1+5, 4);
        world.setBlock(x1+0, height+7, z1+6, 4);
        world.setBlock(x1+0, height+7, z1+7, 4);
        world.setBlock(x1+0, height+7, z1+8, 4);
        world.setBlock(x1+2, height+8, z1+0, 4);
        world.setBlock(x1+3, height+8, z1+0, 4);
        world.setBlock(x1+4, height+8, z1+0, 4);
        world.setBlock(x1+5, height+8, z1+0, 4);
        world.setBlock(x1+6, height+8, z1+0, 4);
        world.setBlock(x1+7, height+8, z1+0, 4);
        world.setBlock(x1+8, height+8, z1+0, 4);
        world.setBlock(x1+9, height+8, z1+1, 4);
        world.setBlock(x1+10, height+8, z1+2, 4);
        world.setBlock(x1+10, height+8, z1+3, 4);
        world.setBlock(x1+10, height+8, z1+4, 4);
        world.setBlock(x1+10, height+8, z1+5, 4);
        world.setBlock(x1+10, height+8, z1+6, 4);
        world.setBlock(x1+10, height+8, z1+7, 4);
        world.setBlock(x1+10, height+8, z1+8, 4);
        world.setBlock(x1+9, height+8, z1+9, 4);
        world.setBlock(x1+8, height+8, z1+10, 4);
        world.setBlock(x1+7, height+8, z1+10, 4);
        world.setBlock(x1+6, height+8, z1+10, 4);
        world.setBlock(x1+5, height+8, z1+10, 4);
        world.setBlock(x1+4, height+8, z1+10, 4);
        world.setBlock(x1+3, height+8, z1+10, 4);
        world.setBlock(x1+2, height+8, z1+10, 4);
        world.setBlock(x1+1, height+8, z1+1, 4);
        world.setBlock(x1+1, height+8, z1+9, 4);
        world.setBlock(x1+0, height+8, z1+2, 4);
        world.setBlock(x1+0, height+8, z1+3, 4);
        world.setBlock(x1+0, height+8, z1+4, 4);
        world.setBlock(x1+0, height+8, z1+5, 4);
        world.setBlock(x1+0, height+8, z1+6, 4);
        world.setBlock(x1+0, height+8, z1+7, 4);
        world.setBlock(x1+0, height+8, z1+8, 4);
        world.setBlock(x1+2, height+9, z1+0, 4);
        world.setBlock(x1+3, height+9, z1+0, 4);
        world.setBlock(x1+4, height+9, z1+0, 4);
        world.setBlock(x1+5, height+9, z1+0, 4);
        world.setBlock(x1+6, height+9, z1+0, 4);
        world.setBlock(x1+7, height+9, z1+0, 4);
        world.setBlock(x1+8, height+9, z1+0, 4);
        world.setBlock(x1+9, height+9, z1+1, 4);
        world.setBlock(x1+10, height+9, z1+2, 4);
        world.setBlock(x1+10, height+9, z1+3, 4);
        world.setBlock(x1+10, height+9, z1+4, 4);
        world.setBlock(x1+10, height+9, z1+5, 4);
        world.setBlock(x1+10, height+9, z1+6, 4);
        world.setBlock(x1+10, height+9, z1+7, 4);
        world.setBlock(x1+10, height+9, z1+8, 4);
        world.setBlock(x1+9, height+9, z1+9, 4);
        world.setBlock(x1+8, height+9, z1+10, 4);
        world.setBlock(x1+7, height+9, z1+10, 4);
        world.setBlock(x1+6, height+9, z1+10, 4);
        world.setBlock(x1+5, height+9, z1+10, 4);
        world.setBlock(x1+4, height+9, z1+10, 4);
        world.setBlock(x1+3, height+9, z1+10, 4);
        world.setBlock(x1+3, height+9, z1+9, 4);
        world.setBlock(x1+7, height+9, z1+1, 4);
        world.setBlock(x1+6, height+9, z1+1, 4);
        world.setBlock(x1+4, height+9, z1+9, 4);
        world.setBlock(x1+2, height+9, z1+10, 4);
        world.setBlock(x1+1, height+9, z1+1, 4);
        world.setBlock(x1+1, height+9, z1+9, 4);
        world.setBlock(x1+0, height+9, z1+2, 4);
        world.setBlock(x1+0, height+9, z1+3, 4);
        world.setBlock(x1+0, height+9, z1+4, 4);
        world.setBlock(x1+0, height+9, z1+5, 4);
        world.setBlock(x1+0, height+9, z1+6, 4);
        world.setBlock(x1+0, height+9, z1+7, 4);
        world.setBlock(x1+1, height+9, z1+7, 4);
        world.setBlock(x1+2, height+9, z1+7, 4);
        world.setBlock(x1+2, height+9, z1+8, 4);
        world.setBlock(x1+1, height+9, z1+8, 4);
        world.setBlock(x1+1, height+9, z1+2, 4);
        world.setBlock(x1+2, height+9, z1+2, 4);
        world.setBlock(x1+2, height+9, z1+3, 4);
        world.setBlock(x1+1, height+9, z1+3, 4);
        world.setBlock(x1+8, height+9, z1+2, 4);
        world.setBlock(x1+9, height+9, z1+2, 4);
        world.setBlock(x1+9, height+9, z1+3, 4);
        world.setBlock(x1+8, height+9, z1+3, 4);
        world.setBlock(x1+8, height+9, z1+7, 4);
        world.setBlock(x1+9, height+9, z1+7, 4);
        world.setBlock(x1+9, height+9, z1+8, 4);
        world.setBlock(x1+8, height+9, z1+8, 4);
        world.setBlock(x1+6, height+9, z1+8, 4);
        world.setBlock(x1+7, height+9, z1+8, 4);
        world.setBlock(x1+7, height+9, z1+9, 4);
        world.setBlock(x1+6, height+9, z1+9, 4);
        world.setBlock(x1+6, height+9, z1+6, 4);
        world.setBlock(x1+7, height+9, z1+6, 4);
        world.setBlock(x1+8, height+8, z1+6, 4);
        world.setBlock(x1+8, height+7, z1+5, 4);
        world.setBlock(x1+8, height+6, z1+4, 4);
        world.setBlock(x1+9, height+5, z1+4, 4);
        world.setBlock(x1+7, height+9, z1+7, 4);
        world.setBlock(x1+6, height+9, z1+7, 4);
        world.setBlock(x1+6, height+9, z1+4, 4);
        world.setBlock(x1+7, height+9, z1+4, 4);
        world.setBlock(x1+7, height+9, z1+5, 4);
        world.setBlock(x1+6, height+9, z1+5, 4);
        world.setBlock(x1+6, height+9, z1+2, 4);
        world.setBlock(x1+7, height+9, z1+2, 4);
        world.setBlock(x1+7, height+9, z1+3, 4);
        world.setBlock(x1+6, height+9, z1+3, 4);
        world.setBlock(x1+3, height+9, z1+1, 4);
        world.setBlock(x1+4, height+9, z1+1, 4);
        world.setBlock(x1+4, height+9, z1+2, 4);
        world.setBlock(x1+3, height+9, z1+2, 4);
        world.setBlock(x1+3, height+9, z1+3, 4);
        world.setBlock(x1+4, height+9, z1+3, 4);
        world.setBlock(x1+4, height+9, z1+4, 4);
        world.setBlock(x1+3, height+9, z1+4, 4);
        world.setBlock(x1+3, height+9, z1+5, 4);
        world.setBlock(x1+4, height+9, z1+5, 4);
        world.setBlock(x1+5, height+9, z1+5, 4);
        world.setBlock(x1+5, height+9, z1+7, 4);
        world.setBlock(x1+5, height+9, z1+3, 4);
        world.setBlock(x1+4, height+9, z1+6, 4);
        world.setBlock(x1+3, height+9, z1+6, 4);
        world.setBlock(x1+3, height+9, z1+7, 4);
        world.setBlock(x1+4, height+9, z1+7, 4);
        world.setBlock(x1+4, height+9, z1+8, 4);
        world.setBlock(x1+3, height+9, z1+8, 4);
        world.setBlock(x1+0, height+9, z1+8, 4);
        world.setBlock(x1+2, height+10, z1+0, 4);
        world.setBlock(x1+3, height+10, z1+0, 4);
        world.setBlock(x1+4, height+10, z1+0, 4);
        world.setBlock(x1+5, height+10, z1+0, 4);
        world.setBlock(x1+6, height+10, z1+0, 4);
        world.setBlock(x1+7, height+10, z1+0, 4);
        world.setBlock(x1+8, height+10, z1+0, 4);
        world.setBlock(x1+9, height+10, z1+1, 4);
        world.setBlock(x1+10, height+10, z1+2, 4);
        world.setBlock(x1+10, height+10, z1+3, 4);
        world.setBlock(x1+10, height+10, z1+4, 4);
        world.setBlock(x1+10, height+10, z1+5, 4);
        world.setBlock(x1+10, height+10, z1+6, 4);
        world.setBlock(x1+10, height+10, z1+7, 4);
        world.setBlock(x1+10, height+10, z1+8, 4);
        world.setBlock(x1+9, height+10, z1+9, 4);
        world.setBlock(x1+8, height+10, z1+10, 4);
        world.setBlock(x1+7, height+10, z1+10, 4);
        world.setBlock(x1+6, height+10, z1+10, 4);
        world.setBlock(x1+5, height+10, z1+10, 4);
        world.setBlock(x1+4, height+10, z1+10, 4);
        world.setBlock(x1+3, height+10, z1+10, 4);
        world.setBlock(x1+2, height+10, z1+10, 4);
        world.setBlock(x1+1, height+10, z1+1, 4);
        world.setBlock(x1+1, height+10, z1+9, 4);
        world.setBlock(x1+0, height+10, z1+2, 4);
        world.setBlock(x1+0, height+10, z1+3, 4);
        world.setBlock(x1+0, height+10, z1+4, 4);
        world.setBlock(x1+0, height+10, z1+5, 4);
        world.setBlock(x1+0, height+10, z1+6, 4);
        world.setBlock(x1+0, height+10, z1+7, 4);
        world.setBlock(x1+0, height+10, z1+8, 4);
        world.setBlock(x1+2, height+11, z1+0, 4);
        world.setBlock(x1+3, height+11, z1+0, 4);
        world.setBlock(x1+4, height+11, z1+0, 4);
        world.setBlock(x1+5, height+11, z1+0, 4);
        world.setBlock(x1+6, height+11, z1+0, 4);
        world.setBlock(x1+7, height+11, z1+0, 4);
        world.setBlock(x1+8, height+11, z1+0, 4);
        world.setBlock(x1+9, height+11, z1+1, 4);
        world.setBlock(x1+10, height+11, z1+2, 4);
        world.setBlock(x1+10, height+11, z1+3, 4);
        world.setBlock(x1+10, height+11, z1+4, 4);
        world.setBlock(x1+10, height+11, z1+5, 4);
        world.setBlock(x1+10, height+11, z1+6, 4);
        world.setBlock(x1+10, height+11, z1+7, 4);
        world.setBlock(x1+10, height+11, z1+8, 4);
        world.setBlock(x1+9, height+11, z1+9, 4);
        world.setBlock(x1+8, height+11, z1+10, 4);
        world.setBlock(x1+7, height+11, z1+10, 4);
        world.setBlock(x1+6, height+11, z1+10, 4);
        world.setBlock(x1+5, height+11, z1+10, 4);
        world.setBlock(x1+4, height+11, z1+10, 4);
        world.setBlock(x1+3, height+11, z1+10, 4);
        world.setBlock(x1+2, height+11, z1+10, 4);
        world.setBlock(x1+1, height+11, z1+1, 4);
        world.setBlock(x1+1, height+11, z1+9, 4);
        world.setBlock(x1+0, height+11, z1+2, 4);
        world.setBlock(x1+0, height+11, z1+3, 4);
        world.setBlock(x1+0, height+11, z1+4, 4);
        world.setBlock(x1+0, height+11, z1+5, 4);
        world.setBlock(x1+0, height+11, z1+6, 4);
        world.setBlock(x1+0, height+11, z1+7, 4);
        world.setBlock(x1+0, height+11, z1+8, 4);
        world.setBlock(x1+2, height+12, z1+0, 4);
        world.setBlock(x1+3, height+12, z1+0, 4);
        world.setBlock(x1+4, height+12, z1+0, 4);
        world.setBlock(x1+5, height+12, z1+0, 4);
        world.setBlock(x1+6, height+12, z1+0, 4);
        world.setBlock(x1+7, height+12, z1+0, 4);
        world.setBlock(x1+8, height+12, z1+0, 4);
        world.setBlock(x1+9, height+12, z1+1, 4);
        world.setBlock(x1+10, height+12, z1+2, 4);
        world.setBlock(x1+10, height+12, z1+3, 4);
        world.setBlock(x1+10, height+12, z1+4, 4);
        world.setBlock(x1+10, height+12, z1+5, 4);
        world.setBlock(x1+10, height+12, z1+6, 4);
        world.setBlock(x1+10, height+12, z1+7, 4);
        world.setBlock(x1+10, height+12, z1+8, 4);
        world.setBlock(x1+9, height+12, z1+9, 4);
        world.setBlock(x1+8, height+12, z1+10, 4);
        world.setBlock(x1+7, height+12, z1+10, 4);
        world.setBlock(x1+6, height+12, z1+10, 4);
        world.setBlock(x1+5, height+12, z1+10, 4);
        world.setBlock(x1+4, height+12, z1+10, 4);
        world.setBlock(x1+3, height+12, z1+10, 4);
        world.setBlock(x1+2, height+12, z1+10, 4);
        world.setBlock(x1+1, height+12, z1+1, 4);
        world.setBlock(x1+1, height+12, z1+9, 4);
        world.setBlock(x1+0, height+12, z1+2, 4);
        world.setBlock(x1+0, height+12, z1+3, 4);
        world.setBlock(x1+0, height+12, z1+4, 4);
        world.setBlock(x1+0, height+12, z1+5, 4);
        world.setBlock(x1+0, height+12, z1+6, 4);
        world.setBlock(x1+0, height+12, z1+7, 4);
        world.setBlock(x1+0, height+12, z1+8, 4);
        world.setBlock(x1+2, height+13, z1+0, 4);
        world.setBlock(x1+3, height+13, z1+0, 4);
        world.setBlock(x1+4, height+13, z1+0, 4);
        world.setBlock(x1+5, height+13, z1+0, 4);
        world.setBlock(x1+6, height+13, z1+0, 4);
        world.setBlock(x1+7, height+13, z1+0, 4);
        world.setBlock(x1+8, height+13, z1+0, 4);
        world.setBlock(x1+9, height+13, z1+1, 4);
        world.setBlock(x1+10, height+13, z1+2, 4);
        world.setBlock(x1+10, height+13, z1+3, 4);
        world.setBlock(x1+10, height+13, z1+4, 4);
        world.setBlock(x1+10, height+13, z1+5, 4);
        world.setBlock(x1+10, height+13, z1+6, 4);
        world.setBlock(x1+10, height+13, z1+7, 4);
        world.setBlock(x1+10, height+13, z1+8, 4);
        world.setBlock(x1+9, height+13, z1+9, 4);
        world.setBlock(x1+8, height+13, z1+10, 4);
        world.setBlock(x1+7, height+13, z1+10, 4);
        world.setBlock(x1+6, height+13, z1+10, 4);
        world.setBlock(x1+5, height+13, z1+10, 4);
        world.setBlock(x1+4, height+13, z1+10, 4);
        world.setBlock(x1+3, height+13, z1+10, 4);
        world.setBlock(x1+2, height+13, z1+10, 4);
        world.setBlock(x1+1, height+13, z1+1, 4);
        world.setBlock(x1+1, height+13, z1+9, 4);
        world.setBlock(x1+0, height+13, z1+2, 4);
        world.setBlock(x1+0, height+13, z1+3, 4);
        world.setBlock(x1+0, height+13, z1+4, 4);
        world.setBlock(x1+0, height+13, z1+5, 4);
        world.setBlock(x1+0, height+13, z1+6, 4);
        world.setBlock(x1+0, height+13, z1+7, 4);
        world.setBlock(x1+0, height+13, z1+8, 4);
        world.setBlock(x1+2, height+14, z1+0, 4);
        world.setBlock(x1+3, height+14, z1+0, 4);
        world.setBlock(x1+4, height+14, z1+0, 4);
        world.setBlock(x1+5, height+14, z1+0, 4);
        world.setBlock(x1+6, height+14, z1+0, 4);
        world.setBlock(x1+7, height+14, z1+0, 4);
        world.setBlock(x1+8, height+14, z1+0, 4);
        world.setBlock(x1+9, height+14, z1+1, 4);
        world.setBlock(x1+10, height+14, z1+2, 4);
        world.setBlock(x1+10, height+14, z1+3, 4);
        world.setBlock(x1+10, height+14, z1+4, 4);
        world.setBlock(x1+10, height+14, z1+5, 4);
        world.setBlock(x1+10, height+14, z1+6, 4);
        world.setBlock(x1+10, height+14, z1+7, 4);
        world.setBlock(x1+10, height+14, z1+8, 4);
        world.setBlock(x1+9, height+14, z1+9, 4);
        world.setBlock(x1+8, height+14, z1+10, 4);
        world.setBlock(x1+7, height+14, z1+10, 4);
        world.setBlock(x1+6, height+14, z1+10, 4);
        world.setBlock(x1+5, height+14, z1+10, 4);
        world.setBlock(x1+4, height+14, z1+10, 4);
        world.setBlock(x1+3, height+14, z1+10, 4);
        world.setBlock(x1+3, height+14, z1+9, 4);
        world.setBlock(x1+7, height+14, z1+1, 4);
        world.setBlock(x1+6, height+14, z1+1, 4);
        world.setBlock(x1+4, height+14, z1+9, 4);
        world.setBlock(x1+2, height+14, z1+10, 4);
        world.setBlock(x1+1, height+14, z1+1, 4);
        world.setBlock(x1+1, height+14, z1+9, 4);
        world.setBlock(x1+0, height+14, z1+2, 4);
        world.setBlock(x1+0, height+14, z1+3, 4);
        world.setBlock(x1+0, height+14, z1+4, 4);
        world.setBlock(x1+0, height+14, z1+5, 4);
        world.setBlock(x1+0, height+14, z1+6, 4);
        world.setBlock(x1+0, height+14, z1+7, 4);
        world.setBlock(x1+1, height+14, z1+7, 4);
        world.setBlock(x1+2, height+14, z1+7, 4);
        world.setBlock(x1+2, height+14, z1+8, 4);
        world.setBlock(x1+1, height+14, z1+8, 4);
        world.setBlock(x1+1, height+14, z1+2, 4);
        world.setBlock(x1+2, height+14, z1+2, 4);
        world.setBlock(x1+2, height+14, z1+3, 4);
        world.setBlock(x1+1, height+14, z1+3, 4);
        world.setBlock(x1+8, height+14, z1+2, 4);
        world.setBlock(x1+9, height+14, z1+2, 4);
        world.setBlock(x1+9, height+14, z1+3, 4);
        world.setBlock(x1+8, height+14, z1+3, 4);
        world.setBlock(x1+8, height+14, z1+7, 4);
        world.setBlock(x1+9, height+14, z1+7, 4);
        world.setBlock(x1+9, height+14, z1+8, 4);
        world.setBlock(x1+8, height+14, z1+8, 4);
        world.setBlock(x1+6, height+14, z1+8, 4);
        world.setBlock(x1+7, height+14, z1+8, 4);
        world.setBlock(x1+7, height+14, z1+9, 4);
        world.setBlock(x1+6, height+14, z1+9, 4);
        world.setBlock(x1+6, height+14, z1+6, 4);
        world.setBlock(x1+7, height+14, z1+6, 4);
        world.setBlock(x1+8, height+13, z1+6, 4);
        world.setBlock(x1+8, height+12, z1+5, 4);
        world.setBlock(x1+8, height+11, z1+4, 4);
        world.setBlock(x1+9, height+10, z1+4, 4);
        world.setBlock(x1+7, height+14, z1+7, 4);
        world.setBlock(x1+6, height+14, z1+7, 4);
        world.setBlock(x1+6, height+14, z1+4, 4);
        world.setBlock(x1+7, height+14, z1+4, 4);
        world.setBlock(x1+7, height+14, z1+5, 4);
        world.setBlock(x1+6, height+14, z1+5, 4);
        world.setBlock(x1+6, height+14, z1+2, 4);
        world.setBlock(x1+7, height+14, z1+2, 4);
        world.setBlock(x1+7, height+14, z1+3, 4);
        world.setBlock(x1+6, height+14, z1+3, 4);
        world.setBlock(x1+3, height+14, z1+1, 4);
        world.setBlock(x1+4, height+14, z1+1, 4);
        world.setBlock(x1+4, height+14, z1+2, 4);
        world.setBlock(x1+3, height+14, z1+2, 4);
        world.setBlock(x1+3, height+14, z1+3, 4);
        world.setBlock(x1+4, height+14, z1+3, 4);
        world.setBlock(x1+4, height+14, z1+4, 4);
        world.setBlock(x1+3, height+14, z1+4, 4);
        world.setBlock(x1+3, height+14, z1+5, 4);
        world.setBlock(x1+4, height+14, z1+5, 4);
        world.setBlock(x1+5, height+14, z1+5, 4);
        world.setBlock(x1+5, height+14, z1+7, 4);
        world.setBlock(x1+5, height+14, z1+3, 4);
        world.setBlock(x1+4, height+14, z1+6, 4);
        world.setBlock(x1+3, height+14, z1+6, 4);
        world.setBlock(x1+3, height+14, z1+7, 4);
        world.setBlock(x1+4, height+14, z1+7, 4);
        world.setBlock(x1+4, height+14, z1+8, 4);
        world.setBlock(x1+3, height+14, z1+8, 4);
        world.setBlock(x1+0, height+14, z1+8, 4);
        world.setBlock(x1+2, height+15, z1+0, 4);
        world.setBlock(x1+3, height+15, z1+0, 4);
        world.setBlock(x1+4, height+15, z1+0, 4);
        world.setBlock(x1+5, height+15, z1+0, 4);
        world.setBlock(x1+6, height+15, z1+0, 4);
        world.setBlock(x1+7, height+15, z1+0, 4);
        world.setBlock(x1+8, height+15, z1+0, 4);
        world.setBlock(x1+9, height+15, z1+1, 4);
        world.setBlock(x1+10, height+15, z1+2, 4);
        world.setBlock(x1+10, height+15, z1+3, 4);
        world.setBlock(x1+10, height+15, z1+4, 4);
        world.setBlock(x1+10, height+15, z1+5, 4);
        world.setBlock(x1+10, height+15, z1+6, 4);
        world.setBlock(x1+10, height+15, z1+7, 4);
        world.setBlock(x1+10, height+15, z1+8, 4);
        world.setBlock(x1+9, height+15, z1+9, 4);
        world.setBlock(x1+8, height+15, z1+10, 4);
        world.setBlock(x1+7, height+15, z1+10, 4);
        world.setBlock(x1+6, height+15, z1+10, 4);
        world.setBlock(x1+5, height+15, z1+10, 4);
        world.setBlock(x1+4, height+15, z1+10, 4);
        world.setBlock(x1+3, height+15, z1+10, 4);
        world.setBlock(x1+2, height+15, z1+10, 4);
        world.setBlock(x1+1, height+15, z1+1, 4);
        world.setBlock(x1+1, height+15, z1+9, 4);
        world.setBlock(x1+0, height+15, z1+2, 4);
        world.setBlock(x1+0, height+15, z1+3, 4);
        world.setBlock(x1+0, height+15, z1+4, 4);
        world.setBlock(x1+0, height+15, z1+5, 4);
        world.setBlock(x1+0, height+15, z1+6, 4);
        world.setBlock(x1+0, height+15, z1+7, 4);
        world.setBlock(x1+0, height+15, z1+8, 4);
        world.setBlock(x1+2, height+16, z1+0, 4);
        world.setBlock(x1+3, height+16, z1+0, 4);
        world.setBlock(x1+4, height+16, z1+0, 4);
        world.setBlock(x1+5, height+16, z1+0, 4);
        world.setBlock(x1+6, height+16, z1+0, 4);
        world.setBlock(x1+7, height+16, z1+0, 4);
        world.setBlock(x1+8, height+16, z1+0, 4);
        world.setBlock(x1+9, height+16, z1+1, 4);
        world.setBlock(x1+10, height+16, z1+2, 4);
        world.setBlock(x1+10, height+16, z1+3, 4);
        world.setBlock(x1+10, height+16, z1+4, 4);
        world.setBlock(x1+10, height+16, z1+5, 4);
        world.setBlock(x1+10, height+16, z1+6, 4);
        world.setBlock(x1+10, height+16, z1+7, 4);
        world.setBlock(x1+10, height+16, z1+8, 4);
        world.setBlock(x1+9, height+16, z1+9, 4);
        world.setBlock(x1+8, height+16, z1+10, 4);
        world.setBlock(x1+7, height+16, z1+10, 4);
        world.setBlock(x1+6, height+16, z1+10, 4);
        world.setBlock(x1+5, height+16, z1+10, 4);
        world.setBlock(x1+4, height+16, z1+10, 4);
        world.setBlock(x1+3, height+16, z1+10, 4);
        world.setBlock(x1+2, height+16, z1+10, 4);
        world.setBlock(x1+1, height+16, z1+1, 4);
        world.setBlock(x1+1, height+16, z1+9, 4);
        world.setBlock(x1+0, height+16, z1+2, 4);
        world.setBlock(x1+0, height+16, z1+3, 4);
        world.setBlock(x1+0, height+16, z1+4, 4);
        world.setBlock(x1+0, height+16, z1+5, 4);
        world.setBlock(x1+0, height+16, z1+6, 4);
        world.setBlock(x1+0, height+16, z1+7, 4);
        world.setBlock(x1+0, height+16, z1+8, 4);
        world.setBlock(x1+2, height+17, z1+0, 4);
        world.setBlock(x1+3, height+17, z1+0, 4);
        world.setBlock(x1+4, height+17, z1+0, 4);
        world.setBlock(x1+5, height+17, z1+0, 4);
        world.setBlock(x1+6, height+17, z1+0, 4);
        world.setBlock(x1+7, height+17, z1+0, 4);
        world.setBlock(x1+8, height+17, z1+0, 4);
        world.setBlock(x1+9, height+17, z1+1, 4);
        world.setBlock(x1+10, height+17, z1+2, 4);
        world.setBlock(x1+10, height+17, z1+3, 4);
        world.setBlock(x1+10, height+17, z1+4, 4);
        world.setBlock(x1+10, height+17, z1+5, 4);
        world.setBlock(x1+10, height+17, z1+6, 4);
        world.setBlock(x1+10, height+17, z1+7, 4);
        world.setBlock(x1+10, height+17, z1+8, 4);
        world.setBlock(x1+9, height+17, z1+9, 4);
        world.setBlock(x1+8, height+17, z1+10, 4);
        world.setBlock(x1+7, height+17, z1+10, 4);
        world.setBlock(x1+6, height+17, z1+10, 4);
        world.setBlock(x1+5, height+17, z1+10, 4);
        world.setBlock(x1+4, height+17, z1+10, 4);
        world.setBlock(x1+3, height+17, z1+10, 4);
        world.setBlock(x1+2, height+17, z1+10, 4);
        world.setBlock(x1+1, height+17, z1+1, 4);
        world.setBlock(x1+1, height+17, z1+9, 4);
        world.setBlock(x1+0, height+17, z1+2, 4);
        world.setBlock(x1+0, height+17, z1+3, 4);
        world.setBlock(x1+0, height+17, z1+4, 4);
        world.setBlock(x1+0, height+17, z1+5, 4);
        world.setBlock(x1+0, height+17, z1+6, 4);
        world.setBlock(x1+0, height+17, z1+7, 4);
        world.setBlock(x1+0, height+17, z1+8, 4);
        world.setBlock(x1+2, height+18, z1+0, 4);
        world.setBlock(x1+3, height+18, z1+0, 4);
        world.setBlock(x1+4, height+18, z1+0, 4);
        world.setBlock(x1+5, height+18, z1+0, 4);
        world.setBlock(x1+6, height+18, z1+0, 4);
        world.setBlock(x1+7, height+18, z1+0, 4);
        world.setBlock(x1+8, height+18, z1+0, 4);
        world.setBlock(x1+9, height+18, z1+1, 4);
        world.setBlock(x1+10, height+18, z1+2, 4);
        world.setBlock(x1+10, height+18, z1+3, 4);
        world.setBlock(x1+10, height+18, z1+4, 4);
        world.setBlock(x1+10, height+18, z1+5, 4);
        world.setBlock(x1+10, height+18, z1+6, 4);
        world.setBlock(x1+10, height+18, z1+7, 4);
        world.setBlock(x1+10, height+18, z1+8, 4);
        world.setBlock(x1+9, height+18, z1+9, 4);
        world.setBlock(x1+8, height+18, z1+10, 4);
        world.setBlock(x1+7, height+18, z1+10, 4);
        world.setBlock(x1+6, height+18, z1+10, 4);
        world.setBlock(x1+5, height+18, z1+10, 4);
        world.setBlock(x1+4, height+18, z1+10, 4);
        world.setBlock(x1+3, height+18, z1+10, 4);
        world.setBlock(x1+2, height+18, z1+10, 4);
        world.setBlock(x1+1, height+18, z1+1, 4);
        world.setBlock(x1+1, height+18, z1+9, 4);
        world.setBlock(x1+0, height+18, z1+2, 4);
        world.setBlock(x1+0, height+18, z1+3, 4);
        world.setBlock(x1+0, height+18, z1+4, 4);
        world.setBlock(x1+0, height+18, z1+5, 4);
        world.setBlock(x1+0, height+18, z1+6, 4);
        world.setBlock(x1+0, height+18, z1+7, 4);
        world.setBlock(x1+0, height+18, z1+8, 4);
        world.setBlock(x1+2, height+19, z1+0, 4);
        world.setBlock(x1+3, height+19, z1+0, 4);
        world.setBlock(x1+4, height+19, z1+0, 4);
        world.setBlock(x1+5, height+19, z1+0, 4);
        world.setBlock(x1+6, height+19, z1+0, 4);
        world.setBlock(x1+7, height+19, z1+0, 4);
        world.setBlock(x1+8, height+19, z1+0, 4);
        world.setBlock(x1+9, height+19, z1+1, 4);
        world.setBlock(x1+10, height+19, z1+2, 4);
        world.setBlock(x1+10, height+19, z1+3, 4);
        world.setBlock(x1+10, height+19, z1+4, 4);
        world.setBlock(x1+10, height+19, z1+5, 4);
        world.setBlock(x1+10, height+19, z1+6, 4);
        world.setBlock(x1+10, height+19, z1+7, 4);
        world.setBlock(x1+10, height+19, z1+8, 4);
        world.setBlock(x1+9, height+19, z1+9, 4);
        world.setBlock(x1+8, height+19, z1+10, 4);
        world.setBlock(x1+7, height+19, z1+10, 4);
        world.setBlock(x1+6, height+19, z1+10, 4);
        world.setBlock(x1+5, height+19, z1+10, 4);
        world.setBlock(x1+4, height+19, z1+10, 4);
        world.setBlock(x1+3, height+19, z1+10, 4);
        world.setBlock(x1+3, height+19, z1+9, 4);
        world.setBlock(x1+7, height+19, z1+1, 4);
        world.setBlock(x1+6, height+19, z1+1, 4);
        world.setBlock(x1+4, height+19, z1+9, 4);
        world.setBlock(x1+2, height+19, z1+10, 4);
        world.setBlock(x1+1, height+19, z1+1, 4);
        world.setBlock(x1+1, height+19, z1+9, 4);
        world.setBlock(x1+0, height+19, z1+2, 4);
        world.setBlock(x1+0, height+19, z1+3, 4);
        world.setBlock(x1+0, height+19, z1+4, 4);
        world.setBlock(x1+0, height+19, z1+5, 4);
        world.setBlock(x1+0, height+19, z1+6, 4);
        world.setBlock(x1+0, height+19, z1+7, 4);
        world.setBlock(x1+1, height+19, z1+7, 4);
        world.setBlock(x1+2, height+19, z1+7, 4);
        world.setBlock(x1+2, height+19, z1+8, 4);
        world.setBlock(x1+1, height+19, z1+8, 4);
        world.setBlock(x1+1, height+19, z1+2, 4);
        world.setBlock(x1+2, height+19, z1+2, 4);
        world.setBlock(x1+2, height+19, z1+3, 4);
        world.setBlock(x1+1, height+19, z1+3, 4);
        world.setBlock(x1+8, height+19, z1+2, 4);
        world.setBlock(x1+9, height+19, z1+2, 4);
        world.setBlock(x1+9, height+19, z1+3, 4);
        world.setBlock(x1+8, height+19, z1+3, 4);
        world.setBlock(x1+8, height+19, z1+7, 4);
        world.setBlock(x1+9, height+19, z1+7, 4);
        world.setBlock(x1+9, height+19, z1+8, 4);
        world.setBlock(x1+8, height+19, z1+8, 4);
        world.setBlock(x1+8, height+19, z1+9, 4);
        world.setBlock(x1+5, height+19, z1+9, 4);
        world.setBlock(x1+5, height+19, z1+8, 4);
        world.setBlock(x1+5, height+19, z1+6, 4);
        world.setBlock(x1+5, height+19, z1+4, 4);
        world.setBlock(x1+5, height+19, z1+2, 4);
        world.setBlock(x1+5, height+19, z1+1, 4);
        world.setBlock(x1+8, height+19, z1+1, 4);
        world.setBlock(x1+2, height+19, z1+1, 4);
        world.setBlock(x1+2, height+19, z1+9, 4);
        world.setBlock(x1+6, height+19, z1+8, 4);
        world.setBlock(x1+7, height+19, z1+8, 4);
        world.setBlock(x1+7, height+19, z1+9, 4);
        world.setBlock(x1+6, height+19, z1+9, 4);
        world.setBlock(x1+6, height+19, z1+6, 4);
        world.setBlock(x1+7, height+19, z1+6, 4);
        world.setBlock(x1+8, height+18, z1+6, 4);
        world.setBlock(x1+8, height+17, z1+5, 4);
        world.setBlock(x1+8, height+16, z1+4, 4);
        world.setBlock(x1+9, height+15, z1+4, 4);
        world.setBlock(x1+7, height+19, z1+7, 4);
        world.setBlock(x1+6, height+19, z1+7, 4);
        world.setBlock(x1+6, height+19, z1+4, 4);
        world.setBlock(x1+7, height+19, z1+4, 4);
        world.setBlock(x1+7, height+19, z1+5, 4);
        world.setBlock(x1+6, height+19, z1+5, 4);
        world.setBlock(x1+6, height+19, z1+2, 4);
        world.setBlock(x1+7, height+19, z1+2, 4);
        world.setBlock(x1+7, height+19, z1+3, 4);
        world.setBlock(x1+6, height+19, z1+3, 4);
        world.setBlock(x1+3, height+19, z1+1, 4);
        world.setBlock(x1+4, height+19, z1+1, 4);
        world.setBlock(x1+4, height+19, z1+2, 4);
        world.setBlock(x1+3, height+19, z1+2, 4);
        world.setBlock(x1+3, height+19, z1+3, 4);
        world.setBlock(x1+4, height+19, z1+3, 4);
        world.setBlock(x1+4, height+19, z1+4, 4);
        world.setBlock(x1+3, height+19, z1+4, 4);
        world.setBlock(x1+3, height+19, z1+5, 4);
        world.setBlock(x1+2, height+19, z1+5, 4);
        world.setBlock(x1+1, height+19, z1+5, 4);
        world.setBlock(x1+1, height+19, z1+6, 4);
        world.setBlock(x1+2, height+19, z1+6, 4);
        world.setBlock(x1+1, height+19, z1+4, 4);
        world.setBlock(x1+2, height+19, z1+4, 4);
        world.setBlock(x1+8, height+19, z1+4, 4);
        world.setBlock(x1+9, height+19, z1+4, 4);
        world.setBlock(x1+8, height+19, z1+5, 4);
        world.setBlock(x1+9, height+19, z1+5, 4);
        world.setBlock(x1+8, height+19, z1+6, 4);
        world.setBlock(x1+9, height+19, z1+6, 4);
        world.setBlock(x1+4, height+19, z1+5, 4);
        world.setBlock(x1+5, height+19, z1+5, 4);

        // Loot
        world.setBlock(x1+5, height+20, z1+5, 1031);
        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+5, height+20, z1+5);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.soulforgedSteelIngot, 1);
        chest.setStorageStack(loot);

        world.setBlock(x1+5, height+16, z1+5, 52);
        var spawner4 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+5, height+16, z1+5);
        spawner4.getSpawnerLogic().setMobID("Blaze");

        world.setBlock(x1+5, height+11, z1+5, 52);
        var spawner3 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+5, height+11, z1+5);
        spawner3.getSpawnerLogic().setMobID("Skeleton");

        world.setBlock(x1+5, height+6, z1+5, 52);
        var spawner2 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+5, height+6, z1+5);
        spawner2.getSpawnerLogic().setMobID("Skeleton");

        world.setBlock(x1+5, height+1, z1+5, 52);
        var spawner1 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+5, height+1, z1+5);
        spawner1.getSpawnerLogic().setMobID("Zombie");

        world.setBlock(x1+5, height+19, z1+7, 4);
        world.setBlock(x1+5, height+19, z1+3, 4);
        world.setBlock(x1+4, height+19, z1+6, 4);
        world.setBlock(x1+3, height+19, z1+6, 4);
        world.setBlock(x1+3, height+19, z1+7, 4);
        world.setBlock(x1+4, height+19, z1+7, 4);
        world.setBlock(x1+4, height+19, z1+8, 4);
        world.setBlock(x1+3, height+19, z1+8, 4);
        world.setBlock(x1+0, height+19, z1+8, 4);
    }

    private void spawnSurfaceDungeon(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        world.setBlock(x1+1, height+0, z1+0, 4);
        world.setBlock(x1+1, height+0, z1+1, 4);
        world.setBlock(x1+1, height+0, z1+2, 4);
        world.setBlock(x1+1, height+-1, z1+0, 4);
        world.setBlock(x1+1, height+-1, z1+1, 4);
        world.setBlock(x1+1, height+-1, z1+2, 4);
        world.setBlock(x1+1, height+-2, z1+0, 4);
        world.setBlock(x1+1, height+-2, z1+1, 4);
        world.setBlock(x1+1, height+-2, z1+2, 4);
        world.setBlock(x1+1, height+-3, z1+0, 4);
        world.setBlock(x1+1, height+-3, z1+1, 4);
        world.setBlock(x1+1, height+-3, z1+2, 4);
        world.setBlock(x1+1, height+-4, z1+0, 4);
        world.setBlock(x1+2, height+-1, z1+0, 4);
        world.setBlock(x1+2, height+-2, z1+0, 4);
        world.setBlock(x1+2, height+-3, z1+0, 4);
        world.setBlock(x1+2, height+-4, z1+0, 4);
        world.setBlock(x1+3, height+-1, z1+0, 4);
        world.setBlock(x1+3, height+-2, z1+0, 4);
        world.setBlock(x1+3, height+-3, z1+0, 4);
        world.setBlock(x1+3, height+-4, z1+0, 4);
        world.setBlock(x1+4, height+-1, z1+0, 4);
        world.setBlock(x1+4, height+-2, z1+0, 4);
        world.setBlock(x1+4, height+-3, z1+0, 4);
        world.setBlock(x1+4, height+-4, z1+0, 4);
        world.setBlock(x1+5, height+-1, z1+0, 4);
        world.setBlock(x1+5, height+-2, z1+0, 4);
        world.setBlock(x1+5, height+-3, z1+0, 4);
        world.setBlock(x1+5, height+-4, z1+0, 4);
        world.setBlock(x1+6, height+-1, z1+0, 4);
        world.setBlock(x1+6, height+-2, z1+0, 4);
        world.setBlock(x1+6, height+-3, z1+0, 4);
        world.setBlock(x1+6, height+-4, z1+0, 4);
        world.setBlock(x1+7, height+-1, z1+0, 4);
        world.setBlock(x1+7, height+-2, z1+0, 4);
        world.setBlock(x1+7, height+-3, z1+0, 4);
        world.setBlock(x1+7, height+-4, z1+0, 4);
        world.setBlock(x1+8, height+-1, z1+0, 4);
        world.setBlock(x1+8, height+-2, z1+0, 4);
        world.setBlock(x1+8, height+-3, z1+0, 4);
        world.setBlock(x1+8, height+-4, z1+0, 4);
        world.setBlock(x1+9, height+-1, z1+0, 4);
        world.setBlock(x1+9, height+-2, z1+0, 4);
        world.setBlock(x1+9, height+-3, z1+0, 4);
        world.setBlock(x1+9, height+-4, z1+0, 4);
        world.setBlock(x1+10, height+-1, z1+0, 4);
        world.setBlock(x1+10, height+-2, z1+0, 4);
        world.setBlock(x1+10, height+-3, z1+0, 4);
        world.setBlock(x1+10, height+-4, z1+0, 4);
        world.setBlock(x1+10, height+-1, z1+1, 4);
        world.setBlock(x1+10, height+-2, z1+1, 4);
        world.setBlock(x1+10, height+-3, z1+1, 4);
        world.setBlock(x1+10, height+-4, z1+1, 4);
        world.setBlock(x1+9, height+-4, z1+1, 0);
        world.setBlock(x1+9, height+-4, z1+2, 0);
        world.setBlock(x1+9, height+-4, z1+3, 0);
        world.setBlock(x1+9, height+-4, z1+4, 0);
        world.setBlock(x1+9, height+-4, z1+5, 0);
        world.setBlock(x1+9, height+-3, z1+1, 0);
        world.setBlock(x1+9, height+-3, z1+2, 0);
        world.setBlock(x1+9, height+-3, z1+3, 0);
        world.setBlock(x1+9, height+-3, z1+4, 0);
        world.setBlock(x1+9, height+-3, z1+5, 0);
        world.setBlock(x1+9, height+-2, z1+1, 0);
        world.setBlock(x1+9, height+-2, z1+2, 0);
        world.setBlock(x1+9, height+-2, z1+3, 0);
        world.setBlock(x1+9, height+-2, z1+4, 0);
        world.setBlock(x1+9, height+-2, z1+5, 0);
        world.setBlock(x1+9, height+-1, z1+1, 0);
        world.setBlock(x1+9, height+-1, z1+2, 0);
        world.setBlock(x1+9, height+-1, z1+3, 0);
        world.setBlock(x1+9, height+-1, z1+4, 0);
        world.setBlock(x1+9, height+-1, z1+5, 0);
        world.setBlock(x1+8, height+-4, z1+1, 0);
        world.setBlock(x1+8, height+-4, z1+2, 0);

        world.setBlock(x1+9, height+-4, z1+3, 1031);

        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+9, height+-4, z1+3);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.diamondIngot, 4);

        var randomLoot = rand.nextInt(1, 3);

        if (randomLoot == 2)
            loot = new ItemStack(Item.appleGold);
        if (randomLoot == 1)
            loot = new ItemStack(Item.beefCooked, 6);
        
        chest.setStorageStack(loot);


        world.setBlock(x1+8, height+-4, z1+4, 0);
        world.setBlock(x1+8, height+-4, z1+5, 0);
        world.setBlock(x1+8, height+-3, z1+1, 0);
        world.setBlock(x1+8, height+-3, z1+2, 0);
        world.setBlock(x1+8, height+-3, z1+3, 0);
        world.setBlock(x1+8, height+-3, z1+4, 0);
        world.setBlock(x1+8, height+-3, z1+5, 0);
        world.setBlock(x1+8, height+-2, z1+1, 0);
        world.setBlock(x1+8, height+-2, z1+2, 0);
        world.setBlock(x1+8, height+-2, z1+3, 0);
        world.setBlock(x1+8, height+-2, z1+4, 0);
        world.setBlock(x1+8, height+-2, z1+5, 0);
        world.setBlock(x1+8, height+-1, z1+1, 0);
        world.setBlock(x1+8, height+-1, z1+2, 0);
        world.setBlock(x1+8, height+-1, z1+3, 0);
        world.setBlock(x1+8, height+-1, z1+4, 0);
        world.setBlock(x1+8, height+-1, z1+5, 0);
        world.setBlock(x1+7, height+-4, z1+1, 0);
        world.setBlock(x1+7, height+-4, z1+2, 0);
        world.setBlock(x1+7, height+-4, z1+3, 0);
        world.setBlock(x1+7, height+-4, z1+4, 0);
        world.setBlock(x1+7, height+-4, z1+5, 0);
        world.setBlock(x1+7, height+-3, z1+1, 0);
        world.setBlock(x1+7, height+-3, z1+2, 0);
        world.setBlock(x1+7, height+-3, z1+3, 0);
        world.setBlock(x1+7, height+-3, z1+4, 0);
        world.setBlock(x1+7, height+-3, z1+5, 0);
        world.setBlock(x1+7, height+-2, z1+1, 0);
        world.setBlock(x1+7, height+-2, z1+2, 0);
        world.setBlock(x1+7, height+-2, z1+3, 0);
        world.setBlock(x1+7, height+-2, z1+4, 0);
        world.setBlock(x1+7, height+-2, z1+5, 0);
        world.setBlock(x1+7, height+-1, z1+1, 0);
        world.setBlock(x1+7, height+-1, z1+2, 0);
        world.setBlock(x1+7, height+-1, z1+3, 0);
        world.setBlock(x1+7, height+-1, z1+4, 0);
        world.setBlock(x1+7, height+-1, z1+5, 0);
        world.setBlock(x1+6, height+-4, z1+1, 0);
        world.setBlock(x1+6, height+-4, z1+2, 0);
        world.setBlock(x1+6, height+-4, z1+3, 0);
        world.setBlock(x1+6, height+-4, z1+4, 0);
        world.setBlock(x1+6, height+-4, z1+5, 0);
        world.setBlock(x1+6, height+-3, z1+1, 0);
        world.setBlock(x1+6, height+-3, z1+2, 0);
        world.setBlock(x1+6, height+-3, z1+3, 0);
        world.setBlock(x1+6, height+-3, z1+4, 0);
        world.setBlock(x1+6, height+-3, z1+5, 0);
        world.setBlock(x1+6, height+-2, z1+1, 0);
        world.setBlock(x1+6, height+-2, z1+2, 0);
        world.setBlock(x1+6, height+-2, z1+3, 0);
        world.setBlock(x1+6, height+-2, z1+4, 0);
        world.setBlock(x1+6, height+-2, z1+5, 0);
        world.setBlock(x1+6, height+-1, z1+1, 0);
        world.setBlock(x1+6, height+-1, z1+2, 0);
        world.setBlock(x1+6, height+-1, z1+3, 0);
        world.setBlock(x1+6, height+-1, z1+4, 0);
        world.setBlock(x1+6, height+-1, z1+5, 0);
        world.setBlock(x1+5, height+-4, z1+1, 0);
        world.setBlock(x1+5, height+-4, z1+2, 0);
        world.setBlock(x1+5, height+-4, z1+3, 0);
        world.setBlock(x1+5, height+-4, z1+4, 0);
        world.setBlock(x1+5, height+-4, z1+5, 0);
        world.setBlock(x1+5, height+-3, z1+1, 0);
        world.setBlock(x1+5, height+-3, z1+2, 0);
        world.setBlock(x1+5, height+-3, z1+3, 0);
        world.setBlock(x1+5, height+-3, z1+4, 0);
        world.setBlock(x1+5, height+-3, z1+5, 0);
        world.setBlock(x1+5, height+-2, z1+1, 0);
        world.setBlock(x1+5, height+-2, z1+2, 0);
        world.setBlock(x1+5, height+-2, z1+3, 0);
        world.setBlock(x1+5, height+-2, z1+4, 0);
        world.setBlock(x1+5, height+-2, z1+5, 0);
        world.setBlock(x1+5, height+-1, z1+1, 0);
        world.setBlock(x1+5, height+-1, z1+2, 0);
        world.setBlock(x1+5, height+-1, z1+3, 0);
        world.setBlock(x1+5, height+-1, z1+4, 0);
        world.setBlock(x1+5, height+-1, z1+5, 0);
        world.setBlock(x1+5, height+-4, z1+1, 0);
        world.setBlock(x1+5, height+-4, z1+2, 0);
        world.setBlock(x1+5, height+-4, z1+3, 0);
        world.setBlock(x1+5, height+-4, z1+4, 0);
        world.setBlock(x1+5, height+-4, z1+5, 0);
        world.setBlock(x1+5, height+-3, z1+1, 0);
        world.setBlock(x1+5, height+-3, z1+2, 0);
        world.setBlock(x1+5, height+-3, z1+3, 0);
        world.setBlock(x1+5, height+-3, z1+4, 0);
        world.setBlock(x1+5, height+-3, z1+5, 0);
        world.setBlock(x1+5, height+-2, z1+1, 0);
        world.setBlock(x1+5, height+-2, z1+2, 0);
        world.setBlock(x1+5, height+-2, z1+3, 0);
        world.setBlock(x1+5, height+-2, z1+4, 0);
        world.setBlock(x1+5, height+-2, z1+5, 0);
        world.setBlock(x1+5, height+-1, z1+1, 0);
        world.setBlock(x1+5, height+-1, z1+2, 0);
        world.setBlock(x1+4, height+-4, z1+1, 0);
        world.setBlock(x1+4, height+-4, z1+2, 0);
        world.setBlock(x1+4, height+-4, z1+3, 0);
        world.setBlock(x1+4, height+-4, z1+4, 0);
        world.setBlock(x1+4, height+-3, z1+1, 0);
        world.setBlock(x1+4, height+-2, z1+1, 0);
        world.setBlock(x1+4, height+-2, z1+2, 0);
        world.setBlock(x1+4, height+-2, z1+5, 0);
        world.setBlock(x1+4, height+-1, z1+3, 0);
        world.setBlock(x1+4, height+-1, z1+4, 0);
        world.setBlock(x1+4, height+-1, z1+5, 0);
        world.setBlock(x1+4, height+-4, z1+5, 0);
        world.setBlock(x1+4, height+-3, z1+2, 0);
        world.setBlock(x1+4, height+-3, z1+3, 0);
        world.setBlock(x1+4, height+-3, z1+4, 0);
        world.setBlock(x1+4, height+-3, z1+5, 0);
        world.setBlock(x1+4, height+-2, z1+3, 0);
        world.setBlock(x1+4, height+-2, z1+4, 0);
        world.setBlock(x1+4, height+-1, z1+1, 0);
        world.setBlock(x1+4, height+-1, z1+2, 0);
        world.setBlock(x1+3, height+-4, z1+1, 0);
        world.setBlock(x1+3, height+-4, z1+2, 0);
        world.setBlock(x1+3, height+-4, z1+3, 0);
        world.setBlock(x1+3, height+-4, z1+4, 0);
        world.setBlock(x1+3, height+-3, z1+1, 0);
        world.setBlock(x1+3, height+-2, z1+1, 0);
        world.setBlock(x1+3, height+-2, z1+2, 0);
        world.setBlock(x1+3, height+-2, z1+5, 0);
        world.setBlock(x1+3, height+-1, z1+3, 0);
        world.setBlock(x1+3, height+-1, z1+4, 0);
        world.setBlock(x1+3, height+-1, z1+5, 0);
        world.setBlock(x1+3, height+-4, z1+5, 0);
        world.setBlock(x1+3, height+-3, z1+2, 0);
        world.setBlock(x1+3, height+-3, z1+3, 0);
        world.setBlock(x1+3, height+-3, z1+4, 0);
        world.setBlock(x1+3, height+-3, z1+5, 0);
        world.setBlock(x1+3, height+-2, z1+3, 0);
        world.setBlock(x1+3, height+-2, z1+4, 0);
        world.setBlock(x1+3, height+-1, z1+1, 0);
        world.setBlock(x1+3, height+-1, z1+2, 0);
        world.setBlock(x1+2, height+-4, z1+1, 0);
        world.setBlock(x1+2, height+-4, z1+2, 0);
        world.setBlock(x1+2, height+-4, z1+3, 0);
        world.setBlock(x1+2, height+-4, z1+4, 0);
        world.setBlock(x1+2, height+-3, z1+1, 0);
        world.setBlock(x1+2, height+-2, z1+1, 0);
        world.setBlock(x1+2, height+-2, z1+2, 0);
        world.setBlock(x1+2, height+-2, z1+5, 0);
        world.setBlock(x1+2, height+-1, z1+3, 0);
        world.setBlock(x1+2, height+-1, z1+4, 0);
        world.setBlock(x1+2, height+-1, z1+5, 0);
        world.setBlock(x1+2, height+-4, z1+5, 0);
        world.setBlock(x1+2, height+-3, z1+2, 0);
        world.setBlock(x1+2, height+-3, z1+3, 0);
        world.setBlock(x1+2, height+-3, z1+4, 0);
        world.setBlock(x1+2, height+-3, z1+5, 0);
        world.setBlock(x1+2, height+-2, z1+3, 0);
        world.setBlock(x1+2, height+-2, z1+4, 0);
        world.setBlock(x1+2, height+-1, z1+1, 0);
        world.setBlock(x1+2, height+-1, z1+2, 0);
        world.setBlock(x1+5, height+-1, z1+3, 0);
        world.setBlock(x1+5, height+-1, z1+4, 0);
        world.setBlock(x1+5, height+-1, z1+5, 0);

        world.setBlock(x1+8, height+-4, z1+3, 52);
        var spawner1 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+8, height+-4, z1+3);
        spawner1.getSpawnerLogic().setMobID("Zombie");

        world.setBlock(x1+8, height+-3, z1+3, 52);
        var spawner2 = (TileEntityMobSpawner)world.getBlockTileEntity(x1+8, height+-3, z1+3);
        spawner2.getSpawnerLogic().setMobID("Skeleton");

        world.setBlock(x1+10, height+-1, z1+2, 4);
        world.setBlock(x1+10, height+-2, z1+2, 4);
        world.setBlock(x1+10, height+-3, z1+2, 4);
        world.setBlock(x1+10, height+-4, z1+2, 4);
        world.setBlock(x1+10, height+-1, z1+3, 4);
        world.setBlock(x1+10, height+-2, z1+3, 4);
        world.setBlock(x1+10, height+-3, z1+3, 4);
        world.setBlock(x1+10, height+-4, z1+3, 4);
        world.setBlock(x1+10, height+-1, z1+4, 4);
        world.setBlock(x1+10, height+-2, z1+4, 4);
        world.setBlock(x1+10, height+-3, z1+4, 4);
        world.setBlock(x1+10, height+-4, z1+4, 4);
        world.setBlock(x1+10, height+-1, z1+5, 4);
        world.setBlock(x1+10, height+-2, z1+5, 4);
        world.setBlock(x1+10, height+-3, z1+5, 4);
        world.setBlock(x1+10, height+-4, z1+5, 4);
        world.setBlock(x1+10, height+-1, z1+6, 4);
        world.setBlock(x1+10, height+-2, z1+6, 4);
        world.setBlock(x1+10, height+-3, z1+6, 4);
        world.setBlock(x1+10, height+-4, z1+6, 4);
        world.setBlock(x1+9, height+-1, z1+6, 4);
        world.setBlock(x1+9, height+-2, z1+6, 4);
        world.setBlock(x1+9, height+-3, z1+6, 4);
        world.setBlock(x1+9, height+-4, z1+6, 4);
        world.setBlock(x1+8, height+-1, z1+6, 4);
        world.setBlock(x1+8, height+-2, z1+6, 4);
        world.setBlock(x1+8, height+-3, z1+6, 4);
        world.setBlock(x1+8, height+-4, z1+6, 4);
        world.setBlock(x1+7, height+-1, z1+6, 4);
        world.setBlock(x1+7, height+-2, z1+6, 4);
        world.setBlock(x1+7, height+-3, z1+6, 4);
        world.setBlock(x1+7, height+-4, z1+6, 4);
        world.setBlock(x1+6, height+-2, z1+6, 4);
        world.setBlock(x1+6, height+-3, z1+6, 4);
        world.setBlock(x1+6, height+-4, z1+6, 4);
        world.setBlock(x1+5, height+-1, z1+6, 4);
        world.setBlock(x1+5, height+-2, z1+6, 4);
        world.setBlock(x1+5, height+-3, z1+6, 4);
        world.setBlock(x1+5, height+-4, z1+6, 4);
        world.setBlock(x1+6, height+-1, z1+6, 4);
        world.setBlock(x1+5, height+-2, z1+6, 4);
        world.setBlock(x1+5, height+-3, z1+6, 4);
        world.setBlock(x1+5, height+-4, z1+6, 4);
        world.setBlock(x1+4, height+-1, z1+6, 4);
        world.setBlock(x1+4, height+-2, z1+6, 4);
        world.setBlock(x1+4, height+-3, z1+6, 4);
        world.setBlock(x1+4, height+-4, z1+6, 4);
        world.setBlock(x1+4, height+-2, z1+6, 4);
        world.setBlock(x1+4, height+-3, z1+6, 4);
        world.setBlock(x1+4, height+-4, z1+6, 4);
        world.setBlock(x1+3, height+-1, z1+6, 4);
        world.setBlock(x1+3, height+-2, z1+6, 4);
        world.setBlock(x1+3, height+-3, z1+6, 4);
        world.setBlock(x1+3, height+-4, z1+6, 4);
        world.setBlock(x1+3, height+-2, z1+6, 4);
        world.setBlock(x1+3, height+-3, z1+6, 4);
        world.setBlock(x1+3, height+-4, z1+6, 4);
        world.setBlock(x1+2, height+-1, z1+6, 4);
        world.setBlock(x1+2, height+-2, z1+6, 4);
        world.setBlock(x1+2, height+-3, z1+6, 4);
        world.setBlock(x1+2, height+-4, z1+6, 4);
        world.setBlock(x1+2, height+-2, z1+6, 4);
        world.setBlock(x1+2, height+-3, z1+6, 4);
        world.setBlock(x1+2, height+-4, z1+6, 4);
        world.setBlock(x1+1, height+-1, z1+6, 4);
        world.setBlock(x1+1, height+-2, z1+6, 4);
        world.setBlock(x1+1, height+-3, z1+6, 4);
        world.setBlock(x1+1, height+-4, z1+6, 4);
        world.setBlock(x1+1, height+-2, z1+6, 4);
        world.setBlock(x1+1, height+-3, z1+6, 4);
        world.setBlock(x1+1, height+-4, z1+6, 4);
        world.setBlock(x1+1, height+-1, z1+5, 4);
        world.setBlock(x1+1, height+-2, z1+5, 4);
        world.setBlock(x1+1, height+-3, z1+5, 4);
        world.setBlock(x1+1, height+-4, z1+5, 4);
        world.setBlock(x1+1, height+-2, z1+5, 4);
        world.setBlock(x1+1, height+-3, z1+5, 4);
        world.setBlock(x1+1, height+-4, z1+5, 4);
        world.setBlock(x1+1, height+-1, z1+4, 4);
        world.setBlock(x1+1, height+-2, z1+4, 4);
        world.setBlock(x1+1, height+-3, z1+4, 4);
        world.setBlock(x1+1, height+-4, z1+4, 4);
        world.setBlock(x1+1, height+-2, z1+4, 4);
        world.setBlock(x1+1, height+-3, z1+4, 4);
        world.setBlock(x1+1, height+-4, z1+4, 4);
        world.setBlock(x1+1, height+-1, z1+3, 4);
        world.setBlock(x1+1, height+-2, z1+3, 4);
        world.setBlock(x1+1, height+-3, z1+3, 4);
        world.setBlock(x1+1, height+-4, z1+3, 4);
        world.setBlock(x1+1, height+-2, z1+3, 4);
        world.setBlock(x1+1, height+-3, z1+3, 4);
        world.setBlock(x1+1, height+-4, z1+3, 4);
        world.setBlock(x1+1, height+-4, z1+1, 4);
        world.setBlock(x1+1, height+-4, z1+2, 4);
        world.setBlock(x1+2, height+0, z1+2, 4);
        world.setBlock(x1+2, height+0, z1+3, 4);
        world.setBlock(x1+2, height+0, z1+4, 4);
        world.setBlock(x1+2, height+0, z1+5, 4);
        world.setBlock(x1+2, height+0, z1+6, 4);
        world.setBlock(x1+1, height+0, z1+6, 4);
        world.setBlock(x1+1, height+0, z1+4, 4);
        world.setBlock(x1+1, height+0, z1+5, 4);
        world.setBlock(x1+1, height+0, z1+3, 4);
        world.setBlock(x1+3, height+0, z1+3, 4);
        world.setBlock(x1+4, height+0, z1+3, 4);
        world.setBlock(x1+5, height+0, z1+3, 4);
        world.setBlock(x1+6, height+0, z1+3, 4);
        world.setBlock(x1+7, height+0, z1+3, 4);
        world.setBlock(x1+8, height+0, z1+3, 4);
        world.setBlock(x1+9, height+0, z1+3, 4);
        world.setBlock(x1+9, height+0, z1+4, 4);
        world.setBlock(x1+9, height+0, z1+5, 4);
        world.setBlock(x1+8, height+0, z1+5, 4);
        world.setBlock(x1+7, height+0, z1+5, 4);
        world.setBlock(x1+6, height+0, z1+5, 4);
        world.setBlock(x1+5, height+0, z1+5, 4);
        world.setBlock(x1+4, height+0, z1+5, 4);
        world.setBlock(x1+3, height+0, z1+5, 4);
        world.setBlock(x1+3, height+0, z1+4, 4);
        world.setBlock(x1+4, height+0, z1+4, 4);
        world.setBlock(x1+5, height+0, z1+4, 4);
        world.setBlock(x1+6, height+0, z1+4, 4);
        world.setBlock(x1+7, height+0, z1+4, 4);
        world.setBlock(x1+8, height+0, z1+4, 4);
        world.setBlock(x1+8, height+0, z1+2, 4);
        world.setBlock(x1+6, height+0, z1+2, 4);
        world.setBlock(x1+7, height+0, z1+2, 4);
        world.setBlock(x1+9, height+0, z1+2, 4);
        world.setBlock(x1+9, height+0, z1+1, 4);
        world.setBlock(x1+8, height+0, z1+1, 4);
        world.setBlock(x1+7, height+0, z1+1, 4);
        world.setBlock(x1+6, height+0, z1+1, 4);
        world.setBlock(x1+3, height+0, z1+2, 4);
        world.setBlock(x1+2, height+0, z1+0, 4);
        world.setBlock(x1+3, height+0, z1+0, 4);
        world.setBlock(x1+4, height+0, z1+0, 4);
        world.setBlock(x1+4, height+0, z1+2, 4);
        world.setBlock(x1+5, height+0, z1+2, 4);
        world.setBlock(x1+5, height+0, z1+1, 4);
        world.setBlock(x1+5, height+0, z1+0, 4);
        world.setBlock(x1+4, height+-1, z1+1, 4);
        world.setBlock(x1+3, height+-2, z1+1, 4);
        world.setBlock(x1+2, height+-3, z1+1, 4);
        world.setBlock(x1+2, height+-4, z1+2, 4);
    }

    private void spawnHouse1(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        if (rand.nextInt(3) == 1 && world.doChunksNearChunkExist(x1+40, 0, z1+40, 0))
            spawnHouse1(world, x1+40, z1+40, rand);
        if (rand.nextInt(3) == 1 && world.doChunksNearChunkExist(x1-40, 0, z1, 0))
            spawnHouse2(world, x1-40, z1, rand);

        world.setBlock(x1+2, height+0, z1+-1, 159);
        world.setBlock(x1+3, height+0, z1+-2, 5);
        world.setBlock(x1+4, height+0, z1+-2, 5);
        world.setBlock(x1+5, height+0, z1+-2, 5);
        world.setBlock(x1+6, height+0, z1+-2, 5);
        world.setBlock(x1+7, height+0, z1+-2, 5);
        world.setBlock(x1+8, height+0, z1+-2, 5);
        world.setBlock(x1+9, height+0, z1+-2, 5);
        world.setBlock(x1+3, height+0, z1+-2, 5);
        world.setBlock(x1+4, height+0, z1+-3, 5);
        world.setBlock(x1+5, height+0, z1+-3, 5);
        world.setBlock(x1+6, height+0, z1+-3, 5);
        world.setBlock(x1+7, height+0, z1+-3, 5);
        world.setBlock(x1+8, height+0, z1+-3, 5);
        world.setBlock(x1+9, height+0, z1+-3, 5);
        world.setBlock(x1+3, height+0, z1+-3, 5);
        world.setBlock(x1+4, height+0, z1+-4, 5);
        world.setBlock(x1+5, height+0, z1+-4, 5);
        world.setBlock(x1+6, height+0, z1+-4, 5);
        world.setBlock(x1+7, height+0, z1+-4, 5);
        world.setBlock(x1+8, height+0, z1+-4, 5);
        world.setBlock(x1+9, height+0, z1+-4, 5);
        world.setBlock(x1+3, height+0, z1+-4, 5);
        world.setBlock(x1+4, height+0, z1+-5, 5);
        world.setBlock(x1+5, height+0, z1+-5, 5);
        world.setBlock(x1+6, height+0, z1+-5, 5);
        world.setBlock(x1+7, height+0, z1+-5, 5);
        world.setBlock(x1+8, height+0, z1+-5, 5);
        world.setBlock(x1+9, height+0, z1+-5, 5);
        world.setBlock(x1+3, height+0, z1+-5, 5);
        world.setBlock(x1+4, height+0, z1+-6, 5);
        world.setBlock(x1+5, height+0, z1+-6, 5);
        world.setBlock(x1+6, height+0, z1+-6, 5);
        world.setBlock(x1+7, height+0, z1+-6, 5);
        world.setBlock(x1+8, height+0, z1+-6, 5);
        world.setBlock(x1+9, height+1, z1+-7, 5);

        var villager = new EntityVillager(world, 2);
        villager.setLocationAndAngles(x1+9, height+1, z1+-6,  0, 0);
        world.spawnEntityInWorld(villager);

        world.setBlock(x1+9, height+2, z1+-7, 1031);
        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+9, height+2, z1+-7);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.diamondIngot, 5);

        var randomLoot = rand.nextInt(1, 4);

        if (randomLoot == 1)
            loot = new ItemStack(BTWItems.ironChisel, 1);
        if (randomLoot == 2)
            loot = new ItemStack(Item.ingotIron, 2);
        if (randomLoot == 3)
            loot = new ItemStack(BTWItems.porkDinner, 3);
        if (randomLoot == 4)
            loot = new ItemStack(Item.bucketMilk, 4);

        chest.setStorageStack(loot);

        world.setBlock(x1+9, height+0, z1+-6, 5);
        world.setBlock(x1+3, height+0, z1+-6, 5);
        world.setBlock(x1+4, height+0, z1+-7, 5);
        world.setBlock(x1+5, height+0, z1+-7, 5);
        world.setBlock(x1+6, height+0, z1+-7, 5);
        world.setBlock(x1+7, height+0, z1+-7, 5);
        world.setBlock(x1+8, height+0, z1+-7, 5);
        world.setBlock(x1+9, height+0, z1+-7, 5);
        world.setBlock(x1+3, height+0, z1+-7, 5);
        world.setBlock(x1+5, height+1, z1+-6, 5);
        world.setBlock(x1+6, height+1, z1+-6, 5);
        world.setBlock(x1+6, height+1, z1+-2, 4);
        world.setBlock(x1+5, height+1, z1+-2, 4);
        world.setBlock(x1+4, height+1, z1+-2, 4);
        world.setBlock(x1+3, height+1, z1+-2, 4);
        world.setBlock(x1+3, height+1, z1+-3, 4);
        world.setBlock(x1+3, height+1, z1+-4, 4);
        world.setBlock(x1+2, height+0, z1+-2, 159);
        world.setBlock(x1+2, height+0, z1+-3, 159);
        world.setBlock(x1+2, height+0, z1+-5, 159);
        world.setBlock(x1+2, height+0, z1+-4, 159);
        world.setBlock(x1+2, height+0, z1+-6, 159);
        world.setBlock(x1+2, height+0, z1+-7, 159);
        world.setBlock(x1+3, height+0, z1+-1, 159);
        world.setBlock(x1+4, height+0, z1+-1, 159);
        world.setBlock(x1+5, height+0, z1+-1, 159);
        world.setBlock(x1+6, height+0, z1+-1, 159);
        world.setBlock(x1+7, height+0, z1+-1, 159);
        world.setBlock(x1+8, height+0, z1+-1, 159);
        world.setBlock(x1+9, height+0, z1+-1, 159);
        world.setBlock(x1+2, height+0, z1+-8, 159);
        world.setBlock(x1+10, height+0, z1+-1, 159);
        world.setBlock(x1+10, height+0, z1+-2, 159);
        world.setBlock(x1+10, height+0, z1+-3, 159);
        world.setBlock(x1+10, height+0, z1+-5, 159);
        world.setBlock(x1+10, height+0, z1+-4, 159);
        world.setBlock(x1+10, height+0, z1+-6, 159);
        world.setBlock(x1+10, height+0, z1+-7, 159);
        world.setBlock(x1+10, height+0, z1+-8, 159);
        world.setBlock(x1+3, height+0, z1+-8, 159);
        world.setBlock(x1+4, height+0, z1+-8, 159);
        world.setBlock(x1+5, height+0, z1+-8, 159);
        world.setBlock(x1+6, height+0, z1+-8, 159);
        world.setBlock(x1+7, height+0, z1+-8, 159);
        world.setBlock(x1+8, height+0, z1+-8, 159);
        world.setBlock(x1+9, height+0, z1+-8, 159);
        world.setBlock(x1+2, height+1, z1+-1, 159);
        world.setBlock(x1+2, height+1, z1+-2, 159);
        world.setBlock(x1+2, height+1, z1+-3, 159);
        world.setBlock(x1+2, height+1, z1+-5, 159);
        world.setBlock(x1+2, height+1, z1+-4, 159);
        world.setBlock(x1+2, height+1, z1+-6, 159);
        world.setBlock(x1+2, height+1, z1+-7, 159);
        world.setBlock(x1+3, height+1, z1+-1, 159);
        world.setBlock(x1+4, height+1, z1+-1, 159);
        world.setBlock(x1+5, height+1, z1+-1, 159);
        world.setBlock(x1+6, height+1, z1+-1, 159);
        world.setBlock(x1+7, height+1, z1+-1, 159);
        world.setBlock(x1+9, height+1, z1+-1, 159);
        world.setBlock(x1+2, height+1, z1+-8, 159);
        world.setBlock(x1+10, height+1, z1+-1, 159);
        world.setBlock(x1+10, height+1, z1+-2, 159);
        world.setBlock(x1+10, height+1, z1+-3, 159);
        world.setBlock(x1+10, height+1, z1+-5, 159);
        world.setBlock(x1+10, height+1, z1+-4, 159);
        world.setBlock(x1+10, height+1, z1+-6, 159);
        world.setBlock(x1+10, height+1, z1+-7, 159);
        world.setBlock(x1+10, height+1, z1+-8, 159);
        world.setBlock(x1+3, height+1, z1+-8, 159);
        world.setBlock(x1+4, height+1, z1+-8, 159);
        world.setBlock(x1+5, height+1, z1+-8, 159);
        world.setBlock(x1+6, height+1, z1+-8, 159);
        world.setBlock(x1+7, height+1, z1+-8, 159);
        world.setBlock(x1+8, height+1, z1+-8, 159);
        world.setBlock(x1+9, height+1, z1+-8, 159);
        world.setBlock(x1+2, height+2, z1+-1, 159);
        world.setBlock(x1+2, height+2, z1+-2, 159);
        world.setBlock(x1+2, height+2, z1+-3, 159);
        world.setBlock(x1+2, height+2, z1+-5, 159);
        world.setBlock(x1+2, height+2, z1+-4, 102);
        world.setBlock(x1+2, height+2, z1+-6, 159);
        world.setBlock(x1+2, height+2, z1+-7, 159);
        world.setBlock(x1+3, height+2, z1+-1, 159);
        world.setBlock(x1+4, height+2, z1+-1, 159);
        world.setBlock(x1+5, height+2, z1+-1, 159);
        world.setBlock(x1+6, height+2, z1+-1, 102);
        world.setBlock(x1+7, height+2, z1+-1, 159);
        world.setBlock(x1+9, height+2, z1+-1, 159);
        world.setBlock(x1+2, height+2, z1+-8, 159);
        world.setBlock(x1+10, height+2, z1+-1, 159);
        world.setBlock(x1+10, height+2, z1+-2, 159);
        world.setBlock(x1+10, height+2, z1+-3, 159);
        world.setBlock(x1+10, height+2, z1+-5, 159);
        world.setBlock(x1+10, height+2, z1+-4, 102);
        world.setBlock(x1+10, height+2, z1+-6, 159);
        world.setBlock(x1+10, height+2, z1+-7, 159);
        world.setBlock(x1+10, height+2, z1+-8, 159);
        world.setBlock(x1+3, height+2, z1+-8, 102);
        world.setBlock(x1+4, height+2, z1+-8, 159);
        world.setBlock(x1+5, height+2, z1+-8, 159);
        world.setBlock(x1+6, height+2, z1+-8, 159);
        world.setBlock(x1+7, height+2, z1+-8, 102);
        world.setBlock(x1+8, height+2, z1+-8, 159);
        world.setBlock(x1+9, height+2, z1+-8, 159);
        world.setBlock(x1+2, height+3, z1+-1, 159);
        world.setBlock(x1+2, height+3, z1+-2, 159);
        world.setBlock(x1+2, height+3, z1+-3, 159);
        world.setBlock(x1+2, height+3, z1+-5, 159);
        world.setBlock(x1+2, height+3, z1+-4, 159);
        world.setBlock(x1+2, height+3, z1+-6, 159);
        world.setBlock(x1+2, height+3, z1+-7, 159);
        world.setBlock(x1+3, height+3, z1+-1, 159);
        world.setBlock(x1+4, height+3, z1+-1, 159);
        world.setBlock(x1+5, height+3, z1+-1, 159);
        world.setBlock(x1+6, height+3, z1+-1, 159);
        world.setBlock(x1+7, height+3, z1+-1, 159);
        world.setBlock(x1+8, height+3, z1+-1, 159);
        world.setBlock(x1+9, height+3, z1+-1, 159);
        world.setBlock(x1+9, height+4, z1+-1, 159);
        world.setBlock(x1+8, height+4, z1+-1, 159);
        world.setBlock(x1+7, height+4, z1+-1, 159);
        world.setBlock(x1+6, height+4, z1+-1, 159);
        world.setBlock(x1+5, height+4, z1+-1, 159);
        world.setBlock(x1+4, height+4, z1+-1, 159);
        world.setBlock(x1+3, height+4, z1+-1, 159);
        world.setBlock(x1+4, height+5, z1+-1, 159);
        world.setBlock(x1+5, height+5, z1+-1, 159);
        world.setBlock(x1+6, height+5, z1+-1, 159);
        world.setBlock(x1+7, height+5, z1+-1, 159);
        world.setBlock(x1+8, height+5, z1+-1, 159);
        world.setBlock(x1+7, height+6, z1+-1, 159);
        world.setBlock(x1+6, height+6, z1+-1, 159);
        world.setBlock(x1+5, height+6, z1+-1, 159);
        world.setBlock(x1+6, height+7, z1+-1, 159);
        world.setBlock(x1+9, height+4, z1+-8, 159);
        world.setBlock(x1+8, height+4, z1+-8, 159);
        world.setBlock(x1+7, height+4, z1+-8, 159);
        world.setBlock(x1+6, height+4, z1+-8, 159);
        world.setBlock(x1+5, height+4, z1+-8, 159);
        world.setBlock(x1+4, height+4, z1+-8, 159);
        world.setBlock(x1+3, height+4, z1+-8, 159);
        world.setBlock(x1+4, height+5, z1+-8, 159);
        world.setBlock(x1+5, height+5, z1+-8, 159);
        world.setBlock(x1+6, height+5, z1+-8, 159);
        world.setBlock(x1+7, height+5, z1+-8, 159);
        world.setBlock(x1+8, height+5, z1+-8, 159);
        world.setBlock(x1+7, height+6, z1+-8, 159);
        world.setBlock(x1+6, height+6, z1+-8, 159);
        world.setBlock(x1+5, height+6, z1+-8, 159);
        world.setBlock(x1+6, height+7, z1+-8, 159);
        world.setBlock(x1+2, height+3, z1+-8, 159);
        world.setBlock(x1+10, height+3, z1+-1, 159);
        world.setBlock(x1+11, height+3, z1+-1, 5);
        world.setBlock(x1+11, height+3, z1+-2, 5);
        world.setBlock(x1+11, height+3, z1+-3, 5);
        world.setBlock(x1+11, height+3, z1+-4, 5);
        world.setBlock(x1+11, height+3, z1+-5, 5);
        world.setBlock(x1+11, height+3, z1+-6, 5);
        world.setBlock(x1+11, height+3, z1+-7, 5);
        world.setBlock(x1+11, height+3, z1+-8, 5);
        world.setBlock(x1+10, height+4, z1+-1, 5);
        world.setBlock(x1+10, height+4, z1+-2, 5);
        world.setBlock(x1+10, height+4, z1+-3, 5);
        world.setBlock(x1+10, height+4, z1+-4, 5);
        world.setBlock(x1+10, height+4, z1+-5, 5);
        world.setBlock(x1+10, height+4, z1+-6, 5);
        world.setBlock(x1+10, height+4, z1+-7, 5);
        world.setBlock(x1+10, height+4, z1+-8, 5);
        world.setBlock(x1+1, height+3, z1+-1, 5);
        world.setBlock(x1+1, height+3, z1+-2, 5);
        world.setBlock(x1+1, height+3, z1+-3, 5);
        world.setBlock(x1+1, height+3, z1+-4, 5);
        world.setBlock(x1+1, height+3, z1+-5, 5);
        world.setBlock(x1+1, height+3, z1+-6, 5);
        world.setBlock(x1+1, height+3, z1+-7, 5);
        world.setBlock(x1+1, height+3, z1+-8, 5);
        world.setBlock(x1+2, height+4, z1+-1, 5);
        world.setBlock(x1+2, height+4, z1+-2, 5);
        world.setBlock(x1+2, height+4, z1+-3, 5);
        world.setBlock(x1+2, height+4, z1+-4, 5);
        world.setBlock(x1+2, height+4, z1+-5, 5);
        world.setBlock(x1+2, height+4, z1+-6, 5);
        world.setBlock(x1+2, height+4, z1+-7, 5);
        world.setBlock(x1+2, height+4, z1+-8, 5);
        world.setBlock(x1+3, height+5, z1+-1, 5);
        world.setBlock(x1+3, height+5, z1+-2, 5);
        world.setBlock(x1+3, height+5, z1+-3, 5);
        world.setBlock(x1+3, height+5, z1+-4, 5);
        world.setBlock(x1+3, height+5, z1+-5, 5);
        world.setBlock(x1+3, height+5, z1+-6, 5);
        world.setBlock(x1+3, height+5, z1+-7, 5);
        world.setBlock(x1+3, height+5, z1+-8, 5);
        world.setBlock(x1+4, height+6, z1+-1, 5);
        world.setBlock(x1+4, height+6, z1+-2, 5);
        world.setBlock(x1+4, height+6, z1+-3, 5);
        world.setBlock(x1+4, height+6, z1+-4, 5);
        world.setBlock(x1+4, height+6, z1+-5, 5);
        world.setBlock(x1+4, height+6, z1+-6, 5);
        world.setBlock(x1+4, height+6, z1+-7, 5);
        world.setBlock(x1+4, height+6, z1+-8, 5);
        world.setBlock(x1+9, height+5, z1+-1, 5);
        world.setBlock(x1+9, height+5, z1+-2, 5);
        world.setBlock(x1+9, height+5, z1+-3, 5);
        world.setBlock(x1+9, height+5, z1+-4, 5);
        world.setBlock(x1+9, height+5, z1+-5, 5);
        world.setBlock(x1+9, height+5, z1+-6, 5);
        world.setBlock(x1+9, height+5, z1+-7, 5);
        world.setBlock(x1+9, height+5, z1+-8, 5);
        world.setBlock(x1+8, height+6, z1+-1, 5);
        world.setBlock(x1+8, height+6, z1+-2, 5);
        world.setBlock(x1+8, height+6, z1+-3, 5);
        world.setBlock(x1+8, height+6, z1+-4, 5);
        world.setBlock(x1+8, height+6, z1+-5, 5);
        world.setBlock(x1+8, height+6, z1+-6, 5);
        world.setBlock(x1+8, height+6, z1+-7, 5);
        world.setBlock(x1+8, height+6, z1+-8, 5);
        world.setBlock(x1+7, height+7, z1+-1, 5);
        world.setBlock(x1+7, height+7, z1+-2, 5);
        world.setBlock(x1+7, height+7, z1+-3, 5);
        world.setBlock(x1+7, height+7, z1+-4, 5);
        world.setBlock(x1+7, height+7, z1+-5, 5);
        world.setBlock(x1+7, height+7, z1+-6, 5);
        world.setBlock(x1+7, height+7, z1+-7, 5);
        world.setBlock(x1+7, height+7, z1+-8, 5);
        world.setBlock(x1+5, height+7, z1+-1, 5);
        world.setBlock(x1+5, height+7, z1+-2, 5);
        world.setBlock(x1+5, height+7, z1+-3, 5);
        world.setBlock(x1+5, height+7, z1+-4, 5);
        world.setBlock(x1+6, height+7, z1+-4, 89);
        world.setBlock(x1+6, height+7, z1+-5, 89);
        world.setBlock(x1+5, height+7, z1+-5, 5);
        world.setBlock(x1+5, height+7, z1+-6, 5);
        world.setBlock(x1+5, height+7, z1+-7, 5);
        world.setBlock(x1+5, height+7, z1+-8, 5);
        world.setBlock(x1+6, height+8, z1+-1, 5);
        world.setBlock(x1+6, height+8, z1+-2, 5);
        world.setBlock(x1+6, height+8, z1+-3, 5);
        world.setBlock(x1+6, height+8, z1+-4, 5);
        world.setBlock(x1+6, height+8, z1+-5, 5);
        world.setBlock(x1+6, height+8, z1+-6, 5);
        world.setBlock(x1+6, height+8, z1+-7, 5);
        world.setBlock(x1+6, height+8, z1+-8, 5);
        world.setBlock(x1+10, height+3, z1+-2, 159);
        world.setBlock(x1+10, height+3, z1+-3, 159);
        world.setBlock(x1+10, height+3, z1+-5, 159);
        world.setBlock(x1+10, height+3, z1+-4, 159);
        world.setBlock(x1+10, height+3, z1+-6, 159);
        world.setBlock(x1+10, height+3, z1+-7, 159);
        world.setBlock(x1+10, height+3, z1+-8, 159);
        world.setBlock(x1+3, height+3, z1+-8, 159);
        world.setBlock(x1+4, height+3, z1+-8, 159);
        world.setBlock(x1+5, height+3, z1+-8, 159);
        world.setBlock(x1+6, height+3, z1+-8, 159);
        world.setBlock(x1+7, height+3, z1+-8, 159);
        world.setBlock(x1+8, height+3, z1+-8, 159);
        world.setBlock(x1+9, height+3, z1+-8, 159);
    }

    private void spawnHouse2(World world, int x1, int z1, Random rand)
    {
        var height = world.getChunkHeightMapMinimum(x1, z1) + 1;

        if (rand.nextInt(3) == 1 && world.doChunksNearChunkExist(x1+40, 0, z1+40, 0))
            spawnHouse2(world, x1+40, z1+40, rand);
        if (rand.nextInt(3) == 1 && world.doChunksNearChunkExist(x1-40, 0, z1, 0))
            spawnHouse1(world, x1-40, z1, rand);

        world.setBlock(x1+2, height+0, z1+-1, 159);
        world.setBlock(x1+3, height+0, z1+-2, 5);
        world.setBlock(x1+4, height+0, z1+-2, 5);
        world.setBlock(x1+5, height+0, z1+-2, 5);
        world.setBlock(x1+6, height+0, z1+-2, 5);
        world.setBlock(x1+7, height+0, z1+-2, 5);
        world.setBlock(x1+8, height+0, z1+-2, 5);
        world.setBlock(x1+9, height+0, z1+-2, 5);
        world.setBlock(x1+3, height+0, z1+-2, 5);
        world.setBlock(x1+4, height+0, z1+-3, 5);
        world.setBlock(x1+5, height+0, z1+-3, 5);
        world.setBlock(x1+6, height+0, z1+-3, 5);
        world.setBlock(x1+7, height+0, z1+-3, 5);
        world.setBlock(x1+8, height+0, z1+-3, 5);
        world.setBlock(x1+9, height+0, z1+-3, 5);
        world.setBlock(x1+3, height+0, z1+-3, 5);
        world.setBlock(x1+4, height+0, z1+-4, 5);
        world.setBlock(x1+5, height+0, z1+-4, 5);
        world.setBlock(x1+6, height+0, z1+-4, 5);
        world.setBlock(x1+7, height+0, z1+-4, 5);
        world.setBlock(x1+8, height+0, z1+-4, 5);
        world.setBlock(x1+9, height+0, z1+-4, 5);
        world.setBlock(x1+3, height+0, z1+-4, 5);
        world.setBlock(x1+4, height+0, z1+-5, 5);
        world.setBlock(x1+5, height+0, z1+-5, 5);
        world.setBlock(x1+6, height+0, z1+-5, 5);
        world.setBlock(x1+7, height+0, z1+-5, 5);
        world.setBlock(x1+8, height+0, z1+-5, 5);
        world.setBlock(x1+9, height+0, z1+-5, 5);
        world.setBlock(x1+3, height+0, z1+-5, 5);
        world.setBlock(x1+4, height+0, z1+-6, 5);
        world.setBlock(x1+5, height+0, z1+-6, 5);
        world.setBlock(x1+6, height+0, z1+-6, 5);
        world.setBlock(x1+7, height+0, z1+-6, 5);
        world.setBlock(x1+8, height+0, z1+-6, 5);
        world.setBlock(x1+18, height+1, z1+-8, 5);
        world.setBlock(x1+9, height+1, z1+-11, 5);
        world.setBlock(x1+10, height+1, z1+-11, 5);
        world.setBlock(x1+11, height+1, z1+-11, 5);

        var villager = new EntityVillager(world, 0);
        villager.setLocationAndAngles(x1+17, height+1, z1+-8, 0, 0);
        world.spawnEntityInWorld(villager);

        world.setBlock(x1+18, height+2, z1+-8, 1031);
        var chest = (WickerBasketTileEntity)world.getBlockTileEntity(x1+18, height+2, z1+-8);

        if (chest == null)
            return;

        var loot = new ItemStack(BTWItems.diamondIngot, 5);

        var randomLoot = rand.nextInt(1, 4);

        if (randomLoot == 1)
            loot = new ItemStack(BTWItems.ironChisel, 1);
        if (randomLoot == 2)
            loot = new ItemStack(Item.ingotIron, 2);
        if (randomLoot == 3)
            loot = new ItemStack(BTWItems.porkDinner, 3);
        if (randomLoot == 4)
            loot = new ItemStack(Item.bucketMilk, 4);

        chest.setStorageStack(loot);


        world.setBlock(x1+9, height+0, z1+-6, 5);
        world.setBlock(x1+3, height+0, z1+-6, 5);
        world.setBlock(x1+4, height+0, z1+-7, 5);
        world.setBlock(x1+5, height+0, z1+-7, 5);
        world.setBlock(x1+6, height+0, z1+-7, 5);
        world.setBlock(x1+7, height+0, z1+-7, 5);
        world.setBlock(x1+8, height+0, z1+-7, 5);
        world.setBlock(x1+9, height+0, z1+-7, 5);
        world.setBlock(x1+3, height+0, z1+-7, 5);
        world.setBlock(x1+5, height+1, z1+-6, 5);
        world.setBlock(x1+6, height+1, z1+-6, 5);
        world.setBlock(x1+6, height+1, z1+-2, 4);
        world.setBlock(x1+5, height+1, z1+-2, 4);
        world.setBlock(x1+4, height+1, z1+-2, 4);
        world.setBlock(x1+3, height+1, z1+-2, 4);
        world.setBlock(x1+3, height+1, z1+-3, 4);
        world.setBlock(x1+3, height+1, z1+-4, 4);
        world.setBlock(x1+2, height+0, z1+-2, 159);
        world.setBlock(x1+2, height+0, z1+-3, 159);
        world.setBlock(x1+2, height+0, z1+-5, 159);
        world.setBlock(x1+2, height+0, z1+-4, 159);
        world.setBlock(x1+2, height+0, z1+-6, 159);
        world.setBlock(x1+2, height+0, z1+-7, 159);
        world.setBlock(x1+3, height+0, z1+-1, 159);
        world.setBlock(x1+4, height+0, z1+-1, 159);
        world.setBlock(x1+5, height+0, z1+-1, 159);
        world.setBlock(x1+6, height+0, z1+-1, 159);
        world.setBlock(x1+7, height+0, z1+-1, 159);
        world.setBlock(x1+8, height+0, z1+-1, 159);
        world.setBlock(x1+9, height+0, z1+-1, 159);
        world.setBlock(x1+2, height+0, z1+-8, 159);
        world.setBlock(x1+10, height+0, z1+-1, 159);
        world.setBlock(x1+10, height+0, z1+-2, 159);
        world.setBlock(x1+10, height+0, z1+-3, 159);
        world.setBlock(x1+10, height+0, z1+-5, 159);
        world.setBlock(x1+10, height+0, z1+-4, 159);
        world.setBlock(x1+10, height+0, z1+-6, 159);
        world.setBlock(x1+10, height+0, z1+-7, 159);
        world.setBlock(x1+10, height+0, z1+-8, 159);
        world.setBlock(x1+10, height+0, z1+-9, 159);
        world.setBlock(x1+9, height+0, z1+-9, 159);
        world.setBlock(x1+7, height+0, z1+-9, 159);
        world.setBlock(x1+8, height+0, z1+-9, 159);
        world.setBlock(x1+6, height+0, z1+-9, 159);
        world.setBlock(x1+5, height+0, z1+-9, 159);
        world.setBlock(x1+4, height+0, z1+-9, 159);
        world.setBlock(x1+3, height+0, z1+-9, 159);
        world.setBlock(x1+2, height+0, z1+-9, 159);
        world.setBlock(x1+10, height+0, z1+-10, 159);
        world.setBlock(x1+9, height+0, z1+-10, 159);
        world.setBlock(x1+7, height+0, z1+-10, 159);
        world.setBlock(x1+8, height+0, z1+-10, 159);
        world.setBlock(x1+6, height+0, z1+-10, 159);
        world.setBlock(x1+5, height+0, z1+-10, 159);
        world.setBlock(x1+4, height+0, z1+-10, 159);
        world.setBlock(x1+3, height+0, z1+-10, 159);
        world.setBlock(x1+2, height+0, z1+-10, 159);
        world.setBlock(x1+10, height+0, z1+-11, 159);
        world.setBlock(x1+9, height+0, z1+-11, 159);
        world.setBlock(x1+7, height+0, z1+-11, 159);
        world.setBlock(x1+8, height+0, z1+-11, 159);
        world.setBlock(x1+6, height+0, z1+-11, 159);
        world.setBlock(x1+5, height+0, z1+-11, 159);
        world.setBlock(x1+4, height+0, z1+-11, 159);
        world.setBlock(x1+3, height+0, z1+-11, 159);
        world.setBlock(x1+2, height+0, z1+-11, 159);
        world.setBlock(x1+10, height+0, z1+-12, 159);
        world.setBlock(x1+9, height+0, z1+-12, 159);
        world.setBlock(x1+7, height+0, z1+-12, 159);
        world.setBlock(x1+8, height+0, z1+-12, 159);
        world.setBlock(x1+6, height+0, z1+-12, 159);
        world.setBlock(x1+5, height+0, z1+-12, 159);
        world.setBlock(x1+4, height+0, z1+-12, 159);
        world.setBlock(x1+3, height+0, z1+-12, 159);
        world.setBlock(x1+2, height+0, z1+-12, 159);
        world.setBlock(x1+10, height+0, z1+-13, 159);
        world.setBlock(x1+9, height+0, z1+-13, 159);
        world.setBlock(x1+7, height+0, z1+-13, 159);
        world.setBlock(x1+8, height+0, z1+-13, 159);
        world.setBlock(x1+6, height+0, z1+-13, 159);
        world.setBlock(x1+5, height+0, z1+-13, 159);
        world.setBlock(x1+4, height+0, z1+-13, 159);
        world.setBlock(x1+3, height+0, z1+-13, 159);
        world.setBlock(x1+2, height+0, z1+-13, 159);
        world.setBlock(x1+19, height+0, z1+-13, 159);
        world.setBlock(x1+18, height+0, z1+-13, 159);
        world.setBlock(x1+16, height+0, z1+-13, 159);
        world.setBlock(x1+17, height+0, z1+-13, 159);
        world.setBlock(x1+15, height+0, z1+-13, 159);
        world.setBlock(x1+14, height+0, z1+-13, 159);
        world.setBlock(x1+13, height+0, z1+-13, 159);
        world.setBlock(x1+12, height+0, z1+-13, 159);
        world.setBlock(x1+11, height+0, z1+-13, 159);
        world.setBlock(x1+19, height+0, z1+-12, 159);
        world.setBlock(x1+18, height+0, z1+-12, 159);
        world.setBlock(x1+16, height+0, z1+-12, 159);
        world.setBlock(x1+17, height+0, z1+-12, 159);
        world.setBlock(x1+15, height+0, z1+-12, 159);
        world.setBlock(x1+14, height+0, z1+-12, 159);
        world.setBlock(x1+13, height+0, z1+-12, 159);
        world.setBlock(x1+12, height+0, z1+-12, 159);
        world.setBlock(x1+11, height+0, z1+-12, 159);
        world.setBlock(x1+19, height+0, z1+-11, 159);
        world.setBlock(x1+18, height+0, z1+-11, 159);
        world.setBlock(x1+16, height+0, z1+-11, 159);
        world.setBlock(x1+17, height+0, z1+-11, 159);
        world.setBlock(x1+15, height+0, z1+-11, 159);
        world.setBlock(x1+14, height+0, z1+-11, 159);
        world.setBlock(x1+13, height+0, z1+-11, 159);
        world.setBlock(x1+12, height+0, z1+-11, 159);
        world.setBlock(x1+11, height+0, z1+-11, 159);
        world.setBlock(x1+19, height+0, z1+-10, 159);
        world.setBlock(x1+18, height+0, z1+-10, 159);
        world.setBlock(x1+16, height+0, z1+-10, 159);
        world.setBlock(x1+17, height+0, z1+-10, 159);
        world.setBlock(x1+15, height+0, z1+-10, 159);
        world.setBlock(x1+14, height+0, z1+-10, 159);
        world.setBlock(x1+13, height+0, z1+-10, 159);
        world.setBlock(x1+12, height+0, z1+-10, 159);
        world.setBlock(x1+11, height+0, z1+-10, 159);
        world.setBlock(x1+19, height+0, z1+-9, 159);
        world.setBlock(x1+18, height+0, z1+-9, 159);
        world.setBlock(x1+16, height+0, z1+-9, 159);
        world.setBlock(x1+17, height+0, z1+-9, 159);
        world.setBlock(x1+15, height+0, z1+-9, 159);
        world.setBlock(x1+14, height+0, z1+-9, 159);
        world.setBlock(x1+13, height+0, z1+-9, 159);
        world.setBlock(x1+12, height+0, z1+-9, 159);
        world.setBlock(x1+11, height+0, z1+-9, 159);
        world.setBlock(x1+19, height+0, z1+-8, 159);
        world.setBlock(x1+18, height+0, z1+-8, 159);
        world.setBlock(x1+16, height+0, z1+-8, 159);
        world.setBlock(x1+17, height+0, z1+-8, 159);
        world.setBlock(x1+15, height+0, z1+-8, 159);
        world.setBlock(x1+14, height+0, z1+-8, 159);
        world.setBlock(x1+13, height+0, z1+-8, 159);
        world.setBlock(x1+12, height+0, z1+-8, 159);
        world.setBlock(x1+11, height+0, z1+-8, 159);
        world.setBlock(x1+19, height+0, z1+-7, 159);
        world.setBlock(x1+18, height+0, z1+-7, 159);
        world.setBlock(x1+16, height+0, z1+-7, 159);
        world.setBlock(x1+17, height+0, z1+-7, 159);
        world.setBlock(x1+15, height+0, z1+-7, 159);
        world.setBlock(x1+14, height+0, z1+-7, 159);
        world.setBlock(x1+13, height+0, z1+-7, 159);
        world.setBlock(x1+12, height+0, z1+-7, 159);
        world.setBlock(x1+11, height+0, z1+-7, 159);
        world.setBlock(x1+3, height+0, z1+-8, 159);
        world.setBlock(x1+4, height+0, z1+-8, 159);
        world.setBlock(x1+5, height+0, z1+-8, 159);
        world.setBlock(x1+6, height+0, z1+-8, 159);
        world.setBlock(x1+7, height+0, z1+-8, 159);
        world.setBlock(x1+8, height+0, z1+-8, 159);
        world.setBlock(x1+9, height+0, z1+-8, 159);
        world.setBlock(x1+2, height+1, z1+-1, 159);
        world.setBlock(x1+2, height+1, z1+-2, 159);
        world.setBlock(x1+2, height+1, z1+-3, 159);
        world.setBlock(x1+2, height+1, z1+-5, 159);
        world.setBlock(x1+2, height+1, z1+-4, 159);
        world.setBlock(x1+2, height+1, z1+-6, 159);
        world.setBlock(x1+2, height+1, z1+-7, 159);
        world.setBlock(x1+3, height+1, z1+-1, 159);
        world.setBlock(x1+4, height+1, z1+-1, 159);
        world.setBlock(x1+5, height+1, z1+-1, 159);
        world.setBlock(x1+6, height+1, z1+-1, 159);
        world.setBlock(x1+7, height+1, z1+-1, 159);
        world.setBlock(x1+9, height+1, z1+-1, 159);
        world.setBlock(x1+2, height+1, z1+-8, 159);
        world.setBlock(x1+10, height+1, z1+-1, 159);
        world.setBlock(x1+10, height+1, z1+-2, 159);
        world.setBlock(x1+10, height+1, z1+-3, 159);
        world.setBlock(x1+10, height+1, z1+-5, 159);
        world.setBlock(x1+10, height+1, z1+-4, 159);
        world.setBlock(x1+10, height+1, z1+-6, 159);
        world.setBlock(x1+10, height+1, z1+-7, 159);
        world.setBlock(x1+2, height+2, z1+-1, 159);
        world.setBlock(x1+2, height+2, z1+-2, 159);
        world.setBlock(x1+2, height+2, z1+-3, 159);
        world.setBlock(x1+2, height+2, z1+-5, 159);
        world.setBlock(x1+2, height+2, z1+-4, 102);
        world.setBlock(x1+2, height+2, z1+-6, 159);
        world.setBlock(x1+2, height+2, z1+-7, 159);
        world.setBlock(x1+3, height+2, z1+-1, 159);
        world.setBlock(x1+4, height+2, z1+-1, 159);
        world.setBlock(x1+5, height+2, z1+-1, 159);
        world.setBlock(x1+6, height+2, z1+-1, 102);
        world.setBlock(x1+7, height+2, z1+-1, 159);
        world.setBlock(x1+9, height+2, z1+-1, 159);
        world.setBlock(x1+2, height+2, z1+-8, 159);
        world.setBlock(x1+10, height+2, z1+-1, 159);
        world.setBlock(x1+10, height+2, z1+-2, 159);
        world.setBlock(x1+10, height+2, z1+-3, 159);
        world.setBlock(x1+10, height+2, z1+-5, 159);
        world.setBlock(x1+10, height+2, z1+-4, 102);
        world.setBlock(x1+10, height+2, z1+-6, 159);
        world.setBlock(x1+10, height+2, z1+-7, 159);
        world.setBlock(x1+2, height+3, z1+-1, 159);
        world.setBlock(x1+2, height+3, z1+-2, 159);
        world.setBlock(x1+2, height+3, z1+-3, 159);
        world.setBlock(x1+2, height+3, z1+-5, 159);
        world.setBlock(x1+2, height+3, z1+-4, 159);
        world.setBlock(x1+2, height+3, z1+-6, 159);
        world.setBlock(x1+2, height+3, z1+-7, 159);
        world.setBlock(x1+3, height+3, z1+-1, 159);
        world.setBlock(x1+4, height+3, z1+-1, 159);
        world.setBlock(x1+5, height+3, z1+-1, 159);
        world.setBlock(x1+6, height+3, z1+-1, 159);
        world.setBlock(x1+7, height+3, z1+-1, 159);
        world.setBlock(x1+8, height+3, z1+-1, 159);
        world.setBlock(x1+9, height+3, z1+-1, 159);
        world.setBlock(x1+9, height+4, z1+-1, 159);
        world.setBlock(x1+8, height+4, z1+-1, 159);
        world.setBlock(x1+7, height+4, z1+-1, 159);
        world.setBlock(x1+6, height+4, z1+-1, 159);
        world.setBlock(x1+5, height+4, z1+-1, 159);
        world.setBlock(x1+4, height+4, z1+-1, 159);
        world.setBlock(x1+3, height+4, z1+-1, 159);
        world.setBlock(x1+4, height+5, z1+-1, 159);
        world.setBlock(x1+5, height+5, z1+-1, 159);
        world.setBlock(x1+6, height+5, z1+-1, 159);
        world.setBlock(x1+7, height+5, z1+-1, 159);
        world.setBlock(x1+8, height+5, z1+-1, 159);
        world.setBlock(x1+7, height+6, z1+-1, 159);
        world.setBlock(x1+6, height+6, z1+-1, 159);
        world.setBlock(x1+5, height+6, z1+-1, 159);
        world.setBlock(x1+6, height+7, z1+-1, 159);
        world.setBlock(x1+2, height+3, z1+-8, 159);
        world.setBlock(x1+2, height+1, z1+-9, 159);
        world.setBlock(x1+2, height+2, z1+-9, 159);
        world.setBlock(x1+2, height+3, z1+-9, 159);
        world.setBlock(x1+2, height+1, z1+-10, 159);
        world.setBlock(x1+2, height+2, z1+-10, 159);
        world.setBlock(x1+2, height+3, z1+-10, 159);
        world.setBlock(x1+2, height+1, z1+-11, 159);
        world.setBlock(x1+2, height+2, z1+-11, 159);
        world.setBlock(x1+2, height+3, z1+-11, 159);
        world.setBlock(x1+2, height+1, z1+-12, 159);
        world.setBlock(x1+2, height+2, z1+-12, 159);
        world.setBlock(x1+2, height+3, z1+-12, 159);
        world.setBlock(x1+2, height+1, z1+-13, 159);
        world.setBlock(x1+2, height+2, z1+-13, 159);
        world.setBlock(x1+2, height+3, z1+-13, 159);
        world.setBlock(x1+3, height+1, z1+-13, 159);
        world.setBlock(x1+3, height+2, z1+-13, 159);
        world.setBlock(x1+3, height+3, z1+-13, 159);
        world.setBlock(x1+4, height+1, z1+-13, 159);
        world.setBlock(x1+4, height+2, z1+-13, 159);
        world.setBlock(x1+4, height+3, z1+-13, 159);
        world.setBlock(x1+5, height+1, z1+-13, 159);
        world.setBlock(x1+5, height+2, z1+-13, 159);
        world.setBlock(x1+5, height+3, z1+-13, 159);
        world.setBlock(x1+6, height+1, z1+-13, 159);
        world.setBlock(x1+6, height+2, z1+-13, 159);
        world.setBlock(x1+6, height+3, z1+-13, 159);
        world.setBlock(x1+7, height+1, z1+-13, 159);
        world.setBlock(x1+7, height+2, z1+-13, 159);
        world.setBlock(x1+7, height+3, z1+-13, 159);
        world.setBlock(x1+8, height+1, z1+-13, 159);
        world.setBlock(x1+8, height+2, z1+-13, 159);
        world.setBlock(x1+8, height+3, z1+-13, 159);
        world.setBlock(x1+9, height+1, z1+-13, 159);
        world.setBlock(x1+9, height+2, z1+-13, 159);
        world.setBlock(x1+9, height+3, z1+-13, 159);
        world.setBlock(x1+10, height+1, z1+-13, 159);
        world.setBlock(x1+10, height+2, z1+-13, 159);
        world.setBlock(x1+10, height+3, z1+-13, 159);
        world.setBlock(x1+11, height+1, z1+-13, 159);
        world.setBlock(x1+11, height+2, z1+-13, 159);
        world.setBlock(x1+11, height+3, z1+-13, 159);
        world.setBlock(x1+12, height+1, z1+-13, 159);
        world.setBlock(x1+12, height+2, z1+-13, 159);
        world.setBlock(x1+12, height+3, z1+-13, 159);
        world.setBlock(x1+13, height+1, z1+-13, 159);
        world.setBlock(x1+13, height+2, z1+-13, 159);
        world.setBlock(x1+13, height+3, z1+-13, 159);
        world.setBlock(x1+14, height+1, z1+-13, 159);
        world.setBlock(x1+14, height+2, z1+-13, 159);
        world.setBlock(x1+14, height+3, z1+-13, 159);
        world.setBlock(x1+15, height+1, z1+-13, 159);
        world.setBlock(x1+15, height+2, z1+-13, 159);
        world.setBlock(x1+15, height+3, z1+-13, 159);
        world.setBlock(x1+16, height+1, z1+-13, 159);
        world.setBlock(x1+16, height+2, z1+-13, 159);
        world.setBlock(x1+16, height+3, z1+-13, 159);
        world.setBlock(x1+17, height+1, z1+-13, 159);
        world.setBlock(x1+17, height+2, z1+-13, 159);
        world.setBlock(x1+17, height+3, z1+-13, 159);
        world.setBlock(x1+18, height+1, z1+-13, 159);
        world.setBlock(x1+18, height+2, z1+-13, 159);
        world.setBlock(x1+18, height+3, z1+-13, 159);
        world.setBlock(x1+19, height+1, z1+-13, 159);
        world.setBlock(x1+19, height+2, z1+-13, 159);
        world.setBlock(x1+19, height+3, z1+-13, 159);
        world.setBlock(x1+19, height+1, z1+-12, 159);
        world.setBlock(x1+19, height+2, z1+-12, 159);
        world.setBlock(x1+19, height+3, z1+-12, 159);
        world.setBlock(x1+19, height+1, z1+-11, 159);
        world.setBlock(x1+19, height+2, z1+-11, 159);
        world.setBlock(x1+19, height+3, z1+-11, 159);
        world.setBlock(x1+19, height+1, z1+-10, 159);
        world.setBlock(x1+19, height+2, z1+-10, 159);
        world.setBlock(x1+19, height+3, z1+-10, 159);
        world.setBlock(x1+19, height+1, z1+-9, 159);
        world.setBlock(x1+19, height+2, z1+-9, 159);
        world.setBlock(x1+19, height+3, z1+-9, 159);
        world.setBlock(x1+19, height+1, z1+-8, 159);
        world.setBlock(x1+19, height+2, z1+-8, 159);
        world.setBlock(x1+19, height+3, z1+-8, 159);
        world.setBlock(x1+19, height+4, z1+-12, 159);
        world.setBlock(x1+19, height+4, z1+-11, 159);
        world.setBlock(x1+19, height+4, z1+-10, 159);
        world.setBlock(x1+19, height+4, z1+-9, 159);
        world.setBlock(x1+19, height+5, z1+-11, 159);
        world.setBlock(x1+19, height+5, z1+-10, 159);
        world.setBlock(x1+19, height+6, z1+-10, 159);
        world.setBlock(x1+19, height+5, z1+-9, 159);
        world.setBlock(x1+19, height+4, z1+-8, 159);
        world.setBlock(x1+19, height+1, z1+-7, 159);
        world.setBlock(x1+19, height+2, z1+-7, 159);
        world.setBlock(x1+19, height+3, z1+-7, 159);
        world.setBlock(x1+18, height+1, z1+-7, 159);
        world.setBlock(x1+18, height+2, z1+-7, 159);
        world.setBlock(x1+18, height+3, z1+-7, 159);
        world.setBlock(x1+17, height+1, z1+-7, 159);
        world.setBlock(x1+17, height+2, z1+-7, 159);
        world.setBlock(x1+17, height+3, z1+-7, 159);
        world.setBlock(x1+15, height+1, z1+-7, 159);
        world.setBlock(x1+15, height+2, z1+-7, 159);
        world.setBlock(x1+15, height+3, z1+-7, 159);
        world.setBlock(x1+16, height+1, z1+-7, 159);
        world.setBlock(x1+16, height+2, z1+-7, 159);
        world.setBlock(x1+16, height+3, z1+-7, 159);
        world.setBlock(x1+13, height+1, z1+-7, 159);
        world.setBlock(x1+13, height+2, z1+-7, 159);
        world.setBlock(x1+13, height+3, z1+-7, 159);
        world.setBlock(x1+14, height+1, z1+-7, 159);
        world.setBlock(x1+14, height+2, z1+-7, 159);
        world.setBlock(x1+14, height+3, z1+-7, 159);
        world.setBlock(x1+12, height+1, z1+-7, 159);
        world.setBlock(x1+12, height+2, z1+-7, 159);
        world.setBlock(x1+12, height+3, z1+-7, 159);
        world.setBlock(x1+11, height+1, z1+-7, 159);
        world.setBlock(x1+11, height+2, z1+-7, 159);
        world.setBlock(x1+11, height+3, z1+-7, 159);
        world.setBlock(x1+10, height+3, z1+-1, 159);
        world.setBlock(x1+11, height+3, z1+-1, 5);
        world.setBlock(x1+11, height+3, z1+-2, 5);
        world.setBlock(x1+11, height+3, z1+-3, 5);
        world.setBlock(x1+11, height+3, z1+-4, 5);
        world.setBlock(x1+11, height+3, z1+-5, 5);
        world.setBlock(x1+11, height+3, z1+-6, 5);
        world.setBlock(x1+12, height+3, z1+-6, 5);
        world.setBlock(x1+13, height+3, z1+-6, 5);
        world.setBlock(x1+14, height+3, z1+-6, 5);
        world.setBlock(x1+15, height+3, z1+-6, 5);
        world.setBlock(x1+16, height+3, z1+-6, 5);
        world.setBlock(x1+17, height+3, z1+-6, 5);
        world.setBlock(x1+18, height+3, z1+-6, 5);
        world.setBlock(x1+19, height+3, z1+-6, 5);
        world.setBlock(x1+12, height+3, z1+-14, 5);
        world.setBlock(x1+13, height+3, z1+-14, 5);
        world.setBlock(x1+14, height+3, z1+-14, 5);
        world.setBlock(x1+15, height+3, z1+-14, 5);
        world.setBlock(x1+16, height+3, z1+-14, 5);
        world.setBlock(x1+17, height+3, z1+-14, 5);
        world.setBlock(x1+18, height+3, z1+-14, 5);
        world.setBlock(x1+19, height+3, z1+-14, 5);
        world.setBlock(x1+4, height+3, z1+-14, 5);
        world.setBlock(x1+5, height+3, z1+-14, 5);
        world.setBlock(x1+2, height+3, z1+-14, 5);
        world.setBlock(x1+3, height+3, z1+-14, 5);
        world.setBlock(x1+6, height+3, z1+-14, 5);
        world.setBlock(x1+7, height+3, z1+-14, 5);
        world.setBlock(x1+8, height+3, z1+-14, 5);
        world.setBlock(x1+9, height+3, z1+-14, 5);
        world.setBlock(x1+10, height+3, z1+-14, 5);
        world.setBlock(x1+11, height+3, z1+-14, 5);
        world.setBlock(x1+10, height+4, z1+-1, 5);
        world.setBlock(x1+10, height+4, z1+-2, 5);
        world.setBlock(x1+10, height+4, z1+-3, 5);
        world.setBlock(x1+10, height+4, z1+-4, 5);
        world.setBlock(x1+10, height+4, z1+-5, 5);
        world.setBlock(x1+10, height+4, z1+-6, 5);
        world.setBlock(x1+10, height+4, z1+-7, 5);
        world.setBlock(x1+1, height+3, z1+-1, 5);
        world.setBlock(x1+1, height+3, z1+-2, 5);
        world.setBlock(x1+1, height+3, z1+-3, 5);
        world.setBlock(x1+1, height+3, z1+-4, 5);
        world.setBlock(x1+1, height+3, z1+-5, 5);
        world.setBlock(x1+1, height+3, z1+-6, 5);
        world.setBlock(x1+1, height+3, z1+-7, 5);
        world.setBlock(x1+1, height+3, z1+-8, 5);
        world.setBlock(x1+1, height+3, z1+-9, 5);
        world.setBlock(x1+1, height+3, z1+-10, 5);
        world.setBlock(x1+1, height+3, z1+-11, 5);
        world.setBlock(x1+1, height+3, z1+-12, 5);
        world.setBlock(x1+1, height+3, z1+-13, 5);
        world.setBlock(x1+1, height+3, z1+-14, 5);
        world.setBlock(x1+2, height+4, z1+-1, 5);
        world.setBlock(x1+2, height+4, z1+-2, 5);
        world.setBlock(x1+2, height+4, z1+-3, 5);
        world.setBlock(x1+2, height+4, z1+-4, 5);
        world.setBlock(x1+2, height+4, z1+-5, 5);
        world.setBlock(x1+2, height+4, z1+-6, 5);
        world.setBlock(x1+2, height+4, z1+-7, 5);
        world.setBlock(x1+2, height+4, z1+-8, 5);
        world.setBlock(x1+2, height+4, z1+-9, 5);
        world.setBlock(x1+2, height+4, z1+-10, 5);
        world.setBlock(x1+2, height+4, z1+-11, 5);
        world.setBlock(x1+2, height+4, z1+-12, 5);
        world.setBlock(x1+2, height+4, z1+-13, 5);
        world.setBlock(x1+4, height+4, z1+-13, 5);
        world.setBlock(x1+3, height+4, z1+-13, 5);
        world.setBlock(x1+5, height+4, z1+-13, 5);
        world.setBlock(x1+6, height+4, z1+-13, 5);
        world.setBlock(x1+7, height+4, z1+-13, 5);
        world.setBlock(x1+8, height+4, z1+-13, 5);
        world.setBlock(x1+9, height+4, z1+-13, 5);
        world.setBlock(x1+10, height+4, z1+-13, 5);
        world.setBlock(x1+11, height+4, z1+-13, 5);
        world.setBlock(x1+12, height+4, z1+-13, 5);
        world.setBlock(x1+13, height+4, z1+-13, 5);
        world.setBlock(x1+14, height+4, z1+-13, 5);
        world.setBlock(x1+15, height+4, z1+-13, 5);
        world.setBlock(x1+16, height+4, z1+-13, 5);
        world.setBlock(x1+17, height+4, z1+-13, 5);
        world.setBlock(x1+18, height+4, z1+-13, 5);
        world.setBlock(x1+19, height+4, z1+-13, 5);
        world.setBlock(x1+11, height+4, z1+-7, 5);
        world.setBlock(x1+12, height+4, z1+-7, 5);
        world.setBlock(x1+13, height+4, z1+-7, 5);
        world.setBlock(x1+14, height+4, z1+-7, 5);
        world.setBlock(x1+15, height+4, z1+-7, 5);
        world.setBlock(x1+16, height+4, z1+-7, 5);
        world.setBlock(x1+17, height+4, z1+-7, 5);
        world.setBlock(x1+18, height+4, z1+-7, 5);
        world.setBlock(x1+19, height+4, z1+-7, 5);
        world.setBlock(x1+3, height+5, z1+-1, 5);
        world.setBlock(x1+3, height+5, z1+-2, 5);
        world.setBlock(x1+3, height+5, z1+-3, 5);
        world.setBlock(x1+3, height+5, z1+-4, 5);
        world.setBlock(x1+3, height+5, z1+-5, 5);
        world.setBlock(x1+3, height+5, z1+-6, 5);
        world.setBlock(x1+3, height+5, z1+-7, 5);
        world.setBlock(x1+4, height+6, z1+-1, 5);
        world.setBlock(x1+4, height+6, z1+-2, 5);
        world.setBlock(x1+4, height+6, z1+-3, 5);
        world.setBlock(x1+4, height+6, z1+-4, 5);
        world.setBlock(x1+4, height+6, z1+-5, 5);
        world.setBlock(x1+4, height+6, z1+-6, 5);
        world.setBlock(x1+4, height+6, z1+-7, 5);
        world.setBlock(x1+4, height+6, z1+-8, 5);
        world.setBlock(x1+4, height+6, z1+-9, 5);
        world.setBlock(x1+4, height+6, z1+-10, 5);
        world.setBlock(x1+4, height+6, z1+-11, 5);
        world.setBlock(x1+5, height+6, z1+-11, 5);
        world.setBlock(x1+6, height+6, z1+-11, 5);
        world.setBlock(x1+7, height+6, z1+-11, 5);
        world.setBlock(x1+8, height+6, z1+-11, 5);
        world.setBlock(x1+9, height+6, z1+-11, 5);
        world.setBlock(x1+10, height+6, z1+-11, 5);
        world.setBlock(x1+11, height+6, z1+-11, 5);
        world.setBlock(x1+12, height+6, z1+-11, 5);
        world.setBlock(x1+13, height+6, z1+-11, 5);
        world.setBlock(x1+14, height+6, z1+-11, 5);
        world.setBlock(x1+15, height+6, z1+-11, 5);
        world.setBlock(x1+16, height+6, z1+-11, 5);
        world.setBlock(x1+17, height+6, z1+-11, 5);
        world.setBlock(x1+18, height+6, z1+-11, 5);
        world.setBlock(x1+19, height+6, z1+-11, 5);
        world.setBlock(x1+19, height+6, z1+-9, 5);
        world.setBlock(x1+18, height+6, z1+-9, 5);
        world.setBlock(x1+17, height+6, z1+-9, 5);
        world.setBlock(x1+16, height+6, z1+-9, 5);
        world.setBlock(x1+15, height+6, z1+-9, 5);
        world.setBlock(x1+14, height+6, z1+-9, 5);
        world.setBlock(x1+13, height+6, z1+-9, 5);
        world.setBlock(x1+12, height+6, z1+-9, 5);
        world.setBlock(x1+11, height+6, z1+-9, 5);
        world.setBlock(x1+10, height+6, z1+-9, 5);
        world.setBlock(x1+9, height+6, z1+-9, 5);
        world.setBlock(x1+8, height+6, z1+-9, 5);
        world.setBlock(x1+8, height+6, z1+-8, 5);
        world.setBlock(x1+9, height+5, z1+-1, 5);
        world.setBlock(x1+9, height+5, z1+-2, 5);
        world.setBlock(x1+9, height+5, z1+-3, 5);
        world.setBlock(x1+9, height+5, z1+-4, 5);
        world.setBlock(x1+9, height+5, z1+-5, 5);
        world.setBlock(x1+9, height+5, z1+-6, 5);
        world.setBlock(x1+9, height+5, z1+-7, 5);
        world.setBlock(x1+9, height+5, z1+-8, 5);
        world.setBlock(x1+10, height+5, z1+-8, 5);
        world.setBlock(x1+11, height+5, z1+-8, 5);
        world.setBlock(x1+12, height+5, z1+-8, 5);
        world.setBlock(x1+13, height+5, z1+-8, 5);
        world.setBlock(x1+14, height+5, z1+-8, 5);
        world.setBlock(x1+15, height+5, z1+-8, 5);
        world.setBlock(x1+16, height+5, z1+-8, 5);
        world.setBlock(x1+17, height+5, z1+-8, 5);
        world.setBlock(x1+18, height+5, z1+-8, 5);
        world.setBlock(x1+19, height+5, z1+-8, 5);
        world.setBlock(x1+19, height+5, z1+-12, 5);
        world.setBlock(x1+18, height+5, z1+-12, 5);
        world.setBlock(x1+17, height+5, z1+-12, 5);
        world.setBlock(x1+16, height+5, z1+-12, 5);
        world.setBlock(x1+15, height+5, z1+-12, 5);
        world.setBlock(x1+14, height+5, z1+-12, 5);
        world.setBlock(x1+13, height+5, z1+-12, 5);
        world.setBlock(x1+12, height+5, z1+-12, 5);
        world.setBlock(x1+11, height+5, z1+-12, 5);
        world.setBlock(x1+10, height+5, z1+-12, 5);
        world.setBlock(x1+9, height+5, z1+-12, 5);
        world.setBlock(x1+7, height+5, z1+-12, 5);
        world.setBlock(x1+6, height+5, z1+-12, 5);
        world.setBlock(x1+5, height+5, z1+-12, 5);
        world.setBlock(x1+4, height+5, z1+-12, 5);
        world.setBlock(x1+3, height+5, z1+-12, 5);
        world.setBlock(x1+3, height+5, z1+-11, 5);
        world.setBlock(x1+3, height+5, z1+-10, 5);
        world.setBlock(x1+3, height+5, z1+-9, 5);
        world.setBlock(x1+3, height+5, z1+-8, 5);
        world.setBlock(x1+8, height+5, z1+-12, 5);
        world.setBlock(x1+8, height+6, z1+-1, 5);
        world.setBlock(x1+8, height+6, z1+-2, 5);
        world.setBlock(x1+8, height+6, z1+-3, 5);
        world.setBlock(x1+8, height+6, z1+-4, 5);
        world.setBlock(x1+8, height+6, z1+-5, 5);
        world.setBlock(x1+8, height+6, z1+-6, 5);
        world.setBlock(x1+8, height+6, z1+-7, 5);
        world.setBlock(x1+7, height+7, z1+-1, 5);
        world.setBlock(x1+7, height+7, z1+-2, 5);
        world.setBlock(x1+7, height+7, z1+-3, 5);
        world.setBlock(x1+7, height+7, z1+-4, 5);
        world.setBlock(x1+7, height+7, z1+-5, 5);
        world.setBlock(x1+7, height+7, z1+-6, 5);
        world.setBlock(x1+7, height+7, z1+-7, 5);
        world.setBlock(x1+7, height+7, z1+-8, 5);
        world.setBlock(x1+7, height+7, z1+-9, 5);
        world.setBlock(x1+7, height+7, z1+-10, 5);
        world.setBlock(x1+8, height+7, z1+-10, 5);
        world.setBlock(x1+9, height+7, z1+-10, 5);
        world.setBlock(x1+10, height+7, z1+-10, 5);
        world.setBlock(x1+11, height+7, z1+-10, 5);
        world.setBlock(x1+12, height+7, z1+-10, 5);
        world.setBlock(x1+13, height+7, z1+-10, 5);
        world.setBlock(x1+14, height+7, z1+-10, 5);
        world.setBlock(x1+15, height+7, z1+-10, 5);
        world.setBlock(x1+16, height+7, z1+-10, 5);
        world.setBlock(x1+17, height+7, z1+-10, 5);
        world.setBlock(x1+18, height+7, z1+-10, 5);
        world.setBlock(x1+19, height+7, z1+-10, 5);
        world.setBlock(x1+5, height+7, z1+-1, 5);
        world.setBlock(x1+5, height+7, z1+-2, 5);
        world.setBlock(x1+5, height+7, z1+-3, 5);
        world.setBlock(x1+5, height+7, z1+-4, 5);
        world.setBlock(x1+6, height+7, z1+-4, 89);
        world.setBlock(x1+6, height+7, z1+-5, 89);
        world.setBlock(x1+15, height+6, z1+-10, 89);
        world.setBlock(x1+5, height+7, z1+-5, 5);
        world.setBlock(x1+5, height+7, z1+-6, 5);
        world.setBlock(x1+5, height+7, z1+-7, 5);
        world.setBlock(x1+5, height+7, z1+-8, 5);
        world.setBlock(x1+5, height+7, z1+-9, 5);
        world.setBlock(x1+5, height+7, z1+-10, 5);
        world.setBlock(x1+6, height+7, z1+-10, 5);
        world.setBlock(x1+5, height+6, z1+-7, 5);
        world.setBlock(x1+5, height+6, z1+-7, 5);
        world.setBlock(x1+6, height+8, z1+-1, 5);
        world.setBlock(x1+6, height+8, z1+-2, 5);
        world.setBlock(x1+6, height+8, z1+-3, 5);
        world.setBlock(x1+6, height+8, z1+-4, 5);
        world.setBlock(x1+6, height+8, z1+-5, 5);
        world.setBlock(x1+6, height+8, z1+-6, 5);
        world.setBlock(x1+6, height+8, z1+-7, 5);
        world.setBlock(x1+6, height+8, z1+-8, 5);
        world.setBlock(x1+6, height+8, z1+-8, 5);
        world.setBlock(x1+6, height+8, z1+-9, 5);
        world.setBlock(x1+10, height+3, z1+-2, 159);
        world.setBlock(x1+10, height+3, z1+-3, 159);
        world.setBlock(x1+10, height+3, z1+-5, 159);
        world.setBlock(x1+10, height+3, z1+-4, 159);
        world.setBlock(x1+10, height+3, z1+-6, 159);
        world.setBlock(x1+10, height+3, z1+-7, 159);

    }
}