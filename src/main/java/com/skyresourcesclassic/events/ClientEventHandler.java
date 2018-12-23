package com.skyresourcesclassic.events;

import com.skyresourcesclassic.ConfigOptions;
import com.skyresourcesclassic.InfoToast;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class ClientEventHandler {
    @SubscribeEvent
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.player.world.isRemote) {
            EntityPlayer player = event.player;
            if (ConfigOptions.guide.allowGuide
                    && Minecraft.getMinecraft().player != null
                    && Minecraft.getMinecraft().player.getGameProfile().getId().equals(player.getGameProfile().getId())
                    && player.ticksExisted > 100 && player.ticksExisted < 150
                    && Minecraft.getMinecraft().getToastGui().getToast(InfoToast.class, InfoToast.Type.Info) == null) {
                Minecraft.getMinecraft().getToastGui().add(new InfoToast(new TextComponentString("Sky Resources Guide"),
                        new TextComponentString("Press " + TextFormatting.AQUA + "Open Guide Key (G)"), 5000));
            }
        }
    }
}
