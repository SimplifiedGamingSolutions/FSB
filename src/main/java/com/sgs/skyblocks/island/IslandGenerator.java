package com.sgs.skyblocks.island;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

import com.sgs.skyblocks.SkyBlocks;
import com.sgs.skyblocks.utils.SkyBlocksLogger;
import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

public class IslandGenerator {
	private SkyBlocksLogger logger = SkyBlocks.getLogger();
	private static int island_height = 50;
	private static int island_distance = 150;
	public IslandGenerator() {
        logger.entering("createIsland", this.getClass().getName());
        logger.log(Level.INFO, "Finished creating player island.");
        logger.exiting("createIsland", this.getClass().getName());
	}
	public static BlockPos createIsland(final EntityPlayer player) {
		IslandGenerator gen = new IslandGenerator();
		BlockPos pos = getLastIslandPosition(player);
		SkyBlocksWorldData.setLastIslandBlockPos(player.getEntityWorld(), pos);
		gen.generateIslandBlocks(pos.getX(), pos.getZ(), player, player.getEntityWorld());
        return new BlockPos(pos);
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
	        	p = new BlockPos(p.getX()+island_distance, p.getY()+0, p.getZ()+0);
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
	private void islandLayer1(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 4;
        for (int x_operate = x - 3; x_operate <= x + 3; ++x_operate) {
            for (int z_operate = z - 3; z_operate <= z + 3; ++z_operate) {
                world.setBlockState(new BlockPos(x_operate, y, z_operate), Block.getBlockById(2).getDefaultState());
            }
        }
        BlockPos blockToChange2 = new BlockPos(x - 3, y, z + 3);
        world.setBlockState(blockToChange2, Block.getBlockById(0).getDefaultState());
        blockToChange2 = new BlockPos(x - 3, y, z - 3);
        world.setBlockState(blockToChange2, Block.getBlockById(0).getDefaultState());
        blockToChange2 = new BlockPos(x + 3, y, z - 3);
        world.setBlockState(blockToChange2, Block.getBlockById(0).getDefaultState());
        blockToChange2 = new BlockPos(x + 3, y, z + 3);
        world.setBlockState(blockToChange2, Block.getBlockById(0).getDefaultState());
    }

    private void islandLayer2(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 3;
        for (int x_operate = x - 2; x_operate <= x + 2; ++x_operate) {
            for (int z_operate = z - 2; z_operate <= z + 2; ++z_operate) {
                final BlockPos blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getBlockById(3).getDefaultState());
            }
        }
        BlockPos blockToChange2 = new BlockPos(x - 3, y, z);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x + 3, y, z);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x, y, z - 3);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x, y, z + 3);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x, y, z);
        world.setBlockState(blockToChange2, Block.getBlockById(12).getDefaultState());
    }

    private void islandLayer3(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 2;
        for (int x_operate = x - 1; x_operate <= x + 1; ++x_operate) {
            for (int z_operate = z - 1; z_operate <= z + 1; ++z_operate) {
                final BlockPos blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getBlockById(3).getDefaultState());
            }
        }
        BlockPos blockToChange2 = new BlockPos(x - 2, y, z);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x + 2, y, z);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x, y, z - 2);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x, y, z + 2);
        world.setBlockState(blockToChange2, Block.getBlockById(3).getDefaultState());
        blockToChange2 = new BlockPos(x, y, z);
        world.setBlockState(blockToChange2, Block.getBlockById(12).getDefaultState());
    }

    private void islandLayer4(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height + 1;
        BlockPos blockToChange = new BlockPos(x - 1, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(3).getDefaultState());
        blockToChange = new BlockPos(x + 1, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(3).getDefaultState());
        blockToChange = new BlockPos(x, y, z - 1);
        world.setBlockState(blockToChange, Block.getBlockById(3).getDefaultState());
        blockToChange = new BlockPos(x, y, z + 1);
        world.setBlockState(blockToChange, Block.getBlockById(3).getDefaultState());
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(12).getDefaultState());
    }

    private void islandExtras(final int x, final int z, final EntityPlayer player, final World world) {
        int y = island_height;
        BlockPos blockToChange = new BlockPos(x, y + 5, z);
        world.setBlockState(blockToChange, Block.getBlockById(17).getDefaultState());
        blockToChange = new BlockPos(x, y + 6, z);
        world.setBlockState(blockToChange, Block.getBlockById(17).getDefaultState());
        blockToChange = new BlockPos(x, y + 7, z);
        world.setBlockState(blockToChange, Block.getBlockById(17).getDefaultState());
        y = island_height + 8;
        for (int x_operate = x - 2; x_operate <= x + 2; ++x_operate) {
            for (int z_operate = z - 2; z_operate <= z + 2; ++z_operate) {
                blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
            }
        }
        blockToChange = new BlockPos(x + 2, y, z + 2);
        world.setBlockState(blockToChange, Block.getBlockById(0).getDefaultState());
        blockToChange = new BlockPos(x + 2, y, z - 2);
        world.setBlockState(blockToChange, Block.getBlockById(0).getDefaultState());
        blockToChange = new BlockPos(x - 2, y, z + 2);
        world.setBlockState(blockToChange, Block.getBlockById(0).getDefaultState());
        blockToChange = new BlockPos(x - 2, y, z - 2);
        world.setBlockState(blockToChange, Block.getBlockById(0).getDefaultState());
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(17).getDefaultState());
        y = island_height + 9;
        for (int x_operate = x - 1; x_operate <= x + 1; ++x_operate) {
            for (int z_operate = z - 1; z_operate <= z + 1; ++z_operate) {
                blockToChange = new BlockPos(x_operate, y, z_operate);
                world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
            }
        }
        blockToChange = new BlockPos(x - 2, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x + 2, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, y, z - 2);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, y, z + 2);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(17).getDefaultState());
        y = island_height + 10;
        blockToChange = new BlockPos(x - 1, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x + 1, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, y, z - 1);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, y, z + 1);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, y, z);
        world.setBlockState(blockToChange, Block.getBlockById(17).getDefaultState());
        blockToChange = new BlockPos(x, y + 1, z);
        world.setBlockState(blockToChange, Block.getBlockById(18).getDefaultState());
        blockToChange = new BlockPos(x, island_height + 5, z + 1);
        world.setBlockState(blockToChange.west().south(), Block.getBlockById(54).getDefaultState());
    }
}
