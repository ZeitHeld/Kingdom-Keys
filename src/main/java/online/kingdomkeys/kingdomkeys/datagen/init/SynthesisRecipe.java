package online.kingdomkeys.kingdomkeys.datagen.init;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.datagen.builder.SynthesisRecipeBuilder;
import online.kingdomkeys.kingdomkeys.datagen.provider.SynthesisRecipeProvider;
import online.kingdomkeys.kingdomkeys.lib.Strings;

public class SynthesisRecipe extends SynthesisRecipeProvider {
    public SynthesisRecipe(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, KingdomKeys.MODID, SynthesisRecipeBuilder::new, existingFileHelper);
    }

    @Override
    protected void registerRecipe() {
    	getBuilder(Strings.abaddonPlasma).output(Strings.abaddonPlasmaChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_WrithingStone,4).addMaterial(Strings.SM_SoothingCrystal,3);
    	getBuilder(Strings.abyssalTide).output(Strings.abyssalTideChain,1).addMaterial(Strings.SM_PulsingStone,3).addMaterial(Strings.SM_FrostShard,3);
    	getBuilder(Strings.allForOne).output(Strings.allForOneChain,1).addMaterial(Strings.SM_WellspringCrystal,1).addMaterial(Strings.SM_SoothingStone,3).addMaterial(Strings.SM_SoothingShard,2);
    	getBuilder(Strings.astralBlast).output(Strings.astralBlastChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_LucidStone,2).addMaterial(Strings.SM_BlazingShard,3);
    	getBuilder(Strings.aubade).output(Strings.aubadeChain,1).addMaterial(Strings.SM_BlazingStone,1).addMaterial(Strings.SM_BlazingShard,2).addMaterial(Strings.SM_BlazingCrystal,1);
    	getBuilder(Strings.bondOfFlame).output(Strings.bondOfFlameChain,1).addMaterial(Strings.SM_BlazingStone,3).addMaterial(Strings.SM_BlazingShard,5).addMaterial(Strings.SM_BlazingGem,2);
    	getBuilder(Strings.brightcrest).output(Strings.brightcrestChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_SoothingStone,3).addMaterial(Strings.SM_SoothingCrystal,1);
    	getBuilder(Strings.chaosRipper).output(Strings.chaosRipperChain,1).addMaterial(Strings.SM_LucidCrystal,1).addMaterial(Strings.SM_WrithingGem,2);
    	getBuilder(Strings.circleOfLife).output(Strings.circleOfLifeChain,1).addMaterial(Strings.SM_SoothingGem,3).addMaterial(Strings.SM_PulsingStone,3).addMaterial(Strings.SM_WellspringShard,3);
    	getBuilder(Strings.counterpoint).output(Strings.counterpointChain,1).addMaterial(Strings.SM_HungryStone,1).addMaterial(Strings.SM_WellspringCrystal,1).addMaterial(Strings.SM_SoothingShard,2);
    	getBuilder(Strings.crabclaw).output(Strings.crabclawChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_HungryStone,2).addMaterial(Strings.SM_LucidShard,2).addMaterial(Strings.SM_WellspringStone,1);
    	getBuilder(Strings.crownOfGuilt).output(Strings.crownOfGuiltChain,1).addMaterial(Strings.SM_TranquilityGem,1).addMaterial(Strings.SM_WrithingStone,2).addMaterial(Strings.SM_PulsingCrystal,2);
    	getBuilder(Strings.darkerThanDark).output(Strings.darkerThanDarkChain,1).addMaterial(Strings.SM_LucidCrystal,3).addMaterial(Strings.SM_WrithingCrystal,2).addMaterial(Strings.SM_WrithingGem,2);
    	getBuilder(Strings.darkgnaw).output(Strings.darkgnawChain,1).addMaterial(Strings.SM_WrithingCrystal,5).addMaterial(Strings.SM_LucidShard,5);
    	getBuilder(Strings.decisivePumpkin).output(Strings.decisivePumpkinChain,1).addMaterial(Strings.SM_FrostCrystal,3).addMaterial(Strings.SM_WrithingCrystal,3).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_WrithingGem,2);
    	getBuilder(Strings.destinysEmbrace).output(Strings.destinysEmbraceChain,1).addMaterial(Strings.SM_PulsingStone,3).addMaterial(Strings.SM_LightningStone,5).addMaterial(Strings.SM_SoothingCrystal,5).addMaterial(Strings.SM_LightningGem,5);
    	getBuilder(Strings.diamondDust).output(Strings.diamondDustChain,1).addMaterial(Strings.SM_PulsingStone,1).addMaterial(Strings.SM_FrostStone,5).addMaterial(Strings.SM_FrostGem,3);
    	getBuilder(Strings.divewing).output(Strings.divewingChain,1).addMaterial(Strings.SM_WellspringCrystal,3).addMaterial(Strings.SM_TwilightCrystal,3).addMaterial(Strings.SM_BlazingGem,2).addMaterial(Strings.SM_PulsingCrystal,3);
    	getBuilder(Strings.divineRose).output(Strings.divineRoseChain,1).addMaterial(Strings.SM_SoothingGem,4).addMaterial(Strings.SM_PulsingStone,4).addMaterial(Strings.SM_WellspringCrystal,3).addMaterial(Strings.SM_LucidShard,2);
    	getBuilder(Strings.dualDisc).output(Strings.dualDiscChain,1).addMaterial(Strings.SM_SoothingCrystal,2).addMaterial(Strings.SM_PulsingGem,5).addMaterial(Strings.SM_LightningGem,4);
    	getBuilder(Strings.earthshaker).output(Strings.earthshakerChain,1).addMaterial(Strings.SM_WrithingShard,5).addMaterial(Strings.SM_BetwixtStone,3).addMaterial(Strings.SM_WellspringShard,3);
    	getBuilder(Strings.endOfPain).output(Strings.endOfPainChain,1).addMaterial(Strings.SM_PulsingStone,3).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_WrithingShard,3).addMaterial(Strings.SM_WrithingGem,3);
    	getBuilder(Strings.endsOfTheEarth).output(Strings.endsOfTheEarthChain,1).addMaterial(Strings.SM_PulsingStone,3).addMaterial(Strings.SM_WrithingShard,3).addMaterial(Strings.SM_WrithingGem,1).addMaterial(Strings.SM_LucidGem,2);
    	getBuilder(Strings.fairyHarp).output(Strings.fairyHarpChain,1).addMaterial(Strings.SM_SoothingShard,3).addMaterial(Strings.SM_PulsingGem,2).addMaterial(Strings.SM_LucidGem,2);
    	getBuilder(Strings.fairyStars).output(Strings.fairyStarsChain,1).addMaterial(Strings.SM_SoothingShard,4).addMaterial(Strings.SM_PulsingGem,3).addMaterial(Strings.SM_WellspringShard,3);
    	getBuilder(Strings.fatalCrest).output(Strings.fatalCrestChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_WrithingGem,3).addMaterial(Strings.SM_BetwixtStone,3).addMaterial(Strings.SM_LightningShard, 1);
    	getBuilder(Strings.fenrir).output(Strings.fenrirChain,1).addMaterial(Strings.SM_TwilightGem,3).addMaterial(Strings.SM_PulsingStone,6).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_BetwixtShard,2);
    	getBuilder(Strings.ferrisGear).output(Strings.ferrisGearChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_LightningStone,2).addMaterial(Strings.SM_LucidGem,2);
    	getBuilder(Strings.flameLiberator).output(Strings.flameLiberatorChain,1).addMaterial(Strings.SM_BlazingGem,4).addMaterial(Strings.SM_BlazingStone,2).addMaterial(Strings.SM_BlazingShard,5);
    	getBuilder(Strings.followtheWind).output(Strings.followtheWindChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_BlazingShard,2);
    	getBuilder(Strings.frolicFlame).output(Strings.frolicFlameChain,1).addMaterial(Strings.SM_PulsingStone,1).addMaterial(Strings.SM_BlazingShard,3).addMaterial(Strings.SM_BlazingGem,2).addMaterial(Strings.SM_BlazingCrystal,1);
    	getBuilder(Strings.glimpseOfDarkness).output(Strings.glimpseOfDarknessChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_BetwixtCrystal,3).addMaterial(Strings.SM_WrithingGem,3).addMaterial(Strings.SM_PulsingCrystal,2);
    	getBuilder(Strings.guardianBell).output(Strings.guardianBellChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_LightningShard,3).addMaterial(Strings.SM_WellspringCrystal,2);
    	getBuilder(Strings.guardianSoul).output(Strings.guardianSoulChain,1).addMaterial(Strings.SM_PulsingStone,4).addMaterial(Strings.SM_WrithingShard,3).addMaterial(Strings.SM_LightningGem,3).addMaterial(Strings.SM_WellspringStone,1);
    	getBuilder(Strings.gullWing).output(Strings.gullWingChain,1).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_BlazingGem,2).addMaterial(Strings.SM_PulsingShard,5);
    	getBuilder(Strings.herosCrest).output(Strings.herosCrestChain,1).addMaterial(Strings.SM_SoothingStone,2).addMaterial(Strings.SM_LightningCrystal,2).addMaterial(Strings.SM_PulsingShard,3).addMaterial(Strings.SM_LightningGem,2);
    	getBuilder(Strings.hiddenDragon).output(Strings.hiddenDragonChain,1).addMaterial(Strings.SM_BlazingStone,1).addMaterial(Strings.SM_PulsingStone,3).addMaterial(Strings.SM_MythrilCrystal,4).addMaterial(Strings.SM_BlazingShard,4);
    	getBuilder(Strings.hyperdrive).output(Strings.hyperdriveChain,1).addMaterial(Strings.SM_WellspringCrystal,4).addMaterial(Strings.SM_FrostStone,2).addMaterial(Strings.SM_LucidGem,2);
    	getBuilder(Strings.incompleteKiblade).output(Strings.incompleteKibladeChain,1).addMaterial(Strings.SM_WrithingCrystal,1).addMaterial(Strings.SM_MythrilCrystal,1).addMaterial(Strings.SM_TwilightCrystal,1).addMaterial(Strings.SM_BetwixtCrystal,1).addMaterial(Strings.SM_BlazingCrystal,1).addMaterial(Strings.SM_PulsingCrystal,1);
    	getBuilder(Strings.jungleKing).output(Strings.jungleKingChain,1).addMaterial(Strings.SM_WellspringGem,3).addMaterial(Strings.SM_PulsingStone,4).addMaterial(Strings.SM_BetwixtShard,3);
    	getBuilder(Strings.keybladeOfPeoplesHearts).output(Strings.keybladeOfPeoplesHeartsChain,1).addMaterial(Strings.SM_WrithingCrystal,3).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_LostIllusion,1);
    	//TODO finish the kiblade recipe
    	getBuilder(Strings.kiblade).output(Strings.kibladeChain,1).addMaterial(Strings.incompleteKibladeChain,1).addMaterial(Strings.SM_Orichalcum,8).addMaterial(Strings.SM_OrichalcumPlus, 5).addMaterial(Strings.SM_BlazingCrystal, 2).addMaterial(Strings.SM_SoothingCrystal, 2).addMaterial(Strings.SM_WrithingCrystal, 2).addMaterial(Strings.SM_BetwixtCrystal, 2).addMaterial(Strings.SM_WellspringCrystal, 2).addMaterial(Strings.SM_FrostCrystal, 2).addMaterial(Strings.SM_LightningCrystal, 2).addMaterial(Strings.SM_LucidCrystal, 2).addMaterial(Strings.SM_MythrilCrystal, 2).addMaterial(Strings.SM_PulsingCrystal, 2);
    	getBuilder(Strings.kingdomKey).output(Strings.kingdomKeyChain,1).addMaterial(Strings.SM_PulsingStone,1).addMaterial(Strings.SM_PulsingShard,1);
    	getBuilder(Strings.kingdomKeyD).output(Strings.kingdomKeyDChain,1).addMaterial(Strings.SM_PulsingGem,1).addMaterial(Strings.SM_PulsingShard,1);
    	getBuilder(Strings.knockoutPunch).output(Strings.knockoutPunchChain,1).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_SoothingStone,2).addMaterial(Strings.SM_MythrilGem,1);
    	getBuilder(Strings.ladyLuck).output(Strings.ladyLuckChain,1).addMaterial(Strings.SM_PulsingStone,4).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_HungryShard,1).addMaterial(Strings.SM_BlazingGem,2);
    	getBuilder(Strings.leviathan).output(Strings.leviathanChain,1).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_FrostStone,2).addMaterial(Strings.SM_WrithingShard,3);
    	getBuilder(Strings.lionheart).output(Strings.lionheartChain,1).addMaterial(Strings.SM_BetwixtCrystal,3).addMaterial(Strings.SM_TwilightCrystal,3).addMaterial(Strings.SM_BlazingGem,5).addMaterial(Strings.SM_PulsingCrystal,2);
    	getBuilder(Strings.lostMemory).output(Strings.lostMemoryChain,1).addMaterial(Strings.SM_TwilightGem,3).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_HungryShard,1).addMaterial(Strings.SM_MythrilGem,3);
    	getBuilder(Strings.lunarEclipse).output(Strings.lunarEclipseChain,1).addMaterial(Strings.SM_SoothingGem,5).addMaterial(Strings.SM_FrostGem,2).addMaterial(Strings.SM_WrithingGem,5).addMaterial(Strings.SM_PulsingCrystal,2);
    	getBuilder(Strings.markOfAHero).output(Strings.markOfAHeroChain,1).addMaterial(Strings.SM_LightningShard,3).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_SoothingCrystal,3).addMaterial(Strings.SM_LightningGem,3);
    	getBuilder(Strings.mastersDefender).output(Strings.mastersDefenderChain,1).addMaterial(Strings.SM_TwilightGem,10).addMaterial(Strings.SM_MythrilCrystal,4).addMaterial(Strings.SM_TwilightCrystal,7).addMaterial(Strings.SM_PulsingGem,5);
    	getBuilder(Strings.maverickFlare).output(Strings.maverickFlareChain,1).addMaterial(Strings.SM_BlazingShard,3).addMaterial(Strings.SM_BlazingGem,3).addMaterial(Strings.SM_WellspringStone,3);
    	getBuilder(Strings.metalChocobo).output(Strings.metalChocoboChain,1).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_PulsingStone,5).addMaterial(Strings.SM_BetwixtCrystal,3).addMaterial(Strings.SM_WellspringShard,1);
    	getBuilder(Strings.midnightRoar).output(Strings.midnightRoarChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_WrithingCrystal,2);
    	getBuilder(Strings.mirageSplit).output(Strings.mirageSplitChain,1).addMaterial(Strings.SM_WrithingStone,2).addMaterial(Strings.SM_WrithingCrystal,4).addMaterial(Strings.SM_WrithingShard,3).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_WrithingGem,6);
    	getBuilder(Strings.missingAche).output(Strings.missingAcheChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_SoothingStone,3).addMaterial(Strings.SM_WellspringShard,2);
    	getBuilder(Strings.monochrome).output(Strings.monochromeChain,1).addMaterial(Strings.SM_LucidStone,3).addMaterial(Strings.SM_WrithingStone,2).addMaterial(Strings.SM_PulsingShard,2);
    	getBuilder(Strings.moogleOGlory).output(Strings.moogleOGloryChain,1).addMaterial(Strings.SM_LucidGem,3).addMaterial(Strings.SM_WellspringStone,3).addMaterial(Strings.SM_PulsingCrystal,5);
    	getBuilder(Strings.mysteriousAbyss).output(Strings.mysteriousAbyssChain,1).addMaterial(Strings.SM_FrostCrystal,1).addMaterial(Strings.SM_FrostShard,2).addMaterial(Strings.SM_FrostStone,5).addMaterial(Strings.SM_FrostGem,2);
    	getBuilder(Strings.nightmaresEnd).output(Strings.nightmaresEndChain,1).addMaterial(Strings.SM_SoothingGem,6).addMaterial(Strings.SM_SoothingStone,2).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_SoothingShard,3).addMaterial(Strings.SM_SoothingCrystal,4);
    	getBuilder(Strings.nightmaresEndAndMirageSplit).output(Strings.nightmaresEndAndMirageSplitChain,1).addMaterial(Strings.nightmaresEndChain,1).addMaterial(Strings.mirageSplitChain,1);
    	getBuilder(Strings.noName).output(Strings.noNameChain,1).addMaterial(Strings.SM_FrostShard,3).addMaterial(Strings.SM_FrostGem,2).addMaterial(Strings.SM_WrithingGem,3);
    	getBuilder(Strings.noNameBBS).output(Strings.noNameBBSChain,1).addMaterial(Strings.SM_FrostShard,3).addMaterial(Strings.SM_FrostGem,2).addMaterial(Strings.SM_WrithingGem,3);
    	getBuilder(Strings.oathkeeper).output(Strings.oathkeeperChain,1).addMaterial(Strings.SM_MythrilCrystal,3).addMaterial(Strings.SM_TwilightStone,4).addMaterial(Strings.SM_PulsingGem,3);
    	getBuilder(Strings.oblivion).output(Strings.oblivionChain,1).addMaterial(Strings.SM_WrithingCrystal,2).addMaterial(Strings.SM_PulsingStone,5).addMaterial(Strings.SM_WrithingGem,4).addMaterial(Strings.SM_BetwixtGem,3);
    	getBuilder(Strings.oceansRage).output(Strings.oceansRageChain,1).addMaterial(Strings.SM_LightningStone,5).addMaterial(Strings.SM_FrostShard,5);
    	getBuilder(Strings.olympia).output(Strings.olympiaChain,1).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_SoothingShard,2).addMaterial(Strings.SM_LightningCrystal,1).addMaterial(Strings.SM_LightningGem,2);
    	getBuilder(Strings.omegaWeapon).output(Strings.omegaWeaponChain,1).addMaterial(Strings.SM_TwilightCrystal,1).addMaterial(Strings.SM_MythrilGem,2).addMaterial(Strings.SM_WrithingGem,2).addMaterial(Strings.SM_PulsingCrystal,3);
    	getBuilder(Strings.ominousBlight).output(Strings.ominousBlightChain,1).addMaterial(Strings.SM_WrithingStone,2).addMaterial(Strings.SM_SoothingStone,2).addMaterial(Strings.SM_PulsingGem,2);
    	getBuilder(Strings.oneWingedAngel).output(Strings.oneWingedAngelChain,1).addMaterial(Strings.SM_BlazingStone,1).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_BlazingGem,3).addMaterial(Strings.SM_BlazingCrystal,5);
    	getBuilder(Strings.painOfSolitude).output(Strings.painOfSolitudeChain,1).addMaterial(Strings.SM_WrithingCrystal,2).addMaterial(Strings.SM_BetwixtShard,2).addMaterial(Strings.SM_TwilightStone,1).addMaterial(Strings.SM_PulsingShard,2);
    	getBuilder(Strings.photonDebugger).output(Strings.photonDebuggerChain,1).addMaterial(Strings.SM_LightningShard,4).addMaterial(Strings.SM_LightningCrystal,2).addMaterial(Strings.SM_LightningGem,3);
    	getBuilder(Strings.pixiePetal).output(Strings.pixiePetalChain,1).addMaterial(Strings.SM_LucidStone,2).addMaterial(Strings.SM_SoothingShard,2).addMaterial(Strings.SM_PulsingGem,2);
    	getBuilder(Strings.pumpkinhead).output(Strings.pumpkinheadChain,1).addMaterial(Strings.SM_WrithingCrystal,2).addMaterial(Strings.SM_PulsingGem,3).addMaterial(Strings.SM_LucidShard,5);
    	getBuilder(Strings.rainfell).output(Strings.rainfellChain,1).addMaterial(Strings.SM_WrithingStone,2).addMaterial(Strings.SM_FrostStone,1).addMaterial(Strings.SM_LucidShard,5).addMaterial(Strings.SM_StormyGem,1);
    	getBuilder(Strings.rejectionOfFate).output(Strings.rejectionOfFateChain,1).addMaterial(Strings.SM_TwilightGem,2).addMaterial(Strings.SM_WrithingStone,2).addMaterial(Strings.SM_TwilightCrystal,3);
    	getBuilder(Strings.royalRadiance).output(Strings.royalRadianceChain,1).addMaterial(Strings.SM_PulsingStone,5).addMaterial(Strings.SM_FrostShard,2).addMaterial(Strings.SM_SoothingStone,3);
    	getBuilder(Strings.rumblingRose).output(Strings.rumblingRoseChain,1).addMaterial(Strings.SM_PulsingStone,4).addMaterial(Strings.SM_SoothingShard,2).addMaterial(Strings.SM_LucidGem,3).addMaterial(Strings.SM_WellspringStone,2);
    	getBuilder(Strings.signOfInnocence).output(Strings.signOfInnocenceChain,1).addMaterial(Strings.SM_TwilightGem,2).addMaterial(Strings.SM_TwilightCrystal,1).addMaterial(Strings.SM_WrithingShard,3);
    	getBuilder(Strings.silentDirge).output(Strings.silentDirgeChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_TwilightCrystal,2).addMaterial(Strings.SM_WrithingShard,1);
    	getBuilder(Strings.skullNoise).output(Strings.skullNoiseChain,1).addMaterial(Strings.SM_WrithingCrystal,3).addMaterial(Strings.SM_LostIllusion,1).addMaterial(Strings.SM_WrithingGem,2).addMaterial(Strings.SM_WellspringShard,3);
    	getBuilder(Strings.sleepingLion).output(Strings.sleepingLionChain,1).addMaterial(Strings.SM_TwilightGem,1).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_TranquilityCrystal,2).addMaterial(Strings.SM_BlazingShard,4);
    	getBuilder(Strings.soulEater).output(Strings.soulEaterChain,1).addMaterial(Strings.SM_WrithingCrystal,3).addMaterial(Strings.SM_PulsingStone,5).addMaterial(Strings.SM_WrithingGem,5).addMaterial(Strings.SM_PulsingCrystal,3);
    	getBuilder(Strings.spellbinder).output(Strings.spellbinderChain,1).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_FrostStone,2).addMaterial(Strings.SM_PulsingGem,2);
    	getBuilder(Strings.starSeeker).output(Strings.starSeekerChain,1).addMaterial(Strings.SM_TwilightStone,5).addMaterial(Strings.SM_BetwixtShard,3).addMaterial(Strings.SM_PulsingShard,2);
    	getBuilder(Strings.starlight).output(Strings.starlightChain,1).addMaterial(Strings.SM_MythrilStone,3).addMaterial(Strings.SM_MythrilCrystal,3).addMaterial(Strings.SM_MythrilShard,3).addMaterial(Strings.SM_MythrilGem,3);
    	getBuilder(Strings.stormfall).output(Strings.stormfallChain,1).addMaterial(Strings.SM_StormyStone,2).addMaterial(Strings.SM_StormyCrystal,1).addMaterial(Strings.SM_SoothingStone,3).addMaterial(Strings.SM_WrithingGem,2).addMaterial(Strings.SM_PulsingCrystal,3);
    	getBuilder(Strings.strokeOfMidnight).output(Strings.strokeOfMidnightChain,1).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_FrostShard,2).addMaterial(Strings.SM_BetwixtShard,1).addMaterial(Strings.SM_SoothingCrystal,3);
    	getBuilder(Strings.sweetDreams).output(Strings.sweetDreamsChain,1).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_TwilightShard,4).addMaterial(Strings.SM_BetwixtShard,2);
    	getBuilder(Strings.sweetMemories).output(Strings.sweetMemoriesChain,1).addMaterial(Strings.SM_WellspringCrystal,3).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_LucidShard,4).addMaterial(Strings.SM_RemembranceGem,1);
    	getBuilder(Strings.sweetstack).output(Strings.sweetstackChain,1).addMaterial(Strings.SM_PulsingStone,4).addMaterial(Strings.SM_BlazingCrystal,2).addMaterial(Strings.SM_LucidGem,1).addMaterial(Strings.SM_WellspringShard,3);
    	getBuilder(Strings.threeWishes).output(Strings.threeWishesChain,1).addMaterial(Strings.SM_LucidGem,3).addMaterial(Strings.SM_WellspringStone,3).addMaterial(Strings.SM_PulsingCrystal,5);
    	getBuilder(Strings.totalEclipse).output(Strings.totalEclipseChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_BlazingShard,2).addMaterial(Strings.SM_BlazingGem,2);
    	getBuilder(Strings.treasureTrove).output(Strings.treasureTroveChain,1).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_FrostCrystal,2).addMaterial(Strings.SM_WrithingCrystal,1).addMaterial(Strings.SM_SoothingCrystal,2).addMaterial(Strings.SM_BlazingCrystal,2);
    	getBuilder(Strings.trueLightsFlight).output(Strings.trueLightsFlightChain,1).addMaterial(Strings.SM_TwilightGem,3).addMaterial(Strings.SM_TwilightShard,3).addMaterial(Strings.SM_LostIllusion,1);
    	getBuilder(Strings.twilightBlaze).output(Strings.twilightBlazeChain,1).addMaterial(Strings.SM_TwilightCrystal,3).addMaterial(Strings.SM_BlazingCrystal,3);
    	getBuilder(Strings.twoBecomeOne).output(Strings.twoBecomeOneChain,1).addMaterial(Strings.SM_TwilightGem,2).addMaterial(Strings.SM_TwilightCrystal,3).addMaterial(Strings.SM_LostIllusion,1);
    	getBuilder(Strings.ultimaWeaponBBS).output(Strings.ultimaWeaponBBSChain,1).addMaterial(Strings.SM_MythrilCrystal,1).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_OrichalcumPlus,9).addMaterial(Strings.SM_HungryCrystal,5).addMaterial(Strings.SM_LightningGem,1);
    	getBuilder(Strings.ultimaWeaponDDD).output(Strings.ultimaWeaponDDDChain,1).addMaterial(Strings.SM_TwilightGem,4).addMaterial(Strings.SM_TwilightCrystal,3).addMaterial(Strings.SM_BetwixtCrystal,2).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_TwilightStone,5);
    	getBuilder(Strings.ultimaWeaponKH1).output(Strings.ultimaWeaponKH1Chain,1).addMaterial(Strings.SM_StormyStone,3).addMaterial(Strings.SM_HungryStone,5).addMaterial(Strings.SM_LostIllusion,1).addMaterial(Strings.SM_LightningGem,5).addMaterial(Strings.SM_HungryCrystal,5);
    	getBuilder(Strings.ultimaWeaponKH2).output(Strings.ultimaWeaponKH2Chain,1).addMaterial(Strings.SM_MythrilCrystal,1).addMaterial(Strings.SM_BetwixtCrystal,1).addMaterial(Strings.SM_TwilightCrystal,1).addMaterial(Strings.SM_Orichalcum,1).addMaterial(Strings.SM_OrichalcumPlus,13).addMaterial(Strings.SM_HungryCrystal,7);
    	getBuilder(Strings.ultimaWeaponKH3).output(Strings.ultimaWeaponKH3Chain,1).addMaterial(Strings.SM_OrichalcumPlus,7).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_PulsingCrystal,2);
    	getBuilder(Strings.umbrella).output(Strings.umbrellaChain,1).addMaterial(Strings.SM_TwilightShard,1).addMaterial(Strings.SM_MythrilShard,10);
    	getBuilder(Strings.unbound).output(Strings.unboundChain,1).addMaterial(Strings.SM_TwilightGem,5).addMaterial(Strings.SM_MythrilCrystal,3).addMaterial(Strings.SM_BetwixtGem,5).addMaterial(Strings.SM_PulsingCrystal,3);
    	getBuilder(Strings.victoryLine).output(Strings.victoryLineChain,1).addMaterial(Strings.SM_SoothingStone,3).addMaterial(Strings.SM_LucidGem,2).addMaterial(Strings.SM_PulsingCrystal,3);
    	getBuilder(Strings.voidGear).output(Strings.voidGearChain,1).addMaterial(Strings.SM_WrithingShard,1).addMaterial(Strings.SM_PulsingGem,2).addMaterial(Strings.SM_PulsingShard,5).addMaterial(Strings.SM_LucidShard,1);
    	getBuilder(Strings.wayToTheDawn).output(Strings.wayToTheDawnChain,1).addMaterial(Strings.SM_WrithingCrystal,1).addMaterial(Strings.SM_HungryGem,4).addMaterial(Strings.SM_TwilightCrystal,1).addMaterial(Strings.SM_PulsingCrystal,2);
    	getBuilder(Strings.waywardWind).output(Strings.waywardWindChain,1).addMaterial(Strings.SM_WrithingShard,2).addMaterial(Strings.SM_PulsingShard,2).addMaterial(Strings.SM_StormyShard,1);
    	getBuilder(Strings.wishingLamp).output(Strings.wishingLampChain,1).addMaterial(Strings.SM_WellspringStone,3).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_PulsingCrystal,3).addMaterial(Strings.SM_BetwixtGem, 2);
    	getBuilder(Strings.winnersProof).output(Strings.winnersProofChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_TranquilityShard,4).addMaterial(Strings.SM_WrithingShard,5);
    	getBuilder(Strings.wishingStar).output(Strings.wishingStarChain,1).addMaterial(Strings.SM_SoothingGem,2).addMaterial(Strings.SM_PulsingStone,2).addMaterial(Strings.SM_MythrilCrystal,2);
    	getBuilder(Strings.youngXehanortsKeyblade).output(Strings.youngXehanortsKeybladeChain,1).addMaterial(Strings.SM_LucidCrystal,3).addMaterial(Strings.SM_WrithingCrystal,10).addMaterial(Strings.SM_FrostShard,5).addMaterial(Strings.SM_MythrilCrystal,3).addMaterial(Strings.SM_WrithingGem,10);
    	getBuilder(Strings.zeroOne).output(Strings.zeroOneChain,1).addMaterial(Strings.SM_LightningCrystal,3).addMaterial(Strings.SM_PulsingGem,4).addMaterial(Strings.SM_LightningStone,2);
    	
        //getBuilder(Strings.woodenKeyblade).output(Strings.woodenKeybladeChain,1).addMaterial(Strings.SM_Item.swordWood,1);
        //getBuilder(Strings.fatalCrest).output(Strings.fatalCrestChain,1).addMaterial(Strings.SM_WrithingStone,3).addMaterial(Strings.SM_LightningShard,1).addMaterial(Strings.SM_BetwixtStone,3).addMaterial(Strings.SM_WrithingGem,3);
        //getBuilder(Strings.wishingLamp).output(Strings.wishingLampChain,1).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_BetwixtGem,2).addMaterial(Strings.SM_WellspringStone,3).addMaterial(Strings.SM_PulsingCrystal,3);
        //getBuilder(Strings.nightmaresEndAndMirageSplit).output(Strings.nightmaresEndAndMirageSplitChain,1).addMaterial(Strings.SM_Item.miragesplitchain,1).addMaterial(Strings.SM_Item.nightmaresendchain,1);
        //getBuilder(Strings.woodenStick).output(Strings.woodenStickChain,1).addMaterial(Strings.SM_Item.stick,3);
        //getBuilder(Strings.kiblade).output(Strings.kibladeChain,1).addMaterial(Strings.SM_FrostCrystal,2).addMaterial(Strings.SM_RemembranceCrystal,2).addMaterial(Strings.SM_WellspringCrystal,2).addMaterial(Strings.SM_StormyCrystal,2).addMaterial(Strings.SM_Item.incompletekibladechain,1).addMaterial(Strings.SM_Orichalcum+,5).addMaterial(Strings.SM_SoothingCrystal,2).addMaterial(Strings.SM_LightningCrystal,2).addMaterial(Strings.SM_BlazingCrystal,2).addMaterial(Strings.SM_HungryCrystal,2).addMaterial(Strings.SM_LucidCrystal,2).addMaterial(Strings.SM_WrithingCrystal,2).addMaterial(Strings.SM_TranquilityCrystal,2).addMaterial(Strings.SM_Manifestillusion,1).addMaterial(Strings.SM_MythrilCrystal,2).addMaterial(Strings.SM_BetwixtCrystal,2).addMaterial(Strings.SM_TwilightCrystal,2).addMaterial(Strings.SM_Orichalcum,8).addMaterial(Strings.SM_LostIllusion,1).addMaterial(Strings.SM_PulsingCrystal,2);
        //getBuilder(Strings.zeroOne).output(Strings.zeroOneChain,1).addMaterial(Strings.SM_SoothingGem,3).addMaterial(Strings.SM_Tile.hardblox,1).addMaterial(Strings.SM_Tile.normalblox,1).addMaterial(Strings.SM_Tile.metalblox,1).addMaterial(Strings.SM_PulsingCrystal,2);
    }
}
