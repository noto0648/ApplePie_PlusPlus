package applepie.client;

import applepie.ApplePie;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

@SideOnly(Side.CLIENT)
public class RenderAppleBlocks implements ISimpleBlockRenderingHandler{


	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		if(world.getBlockId(x, y, z) == ApplePie.applePot.blockID)
		{
			renderer.renderStandardBlock(block, x, y, z);
			Tessellator var5 = Tessellator.instance;
			var5.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			float var6 = 1.0F;
			int var7 = block.colorMultiplier(world, x, y, z);
			int var8 = Block.flowerPot.blockIndexInTexture;
			float var9 = (float)(var7 >> 16 & 255) / 255.0F;
			float var10 = (float)(var7 >> 8 & 255) / 255.0F;
			float var11 = (float)(var7 & 255) / 255.0F;
			float var12;
			float var14;

			if (EntityRenderer.anaglyphEnable)
			{
				var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
				float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
				var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
				var9 = var12;
				var10 = var13;
				var11 = var14;
			}

			var5.setColorOpaque_F(var6 * var9, var6 * var10, var6 * var11);
			var12 = 0.1865F;
			renderer.renderSouthFace(block, (double)((float)x - 0.5F + var12), (double)y, (double)z, var8);
			renderer.renderNorthFace(block, (double)((float)x + 0.5F - var12), (double)y, (double)z, var8);
			renderer.renderWestFace(block, (double)x, (double)y, (double)((float)z - 0.5F + var12), var8);
			renderer.renderEastFace(block, (double)x, (double)y, (double)((float)z + 0.5F - var12), var8);
			renderer.renderTopFace(block, (double)x, (double)((float)y - 0.5F + var12 + 0.1875F), (double)z, Block.dirt.blockIndexInTexture);
			int var19 = world.getBlockMetadata(x, y, z);
			var14 = 0.0F;
			float var15 = 4.0F;
			float var16 = 0.0F;
			Block var17 = ApplePie.appleSapling;
			var5.addTranslation(var14 / 16.0F, var15 / 16.0F, var16 / 16.0F);
			renderer.drawCrossedSquares(var17, 0, x, y, z, 0.5F);
			var5.addTranslation(-var14 / 16.0F, -var15 / 16.0F, -var16 / 16.0F);
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return ApplePie.potRenderID;
	}

}
