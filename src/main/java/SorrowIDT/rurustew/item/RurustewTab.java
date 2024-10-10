package SorrowIDT.rurustew.item;


import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static SorrowIDT.rurustew.Rurustew.*;

public class RurustewTab {
    public CreativeModeTab output()
    {
        return CreativeModeTab.builder().title(Component.translatable("item.Group.rurustew_tab/group"))
                .icon(() -> new ItemStack(knife.get()))
                .displayItems((parameters, output) -> {
                    output.accept(knife.get());
                    output.accept(rawPlayerMeat.get());
                    output.accept(cookedPlayerMeat.get());

                })
                .build();
    }


}
