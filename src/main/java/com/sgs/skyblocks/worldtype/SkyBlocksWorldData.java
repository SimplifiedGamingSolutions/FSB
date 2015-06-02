package com.sgs.skyblocks.worldtype;

import java.util.HashMap;

import com.sgs.skyblocks.utils.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

public class SkyBlocksWorldData extends WorldSavedData {
	private NBTTagCompound data = new NBTTagCompound();
	final static String key = "SkyBlocks";
    public SkyBlocksWorldData(String tagName) {
        super(tagName);
    }

    public static SkyBlocksWorldData forWorld(World world) {
        // Retrieves the MyWorldData instance for the given world, creating it if necessary
		MapStorage storage = world.getPerWorldStorage();
		SkyBlocksWorldData result = (SkyBlocksWorldData)storage.loadData(SkyBlocksWorldData.class, key);
		if (result == null) {
			result = new SkyBlocksWorldData(key);
			storage.setData(key, result);
		}
		return result;
	}
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
   	 data = compound.getCompoundTag("SkyBlocks");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setTag("SkyBlocks", data);
    }

    public NBTTagCompound getData() {
        return data;
    }
    
    public static BlockPos getLastIslandBlockPos(World world)
    {
    	SkyBlocksWorldData data = forWorld(world);
    	long position = data.getData().getLong("lastIsland");
    	if(position != 0)
    		return BlockPos.fromLong(position);
    	return null;
    }
    
    public static void setLastIslandBlockPos(World world, BlockPos pos)
    {
    	SkyBlocksWorldData data = forWorld(world);
    	data.getData().setLong("lastIsland", pos.toLong());
    }

	public static void addIsland(EntityPlayer player, BlockPos pos) {

		SkyBlocksWorldData data = SkyBlocksWorldData.forWorld(player.getEntityWorld());
		byte[] islandsbytes = data.getData().getByteArray("islands");
		HashMap<String, Long> islands;
		if(islandsbytes.length != 0)
		{
			islands = (HashMap<String, Long>)Utils.fromBytes(islandsbytes);
		}
		else
		{
			islands = new HashMap<String, Long>();
		}
		islands.put(player.getName(), pos.toLong());
		data.getData().setByteArray("islands", Utils.toBytes(islands));
		data.markDirty();
	}

	public static BlockPos getIslandOrigin(EntityPlayer player) {
		SkyBlocksWorldData data = SkyBlocksWorldData.forWorld(player.getEntityWorld());
		byte[] islandsbytes = data.getData().getByteArray("islands");
		HashMap<String, Long> islands;
		if(islandsbytes.length != 0)
		{
			islands = (HashMap<String, Long>)Utils.fromBytes(islandsbytes);
		}
		else
		{
			islands = new HashMap<String, Long>();
		}
		return BlockPos.fromLong(islands.get(player.getName()));
	}

}