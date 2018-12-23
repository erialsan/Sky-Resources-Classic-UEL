package com.skyresourcesclassic.proxy;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.base.ModKeyBindings;
import com.skyresourcesclassic.events.ClientEventHandler;
import com.skyresourcesclassic.plugin.ModPlugins;
import com.skyresourcesclassic.registry.ModRenderers;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        OBJLoader.INSTANCE.addDomain(References.ModID);

        ModRenderers.preInit();


        ModPlugins.initRenderers();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        new ModKeyBindings();
        super.init(e);
        ModRenderers.init();
    }
}
