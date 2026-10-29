package com.mint.mintstinker;

import com.mint.mintstinker.Register.MintsTinkerEffects;
import com.mint.mintstinker.Register.MintsTinkerEntities;
import com.mint.mintstinker.Register.MintsTinkerFluid;
import com.mint.mintstinker.Register.MintsTinkerItem;
import com.mint.mintstinker.Register.MintsTinkerModifier;
import com.mint.mintstinker.Register.MintsTinkerSounds;
import com.mint.mintstinker.stats.MagicCoreMaterialStats;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;

@Mod(MintsTinker.MOD_ID)
public class MintsTinker {
    public static final String MOD_ID = "mintstinker";

    public MintsTinker() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MintsTinkerItem.ITEMS.register(modEventBus);
        MintsTinkerEntities.ENTITIES.register(modEventBus);
        MintsTinkerModifier.MODIFIERS.register(modEventBus);
        MintsTinkerFluid.FLUIDS.register(modEventBus);
        MintsTinkerEffects.EFFECT.register(modEventBus);
        MintsTinkerSounds.SOUNDS.register(modEventBus);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> MaterialRegistry.getInstance().registerStatType(
                MagicCoreMaterialStats.TYPE,
                MaterialRegistry.ARMOR));
    }
    
    
    
    public static ResourceLocation getResource(String id) {return new ResourceLocation("mintstinker", id);
    }

    public static <T> TinkerDataCapability.TinkerDataKey<T> createKey(String name) {
        return TinkerDataCapability.TinkerDataKey.of(getResource(name));
    }

    public static String makeDescriptionId(String type, String name) {
        return type + ".mintstinker." + name;
    }
}

