package applepie.item;

import applepie.ApplePie;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAppleSeed extends Item{

	public ItemAppleSeed(int par1)
	{
		super(par1);
	}

	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(par3World.getBlockId(par4, par5, par6) == Block.flowerPot.blockID)
		{
			par3World.setBlockAndMetadata(par4, par5, par6, ApplePie.applePot.blockID, 0);
			return true;
		}
		return false;
	}

}
