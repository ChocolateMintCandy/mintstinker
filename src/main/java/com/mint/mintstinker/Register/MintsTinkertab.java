package com.mint.mintstinker.Register;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MintsTinkertab {
    public static final CreativeModeTab MATERIALS = new CreativeModeTab("mintstinker.materials") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(MintsTinkerItem.wizard_alloy.get());}
        };






    public MintsTinkertab() {
    }
}
