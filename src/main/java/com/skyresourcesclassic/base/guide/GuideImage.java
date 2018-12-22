package com.skyresourcesclassic.base.guide;

import net.minecraft.util.ResourceLocation;

public class GuideImage {
    public ResourceLocation imgLocation;

    protected GuideImage(String imgAddress) {
        imgLocation = new ResourceLocation(imgAddress);
    }
}
