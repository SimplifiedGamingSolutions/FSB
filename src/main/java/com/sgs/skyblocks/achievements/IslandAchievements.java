package com.sgs.skyblocks.achievements;

import java.util.HashMap;
import java.util.Set;

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
			config.addCustomCategoryComment("cobblestonegenerator", "add your own custom achievements for players.");
			config.getString("description","cobblestonegenerator",  "Collect 2 Apples", "Description shown to users.");
			config.getString("rankLevel","cobblestonegenerator",  "Easy", "Level of difficulty.");
			config.getString("type", "cobblestonegenerator", "onPlayer", "The type of achivement: onPlayer, onIsland");
			config.getStringList("requiredItems", "cobblestonegenerator", new String[]{"4:64"}, "List of items required on player. EX: 'blockid,amount'");
			config.getInt("requiredLevel", "cobblestonegenerator", 1, 1, 20, "Island level required for achievement.");
			config.getBoolean("canKeepItems", "cobblestonegenerator", false, "Whether the player keeps the items required or gives them up on completion of achievement");
			config.getStringList("itemReward", "cobblestonegenerator", new String[]{"334:3"}, "List of items rewarded to player. EX: 'blockid,amount'");
			config.getStringList("permissionReward", "cobblestonegenerator", new String[]{"none"}, "List of permissions rewarded to player.");
			config.getString("rewardText", "cobblestonegenerator", "3 leather", "Text displayed when user receives achievement.");
			config.getInt("currencyReward", "cobblestonegenerator", 10, 1, 100000, "The amount of currency the player is rewarded.");
			config.getInt("xpReward", "cobblestonegenerator", 30, 1, 100000, "The amount of xp the player is rewarded.");
			config.getBoolean("isRepeatable", "cobblestonegenerator", true, "Whether or not the player can repeat the task to receive another reward");
			config.getStringList("repeatItemReward", "cobblestonegenerator", new String[]{"334:1"}, "List of items rewarded to player. EX: 'blockid,amount'");
			config.getString("repeatItemRewardText", "cobblestonegenerator", "1 leather", "Text displayed when user receives achievement.");
			config.getInt("repeatCurrencyReward", "cobblestonegenerator", 5, 1, 100000, "The amount of currency the player is rewarded.");
			config.getInt("repeatXpReward", "cobblestonegenerator", 10, 1, 100000, "The amount of xp the player is rewarded.");
			config.save();
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

	public Achievement[] getAchievementsList() {
		Achievement[] list = new Achievement[achievements.size()];
		int i = 0;
		for(IslandAchievement achievement : achievements.values())
		{
			list[i] = achievement.getAchievement();
			i++;
		}
		return list;
	}
}
