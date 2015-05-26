package com.sgs.skyblocks;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

public class CleanRoomWorldType extends WorldType {
    public CleanRoomWorldType(String name) {
    	super(name);      
    }

    @Override
    public WorldChunkManager getChunkManager(World world) {
        // This is our ChunkManager class, it controls rain, temp, biomes, and spawn location
        return new CleanRoomChunkManager(world);
    }

    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
        // This is our ChunkProvider, this generates the world terrain.
        return new CleanRoomChunkProvider(world, world.getSeed(), true);
    }

    public boolean hasVoidParticles(boolean flag) {
        return flag; // Are their void particles?
    }

    public int getSeaLevel(World world) {
        // Sets the Average Ground Level, be careful with this one, it controls the Y value of your spawn point.
        return 64;
    }

    public double voidFadeMagnitude() {
        return 0.0D; // Sets the void fade, play with it to see which values work for you.
    }
}
