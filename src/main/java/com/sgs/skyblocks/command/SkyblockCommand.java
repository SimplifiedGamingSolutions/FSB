package com.sgs.skyblocks.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import com.sgs.skyblocks.SkyBlocks;
import com.sgs.skyblocks.island.Island;
import com.sgs.skyblocks.island.IslandGenerator;
import com.sgs.skyblocks.player.PlayerInfo;
import com.sgs.skyblocks.worldtype.SkyBlocksWorldData;

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
		EntityPlayer player = (EntityPlayer)sender.getCommandSenderEntity();
		if(args.length == 0)
		{
			PlayerInfo playerInfo = PlayerInfo.getPlayerInfo(player);
			BlockPos pos = playerInfo.getIsland().getLocation();
			player.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			sender.addChatMessage(new ChatComponentText("Welcome home"));
			return;
		}
		if(args.length > 0)
		{
			if(args[0].equalsIgnoreCase("join"))
			{
				BlockPos pos = new Island(player).getLocation();
				sender.addChatMessage(new ChatComponentText("Island Created at: " + pos.getX()+" "+pos.getY()+" "+pos.getZ()));
				player.setPositionAndUpdate(pos.getX(), pos.getY()+1, pos.getZ());
			}
			else if(args[0].equalsIgnoreCase("load"))
			{
				SkyBlocksWorldData data = SkyBlocksWorldData.forWorld(player.getEntityWorld());
				BlockPos pos = BlockPos.fromLong(data.getData().getLong("location"));
				sender.addChatMessage(new ChatComponentText("Island at location: "+ pos.getX()+" "+pos.getY()+" "+pos.getZ()));
			}
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
