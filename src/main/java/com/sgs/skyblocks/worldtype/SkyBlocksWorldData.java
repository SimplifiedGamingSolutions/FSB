package com.sgs.skyblocks.worldtype;

import net.minecraft.nbt.NBTTagCompound;
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

}