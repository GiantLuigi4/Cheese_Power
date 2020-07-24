package com.mozz.cheesepower.init;

import com.mozz.cheesepower.CheesePower;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import com.mozz.cheesepower.CheesePower.CheeseItemGroup;

@Mod.EventBusSubscriber(modid = CheesePower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(CheesePower.MOD_ID)
public class ItemInit {

    public static final Item sheep_cheese = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(CheeseItemGroup.instance).food(new Food.Builder().hunger(8).saturation(6f).meat().build())).setRegistryName("sheep_cheese"));
    }
}
