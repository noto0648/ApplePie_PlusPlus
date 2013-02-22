package applepie.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import applepie.ApplePie;

public class ItemNApple extends ItemFood{

	public ItemNApple(int par1)
	{
		super(par1, 0, 0.6f, false);
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
	}

	@Override
	public int getIconFromDamage(int par1)
	{
		return par1 == 1 ? 16 : (par1 == 2) ? 18 : 17;
	}
	
	@Override
	protected void func_77849_c(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
			NBTTagCompound nbt = par1ItemStack.getTagCompound();
			if((nbt != null)&&(par1ItemStack.getItemDamage() != 2))
			{
				par3EntityPlayer.heal(nbt.getInteger("sweet") / 2);
				par3EntityPlayer.getFoodStats().addStats(nbt.getInteger("size"), 0.6F);
				if((nbt.getShort("ripeness") == 1)&&(par2World.rand.nextFloat() < 0.8F))
				{
					par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 30 * 20, 0));
				}
			} else {
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.poison.id, 30 * 20, 0));
			}
		}
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		NBTTagCompound nbt = par1ItemStack.getTagCompound();
		if(nbt == null)
			return;
		par3List.add(StatCollector.translateToLocal("applepie.ri") + " : " + nbt.getShort("ripeness"));
		par3List.add(StatCollector.translateToLocal("applepie.sw") + " : " + nbt.getInteger("sweet"));
		par3List.add(StatCollector.translateToLocal("applepie.sp") + " : " + nbt.getInteger("speed"));
		par3List.add(StatCollector.translateToLocal("applepie.si") + " : " + nbt.getInteger("size"));
		par3List.add(StatCollector.translateToLocal("applepie.in") + " : " + nbt.getInteger("insect"));
	}


	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}

}
