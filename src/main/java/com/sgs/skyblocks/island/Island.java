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

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;

import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

public class Island implements Serializable{
	private static final long serialVersionUID = -2764714174014196528L;
	
	private double x;
	private double y;
	private double z;
	private float yaw;
	private float pitch;
	private LocalDateTime created;
	
	public Island(EntityPlayer player) {
		this.created = LocalDateTime.now();
		SkyBlocksWorldData data = SkyBlocksWorldData.forWorld(player.getEntityWorld());
		data.getData().setLong("location", player.getPosition().toLong());
		data.markDirty();
		setHome(IslandGenerator.createIsland(player), -180F, 50F);
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
	
	public byte[] toBytes(){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
		  out = new ObjectOutputStream(bos);   
		  out.writeObject(this);
		  return bos.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		  try {
		    if (out != null) {
		      out.close();
		    }
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		  try {
		    bos.close();
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		}
		return null;
	}
	
	public static Island fromBytes(byte[] bytes)
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInput in = null;
		try {
		  in = new ObjectInputStream(bis);
		  return (Island)in.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		  try {
		    bis.close();
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		  try {
		    if (in != null) {
		      in.close();
		    }
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		}
		return null;
	}

	public LocalDateTime getCreationDate() {
		return created;
	}
}
