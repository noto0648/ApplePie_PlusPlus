package com.noto0648.applepie.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import com.noto0648.applepie.ApplePie;
import com.noto0648.applepie.CommonProxy;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registers()
	{
		ApplePie.potRenderID = RenderingRegistry.getNextAvailableRenderId();
		//RenderingRegistry.registerBlockHandler(new RenderAppleBlocks());
		ApplePie.armorRender = RenderingRegistry.addNewArmourRendererPrefix("APPLE");
	}
}
