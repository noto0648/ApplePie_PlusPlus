package net.minecraft.src.applepie;

import java.util.Random;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class BlockAppleOre extends BlockApples{

	public BlockAppleOre(int par1, int par2) {
		super(par1, par2, Material.rock);
	}

	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		ItemStack itemstack = new ItemStack(ApplePieMod.OldApple);
		NBTTagCompound nbt = itemstack.getTagCompound();
		if(nbt == null){
			//NBTがついてなかったら
			nbt = new NBTTagCompound();
			itemstack.setTagCompound(nbt);
		}
		nbt.setInteger("sweet", par1World.rand.nextInt(10)+1);



		for(int k = 0; k < quantityDropped(par1World.rand);k++){
	        if (!par1World.isRemote && par1World.getGameRules().getGameRuleBooleanValue("doTileDrops"))
	        {
	            float var6 = 0.7F;
	            double var7 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
	            double var9 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
	            double var11 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
	            EntityItem var13 = new EntityItem(par1World, (double)par3 + var7, (double)par4 + var9, (double)par5 + var11, itemstack);
	            var13.delayBeforeCanPickup = 10;
	            par1World.spawnEntityInWorld(var13);
	        }
		}
	}
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return ApplePieMod.OldApple.shiftedIndex;
	}

    public int quantityDropped(Random par1Random)
    {
    	return par1Random.nextInt(3) + 1;
    }

}
