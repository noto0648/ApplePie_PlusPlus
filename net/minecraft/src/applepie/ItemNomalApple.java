package net.minecraft.src.applepie;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Item;

public class ItemNomalApple extends Item{

	public ItemNomalApple(int par1) {
		super(par1);
	}


    @SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return "/noto/apples/items01.png";
	}
}
