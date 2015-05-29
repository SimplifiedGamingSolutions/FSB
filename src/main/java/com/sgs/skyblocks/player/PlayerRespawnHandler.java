package com.sgs.skyblocks.player;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.sgs.skyblocks.island.Island;

public class PlayerRespawnHandler
{	
	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event)
	{
		if(event.player instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)event.player;
			PlayerInfo playerInfo = PlayerInfo.getPlayerInfo(player);
			Island island = playerInfo.getIsland();
			Vec3 pos = island.getHomeVector();
			player.playerNetServerHandler.setPlayerLocation(pos.xCoord, pos.yCoord, pos.zCoord, island.getYaw(), island.getPitch());
		}
	}
}
