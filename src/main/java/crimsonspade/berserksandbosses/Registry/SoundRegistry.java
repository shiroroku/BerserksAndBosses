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
    public static RegistryObject<SoundEvent> BLIZZPA_AMBIENCE = registerSoundEvent("blizzpa_ambience");
    public static RegistryObject<SoundEvent> CRIMPA_AMBIENCE = registerSoundEvent("crimpa_ambience");
    public static RegistryObject<SoundEvent> CRIMPA_DEATH = registerSoundEvent("crimpa_death");
    public static RegistryObject<SoundEvent> CRIMPA_HURT = registerSoundEvent("crimpa_hurt");
    public static RegistryObject<SoundEvent> CRIMSADER_AMBIENCE = registerSoundEvent("crimsader_ambience");
    public static RegistryObject<SoundEvent> CRIMSADER_DEATH = registerSoundEvent("crimsader_death");
    public static RegistryObject<SoundEvent> NORMPA_AMBIENCE = registerSoundEvent("normpa_ambience");
    public static RegistryObject<SoundEvent> WARPA_AMBIENCE = registerSoundEvent("warpa_ambience");
    public static RegistryObject<SoundEvent> WARPA_DEATH = registerSoundEvent("warpa_death");
    public static RegistryObject<SoundEvent> WARPA_HURT = registerSoundEvent("warpa_hurt");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(BerserksAndBosses.MODID, name)));
    }
}
