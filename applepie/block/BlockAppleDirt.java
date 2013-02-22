package applepie.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAppleDirt extends BlockContainer{

	public BlockAppleDirt(int par1)
	{
		super(par1, Material.clay);
		this.setTickRandomly(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		this.blockIndexInTexture = 2;
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		TileEntityAppleWood te = (TileEntityAppleWood)par1World.getBlockTileEntity(par2, par3, par4);
		if(te != null)
		{
			if(par1World.rand.nextInt(100) + te.speed > 90)
			{
				if(par1World.getBlockId(par2, par3, par4) == 0)
				{
					
				}
			}
		}
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

}
