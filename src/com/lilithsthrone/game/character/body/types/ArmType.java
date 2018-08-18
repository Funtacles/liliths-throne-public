package com.lilithsthrone.game.character.body.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.body.Body;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.dialogue.utils.UtilText;

/**
 * @since 0.1.0
 * @version 0.2.2
 * @author Innoxia
 */
public enum ArmType implements BodyPartTypeInterface {

	HUMAN(BodyCoveringType.HUMAN, Race.HUMAN),

	DEMON_COMMON(BodyCoveringType.DEMON_COMMON, Race.DEMON),

	IMP(BodyCoveringType.IMP, Race.IMP),

	COW_MORPH(BodyCoveringType.BOVINE_FUR, Race.COW_MORPH),
	
	DOG_MORPH(BodyCoveringType.CANINE_FUR, Race.DOG_MORPH),
	
	LYCAN(BodyCoveringType.LYCAN_FUR, Race.WOLF_MORPH),
	
	FOX_MORPH(BodyCoveringType.FOX_FUR, Race.FOX_MORPH),

	CAT_MORPH(BodyCoveringType.FELINE_FUR, Race.CAT_MORPH),

	HORSE_MORPH(BodyCoveringType.HORSE_HAIR, Race.HORSE_MORPH),

	ALLIGATOR_MORPH(BodyCoveringType.ALLIGATOR_SCALES, Race.ALLIGATOR_MORPH),

	SQUIRREL_MORPH(BodyCoveringType.SQUIRREL_FUR, Race.SQUIRREL_MORPH),
	
	RABBIT_MORPH(BodyCoveringType.RABBIT_FUR, Race.RABBIT_MORPH);

	private BodyCoveringType skinType;
	private Race race;

	private ArmType(BodyCoveringType skinType, Race race) {
		this.skinType = skinType;
		this.race = race;
	}
	
	public boolean allowsFlight() {
		return false;
	}

	@Override
	public String getDeterminer(GameCharacter gc) {
		if(gc.getArmRows()==1) {
			return "a pair of";
		} else if(gc.getArmRows()==2) {
			return "two pairs of";
		} else {
			return "three pairs of";
		}
	}

	@Override
	public boolean isDefaultPlural() {
		return true;
	}

