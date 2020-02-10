package online.kingdomkeys.kingdomkeys.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLPlayMessages;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.client.render.BlastBloxRenderer;
import online.kingdomkeys.kingdomkeys.proxy.ProxyClient;

public class ModEntities {

    private static List<EntityType> ENTITIES = new ArrayList<>();

    public static EntityType<BlastBloxEntity> TYPE_BLAST_BLOX = createEntityType(BlastBloxEntity::new, BlastBloxEntity::new, EntityClassification.MISC,"blast_blox_primed", 0.98F, 0.98F);
   // public static EntityType<EntityShadow> TYPE_HEARTLESS_SHADOW = createEntityType(EntityShadow.class, EntityShadow::new, "shadow");

    /**
     * Helper method to create a new EntityType and set the registry name
     * @param factory The entity type factory
     * @param clientFactory The client factory
     * @param classification The classification of the entity
     * @param name The registry name of the entity
     * @param sizeX The X size of the entity
     * @param sizeY The Y size of the entity
     * @param <T> The entity type
     * @return The EntityType created
     */
    public static <T extends Entity>EntityType<T> createEntityType(EntityType.IFactory<T> factory, BiFunction<FMLPlayMessages.SpawnEntity, World, T> clientFactory, EntityClassification classification, String name, float sizeX, float sizeY) {
        EntityType<T> type = EntityType.Builder.create(factory, classification)
                .setCustomClientFactory(clientFactory)
                .setShouldReceiveVelocityUpdates(true)
                .setUpdateInterval(1)
                .setTrackingRange(128)
                .size(sizeX, sizeY)
                .build(name);
        type.setRegistryName(KingdomKeys.MODID, name);
        ENTITIES.add(type);
        return type;
    }

    /**
     * Register the render classes for the entities, called in {@link ProxyClient#registerModels(ModelRegistryEvent)}  }
     */
    public static void registerModels() {
        RenderingRegistry.registerEntityRenderingHandler(TYPE_BLAST_BLOX, BlastBloxRenderer.FACTORY);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registry {

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            ENTITIES.forEach((entityType)->event.getRegistry().register(entityType));
        }

    }

}
