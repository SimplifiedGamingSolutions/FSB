package com.sgs.skyblocks.achievements;

import net.minecraft.item.ItemStack;

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
	private String permissionReward;
	private String rewardText;
	private int currencyReward;
	private int xpReward;
	private boolean repeatable;
	private ItemStack[] repeatItemReward;
	private String repeatItemRewardText;
	private int repeatCurrencyReward;
	private int repeatXpReward;
	
	public IslandAchievement(String name, String description, String rankLevel, String type, String requiredItems, int requiredLevel, boolean canKeepItems,
			String itemReward, String permissionReward, String rewardText, int currencyReward, int xpReward, boolean repeatable, String[] repeatItemReward, 
			String repeatItemRewardText, int repeatCurrencyReward, int repeatXpReward) {
		// TODO Auto-generated constructor stub
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

	public String getPermissionReward() {
		return permissionReward;
	}

	public void setPermissionReward(String permissionReward) {
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

	public void Complete(String owner_name) {		
	}
}
