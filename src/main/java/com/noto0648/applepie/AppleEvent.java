package com.noto0648.applepie;

import cpw.mods.fml.common.Mod;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class AppleEvent
{
	
	@Mod.EventHandler
	public void onBonemealUsed(BonemealEvent event)
	{
        /*
		if(event.ID == ApplePie.appleSapling.blockID)
		{
			BlockAppleSapling p = (BlockAppleSapling)ApplePie.appleSapling;
			p.boneMell(event.entityPlayer, event.world, event.X, event.Y, event.Z, event.entityPlayer.getCurrentEquippedItem());
			
		}*/
	}

}
