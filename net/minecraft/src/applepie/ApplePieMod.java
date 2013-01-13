package net.minecraft.src.applepie;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.File;
import java.util.Random;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.Property;
import net.minecraftforge.common.Configuration;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.Potion;
import net.minecraft.src.World;

@Mod( modid = "ApplePieplusplus", name="ApplePie++", version="1.4.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ApplePieMod implements IWorldGenerator{

	@SidedProxy(clientSide = "net.minecraft.src.applepie.ClientProxy", serverSide = "net.minecraft.src.applepie.CommonProxy")
	public static CommonProxy proxy;

    @Instance("ApplePieplusplus")
    public static ApplePieMod instance;

    public static Item ApplePie;
    public static Item BakedApple;
    public static Item AppleComport;
    public static Item DryApple;
    public static Item DiamondApple;
    public static Item PoisonApple;
    public static Item AppleCookie;
    public static Item Applejelly;
    public static Item kininaru;
    public static Item OldApple;

    public static Block AppleOre;
    public static Block AppleMachine;

	@Init
    public void myNewLoadMethod(FMLInitializationEvent event)
    {
		ApplePie = new ItemAppleFood(ApplePieID - 256, 6, false).setAlwaysEdible().setIconCoord(0, 0).setItemName("NotoMod.ApplePie");
		BakedApple = new ItemAppleFood(BakedAppleID- 256, 3, false).setAlwaysEdible().setIconCoord(1, 0).setItemName("NotoMod.BakedApple");
		AppleComport = new ItemAppleFood(AppleComportID - 256, 2, false).setAlwaysEdible().setIconCoord(2, 0).setItemName("NotoMod.AppleComport");
		DryApple = new ItemAppleFood(DryAppleID - 256, 2, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setIconCoord(3, 0).setItemName("NotoMod.DryApple");
		DiamondApple = new ItemDiamondApple(AppleDiamondID - 256, 20, false).setAlwaysEdible().setIconCoord(4, 0).setItemName("NotoMod.DiamondApple");
		PoisonApple = new ItemAppleFood(PoisonAppleID - 256, 1, false).setPotionEffect(Potion.poison.id, 15, 0, 1.0F).setIconCoord(5, 0).setItemName("NotoMod.PoisonApple");
		AppleCookie = new ItemAppleFood(AppleCookieID - 256, 2, false).setAlwaysEdible().setIconCoord(6, 0).setItemName("NotoMod.AppleCookie");
		Applejelly = new ItemAppleFood(AppleJellyID - 256, 6, false).setAlwaysEdible().setIconCoord(7, 0).setItemName("NotoMod.AppleJelly");
		kininaru = new ItemAppleFood(KininaruRingoID - 256, 17, false).setAlwaysEdible().setIconCoord(8, 0).setItemName("NotoMod.KininaruRingo");
		OldApple = new ItemOldApple(OldAppleID).setItemName("NotoMod.appleOld").setIconCoord(0, 1);
		/*	APPLE BLOCKS*/
		AppleOre = new BlockAppleOre(AppleOreID, 208).setHardness(1.0F).setBlockName("NotoMod.appleOre").setCreativeTab(CreativeTabs.tabBlock);
		AppleMachine = new BlockAppleMachine(AppleMachineID, 8).setBlockName("NotoMod.appleMachine");
		GameRegistry.registerBlock(AppleOre);
		GameRegistry.registerBlock(AppleMachine);

		LanguageRegistry.instance().addName(ApplePie ,"ApplePie");
		LanguageRegistry.instance().addName(BakedApple, "Baked Apple");
		LanguageRegistry.instance().addName(AppleComport, "Apple Comport");
		LanguageRegistry.instance().addName(DryApple, "Dry Apple");
		LanguageRegistry.instance().addName(DiamondApple, "Diamond Apple");
		LanguageRegistry.instance().addName(PoisonApple, "Poison Apple");
		LanguageRegistry.instance().addName(AppleCookie, "Apple Cookie");
		LanguageRegistry.instance().addName(Applejelly, "Apple Jelly");
		LanguageRegistry.instance().addName(kininaru, "Kininaranai Ringo");
		LanguageRegistry.instance().addName(OldApple, "Old Apple");
		LanguageRegistry.instance().addName(AppleOre, "Apple Ore");

		LanguageRegistry.instance().addNameForObject(ApplePie ,"ja_JP","アップルパイ");
        LanguageRegistry.instance().addNameForObject(BakedApple, "ja_JP","焼きリンゴ");
        LanguageRegistry.instance().addNameForObject(AppleComport, "ja_JP","アップルコンポート");
        LanguageRegistry.instance().addNameForObject(DryApple, "ja_JP","ドライアップル");
        LanguageRegistry.instance().addNameForObject(DiamondApple, "ja_JP","金剛のリンゴ");
        LanguageRegistry.instance().addNameForObject(PoisonApple, "ja_JP","毒リンゴ");
        LanguageRegistry.instance().addNameForObject(AppleCookie, "ja_JP","リンゴクッキー");
        LanguageRegistry.instance().addNameForObject(Applejelly, "ja_JP","リンゴゼリー");
        LanguageRegistry.instance().addNameForObject(kininaru, "ja_JP","気にならない リンゴ");

        LanguageRegistry.instance().addStringLocalization("apple.amai", "Saccharimeter");
        LanguageRegistry.instance().addStringLocalization("apple.amai", "ja_JP", "検糖計");

        GameRegistry.addRecipe(new ItemStack(ApplePie, 2),new Object[]{" C ","BXB","CXC",Character.valueOf('X'),Item.appleRed ,Character.valueOf('B'),Item.sugar, Character.valueOf('C'),Item.wheat});
        GameRegistry.addRecipe(new ItemStack(AppleComport, 8),new Object[]{"BBB","BXB","BBB",Character.valueOf('X'),Item.appleRed ,Character.valueOf('B'),Item.sugar});
        GameRegistry.addRecipe(new ItemStack(DiamondApple, 1),new Object[]{"BBB","BXB","BBB",Character.valueOf('X'),Item.appleRed ,Character.valueOf('B'),Block.blockDiamond});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.blockDiamond,8),new Object[]{new ItemStack(DiamondApple, 1)});
        GameRegistry.addRecipe(new ItemStack(PoisonApple, 1),new Object[]{"X","B",Character.valueOf('X'),Item.spiderEye ,Character.valueOf('B'),Item.appleRed});
        GameRegistry.addRecipe(new ItemStack(AppleCookie, 4),new Object[]{"BXB",Character.valueOf('X'),Item.appleRed ,Character.valueOf('B'),Item.wheat});
        GameRegistry.addRecipe(new ItemStack(Applejelly, 1),new Object[]{"B","C","D",Character.valueOf('C'),Item.appleRed ,Character.valueOf('B'),Item.sugar,Character.valueOf('D'),Item.bucketWater});
        GameRegistry.addRecipe(new ItemStack(kininaru, 1),new Object[]{"BBB","BXB","BBB",Character.valueOf('X'),Item.appleRed ,Character.valueOf('B'),Item.wheat});

        FurnaceRecipes.smelting().addSmelting(Item.appleRed.shiftedIndex, new ItemStack(BakedApple, 1), 3 );
        FurnaceRecipes.smelting().addSmelting(AppleComport.shiftedIndex,new ItemStack(DryApple, 1),3);

        DungeonHooks.addDungeonLoot(new ItemStack(DiamondApple),001);
		proxy.registerRenderInformation();

		NetworkRegistry.instance().registerGuiHandler(this, proxy);
    }

    @Mod.PreInit
    public void myNewPreLoadMethod(FMLPreInitializationEvent evt)
    {
   	   Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
          config.load();
          ApplePieID = config.getItem("ApplePieID", 25300).getInt();
          BakedAppleID = config.getItem("BakedAppleID", 25301).getInt();
          AppleComportID = config.getItem("AppleComportID", 25302).getInt();
          DryAppleID = config.getItem("DryAppleID", 25303).getInt();
          AppleDiamondID = config.getItem("DiamondAppleID", 25304).getInt();
          PoisonAppleID = config.getItem("PoisonAppleID", 25305).getInt();
          AppleCookieID = config.getItem("AppleCookieID", 25306).getInt();
          AppleJellyID = config.getItem("AppleJellyID", 25307).getInt();
          KininaruRingoID = config.getItem("KininaruRingoID", 25308).getInt();
          OldAppleID = config.getItem("OldAppleID", 25309).getInt();

          AppleOreID = config.getBlock("AppleOreID", 3120).getInt();
          AppleMachineID = config.getBlock("AppleMachineID", 3121).getInt();

          appleGuiID = config.get("gui","appleMachineGuiID", 180).getInt();
          config.save();
    }


    public static int ApplePieID;
    public static int BakedAppleID;
    public static int AppleComportID;
    public static int DryAppleID;
    public static int AppleDiamondID;
    public static int PoisonAppleID;
    public static int AppleCookieID;
    public static int AppleJellyID;
    public static int KininaruRingoID;
    public static int OldAppleID;

    public static int AppleOreID;
    public static int AppleMachineID;

    public static int appleGuiID;

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{

	}

}
