package com.sgs.skyblocks.island;

import java.io.Serializable;

import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public class Island implements Serializable{
	private static final long serialVersionUID = -2764714174014196528L;
	
	private String player;
	private BlockPos location;
	
	public Island(EntityPlayer player) {
		this.player = player.getName();
		SkyBlocksWorldData data = SkyBlocksWorldData.forWorld(player.getEntityWorld());
		data.getData().setLong("location", player.getPosition().toLong());
		data.markDirty();
		location = IslandGenerator.createIsland(player);
	}

	public BlockPos getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

}
