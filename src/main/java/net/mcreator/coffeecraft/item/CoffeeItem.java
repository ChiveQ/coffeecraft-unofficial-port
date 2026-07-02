package net.mcreator.coffeecraft.item;

import com.google.common.collect.Lists;
import net.mcreator.coffeecraft.block.CoffeeBlock;
import net.mcreator.coffeecraft.init.CoffeecraftModBlocks;
import net.mcreator.coffeecraft.procedures.CoffeeNetherEffectProcedure;
import net.mcreator.coffeecraft.procedures.CoffeeNetherPoseProcedure;
import net.mcreator.coffeecraft.procedures.LungoPoseProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 初、此莈咖啡各設一頪、代碼大同、實非良構、故抽象之爲一頪、用掃MCR之積弊。
 * 參攷森羅廚房FoodWithEffectsItem。
 * */
public class CoffeeItem extends Item {

    // 效果
    private final List<MobEffectInstance> effectInstances = Lists.newArrayList();

    // 凷


    // 自命稀有度
    public CoffeeItem(FoodProperties properties, Rarity rarity) {
        super(new Item.Properties().stacksTo(1).rarity(rarity).food(properties));
        properties.getEffects().forEach(effect -> {
            if (effect.getSecond() >= 1F) {
                effectInstances.add(effect.getFirst());
            }
        });
    }

    // 默認稀有度
    public CoffeeItem(FoodProperties properties){
        this(properties,Rarity.COMMON);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> tooltip,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, tooltip, flag);
        // 效果信息
        if(!effectInstances.isEmpty())
            PotionUtils.addPotionTooltip(effectInstances,tooltip,1.0F);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world,
                                              @NotNull LivingEntity entity) {
        ItemStack retval = new ItemStack(CoffeecraftModBlocks.WHITE_MUG.get());
        super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        // 此処元爲調用EffectProcedure、代之㠯此。效果今由Food代之、故獨爲聲可矣。
        playSound(world, x, y, z, entity);// 唯此有異
        if (itemstack.isEmpty()) {
            return retval;
        } else {
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(retval))
                    player.drop(retval, false);
            }
            return itemstack;
        }
    }

    // 元有此、致右毄凷不可飲
    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        if(Objects.requireNonNull(context.getPlayer()).isCrouching()){ // 潛行
            CoffeeNetherPoseProcedure.execute(context.getLevel(), context.getClickedPos().getX(),
                    context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
            return InteractionResult.SUCCESS;
        }
        else return super.useOn(context);

    }

    /**
     * 代元EffectProcedure
     * */
    public void playSound(LevelAccessor world, double x, double y, double z, Entity entity){
        if (entity == null)
            return;
        // 播放聲音
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing(x, y, z),
                        Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS
                                .getValue(new ResourceLocation("coffeecraft:drink_coffee"))),
                        SoundSource.PLAYERS, 1, 1);
            } else {
                _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS
                        .getValue(new ResourceLocation("coffeecraft:drink_coffee"))),
                        SoundSource.PLAYERS, 1, 1, false);
            }
        }
    }

}
