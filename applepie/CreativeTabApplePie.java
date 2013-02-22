package applepie;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabApplePie extends CreativeTabs{

	private int fuse = 60;
	
	public CreativeTabApplePie()
	{
		super("ApplePie#");
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		fuse--;
		if(fuse < 0)
			fuse = 60;
		
		return (fuse < 20) ? new ItemStack(ApplePie.appleWood) : (fuse < 40) ? new ItemStack(ApplePie.nApple, 1, 0)  :new ItemStack(ApplePie.nApple, 1, 1) ;
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "ApplePie#";
	}

}
