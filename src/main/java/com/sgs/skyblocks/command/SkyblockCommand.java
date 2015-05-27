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
import com.sgs.skyblocks.island.IslandGenerator;

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
		if(args.length > 0)
		{
			if(args[0].equalsIgnoreCase("join"))
			{
				EntityPlayer player = (EntityPlayer)sender.getCommandSenderEntity();
				BlockPos pos = IslandGenerator.createIsland(player);
				sender.addChatMessage(new ChatComponentText("Island Created"));
				player.setPositionAndUpdate(pos.getX(), pos.getY()+1, pos.getZ());
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