	@Override
	public String getNameSingular(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("arm");
		}
	}
	
	@Override
	public String getNamePlural(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("arms");
		}
	}

	@Override
	public String getDescriptor(GameCharacter gc) {
		switch(this){
			case CAT_MORPH:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
			case DEMON_COMMON:
				return UtilText.returnStringAtRandom("flawless");
			case IMP:
				return UtilText.returnStringAtRandom("");
			case DOG_MORPH:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
			case COW_MORPH:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
			case SQUIRREL_MORPH:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
			case ALLIGATOR_MORPH:
				return UtilText.returnStringAtRandom("scaled", "reptile-like");
			case HORSE_MORPH:
				return UtilText.returnStringAtRandom("");
			case HUMAN:
				return UtilText.returnStringAtRandom("");
			case LYCAN:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
			case FOX_MORPH:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
			case RABBIT_MORPH:
				return UtilText.returnStringAtRandom("furry", "fur-coated");
		}
		return "";
	}
	
	public String getTransformName() {
		switch(this){
			case CAT_MORPH:
				return "feline";
			case DEMON_COMMON:
				return "demonic";
			case IMP:
				return "impish";
			case DOG_MORPH:
				return "canine";
			case COW_MORPH:
				return "bovine";
			case SQUIRREL_MORPH:
				return "furry";
			case ALLIGATOR_MORPH:
				return "alligator";
			case HORSE_MORPH:
				return "equine";
			case HUMAN:
				return "human";
			case LYCAN:
				return "lupine";
			case FOX_MORPH:
				return "vulpine";
			case RABBIT_MORPH:
				return "rabbit";
		}
		return "";
	}

	@Override
	public BodyCoveringType getBodyCoveringType(Body body) {
		return skinType;
	}

	@Override
	public Race getRace() {
		return race;
	}
	
	public String getHandsNameSingular(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("hand");
		}
	}
	
	public String getHandsNamePlural(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("hands");
		}
	}

	public String getHandsDescriptor(GameCharacter gc) {
		if (gc.isFeminine()) {
			switch(this){
				case CAT_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "cat-like", "paw-like", "furry", "feline");
				case DEMON_COMMON: case IMP:
					return UtilText.returnStringAtRandom("delicate", "soft", "feminine");
				case DOG_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "dog-like", "paw-like", "furry", "canine");
				case COW_MORPH:
					return UtilText.returnStringAtRandom("feminine", "bovine");
				case ALLIGATOR_MORPH:
					return UtilText.returnStringAtRandom("feminine", "scaled");
				case HORSE_MORPH:
					return UtilText.returnStringAtRandom("feminine", "equine");
				case HUMAN:
					return UtilText.returnStringAtRandom("soft", "feminine");
				case LYCAN:
					return UtilText.returnStringAtRandom("soft", "feminine", "wolf-like", "furry", "paw-like");
				case FOX_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "fox-like", "furry", "paw-like");
				case SQUIRREL_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "squirrel-like", "claw-like", "furry", "rodent");
				case RABBIT_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "rabbit-like", "paw-like", "furry");
			}
		} else {
			switch(this){
				case CAT_MORPH:
					return UtilText.returnStringAtRandom("soft", "delicate", "cat-like", "paw-like", "furry", "feline");
				case DEMON_COMMON: case IMP:
					return UtilText.returnStringAtRandom("");
				case DOG_MORPH:
					return UtilText.returnStringAtRandom("dog-like", "paw-like", "furry", "canine");
				case COW_MORPH:
					return UtilText.returnStringAtRandom("bovine");
				case ALLIGATOR_MORPH:
					return UtilText.returnStringAtRandom("scaled");
				case HORSE_MORPH:
					return UtilText.returnStringAtRandom("equine");
				case HUMAN:
					return UtilText.returnStringAtRandom("");
				case LYCAN:
					return UtilText.returnStringAtRandom("wolf-like", "furry", "paw-like");
				case FOX_MORPH:
					return UtilText.returnStringAtRandom("fox-like", "furry", "paw-like");
				case SQUIRREL_MORPH:
					return UtilText.returnStringAtRandom("soft", "squirrel-like", "claw-like", "furry", "rodent");
				case RABBIT_MORPH:
					return UtilText.returnStringAtRandom("rabbit-like", "paw-like", "furry");
			}
		}
		
		return "";
	}
	
	public String getFingersNameSingular(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("finger");
		}
	}
	
	public String getFingersNamePlural(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("fingers");
		}
	}

	public String getFingersDescriptor(GameCharacter gc) {
		if (gc.isFeminine()) {
			switch(this){
				case CAT_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "padded", "feline");
				case DEMON_COMMON: case IMP:
					return UtilText.returnStringAtRandom("delicate", "soft", "feminine");
				case DOG_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "padded", "canine");
				case COW_MORPH:
					return UtilText.returnStringAtRandom("feminine", "bovine");
				case ALLIGATOR_MORPH:
					return UtilText.returnStringAtRandom("feminine", "scaled");
				case HORSE_MORPH:
					return UtilText.returnStringAtRandom("feminine", "equine");
				case HUMAN:
					return UtilText.returnStringAtRandom("soft", "feminine");
				case LYCAN:
					return UtilText.returnStringAtRandom("soft", "feminine", "padded", "wolf-like");
				case FOX_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "padded", "fox-like");
				case SQUIRREL_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "clawed", "rodent");
				case RABBIT_MORPH:
					return UtilText.returnStringAtRandom("soft", "feminine", "rabbit-like", "paw-like", "furry");
			}
		} else {
			switch(this){
				case CAT_MORPH:
					return UtilText.returnStringAtRandom("soft", "delicate", "padded", "feline");
				case DEMON_COMMON: case IMP:
					return UtilText.returnStringAtRandom("");
				case DOG_MORPH:
					return UtilText.returnStringAtRandom("dog-like", "padded", "canine");
				case COW_MORPH:
					return UtilText.returnStringAtRandom("bovine");
				case ALLIGATOR_MORPH:
					return UtilText.returnStringAtRandom("scaled");
				case HORSE_MORPH:
					return UtilText.returnStringAtRandom("equine");
				case HUMAN:
					return UtilText.returnStringAtRandom("");
				case LYCAN:
					return UtilText.returnStringAtRandom("wolf-like", "padded");
				case FOX_MORPH:
					return UtilText.returnStringAtRandom("fox-like", "padded");
				case SQUIRREL_MORPH:
					return UtilText.returnStringAtRandom("soft", "clawed", "rodent");
				case RABBIT_MORPH:
					return UtilText.returnStringAtRandom("rabbit-like", "paw-like", "furry");
			}
		}
		
		return "";
	}
	
	private static Map<Race, List<ArmType>> typesMap = new HashMap<>();
	public static List<ArmType> getArmTypes(Race r) {
		if(typesMap.containsKey(r)) {
			return typesMap.get(r);
		}
		
		List<ArmType> types = new ArrayList<>();
		for(ArmType type : ArmType.values()) {
			if(type.getRace()==r) {
				types.add(type);
			}
		}
		typesMap.put(r, types);
		return types;
	}
}