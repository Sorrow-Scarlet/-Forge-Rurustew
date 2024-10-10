package SorrowIDT.rurustew.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class cookedPlayerMeat extends Foods {
    public static final FoodProperties cookedplayermeat = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).meat().build();
}
