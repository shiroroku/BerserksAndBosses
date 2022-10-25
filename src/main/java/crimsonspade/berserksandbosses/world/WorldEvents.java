package crimsonspade.berserksandbosses.world;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BerserksAndBosses.MODID)
public class WorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        EntityGen.onEntitySpawn(event);
    }
}
