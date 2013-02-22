package applepie;

import java.util.Random;

import applepie.block.TileEntityAppleWood;

import net.minecraft.world.World;
import net.minecraft.world.biome.*;

public class AppleWorldGen {

	public void generateSurface(World par1World, Random par2Random, int par3, int par4)
	{
		if((par2Random.nextInt(30) % 20) != 0)
			return;

		BiomeGenBase bg = par1World.getWorldChunkManager().getBiomeGenAt(par3, par4);


		if(bg instanceof BiomeGenTaiga)
		{
			WorldGenAppleTree w = new WorldGenAppleTree(true, new int[]{8, 2, 5, 5});
			w.setScale(1.0D, 1.0D, 1.0D);
			int x = par3 + par2Random.nextInt(16) + 8;
			int z = par4 + par2Random.nextInt(16) + 8;
			int y = par1World.getHeightValue(x, z);
			w.generate(par1World, par2Random, x, y, z);
		}
		if(bg instanceof BiomeGenForest)
		{
			WorldGenAppleTree w = new WorldGenAppleTree(true, new int[]{5, 5, 7, 5});
			w.setScale(1.0D, 1.0D, 1.0D);
			int x = par3 + par2Random.nextInt(16) + 8;
			int z = par4 + par2Random.nextInt(16) + 8;
			int y = par1World.getHeightValue(x, z);
			w.generate(par1World, par2Random, x, y, z);
		}
		if(bg instanceof BiomeGenHills)
		{
			WorldGenAppleTree w = new WorldGenAppleTree(true, new int[]{5, 8, 2, 5});
			w.setScale(1.0D, 1.0D, 1.0D);
			int x = par3 + par2Random.nextInt(16) + 8;
			int z = par4 + par2Random.nextInt(16) + 8;
			int y = par1World.getHeightValue(x, z);
			w.generate(par1World, par2Random, x, y, z);
		}
		if(bg instanceof BiomeGenDesert)
		{
			WorldGenAppleTree w = new WorldGenAppleTree(true, new int[]{5, 5, 5, 9});
			w.setScale(1.0D, 1.0D, 1.0D);
			int x = par3 + par2Random.nextInt(16) + 8;
			int z = par4 + par2Random.nextInt(16) + 8;
			int y = par1World.getHeightValue(x, z);
			w.generate(par1World, par2Random, x, y, z);
		}
	}

}
