package com.sgs.skyblocks.utils;

import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import com.sgs.skyblocks.SkyBlocks;
import com.sgs.skyblocks.island.Island;
import com.sgs.skyblocks.player.PlayerInfo;

public class IslandParser {

	public HashMap<Integer,Integer> blocks = new HashMap<Integer,Integer>();
	public Island island;
	public EntityPlayerMP player;
	public int range;
	
	public IslandParser(EntityPlayerMP player){
		this.island = PlayerInfo.getPlayerInfo(player).getIsland();
		this.player = player;
		this.range = SkyBlocks.config.getInt("range", "island_location_config", 25, 1, 100, "range to search for onIsland challenges, can be slow over 100.");
		if(SkyBlocks.config.hasChanged())
			SkyBlocks.config.save();
		parseIsland();
	}

	private void parseIsland() {
		BlockPos pos = island.getHomeBlockPos();
		int posx = (int) Math.round(pos.getX());
		int posy = (int) Math.round(pos.getY());
		int posz = (int) Math.round(pos.getZ());
		int blockid = 0;
		for (int x = -range; x <= range; x++) {
			for (int y = -range; y <= range; y++) {
				for (int z = -range; z <= range; z++) {
					final Block b = player.getEntityWorld().getBlockState(new BlockPos(posx+x,posy+y,posz+z)).getBlock();
					try{
						blockid = Block.getIdFromBlock(b);
						int count = blocks.get(blockid);
						blocks.put(blockid, ++count);
					}
					catch(Exception e){
						blocks.put(blockid, 1);
					}
				}
			}
		}
		/*for(Entry<Integer, Integer> block : blocks.entrySet()){
			player.addChatComponentMessage(new ChatComponentText(block.getKey()+":"+block.getValue()));
		}*/
	}
	
	public boolean hasBlock(ItemStack block){
		try{
			int blockCount = blocks.get(Item.getIdFromItem(block.getItem()));
			if(blockCount >= block.stackSize){
				return true;
			}
		}
		catch(Exception e){
			
		}
		return false;
	}
	public boolean hasBlocks(ItemStack[] blocks, boolean message){
		boolean hasBlocks = true;
		for(ItemStack block : blocks){
			if(!hasBlock(block)){
				if(message)
					player.addChatComponentMessage(new ChatComponentText("You do not have "+block.stackSize+" "+block.getDisplayName()));
				hasBlocks = false;
			}
		}
		return hasBlocks;
	}
	
	
}
