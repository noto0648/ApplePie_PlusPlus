package applepie.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import applepie.ApplePie;
import applepie.block.TileEntityAppleWood;

public class ItemAppleSapling extends Item{

	public ItemAppleSapling(int par1)
	{
		super(par1);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int spawnID = ApplePie.appleSapling.blockID;
		int var11 = par3World.getBlockId(par4, par5, par6);

		if (var11 == Block.snow.blockID)
		{
			par7 = 1;
		}
		else if (var11 != Block.vine.blockID && var11 != Block.tallGrass.blockID && var11 != Block.deadBush.blockID)
		{
			if (par7 == 0)
			{
				--par5;
			}

			if (par7 == 1)
			{
				++par5;
			}

			if (par7 == 2)
			{
				--par6;
			}

			if (par7 == 3)
			{
				++par6;
			}

			if (par7 == 4)
			{
				--par4;
			}

			if (par7 == 5)
			{
				++par4;
			}
		}

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else if (par1ItemStack.stackSize == 0)
		{
			return false;
		}
		else
		{
			if (par3World.canPlaceEntityOnSide(spawnID, par4, par5, par6, false, par7, (Entity)null))
			{
				Block var12 = Block.blocksList[spawnID];
				int var13 = var12.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);

				if (par3World.setBlockAndMetadataWithNotify(par4, par5, par6, spawnID, var13))
				{
					if (par3World.getBlockId(par4, par5, par6) == spawnID)
					{
						Block.blocksList[spawnID].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer);
						Block.blocksList[spawnID].onPostBlockPlaced(par3World, par4, par5, par6, var13);
					}

					NBTTagCompound nbt = par1ItemStack.getTagCompound();
					if(nbt != null)
					{
						TileEntityAppleWood te = (TileEntityAppleWood)par3World.getBlockTileEntity(par4, par5, par6);
						te.sweet = nbt.getInteger("sweet");
						te.speed = nbt.getInteger("speed");
						te.size = nbt.getInteger("size");
						te.insect = nbt.getInteger("insect");
					}
					par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var12.stepSound.getPlaceSound(), (var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
					--par1ItemStack.stackSize;
					return true;
				}
			}

			return false;
		}
	}


	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		NBTTagCompound nbt = par1ItemStack.getTagCompound();
		if(nbt == null)
			return;
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

}
