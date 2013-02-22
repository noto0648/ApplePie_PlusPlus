package applepie.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import applepie.ApplePie;

public class BlockApple extends BlockContainer{

	public BlockApple(int par1)
	{
		super(par1, Material.plants);
		this.blockIndexInTexture = 16;
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par2 == 1 ? 16 : 17;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 1;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}
	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

		ItemStack items = new ItemStack(ApplePie.nApple, 1, metadata);

		TileEntityAppleWood te = (TileEntityAppleWood)world.getBlockTileEntity(x, y + 1, z);

		if(te != null) {

			NBTTagCompound nbt = items.getTagCompound();
			if(nbt == null)
			{
				nbt = new NBTTagCompound();
				items.setTagCompound(nbt);
			}

			nbt.setInteger("sweet", te.sweet);
			nbt.setInteger("speed", te.speed);
			nbt.setInteger("size", te.size);
			nbt.setInteger("insect", te.insect);
			nbt.setShort("ripeness", (short) ((short)metadata + 1));

			ret.add(items);
		}
		return ret;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		if(!par1World.isRemote)
		{
			if(par1World.getBlockId(par2, par3 + 1, par4) != ApplePie.appleLeave.blockID)
			{
				ItemStack items = new ItemStack(ApplePie.nApple, 1);

				TileEntityAppleWood te = (TileEntityAppleWood)par1World.getBlockTileEntity(par2, par3, par4);

				if(te != null) {

					NBTTagCompound nbt = items.getTagCompound();
					if(nbt == null)
					{
						nbt = new NBTTagCompound();
						items.setTagCompound(nbt);
					}

					nbt.setInteger("sweet", te.sweet);
					nbt.setInteger("speed", te.speed);
					nbt.setInteger("size", te.size);
					nbt.setInteger("insect", te.insect);
					nbt.setShort("ripeness", (short) ((short)par1World.getBlockMetadata(par2, par3, par4) + 1));
					this.dropBlockAsItem_do(par1World, par2, par3, par4, items);
				}
				par1World.setBlockWithNotify(par2, par3, par4, 0);
			}
		}
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

}
