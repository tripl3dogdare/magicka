package com.tripl3dogdare.magicka;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;

@Config(modid="magicka")
public class MagickaConfig {
	// TODO: Move to Scala code with Minecraft Forge PR #4073
	// https://github.com/MinecraftForge/MinecraftForge/pull/4073

	public static void rebuild() {
	    ConfigManager.sync("wrenchitw", Config.Type.INSTANCE);
	}
}
