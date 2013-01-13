package net.minecraft.src.applepie;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Potion;

public class ItemDiamondApple extends ItemFood{

	public static boolean light;
	public static boolean pink;
	
	public ItemDiamondApple(int par1, int par2, boolean par3) {
		
		super(par1, par2, par3);
		this.maxStackSize = 64;
		setPotionEffect(Potion.moveSpeed.id, 600, 3, 1.0F);
	}
	
    public boolean hasEffect(ItemStack par1ItemStack)
    {
 	   /*
 	    * アイテムを光らせる演出効果
 	    */
        return true;
    }


    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
 	   /*
 	    * 文字をピンク色に変える効果
 	    */
        return EnumRarity.epic;
    }

    @SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return "/noto/apples/items01.png";
	}
	
	
}