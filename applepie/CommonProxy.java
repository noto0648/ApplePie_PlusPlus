package applepie;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import applepie.block.ContainerMatingMachine;
import applepie.block.TileEntityMatingMachine;
import applepie.client.GuiMatingMachine;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

	public void registerRenderInformation() 
	{
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == ApplePie.matingGUIID)
			return new ContainerMatingMachine(player.inventory, (TileEntityMatingMachine)world.getBlockTileEntity(x, y, z));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == ApplePie.matingGUIID)
			return new GuiMatingMachine(new ContainerMatingMachine(player.inventory, (TileEntityMatingMachine)world.getBlockTileEntity(x, y, z)));
		return null;
	}

}
