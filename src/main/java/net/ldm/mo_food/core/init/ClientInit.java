package net.ldm.mo_food.core.init;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.ldm.mo_food.client.render.SifterBlockEntityRenderer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

import static net.ldm.mo_food.core.init.MoFood.*;

/**
 * Initializer for client-side ONLY.
 */
public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SWEET_POTATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TOMATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LETTUCE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GARLIC_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SIFTER, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(SIFTER_BLOCK_ENTITY, SifterBlockEntityRenderer::new);

        ModelPredicateProviderRegistry.register(CORN, new Identifier("bites"), (itemStack, clientWorld, livingEntity, number) -> {
            if (livingEntity == null || livingEntity.getActiveItem() != itemStack) return 0.0f;
            return itemStack.getNbt() != null ? itemStack.getNbt().getFloat("bites") : 0.0f;
        });
    }
}
