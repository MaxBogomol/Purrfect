package mod.maxbogomol.purrfect.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.maxbogomol.purrfect.common.item.equipment.SillyTagItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.util.LazyOptional;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.List;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public PlayerRendererMixin(EntityRendererProvider.Context context, PlayerModel<AbstractClientPlayer> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V"), method = "Lnet/minecraft/client/renderer/entity/player/PlayerRenderer;renderNameTag(Lnet/minecraft/client/player/AbstractClientPlayer;Lnet/minecraft/network/chat/Component;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V")
    private void purrfect$renderNameTag(AbstractClientPlayer entity, Component displayName, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci) {
        PlayerRenderer self = (PlayerRenderer) ((Object) this);
        LazyOptional<ICuriosItemHandler> curiosItemHandler = CuriosApi.getCuriosInventory(entity);
        if (curiosItemHandler.isPresent() && curiosItemHandler.resolve().isPresent()) {
            List<SlotResult> curioSlots = curiosItemHandler.resolve().get().findCurios(CollarItem::hasTag);
            poseStack.translate(0, 0.6f, 0);
            for (SlotResult slot : curioSlots) {
                Component component = Component.empty();
                if (!CollarItem.getCustomTag(slot.stack()).isEmpty()) {
                    component = Component.literal(CollarItem.getCustomTag(slot.stack())).withStyle(ChatFormatting.ITALIC);
                }
                if (!CollarItem.getTag(slot.stack()).isEmpty()) {
                    component = Component.translatable(SillyTagItem.getTranslatedTag(CollarItem.getTag(slot.stack())));
                }
                poseStack.translate(0, 0.2f, 0);
                poseStack.pushPose();
                poseStack.scale(0.75f, 0.75f, 0.75f);
                super.renderNameTag(entity, component, poseStack, buffer, packedLight);
                poseStack.popPose();
            }
        }
    }
}
