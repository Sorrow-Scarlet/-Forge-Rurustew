package SorrowIDT.rurustew.item;

import SorrowIDT.rurustew.Rurustew;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems extends Foods {
    public static final DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS,
            Rurustew.MODID);//第一个参数是注册的物品的类型，第二个是MODID
    //开始注册物品（向注册表中注册物品）

    //第一个参数数物品的name，对应于语言文件中的name值,贴图的名字要和这个name值一致，且贴图要放在指定位置
    public static final RegistryObject<Item> RAW_PLAYER_MEAT=ITEMS.register("raw_player_meat",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COOKED_PLAYER_MEAT=ITEMS.register("cooked_player_meat",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> KNIFE =ITEMS.register("knife",
            ()->new Item(new Item.Properties()));




    //对外暴露的接口，在主类中将注册表添加到事件总线上
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
