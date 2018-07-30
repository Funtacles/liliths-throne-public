package com.lilithsthrone.game.character.body.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.body.Body;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.utils.Util;

/**
 * @since 0.1.0
 * @version 0.2.1
 * @author Innoxia
 */
public enum AssType implements BodyPartTypeInterface {
	HUMAN(BodyCoveringType.HUMAN, AnusType.HUMAN, Race.HUMAN),
	
	DOG_MORPH(BodyCoveringType.CANINE_FUR, AnusType.DOG_MORPH, Race.DOG_MORPH),
	
	COW_MORPH(BodyCoveringType.BOVINE_FUR, AnusType.COW_MORPH, Race.COW_MORPH),

	SQUIRREL_MORPH(BodyCoveringType.SQUIRREL_FUR, AnusType.SQUIRREL_MORPH, Race.SQUIRREL_MORPH),

	RAT_MORPH(BodyCoveringType.RAT_FUR, AnusType.RAT_MORPH, Race.RAT_MORPH),
	
	RABBIT_MORPH(BodyCoveringType.RABBIT_FUR, AnusType.RABBIT_MORPH, Race.RABBIT_MORPH),

	WOLF_MORPH(BodyCoveringType.LYCAN_FUR, AnusType.WOLF_MORPH, Race.WOLF_MORPH),
	
	FOX_MORPH(BodyCoveringType.FOX_FUR, AnusType.FOX_MORPH, Race.FOX_MORPH),
	
	CAT_MORPH(BodyCoveringType.FELINE_FUR, AnusType.CAT_MORPH, Race.CAT_MORPH),
	
	HORSE_MORPH(BodyCoveringType.HORSE_HAIR, AnusType.HORSE_MORPH, Race.HORSE_MORPH),
	
	REINDEER_MORPH(BodyCoveringType.REINDEER_FUR, AnusType.REINDEER_MORPH, Race.REINDEER_MORPH);
	
	private BodyCoveringType skinType;
	private AnusType anusType;
	private Race race;

	private AssType(BodyCoveringType skinType, AnusType anusType, Race race) {
		this.skinType = skinType;
		this.anusType = anusType;
		this.race = race;
	}
	
	@Override
	public boolean isDefaultPlural() {
		return false;
	}

	@Override
	public String getDeterminer(GameCharacter gc) {
		return "";
	}
	
	@Override
	public String getName(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("ass", "rear end", "butt", "rump");
		}
	}

	@Override
	public String getNameSingular(GameCharacter gc) {
		return getName(gc);
	}
	
	@Override
	public String getNamePlural(GameCharacter gc) {
		switch(this){
			default:
				return UtilText.returnStringAtRandom("asses", "rear ends", "butts", "rumps");
		}
	}

	@Override
	public String getDescriptor(GameCharacter gc) {
		// Randomly give a size or type-specific descriptor:
		switch(Util.random.nextInt(2)){
			case 0:
				switch (this) {
					default:
						return UtilText.returnStringAtRandom("");
				}
			default:
				return gc.getAssSize().getDescriptor();
		}
	}

	@Override
	public BodyCoveringType getBodyCoveringType(Body body) {
		if(body!=null) {
			return body.getSkin().getType().getBodyCoveringType(body);
		}
		return skinType;
	}

	@Override
	public Race getRace() {
		return race;
	}
	public AnusType getAnusType() {
		return anusType;
	}
	
	public String getTransformName() {
		switch(this){
			case CAT_MORPH:
				return "feline";
			case DOG_MORPH:
				return "canine";
			case COW_MORPH:
				return "bovine";
			case SQUIRREL_MORPH:
				return "furry";
			case HORSE_MORPH:
				return "equine";
			case REINDEER_MORPH:
				return "rangiferine";
			case HUMAN:
				return "human";
			case WOLF_MORPH:
				return "lupine";
			case FOX_MORPH:
				return "vulpine";
			case RAT_MORPH:
				return "rat";
			case RABBIT_MORPH:
				return "rabbit";
		}
		return "";
	}
	
	private static Map<Race, List<AssType>> typesMap = new HashMap<>();
	public static List<AssType> getAssTypes(Race r) {
		if(typesMap.containsKey(r)) {
			return typesMap.get(r);
		}
		
		List<AssType> types = new ArrayList<>();
		for(AssType type : AssType.values()) {
			if(type.getRace()==r) {
				types.add(type);
			}
		}
		typesMap.put(r, types);
		return types;
	}
}