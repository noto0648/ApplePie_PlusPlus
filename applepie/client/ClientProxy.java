package applepie.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import applepie.ApplePie;
import applepie.CommonProxy;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture(ApplePie.terrain);
		ApplePie.potRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderAppleBlocks());
		ApplePie.armorRender = RenderingRegistry.addNewArmourRendererPrefix("APPLE");
	}
}
