package com.lilithsthrone.game.dialogue.places.dominion;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.lilithsthrone.game.Season;
import com.lilithsthrone.game.Weather;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.game.dialogue.DialogueFlagValue;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.responses.ResponseEffectsOnly;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.item.AbstractItemType;
import com.lilithsthrone.game.inventory.item.ItemType;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;

/**
 * @since 0.1.0
 * @version 0.2.5
 * @author Innoxia
 */
public class CityPlaces {

	public static final DialogueNodeOld STREET = new DialogueNodeOld("Dominion Streets", "", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);
			
			if (Main.game.isDayTime()) { // Day time:
				if (Main.game.getCurrentWeather() != Weather.MAGIC_STORM) {
					UtilText.nodeContentSB.append("<p>"
							+ "Although the streets of Dominion look similar to those of Victorian-era London, there's a strange feel to them that hints at the other-worldly nature of this place."
							+ " The roads that should be home to a city's heavy traffic are all paved over with clean white flagstones.");
					
					switch(Main.game.getCurrentWeather()) {
						case CLEAR:
							UtilText.nodeContentSB.append(" Rows of trees and marble benches line either side of the pedestrianised streets, offering shade and a place to rest for weary shoppers."
									+ " On either side of you, the building's clean facades gleam in the sunshine, and high above in the sky, you see harpies flying about on business of their own."
									+ "</p>");
							break;
						case CLOUD:
							UtilText.nodeContentSB.append(" Rows of trees and marble benches line either side of the pedestrianised streets, offering a place to rest."
									+ " On either side of you, the building's clean facades gleam in the sunshine, and high above in the sky, you see harpies flying about on business of their own.</p>");
							break;
						case MAGIC_STORM_GATHERING:
							UtilText.nodeContentSB.append(" Marble benches line either side of the pedestrianised streets, granted shade from the summer sun by rows of trees."
									+ " The tree's branches sway as the wind starts to pick up, and the rustling of leaves can be head over the steady hum of the busy crowds."
									+ " On either side of you, the glass frontages of the recently renovated buildings reflect the darkening sky."
									+ "</p>");
							break;
						case RAIN:
							UtilText.nodeContentSB.append(" Rows of trees and marble benches line either side of the pedestrianised streets, offering a place to rest and cover from the rain."
									+ " On either side of you, large canvas awnings have been extended from the buildings, shielding passersby from the sudden downpour."
									+ "</p>");
							break;
						case SNOW:
							UtilText.nodeContentSB.append(" Large white snowflakes continue to fall all around you as you walk past the rows of trees and marble benches that line either side of the pedestrianised streets."
									+ "</p>");
							break;
						case MAGIC_STORM:
							break;
					}
					
					UtilText.nodeContentSB.append("<p>"
								+ "The streets are very busy at this time of day, and are filled with people hurrying to and fro."
								+ " Despite their alarming appearances, the citizens of Dominion appear to be completely normal in every other way."
								+ " You see those people who are always in a rush to be somewhere else, the crowds of shoppers lazily ambling by, the groups of friends laughing and chatting on benches, and"
								+ " all the other sorts that you'd find in any old city."
								+ " As the streets are quiet at this time, you have plenty of room to weave your way through the sparse crowds."
							+ "</p>"
							+ "<p>"
								+ "Most of the people around you are partial or lesser morphs, although there are a quite a few greater morphs to be seen walking the streets as well."
								+ " Dog, cat and horse-morphs are by far the most common races that you see, but it wouldn't take long to find examples of every race."
								+ " The rarest races that you see are humans and demons."
								+ " The latter are very easy to spot, as wherever they walk, people hurriedly move to make way."
							+ "</p>");

					UtilText.nodeContentSB.append(getRandomStreetEvent());
					
					
				} else { // Storm:
					UtilText.nodeContentSB.append("<p>"
								+ "Although the streets of Dominion look similar to those of Victorian-era London, there's a few major differences that reveal the other-worldly nature of this place."
								+ " The roads that should be home to a city's heavy traffic are all paved over with clean white flagstones."
								+ " Marble benches line either side of the pedestrianised streets, interspersed by rows of trees and arcane-powered street lamps."
								+ " The tree's branches sway wildly in the storm's wind as it howls down the empty streets."
								+ " The glass frontages of the surrounding buildings reflect each and every lightning strike, filling the streets with bright purple and pink flashes."
							+ "</p>"
							+ " <p>"
								+ "Due to the ongoing storm, the entire city seems to be almost totally deserted."
								+ " Doors are locked, windows are shuttered, and, for the most part, not a soul can be seen."
								+ " The only people able to withstand the storm's thunderous power are demons, and every now and then you see one strutting down the street."
								+ " They sometimes cast a curious glance your way, but most are content to simply ignore you."
							+ "</p>"
							+ " <p>"
								+ "The size and emptiness of the city streets fills you with a sense of foreboding, and you frantically look around for signs of danger as you hurry on your way."
								+ " Remembering what happened the first night you arrived in this world, you know full well that any non-demons caught out in the storm will be filled with an uncontrollable lust."
								+ " If they catch you, they'll be sure to force you into a fight."
							+ "</p>");
				}
				
			} else { // Night time:
				if (Main.game.getCurrentWeather() != Weather.MAGIC_STORM) {
					UtilText.nodeContentSB.append("<p>"
							+ "Although the streets of Dominion look similar to those of Victorian-era London, there's a strange feel to them that hints at the other-worldly nature of this place."
							+ " The roads that should be home to a city's heavy traffic are all paved over with clean white flagstones."
							+ " Marble benches line both sides of the pedestrianised streets, and are interspersed by rows of trees, softly illuminated by the amber glow of arcane-powered street lamps.");
					
					switch(Main.game.getCurrentWeather()) {
						case CLEAR: case CLOUD:
							UtilText.nodeContentSB.append(" On either side of you, lights shine out from the windows of the tall buildings."
									+ "</p>");
							break;
						case MAGIC_STORM_GATHERING:
							UtilText.nodeContentSB.append(" The tree's branches sway as the wind starts to pick up, and the rustling of leaves fills the still night air."
									+ "</p>");
							break;
						case RAIN:
							UtilText.nodeContentSB.append(" On either side of you, large canvas awnings have been extended from the buildings, shielding passersby from the sudden downpour."
									+ "</p>");
							break;
						case SNOW:
							UtilText.nodeContentSB.append(" Large fluffy snowflakes continue to fall all around you; their haphazard paths illuminated by the lights shining out from the windows of the tall buildings."
									+ "</p>");
							break;
						case MAGIC_STORM:
							break;
					}

					UtilText.nodeContentSB.append("<p>"
								+ "Although the streets are noticeably quieter than during the day, there are still plenty of people hurrying to and fro."
								+ " Despite their alarming appearances, the citizens of Dominion appear to be completely normal in every other way."
								+ " You see those people who are always in a rush to be somewhere else, the crowds of shoppers lazily ambling by, the groups of friends laughing and chatting on benches, and"
								+ " all the other sorts that you'd find in any old city."
								+ " As the streets are quiet at this time, you have plenty of room to weave your way through the sparse crowds."
							+ "</p>"
							+ "<p>"
								+ "Most of the people around you are partial or lesser morphs, although there are a quite a few greater morphs to be seen walking the streets as well."
								+ " Dog, cat and horse-morphs are by far the most common races that you see, but it wouldn't take long to find examples of every race."
								+ " The rarest races that you see are humans and demons."
								+ " The latter are very easy to spot, as wherever they walk, people hurriedly move to make way."
							+ "</p>");
					
					UtilText.nodeContentSB.append(getRandomStreetEvent());

				} else { // Storm:
					UtilText.nodeContentSB.append("<p>"
								+ "Although the streets of Dominion look similar to those of Victorian-era London, there's a few major differences that reveal the other-worldly nature of this place."
								+ "The roads that should be home to a city's heavy traffic are all paved over with clean white flagstones."
								+ " Marble benches line either side of the pedestrianised streets, interspersed by rows of trees, all illuminated by the soft amber glow of arcane-powered street lamps."
								+ " The tree's branches sway wildly in the storm's wind as it howls down the empty streets."
								+ " The glass frontages of the surrounding buildings reflect each and every lightning strike, filling the streets with bright purple and pink flashes."
							+ "</p>"
							+ " <p>"
								+ "Due to the ongoing storm, the entire city seems to be almost totally deserted."
								+ " Doors are locked, windows are shuttered, and, for the most part, not a soul can be seen."
								+ " The only people able to withstand the storm's thunderous power are demons, and every now and then you see one strutting down the street."
								+ " They sometimes cast a curious glance your way, but most are content to simply ignore you."
							+ "</p>"
							+ " <p>"
								+ "The size and emptiness of the city streets fills you with a sense of foreboding, and you frantically look around for signs of danger as you hurry on your way."
								+ " Remembering what happened the first night you arrived in this world, you know full well that any non-demons caught out in the storm will be filled with an uncontrollable lust."
								+ " If they catch you, they'll be sure to force you into a fight."
							+ "</p>");
					
					
				}
			}
			
