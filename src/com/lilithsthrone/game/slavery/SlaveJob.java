package com.lilithsthrone.game.slavery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.effects.Perk;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.dialogue.eventLog.EventLogEntry;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.world.Cell;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @since 0.1.87
 * @version 0.2.5
 * @author Innoxia
 */
public enum SlaveJob {
	
	/*
		restaurant
			w&m
		bar
			sleazy (obedience not counted, but income is less)
			allow groping
	 */
	
	IDLE(-1, "Idle", "Idle", "Do not assign any job to this slave.",
			0, 0,
			0, 0, 0,
			null, null, null) {
		public boolean isAvailable(GameCharacter character) {
			return true;
		}
	},
	
	CLEANING(20, "maid", "manservant", "Assign this slave to help Rose keep the house clean, deal with visitors, and perform all sorts of menial housework.",
			0, 0.5f,
			80, 0f, 0.1f,
			null, null, null) {
		@Override
		public EventLogEntry getHourlyEvent(long hour, NPC slave, List<NPC> otherNPCsPresent) {
			return new EventLogEntry(Main.game.getDayNumber()-1*24l+hour, "[style.colourDisabled(Nothing)]", "");
		}
		
		@Override
		public void sendToWorkLocation(GameCharacter slave) {

		}
	},
	
	LIBRARY(5, "librarian", "librarian", "Assign this slave to work in Lilaya's library.",
			0, 0.25f,
			80, 0, 0.1f,
			null, null, null),
	
	KITCHEN(5, "cook", "cook", "Assign this slave to work in Lilaya's kitchen as a cook.",
			0, 0.25f,
			80, 0, 0.05f,
			null, null, null),
	
	MILKING(-1, "Dairy Cow", "Dairy Bull", "Assign this slave to the cow stalls, ready for milking or breeding (or perhaps both). Income is based off of the assigned slave's milk, cum, and girlcum production.",
			-0.25f, 1f,
			0, 0, 0,
			Util.newArrayListOfValues(
					SlaveJobSetting.MILKING_MILK_DISABLE,
					SlaveJobSetting.MILKING_CUM_DISABLE,
					SlaveJobSetting.MILKING_GIRLCUM_DISABLE),
			Util.newHashMapOfValues(
					new Value<>("Room Preference", Util.newArrayListOfValues(
							SlaveJobSetting.MILKING_INDUSTRIAL,
							SlaveJobSetting.MILKING_REGULAR,
							SlaveJobSetting.MILKING_ARTISAN,
							SlaveJobSetting.MILKING_NO_PREFERENCE))),
			Util.newArrayListOfValues(
					SlaveJobSetting.MILKING_NO_PREFERENCE)) {

		@Override
		public int getSlaveLimit() {
			return Main.game.getSlaveryUtil().getMilkingRooms().size()*8;
		}
		
		@Override
		public float getAffectionGain(GameCharacter slave) {
			if(slave.hasFetish(Fetish.FETISH_LACTATION_SELF)) {
				return 2f;
			} else {
				return -0.25f;
			}
		}
		
		@Override
		public boolean isAvailable(GameCharacter character) {
			return Main.game.getPlayer().getSlavesWorkingJob(SlaveJob.MILKING) < getSlaveLimit();
		}

		public String getAvailabilityText(GameCharacter character) {
			if(!isAvailable(character)) {
				return "Not enough space in milking rooms!";
			}
			
			return super.getAvailabilityText(character);
		}
		
		@Override
		public WorldType getWorldLocation(GameCharacter character) {
			Cell c = MilkingRoom.getMilkingCell(character, false);
			if(c==null) {
				return null;
			}
			return c.getType();
		}
		
		@Override
		public PlaceType getPlaceLocation(GameCharacter character) {
			Cell c = MilkingRoom.getMilkingCell(character, false);
			if(c==null) {
				return null;
			}
			return c.getPlace().getPlaceType();
		}
		
		@Override
		public void sendToWorkLocation(GameCharacter slave) {
			Cell c = MilkingRoom.getMilkingCell(slave, true);
			if(c!=null) {
				if(c.getType()!=slave.getWorldLocation() || c.getLocation()!=slave.getLocation()) {
					slave.setLocation(c.getType(), c.getLocation(), false);
				}
			}
		}
		
	}
	
	;
	
