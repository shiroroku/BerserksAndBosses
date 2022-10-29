package crimsonspade.berserksandbosses.Entity;

import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.Path;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BerserkStrider extends Strider {
    public int suriveTime = 0;

    public BerserkStrider(EntityType<? extends BerserkStrider> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    @Override
    public void tick() {
        super.tick();
        suriveTime ++;
        if (suriveTime >= 96000){
            var entity = new MaliceSoulflame(EntityRegistry.MALICE_SOULFLAME.get(), this.level);
            entity.setPos(this.position());
            this.level.addFreshEntity(entity);
            entity.die();
            this.kill();
        }
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, Entity::isInWater));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 3, 16));
        this.goalSelector.addGoal(2, new KidnapGoal(this, () -> this.navigation.createPath(findBottomLava(this.blockPosition()), 1)));
    }

    BlockPos findBottomLava(BlockPos pos){
        if(this.level.getBlockState(pos) == Blocks.LAVA.defaultBlockState()){
            if(findBottomLava(pos.below()) != null){
                return findBottomLava(pos.below());
            } else if (this.level.getBlockState(pos.north()) == Blocks.LAVA.defaultBlockState()){
                return findBottomLava(pos.north().below());
            } else if (this.level.getBlockState(pos.east()) == Blocks.LAVA.defaultBlockState()){
                return findBottomLava(pos.east().below());
            } else if (this.level.getBlockState(pos.south()) == Blocks.LAVA.defaultBlockState()){
                return findBottomLava(pos.south().below());
            } else if (this.level.getBlockState(pos.west()) == Blocks.LAVA.defaultBlockState()){
                return findBottomLava(pos.west().below());
            } else {
                return pos;
            }
        } return pos;
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 25D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D).build();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_149158_) {
        super.addAdditionalSaveData(p_149158_);
        p_149158_.putInt("surviveTime", this.suriveTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_149145_) {
        super.readAdditionalSaveData(p_149145_);
        this.suriveTime = p_149145_.getInt("surviveTime");
    }
}
