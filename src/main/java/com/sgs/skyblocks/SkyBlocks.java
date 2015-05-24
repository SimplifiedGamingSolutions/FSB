package com.sgs.skyblocks;

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

@Mod(modid = SkyBlocks.MODID, version = SkyBlocks.VERSION)
public class SkyBlocks
{
    public static final String MODID = "SkyBlocks";
    public static final String VERSION = "1.0";
    public static WorldType cleanRoom = new CleanRoomWorldType("void");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void Load(FMLInitializationEvent event){
    	LanguageRegistry.instance().addStringLocalization("generator.void", "void");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        
    }
    
}
