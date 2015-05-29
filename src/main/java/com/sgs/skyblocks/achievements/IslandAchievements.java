package com.sgs.skyblocks.achievements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import com.sgs.skyblocks.SkyBlocks;

public class IslandAchievements
{
	private Configuration config;
	private HashMap<String, IslandAchievement> Achievements;
	
	public IslandAchievements() {
		config = SkyBlocks.islandConfig;
		processAchievement();
	}

	private void processAchievement()
	{
		for(String achievement : config.getCategoryNames())
		{
			String name = achievement;
			
		}
	}
}
