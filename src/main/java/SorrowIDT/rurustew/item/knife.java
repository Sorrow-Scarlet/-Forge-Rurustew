package SorrowIDT.rurustew.item;


import SorrowIDT.rurustew.Rurustew;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class knife extends Item {
    public knife(Properties p_42952_) {
        super(p_42952_);
    }



    public InteractionResult interactLivingEntity(ItemStack p_42954_, Player p_42955_, LivingEntity p_42956_, InteractionHand p_42957_) {
        if ((p_42956_ instanceof Player) ||(p_42956_ instanceof Villager)
                || (p_42956_ instanceof Pillager)||(p_42956_ instanceof Evoker)
                ||(p_42956_ instanceof Vindicator)||(p_42956_ instanceof Witch)) {
            if (!p_42955_.level().isClientSide && p_42956_.isAlive()) {
                //Player 对 LivingEntity 造成10点生命的伤害;
                p_42956_.hurt(p_42955_.damageSources().magic(),10);
                //将 LivingEntity 的肉添加到 Player 的物品栏中
                p_42955_.addItem(new ItemStack(Rurustew.rawPlayerMeat.get(),1));
                return InteractionResult.sidedSuccess(p_42955_.level().isClientSide);
            }

        }
        if((p_42956_ instanceof Zombie) ||(p_42956_ instanceof Drowned)||(p_42956_ instanceof ZombieVillager)){
            //Player 对 LivingEntity 造成10点生命的伤害;
            p_42956_.hurt(p_42955_.damageSources().magic(),5);
            //将 LivingEntity 的肉添加到 Player 的物品栏中
            p_42955_.addItem(new ItemStack(Items.ROTTEN_FLESH,2));
            return InteractionResult.sidedSuccess(p_42955_.level().isClientSide);
        }
        if((p_42956_ instanceof Skeleton ||(p_42956_ instanceof Stray))){
            //Player 对 LivingEntity 造成10点生命的伤害;
            p_42956_.hurt(p_42955_.damageSources().magic(),10);
            //将 LivingEntity 的肉添加到 Player 的物品栏中
            p_42955_.addItem(new ItemStack(Items.BONE,5));
            return InteractionResult.sidedSuccess(p_42955_.level().isClientSide);
        }

        else {
            return InteractionResult.PASS;
        }
    }


}
