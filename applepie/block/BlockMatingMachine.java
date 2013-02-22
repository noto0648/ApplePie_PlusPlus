package applepie.block;

import applepie.ApplePie;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMatingMachine extends BlockContainer{

	public BlockMatingMachine(int par1)
	{
		super(par1, Material.iron);
	}
	
	@Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if(!par1World.isRemote)
		{
			par5EntityPlayer.openGui(ApplePie.instance, ApplePie.matingGUIID, par1World, par2, par3, par4);
			return true;
		}
        return false;
    }
	

	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityMatingMachine();
	}

}
