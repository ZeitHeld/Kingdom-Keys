
package online.kingdomkeys.kingdomkeys.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import online.kingdomkeys.kingdomkeys.datagen.init.ItemTagsGen;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

//Thank you Curios for the example!
// modified to work with the LuckyLucky effect.

public class DiscGenModifier extends LootModifier {
	//public static final Supplier<Codec<DiscGenModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            //.fieldOf("item").forGetter(m -> m.item)).apply(inst, DiscGenModifier::new)));
	public static final Supplier<Codec<DiscGenModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst)
            .apply(inst, DiscGenModifier::new)));

	/*final Item item;

	protected DiscGenModifier(LootItemCondition[] conditions, Item item) {
		super(conditions);
		this.item = item;
	}*/
	
	protected DiscGenModifier(LootItemCondition[] conditions) {
		super(conditions);
	}

	@Nonnull
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		for(LootItemCondition condition : this.conditions) {
            if(!condition.test(context)) {
                return generatedLoot;
            }
        }

		for(int i=0;i<2;i++) {
			generatedLoot.add(new ItemStack(ForgeRegistries.ITEMS.tags().getTag(ItemTagsGen.MUSIC_DISCS).getRandomElement(context.getRandom()).get()));
			if(Math.random() > 0.5)
				break;
		}
        //generatedLoot.add(new ItemStack(this.item));
		
        return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}
