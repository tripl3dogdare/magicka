package com.tripl3dogdare.magicka.z_utils

import net.minecraft.client.renderer.RenderHelper
import net.minecraft.entity.EntityLivingBase
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.OpenGlHelper

object RenderUtils {

	def drawEntityOnScreen(posX:Int, posY:Int, scale:Int, mouseX:Float, mouseY:Float, ent:EntityLivingBase) {
		GlStateManager.enableColorMaterial
		GlStateManager.pushMatrix
		GlStateManager.translate(posX, posY, 50.0F)
		GlStateManager.scale(-scale, scale, scale)
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F)
		val f = ent.renderYawOffset
		val f1 = ent.rotationYaw
		val f2 = ent.rotationPitch
		val f3 = ent.prevRotationYawHead
		val f4 = ent.rotationYawHead
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F)
		RenderHelper.enableStandardItemLighting
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F)
		GlStateManager.rotate(-(Math.atan(mouseY / 40.0F).toFloat) * 20.0F, 1.0F, 0.0F, 0.0F)
		ent.renderYawOffset = Math.atan(mouseX / 40.0F).toFloat * 20.0F
		ent.rotationYaw = Math.atan(mouseX / 40.0F).toFloat * 40.0F
		ent.rotationPitch = -(Math.atan(mouseY / 40.0F).toFloat) * 20.0F
		ent.rotationYawHead = ent.rotationYaw
		ent.prevRotationYawHead = ent.rotationYaw
		GlStateManager.translate(0.0F, 0.0F, 0.0F)
		val rendermanager = Minecraft.getMinecraft.getRenderManager
		rendermanager.setPlayerViewY(180.0F)
		rendermanager.setRenderShadow(false)
		rendermanager.doRenderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false)
		rendermanager.setRenderShadow(true)
		ent.renderYawOffset = f
		ent.rotationYaw = f1
		ent.rotationPitch = f2
		ent.prevRotationYawHead = f3
		ent.rotationYawHead = f4
		GlStateManager.popMatrix
		RenderHelper.disableStandardItemLighting
		GlStateManager.disableRescaleNormal
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit)
		GlStateManager.disableTexture2D
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit)
	}

}