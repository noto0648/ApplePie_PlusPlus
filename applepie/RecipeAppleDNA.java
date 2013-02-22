package applepie;

import java.util.Random;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeAppleDNA implements IRecipe{

	private ItemStack recipe;

	@Override
	public boolean matches(InventoryCrafting par1, World par2)
	{
		ItemStack[] apple = new ItemStack[9];
		int count = 0;

		for(int num = 0; num < par1.getSizeInventory(); num++)
		{
			ItemStack slot = par1.getStackInSlot(num);
			if(slot != null)
			{
				if(slot.itemID == ApplePie.nApple.itemID)
				{
					apple[count] = slot;
					count ++;
				}
			}
		}
		if((count == 2)&&(apple[0] != null)&&(apple[1] != null))
		{
			NBTTagCompound nbtApple = apple[0].getTagCompound();
			NBTTagCompound _nbtApple = apple[1].getTagCompound();
			if((nbtApple != null)&&(_nbtApple != null))
			{
				Random rand = new Random();
				
				this.recipe = new ItemStack(ApplePie.nApple, 1, 2);
				NBTTagCompound itemTag = new NBTTagCompound();
				itemTag.setShort("ripeness", (short)rand.nextInt(128));
				itemTag.setInteger("sweet", rand.nextInt(2) == 0 ? nbtApple.getInteger("sweet") : _nbtApple.getInteger("sweet"));
				itemTag.setInteger("speed", rand.nextInt(2) == 0 ? nbtApple.getInteger("speed") : _nbtApple.getInteger("speed"));
				itemTag.setInteger("size", rand.nextInt(2) == 0 ? nbtApple.getInteger("size") : _nbtApple.getInteger("size"));
				itemTag.setInteger("insect", rand.nextInt(2) == 0 ? nbtApple.getInteger("insect") : _nbtApple.getInteger("insect"));
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
