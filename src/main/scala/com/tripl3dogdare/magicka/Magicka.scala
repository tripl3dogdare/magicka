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
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import net.minecraft.init.Enchantments

@Mod(modid=Magicka.MODID, name=Magicka.NAME, version=Magicka.VERSION, modLanguage="scala")
@Mod.EventBusSubscriber
object Magicka {
  final val MODID = "magicka"
  final val NAME = "Magicka"
  final val VERSION = "Indev"

  val console = LogManager.getLogger(MODID)
	val network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID)

  @SubscribeEvent def registerItems(e:RegistryEvent.Register[Item]) = Items.register(e)
  @SubscribeEvent def registerBlocks(e:RegistryEvent.Register[Block]) = Blocks.register(e)
  @SubscribeEvent def registerModels(e:ModelRegistryEvent) = Models.register(e)

  object Items {
    def register(e:RegistryEvent.Register[Item]) {}
  }

  object Blocks {
    def register(e:RegistryEvent.Register[Block]) {}
  }

  object Models {
    def register(e:ModelRegistryEvent) {}
  }

	val tabMain = new CreativeTabs("magicka") {
    override def getTabIconItem = {
      val stack = new ItemStack(net.minecraft.init.Items.ENCHANTED_BOOK)
      stack.addEnchantment(Enchantments.SMITE, 0)
      stack
    }
  }

  @SubscribeEvent def onConfigChanged(e:OnConfigChangedEvent) =
    if(e.getModID == "magicka") MagickaConfig.rebuild

}