package com.mint.mintstinker.Register;

import com.mint.mintstinker.MintsTinker;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.EnumObject;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.library.tools.definition.ModifiableArmorMaterial;
import slimeknights.tconstruct.library.tools.item.armor.MultilayerArmorItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.item.ArmorSlotType;

import static com.mint.mintstinker.MintsTinker.MOD_ID;

public class MintsTinkerItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final Item.Properties ARMOR = new Item.Properties().stacksTo(1).tab(MintsTinkertab.MATERIALS);
    public static final ModifiableArmorMaterial MAGITEK_ARMOR_MATERIAL = ModifiableArmorMaterial.create(MintsTinker.getResource("magitek_armor"), SoundEvents.ARMOR_EQUIP_NETHERITE);//魔导铠
    public static final EnumObject<ArmorSlotType, MultilayerArmorItem> MAGITEK_ARMOR = new EnumObject.Builder<ArmorSlotType, MultilayerArmorItem>(ArmorSlotType.class)
            .put(ArmorSlotType.HELMET, ITEMS.register("magitek_armor_helmet", () -> new MultilayerArmorItem(MAGITEK_ARMOR_MATERIAL, ArmorSlotType.HELMET, ARMOR)))//魔导铠头盔
            .put(ArmorSlotType.CHESTPLATE, ITEMS.register("magitek_armor_chestplate", () -> new MultilayerArmorItem(MAGITEK_ARMOR_MATERIAL, ArmorSlotType.CHESTPLATE, ARMOR)))//魔导铠胸甲
            .put(ArmorSlotType.LEGGINGS, ITEMS.register("magitek_armor_leggings", () -> new MultilayerArmorItem(MAGITEK_ARMOR_MATERIAL, ArmorSlotType.LEGGINGS, ARMOR)))//魔导铠护腿
            .put(ArmorSlotType.BOOTS, ITEMS.register("magitek_armor_boots", () -> new MultilayerArmorItem(MAGITEK_ARMOR_MATERIAL, ArmorSlotType.BOOTS, ARMOR)))//魔导铠靴子
            .build();
    public static final RegistryObject<Item> wizard_alloy = ITEMS.register("wizard_alloy", () -> new Item(new Item.Properties().tab(MintsTinkertab.MATERIALS)));//巫师合金
    public static final RegistryObject<Item> wind_dragon = ITEMS.register("wind_dragon", () -> new Item(new Item.Properties().tab(MintsTinkertab.MATERIALS)));//飓风飞龙
    public static final MaterialStatsId MAGIC_CORE_STAT = new MaterialStatsId(MintsTinker.getResource("magic_core"));
    public static final RegistryObject<ToolPartItem> magic_core = ITEMS.register("magic_core", () -> new ToolPartItem(new Item.Properties().tab(MintsTinkertab.MATERIALS), MAGIC_CORE_STAT));//魔力核心

}
