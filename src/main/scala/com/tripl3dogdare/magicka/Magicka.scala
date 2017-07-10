package com.tripl3dogdare.magicka

import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.common.config.Config
import net.minecraft.item.Item
import net.minecraft.block.Block
import net.minecraftforge.common.config.ConfigManager
import org.apache.logging.log4j.LogManager
import net.minecraftforge.fml.common.network.NetworkRegistry

@Mod(modid=Magicka.MODID, name=Magicka.NAME, version=Magicka.VERSION, modLanguage="scala")
@Mod.EventBusSubscriber
object Magicka {
  final val MODID = "magicka"
  final val NAME = "Magicka"
  final val VERSION = "Indev"

  val console = LogManager.getLogger("magicka")
	val network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID)

  @SubscribeEvent def registerItems(e:RegistryEvent.Register[Item]) = {
  }

  @SubscribeEvent def registerBlocks(e:RegistryEvent.Register[Block]) = {
  }

  @SubscribeEvent def registerModels(e:ModelRegistryEvent) = {
  }

  @SubscribeEvent def onConfigChanged(e:OnConfigChangedEvent) =
    if(e.getModID == "magicka") MagickaConfig.rebuild

}