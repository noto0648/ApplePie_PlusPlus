package net.minecraft.src.applepie;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class BlockAppleMachine extends Block{

	public BlockAppleMachine(int par1, int par2) {
		super(par1, par2, Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	if(par2 == 0||par2 == 6)
    	{
    		return 6;
    	}else
    	{
    		return 5;
    	}
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
        	par5EntityPlayer.openGui(ApplePieMod.instance, ApplePieMod.appleGuiID, par1World, par2, par3, par4);
        	//ModLoader.openGUI(par5EntityPlayer, new GuiAppleCheckMachine(par5EntityPlayer.inventory, par1World, par2, par3, par4));
        	return true;
        }

    }

}
