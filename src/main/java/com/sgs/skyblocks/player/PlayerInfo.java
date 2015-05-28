package com.sgs.skyblocks.player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.sgs.skyblocks.island.Island;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PlayerInfo implements Serializable{
	private static final long serialVersionUID = 920558059357137410L;
	
	private String name;
	private Island island;
	private LocalDateTime created;
	
	public PlayerInfo(EntityPlayer player, Island island) {
		this.name = player.getName();
		this.island = island;
		savePlayerInfo(player);
	}

	public static PlayerInfo getPlayerInfo(EntityPlayer player)
	{
		NBTTagCompound data = player.getEntityData();
		byte[] rawPlayerInfo = data.getByteArray("playerInfo");
		if(rawPlayerInfo.length != 0){
			return PlayerInfo.fromBytes(rawPlayerInfo);
		}
		else
		{
			return new PlayerInfo(player, new Island(player));
		}
	}
	
	public void savePlayerInfo(EntityPlayer player){
		NBTTagCompound data = player.getEntityData();
		data.setByteArray("playerInfo", this.toBytes());
	}
	
	public Island getIsland()
	{
		return island;
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
	
	public static PlayerInfo fromBytes(byte[] bytes)
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInput in = null;
		try {
		  in = new ObjectInputStream(bis);
		  return (PlayerInfo)in.readObject();
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
	
	@Override
	public String toString() {
		return name +"\n"+island.getLocation().getX()+" "+island.getLocation().getY()+" "+island.getLocation().getZ()+"\n"+island.getCreationDate();
	}
    
}
