package com.noto0648.applepie;

import java.util.Random;

import com.noto0648.applepie.block.BlockAppleLeaves;
import com.noto0648.applepie.block.BlockAppleWood;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "applePiePlusPlus", name = "Apple Pie++", version = "2.0")
public class ApplePie
{
	public static Block appleWood;
	public static Block appleLeave;
	public static Block appleBlock;
	public static Block appleSapling;
	public static Block matingMachine;
	public static Block applePot;
	public static Block appleDirt;

	
	public static Item nApple;
	public static Item itemSapling;
	public static Item seedTool;
	public static Item appleSeed;
	public static Item appleIngot;
	public static Item appleBall;
	public static Item appleShears;
	
	public static Item appleArmorHelmet;
	public static Item appleArmorPlate;
	public static Item appleArmorRegins;
	public static Item appleArmorBooth;
	
	public static CreativeTabs applepieTab = new CreativeTabApplePie();
	public static ItemArmor.ArmorMaterial MATERIAL_APPLE = EnumHelper.addArmorMaterial("APPLE", 20, new int[]{2, 6, 5, 2}, 9);

	@SidedProxy(clientSide = "com.noto0648.applepie.client.ClientProxy", serverSide = "com.noto0648.applepie.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("applePiePlusPlus")
	public static ApplePie instance;
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
        /*
		matingGUIID = 128;
		proxy.registerRenderInformation();
		GameRegistry.registerWorldGenerator(this);
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		nApple = new ItemNApple(nAppleID - 256).setItemName("applepie.notoapple").setIconCoord(0, 1).setCreativeTab(applepieTab);
		itemSapling = new ItemAppleSapling(itemSaplingID - 256).setItemName("applepie.itemSapling").setIconCoord(4, 0).setCreativeTab(applepieTab);
		seedTool = new ItemSeedTool(seedToolID - 256).setItemName("applepie.seedtool").setIconCoord(4, 1).setCreativeTab(applepieTab);
		appleIngot = new ItemAppleIngot(appleIngotID - 256).setItemName("applepie.appleIngot").setIconCoord(0, 5).setCreativeTab(applepieTab);
		appleBall = new ItemAppleIngot(appleBallID - 256).setItemName("applepie.appleBall").setIconCoord(1, 5).setCreativeTab(applepieTab);
		appleShears = new ItemAppleShears(appleShearsID - 256).setItemName("applepie.appleShaears").setIconCoord(7, 5).setCreativeTab(applepieTab);
		
		appleArmorHelmet = new ItemAppleArmor(appleArmor_A_ID - 256, APPLE, armorRender, 0).setIconCoord(2, 5).setItemName("applepie.armor_helmet").setCreativeTab(applepieTab);
		appleArmorPlate = new ItemAppleArmor(appleArmor_B_ID - 256, APPLE, armorRender, 1).setIconCoord(3, 5).setItemName("applepie.armor_plate").setCreativeTab(applepieTab);
		appleArmorRegins = new ItemAppleArmor(appleArmor_C_ID - 256, APPLE, armorRender, 2).setIconCoord(4, 5).setItemName("applepie.armor_regins").setCreativeTab(applepieTab);
		appleArmorBooth = new ItemAppleArmor(appleArmor_D_ID - 256, APPLE, armorRender, 3).setIconCoord(5, 5).setItemName("applepie.armor_booth").setCreativeTab(applepieTab);
		
		appleWood = new BlockAppleWood(appleWoodID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setBlockName("applepie.appleWood").setCreativeTab(applepieTab);
		appleLeave = new BlockAppleLeave(appleLeaveID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("applepie.appleLeaves").setCreativeTab(applepieTab);
		appleBlock = new BlockApple(appleBlockID).setHardness(0.1F).setStepSound(Block.soundGrassFootstep).setBlockName("applepie.appleBlock").setRequiresSelfNotify();
		appleSapling = new BlockAppleSapling(appleSaplingID).setHardness(0.1F).setStepSound(Block.soundGrassFootstep).setBlockName("applepie.appleSapling");
		
		GameRegistry.registerBlock(appleWood, "applepie.appleWood");
		GameRegistry.registerBlock(appleLeave, "applepie.appleLeaves");
		GameRegistry.registerBlock(appleBlock, "applepie.appleBlock");
		GameRegistry.registerBlock(appleSapling, "applepie.appleSapling");
		//GameRegistry.registerBlock(matingMachine, "applepie.matingMachine");
		//GameRegistry.registerBlock(appleDirt, "applepie.appleDirt");
		//GameRegistry.registerBlock(applePot, "applepie.applePot");
		
		GameRegistry.registerTileEntity(TileEntityAppleWood.class, "tileentity.applewood");
		
		LanguageRegistry.addName(nApple, "Apple");
		LanguageRegistry.addName(itemSapling, "Apple Sapling");
		LanguageRegistry.addName(seedTool, "Seed Tool");
		LanguageRegistry.addName(appleIngot, "Apple Ingot");
		LanguageRegistry.addName(appleArmorHelmet, "Apple Helmet");
		LanguageRegistry.addName(appleArmorPlate, "Apple Chestplate");
		LanguageRegistry.addName(appleArmorRegins, "Apple Leggings");
		LanguageRegistry.addName(appleArmorBooth, "Apple Boots");
		LanguageRegistry.addName(appleBall, "Lump of Apple");
		LanguageRegistry.addName(appleShears, "Apple Shears");
		//LanguageRegistry.addName(appleSeed, "Apple Seed");
		
		LanguageRegistry.addName(appleWood, "Apple Wood");
		LanguageRegistry.addName(appleLeave, "Apple Leaves");
		LanguageRegistry.addName(appleBlock, "Apple");
		LanguageRegistry.addName(appleSapling, "Apple Sapling");
		//LanguageRegistry.addName(matingMachine, "Mating Machine");
		//LanguageRegistry.addName(appleDirt, "AppleSeed in dirt");
		//LanguageRegistry.addName(applePot, "Apple Pot");
		
		LanguageRegistry.instance().addStringLocalization("applepie.ri", "Ripeness");
		LanguageRegistry.instance().addStringLocalization("applepie.sw", "Sweet");
		LanguageRegistry.instance().addStringLocalization("applepie.sp", "Speed");
		LanguageRegistry.instance().addStringLocalization("applepie.si", "Size");
		LanguageRegistry.instance().addStringLocalization("applepie.in", "Insect");
		
		LanguageRegistry.instance().addStringLocalization("applepie.ri", "ja_JP", "熟度");
		LanguageRegistry.instance().addStringLocalization("applepie.sw", "ja_JP", "美味しさ");
		LanguageRegistry.instance().addStringLocalization("applepie.sp", "ja_JP", "成長速度");
		LanguageRegistry.instance().addStringLocalization("applepie.si", "ja_JP", "大きさ");
		LanguageRegistry.instance().addStringLocalization("applepie.in", "ja_JP", "病気耐性");
		
		GameRegistry.addRecipe(new RecipeSapling());
		GameRegistry.addRecipe(new RecipeAppleDNA());
		GameRegistry.addRecipe(new ItemStack(appleArmorHelmet), new Object[]{"XXX", "X X", Character.valueOf('X'), ApplePie.appleIngot});
		GameRegistry.addRecipe(new ItemStack(appleArmorPlate), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), ApplePie.appleIngot});
		GameRegistry.addRecipe(new ItemStack(appleArmorRegins), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), ApplePie.appleIngot});
		GameRegistry.addRecipe(new ItemStack(appleArmorBooth), new Object[]{"X X", "X X", Character.valueOf('X'), ApplePie.appleIngot});
		GameRegistry.addRecipe(new ItemStack(appleBall, 2), new Object[]{"XX", "XX", Character.valueOf('X'), new ItemStack(ApplePie.nApple, 1, -1)});
		GameRegistry.addRecipe(new ItemStack(appleShears, 1), new Object[]{" X", "X ", Character.valueOf('X'), ApplePie.appleIngot});
		
		GameRegistry.addSmelting(appleBall.itemID, new ItemStack(appleIngot, 1), 0.2F);*/
	}

	@Mod.EventHandler
	public void preLoaad(FMLPreInitializationEvent event)
	{
        appleWood = new BlockAppleWood();
        appleLeave = new BlockAppleLeaves();

        GameRegistry.registerBlock(appleWood, "NotoMod.appleWood");
        GameRegistry.registerBlock(appleLeave, "NotoMod.appleLeaves");

		MinecraftForge.EVENT_BUS.register(new AppleEvent());
	}

}
