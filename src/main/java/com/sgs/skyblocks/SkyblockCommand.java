package com.sgs.skyblocks;

import java.util.ArrayList;
import java.util.List;

import com.sgs.skyblocks.island.IslandGenerator;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public class SkyblockCommand implements ICommand{

    private final List<String> aliases;
    
    public SkyblockCommand() {
		aliases = new ArrayList<String>();
		aliases.add("SkyBlock");
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
	public List getAliases() {
		return this.aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer)sender.getCommandSenderEntity();
		IslandGenerator.createIsland(player);
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args,
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
