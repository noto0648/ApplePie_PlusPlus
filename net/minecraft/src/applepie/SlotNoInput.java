package net.minecraft.src.applepie;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class SlotNoInput extends Slot{

	private EntityPlayer thePlayer;

	public SlotNoInput(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }

    protected void onCrafting(ItemStack par1ItemStack, int par2)
    {

    }

    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
    	//とった時の処理
    }

}
