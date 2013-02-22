package applepie.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityMatingMachine extends TileEntity implements IInventory, ISidedInventory{

	private ItemStack[] stack = new ItemStack[3];
	public int cookTime = 0;

	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if (side == ForgeDirection.DOWN) return 1;
		if (side == ForgeDirection.UP) return 0;
		return 2;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}

	@Override
	public int getSizeInventory()
	{
		return stack.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1)
	{
		return stack[var1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.stack[par1] != null)
		{
			ItemStack var3;

			if (this.stack[par1].stackSize <= par2)
			{
				var3 = this.stack[par1];
				this.stack[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.stack[par1].splitStack(par2);

				if (this.stack[par1].stackSize == 0)
				{
					this.stack[par1] = null;
				}

				return var3;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.stack[par1] != null)
		{
			ItemStack var2 = this.stack[par1];
			this.stack[par1] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
		this.stack[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName()
	{
		return "container.applemating";
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1)
	{
		return false;
	}

	public void openChest() {}

	public void closeChest() {}

}
