package crimsonspade.berserksandbosses.Registry;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BerserksAndBosses.MODID);

    public static RegistryObject<SoundEvent> COLOSSUS_MUSIC = registerSoundEvent("father_fallen_foes");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(BerserksAndBosses.MODID, name)));
    }
}
