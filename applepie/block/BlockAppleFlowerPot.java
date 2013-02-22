package applepie.block;

import applepie.ApplePie;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class BlockAppleFlowerPot extends BlockFlowerPot {

	public BlockAppleFlowerPot(int par1)
	{
		super(par1);
		this.blockIndexInTexture = 186;
		this.setBlockBoundsForItemRender();
		this.setRequiresSelfNotify();
	}

	@Override
	public void setBlockBoundsForItemRender()
	{
		float var1 = 0.375F;
		float var2 = var1 / 2.0F;
		this.setBlockBounds(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return ApplePie.potRenderID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}



}
