package applepie;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeSapling implements IRecipe{

	private ItemStack recipe;
	
	@Override
	public boolean matches(InventoryCrafting par1, World par2)
	{
		this.recipe = null;
		
		ItemStack apple = null;
		ItemStack tool = null;
		
		for(int num = 0; num < par1.getSizeInventory(); num++)
		{
			ItemStack slot = par1.getStackInSlot(num);
			if(slot != null)
			{
				if(slot.itemID == ApplePie.nApple.itemID)
					apple = slot;
				if(slot.itemID == ApplePie.seedTool.itemID)
					tool = slot;
			}
		}
		
		if((apple != null)&&(tool != null))
		{
			
			NBTTagCompound nbtApple = apple.getTagCompound();
			if((nbtApple != null))
			{
				this.recipe = new ItemStack(ApplePie.itemSapling, 1);
				NBTTagCompound itemTag = new NBTTagCompound();

				//itemTag.setShort("ripeness", nbtApple.getShort("ripeness"));
				itemTag.setInteger("sweet", nbtApple.getInteger("sweet"));
				itemTag.setInteger("speed", nbtApple.getInteger("speed"));
				itemTag.setInteger("size", nbtApple.getInteger("size"));
				itemTag.setInteger("insect", nbtApple.getInteger("insect"));
				this.recipe.setTagCompound(itemTag);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1)
	{
		return this.recipe.copy();
	}

	@Override
	public int getRecipeSize()
	{
		return 10;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
		return this.recipe;
	}

}
