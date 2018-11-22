package com.skyresourcesclassic.plugin.theoneprobe;

import com.skyresourcesclassic.plugin.IModPlugin;

import net.minecraftforge.fml.common.event.FMLInterModComms;

public class TOPPlugin implements IModPlugin
{

	public void preInit()
	{
		FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe",
				"com.skyresourcesclassic.plugin.theoneprobe.GetTOP");
	}

	public void init()
	{
	}

	public void initRenderers()
	{

	}

	public void postInit()
	{

	}
}
