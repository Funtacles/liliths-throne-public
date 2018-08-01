package com.lilithsthrone.game.inventory.weapon;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.attributes.Attribute;
import com.lilithsthrone.game.combat.DamageType;
import com.lilithsthrone.game.combat.DamageVariance;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.ItemTag;
import com.lilithsthrone.game.inventory.Rarity;
import com.lilithsthrone.utils.ColourListPresets;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;

/**
 * @since 0.1.84
 * @version 0.2.6
 * @author Innoxia
 */
public class WeaponType {
	
	public static AbstractWeaponType MELEE_CHAOS_RARE = new AbstractWeaponType(1000,
			true,
			"an",
			"it",
			false,
			"opaque demonstone",
			"opaque demonstones",
			"Crystal Strike",
			"A common type of demonstone, the power of which can be harnessed as a weapon."
					+ " Demonstones are rumoured to be crystallised essences of a Lilin's orgasm.",
			InventorySlot.WEAPON_MAIN,
			"meleeCrystal1",
			Rarity.RARE,
			Util.newArrayListOfValues(
					DamageType.PHYSICAL,
					DamageType.FIRE,
					DamageType.ICE,
					DamageType.POISON),
			8,
			0,
			DamageVariance.MEDIUM,
			null,
			null,
			null,
			null,
			null,
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)) {
		
		private static final long serialVersionUID = 1L;
				
		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy in the crystal."
					+ " As [npc.she] [npc.does] so, it dissolves and flows into [npc.her] body, granting [npc.herHim] the ability to perform magical attacks.");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy inside of [npc.herHim], forcing it out from [npc.her] body."
					+ " As [npc.she] [npc.does] so, it reforms back into a demonstone.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return genericMeleeAttackDescription(character, target, isHit);
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Strike at [npc.name] in melee, using your crystal's power to inflict extra damage!");
		}
		
		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_FIRE, 5));
				case ICE:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_ICE, 5));
				case LUST:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_PHYSICAL, 5));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_PHYSICAL, 5));
				case POISON:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_POISON, 5));
			}
			return null;
		}
	};
	
	public static AbstractWeaponType MELEE_CHAOS_EPIC = new AbstractWeaponType(1500,
			true,
			"a",
			"it",
			false,
			"misty demonstone",
			"misty demonstones",
			"Crystal Strike",
			"A powerful demonstone, the power of which can be harnessed as a weapon."
					+ " Demonstones are rumoured to be crystallised essences of a Lilin's orgasm.",
			InventorySlot.WEAPON_MAIN,
			"meleeCrystal2",
			Rarity.EPIC,
			Util.newArrayListOfValues(
					DamageType.PHYSICAL,
					DamageType.FIRE,
					DamageType.ICE,
					DamageType.POISON),
			12,
			0,
			DamageVariance.MEDIUM,
			null,
			null,
			null,
			null,
			null,
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)) {

		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy in the crystal."
					+ " As [npc.she] [npc.does] so, it dissolves and flows into [npc.her] body, granting [npc.herHim] the ability to perform magical attacks.");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy inside of [npc.herHim], forcing it out from [npc.her] body."
					+ " As [npc.she] [npc.does] so, it reforms back into a demonstone.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return genericMeleeAttackDescription(character, target, isHit);
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Strike at [npc.name] in melee, using your crystal's power to inflict extra damage!");
		}

		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_FIRE, 10));
				case ICE:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_ICE, 10));
				case LUST:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_PHYSICAL, 10));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_PHYSICAL, 10));
				case POISON:
					return Util.newHashMapOfValues(new Value<>(Attribute.DAMAGE_POISON, 10));
			}
			return null;
		}
	};
	
	public static AbstractWeaponType MELEE_CHAOS_LEGENDARY = new AbstractWeaponType(2500,
			true,
			"a",
			"it",
			false,
			"clear demonstone",
			"clear demonstones",
			"Crystal Strike",
			"An extremely powerful demonstone, the power of which can be harnessed as a weapon."
					+ " Demonstones are rumoured to be crystallised essences of a Lilin's orgasm.",
			InventorySlot.WEAPON_MAIN,
			"meleeCrystal3",
			Rarity.LEGENDARY,
			Util.newArrayListOfValues(
					DamageType.PHYSICAL,
					DamageType.FIRE,
					DamageType.ICE,
					DamageType.POISON),
			16,
			0,
			DamageVariance.LOW,
			null,
			null,
			null,
			null,
			null,
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)){

		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy in the crystal."
					+ " As [npc.she] [npc.does] so, it dissolves and flows into [npc.her] body, granting [npc.herHim] the ability to perform magical attacks.");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy inside of [npc.herHim], forcing it out from [npc.her] body."
					+ " As [npc.she] [npc.does] so, it reforms back into a demonstone.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return genericMeleeAttackDescription(character, target, isHit);
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Strike at [npc.name] in melee, using your crystal's power to inflict extra damage!");
		}

		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_FIRE, 10),
							new Value<>(Attribute.RESISTANCE_FIRE, 5));
				case ICE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_ICE, 10),
							new Value<>(Attribute.RESISTANCE_ICE, 5));
				case LUST:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_PHYSICAL, 10),
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 5));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_PHYSICAL, 10),
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 5));
				case POISON:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_POISON, 10),
							new Value<>(Attribute.RESISTANCE_POISON, 5));
			}
			return null;
		}
	};
	
	public static AbstractWeaponType MELEE_ZWEIHANDER = new AbstractWeaponType(5000,
			true,
			"a",
			"it",
			false,
			"Zweih&auml;nder",
			"Zweih&auml;nders",
			"Slash",
			"As its name of 'Zweih&auml;nder' (two-hander) suggests, this sword is so large that it requires two hands to wield correctly."
					+ " The blade is made out of ethereal arcane energy, which, instead of cutting someone, drains their energy as it passes through them.",
			InventorySlot.WEAPON_MAIN,
			"zweihander",
			Rarity.EPIC,
			Util.newArrayListOfValues(
					DamageType.PHYSICAL,
					DamageType.FIRE,
					DamageType.ICE,
					DamageType.POISON),
			20,
			0,
			DamageVariance.MEDIUM,
			null,
			ColourListPresets.JUST_BLACK.getPresetColourList(),
			ColourListPresets.ALL.getPresetColourList(),
			ColourListPresets.JUST_STEEL.getPresetColourList(),
			ColourListPresets.ALL_METAL.getPresetColourList(),
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)) {

		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(ready)] [npc.her] "+this.getName()+".");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(put)] [npc.her] "+this.getName()+" away.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return getDescriptions(character, target, isHit,
					UtilText.returnStringAtRandom(
							"You slash your "+this.getName()+" at [npc.name], grinning as the ethereal arcane blade travels through [npc.her] body!",
							"Slashing out at [npc.name] with your "+this.getName()+", you grin as you see the ethereal blade travel straight through [npc.her] body!",
							"You slash at [npc.name] with your "+this.getName()+", causing [npc.herHim] to stagger back as the ethereal blade passes right through [npc.her] chest!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at you, grinning as the ethereal arcane blade travels through your body!",
							"Slashing out at you with [npc.her] "+this.getName()+", [npc.name] grins as [npc.she] sees the ethereal blade travel straight through your body!",
							"[npc.Name] slashes at you with [npc.her] "+this.getName()+", causing you to stagger back as the ethereal blade passes right through your chest!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at [npc2.name], grinning as the ethereal arcane blade travels through [npc2.her] body!",
							"Slashing out at [npc2.name] with [npc.her] "+this.getName()+", [npc.name] grins as [npc.she] sees the ethereal blade travel straight through [npc2.her] body!",
							"[npc.Name] slashes at [npc2.name] with [npc.her] "+this.getName()+", causing [npc2.herHim] to stagger back as the ethereal blade passes right through [npc2.her] chest!"),
					UtilText.returnStringAtRandom(
							"You slash your "+this.getName()+" at [npc.name], but the blade sails harmlessly through mid-air as you miss your target!",
							"Slashing out at [npc.name] with your "+this.getName()+", you sigh in frustration as you end up missing your target!",
							"You slash at [npc.name] with your "+this.getName()+", but fail to land a hit!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at you, but the blade sails harmlessly through mid-air as [npc.she] misses you!",
							"Slashing out at you with [npc.her] "+this.getName()+", [npc.name] sighs in frustration as [npc.she] ends up missing you!",
							"[npc.Name] slashes at you with [npc.her] "+this.getName()+", but fails to land a hit!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at [npc2.name], but the blade sails harmlessly through mid-air as [npc.she] misses [npc2.herHim]!",
							"Slashing out at [npc2.name] with [npc.her] "+this.getName()+", [npc.name] sighs in frustration as [npc.she] ends up missing [npc2.herHim]!",
							"[npc.Name] slashes at [npc2.name] with [npc.her] "+this.getName()+", but fails to land a hit!"));
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Strike at [npc.name] with your zweihander!");
		}

		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_FIRE, 5),
							new Value<>(Attribute.DAMAGE_MELEE_WEAPON, 15));
				case ICE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_ICE, 5),
							new Value<>(Attribute.DAMAGE_MELEE_WEAPON, 15));
				case LUST:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_PHYSICAL, 5),
							new Value<>(Attribute.DAMAGE_MELEE_WEAPON, 15));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_PHYSICAL, 5),
							new Value<>(Attribute.DAMAGE_MELEE_WEAPON, 15));
				case POISON:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_POISON, 5),
							new Value<>(Attribute.DAMAGE_MELEE_WEAPON, 15));
			}
			return null;
		}
	};
	
	public static AbstractWeaponType MELEE_KNIGHTLY_SWORD = new AbstractWeaponType(2500,
			true,
			"a",
			"it",
			false,
			"Knightly Sword",
			"Knightly Swords",
			"Slash",
			"This straight-edged sword has a single-handed cruciform hilt."
					+ " The 75cm-long blade is made out of ethereal arcane energy, which, instead of cutting someone, drains their energy as it passes through them.",
			InventorySlot.WEAPON_MAIN,
			"knightlySword",
			Rarity.EPIC,
			Util.newArrayListOfValues(
					DamageType.PHYSICAL,
					DamageType.FIRE,
					DamageType.ICE,
					DamageType.POISON),
			18,
			0,
			DamageVariance.LOW,
			null,
			ColourListPresets.JUST_BLACK.getPresetColourList(),
			ColourListPresets.ALL.getPresetColourList(),
			ColourListPresets.JUST_STEEL.getPresetColourList(),
			ColourListPresets.ALL_METAL.getPresetColourList(),
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)) {

		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(ready)] [npc.her] "+this.getName()+".");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(put)] [npc.her] "+this.getName()+" away.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return getDescriptions(character, target, isHit,
					UtilText.returnStringAtRandom(
							"You slash your "+this.getName()+" at [npc.name], grinning as the ethereal arcane blade travels through [npc.her] body!",
							"Slashing out at [npc.name] with your "+this.getName()+", you grin as you see the ethereal blade travel straight through [npc.her] body!",
							"You slash at [npc.name] with your "+this.getName()+", causing [npc.herHim] to stagger back as the ethereal blade passes right through [npc.her] chest!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at you, grinning as the ethereal arcane blade travels through your body!",
							"Slashing out at you with [npc.her] "+this.getName()+", [npc.name] grins as [npc.she] sees the ethereal blade travel straight through your body!",
							"[npc.Name] slashes at you with [npc.her] "+this.getName()+", causing you to stagger back as the ethereal blade passes right through your chest!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at [npc2.name], grinning as the ethereal arcane blade travels through [npc2.her] body!",
							"Slashing out at [npc2.name] with [npc.her] "+this.getName()+", [npc.name] grins as [npc.she] sees the ethereal blade travel straight through [npc2.her] body!",
							"[npc.Name] slashes at [npc2.name] with [npc.her] "+this.getName()+", causing [npc2.herHim] to stagger back as the ethereal blade passes right through [npc2.her] chest!"),
					UtilText.returnStringAtRandom(
							"You slash your "+this.getName()+" at [npc.name], but the blade sails harmlessly through mid-air as you miss your target!",
							"Slashing out at [npc.name] with your "+this.getName()+", you sigh in frustration as you end up missing your target!",
							"You slash at [npc.name] with your "+this.getName()+", but fail to land a hit!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at you, but the blade sails harmlessly through mid-air as [npc.she] misses you!",
							"Slashing out at you with [npc.her] "+this.getName()+", [npc.name] sighs in frustration as [npc.she] ends up missing you!",
							"[npc.Name] slashes at you with [npc.her] "+this.getName()+", but fails to land a hit!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] slashes [npc.her] "+this.getName()+" at [npc2.name], but the blade sails harmlessly through mid-air as [npc.she] misses [npc2.herHim]!",
							"Slashing out at [npc2.name] with [npc.her] "+this.getName()+", [npc.name] sighs in frustration as [npc.she] ends up missing [npc2.herHim]!",
							"[npc.Name] slashes at [npc2.name] with [npc.her] "+this.getName()+", but fails to land a hit!"));
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Strike at [npc.name] with your "+this.getName()+"!");
		}

		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_FIRE, 5),
							new Value<>(Attribute.CRITICAL_CHANCE, 5));
				case ICE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_ICE, 5),
							new Value<>(Attribute.CRITICAL_CHANCE, 5));
				case LUST:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_PHYSICAL, 5),
							new Value<>(Attribute.CRITICAL_CHANCE, 5));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_PHYSICAL, 5),
							new Value<>(Attribute.CRITICAL_CHANCE, 5));
				case POISON:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.DAMAGE_POISON, 5),
							new Value<>(Attribute.CRITICAL_CHANCE, 5));
			}
			return null;
		}
	};
	
	public static AbstractWeaponType OFFHAND_BUCKLER = new AbstractWeaponType(1000,
			true,
			"a",
			"it",
			false,
			"Buckler",
			"Bucklers",
			"Bash",
			"A small metal shield, measuring 45cm in diameter, and gripped in one hand by means of a handle positioned behind the boss."
					+ " Shields such as this one are typically enchanted to help the wielder resist a certain type of arcane damage.",
			InventorySlot.WEAPON_OFFHAND,
			"buckler",
			Rarity.EPIC,
			Util.newArrayListOfValues(
					DamageType.FIRE,
					DamageType.ICE,
					DamageType.POISON),
			6,
			0,
			DamageVariance.HIGH,
			null,
			ColourListPresets.JUST_STEEL.getPresetColourList(),
			ColourListPresets.ALL_METAL.getPresetColourList(),
			ColourListPresets.JUST_STEEL.getPresetColourList(),
			ColourListPresets.ALL_METAL.getPresetColourList(),
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)) {

		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(ready)] [npc.her] "+this.getName()+".");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(put)] [npc.her] "+this.getName()+" away.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return getDescriptions(character, target, isHit,
					UtilText.returnStringAtRandom(
							"You bash your "+this.getName()+" at [npc.name], grinning as you end up whacking [npc.herHim] right on the [npc.arm]!",
							"Striking out at [npc.name] with your "+this.getName()+", you grin as you bash [npc.herHim] right in the chest!",
							"You strike at [npc.name] with your "+this.getName()+", causing [npc.herHim] to stagger back as you bash [npc.her] torso!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] bashes [npc.her] "+this.getName()+" at you, grinning as [npc.she] whacks you right on the [pc.arm]!",
							"Striking out at you with [npc.her] "+this.getName()+", [npc.name] grins as [npc.she] bashes you right in the chest!",
							"[npc.Name] strikes at you with [npc.her] "+this.getName()+", causing you to stagger back [npc.she] bashes your torso!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] bashes [npc.her] "+this.getName()+" at [npc2.name], grinning as [npc.she] whacks [npc2.herHim] right on the [npc2.arm]!",
							"Striking out at [npc2.name] with [npc.her] "+this.getName()+", [npc.name] grins as [npc.she] bashes [npc2.herHim] right in the chest!",
							"[npc.Name] strikes at [npc2.name] with [npc.her] "+this.getName()+", causing [npc2.herHim] to stagger back [npc.she] bashes [npc2.her] torso!"),
					UtilText.returnStringAtRandom(
							"You bash your "+this.getName()+" at [npc.name], but your strike sails harmlessly through mid-air as you miss your target!",
							"Striking out at [npc.name] with your "+this.getName()+", you sigh in frustration as you end up missing your target!",
							"You slash at [npc.name] with your "+this.getName()+", but fail to land a hit!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] bashes [npc.her] "+this.getName()+" at you, but [npc.her] strike sails harmlessly through mid-air as [npc.she] misses you!",
							"Striking out at you with [npc.her] "+this.getName()+", [npc.name] sighs in frustration as [npc.she] ends up missing you!",
							"[npc.Name] strikes at you with [npc.her] "+this.getName()+", but fails to land a hit!"),
					UtilText.returnStringAtRandom(
							"[npc.Name] bashes [npc.her] "+this.getName()+" at [npc2.name], but [npc.her] strike sails harmlessly through mid-air as [npc.she] misses [npc2.herHim]!",
							"Striking out at [npc2.name] with [npc.her] "+this.getName()+", [npc.name] sighs in frustration as [npc.she] ends up missing [npc2.herHim]!",
							"[npc.Name] strikes at [npc2.name] with [npc.her] "+this.getName()+", but fails to land a hit!"));
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Strike at [npc.name] with your "+this.getName()+"!");
		}

		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.RESISTANCE_FIRE, 15),
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 15));
				case ICE:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.RESISTANCE_ICE, 15),
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 15));
				case LUST:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.RESISTANCE_LUST, 15),
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 15));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 30));
				case POISON:
					return Util.newHashMapOfValues(
							new Value<>(Attribute.RESISTANCE_POISON, 15),
							new Value<>(Attribute.RESISTANCE_PHYSICAL, 15));
			}
			return null;
		}
	};
	
	public static AbstractWeaponType OFFHAND_CHAOS_EPIC = new AbstractWeaponType(1500,
			false,
			"a",
			"it",
			false,
			"chaos feather",
			"chaos feathers",
			"Feather Bolt",
			"A well-preserved magical feather, the power of which can be harnessed as a weapon."
					+ " Feathers like this are rumoured to have been plucked from a Lilin's wings.",
			InventorySlot.WEAPON_OFFHAND,
			"rangedFeather2",
			Rarity.EPIC,
			Util.newArrayListOfValues(DamageType.PHYSICAL, DamageType.FIRE, DamageType.ICE, DamageType.POISON),
			14,
			0,
			DamageVariance.HIGH,
			null,
			null,
			null,
			null,
			null,
			Util.newArrayListOfValues(ItemTag.SOLD_BY_VICKY)) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy in the feather."
					+ " As [npc.she] [npc.does] so, it dissolves and flows into [npc.her] body, granting [npc.herHim] the ability to perform magical attacks at range.");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(focus)] on the energy inside of [npc.herHim], forcing it out from [npc.her] body."
					+ " As [npc.she] [npc.does] so, it reforms back into a chaos feather.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return genericRangedAttackDescription(character, target,isHit);
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"Use your feather's power to shoot a bolt of energy at [npc.name]!");
		}

		@Override
		public Map<Attribute, Integer> getGenerationAttributeModifiers(DamageType dt) {
			switch(dt) {
				case FIRE:
					return Util.newHashMapOfValues(new Value<>(Attribute.RESISTANCE_FIRE, 10));
				case ICE:
					return Util.newHashMapOfValues(new Value<>(Attribute.RESISTANCE_ICE, 10));
				case LUST:
					return Util.newHashMapOfValues(new Value<>(Attribute.RESISTANCE_PHYSICAL, 10));
				case MISC:
					break;
				case PHYSICAL:
					return Util.newHashMapOfValues(new Value<>(Attribute.RESISTANCE_PHYSICAL, 10));
				case POISON:
					return Util.newHashMapOfValues(new Value<>(Attribute.RESISTANCE_POISON, 10));
			}
			return null;
		}
	};
	
	// I made this in one of my lunch breaks x_x
	public static AbstractWeaponType MAIN_WESTERN_KKP = new AbstractWeaponType(25000,
			false,
			"a",
			"it",
			false,
			"Western KKP",
			"Western KKPs",
			"Fire KKP",
			"A blowback-operated semi-automatic pistol, featuring an exposed hammer, a traditional double-action trigger mechanism, a single-column magazine, and a fixed barrel that also acts as the guide rod for the recoil spring.",
			InventorySlot.WEAPON_MAIN,
			"western_kkp",
			Rarity.LEGENDARY,
			Util.newArrayListOfValues(DamageType.PHYSICAL),
			100000,
			0,
			DamageVariance.LOW,
			null,
			null,
			null,
			null,
			null,
			Util.newArrayListOfValues(ItemTag.REMOVE_FROM_DEBUG_SPAWNER)) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public String equipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(ready)] [npc.her] pistol.");
		}

		@Override
		public String unequipText(GameCharacter character) {
			return UtilText.parse(character, "[npc.Name] [npc.verb(holster)] [npc.her] pistol.");
		}

		@Override
		public String getAttackDescription(GameCharacter character, GameCharacter target, boolean isHit) {
			return UtilText.parse(character, target, "[npc.Name] just [npc.verb(shoot)] [npc2.name]... Thankfully, there seems to be some kind of arcane force preventing [npc.her] gun from actually killing [npc2.herHim]...");
		}

		@Override
		public String getAttackDescription(GameCharacter user, GameCharacter target) {
			return UtilText.parse(target,
					"The name's [pc.surname]... [pc.name] [pc.surname].");
		}
	};
	
	public static List<AbstractWeaponType> rareWeapons = new ArrayList<>(), allweapons = new ArrayList<>();
	
	public static Map<AbstractWeaponType, String> weaponToIdMap = new HashMap<>();
	public static Map<String, AbstractWeaponType> idToWeaponMap = new HashMap<>();

	static {
		
		Field[] fields = WeaponType.class.getFields();
		
		for(Field f : fields){
			
			if (AbstractWeaponType.class.isAssignableFrom(f.getType())) {
				
				AbstractWeaponType weapon;
				
				try {
					weapon = ((AbstractWeaponType) f.get(null));

					// I feel like this is stupid :thinking:
					weaponToIdMap.put(weapon, f.getName());
					idToWeaponMap.put(f.getName(), weapon);
					
					if(weapon != MAIN_WESTERN_KKP) {
						allweapons.add(weapon);
					
						if (weapon.getRarity() == Rarity.RARE) {
							rareWeapons.add(weapon);
						}
					}
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
