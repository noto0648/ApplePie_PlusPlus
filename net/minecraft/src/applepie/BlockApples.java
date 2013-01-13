package net.minecraft.src.applepie;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockApples extends Block{

	public BlockApples(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
	}

    @SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return "/noto/apples/items01.png";
	}

}
