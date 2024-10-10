package SorrowIDT.rurustew.item;



import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class knife extends Item {


    public knife(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResult interactLivingEntity(LivingEntity p_42956_,UseOnContext p_186371_) {
        Level level = p_186371_.getLevel();
        Player player = p_186371_.getPlayer();
            if (player != null && (p_42956_ instanceof Player)) {
                player.attack(p_42956_);
                //player.addItem(new ItemStack();
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
