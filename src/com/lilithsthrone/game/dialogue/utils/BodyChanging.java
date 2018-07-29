package com.lilithsthrone.game.dialogue.utils;

import java.util.ArrayList;
import java.util.List;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.types.HornType;
import com.lilithsthrone.game.character.npc.misc.Elemental;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.DialogueNodeType;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.responses.ResponseEffectsOnly;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;

/**
 * @since 0.1.90
 * @version 0.2.5
 * @author Innoxia
 */
public class BodyChanging {
	
	private static GameCharacter target;
	
	public static GameCharacter getTarget() {
		if(target==null) {
			return Main.game.getPlayer();
		}
		return target;
	}

	public static void setTarget(GameCharacter target) {
		BodyChanging.target = target;
	}
	
	private static Response getBodyChangingResponse(int responseTab, int index) {
		if(index==1) {
			return new Response("Core",
					getTarget().isPlayer()
						?"Change core aspects of your body."
						:UtilText.parse(getTarget(), "Change core aspects of [npc.namePos] body."),
					BODY_CHANGING_CORE);
			
		} else if(index==2) {
			return new Response("Head", 
					getTarget().isPlayer()
						?"Change aspects of your face and hair."
						:UtilText.parse(getTarget(), "Change aspects of [npc.namePos] face and hair."),
					BODY_CHANGING_FACE);
			
		} else if(index==3) {
			return new Response("Ass",
					getTarget().isPlayer()
						?"Change aspects of your ass."
						:UtilText.parse(getTarget(), "Change aspects of [npc.namePos] ass."),
					BODY_CHANGING_ASS);
			
		} else if(index==4) {
			return new Response("Breasts",
					getTarget().isPlayer()
						?"Change aspects of your breasts."
						:UtilText.parse(getTarget(), "Change aspects of [npc.namePos] breasts."),
					BODY_CHANGING_BREASTS);
			
		} else if(index==5) {
			return new Response("Vagina", 
					getTarget().isPlayer()
						?"Change aspects of your vagina."
						:UtilText.parse(getTarget(), "Change aspects of [npc.namePos] vagina."),
						BODY_CHANGING_VAGINA);
			
		} else if(index==6) {
			return new Response("Penis", 
					getTarget().isPlayer()
						?"Change aspects of your penis."
						:UtilText.parse(getTarget(), "Change aspects of [npc.namePos] penis."),
						BODY_CHANGING_PENIS);
			
		} else if(index==0) {
			return new ResponseEffectsOnly("Back", "Return to the previous screen."){
				@Override
				public void effects() {
					Main.game.restoreSavedContent();
				}
			};
			
		} else {
			return null;
		}
	}

	private static List<Race> demonRace = Util.newArrayListOfValues(Race.DEMON);
	private static List<Race> slimeRaces = new ArrayList<>();
	static {
		for(Race r : Race.values()) {
			slimeRaces.add(r);
		}
	}
	
	private static boolean isDemonTFMenu() {
		return BodyChanging.getTarget().getRace()==Race.DEMON
				|| BodyChanging.getTarget() instanceof Elemental;
	}
	
