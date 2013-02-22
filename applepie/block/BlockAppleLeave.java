package applepie.block;

import java.util.Random;

import applepie.ApplePie;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAppleLeave extends BlockContainer{

	public BlockAppleLeave(int par1) 
	{
		super(par1, Material.leaves);
		this.blockIndexInTexture = 2;
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			boolean woodCheck = false;
			int target_x, target_y, target_z;

			sarch:{
				for(int h = -1; h < 2; h++)
				{
					for(int i = -4; i < 4; i++)
					{
						for(int j = -4; j < 4; j++)
						{
							if(par1World.getBlockId(par2 + i, par3 + h, par4 + j) == ApplePie.appleWood.blockID)
							{
								woodCheck = true;
								target_x = par2 + i;
								target_y = par3 + h;
								target_z = par4 + j;
								break sarch;
							}
						}
					}
				}
			}
			if(woodCheck)
			{
				if(par1World.rand.nextInt(100) + getTag(par1World, "speed", new int[]{par2, par3, par4}) > 95){
					if(par1World.getBlockId(par2, par3 - 1, par4) == 0)
					{
						par1World.setBlockAndMetadata(par2, par3 - 1, par4, ApplePie.appleBlock.blockID, 0);
						setTileEntity(par1World, new int[]{par2, par3, par4}, new int[]{par2, par3 - 1, par4});

					}
					else if(par1World.getBlockId(par2, par3 - 1, par4) == ApplePie.appleBlock.blockID)
					{
						if(par1World.getBlockMetadata(par2, par3 - 1, par4) == 0)
						{
							par1World.setBlockAndMetadataWithNotify(par2, par3 - 1, par4, ApplePie.appleBlock.blockID, 1);
						}
					}
				}
				return;
			}
			else
			{
				par1World.setBlockWithNotify(par2, par3, par4, 0);
			}
		}
	}
	

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}


	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}

	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityAppleWood();
	}

	private void setTileEntity(World par1World, int[] pos_a, int[] pos_b)
	{
		TileEntityAppleWood te_m = (TileEntityAppleWood)par1World.getBlockTileEntity(pos_a[0], pos_a[1], pos_a[2]);
		if(te_m != null) {
			TileEntityAppleWood te = (TileEntityAppleWood)par1World.getBlockTileEntity(pos_b[0], pos_b[1], pos_b[2]);
			if(te != null) {
				te.sweet = te_m.sweet;
				te.speed = te_m.speed;
				te.size = te_m.size;
				te.insect = te_m.insect;
			}
		}
	}

	private int getTag(World par1, String par2, int[] par3)
	{
		TileEntityAppleWood te = (TileEntityAppleWood)par1.getBlockTileEntity(par3[0], par3[1], par3[2]);
		if(te != null){
			if(par2 == "sweet")
				return te.sweet;
			if(par2 ==  "speed")
				return te.speed;
			if(par2 == "size")
				return te.size;
			if(par2 == "insect")
				return te.insect;
		}
		return 0;
	}
}
