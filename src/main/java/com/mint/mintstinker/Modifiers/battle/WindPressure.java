package com.mint.mintstinker.Modifiers.battle;

import com.mint.mintstinker.extend.superclass.BattleModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class WindPressure extends BattleModifier {

    /** 重力效果的注册名（来自新生魔艺 Ars Nouveau） */
    private static final ResourceLocation GRAVITY_EFFECT = new ResourceLocation("ars_nouveau", "gravity");
    /** 飞行效果的注册名（来自新生魔艺 Ars Nouveau） */
    private static final ResourceLocation FLIGHT_EFFECT = new ResourceLocation("ars_nouveau", "flight");
    /** 重力效果作用半径（米） */
    private static final double RANGE = 20.0D;
    /** 重力效果持续时间（tick，200 tick = 10 秒） */
    private static final int GRAVITY_DURATION = 200;
    /** 飞行效果持续时间（59 秒） */
    private static final int RITUAL_FLIGHT_DURATION = 1180;
    /** 飞行效果刷新阈值（30 秒），剩余时间不高于该值时重新赋予 */
    private static final int FLIGHT_REFRESH_THRESHOLD = 600;

    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level world, LivingEntity entity, int index, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        // 仅在服务端、持有者为玩家且工具位于正确槽位（手持或盔甲）时生效
        if (world.isClientSide || !(entity instanceof Player player) || !isCorrectSlot) {
            return;
        }
        // 每 20 tick（1 秒）检查一次，降低性能开销
        if (world.getGameTime() % 20 != 0) {
            return;
        }

        applyGravity(world, player, modifier);
        applyFlight(player);
    }

    @Override
    public boolean havenolevel() {
        return true;

    }
    /** 给半径 20 米内、除玩家外的生物施加重力效果 */
    private void applyGravity(Level world, Player player, ModifierEntry modifier) {
        MobEffect gravity = ForgeRegistries.MOB_EFFECTS.getValue(GRAVITY_EFFECT);
        if (gravity == null) {
            return;
        }
        AABB area = player.getBoundingBox().inflate(RANGE);
        List<LivingEntity> targets = world.getEntitiesOfClass(LivingEntity.class, area, target -> !(target instanceof Player));
        int amplifier = Math.max(0, modifier.getLevel() - 1);
        for (LivingEntity target : targets) {
            target.addEffect(new MobEffectInstance(gravity, GRAVITY_DURATION, amplifier));
        }
    }

    /** 给手持或装备该工具的玩家施加飞行效果；当剩余时间不超过 30 秒时重新赋予 */
    private void applyFlight(Player player) {
        MobEffect flight = ForgeRegistries.MOB_EFFECTS.getValue(FLIGHT_EFFECT);
        if (flight == null) {
            return;
        }
        MobEffectInstance current = player.getEffect(flight);
        if (current == null || current.getDuration() <= FLIGHT_REFRESH_THRESHOLD) {
            boolean wasFlying = player.getAbilities().flying;
            player.addEffect(new MobEffectInstance(flight, RITUAL_FLIGHT_DURATION, 0, false, false));
            // Ars Nouveau 移除效果时会把 flying 置 false，这里补回来，避免玩家掉落
            if (wasFlying && !player.getAbilities().flying) {
                player.getAbilities().flying = true;
                player.onUpdateAbilities();
            }
        }   
    }
}
