package com.mint.mintstinker.Register;

import com.mint.mintstinker.effects.Magical_Disease;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mint.mintstinker.MintsTinker.MOD_ID;

public class MintsTinkerEffects {
    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);
    public static final RegistryObject<MobEffect> magical_disease = EFFECT.register("magical_disease", Magical_Disease::new); //魔力短路


}
