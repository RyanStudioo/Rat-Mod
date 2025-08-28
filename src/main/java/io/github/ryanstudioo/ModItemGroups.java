package io.github.ryanstudioo;

import io.github.ryanstudioo.items.ModBlocks;
import io.github.ryanstudioo.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup RatModGroup = register("ratmod");

    public static ItemGroup register(String name) {
        Identifier id = Identifier.of(Ratmod.MOD_ID, name);
        ItemGroup registry = Registry.register(Registries.ITEM_GROUP,
                id,
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModItems.cheese))
                        .displayName(Text.translatable("itemGroup.ratmod."+name))
                        .entries((context, entries) -> {
                            entries.add(ModItems.cheese);
                            entries.add(ModBlocks.CHEESE_BLOCK);
                            entries.add(ModItems.RAT_SPAWN_EGG);
                        }).build()
                );
        return registry;
    }

    public static void initialize() {
    }
}
