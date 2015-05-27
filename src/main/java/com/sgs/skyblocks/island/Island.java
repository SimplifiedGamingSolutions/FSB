package com.sgs.skyblocks.island;

import java.io.Serializable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public class Island implements Serializable{
	private static final long serialVersionUID = -2764714174014196528L;
	
	private String player;
	private BlockPos location;
	
	public Island(EntityPlayer player) {
		this.player = player.getName();
		location = IslandGenerator.createIsland(player);
	}

}
