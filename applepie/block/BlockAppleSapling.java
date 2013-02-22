package applepie.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import applepie.ApplePie;
import applepie.WorldGenAppleTree;

public class BlockAppleSapling extends BlockContainer implements IPlantable{

	public BlockAppleSapling(int par1)
	{
		super(par1, Material.plants);
		float var3 = 0.4F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		this.setTickRandomly(true);
		this.blockIndexInTexture = 4;
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			super.updateTick(par1World, par2, par3, par4, par5Random);
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
			{
				if (!par1World.isRemote)
				{
					TileEntityAppleWood te = (TileEntityAppleWood)par1World.getBlockTileEntity(par2, par3, par4);
					par1World.setBlock(par2, par3, par4, 0);
					if(te != null)
					{
						WorldGenAppleTree g = new WorldGenAppleTree(true, new int[]{te.sweet, te.speed, te.size, te.insect});
						g.generate(par1World, par1World.rand, par2, par3, par4);
					}else{
						WorldGenAppleTree g = new WorldGenAppleTree(true);
						g.generate(par1World, par1World.rand, par2, par3, par4);
					}
				}
			}
		}
	}

	public void boneMell(EntityPlayer par1EntityPlayer, World par2World, int par3, int par4, int par5, ItemStack par6ItemStack)
	{
		if (!par2World.isRemote)
		{
			TileEntityAppleWood te = (TileEntityAppleWood)par2World.getBlockTileEntity(par3, par4, par5);
			par2World.setBlock(par3, par4, par5, 0);
			if(te != null)
			{
				WorldGenAppleTree g = new WorldGenAppleTree(true, new int[]{te.sweet, te.speed, te.size, te.insect});
				g.generate(par2World, par2World.rand, par3, par4, par5);
			}else{
				WorldGenAppleTree g = new WorldGenAppleTree(true);
				g.generate(par2World, par2World.rand, par3, par4, par5);
			}
			if(!par1EntityPlayer.capabilities.isCreativeMode)
			{
				-- par6ItemStack.stackSize;
			}
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 1;
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	@Override
	public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	{
		super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
	}

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		Block soil = blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
		return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4)) && 
				(soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this));
	}



	protected final void checkFlowerChange(World par1World, int par2, int par3, int par4)
	{
		if (!this.canBlockStay(par1World, par2, par3, par4))
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlockWithNotify(par2, par3, par4, 0);
		}
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return super.canPlaceBlockAt(par1World, par2, par3, par4) && canBlockStay(par1World, par2, par3, par4);
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		this.checkFlowerChange(par1World, par2, par3, par4);
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z)
	{
		return blockID;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityAppleWood();
	}

	@Override
	public String getTextureFile()
	{
		return ApplePie.terrain;
	}

}
