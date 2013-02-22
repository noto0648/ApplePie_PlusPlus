package applepie.item;

import applepie.ApplePie;
import net.minecraft.item.Item;

public class ItemAppleIngot extends Item{

	public ItemAppleIngot(int par1)
	{
		super(par1);
	}
	
	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}

}
