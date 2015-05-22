package com.sgs.skyblocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SkyBlocks.MODID, version = SkyBlocks.VERSION)
public class SkyBlocks
{
    public static final String MODID = "SkyBlocks";
    public static final String VERSION = "1.0";
    
    SkyWorldGenerator worldGen = new SkyWorldGenerator();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }
    
    @EventHandler
    public void Load(FMLInitializationEvent event){

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(worldGen, 0);
    }
    
}
