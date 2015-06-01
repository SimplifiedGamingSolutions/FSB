package com.sgs.skyblocks.island;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;

import com.sgs.skyblocks.SkyBlocks;
import com.sgs.skyblocks.utils.SkyBlocksLogger;
import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

public class IslandGenerator {
	private SkyBlocksLogger logger = SkyBlocks.getLogger();
	private static int island_height;
	private static int island_distance;
	
	public IslandGenerator() {
        logger.entering("constructor", this.getClass().getName());
        island_height = SkyBlocks.config.getInt("island_height", "island_location_config", 58, 0, 250, "The height of the base of the island. The island is conscructed from bottom to top.");
        island_distance = SkyBlocks.config.getInt("island_distance", "island_location_config", 150, 20, 255, "The distance between islands.");
        
        if(SkyBlocks.config.hasChanged())
        {
        	SkyBlocks.config.save();
        }
        logger.exiting("constructor", this.getClass().getName());
	}
	public static Vec3 createIsland(final EntityPlayer player) {
		IslandGenerator gen = new IslandGenerator();
		BlockPos pos = getLastIslandPosition(player);
		SkyBlocksWorldData.setLastIslandBlockPos(player.getEntityWorld(), pos);
		gen.generateIslandBlocks(pos.getX(), pos.getZ(), player, player.getEntityWorld());
		Vec3 home = new Vec3(pos.getX()+.5, pos.getY()+5.5, pos.getZ()+2.5);
        return home;
    }
	private static BlockPos getLastIslandPosition(EntityPlayer player)
	{
		BlockPos last = SkyBlocksWorldData.getLastIslandBlockPos(player.getEntityWorld());
		if(last != null)
			return getNextIslandPosition(last);
		return new BlockPos(0,island_height,0);
	}
	private static BlockPos getNextIslandPosition(BlockPos p) {
		final int x = p.getX();
	    final int z = p.getZ();
	    if (x < z) {
	        if (-1 * x < z) {
	        	p = new BlockPos(p.getX()+island_distance, p.getY(), p.getZ());
	            return p;
	        }
	        p = new BlockPos(p.getX(), p.getY(), p.getZ()+island_distance);
	        return p;
	    } else if (x > z) {
	        if (-1 * x >= z) {
	        	p = new BlockPos(p.getX()-island_distance, p.getY(), p.getZ());
	            return p;
	        }
	        p = new BlockPos(p.getX(), p.getY(), p.getZ()-island_distance);
	        return p;
	    } else {
	        if (x <= 0) {
	        	p = new BlockPos(p.getX(), p.getY(), p.getZ()+island_distance);
	            return p;
	        }
	        p = new BlockPos(p.getX(), p.getY(), p.getZ()-island_distance);
	        return p;
	    }
	}
	public void generateIslandBlocks(final int x, final int z, final EntityPlayer player, final World world) {
        final int y = island_height;
        BlockPos pos = new BlockPos(x, y, z);
        world.setBlockState(pos, Blocks.dirt.getDefaultState());
        this.islandLayer1(x, z, player, world);
        this.islandLayer2(x, z, player, world);
        this.islandLayer3(x, z, player, world);
        this.islandLayer4(x, z, player, world);
        this.islandExtras(x, z, player, world);
    }
	private void islandLayer4(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 4;
        for (int x_operate = x - 3; x_operate <= x + 3; ++x_operate) {
            for (int z_operate = z - 3; z_operate <= z + 3; ++z_operate) {
                world.setBlockState(new BlockPos(x_operate, y, z_operate), Block.getStateById(2));
            }
        }
        BlockPos blockToChange2 = new BlockPos(x - 3, y, z + 3);
        world.setBlockState(blockToChange2, Block.getStateById(0));
        blockToChange2 = new BlockPos(x - 3, y, z - 3);
        world.setBlockState(blockToChange2, Block.getStateById(0));
        blockToChange2 = new BlockPos(x + 3, y, z - 3);
        world.setBlockState(blockToChange2, Block.getStateById(0));
        blockToChange2 = new BlockPos(x + 3, y, z + 3);
        world.setBlockState(blockToChange2, Block.getStateById(0));
    }

