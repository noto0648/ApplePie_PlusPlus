package com.noto0648.applepie;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabApplePie extends CreativeTabs
{

	private int fuse = 60;
	
	public CreativeTabApplePie()
	{
		super("ApplePie");
	}

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(Blocks.brick_block);
    }

	@Override
	public String getTranslatedTabLabel()
	{
		return "ApplePie#";
	}

}
