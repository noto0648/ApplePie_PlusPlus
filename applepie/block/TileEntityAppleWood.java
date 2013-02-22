package applepie.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAppleWood extends TileEntity{
	
	public int sweet = 0;
	public int speed = 0;
	public int size = 0;
	public int insect = 0;
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		this.sweet = par1NBTTagCompound.getInteger("sweet");
		this.speed = par1NBTTagCompound.getInteger("speed");
		this.size = par1NBTTagCompound.getInteger("size");
		this.insect = par1NBTTagCompound.getInteger("insect");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("sweet", this.sweet);
		par1NBTTagCompound.setInteger("speed", this.speed);
		par1NBTTagCompound.setInteger("size", this.size);
		par1NBTTagCompound.setInteger("insect", this.insect);
	}

}
