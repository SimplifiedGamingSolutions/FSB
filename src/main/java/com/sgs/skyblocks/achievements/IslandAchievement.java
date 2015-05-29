package com.sgs.skyblocks.achievements;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;

public class IslandAchievement
{
	private String name;
	private AchievementType type;
	private int amount;
	private Block block;
	
	public IslandAchievement(String name, AchievementType type, int amount, int blockID)
	{
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.block = Block.getBlockById(blockID);
	}
}
