package com.mozz.cheesepower.init;

import com.mozz.cheesepower.CheesePower;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(CheesePower.MOD_ID)
@Mod.EventBusSubscriber(modid = CheesePower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    public static final Block cauldron_pot = null;

    @SubscribeEvent
    public static void registerBlock(final RegistryEvent.Register<Block> event) {
        event.getRegistry()
                .register(new Block(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(2.0F)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL).notSolid())
                    .setRegistryName("cauldron_pot"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry()
                .register(new BlockItem(cauldron_pot, new Item.Properties().group(CheesePower.CheeseItemGroup.instance).maxStackSize(1))
                        .setRegistryName("cauldron_pot"));
    }
}
