package com.sgs.skyblocks.island;

import org.apache.logging.log4j.Level;

import com.sgs.skyblocks.SkyBlocks;
import com.sgs.skyblocks.utils.SkyBlocksLogger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class IslandGenerator {
	private SkyBlocksLogger logger = SkyBlocks.getLogger();
	private int island_height = 100;
	public IslandGenerator() {
        logger.entering("createIsland", this.getClass().getName());
        logger.log(Level.INFO, "Finished creating player island.");
        logger.exiting("createIsland", this.getClass().getName());
	}
	public static BlockPos createIsland(final EntityPlayer player) {
		IslandGenerator gen = new IslandGenerator();
		BlockPos pos = player.getPosition();
		gen.generateIslandBlocks(pos.getX(), pos.getZ(), player, player.getEntityWorld());
        return new BlockPos(pos);
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
        world.setBlockState(blockToChange, Block.getBlockById(54).getDefaultState());
    }
}