	private int slaveLimit;
	private String nameFeminine;
	private String nameMasculine;
	private String description;
	private float obedienceGain;
	private float affectionGain;
	private int income;
	private float obedienceIncomeModifier;
	private float affectionIncomeModifier;
	private List<SlaveJobSetting> mutualSettings;
	private Map<String, List<SlaveJobSetting>> mutuallyExclusiveSettings;
	private List<SlaveJobSetting> defaultMutuallyExclusiveSettings;
	private WorldType worldLocation;
	private PlaceType placeLocation;
	
	private SlaveJob(int slaveLimit,
			String nameFeminine,
			String nameMasculine,
			String description,
			float affectionGain,
			float obedienceGain,
			int income,
			float affectionIncomeModifier,
			float obedienceIncomeModifier,
			List<SlaveJobSetting> mutualSettings,
			Map<String, List<SlaveJobSetting>> mutuallyExclusiveSettings,
			List<SlaveJobSetting> defaultMutuallyExclusiveSettings) {
		
		this.slaveLimit = slaveLimit;
		this.nameFeminine = nameFeminine;
		this.nameMasculine = nameMasculine;
		this.description = description;
		this.obedienceGain = obedienceGain;
		this.affectionGain = affectionGain;
		this.income = income;
		this.obedienceIncomeModifier = obedienceIncomeModifier;
		this.affectionIncomeModifier = affectionIncomeModifier;
		
		if(mutualSettings == null) {
			this.mutualSettings = new ArrayList<>();
		} else {
			this.mutualSettings = mutualSettings;
		}
		
		if(mutuallyExclusiveSettings == null) {
			this.mutuallyExclusiveSettings = new HashMap<>();
		} else {
			this.mutuallyExclusiveSettings = mutuallyExclusiveSettings;
		}

		if(defaultMutuallyExclusiveSettings == null) {
			this.defaultMutuallyExclusiveSettings = new ArrayList<>();
		} else {
			this.defaultMutuallyExclusiveSettings = defaultMutuallyExclusiveSettings;
		}
	}
	
	public int getSlaveLimit() {
		return slaveLimit;
	}

	public String getName(GameCharacter character) {
		if(character.isFeminine()) {
			return nameFeminine;
		} else {
			return nameMasculine;
		}
	}
	
	public String getNameFeminine() {
		return nameFeminine;
	}
	
	public String getNameMasculine() {
		return nameMasculine;
	}

	public String getDescription() {
		return description;
	}
	
	public float getObedienceGain(GameCharacter slave) {
		return obedienceGain;
	}

	public float getAffectionGain(GameCharacter slave) {
		return affectionGain;
	}

	public int getIncome() {
		return income;
	}
	
	public int getFinalHourlyIncomeAfterModifiers(GameCharacter character) {
		int value = (int)(Math.max(0, (income + ((getAffectionIncomeModifier()*character.getAffection(Main.game.getPlayer()))) + ((getObedienceIncomeModifier()*character.getObedienceValue())))));
		
		if(this==SlaveJob.MILKING) {
			value = 0;
			if(character.getBreastRawStoredMilkValue()>0  && !character.getSlaveJobSettings().contains(SlaveJobSetting.MILKING_MILK_DISABLE)) {
				int milked = MilkingRoom.getActualMilkPerHour(character);
				value += (milked * character.getMilk().getValuePerMl());
			}
			if(character.hasPenis() && character.getPenisRawStoredCumValue()>0  && !character.getSlaveJobSettings().contains(SlaveJobSetting.MILKING_CUM_DISABLE)) {
				int milked = MilkingRoom.getActualCumPerHour(character);
				value += (milked * character.getCum().getValuePerMl());
			}
			if(character.hasVagina() && !character.getSlaveJobSettings().contains(SlaveJobSetting.MILKING_GIRLCUM_DISABLE)) {
				int milked = MilkingRoom.getActualGirlcumPerHour(character);
				value += (milked * character.getGirlcum().getValuePerMl());
			}
		}
		
		if(character.getOwner().hasTrait(Perk.JOB_OFFICE_WORKER, true)) {
			return (int) (1.25f * value);
		} else if((character.getOwner().hasTrait(Perk.JOB_MAID, true) || character.getOwner().hasTrait(Perk.JOB_BUTLER, true)) && this==SlaveJob.CLEANING) {
			return 2 * value;
		}
		
		return value;
	}
	
