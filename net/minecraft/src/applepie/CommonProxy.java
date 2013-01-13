package net.minecraft.src.applepie;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{

    public void registerRenderInformation()
    {

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
		if (ID == ApplePieMod.appleGuiID)
		{
			return new GuiAppleCheckMachine(player.inventory, world, x, y, z);
		}
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
		if (ID == ApplePieMod.appleGuiID)
		{
			return new ContainerAppleCheckMachine(player.inventory, world, x, y, z);
		}
        return null;
    }
}