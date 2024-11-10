package mod.maxbogomol.purrfect.common.event;

import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    @SubscribeEvent
    public void onEntityJump(LivingEvent.LivingJumpEvent event) {
        CollarItem.playerJump(event);
    }
}
