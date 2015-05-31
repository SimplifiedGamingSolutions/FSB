package com.sgs.skyblocks.utils;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class InventoryParser {
	
	public EntityPlayerMP player;
	private InventoryPlayer inventory;
	
	public InventoryParser(EntityPlayerMP player){
		this.inventory = player.inventory;
		this.player = player;
	}
	
	public boolean hasItems(ItemStack item){
		if(inventory.hasItem(item.getItem()))
		{
			int i = 0;
			int count = item.stackSize;
	        while( i < inventory.mainInventory.length && count > 0)
	        {
	            if (inventory.mainInventory[i] != null && inventory.mainInventory[i].getItem().equals(item.getItem()))
	            {
	            	count -= inventory.mainInventory[i].stackSize;
	            }
	            i++;
	        }
	        if(count <= 0)
	        	return true;
		}
		return false;
	}
	public boolean hasItems(ItemStack[] items, boolean message){
		boolean hasItems = true;
		for(ItemStack item : items){
			if(!hasItems(item)){
				if(message)
					player.addChatMessage(new ChatComponentText("You do not have "+item.stackSize+" "+item.getDisplayName()));
				hasItems = false;
			}
		}
		return hasItems;
	}
	
	public boolean removeItemStack(ItemStack item){
		int left = item.stackSize;
		int i = 0;
		while(left > 0 && i < inventory.mainInventory.length)
        {
            if (inventory.mainInventory[i] != null && inventory.mainInventory[i].getItem().equals(item.getItem()))
            {
            	if(inventory.mainInventory[i].stackSize <= left)
            	{
            		left -= inventory.mainInventory[i].stackSize;
            		inventory.mainInventory[i] = null;
            	}
            	else
            	{
            		inventory.mainInventory[i].stackSize -= left;
            		left = 0;
            	}
            }
            i++;
        }
		if(left == 0)
		{
			inventory.markDirty();
			return true;
		}
		else
			return false;
	}
	
	public void addItemStack(ItemStack item)
	{
		inventory.addItemStackToInventory(item);
		inventory.markDirty();
	}
	
	public boolean removeItems(ItemStack[] items){
		boolean removedAll = true;
		for(ItemStack item : items){
			if(!removeItemStack(item)){
				removedAll = false;
			}
		}
		return removedAll;
	}
}