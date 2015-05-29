package com.sgs.skyblocks.achievements;

public enum AchievementType
{
	Obtain,
	Break,
	Kill;
	public static AchievementType parse(String value)
	{
		if(value.equalsIgnoreCase("obtain"))
		{
			return Obtain;
		}
		else if(value.equalsIgnoreCase("break"))
		{
			return Break;
		}
		else if(value.equalsIgnoreCase("kill"))
		{
			return Kill;
		}
		else
		{
			return Obtain;
		}
	}
}

