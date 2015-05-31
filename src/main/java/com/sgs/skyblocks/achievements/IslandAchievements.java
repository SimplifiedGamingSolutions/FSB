package com.sgs.skyblocks.achievements;

import java.util.HashMap;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

import com.sgs.skyblocks.SkyBlocks;

public class IslandAchievements
{
	private Configuration config;
	public static HashMap<String, IslandAchievement> achievements;
	
	public IslandAchievements() {
		achievements = new HashMap<String, IslandAchievement>();
		config = SkyBlocks.islandConfig;
		processAchievement();
	}

	private void processAchievement()
	{
		Set<String> achievementList = config.getCategoryNames();
		if(achievementList.isEmpty())
		{
			addDefaultAchievementWithComments("cobblestonegenerator", "Create a cobblestone generator and mine 64 cobblestone.", "Easy", "onPlayer", new String[]{"4:64"}, 1, false, new String[]{"334:3"}, new String[]{"none"}, "3 leather", 10, 30, true, new String[]{"334:1"}, "1 leather", 5, 10);
			addDefaultAchievement("applecollector", "Collect 2 apples from trees.", "Easy", "onPlayer", new String[]{"260:2"}, 1, false, new String[]{"6:0:2","6:1:2","6:2:2","6:3:2"}, new String[]{"none"}, "2 of each kind of sapling", 10, 30, true, new String[]{"6:0:1","6:1:1","6:2:1","6:3:1"}, "1 of each kind of sapling", 5, 10);
			addDefaultAchievement("wheatfarmer", "Create a wheat farm and harvest 64 units of wheat", "Easy", "onPlayer", new String[]{"296:64"}, 1, false, new String[]{"3:5"}, new String[]{"none"}, "5 dirt", 10, 30, true, new String[]{"3:1"}, "1 dirt", 5, 10);
			addDefaultAchievement("cactusfarmer", "Create a cactus farm and harvest 64 cacti", "Easy", "onPlayer", new String[]{"81:64"}, 1, false, new String[]{"12:10"}, new String[]{"none"}, "10 sand", 15, 30, true, new String[]{"12:1"}, "1 sand", 1, 10);
			addDefaultAchievement("sugarfarmer", "Create a sugar cane farm and refine 64 units of sugar", "Easy", "onPlayer", new String[]{"353:64"}, 1, false, new String[]{"3:5","82:15"}, new String[]{"none"}, "5 dirt and 15 clay blocks", 15, 30, true, new String[]{"82:2"}, "2 clay blocks", 5, 10);
			addDefaultAchievement("melonfarmer", "Create a melon farm and harvest 128 slices of melon", "Easy", "onPlayer", new String[]{"360:128"}, 1, false, new String[]{"3:5"}, new String[]{"none"}, "5 dirt", 15, 30, true, new String[]{"3:2"}, "2 dirt blocks", 5, 10);			
			addDefaultAchievement("pumpkinfarmer", "Create a pumpkin farm and harvest 64 pumpkins", "Easy", "onPlayer", new String[]{"86:64"}, 1, false, new String[]{"3:5"}, new String[]{"none"}, "5 dirt", 15, 30, true, new String[]{"3:2"}, "2 dirt blocks", 5, 10);
			addDefaultAchievement("shroompicker", "Create a mushroom farm and collect 64 red and 64 brown mushrooms", "Easy", "onPlayer", new String[]{"39:64","40:64"}, 1, false, new String[]{"110:1"}, new String[]{"none"}, "1 mycelium block", 15, 30, true, new String[]{"110:1"}, "1 mycelium block", 5, 10);			
			addDefaultAchievement("novicebuilder", "Reach island level 20 (/island level).", "Easy", "islandLevel", new String[]{"20:1"}, 1, false, new String[]{"257:1","3:5"}, new String[]{"none"}, "1 iron pickaxe and 5 dirt", 50, 50, false, new String[]{""}, "", 0, 0);	
			addDefaultAchievement("monsterslayer", "Kill monsters and collect 64 rotten flesh, 32 skeleton bones, 32 string, 32 arrows, 16 gunpowder, 5 spider eyes", "Medium", "onPlayer", new String[]{"367:64","287:32","289:16","262:32","352:32","375:5"}, 1, false, new String[]{"331:16","15:5","318:1"}, new String[]{"none"}, "16 redstone dust, 1 flint, and 5 iron(ore)", 75, 75, true, new String[]{"331:2","15:1","318:1"}, "2 redstone dust, 1 flint, and 1 iron(ore)", 15, 15);
			addDefaultAchievement("expertfarmer", "Harvest 64 units of the following: wheat, sugar, melon, carrots, potatoes, pumpkin", "Medium", "onPlayer", new String[]{"360:64","353:64","296:64","392:64","391:64","86:64"}, 1, false, new String[]{"331:16","351:3:1","383:90:1","383:92:1","383:93:1"}, new String[]{"none"}, "16 redstone dust, 1 cocoa bean, 1 spawn egg(chicken,cow,pig)", 75, 75, true, new String[]{"351:3:1","383:90:1","383:92:1","383:93:1"}, "1 cocoa bean, 1 spawn egg(chicken,cow,pig)", 20, 20);			
			addDefaultAchievement("fisherman", "Make a fishing pond, then catch and cook 10 fish", "Medium", "onPlayer", new String[]{"350:0:10"}, 1, false, new String[]{"331:16","15:5","351:5"}, new String[]{"none"}, "16 redstone dust, 5 inksac, 5 iron (ore)", 75, 75, true, new String[]{"331:2","15:1","351:1"}, "2 redstone dust, 1 inksac, 1 iron (ore)", 15, 15);
			addDefaultAchievement("lumberjack", "Create a tree farm and collect 16 oak, birch, jungle, and spruce logs", "Medium", "onPlayer", new String[]{"17:0:16","17:1:16","17:2:16","17:3:16"}, 1, false, new String[]{"331:16","15:5","383:98:1"}, new String[]{"none"}, "16 redstone dust, 5 iron (ore), 1 wolf spawn egg", 75, 75, true, new String[]{"331:2","15:1"}, "2 redstone dust, 1 iron (ore)", 15, 15);			
			addDefaultAchievement("cookielover", "Make 128 cookies and a bucket of milk", "Medium", "onPlayer", new String[]{"335:1","357:128"}, 1, false, new String[]{"331:16","15:5"}, new String[]{"none"}, "16 redstone dust, 5 iron (ore)", 75, 75, true, new String[]{"331:2","15:1"}, "2 redstone dust, 1 iron (ore)", 15, 15);
			addDefaultAchievement("adeptbuilder", "Reach island level 100 (/island level).", "Medium", "islandLevel", new String[]{"100:1"}, 1, false, new String[]{"49:10"}, new String[]{"none"}, "10 obsidian blocks", 50, 50, false, new String[]{""}, "", 0, 0);
			addDefaultAchievement("homeowner", "Build a house that contains at least 1 door, bed, bookshelf, crafting table, furnace, window, and torch.", "Medium", "onIsland", new String[]{"26:1","58:1","20:1","64:1","61:1","47:1","50:1"}, 1, true, new String[]{"84:1","267:1","22:10"}, new String[]{"none"}, "1 jukebox, 1 music disk, 10 lapis lazuli blocks", 100, 100, false, new String[]{""}, "", 0, 0);
			addDefaultAchievement("netherportal", "Build a nether portal on your island and activate it.", "Hard", "onIsland", new String[]{"49:10","90:1"}, 1, true, new String[]{"276:1"}, new String[]{"none"}, "1 diamond sword", 100, 100, false, new String[]{""}, "", 0, 0);
			
		}
		for(String achievement : achievementList)
		{
			try{
				ConfigCategory cat = config.getCategory(achievement);
				achievements.put(achievement.toLowerCase(), new IslandAchievement(
							achievement, 
							cat.get("description").getString(), 
							cat.get("rankLevel").getString(), 
							cat.get("type").getString(),
							cat.get("requiredItems").getStringList(), 
							cat.get("requiredLevel").getInt(), 
							cat.get("canKeepItems").getBoolean(), 
							cat.get("itemReward").getStringList(),
							cat.get("permissionReward").getStringList(), 
							cat.get("rewardText").getString(), 
							cat.get("currencyReward").getInt(), 
							cat.get("xpReward").getInt(),
							cat.get("isRepeatable").getBoolean(), 
							cat.get("repeatItemReward").getStringList(), 
							cat.get("repeatItemRewardText").getString(), 
							cat.get("repeatCurrencyReward").getInt(), 
							cat.get("repeatXpReward").getInt()
						)
				);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				SkyBlocks.getLogger().logSevere("IslandConfig syntax error, compare to default config or erase config file to create default.");
			}
			
		}
	}

