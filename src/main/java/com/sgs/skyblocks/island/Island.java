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

import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

public class Island implements Serializable{
	private static final long serialVersionUID = -2764714174014196528L;
	
	private String player;
	private int x;
	private int y;
	private int z;
	private LocalDateTime created;
	
	public Island(EntityPlayer player) {
		this.player = player.getName();
		this.created = LocalDateTime.now();
		SkyBlocksWorldData data = SkyBlocksWorldData.forWorld(player.getEntityWorld());
		data.getData().setLong("location", player.getPosition().toLong());
		data.markDirty();
		setLocation(IslandGenerator.createIsland(player));
		player.addChatMessage(new ChatComponentText("Island created!"));
	}
	
	public void setLocation(BlockPos pos)
	{
		this.x=pos.getX();
		this.y=pos.getY();
		this.z=pos.getZ();
	}

	public BlockPos getLocation() {
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
