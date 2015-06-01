package com.sgs.skyblocks.command;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;

import com.sgs.skyblocks.achievements.IslandAchievement;
import com.sgs.skyblocks.achievements.IslandAchievements;
import com.sgs.skyblocks.island.Island;
import com.sgs.skyblocks.player.PlayerInfo;

public class SkyblockCommand implements ICommand{

    private final List<String> aliases;
    
    public SkyblockCommand() {
		aliases = new ArrayList<String>();
		aliases.add("SkyBlock");
		aliases.add("skyblock");
		aliases.add("sb");
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SB";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "SB <command>";
	}

	@Override
	public List<String> getAliases() {
		return this.aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerMP player = (EntityPlayerMP)sender.getCommandSenderEntity();
		PlayerInfo info;
		switch(args.length)
		{
			case 0:
				info = PlayerInfo.getPlayerInfo(player);
				Island island = info.getIsland();
				Vec3 pos = island.getHomeVector();
				player.playerNetServerHandler.setPlayerLocation(pos.xCoord, pos.yCoord, pos.zCoord, island.getYaw(), island.getPitch());
				sender.addChatMessage(new ChatComponentText("Welcome home"));
				break;
			case 1:
				if(args[0].equalsIgnoreCase("pos"))
				{
					sender.addChatMessage(new ChatComponentText("x:"+sender.getPositionVector().xCoord+" y:"+sender.getPositionVector().yCoord+" z:"+sender.getPositionVector().zCoord + " pitch:"+player.rotationPitch+" yaw:"+player.rotationYaw));
				}
				else if(args[0].equalsIgnoreCase("sethome"))
				{
					info = PlayerInfo.getPlayerInfo(player);
					info.getIsland().setHome(player.getPositionVector(), player.rotationYaw, player.rotationPitch);
					info.savePlayerInfo(player);
				}
				else if(args[0].equalsIgnoreCase("challenges"))
				{	
					sender.addChatMessage(new ChatComponentText(""));
					sender.addChatMessage(new ChatComponentText(String.format("%1$-22s %2$-15s %3$-10s\n", "Challenge Name", "Difficulty", "Type")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN).setBold(true)));
					for(IslandAchievement achievement : IslandAchievements.achievements.values())
					{
						ChatComponentText message = new ChatComponentText(String.format("%1$-30s %2$-13s %3$-10s", achievement.getName(), achievement.getRankLevel(), achievement.getType()));
						if(!achievement.hasCompleted(player))
							sender.addChatMessage(message.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
						else if(achievement.hasCompleted(player) && achievement.isRepeatable())
							sender.addChatMessage(message.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.YELLOW)));
						else if(achievement.hasCompleted(player) && !achievement.isRepeatable())
							sender.addChatMessage(message.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
					}
				}
				break;
			case 2:
				if(args[0].equalsIgnoreCase("complete"))
				{
					IslandAchievements.achievements.get(args[1].toLowerCase()).Complete(player);
				}
				break;
		}
				
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<?> addTabCompletionOptions(ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