    private void islandLayer3(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 3;
        for (int x_operate = x - 2; x_operate <= x + 2; ++x_operate) {
            for (int z_operate = z - 2; z_operate <= z + 2; ++z_operate) {
                final BlockPos blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getStateById(3));
            }
        }
        BlockPos blockToChange2 = new BlockPos(x - 3, y, z);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x + 3, y, z);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x, y, z - 3);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x, y, z + 3);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x, y, z);
        world.setBlockState(blockToChange2, Block.getStateById(12));
    }

    private void islandLayer2(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 2;
        for (int x_operate = x - 1; x_operate <= x + 1; ++x_operate) {
            for (int z_operate = z - 1; z_operate <= z + 1; ++z_operate) {
                final BlockPos blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getStateById(3));
            }
        }
        BlockPos blockToChange2 = new BlockPos(x - 2, y, z);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x + 2, y, z);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x, y, z - 2);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x, y, z + 2);
        world.setBlockState(blockToChange2, Block.getStateById(3));
        blockToChange2 = new BlockPos(x, y, z);
        world.setBlockState(blockToChange2, Block.getStateById(12));
    }

    private void islandLayer1(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 1;
        BlockPos blockToChange = new BlockPos(x - 1, y, z);
        world.setBlockState(blockToChange, Block.getStateById(3));
        blockToChange = new BlockPos(x + 1, y, z);
        world.setBlockState(blockToChange, Block.getStateById(3));
        blockToChange = new BlockPos(x, y, z - 1);
        world.setBlockState(blockToChange, Block.getStateById(3));
        blockToChange = new BlockPos(x, y, z + 1);
        world.setBlockState(blockToChange, Block.getStateById(3));
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getStateById(12));
    }

    private void islandExtras(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height;
        BlockPos blockToChange = new BlockPos(x, y + 5, z);
        world.setBlockState(blockToChange, Block.getStateById(17));
        blockToChange = new BlockPos(x, y + 6, z);
        world.setBlockState(blockToChange, Block.getStateById(17));
        blockToChange = new BlockPos(x, y + 7, z);
        world.setBlockState(blockToChange, Block.getStateById(17));
        y = island_height + 8;
        for (int x_operate = x - 2; x_operate <= x + 2; ++x_operate) {
            for (int z_operate = z - 2; z_operate <= z + 2; ++z_operate) {
                blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getStateById(18));
            }
        }
        blockToChange = new BlockPos(x + 2, y, z + 2);
        world.setBlockState(blockToChange, Block.getStateById(0));
        blockToChange = new BlockPos(x + 2, y, z - 2);
        world.setBlockState(blockToChange, Block.getStateById(0));
        blockToChange = new BlockPos(x - 2, y, z + 2);
        world.setBlockState(blockToChange, Block.getStateById(0));
        blockToChange = new BlockPos(x - 2, y, z - 2);
        world.setBlockState(blockToChange, Block.getStateById(0));
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getStateById(17));
        y = island_height + 9;
        for (int x_operate = x - 1; x_operate <= x + 1; ++x_operate) {
            for (int z_operate = z - 1; z_operate <= z + 1; ++z_operate) {
                blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getStateById(18));
            }
        }
        blockToChange = new BlockPos(x - 2, y, z);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x + 2, y, z);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, y, z - 2);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, y, z + 2);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getStateById(17));
        y = island_height + 10;
        blockToChange = new BlockPos(x - 1, y, z);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x + 1, y, z);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, y, z - 1);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, y, z + 1);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getStateById(17));
        blockToChange = new BlockPos(x, y + 1, z);
        world.setBlockState(blockToChange, Block.getStateById(18));
        blockToChange = new BlockPos(x, island_height + 5, z + 1);
        world.setBlockState(blockToChange, Block.getStateById(54).withProperty(BlockChest.FACING, EnumFacing.SOUTH));
        populateChest(world, blockToChange);
    }
	private void populateChest(World world, BlockPos chestPosition)
	{
		TileEntityChest chest = (TileEntityChest)world.getTileEntity(chestPosition);
		if(SkyBlocks.config.getCategory("island_chest_items").isEmpty())
		{
			SkyBlocks.config.get("island_chest_items", "79", 2, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "360", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "81", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "327", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "40", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "39", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "361", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "338", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.get("island_chest_items", "323", 1, "Example add five cobblestone to chest 'I:4=5'");
			SkyBlocks.config.save();
		}
		ConfigCategory cat = SkyBlocks.config.getCategory("island_chest_items");
		Map<String, Property> items = cat.getValues();
		int i = 0;
		for(String itemID : items.keySet())
		{
			int id = Integer.parseInt(itemID);
			int amount = items.get(itemID).getInt();
			chest.setInventorySlotContents(i, new ItemStack(Item.getItemById(id), amount));
			i++;
		}
	}
}
