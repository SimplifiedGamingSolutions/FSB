package com.sgs.skyblocks.player;


import scala.actors.threadpool.ExecutionException;
import scala.actors.threadpool.RunnableFuture;
import scala.actors.threadpool.TimeUnit;
import scala.actors.threadpool.TimeoutException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.sgs.skyblocks.island.Island;

public class PlayerRespawnHandler
{	
	public PlayerRespawnHandler()
	{
		{
	        MinecraftForge.EVENT_BUS.register(this);
	        FMLCommonHandler.instance().bus().register(this);
	    }
	}
	
	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event)
	{
		if (event.player.worldObj.isRemote)
			return;
		if(event.player instanceof EntityPlayerMP)
		{
			final EntityPlayerMP player = (EntityPlayerMP)event.player;
			PlayerInfo playerInfo = PlayerInfo.getPlayerInfo(player);
			Island island = playerInfo.getIsland();
			Vec3 pos = island.getHomeVector();
			player.setLocationAndAngles(pos.xCoord, pos.yCoord, pos.zCoord, island.getYaw(), island.getPitch());
			player.playerNetServerHandler.setPlayerLocation(pos.xCoord, pos.yCoord, pos.zCoord, island.getYaw(), island.getPitch());
		}
	}
}
