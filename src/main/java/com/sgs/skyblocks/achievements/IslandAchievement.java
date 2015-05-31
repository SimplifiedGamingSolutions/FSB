package com.sgs.skyblocks.achievements;

import java.util.ArrayList;
import java.util.List;

import com.sgs.skyblocks.SkyBlocks;

import scala.actors.threadpool.Arrays;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class IslandAchievement
{
	private String name;
	private String description;
	private String rankLevel;
	private String type;
	private ItemStack[] requiredItems;
	private int requiredLevel;
	private boolean canKeepItems;
	private ItemStack[] itemReward;
	private String[] permissionReward;
	private String rewardText;
	private int currencyReward;
	private int xpReward;
	private boolean repeatable;
	private ItemStack[] repeatItemReward;
	private String repeatItemRewardText;
	private int repeatCurrencyReward;
	private int repeatXpReward;
	private Achievement achievement;
	
	public IslandAchievement(String name, String description, String rankLevel, String type, String[] requiredItems, int requiredLevel, boolean canKeepItems,
			String itemReward[], String permissionReward[], String rewardText, int currencyReward, int xpReward, boolean repeatable, String[] repeatItemReward, 
			String repeatItemRewardText, int repeatCurrencyReward, int repeatXpReward) {
		this.name = name;
		this.description = description;
		this.rankLevel = rankLevel;
		this.type = type;
		this.requiredItems = new ItemStack[requiredItems.length];
		for(int i = 0; i < requiredItems.length; i++)
		{
			String[] item = requiredItems[i].split(":");
			this.requiredItems[i] = new ItemStack(Item.getByNameOrId(item[0]), Integer.parseInt(item[1]));
		}
		this.requiredLevel = requiredLevel;
		this.canKeepItems = canKeepItems;
		this.itemReward = new ItemStack[itemReward.length];
		for(int i = 0; i < itemReward.length; i++)
		{
			String[] item = itemReward[i].split(":");
			this.itemReward[i] = new ItemStack(Item.getByNameOrId(item[0]), Integer.parseInt(item[1]));
		}
		this.permissionReward = permissionReward;
		this.rewardText = rewardText;
		this.currencyReward = currencyReward;
		this.xpReward = xpReward;
		this.repeatable = repeatable;

		this.repeatItemReward = new ItemStack[repeatItemReward.length];
		for(int i = 0; i < repeatItemReward.length; i++)
		{
			String[] item = repeatItemReward[i].split(":");
			this.repeatItemReward[i] = new ItemStack(Item.getByNameOrId(item[0]), Integer.parseInt(item[1]));
		}
		this.repeatItemRewardText = repeatItemRewardText;
		this.repeatCurrencyReward = repeatCurrencyReward;
		this.repeatXpReward = repeatXpReward;
        LanguageRegistry.instance().addStringLocalization("achievement."+name, name);
        LanguageRegistry.instance().addStringLocalization("achievement."+name+".desc", "en_US", description);
		this.achievement = new Achievement(description, name, 0, 0, Blocks.grass, null);
		
	}

	public Achievement getAchievement()
	{
		return achievement;
	}
	
	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRankLevel() {
		return rankLevel;
	}

	public void setRankLevel(String rankLevel) {
		this.rankLevel = rankLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ItemStack[] getRequiredItems() {
		return requiredItems;
	}

	public void setRequiredItems(ItemStack[] requiredItems) {
		this.requiredItems = requiredItems;
	}
	
	public boolean canKeepItems() {
		return canKeepItems;
	}

	public void setKeepItems(boolean canKeepItems) {
		this.canKeepItems = canKeepItems;
	}

	public ItemStack[] getItemReward() {
		return itemReward;
	}

	public void setItemReward(ItemStack[] itemReward) {
		this.itemReward = itemReward;
	}

	public String[] getPermissionReward() {
		return permissionReward;
	}

	public void setPermissionReward(String[] permissionReward) {
		this.permissionReward = permissionReward;
	}

	public String getRewardText() {
		return rewardText;
	}

	public void setRewardText(String rewardText) {
		this.rewardText = rewardText;
	}

	public int getCurrencyReward() {
		return currencyReward;
	}

	public void setCurrencyReward(int currencyReward) {
		this.currencyReward = currencyReward;
	}

	public int getXpReward() {
		return xpReward;
	}

	public void setXpReward(int xpReward) {
		this.xpReward = xpReward;
	}

	public boolean isRepeatable() {
		return repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}

	public ItemStack[] getRepeatItemReward() {
		return repeatItemReward;
	}

	public void setRepeatItemReward(ItemStack[] repeatItemReward) {
		this.repeatItemReward = repeatItemReward;
	}

	public String getRepeatItemRewardText() {
		return repeatItemRewardText;
	}

	public void setRepeatItemRewardText(String repeatItemRewardText) {
		this.repeatItemRewardText = repeatItemRewardText;
	}

	public int getRepeatCurrencyReward() {
		return repeatCurrencyReward;
	}

	public void setRepeatCurrencyReward(int repeatCurrencyReward) {
		this.repeatCurrencyReward = repeatCurrencyReward;
	}

	public int getRepeatXpReward() {
		return repeatXpReward;
	}

	public void setRepeatXpReward(int repeatXpReward) {
		this.repeatXpReward = repeatXpReward;
	}


	public boolean hasCompleted(String owner_name) {
		return false;
	}

	public void Complete(EntityPlayerMP player) {
		if(type.equalsIgnoreCase("onPlayer"))
		{
			if(!hasCompleted(player.getName()))
			{
				if(checkInventory(player))
				{
					player.addChatComponentMessage(new ChatComponentText(rewardText));
					player.addStat(achievement, 1);
				}
			}
			else if(isRepeatable())
			{
				if(checkInventory(player))
				{
					player.addChatComponentMessage(new ChatComponentText(rewardText));
				}
			}
			else
			{
				player.addChatComponentMessage(new ChatComponentText("Achievement not repeatable."));
			}
		}
	}

	private boolean checkInventory(EntityPlayerMP player) {
		List<ItemStack> inventory = Arrays.asList(player.inventory.mainInventory);
		int i = 0;
		boolean passing = true;
		while(passing && i < requiredItems.length)
		{
			if(player.inventory.hasItem(requiredItems[i].getItem()))
			{
				int amount = 0;
				for(ItemStack item : inventory)
				{
					if(item != null && item.getItem().equals(requiredItems[i].getItem()))
					{
						amount += item.stackSize;
					}
				}
				if(amount >= requiredItems[i].stackSize)
				{
					passing = true;
					i++;
				}
				else{
					passing = false;
				}
				
			}
			else
			{
				passing = false;
			}
		}
		if(!passing)
		{
			player.addChatComponentMessage(new ChatComponentText("Sorry, you don't have enough '"+Item.itemRegistry.getNameForObject(requiredItems[i].getItem()).toString().substring(10)+"' You need '"+requiredItems[i].stackSize+"'"));
		}
		return passing;
	}
}
