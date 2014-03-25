package com.noto0648.applepie.block;

import com.noto0648.applepie.ApplePie;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Noto on 14/03/25.
 */
public class BlockAppleWood extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;

    public BlockAppleWood()
    {
        super(Material.wood);
        this.setCreativeTab(ApplePie.applepieTab);
        this.setBlockName("NotoMod.appleWood");
        this.setBlockTextureName("applepie:appleWood");
        this.setStepSound(Block.soundTypeWood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int p_149691_2_)
    {
        if (side == ForgeDirection.UP.ordinal() || side == ForgeDirection.DOWN.ordinal())
        {
            return this.topIcon;
        }

        return this.sideIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        super.registerBlockIcons(p_149651_1_);
        sideIcon = p_149651_1_.registerIcon("applepie:wood_side");
        topIcon = p_149651_1_.registerIcon("applepie:wood_top");
    }
}