	public int getFinalDailyIncomeAfterModifiers(GameCharacter character) {
		int value = (int)(Math.max(0, (income + ((getAffectionIncomeModifier()*character.getAffection(Main.game.getPlayer()))) + ((getObedienceIncomeModifier()*character.getObedienceValue()))))*character.getTotalHoursWorked());
		
		if(this==SlaveJob.MILKING) {
			value = 0;
			if(character.getBreastRawStoredMilkValue()>0 && !character.getSlaveJobSettings().contains(SlaveJobSetting.MILKING_MILK_DISABLE)) {
				int milked = (int) Math.max(1, (character.getBreastLactationRegeneration().getPercentageRegen()*60));
				value += (milked * character.getMilk().getValuePerMl());
			} 
			if(character.hasPenis() && character.getPenisRawStoredCumValue()>0 && !character.getSlaveJobSettings().contains(SlaveJobSetting.MILKING_CUM_DISABLE)) {
				int milked = (int) Math.max(1, (character.getPenisCumProductionRegeneration().getPercentageRegen()*60));
				value += (milked * character.getCum().getValuePerMl());
			}
			if(character.hasVagina() && !character.getSlaveJobSettings().contains(SlaveJobSetting.MILKING_GIRLCUM_DISABLE)) {
				int milked = character.getVaginaWetness().getValue()*(character.isVaginaSquirter()?2:1);
				value += (milked * character.getGirlcum().getValuePerMl());
			}
			value *= character.getTotalHoursWorked();
		}
		
		if(character.getOwner().hasTrait(Perk.JOB_OFFICE_WORKER, true)) {
			return (int) (1.25f * value);
		} else if((character.getOwner().hasTrait(Perk.JOB_MAID, true) || character.getOwner().hasTrait(Perk.JOB_BUTLER, true)) && this==SlaveJob.CLEANING) {
			return 2 * value;
		}
		
		return value;
	}

	public float getObedienceIncomeModifier() {
		return obedienceIncomeModifier;
	}

	public float getAffectionIncomeModifier() {
		return affectionIncomeModifier;
	}

	public List<SlaveJobSetting> getMutualSettings() {
		return mutualSettings;
	}

	public Map<String, List<SlaveJobSetting>> getMutuallyExclusiveSettings() {
		return mutuallyExclusiveSettings;
	}
	
	public List<SlaveJobSetting> getDefaultMutuallyExclusiveSettings() {
		return defaultMutuallyExclusiveSettings;
	}

	public WorldType getWorldLocation(GameCharacter character) {
		return worldLocation;
	}

	public PlaceType getPlaceLocation(GameCharacter character) {
		return placeLocation;
	}
	
	public void sendToWorkLocation(GameCharacter slave) {
		if(slave.getSlaveJob().getWorldLocation(slave)!=null
				&& slave.getSlaveJob().getPlaceLocation(slave)!=null
				&& (slave.getSlaveJob().getWorldLocation(slave)!=slave.getWorldLocation() || slave.getSlaveJob().getPlaceLocation(slave)!=slave.getLocationPlace().getPlaceType())) {
			slave.setRandomUnoccupiedLocation(slave.getSlaveJob().getWorldLocation(slave), slave.getSlaveJob().getPlaceLocation(slave), false);
		}
	}
	
	public boolean isAvailable(GameCharacter character) {
		return character.getSlaveJob()==this || (character.getHomeLocationPlace().getPlaceType() != PlaceType.SLAVER_ALLEY_SLAVERY_ADMINISTRATION && character.getOwner().getSlavesWorkingJob(this)<this.getSlaveLimit());
	}
	
	public String getAvailabilityText(GameCharacter character) {
		if(character.getOwner().getSlavesWorkingJob(this)>=this.getSlaveLimit()) {
			return "You have already assigned the maximum number of slaves to this job!";
			
		} else if(character.getHomeLocationPlace().getPlaceType() == PlaceType.SLAVER_ALLEY_SLAVERY_ADMINISTRATION) {
			return "Slaves cannot work out of the cells at slavery administration. Move them into a room first!";
			
		} else {
			return "This job is unavailable!";
		}
	}
	
	public EventLogEntry getHourlyEvent(long hour, NPC slave, List<NPC> otherNPCsPresent) {
//		return new EventLogEntry(Main.game.getDayNumber()-1*24l+hour, "[style.colourDisabled(Nothing)]", "");
		return null;
	}
	
}