			if(Main.game.getDateNow().getMonth()==Month.OCTOBER) {
				UtilText.nodeContentSB.append(
					"<p>"
						+ "<b style='color:"+Colour.BASE_ORANGE.toWebHexString()+";'>October;</b> <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Lilith's Month:</b><br/>"
						+ "Orange, black, and purple flags fly from almost every window, and you look up to see that large banners have been hung across the street, each one bearing a different slogan celebrating Lilith's rule."
						+ " The occasional demon that you see is usually dressed up in a Halloween-esque costume for the occasion, which does nothing to help alleviate the eerie atmosphere."
					+ "</p>");
			}
			if(Main.game.getDialogueFlags().hasFlag(DialogueFlagValue.hasSnowedThisWinter) && Main.game.getSeason()==Season.WINTER) {
				UtilText.nodeContentSB.append(
					"<p>"
						+ "<b style='color:"+Colour.BASE_BLUE_LIGHT.toWebHexString()+";'>Snow:</b><br/>"
						+ "The reindeer-morph workers are doing a good job of keeping Dominion's streets clear from the snow, but the rooftops, trees, and tops of lamp posts are all home to a thick layer of white."
						+ " You see your breath exiting your mouth in a little cloud of condensation, but despite the clear evidence of the air's freezing temperature, your arcane aura protects your body from feeling the cold."
					+ "</p>");
			}

