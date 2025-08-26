package name.modid;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item cheese = register("cheese", Item::new, new Item.Settings().food(
            new FoodComponent.Builder().nutrition(4).saturationModifier(2).build()));



    public static void itemGroup(RegistryKey <ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register((itemGroup) -> itemGroup.add(item));
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Ratmod.MOD_ID, name));


        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        Item test = register("test", Item::new, new Item.Settings().food(
                new FoodComponent.Builder().nutrition(4).saturationModifier(2).build()));
        itemGroup(ItemGroups.FOOD_AND_DRINK, cheese);
        itemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.CHEESE_BLOCK.asItem());



    }

}
