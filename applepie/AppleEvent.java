package applepie;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

import applepie.block.*;

public class AppleEvent {
	
	@ForgeSubscribe
	public void onBonemealUsed(BonemealEvent event)
	{
		if(event.ID == ApplePie.appleSapling.blockID)
		{
			BlockAppleSapling p = (BlockAppleSapling)ApplePie.appleSapling;
			p.boneMell(event.entityPlayer, event.world, event.X, event.Y, event.Z, event.entityPlayer.getCurrentEquippedItem());
			
		}
	}

}
