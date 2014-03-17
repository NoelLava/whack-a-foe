package com.bulalo.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	public static Texture gameTexture;
	public static Texture hammerAngles;
	public static TextureRegion table;
	public static TextureRegion dummy1;
	public static TextureRegion dummy2;
	public static TextureRegion dummy3;
	public static TextureRegion dummy4;
	public static TextureRegion HamWoodLeft, HamWoodMid, HamWoodRight;
	public static TextureRegion HamSteelLeft, HamSteelMid, HamSteelRight;
	public static TextureRegion HamGoldLeft, HamGoldMid, HamGoldRight;
	public static TextureRegion gameLogo, timeScore;
	
	public static Texture tSTexture;
	public static TextureRegion titleBg;
	public static TextureRegion redButton;
	public static TextureRegion redPressed;
	public static TextureRegion yellowButton;
	public static TextureRegion yellowPressed;
	public static TextureRegion blueButton;
	public static TextureRegion bluePressed;
	public static TextureRegion backButton;
	public static TextureRegion backPressed;
	public static TextureRegion pauseButton;
	public static TextureRegion pausePressed;

	public static Texture cSTexture;
	public static Texture woodTexture;
	public static Texture steelTexture;
	public static Texture carbonTexture;
	public static TextureRegion csBg;
	public static TextureRegion wood;
	public static TextureRegion steel;
	public static TextureRegion carbon;
	public static TextureRegion background;

	public static Texture sSTexture;
	public static TextureRegion ssBg;
	public static TextureRegion kahoy;
	public static TextureRegion bakal;
	public static TextureRegion ginto;

	public static Animation dummyAnimation, dummyDies;
	public static Animation tableScreen;

	public static Texture dummy;
	public static TextureRegion dummyJanitor;
	public static TextureRegion dummyDefault;
	public static TextureRegion dummyOffice;
	
	public static Texture splashScreen;
	public static TextureRegion bulalo;
	
	public static Sound gameStart, hitSmash, buttonDown, buttonUp, bulaloil;
	public static Sound gameOver, hitEmpty, hitFriend, hitFunny;
	public static Music titleMusic, gameMusic, gameMusic2;
	
	public static BitmapFont digital, digitalShadow, bit;

	public static void load() {
		Texture.setEnforcePotImages(false);

		gameTexture = new Texture(
				Gdx.files.internal("data/GameScreenTexture.png"));
		gameTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		hammerAngles = new Texture(
				Gdx.files.internal("data/HammerAngleTexture.png"));
		hammerAngles.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		dummy = new Texture(Gdx.files.internal("data/dummies.png"));
		dummy.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		tSTexture = new Texture(
				Gdx.files.internal("data/TitleScreenTexture.png"));
		tSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cSTexture = new Texture(
				Gdx.files.internal("data/CustomScreenTexture.png"));
		cSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		woodTexture = new Texture(Gdx.files.internal("data/Wood.png"));
		woodTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		steelTexture = new Texture(Gdx.files.internal("data/Steel.png"));
		steelTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		carbonTexture = new Texture(Gdx.files.internal("data/Carbon.png"));
		carbonTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		sSTexture = new Texture(
				Gdx.files.internal("data/ShopScreenTexture.png"));
		sSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		splashScreen = new Texture(Gdx.files.internal("data/WaFSplash.png"));
		splashScreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		bulalo = new TextureRegion(splashScreen, 0, 0, 335, 512);
		
		// Sounds ==========================================================================================

		gameStart = Gdx.audio.newSound(Gdx.files.internal("sfx/playSFX.mp3"));
		hitSmash = Gdx.audio.newSound(Gdx.files.internal("sfx/smashSFX.mp3"));
		buttonDown = Gdx.audio.newSound(Gdx.files.internal("sfx/buttonDown.mp3"));
		buttonUp = Gdx.audio.newSound(Gdx.files.internal("sfx/buttonUp.mp3"));
		bulaloil = Gdx.audio.newSound(Gdx.files.internal("sfx/boil1.mp3"));
		gameOver = Gdx.audio.newSound(Gdx.files.internal("sfx/clear2.mp3"));
		hitEmpty = Gdx.audio.newSound(Gdx.files.internal("sfx/SFX1.mp3"));
		hitFriend = Gdx.audio.newSound(Gdx.files.internal("sfx/SFX3.mp3"));
		hitFunny = Gdx.audio.newSound(Gdx.files.internal("sfx/SFX4.mp3"));
		
		titleMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menuBGM1.mp3"));
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music/playBGM1.mp3"));
		gameMusic2 = Gdx.audio.newMusic(Gdx.files.internal("music/playBGM2.mp3"));
		
		
		// TitleScreen Textures ==========================================================================================
		titleBg = new TextureRegion(tSTexture, 0, 0, 320, 512);
		titleBg.flip(false, true);

		redButton = new TextureRegion(tSTexture, 330, 0, 86, 82);
		redPressed = new TextureRegion(tSTexture, 420, 0, 86, 82);
		yellowButton = new TextureRegion(tSTexture, 330, 82, 86, 82);
		yellowPressed = new TextureRegion(tSTexture, 420, 82, 86, 82);
		blueButton = new TextureRegion(tSTexture, 330, 164, 86, 82);
		bluePressed = new TextureRegion(tSTexture, 420, 164, 86, 82);
		backButton = new TextureRegion(tSTexture, 330, 246, 86, 82);
		backPressed = new TextureRegion(tSTexture, 420, 246, 86, 82);
		pauseButton = new TextureRegion(tSTexture, 330, 328, 86, 82);
		pausePressed = new TextureRegion(tSTexture, 420, 328, 86, 82);

		redButton.flip(false, true);
		redPressed.flip(false, true);
		yellowButton.flip(false, true);
		yellowPressed.flip(false, true);
		blueButton.flip(false, true);
		bluePressed.flip(false, true);
		backButton.flip(false, true);
		backPressed.flip(false, true);
		pauseButton.flip(false, true);
		pausePressed.flip(false, true);

		// GameScreen Textures ==========================================================================================
		table = new TextureRegion(gameTexture, 0, 0, 320, 512);
		table.flip(false, true);

		dummy1 = new TextureRegion(gameTexture, 320, 0, 65, 95);
		dummy2 = new TextureRegion(gameTexture, 385, 0, 65, 95);
		dummy3 = new TextureRegion(gameTexture, 320, 95, 65, 95);
		dummy4 = new TextureRegion(gameTexture, 385, 95, 65, 95);

		dummy1.flip(false, true);
		dummy2.flip(false, true);
		dummy3.flip(false, true);
		dummy4.flip(false, true);

		HamWoodLeft = new TextureRegion(hammerAngles, 0, 0, 107, 170);
		HamWoodMid = new TextureRegion(hammerAngles, 107, 0, 107, 170);
		HamWoodRight = new TextureRegion(hammerAngles, 214, 0, 107, 170);
		HamSteelLeft = new TextureRegion(hammerAngles, 0, 170, 107, 170);
		HamSteelMid = new TextureRegion(hammerAngles, 107, 170, 107, 170);
		HamSteelRight = new TextureRegion(hammerAngles, 214, 170, 107, 170);
		HamGoldLeft = new TextureRegion(hammerAngles, 0, 340, 107, 170);
		HamGoldMid = new TextureRegion(hammerAngles, 107, 340, 107, 170);
		HamGoldRight = new TextureRegion(hammerAngles, 214, 340, 107, 170);
		
		HamWoodLeft.flip(false, true);
		HamWoodMid.flip(false, true);
		HamWoodRight.flip(false, true);
		HamSteelLeft.flip(false, true);
		HamSteelMid.flip(false, true);
		HamSteelRight.flip(false, true);
		HamGoldLeft.flip(false, true);
		HamGoldMid.flip(false, true);
		HamGoldRight.flip(false, true);
		
		gameLogo = new TextureRegion(gameTexture, 320, 207, 188, 77);
		timeScore = new TextureRegion(gameTexture, 320, 305, 188, 77);
		
		gameLogo.flip(false, true);
		timeScore.flip(false, true);
		
		TextureRegion[] timeLogo = {timeScore, gameLogo};
		tableScreen = new Animation(2f, timeLogo);
		tableScreen.setPlayMode(Animation.LOOP);

		// CustomizeScreen Textures ==========================================================================================
		csBg = new TextureRegion(cSTexture, 0, 0, 320, 512);
		wood = new TextureRegion(woodTexture, 0, 0, 512, 512);
		steel = new TextureRegion(steelTexture, 0, 0, 320, 512);
		carbon = new TextureRegion(carbonTexture, 0, 0, 320, 512);

		dummyJanitor = new TextureRegion(dummy, 184, 0, 65, 95);
		dummyOffice = new TextureRegion(dummy, 184, 83, 65, 95);
		dummyDefault = new TextureRegion(dummy, 176, 173, 65, 95);

		dummyJanitor.flip(false, true);
		dummyOffice.flip(false, true);
		dummyDefault.flip(false, true);
		csBg.flip(false, true);
		wood.flip(false, true);
		steel.flip(false, true);
		carbon.flip(false, true);

		// ShopScreen Textures ==========================================================================================
		ssBg = new TextureRegion(sSTexture, 0, 0, 320, 512);
		kahoy = new TextureRegion(sSTexture, 320, 130, 95, 130);
		bakal = new TextureRegion(sSTexture, 320, 0, 95, 130);
		ginto = new TextureRegion(sSTexture, 414, 0, 97, 130);

		ssBg.flip(false, true);
		kahoy.flip(false, true);
		bakal.flip(false, true);
		ginto.flip(false, true);
		
		// Fonts ===============================================================================================
		
		digital = new BitmapFont(Gdx.files.internal("font/Digital.fnt"));
		digitalShadow = new BitmapFont(Gdx.files.internal("font/DigitalShadow.fnt"));
		bit = new BitmapFont(Gdx.files.internal("font/8bit.fnt"));
		
		digital.setScale(.5f, -.5f);
		digitalShadow.setScale(.5f, -.5f);
		bit.setScale(.25f, -.25f);
		
		// Animations ==========================================================================================
		TextureRegion[] dummies = { dummy1, dummy2, dummy3, dummy4 };
		dummyAnimation = new Animation(0.03f, dummies);
		dummyAnimation.setPlayMode(Animation.NORMAL);
		TextureRegion[] dummyRev = { dummy4, dummy3, dummy2, dummy1 };
		dummyDies = new Animation(0.03f, dummyRev);
		dummyDies.setPlayMode(Animation.NORMAL);

	}

	public static void dispose() {
		// We must dispose of the textures when we are finished
		gameTexture.dispose();
		tSTexture.dispose();
		sSTexture.dispose();
		cSTexture.dispose();
		woodTexture.dispose();
		steelTexture.dispose();
		carbonTexture.dispose();
		hammerAngles.dispose();
		splashScreen.dispose();
		
		gameStart.dispose();
		hitSmash.dispose();
		buttonDown.dispose();
		buttonUp.dispose();
		bulaloil.dispose();
		gameOver.dispose();
		hitEmpty.dispose();
		hitFriend.dispose();
		hitFunny.dispose();
		titleMusic.dispose();
		gameMusic.dispose();
		gameMusic2.dispose();
		
		digital.dispose();
		digitalShadow.dispose();
		bit.dispose();
	}
}
