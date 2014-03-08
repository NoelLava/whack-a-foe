package com.bulalo.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	public static Texture gameTexture;
	public static TextureRegion table;
	public static TextureRegion dummy1;
	public static TextureRegion dummy2;
	public static TextureRegion dummy3;
	public static TextureRegion dummy4;
	
	public static Texture tSTexture;
	public static TextureRegion titleBg;
	public static TextureRegion redButton;
	public static TextureRegion redPressed;
	public static TextureRegion yellowButton;
	public static TextureRegion yellowPressed;
	public static TextureRegion blueButton;
	public static TextureRegion bluePressed;
	
	public static Texture cSTexture;
	public static Texture woodTexture;
	public static Texture steelTexture;
	public static Texture carbonTexture;
	public static TextureRegion csBg;
	public static TextureRegion wood;
	public static TextureRegion steel;
	public static TextureRegion carbon;
	
	public static Animation dummyAnimation;
	public static Animation dummyDies;
	
	public static void load(){
		Texture.setEnforcePotImages(false);
		
		gameTexture = new Texture(Gdx.files.internal("data/GameScreenTexture.png"));
		gameTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		tSTexture = new Texture(Gdx.files.internal("data/TitleScreenTexture.png"));
		tSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		cSTexture = new Texture(Gdx.files.internal("data/CustomizeS.png"));
		cSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		woodTexture = new Texture(Gdx.files.internal("data/Wood.png"));
		woodTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		steelTexture = new Texture(Gdx.files.internal("data/Steel.png"));
		steelTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		carbonTexture = new Texture(Gdx.files.internal("data/Carbon.png"));
		carbonTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
			//TitleScreen Textures
		titleBg = new TextureRegion(tSTexture, 0, 0, 320, 512);
		titleBg.flip(false, true);
		
		redButton = new TextureRegion(tSTexture, 325, 0, 65, 65);
		redButton.flip(false, true);
		
		redPressed = new TextureRegion(tSTexture, 400, 0, 65, 65);
		redPressed.flip(false, true);
		
		yellowButton = new TextureRegion(tSTexture, 325, 75, 65, 65);
		yellowButton.flip(false, true);
		
		yellowPressed = new TextureRegion(tSTexture, 400, 75, 65, 65);
		yellowPressed.flip(false, true);
		
		blueButton = new TextureRegion(tSTexture, 325, 150, 65, 65);
		blueButton.flip(false, true);
		
		bluePressed = new TextureRegion(tSTexture, 400, 150, 65, 65);
		bluePressed.flip(false, true);
		
		//GameScreen Textures
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
		
		//CustomizeScreen Textures
		csBg = new TextureRegion(cSTexture, 0, 0, 512, 512);
		wood = new TextureRegion(woodTexture, 0, 0, 512, 512);
		steel = new TextureRegion(steelTexture, 0, 0, 320, 512);
		carbon = new TextureRegion(carbonTexture, 0, 0, 320, 512);
		
		csBg.flip(false, true);
		wood.flip(false, true);
		steel.flip(false, true);
		carbon.flip(false, true);
		
		TextureRegion[] dummies = {dummy1, dummy2, dummy3, dummy4};
		dummyAnimation = new Animation(0.025f, dummies);
		dummyAnimation.setPlayMode(Animation.NORMAL);
		dummyDies = new Animation(0.3f, dummies);
		dummyDies.setPlayMode(Animation.REVERSED);
	}
	
	public static void dispose() {
		//We must dispose of the textures when we are finished, beki si kim
		gameTexture.dispose();
		tSTexture.dispose();
		cSTexture.dispose();
		woodTexture.dispose();
		steelTexture.dispose();
		carbonTexture.dispose();
	}
}