	public static final DialogueNodeOld BODY_CHANGING_CORE = new DialogueNodeOld("Core", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getHeaderContent() {
			if(isDemonTFMenu()) {
				return "<div class='container-full-width' style='text-align:center;'>"
							+ (BodyChanging.getTarget().isPlayer()
									?"<i>Focus your demonic transformative powers on changing core aspects of your body.</i>"
									:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] demonic transformative powers on changing core aspects of [npc.her] body.</i>"))
						+ "</div>"
						
						+ CharacterModificationUtils.getFullFemininityChoiceDiv()

						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformArmChoiceDiv(demonRace)
							+ CharacterModificationUtils.getSelfTransformLegChoiceDiv(demonRace)
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformTailChoiceDiv(demonRace)
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformWingChoiceDiv(demonRace)
							+ CharacterModificationUtils.getSelfTransformWingSizeDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getHeightChoiceDiv()
						
						
						+ "<div class='cosmetics-container' style='background:transparent;'>"
						
							+ CharacterModificationUtils.getBodySizeChoiceDiv()
							+ CharacterModificationUtils.getMuscleChoiceDiv()
							
							+ "<div class='container-full-width' style='text-align:center;'>"
							+ (BodyChanging.getTarget().isPlayer()
									?"Your muscle and body size values result in your appearance being:<br/>"
										+ "<b style='color:"+Main.game.getPlayer().getBodyShape().toWebHexStringColour()+";'>"+Util.capitaliseSentence(Main.game.getPlayer().getBodyShape().getName(false))+"</b>"
									:UtilText.parse(BodyChanging.getTarget(), "[npc.NamePos] muscle and body size values result in [npc.her] appearance being:<br/>"
											+ "<b style='color:"+getTarget().getBodyShape().toWebHexStringColour()+";'>"+Util.capitaliseSentence(getTarget().getBodyShape().getName(false))+"</b>"))
							+ "</div>"
						
						+"</div>"
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyChanging.getTarget().getSkinType().getBodyCoveringType(BodyChanging.getTarget())).getType(), "Skin Colour",
								(BodyChanging.getTarget().isPlayer()
									?"The colour of the demonic skin that's covering your body."
									:UtilText.parse(BodyChanging.getTarget(), "The colour of the demonic skin that's covering [npc.namePos] body.")),
								true, true)
						
						+ (BodyChanging.getTarget() instanceof Elemental
								?""
								:CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getBodyHairCoveringType(), "Body Hair Colour",
									(BodyChanging.getTarget().isPlayer()
										?"The colour of your demonic body hair."
										:UtilText.parse(BodyChanging.getTarget(), "The colour of the [npc.namePos] demonic body hair.")),
									true, true));
			// Slime:
			} else {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your efforts on changing core aspects of your slime body.</i>"
								:UtilText.parse(BodyChanging.getTarget(),
										"<i>Get [npc.name] to focus [npc.her] efforts on changing core aspects of [npc.her] slime body.</i>"))
					+ "</div>"
					
					+ CharacterModificationUtils.getFullFemininityChoiceDiv()
					
					+"<div style='clear:left;'>"
						+ CharacterModificationUtils.getSelfTransformFaceChoiceDiv(slimeRaces)
						+ CharacterModificationUtils.getSelfTransformBodyChoiceDiv(slimeRaces)
					+"</div>"
					
					+"<div style='clear:left;'>"
						+ CharacterModificationUtils.getSelfTransformArmChoiceDiv(slimeRaces)
						+ CharacterModificationUtils.getSelfTransformLegChoiceDiv(slimeRaces)
					+"</div>"

					+"<div style='clear:left;'>"
						+ CharacterModificationUtils.getSelfTransformTailChoiceDiv(slimeRaces)
					+"</div>"
					
					+"<div style='clear:left;'>"
						+ CharacterModificationUtils.getSelfTransformWingChoiceDiv(slimeRaces)
						+ CharacterModificationUtils.getSelfTransformWingSizeDiv()
					+"</div>"
							
					+ CharacterModificationUtils.getHeightChoiceDiv()
					
					
					+ "<div class='cosmetics-container' style='background:transparent;'>"
					
						+ CharacterModificationUtils.getBodySizeChoiceDiv()
						+ CharacterModificationUtils.getMuscleChoiceDiv()
						
						+ "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"Your muscle and body size values result in your appearance being:<br/>"
									+ "<b style='color:"+Main.game.getPlayer().getBodyShape().toWebHexStringColour()+";'>"+Util.capitaliseSentence(Main.game.getPlayer().getBodyShape().getName(false))+"</b>"
								:UtilText.parse(BodyChanging.getTarget(), "[npc.NamePos] muscle and body size values result in [npc.her] appearance being:<br/>"
										+ "<b style='color:"+getTarget().getBodyShape().toWebHexStringColour()+";'>"+Util.capitaliseSentence(getTarget().getBodyShape().getName(false))+"</b>"))
						+ "</div>"
					
					+"</div>";
			}
		}
		
		@Override
		public String getContent() {
			return "";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Core", "You are already in this screen!", null);
				
			} else {
				return getBodyChangingResponse(responseTab, index);
			}
		}

		@Override
		public DialogueNodeType getDialogueNodeType() {
			return DialogueNodeType.PHONE;
		}
	};
	
	public static final DialogueNodeOld BODY_CHANGING_FACE = new DialogueNodeOld("Head", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getHeaderContent() {
			if(isDemonTFMenu()) {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your demonic transformative powers on changing aspects of your face and hair.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] demonic transformative powers on changing aspects of [npc.her] face and hair.</i>"))
						+ "</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformIrisChoiceDiv()
							+ CharacterModificationUtils.getSelfTransformPupilChoiceDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyChanging.getTarget().getEyeType().getBodyCoveringType(BodyChanging.getTarget())).getType(), "Eye colour",
								(BodyChanging.getTarget().isPlayer()
										?"The colour and pattern of your eyes."
										:UtilText.parse(BodyChanging.getTarget(), "The colour and pattern of [npc.namePos] eyes.")),
								true, true)

						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.EYE_PUPILS).getType(), "Pupil colour",
								(BodyChanging.getTarget().isPlayer()
										?"The colour and pattern of your pupils."
										:UtilText.parse(BodyChanging.getTarget(), "The colour and pattern of [npc.namePos] pupils.")),
								true, true)

						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.EYE_SCLERA).getType(), "Sclerae colour",
								(BodyChanging.getTarget().isPlayer()
										?"The colour and pattern of your sclerae."
										:UtilText.parse(BodyChanging.getTarget(), "The colour and pattern of [npc.namePos] sclerae.")),
								true, true)
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformHornChoiceDiv(demonRace)
							+ CharacterModificationUtils.getSelfTransformHornSizeDiv()
						+"</div>"

						+ (BodyChanging.getTarget().getHornType()!=HornType.NONE
								?CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyChanging.getTarget().getHornType().getBodyCoveringType(BodyChanging.getTarget())).getType(), "Horn Colour",
									(BodyChanging.getTarget().isPlayer()
										?"The colour of your horns."
										:UtilText.parse(BodyChanging.getTarget(), "The colour of [npc.namePos] horns.")),
									true, true)
								:"")
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformLipSizeDiv()
							+ CharacterModificationUtils.getSelfTransformThroatModifiersDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformTongueSizeDiv()
							+ CharacterModificationUtils.getSelfTransformTongueModifiersDiv()
						+"</div>"
							
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.MOUTH).getType(), "Lip & Throat colour",
								(BodyChanging.getTarget().isPlayer()
										?"The natural colour of your lips (top options) and your throat (bottom options). Lipstick can be used to conceal your natural lip colour."
										:UtilText.parse(BodyChanging.getTarget(), "The natural colour of [npc.namePos] lips (top options) and [npc.her] throat (bottom options). Lipstick can be used to conceal [npc.her] natural lip colour.")),
								true, true)
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.TONGUE).getType(), "Tongue colour",
								(BodyChanging.getTarget().isPlayer()
										?"The colour of your tongue."
										:UtilText.parse(BodyChanging.getTarget(), "The colour of [npc.namePos] tongue.")),
								true, true)
	
						+ CharacterModificationUtils.getKatesDivHairLengths(false, "Hair Length",
								(BodyChanging.getTarget().isPlayer()
										?"You can harness the power of your demonic form to change the length of your hair."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can harness the power of [npc.her] demonic form to change the length of [npc.her] hair.")))
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyChanging.getTarget().getHairType().getBodyCoveringType(BodyChanging.getTarget())).getType(), "Hair colour",
								(BodyChanging.getTarget().isPlayer()
										?"You can harness the power of your demonic form to change the colour of your hair."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can harness the power of [npc.her] demonic form to change the colour of [npc.her] hair.")), true, true)
						
						
						;
				
			// Slime:
			} else {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your efforts on changing aspects of your slimy face and hair.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] efforts on changing aspects of [npc.her] slimy face and hair.</i>"))
						+ "</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformEyeChoiceDiv(slimeRaces)
							+ CharacterModificationUtils.getSelfTransformEarChoiceDiv(slimeRaces)
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformIrisChoiceDiv()
							+ CharacterModificationUtils.getSelfTransformPupilChoiceDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformHairChoiceDiv(slimeRaces)
							+ CharacterModificationUtils.getSelfTransformAntennaChoiceDiv(slimeRaces)
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformHornChoiceDiv(slimeRaces)
							+ CharacterModificationUtils.getSelfTransformHornSizeDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformLipSizeDiv()
							+ CharacterModificationUtils.getSelfTransformThroatModifiersDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformTongueSizeDiv()
							+ CharacterModificationUtils.getSelfTransformTongueModifiersDiv()
						+"</div>"
							
						+ CharacterModificationUtils.getSelfDivHairStyles("Hair Style", "You can change the style of your slimy hair at will!")
						
						+ CharacterModificationUtils.getKatesDivHairLengths(false, "Hair Length",
								(BodyChanging.getTarget().isPlayer()
										?"You can freely change the length of your slimy hair."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can freely change the length of [npc.her] slimy hair.")))
						;
			}
		}
		
		@Override
		public String getContent() {
			return "";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==2) {
				return new Response("Head", "You are already in this screen!", null);
				
			} else {
				return getBodyChangingResponse(responseTab, index);
			}
		}

		@Override
		public DialogueNodeType getDialogueNodeType() {
			return DialogueNodeType.PHONE;
		}
	};
	
	public static final DialogueNodeOld BODY_CHANGING_ASS = new DialogueNodeOld("Ass", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getHeaderContent() {
			if(isDemonTFMenu()) {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your demonic transformative powers on changing aspects of your ass and hips.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] demonic transformative powers on changing aspects of [npc.her] ass and hips.</i>"))
						+ "</div>"
								
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformAssSizeDiv()
							+ CharacterModificationUtils.getSelfTransformHipSizeDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformAnusCapacityDiv()
							+ CharacterModificationUtils.getSelfTransformAnusWetnessDiv()
						+"</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformAnusElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformAnusPlasticityDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getSelfTransformAnusModifiersDiv()
							
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.ANUS).getType(), "Anus Colour", 
								(BodyChanging.getTarget().isPlayer()
										?"You can harness the power of your demonic form to change the colour of your asshole."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can harness the power of [npc.her] demonic form to change the colour of [npc.her] asshole.")), true, true)
						
						;
				
			// Slime:
			} else {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your efforts on changing aspects of your slimy ass and hips.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] efforts on changing aspects of [npc.her] slimy ass and hips.</i>"))
						+ "</div>"
	
						+ CharacterModificationUtils.getSelfTransformAssChoiceDiv(slimeRaces)
								
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformAssSizeDiv()
							+ CharacterModificationUtils.getSelfTransformHipSizeDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformAnusCapacityDiv()
							+ CharacterModificationUtils.getSelfTransformAnusWetnessDiv()
						+"</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformAnusElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformAnusPlasticityDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getSelfTransformAnusModifiersDiv()
						;
			}
		}
		
		@Override
		public String getContent() {
			return "";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==3) {
				return new Response("Ass", "You are already in this screen!", null);
				
			} else {
				return getBodyChangingResponse(responseTab, index);
			}
		}

		@Override
		public DialogueNodeType getDialogueNodeType() {
			return DialogueNodeType.PHONE;
		}
	};
	
	public static final DialogueNodeOld BODY_CHANGING_BREASTS = new DialogueNodeOld("Breasts", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getHeaderContent() {
			if(isDemonTFMenu()) {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your demonic transformative powers on changing aspects of your breasts.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] demonic transformative powers on changing aspects of [npc.her] breasts.</i>"))
						+ "</div>"
							
						+ CharacterModificationUtils.getSelfTransformBreastSizeDiv()
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformBreastShapeDiv()
							+ CharacterModificationUtils.getSelfTransformLactationDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformBreastRowsDiv()
							+ CharacterModificationUtils.getSelfTransformNippleCountDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformNippleSizeDiv()
							+ CharacterModificationUtils.getSelfTransformAreolaeSizeDiv()
						+"</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformNippleModifiersDiv()
							+ CharacterModificationUtils.getSelfTransformNippleCapacityDiv()
						+"</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformNippleElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformNipplePlasticityDiv()
						+"</div>"
						
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.NIPPLES).getType(), "Nipple Colour", 
								(BodyChanging.getTarget().isPlayer()
										?"You can harness the power of your demonic form to change the colour of your nipples."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can harness the power of [npc.her] demonic form to change the colour of [npc.her] nipples.")),
								true, true)
						;
			
			// Slime:
			} else {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your efforts on changing aspects of your slimy breasts.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] efforts on changing aspects of [npc.her] slimy breasts.</i>"))
						+ "</div>"
							
						+ CharacterModificationUtils.getSelfTransformBreastChoiceDiv(slimeRaces)
						
						+ CharacterModificationUtils.getSelfTransformBreastSizeDiv()
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformBreastShapeDiv()
							+ CharacterModificationUtils.getSelfTransformLactationDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformBreastRowsDiv()
							+ CharacterModificationUtils.getSelfTransformNippleCountDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformNippleSizeDiv()
							+ CharacterModificationUtils.getSelfTransformAreolaeSizeDiv()
						+"</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformNippleModifiersDiv()
							+ CharacterModificationUtils.getSelfTransformNippleCapacityDiv()
						+"</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformNippleElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformNipplePlasticityDiv()
						+"</div>"
						;
			}
		}
		
		@Override
		public String getContent() {
			return "";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==4) {
				return new Response("Breasts", "You are already in this screen!", null);
				
			} else {
				return getBodyChangingResponse(responseTab, index);
			}
		}

		@Override
		public DialogueNodeType getDialogueNodeType() {
			return DialogueNodeType.PHONE;
		}
	};
	
	public static final DialogueNodeOld BODY_CHANGING_VAGINA = new DialogueNodeOld("Vagina", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getHeaderContent() {
			if(isDemonTFMenu()) {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your demonic transformative powers on changing aspects of your vagina.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] demonic transformative powers on changing aspects of [npc.her] vagina.</i>"))
						+ "</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaChoiceDiv(demonRace)
							+ CharacterModificationUtils.getSelfTransformVaginaModifiersDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaCapacityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaWetnessDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaPlasticityDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformLabiaSizeDiv()
							+ CharacterModificationUtils.getSelfTransformClitorisSizeDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraCapacityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraModifiersDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraPlasticityDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.VAGINA).getType(), "Vagina Colour", 
								(BodyChanging.getTarget().isPlayer()
										?"You can harness the power of your demonic form to change the colour of your vagina."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can harness the power of [npc.her] demonic form to change the colour of [npc.her] vagina.")), true, true)
						
						;
				
			// Slime:
			} else {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your efforts on changing aspects of your slimy vagina.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] efforts on changing aspects of [npc.her] slimy vagina.</i>"))
						+ "</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaChoiceDiv(slimeRaces)
							+ CharacterModificationUtils.getSelfTransformVaginaModifiersDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaCapacityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaWetnessDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaPlasticityDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformLabiaSizeDiv()
							+ CharacterModificationUtils.getSelfTransformClitorisSizeDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraCapacityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraModifiersDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformVaginaUrethraPlasticityDiv()
						+"</div>";
			}
		}
		
		@Override
		public String getContent() {
			return "";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==5) {
				return new Response("Vagina", "You are already in this screen!", null);
				
			} else {
				return getBodyChangingResponse(responseTab, index);
			}
		}

		@Override
		public DialogueNodeType getDialogueNodeType() {
			return DialogueNodeType.PHONE;
		}
	};
	
	public static final DialogueNodeOld BODY_CHANGING_PENIS = new DialogueNodeOld("Penis", "", true) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getHeaderContent() {
			if(isDemonTFMenu()) {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your demonic transformative powers on changing aspects of your penis.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] demonic transformative powers on changing aspects of [npc.her] penis.</i>"))
						+ "</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformPenisChoiceDiv(demonRace, true)
							+ CharacterModificationUtils.getSelfTransformPenisGirthDiv()
						+"</div>"

						+ CharacterModificationUtils.getSelfTransformPenisSizeDiv()
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformTesticleSizeDiv()
							+ CharacterModificationUtils.getSelfTransformTesticleCountDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getSelfTransformCumProductionDiv()
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getInternalTesticleDiv()
							+ CharacterModificationUtils.getSelfTransformUrethraCapacityDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformUrethraElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformUrethraPlasticityDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformPenisModifiersDiv()
							+ CharacterModificationUtils.getSelfTransformUrethraModifiersDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getKatesDivCoveringsNew(false, BodyChanging.getTarget().getCovering(BodyCoveringType.PENIS).getType(), "Penis Colour", 
								(BodyChanging.getTarget().isPlayer()
										?"You can harness the power of your demonic form to change the colour of your penis."
										:UtilText.parse(BodyChanging.getTarget(), "[npc.Name] can harness the power of [npc.her] demonic form to change the colour of [npc.her] penis.")), true, true)
						
						;
				
			// Slime:
			} else {
				return "<div class='container-full-width' style='text-align:center;'>"
						+ (BodyChanging.getTarget().isPlayer()
								?"<i>Focus your efforts on changing aspects of your penis.</i>"
								:UtilText.parse(BodyChanging.getTarget(), "<i>Get [npc.name] to focus [npc.her] efforts on changing aspects of [npc.her] penis.</i>"))
						+ "</div>"
	
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformPenisChoiceDiv(slimeRaces, true)
							+ CharacterModificationUtils.getSelfTransformPenisGirthDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getSelfTransformPenisSizeDiv()
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformTesticleSizeDiv()
							+ CharacterModificationUtils.getSelfTransformTesticleCountDiv()
						+"</div>"
						
						+ CharacterModificationUtils.getSelfTransformCumProductionDiv()
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getInternalTesticleDiv()
							+ CharacterModificationUtils.getSelfTransformUrethraCapacityDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformUrethraElasticityDiv()
							+ CharacterModificationUtils.getSelfTransformUrethraPlasticityDiv()
						+"</div>"
						
						+"<div style='clear:left;'>"
							+ CharacterModificationUtils.getSelfTransformPenisModifiersDiv()
							+ CharacterModificationUtils.getSelfTransformUrethraModifiersDiv()
						+"</div>"
						;
			}
		}
		
		@Override
		public String getContent() {
			return "";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==6) {
				return new Response("Penis", "You are already in this screen!", null);
				
			} else {
				return getBodyChangingResponse(responseTab, index);
			}
		}

		@Override
		public DialogueNodeType getDialogueNodeType() {
			return DialogueNodeType.PHONE;
		}
	};
	
}
