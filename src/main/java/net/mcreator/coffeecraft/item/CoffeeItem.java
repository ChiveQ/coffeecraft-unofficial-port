package net.mcreator.coffeecraft.item;

import com.google.common.collect.Lists;
import net.mcreator.coffeecraft.block.CoffeeBlock;
import net.mcreator.coffeecraft.init.CoffeecraftModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

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
    private final RegistryObject<Block> placedBlock;

    // 自命稀有度
    private CoffeeItem(FoodProperties properties, Rarity rarity,RegistryObject<Block> block) {
        super(new Item.Properties().stacksTo(1).rarity(rarity).food(properties));
        placedBlock = block;
        properties.getEffects().forEach(effect -> {
            if (effect.getSecond() >= 1F) {
                effectInstances.add(effect.getFirst());
            }
        });
    }

    // 工廠函數
    public static CoffeeItem create(FoodProperties properties,Rarity rarity,RegistryObject<Block> block){
        return new CoffeeItem(properties, rarity, block);
    }

    // 默認稀有度
    public static CoffeeItem create(FoodProperties properties, RegistryObject<Block> block){
        return new CoffeeItem(properties, Rarity.COMMON, block);
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

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        if(Objects.requireNonNull(context.getPlayer()).isCrouching()){ // 潛行
            placeBlock(context.getLevel(), context.getClickedPos().getX(),
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

    /**
     * 代元PoseProcedure
     * */
    public void placeBlock(LevelAccessor world, double x, double y, double z, Entity entity){
        if (entity == null)
            return;
        if (entity.isShiftKeyDown()) {
            if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
                world.setBlock(BlockPos.containing(x, y + 1, z), placedBlock.get().defaultBlockState(), 3);
                {
                    Direction _dir = (entity.getDirection());
                    BlockPos _pos = BlockPos.containing(x, y + 1, z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                        world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                    } else {
                        _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                        if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                            world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                    }
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.decorated_pot.place"))), SoundSource.BLOCKS, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.decorated_pot.place"))), SoundSource.BLOCKS, 1, 1, false);
                    }
                }
                if (entity instanceof Player _player) {
                    ItemStack _stktoremove = _player.getMainHandItem();
                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                }
            }
        }
    }

}
