package com.skyresourcesclassic.base;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ModKeyBindings {
    public static KeyBinding guideKey;

    public ModKeyBindings() {
        guideKey = new KeyBinding("key.skyresourcesclassic.guide", Keyboard.KEY_G, "Sky Resources");
        ClientRegistry.registerKeyBinding(guideKey);
    }
}
