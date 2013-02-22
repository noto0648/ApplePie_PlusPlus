package applepie.item;

import java.util.ArrayList;
import java.util.Random;

import applepie.ApplePie;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.IShearable;

public class ItemAppleShears extends ItemShears{

	public ItemAppleShears(int par1)
	{
		super(par1);
	}


	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) 
	{
		if (player.worldObj.isRemote)
		{
			return false;
		}
		
		for(int i = -2; i < 3; i++)
		{
			for(int j = -1; j < 2; j++)
			{
				for(int k = -2; k < 3; k++)
				{
					int id = player.worldObj.getBlockId(x + i, y + j, z + k);
					System.out.println("id:" + id);
					if (Block.blocksList[id] instanceof IShearable)
					{
						player.worldObj.setBlockWithNotify(x + i, y + j, z + k, 0);
					}
				}
			}
			itemstack.damageItem(1, player);
			
		}
	return false;

}

@Override
public String getTextureFile()
{
	return ApplePie.terrain;
}

}
