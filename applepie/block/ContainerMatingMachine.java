package applepie.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerMatingMachine extends Container{

	private TileEntityMatingMachine machine;

	public ContainerMatingMachine(InventoryPlayer par1InventoryPlayer, TileEntityMatingMachine par2TileEntity)
	{
		this.machine = par2TileEntity;
		this.addSlotToContainer(new Slot(par2TileEntity, 0, 56, 17));
		this.addSlotToContainer(new Slot(par2TileEntity, 1, 56, 53));
		this.addSlotToContainer(new SlotMatingMachine(par1InventoryPlayer.player, par2TileEntity, 2, 116, 35));

		/* Add Player Inventory */
		int var3;
		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3)
		{
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.machine.cookTime);
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int par1, int par2)
	{

	}

	@Override
	public boolean canInteractWith(EntityPlayer var1)
	{
		return this.machine.isUseableByPlayer(var1);
	}

	/**
	 *  on Errors
	 */
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack var3 = null;
		Slot var4 = (Slot)this.inventorySlots.get(par2);

		if (var4 != null && var4.getHasStack())
		{
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();

			if (par2 == 2)
			{
				if (!this.mergeItemStack(var5, 3, 39, true))
				{
					return null;
				}

				var4.onSlotChange(var5, var3);
			}
			else if (par2 != 1 && par2 != 0)
			{
				if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null)
				{
					if (!this.mergeItemStack(var5, 0, 1, false))
					{
						return null;
					}
				}
				else if (TileEntityFurnace.isItemFuel(var5))
				{
					if (!this.mergeItemStack(var5, 1, 2, false))
					{
						return null;
					}
				}
				else if (par2 >= 3 && par2 < 30)
				{
					if (!this.mergeItemStack(var5, 30, 39, false))
					{
						return null;
					}
				}
				else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var5, 3, 30, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(var5, 3, 39, false))
			{
				return null;
			}

			if (var5.stackSize == 0)
			{
				var4.putStack((ItemStack)null);
			}
			else
			{
				var4.onSlotChanged();
			}

			if (var5.stackSize == var3.stackSize)
			{
				return null;
			}

			var4.onPickupFromSlot(par1EntityPlayer, var5);
		}

		return var3;
	}

}
