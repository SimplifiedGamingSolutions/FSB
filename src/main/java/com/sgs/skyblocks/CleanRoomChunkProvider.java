package com.sgs.skyblocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class CleanRoomChunkProvider implements IChunkProvider {
	 private World worldObj;
	    private Random random;
	    private final byte[] cachedBlockIDs = new byte[256];
	    private final byte[] cachedBlockMetadata = new byte[256];
	    private final List structureGenerators = new ArrayList();
	    private WorldGenLakes waterLakeGenerator;
	    private WorldGenLakes lavaLakeGenerator;

	    public CleanRoomChunkProvider(World par1World, long par2, boolean par4)
	    {
	        this.worldObj = par1World;
	        this.random = new Random(par2);
	    }

	    /**
	     * loads or generates the chunk at the chunk location specified
	     */
	    public Chunk loadChunk(int par1, int par2)
	    {
	        return this.provideChunk(par1, par2);
	    }


	    /**
	     * Checks to see if a chunk exists at x, y
	     */
	    public boolean chunkExists(int par1, int par2)
	    {
	        return false;
	    }

	    /**
	     * Populates chunk with ores etc etc
	     */
	    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	    {
	    }

	    /**
	     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
	     * Return true if all chunks have been saved.
	     */
	    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
	    {
	        return true;
	    }

	    /**
	     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
	     * unimplemented.
	     */
	    public void saveExtraData() {}

	    /**
	     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
	     */
	    public boolean unloadQueuedChunks()
	    {
	        return false;
	    }

	    /**
	     * Returns if the IChunkProvider supports saving.
	     */
	    public boolean canSave()
	    {
	        return true;
	    }

	    /**
	     * Converts the instance data to a readable string.
	     */
	    public String makeString()
	    {
	        return "FlatLevelSource";
	    }

	    /**
	     * Returns the location of the closest structure of the specified type. If not found returns null.
	     */
	    public BlockPos findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5)
	    {
	        return null;
	    }

	    public int getLoadedChunkCount()
	    {
	        return 0;
	    }


		@Override
		public Chunk provideChunk(BlockPos blockPosIn) {
	        Chunk chunk = new Chunk(this.worldObj, blockPosIn.getX(), blockPosIn.getZ());
	        chunk.generateSkylightMap();
	        return chunk;
		}

		@Override
		public boolean func_177460_a(IChunkProvider p_177460_1_,
				Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List func_177458_a(EnumCreatureType p_177458_1_,
				BlockPos p_177458_2_) {
	        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(new BlockPos(p_177458_2_.getX(), p_177458_2_.getY(), p_177458_2_.getZ()));
	        return biomegenbase == null ? null : biomegenbase.getSpawnableList(p_177458_1_);
		}

		@Override
		public BlockPos getStrongholdGen(World worldIn, String p_180513_2_,
				BlockPos p_180513_3_) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void recreateStructures(Chunk p_180514_1_, int p_180514_2_,
				int p_180514_3_) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Chunk provideChunk(int x, int z) {
	        Chunk chunk = new Chunk(this.worldObj, x, z);
	        chunk.generateSkylightMap();
	        return chunk;
		}
}
