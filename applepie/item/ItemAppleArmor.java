package applepie.item;

import applepie.ApplePie;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemAppleArmor extends ItemArmor implements IArmorTextureProvider{

	public ItemAppleArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack)
	{
		if((itemstack.itemID == ApplePie.appleArmorHelmet.itemID)||(itemstack.itemID == ApplePie.appleArmorPlate.itemID)||(itemstack.itemID == ApplePie.appleArmorBooth.itemID)) {
			return "/applepie/gfx/apple_1.png";
		}
		if(itemstack.itemID == ApplePie.appleArmorRegins.itemID) {
			return "/applepie/gfx/apple_2.png";
		}
		return null;
	}
	
	
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return par1ItemStack.itemID == ApplePie.appleIngot.itemID ? true : false ;
    }
	
	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}

}
