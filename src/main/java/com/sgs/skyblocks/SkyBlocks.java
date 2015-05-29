package com.sgs.skyblocks;

import java.io.File;

import net.minecraft.world.WorldType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import com.sgs.skyblocks.command.SkyblockCommand;
import com.sgs.skyblocks.player.PlayerRespawnHandler;
import com.sgs.skyblocks.utils.SkyBlocksLogger;
import com.sgs.skyblocks.worldtype.CleanRoomWorldType;

@Mod(modid="SkyBlocks", name="SkyBlocks", version="1.0"/*, dependencies = "required-after:worldedit"*/)
public class SkyBlocks
{
    public static WorldType CleanRoom = new CleanRoomWorldType("CleanRoom");
    public static Configuration config;
    public static Configuration islandConfig;
    public static SkyBlocks instance;
    private SkyBlocksLogger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	instance = this;
        logger = new SkyBlocksLogger(event.getModLog());
        config = new Configuration(event.getSuggestedConfigurationFile());
        islandConfig = new Configuration(new File(event.getModConfigurationDirectory(),"IslandConfig.cfg"));
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
      event.registerServerCommand(new SkyblockCommand());
    }
    
    @EventHandler
    public void Load(FMLInitializationEvent event){
        config.load();
    	logger.logInfo("loaded");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	initializeConfig();
		FMLCommonHandler.instance().bus().register(new PlayerRespawnHandler());
    }
    
    private void initializeConfig()
	{
        SkyBlocks.config.addCustomCategoryComment("island_chest_config", "Example add five cobblestone to chest 'I:4=5'");
        SkyBlocks.config.addCustomCategoryComment("island_location_config", "Basic Configurations for islands");
        SkyBlocks.config.addCustomCategoryComment("island_achievements_config", "Add or remove custom achievements with the categories: obtain, break, kill");
        SkyBlocks.config.getInt("island_height", "island_location_config", 58, 0, 250, "The height of the base of the island. The island is conscructed from bottom to top.");
        SkyBlocks.config.getInt("island_distance", "island_location_config", 150, 20, 255, "The distance between islands.");
		SkyBlocks.config.save();
	}

	public static SkyBlocksLogger getLogger(){
    	return SkyBlocksLogger.getLogger();
    }
    
}
