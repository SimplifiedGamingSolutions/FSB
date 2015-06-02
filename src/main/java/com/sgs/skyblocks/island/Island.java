package com.sgs.skyblocks.island;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;

import com.sgs.skyblocks.utils.Utils;
import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

public class Island implements Serializable{
	private static final long serialVersionUID = -2764714174014196528L;
	
	private HashSet<String> completedChallenges = new HashSet<String>();
	private double x;
	private double y;
	private double z;
	private float yaw;
	private float pitch;
	private LocalDateTime created;
	
	public Island(EntityPlayer player) {
		this.created = LocalDateTime.now();
		BlockPos pos = IslandGenerator.createIsland(player);
		SkyBlocksWorldData.addIsland(player, pos);
		
		setHome(new Vec3(pos.getX()+.5, pos.getY()+5.5, pos.getZ()+2.5), -180F, 50F);
		player.addChatMessage(new ChatComponentText("Island created!"));
	}
	
	public void setHome(Vec3 pos)
	{
		this.x=pos.xCoord;
		this.y=pos.yCoord;
		this.z=pos.zCoord;
	}
	public void setHome(BlockPos pos)
	{
		this.x=pos.getX();
		this.y=pos.getY();
		this.z=pos.getZ();
	}
	public void setHome(Vec3 pos, float yaw, float pitch)
	{
		this.x=pos.xCoord;
		this.y=pos.yCoord;
		this.z=pos.zCoord;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	public void setHome(BlockPos pos, float yaw, float pitch)
	{
		this.x=pos.getX();
		this.y=pos.getY();
		this.z=pos.getZ();
	}

	public Vec3 getHomeVector() {
		// TODO Auto-generated method stub
		return new Vec3(x,y,z);
	}
	
	public float getPitch(){
		return pitch;
	}
	
	public float getYaw(){
		return yaw;
	}
	
	public BlockPos getHomeBlockPos() {
		// TODO Auto-generated method stub
		return new BlockPos(x,y,z);
	}
	
	public static Island fromBytes(byte[] bytes)
	{
		return (Island)Utils.fromBytes(bytes);
	}

	public LocalDateTime getCreationDate() {
		return created;
	}
	
	public void completeChallenge(String challenge)
	{
		completedChallenges.add(challenge);
	}

	public boolean hasCompleted(String challenge) {
		return completedChallenges.contains(challenge);
	}
}
