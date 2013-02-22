package applepie;

import java.util.Random;

import applepie.block.TileEntityAppleWood;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenAppleTree extends WorldGenerator
{
	/** The minimum height of a generated tree. */
	private final int minTreeHeight;

	/** True if this tree should grow Vines. */
	private final boolean vinesGrow;

	/** The metadata value of the wood to use in tree generation. */
	private final int metaWood;

	/** The metadata value of the leaves to use in tree generation. */
	private final int metaLeaves;

	private final int[] tileTag;

	public WorldGenAppleTree(boolean par1)
	{
		this(par1, 5, 0, 0, false, null);
	}

	public WorldGenAppleTree(boolean par1, int[] par2)
	{
		this(par1, 5, 0, 0, false, par2);
	}

	public WorldGenAppleTree(boolean par1, int par2, int par3, int par4, boolean par5, int[] par6)
	{
		super(par1);
		this.minTreeHeight = par2;
		this.metaWood = par3;
		this.metaLeaves = par4;
		this.vinesGrow = par5;
		this.tileTag = par6;
	}

	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		int var6 = par2Random.nextInt(3) + this.minTreeHeight;
		boolean var7 = true;

		if (par4 >= 1 && par4 + var6 + 1 <= 256)
		{
			int var8;
			byte var9;
			int var11;
			int var12;

			for (var8 = par4; var8 <= par4 + 1 + var6; ++var8)
			{
				var9 = 1;

				if (var8 == par4)
				{
					var9 = 0;
				}

				if (var8 >= par4 + 1 + var6 - 2)
				{
					var9 = 2;
				}

				for (int var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10)
				{
					for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11)
					{
						if (var8 >= 0 && var8 < 256)
						{
							var12 = par1World.getBlockId(var10, var8, var11);

							Block block = Block.blocksList[var12];

							if (var12 != 0 &&
									!block.isLeaves(par1World, var10, var8, var11) &&
									var12 != Block.grass.blockID &&
									var12 != Block.dirt.blockID &&
									var12 != Block.sand.blockID &&
									var12 != Block.snow.blockID &&
									!block.isWood(par1World, var10, var8, var11))
							{
								var7 = false;
							}
						}
						else
						{
							var7 = false;
						}
					}
				}
			}

			if (!var7)
			{
				return false;
			}
			else
			{
				var8 = par1World.getBlockId(par3, par4 - 1, par5);
				//System.out.println("var8:" + var8);
				if ((var8 == Block.grass.blockID || var8 == Block.dirt.blockID || var8 == Block.sand.blockID) && par4 < 256 - var6 - 1)
				{
					if(var8 == Block.snow.blockID)
					{
						//System.out.println("SYSTEM:SNOWPOINT:" + par3 + ", " + par4 +  ", " + par5);
						par1World.setBlockWithNotify(par3, par4, par5, ApplePie.appleWood.blockID);
						par1World.setBlockWithNotify(par3, par4 - 1, par5, 0);
						par1World.setBlockWithNotify(par3, par4 - 1, par5, ApplePie.appleWood.blockID);
					}
					//System.out.println("SYSTEM:SNOWPOINT:" + par3 + ", " + par4 +  ", " + par5);
					par1World.setBlockWithNotify(par3, par4, par5, ApplePie.appleWood.blockID);
					this.setBlock(par1World, par3, par4 - 1, par5, Block.dirt.blockID);
					var9 = 3;
					byte var18 = 0;
					int var13;
					int var14;
					int var15;

					for (var11 = par4 - var9 + var6; var11 <= par4 + var6; ++var11)
					{
						var12 = var11 - (par4 + var6);
						var13 = var18 + 1 - var12 / 2;

						for (var14 = par3 - var13; var14 <= par3 + var13; ++var14)
						{
							var15 = var14 - par3;

							for (int var16 = par5 - var13; var16 <= par5 + var13; ++var16)
							{
								int var17 = var16 - par5;

								Block block = Block.blocksList[par1World.getBlockId(var14, var11, var16)];

								if ((Math.abs(var15) != var13 || Math.abs(var17) != var13 || par2Random.nextInt(2) != 0 && var12 != 0) &&
										(block == null || block.canBeReplacedByLeaves(par1World, var14, var11, var16)))
								{
									this.setBlockAndMetadata(par1World, var14, var11, var16, ApplePie.appleLeave.blockID, this.metaLeaves);
									this.setTag(par1World, var14, var11, var16, tileTag);
								}
							}
						}
					}

					for (var11 = 0; var11 < var6; ++var11)
					{
						var12 = par1World.getBlockId(par3, par4 + var11, par5);

						Block block = Block.blocksList[var12];

						if (var12 == 0 || block == null || block.isLeaves(par1World, par3, par4 + var11, par5))
						{
							this.setBlockAndMetadata(par1World, par3, par4 + var11, par5, ApplePie.appleWood.blockID, this.metaWood);
							this.setTag(par1World, par3, par4 + var11, par5, tileTag);
						}
					}
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * Grows vines downward from the given block for a given length. Args: World, x, starty, z, vine-length
	 */
	private void growVines(World par1World, int par2, int par3, int par4, int par5)
	{
		this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
		int var6 = 4;

		while (true)
		{
			--par3;

			if (par1World.getBlockId(par2, par3, par4) != 0 || var6 <= 0)
			{
				return;
			}

			this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
			--var6;
		}
	}


	private void setTag(World par1, int x, int y, int z, int[] par2)
	{
		if(par2 != null){
			TileEntityAppleWood t = (TileEntityAppleWood)par1.getBlockTileEntity(x, y, z);
			if(t != null)
			{
				if(par2[0] == 5)
					par2[0] += par1.rand.nextInt(3) - 1;
				if(par2[1] == 5)
					par2[1] += par1.rand.nextInt(3) - 1;
				if(par2[2] == 5)
					par2[2] += par1.rand.nextInt(3) - 1;
				if(par2[3] == 5)
					par2[3] += par1.rand.nextInt(3) - 1;

				t.sweet = par2[0];
				t.speed = par2[1];
				t.size    = par2[2];
				t.insect = par2[3];
			}
		}
	}
}
