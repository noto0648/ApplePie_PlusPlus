package net.minecraft.src.applepie;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;

public class ItemAppleFood extends ItemFood{

	public static boolean light;
	public static boolean pink;
	
	public ItemAppleFood(int par1, int par2, boolean par3) {
		
		super(par1, par2, par3);
		this.maxStackSize = 64;
	}

    @SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return "/noto/apples/items01.png";
	}
	
	
}
