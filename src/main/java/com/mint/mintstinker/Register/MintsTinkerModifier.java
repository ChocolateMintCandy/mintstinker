package com.mint.mintstinker.Register;

import com.mint.mintstinker.Modifiers.battle.WindPressure;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;


import static com.mint.mintstinker.MintsTinker.MOD_ID;

public class MintsTinkerModifier {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MOD_ID);
    public static final StaticModifier<WindPressure> WINDPRESSURE_STATIC_MODIFIER = MODIFIERS.register("windpressure", WindPressure::new);   //风压


}