	private void addDefaultAchievementWithComments(String name, String description, String rankLevel, String type, String[] requiredItems, int requiredLevel, boolean canKeepItems,
			String itemReward[], String permissionReward[], String rewardText, int currencyReward, int xpReward, boolean repeatable, String[] repeatItemReward, 
			String repeatItemRewardText, int repeatCurrencyReward, int repeatXpReward) {
		config.addCustomCategoryComment(name, "add your own custom achievements for players.");
		config.getString("description",name,  description, "Description shown to users.");
		config.getString("rankLevel",name,  rankLevel, "Level of difficulty.");
		config.getString("type", name, type, "The type of achivement: onPlayer, onIsland");
		config.getStringList("requiredItems", name, requiredItems, "List of items required on player. EX: 'blockid,amount'");
		config.getInt("requiredLevel", name, requiredLevel, 1, 20, "Island level required for achievement.");
		config.getBoolean("canKeepItems", name, canKeepItems, "Whether the player keeps the items required or gives them up on completion of achievement");
		config.getStringList("itemReward", name, itemReward, "List of items rewarded to player. EX: 'blockid,amount'");
		config.getStringList("permissionReward", name, permissionReward, "List of permissions rewarded to player.");
		config.getString("rewardText", name, rewardText, "Text displayed when user receives achievement.");
		config.getInt("currencyReward", name, currencyReward, 1, 100000, "The amount of currency the player is rewarded.");
		config.getInt("xpReward", name, xpReward, 1, 100000, "The amount of xp the player is rewarded.");
		config.getBoolean("isRepeatable", name, repeatable, "Whether or not the player can repeat the task to receive another reward");
		config.getStringList("repeatItemReward", name, repeatItemReward, "List of items rewarded to player. EX: 'blockid,amount'");
		config.getString("repeatItemRewardText", name, repeatItemRewardText, "Text displayed when user receives achievement.");
		config.getInt("repeatCurrencyReward", name, repeatCurrencyReward, 1, 100000, "The amount of currency the player is rewarded.");
		config.getInt("repeatXpReward", name, repeatXpReward, 1, 100000, "The amount of xp the player is rewarded.");
		config.save();
	}

