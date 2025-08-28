package io.github.ryanstudioo.items;

import io.github.ryanstudioo.ModEntities;
import io.github.ryanstudioo.Ratmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item cheese;
    public static Item RAT_SPAWN_EGG;

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Ratmod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register((itemGroup) -> itemGroup.add(item));
    }

    public static void initialize() {
        cheese = register("cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder()
                .nutrition(4)
                .saturationModifier(1)
                .build()));
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, cheese);

        RAT_SPAWN_EGG = register("rat_spawn_egg", settings -> new SpawnEggItem(ModEntities.RAT, settings), new Item.Settings());
        addToItemGroup(ItemGroups.SPAWN_EGGS, RAT_SPAWN_EGG);
    }

}