			return UtilText.nodeContentSB.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			List<Response> responses = new ArrayList<>();
			
			if(index == 0) {
				return null;
				
			} else if(index-1 < responses.size()) {
				return responses.get(index-1);
			}
			
			return null;
		}
	};
	
	private static String getRandomStreetEvent() {
		int extraText = Util.random.nextInt(100) + 1;
		if (extraText <= 3) {
			return ("<p><i>A particularly large and imposing incubus cuts his way through the crowd, holding the leashes of three greater cat-girl slaves."
					+ " Each one is completely naked, and as they pass, you can clearly see their cunts drooling with excitement.</i></p>");
		} else if (extraText <= 6) {
			return ("<p><i>To one side, you see a pair of dog-boy enforcers questioning a shady-looking cat-boy."
					+ " As you pass, the cat-boy tries to make a break for it, but is quickly tackled to the floor."
					+ " The enforcers place a pair of restraints around his wrists before dragging him down a nearby alleyway.</i></p>");
		} else if (extraText <= 9) {
			return ("<p><i>A huge billboard covers the entire face of one of the buildings across the street."
					+ " On it, there's an advertisement for the tournament, 'Risk it all', promising great rewards for anyone strong enough to beat the challenge."
					+ " Underneath, the words 'Applications opening soon!' are displayed in bold red lettering.</i></p>");
		} else if (extraText == 10) {
			return ("<p><i>A greater cat-girl is handing out leaflets just in front of you, and as you pass, she shoves one into your hands."
					+ " You look down to see that it's just an advertisement for the drink '"+ ItemType.INT_INGREDIENT_FELINE_FANCY.getName(false)+ "'.</i></p>");
		} else if (extraText == 11) {
			return ("<p><i>A greater wolf-boy is handing out leaflets just in front of you, and as you pass, he shoves one into your hands."
					+ " You look down to see that it's just an advertisement for the drink '"+ ItemType.STR_INGREDIENT_WOLF_WHISKEY.getName(false)+ "'.</i></p>");
		} else if (extraText == 12) {
			return ("<p><i>A greater dog-girl is handing out leaflets just in front of you, and as you pass, she shoves one into your hands."
					+ " You look down to see that it's just an advertisement for the drink '"+ ItemType.FIT_INGREDIENT_CANINE_CRUSH.getName(false)+ "'.</i></p>");
		} else if (extraText == 13) {
			return ("<p><i>A greater horse-boy is handing out leaflets just in front of you, and as you pass, he shoves one into your hands."
					+ " You look down to see that it's just an advertisement for the drink '"+ ItemType.STR_INGREDIENT_EQUINE_CIDER.getName(false)+ "'.</i></p>");
		} else if (extraText == 14) {
			return ("<p><i>A cheering crowd has gathered to one side of the street, and as you glance across, a momentary gap in the crowd allows you to catch a glimpse of what's happening."
					+ " A greater dog-girl is on all fours, and is being double penetrated by a greater horse-boy's pair of massive horse-cocks."
					+ " The girl's juices are leaking down her legs and her tongue lolls from her mouth as the gigantic members thrust in and out of her stretched holes.</i></p>");
		}
		return "";
	}

	
	public static final DialogueNodeOld BACK_ALLEYS = new DialogueNodeOld("Back Alleys", "", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);
			UtilText.nodeContentSB.append("<p>"
					+ "You find yourself walking through labyrinthine alleyways, with not a soul in sight."
					+ " Back-doors and steaming vents line the dark brick walls, and you often have to navigate around overflowing bins and stacks of empty crates in order to make progress."
					+ " These less-travelled parts of Dominion have a dangerous feel to them, and you can't shake the feeling that you're being followed."
					+ "</p>");
			
			for(GameCharacter npc : Main.game.getNonCompanionCharactersPresent()) {
				UtilText.nodeContentSB.append(((NPC) npc).getPresentInTileDescription());
			}
			
			return UtilText.nodeContentSB.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index == 1) {
				return new ResponseEffectsOnly(
						"Explore",
						"Explore the alleyways. Although you don't think you're any more or less likely to find anything by doing this, at least you won't have to keep travelling back and forth..."){
							@Override
							public void effects() {
								DialogueNodeOld dn = Main.game.getActiveWorld().getCell(Main.game.getPlayer().getLocation()).getPlace().getDialogue(true, true);
								Main.game.setContent(new Response("", "", dn));
							}
						};
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld DARK_ALLEYS = new DialogueNodeOld("Dark Alleyways", "", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);
			UtilText.nodeContentSB.append("<p>"
						+ "You find yourself walking through labyrinthine alleyways, with not a soul in sight."
						+ " Back-doors and steaming vents line the dark brick walls, and you often have to navigate around overflowing bins and stacks of empty crates in order to make progress."
						+ " You're far away from the safety of the main street, and you can't shake the feeling that there's something <b>extremely dangerous</b> lurking around the next corner..."
					+ "</p>");

			for(GameCharacter npc : Main.game.getNonCompanionCharactersPresent()) {
				UtilText.nodeContentSB.append(((NPC) npc).getPresentInTileDescription());
			}
			
			return UtilText.nodeContentSB.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index == 1) {
				return new ResponseEffectsOnly(
						"Explore",
						"Explore the alleyways. Although you don't think you're any more or less likely to find anything by doing this, at least you won't have to keep travelling back and forth..."){
							@Override
							public void effects() {
								DialogueNodeOld dn = Main.game.getActiveWorld().getCell(Main.game.getPlayer().getLocation()).getPlace().getDialogue(true, true);
								Main.game.setContent(new Response("", "", dn));
							}
						};
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld BACK_ALLEYS_CANAL = new DialogueNodeOld("Canal Crossing", ".", false) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public int getMinutesPassed() {
			return 5;
		}
		
		@Override
		public String getContent() {
			return "<p>"
						+ "At the junction between the canal and Dominion's dingy backalleys, a series of crude wooden walkways criss-cross over the water."
						+ " Providing a bridge between the numerous passageways set into the flanking buildings on both sides of the waterway, these makeshift constructs are quite clearly the work of the denizens that haunt this area."
					+ "</p>"
					+ "<p>"
						+ "Cautiously glancing around your deserted surroundings, you half-expect to see a shadowy figure emerge from one of the gloomy openings, but, much to your relief, there doesn't seem to be anyone waiting in ambush."
						+ " Letting out a sigh, you continue on your way, happy that you didn't run into any of the lowlives that operate in this area."
					+ "</p>";
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if(index == 1) {
				return new ResponseEffectsOnly(
						"Explore",
						"Explore this area. Although you don't think you're any more or less likely to find anything by doing this, at least you won't have to keep travelling back and forth..."){
							@Override
							public void effects() {
								DialogueNodeOld dn = Main.game.getActiveWorld().getCell(Main.game.getPlayer().getLocation()).getPlace().getDialogue(true, true);
								Main.game.setContent(new Response("", "", dn));
							}
						};
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld BOULEVARD = new DialogueNodeOld("Dominion Boulevard", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);

			UtilText.nodeContentSB.append(
					"<p>"
						+ "You find yourself walking down one of Dominion's main boulevards, which is at least twice the width of all the other streets that you've seen in the city."
						+ " Large, immaculately-maintained residential and commercial buildings flank the road on each side; their white marble facades decorated with countless dark-purple flags bearing the black pentagram of Lilith."
					+ "</p>");
			
			if(Main.game.getCurrentWeather()==Weather.MAGIC_STORM) {
				UtilText.nodeContentSB.append(
						"<p>"
							+ "<b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Arcane Storm:</b><br/>"
							+ "The arcane storm that's raging overhead has brought out a heavy presence of demon Enforcers in this area."
							+ " Unaffected by the arousing power of the storm's thunder, these elite Enforcers keep a close watch on you as you walk down the all-but-deserted boulevard."
							+ " There's no way anyone would be able to assault you while under their watchful gaze, allowing you continue on your way in peace..."
						+ "</p>");
			} else {
				if(Main.game.isDayTime()) {
					UtilText.nodeContentSB.append(
							"<p>"
								+ "Being one of Dominion's main thoroughfares, this boulevard is immensely busy, and you walk past individuals of all different races and appearances as you continue onwards through the crowds."
								+ " Although dog, cat and horse-morphs are still the most common races that you see, there are noticeably more demons mixed in with the crowds here."
								+ " These succubi and incubi are very easy to spot, as wherever they walk, people hurriedly move to make way."
							+ "</p>");
				} else {
					UtilText.nodeContentSB.append(
							"<p>"
								+ "Despite the fact that it's night-time, this boulevard is immensely busy, and you walk past individuals of all different races and appearances as you continue onwards through the crowds."
								+ " Although dog, cat and horse-morphs are still the most common races that you see, there are noticeably more demons mixed in with the crowds here."
								+ " These succubi and incubi are very easy to spot, as wherever they walk, people hurriedly move to make way."
							+ "</p>");
				}
			}

			if(Main.game.getDateNow().getMonth()==Month.OCTOBER) {
				UtilText.nodeContentSB.append(
					"<p>"
						+ "<b style='color:"+Colour.BASE_ORANGE.toWebHexString()+";'>October;</b> <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Lilith's Month:</b><br/>"
						+ "Orange, black, and purple flags fly from almost every window, and you look up to see that large banners have been hung across the street, each one bearing a different slogan celebrating Lilith's rule."
						+ " The occasional demon that you see is usually dressed up in a Halloween-esque costume for the occasion, which does nothing to help alleviate the eerie atmosphere."
					+ "</p>");
			}
			if(Main.game.getDialogueFlags().hasFlag(DialogueFlagValue.hasSnowedThisWinter) && Main.game.getSeason()==Season.WINTER) {
				UtilText.nodeContentSB.append(
					"<p>"
						+ "<b style='color:"+Colour.BASE_BLUE_LIGHT.toWebHexString()+";'>Snow:</b><br/>"
						+ "The reindeer-morph workers are doing a good job of keeping Dominion's streets clear from the snow, but the rooftops, trees, and tops of lamp posts are all home to a thick layer of white."
						+ " You see your breath exiting your mouth in a little cloud of condensation, but despite the clear evidence of the air's freezing temperature, your arcane aura protects your body from feeling the cold."
					+ "</p>");
			}
			
			return UtilText.nodeContentSB.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return null;
		}
	};

	
	public static final DialogueNodeOld DOMINION_PLAZA = new DialogueNodeOld("Lilith's Plaza", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 10;
		}

		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);
			
			UtilText.nodeContentSB.append("<p>"
						+ "You find yourself standing in the very centre of Dominion, where an expansive public square is situated."
						+ " Large residential and commercial buildings flank the plaza on each of its four sides; their white marble facades decorated with countless dark-purple flags bearing the black pentagram of Lilith."
					+ "</p>"
					+ "<p>"
						+ "Numerous grandiose statues and extravagantly-detailed water fountains, all carved from polished white marble, reside within this large area."
						+ " Each one of these sculptures appears to represent a demon or Lilin, and although they're each a marvellous work of art, the one in the very middle of the square is quite simply breathtaking."
						+ " On top of a plinth of at least thirty metres in height, stands a gigantic marble statue of Lilith herself;"
							+ " with wings fully unfurled, and with her hands resting on her wide hips, she smirks down with a visage of manic delight at the crowds below."
						+ " Completely naked, every inch of the effigy's subject is on display for all to see, and you find yourself looking straight up at Lilith's tight pussy as you marvel at the workmanship that went into this astounding piece of art."
					+ "</p>");
			
			if(Main.game.getCurrentWeather()==Weather.MAGIC_STORM) {
				UtilText.nodeContentSB.append(
						"<p>"
							+ "<b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>Arcane Storm:</b><br/>"
							+ "The arcane storm that's raging overhead has brought out a heavy presence of demon Enforcers in this area."
							+ " Unaffected by the arousing power of the storm's thunder, these elite Enforcers keep a close watch on you as you pass through the all-but-deserted plaza."
							+ " There's no way anyone would be able to assault you while under their watchful gaze, allowing you continue on your way in peace..."
						+ "</p>");
			} else {
				UtilText.nodeContentSB.append(
						"<p>"
							+ "Being the central meeting place for Dominion's citizens, this plaza is the busiest location in all of Dominion."
							+ " Throngs of people, of all different races and appearances, fill the square."
							+ " Some appear to be simply passing through the area, while others lounge about on the many wooden benches and marble steps at the base of each statue."
						+ "</p>"
						+ "<p>"
							+ "On raised platforms, well-spoken orators address the crowds, relaying news and important announcements to the many citizens who pass by."
							+ " Pamphlets and newspapers are handed out beside each one of these stands, and you realise that this is the only place where you've seen any form of news being distributed to the population."
						+ "</p>");
			}
			
			return UtilText.nodeContentSB.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index == 1) {
				if(Main.game.getCurrentWeather()==Weather.MAGIC_STORM) {
					return new Response(
							"News", "Due to the ongoing arcane storm, there's nobody here at the moment...", null);
					
				} else {
					return new Response(
							"News",
							"Decide to stay a while and listen to one of the orators...", DOMINION_PLAZA_NEWS){
								@Override
								public void effects() {
									List<Subspecies> possibleSubspecies = new ArrayList<>();
									possibleSubspecies.add(Subspecies.CAT_MORPH);
									possibleSubspecies.add(Subspecies.DOG_MORPH);
									possibleSubspecies.add(Subspecies.HORSE_MORPH);
									possibleSubspecies.add(Subspecies.WOLF_MORPH);
									
									String randomFemalePerson = possibleSubspecies.get(Util.random.nextInt(possibleSubspecies.size())).getSingularFemaleName();
									String randomMalePerson = possibleSubspecies.get(Util.random.nextInt(possibleSubspecies.size())).getSingularMaleName();
									
									Main.game.getTextEndStringBuilder().append("<p>"
											+UtilText.returnStringAtRandom(
													"A rough-looking "+randomMalePerson+" unrolls a large scroll, before clearing his throat and calling out,"
														+ " [maleNPC.speech(By decree of Lilith, and in the interests of Dominion's security,"
															+ " any human found walking the streets between the hours of ten at night and five in the morning will be subject to a full body search from any passing Enforcer without warrant.)]",
													Util.capitaliseSentence(UtilText.generateSingularDeterminer(randomFemalePerson))+" "+randomFemalePerson+" holds up an official-looking piece of paper, complete with a red wax seal, and declares,"
														+ " [femaleNPC.speech(A reward of two-hundred-thousand flames has been issued for any information leading to the arrest of the person or persons responsible"
															+ " for distributing illegal newspapers in the districts beneath the Harpy Nests!)]",
													"A rather wild-looking succubus, dressed in a very Halloween-esque witch's costume, points to different members of the crowd as she screams,"
														+ " [femaleNPC.speech(I count no less than three demons in the crowd who are without a cultist's uniform!"
															+ " What would Lilith say if she could see this now?!)]",
													Util.capitaliseSentence(UtilText.generateSingularDeterminer(randomMalePerson))+" "+randomMalePerson+" relays several boring, mundane pieces of news to the crowd."
															+ " There's nothing that is of any interest to you, and you eventually turn away, having felt as though you just wasted your time.",
													Util.capitaliseSentence(UtilText.generateSingularDeterminer(randomFemalePerson))+" "+randomFemalePerson+" relays several boring, mundane pieces of news to the crowd."
															+ " There's nothing that is of any interest to you, and you eventually turn away, having felt as though you just wasted your time.",
													Util.capitaliseSentence(UtilText.generateSingularDeterminer(randomMalePerson))+" "+randomMalePerson+" is currently reading out a list of advertisements for shops in the local area."
															+ " There's really nothing of interest to be heard, and you soon find yourself turning away and moving on.",
													Util.capitaliseSentence(UtilText.generateSingularDeterminer(randomFemalePerson))+" "+randomFemalePerson+" is currently reading out a list of advertisements for shops in the local area."
															+ " There's really nothing of interest to be heard, and you soon find yourself turning away and moving on.")
											+"</p>");
								}
							};
				}
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld DOMINION_PLAZA_NEWS = new DialogueNodeOld("Lilith's Plaza", ".", false, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);
			
			UtilText.nodeContentSB.append("<p>"
					+ "You decide to stay and listen to one of the many orators who are addressing the crowds..."
					+ "</p>");
			
			return UtilText.nodeContentSB.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return DOMINION_PLAZA.getResponse(responseTab, index);
		}
	};
	
	public static final DialogueNodeOld PARK = new DialogueNodeOld("Park", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getAuthor() {
			return "Kumiko";
		}
		
		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
						+ "This area of Dominion is taken up by a gigantic park, filled with a lush amount of foliage, which makes the air here feel very fresh compared to the rest of the city."
						+ " The park consists of several alternating areas of open lawn and woodland, connected by a series of winding paths."
						+ " There's a small lake situated in one corner of the park, and adjacent to that, there's a small field of wild flowers."
						+ " A couple of food stands have been set up in one area for people that didn't come prepared with a picnic."
					+ "</p>"
					+ "<p>"
						+ "The most noteworthy feature is at the very centre of the park, and takes the form of a huge statue of Lilith herself."
						+ " The sultry smile carved into the white marble almost feels at though it's mocking you, and you can't help but feel as though you don't want to stick around here for long."
					+ "</p>"
					+ "<p>"
						+ "For now, you don't have much reason to wander through this park, but if you had someone else with you, it would be a nice place to spend an afternoon; if you can ignore the statue, that is..."
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Rose Garden", "There's a beautiful rose garden just off to your right. Walk over to it and take a closer look.", PARK_ROSE_GARDEN) {
					@Override
					public void effects() {
						Main.game.getTextEndStringBuilder().append(Main.game.getPlayer().addItem(AbstractItemType.generateItem(ItemType.GIFT_ROSE), false));
					}
				};
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld PARK_ROSE_GARDEN = new DialogueNodeOld("Park", ".", false, true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getAuthor() {
			return "Innoxia";
		}
		
		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
					+ "You find your attention drawn towards a small rose garden that's positioned near the park's entrance."
					+ " Walking over towards it, you see that someone's placed a little sign just in front of the border, which reads:"
				+ "</p>"
				+ "<p style='text-align:center;'>"
					+ "<i>"
						+ "<b>William's Rose Garden</b><br/>"
						+ "Please feel free to help yourself to these roses!"
						+ " I hope you or your partner gets as much happiness out of them as I do from growing them.<br/>"
						+ "- William"
					+ "</i>"
				+ "</p>"
				+ "<p>"
					+ "You look around, but don't see anyone nearby who could be this 'William' character."
					+ " Focusing your attention back to his rose garden, you decide to do as William's sign says, and, stepping forwards, you pluck a single red rose from the nearest bush."
				+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Rose Garden", "You've already taken a rose from the garden.", null);
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld STREET_SHADED = new DialogueNodeOld("Dominion Streets (Shaded)", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return STREET.getContent()
					+ "<p>"
						+ "<b style='color:"+Colour.RACE_HARPY.toWebHexString()+";'>Harpy Nests:</b><br/>"
						+ "The wooden platforms and bridges of the rooftop Harpy Nests cast a shadow over these streets."
						+ " Looking up, you see the occasional flash of brightly-coloured feathers as harpies swoop this way and that."
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return null;
		}
	};
	
	public static final DialogueNodeOld CANAL = new DialogueNodeOld("Dominion Canals", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
						+ "You find yourself walking down the narrow dirt path that runs alongside Dominion's canal."
						+ " The murky waterway is, for the most part, flanked by dark, red-bricked buildings, which give this area of the city a very ominous atmosphere."
					+ "</p>"
					+ "<p>"
						+ "Here and there, the track that you're on widens out, and occasionally branches off to connect with small clearings and gardens."
						+ " Instead of giving you any sense of relief from your oppressive surroundings, however, these rare, foliage-filled areas only serve to fill you with unease,"
							+ " as their leafy bushes and trees would easily grant any would-be attacker the perfect place to hide."
					+ "</p>"
					+ "<p>"
						+ "Unlike the city's back-alleys, this canal-side path is not completely deserted, and every now and then you come across a passerby, who invariably averts their gaze and hurries past you, clearly not wanting to cause any trouble."
						+ " The canal, too, seems to be in infrequent use, and every five minutes or so, an industrial barge slowly trawls past; its long deck stacked high with crates, or filled with tarpaulin-covered mounds of raw materials."
					+ "</p>"
					+ "<p>"
						+ "Excluding these sparse signs of life, the canal is completely deserted."
						+ " The distinct lack of any Enforcer presence is a clear indication that this area is ripe territory for muggers, and you make sure to stay alert as you continue on your way..."
					+ "</p>";
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if(index == 1) {
				return new ResponseEffectsOnly(
						"Explore",
						"Explore this area. Although you don't think you're any more or less likely to find anything by doing this, at least you won't have to keep travelling back and forth..."){
							@Override
							public void effects() {
								DialogueNodeOld dn = Main.game.getActiveWorld().getCell(Main.game.getPlayer().getLocation()).getPlace().getDialogue(true, true);
								Main.game.setContent(new Response("", "", dn));
							}
						};
			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNodeOld CANAL_END = new DialogueNodeOld("Dominion Canals", ".", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return CANAL.getContent()
					+ "<p>"
						+ "<i>"
							+ "The path before you abruptly ends, and although the canal continues on its way to the outskirts of the city, there's no way for you to continue onwards."
						+ "</i>"
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new ResponseEffectsOnly(
						"Explore",
						"Explore this area. Although you don't think you're any more or less likely to find anything by doing this, at least you won't have to keep travelling back and forth..."){
							@Override
							public void effects() {
								DialogueNodeOld dn = Main.game.getActiveWorld().getCell(Main.game.getPlayer().getLocation()).getPlace().getDialogue(true, true);
								Main.game.setContent(new Response("", "", dn));
							}
						};
			} else {
				return null;
			}
		}
	};

	// Entrances and exits:

	public static final DialogueNodeOld CITY_EXIT_JUNGLE = new DialogueNodeOld("Jungle Entrance", "Travel to the jungle.", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
					+ "A sign next to the road informs you that this path leads to the demonic jungles."
					+ " A pair of enforcers are preventing anyone from travelling to the jungle right now."
					+ "</p>"
					+ "<p>"
					+ "<b>Scheduled for release in version 0.4.0.</b>"
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Jungle", "Travel to the demonic jungle. (This will be added later!)", null){
//					@Override
//					public void specialEffects() {
//						Main.mainController.moveGameWorld(true);
//					}
				};

			} else {
				return null;
			}
		}
	};
	public static final DialogueNodeOld CITY_EXIT_FIELDS = new DialogueNodeOld("Fields Entrance", "Travel to the fields.", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
					+ "A sign next to the road informs you that this path leads to the outskirts of the city."
					+ " A pair of enforcers are preventing anyone from travelling to the fields right now."
					+ "</p>"
					+ "<p>"
					+ "<b>Scheduled for release in version 0.3.0.</b>"
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Fields", "Travel to the fields. (This will be added later!)", null);

			} else {
				return null;
			}
		}
	};
	public static final DialogueNodeOld CITY_EXIT_SEA = new DialogueNodeOld("Endless Sea Entrance", "Travel to the Endless Sea.", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
					+ "A sign next to the road informs you that this path leads to the endless sea."
					+ " A pair of enforcers are preventing anyone from travelling to the endless sea right now."
					+ "</p>"
					+ "<p>"
					+ "<b>Scheduled for release in version 0.6.0.</b>"
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Endless Sea", "Travel to the Endless Sea. (This will be added later!)", null);

			} else {
				return null;
			}
		}
	};
	public static final DialogueNodeOld CITY_EXIT_DESERT = new DialogueNodeOld("Desert Entrance", "Travel to the desert.", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public int getMinutesPassed() {
			return 5;
		}

		@Override
		public String getContent() {
			return "<p>"
					+ "A sign next to the road informs you that this path leads to the desert."
					+ " A pair of enforcers are preventing anyone from travelling to the desert right now."
					+ "</p>"
					+ "<p>"
					+ "<b>Scheduled for release in version 0.5.0.</b>"
					+ "</p>";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Desert", "Travel to the desert. (This will be added later!)", null);

			} else {
				return null;
			}
		}
	};
}
