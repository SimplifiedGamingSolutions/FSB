package com.sgs.skyblocks;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.sgs.skyblocks.utils.SkyBlocksLogger;
import com.sgs.skyblocks.worldtype.CleanRoomWorldType;

import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="SkyBlocks", name="SkyBlocks", version="1.0"/*, dependencies = "required-after:worldedit"*/)
public class SkyBlocks
{
    public static WorldType CleanRoom = new CleanRoomWorldType("CleanRoom");
    public static Configuration configs;
    public static SkyBlocks instance;
    private SkyBlocksLogger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	instance = this;
        logger = new SkyBlocksLogger(event.getModLog());
        configs = new Configuration(event.getSuggestedConfigurationFile());
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
      event.registerServerCommand(new SkyblockCommand());
    }
    
    @EventHandler
    public void Load(FMLInitializationEvent event){
        configs.load();
    	logger.logInfo("loaded");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        
    }
    
    public static SkyBlocksLogger getLogger(){
    	return SkyBlocksLogger.getLogger();
    }
    
}
