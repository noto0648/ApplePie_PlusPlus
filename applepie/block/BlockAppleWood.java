package applepie.block;

import applepie.ApplePie;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAppleWood extends Block{

	public BlockAppleWood(int par1)
	{
		super(par1, Material.wood);
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return (par1 == 0|| par1 == 1)? 1 : 0;
	}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		for(int i = 1;;i++){
			if(par1World.getBlockId(par3, par4 + i, par5) == this.blockID)
			{
				par1World.setBlockWithNotify(par3, par4 + i, par5, 0);
				this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(this));
			}else{
				break;
			}
		}
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}
}
