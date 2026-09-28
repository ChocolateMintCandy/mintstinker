package com.mint.mintstinker.Register;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mint.mintstinker.MintsTinker.MOD_ID;

public class MintsTinkerItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> wizard_alloy = ITEMS.register("wizard_alloy", () -> new Item(new Item.Properties().tab(MintsTinkertab.MATERIALS)));//巫师合金
    public static final RegistryObject<Item> wind_dragon = ITEMS.register("wind_dragon", () -> new Item(new Item.Properties().tab(MintsTinkertab.MATERIALS)));//飓风飞龙

}
