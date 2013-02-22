package applepie.item;

import applepie.ApplePie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSeedTool extends Item{

	public ItemSeedTool(int par1)
	{
		super(par1);
		this.setNoRepair();
		this.setMaxDamage(30);
		this.maxStackSize = 1;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
	{
		return false;
	}

	@Override
	public boolean hasContainerItem()
	{
		return true;
	}
	
	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack)
	{
		if (itemStack != null && itemStack.itemID == this.itemID)
		{
			itemStack.setItemDamage(itemStack.getItemDamage()+1);
		}
		return itemStack;
	}
	
	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}
}
