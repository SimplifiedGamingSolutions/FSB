package com.sgs.skyblocks.achievements;

import java.util.ArrayList;

import com.sgs.skyblocks.SkyBlocks;

public class IslandAchievements
{
	private int count;
	private ArrayList<IslandAchievement> achievements;
	
	public IslandAchievements()
	{
		count = SkyBlocks.configs.getInt("Number of Achievements", "Island_Achievements", 5, 0, 255, "The number of achievements to be processed from config file");
		processAchievement(SkyBlocks.configs.get("Island_Achievements", "Example", new String[]{"Apple Harvester", String.valueOf(AchievementType.Obtain),"1"}, "Trim the tree and hope for an apple!").getStringList());
		for(int i=0; i<count; i++)
		{
			SkyBlocks.configs.get("Island_Achievements", String.valueOf(i), "");
		}
	}
	
	private void processAchievement(String[] ach)
	{
		switch(AchievementType.parse(ach[1]))
		{
			case Obtain:
                System.out.println("Mondays are bad.");
                break;
			case Break:
                System.out.println("Mondays are bad.");
                break;
			case Kill:
                System.out.println("Mondays are bad.");
                break;
                
			default:
				break;
		}
	}
}