	private void addDefaultAchievement(String name, String description, String rankLevel, String type, String[] requiredItems, int requiredLevel, boolean canKeepItems,
			String itemReward[], String permissionReward[], String rewardText, int currencyReward, int xpReward, boolean repeatable, String[] repeatItemReward, 
			String repeatItemRewardText, int repeatCurrencyReward, int repeatXpReward) {
		try{
			config.get(name,"description",  description, "Description shown to users.");
			config.get(name,"rankLevel",  rankLevel, "Level of difficulty.");
			config.get( name,"type", type, "The type of achivement: onPlayer, onIsland");
			config.get( name,"requiredItems", requiredItems);
			config.get(name,"requiredLevel",  requiredLevel);
			config.get(name,"canKeepItems",  canKeepItems);
			config.get(name,"itemReward",  itemReward);
			config.get(name,"permissionReward",  permissionReward);
			config.get( name,"rewardText", rewardText);
			config.get(name,"currencyReward",  currencyReward);
			config.get(name,"xpReward",  xpReward);
			config.get(name,"isRepeatable",  repeatable);
			config.get( name, "repeatItemReward",repeatItemReward);
			config.get(name,"repeatItemRewardText",  repeatItemRewardText);
			config.get(name,"repeatCurrencyReward",  repeatCurrencyReward);
			config.get( name,"repeatXpReward", repeatXpReward);
			config.save();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Achievement[] getAchievementsList() {
		Achievement[] list = new Achievement[achievements.size()];
		int i = 0;
		for(IslandAchievement achievement : achievements.values())
		{
			list[i] = achievement.setAchievement(new Achievement(achievement.getDescription(), achievement.getName(), 0, i, Blocks.grass, null));
			i++;
		}
		return list;
	}
}
