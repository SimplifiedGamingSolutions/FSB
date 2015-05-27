package com.sgs.skyblocks.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PlayerInfo{
	private EntityPlayer player;
	private NBTTagCompound playerInfo;
	
	public PlayerInfo(EntityPlayer player) {
		this.player = player;
		playerInfo = player.getEntityData();
	}
    
}
