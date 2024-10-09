package SorrowIDT.rurustew.item;

import SorrowIDT.rurustew.Rurustew;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class RurustewTab {
    public CreativeModeTab output()
    {
        return CreativeModeTab.builder().title(Component.translatable("")).build();
    }


}
