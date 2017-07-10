package com.tripl3dogdare.magicka.z_utils

import java.util.UUID

import scala.collection.JavaConversions.asScalaSet

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTException
import net.minecraft.nbt.NBTTagByte
import net.minecraft.nbt.NBTTagByteArray
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagDouble
import net.minecraft.nbt.NBTTagFloat
import net.minecraft.nbt.NBTTagInt
import net.minecraft.nbt.NBTTagIntArray
import net.minecraft.nbt.NBTTagLong
import net.minecraft.nbt.NBTTagShort
import net.minecraft.nbt.NBTTagString
import java.util.concurrent.Callable

object ImplicitHelpers {
	implicit def func2callable[T](f:() => T):Callable[T] = new Callable[T] { def call = f() }
	implicit def func2runnable(f:() => Unit):Runnable = new Runnable { def run = f() }

	implicit def map2nbtcomp(m:Map[String,Any]):NBTTagCompound = {
		val nbt = new NBTTagCompound
		m.keys foreach { (key) => m.get(key).get match {
			case v:NBTBase => nbt.setTag(key, v)
			case v:Byte => nbt.setByte(key, v)
			case v:Short => nbt.setShort(key, v)
			case v:Int => nbt.setInteger(key, v)
			case v:Long => nbt.setLong(key, v)
			case v:UUID => nbt.setUniqueId(key, v)
			case v:Float => nbt.setFloat(key, v)
			case v:Double => nbt.setDouble(key, v)
			case v:String => nbt.setString(key, v)
			case v:Array[Byte] => nbt.setByteArray(key, v)
			case v:Array[Int] => nbt.setIntArray(key, v)
			case v:Boolean => nbt.setBoolean(key, v)
			case v => throw new NBTException(s"Cannot serialize $v to NBT", "{}", 0)
		}}
		nbt
	}

	implicit def nbtcomp2map(nbt:NBTTagCompound):Map[String,Any] = {
		var map = Map[String,Any]()
		nbt.getKeySet foreach { (key) => nbt.getTag(key) match {
			case v:NBTTagByte => map = map+(key -> v.getByte)
			case v:NBTTagShort => map = map+(key -> v.getShort)
			case v:NBTTagInt => map = map+(key -> v.getInt)
			case v:NBTTagLong => map = map+(key -> v.getLong)
			case v:NBTTagFloat => map = map+(key -> v.getFloat)
			case v:NBTTagDouble => map = map+(key -> v.getDouble)
			case v:NBTTagString => map = map+(key -> v.getString)
			case v:NBTTagByteArray => map = map+(key -> v.getByteArray)
			case v:NBTTagIntArray => map = map+(key -> v.getIntArray)
			case v => map = map+(key -> v)
		}}
		map
	}
}