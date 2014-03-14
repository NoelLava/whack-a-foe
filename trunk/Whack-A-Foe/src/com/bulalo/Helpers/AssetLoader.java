package com.bulalo.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.GameObjects.Tables;

public class AssetLoader {
	public static Texture gameTexture;
	public static TextureRegion table;
	public static TextureRegion dummy1;
	public static TextureRegion dummy2;
	public static TextureRegion dummy3;
	public static TextureRegion dummy4;

	private static Tables table1;
	private static CustomWorld custom = new CustomWorld();

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

	public static Texture shopTexture;
	public static TextureRegion shopBg;
	public static TextureRegion hammer;
	public static TextureRegion hammer1;
	public static TextureRegion hammer2;

	public static Animation dummyAnimation;
	public static Animation dummyDies;

	public static void load() {
		Texture.setEnforcePotImages(false);

		gameTexture = new Texture(
				Gdx.files.internal("data/GameScreenTexture.png"));
		gameTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		tSTexture = new Texture(
				Gdx.files.internal("data/TitleScreenTexture.png"));
		tSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		cSTexture = new Texture(Gdx.files.internal("data/CustomScreenTexture.png"));
		cSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		woodTexture = new Texture(Gdx.files.internal("data/Wood.png"));
		woodTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		steelTexture = new Texture(Gdx.files.internal("data/Steel.png"));
		steelTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		carbonTexture = new Texture(Gdx.files.internal("data/Carbon.png"));
		carbonTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		shopTexture = new Texture(Gdx.files.internal("data/ShopScreenTexture.png"));
		shopTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		// TitleScreen Textures
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

		// GameScreen Textures
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

		// CustomizeScreen Textures
		csBg = new TextureRegion(cSTexture, 0, 0, 320, 512);
		wood = new TextureRegion(woodTexture, 0, 0, 512, 512);
		steel = new TextureRegion(steelTexture, 0, 0, 320, 512);
		carbon = new TextureRegion(carbonTexture, 0, 0, 320, 512);

		csBg.flip(false, true);
		wood.flip(false, true);
		steel.flip(false, true);
		carbon.flip(false, true);

		// ShopScreen Textures
		shopBg = new TextureRegion(shopTexture, 0, 0, 320, 512);
		shopBg.flip(false, true);
		
		hammer = new TextureRegion(shopTexture, 0, 0, 512, 512);
		hammer1 = new TextureRegion(shopTexture, 20, 0, 512, 512);
		hammer2 = new TextureRegion(shopTexture, 40, 0, 320, 512);

		hammer.flip(false, true);
		hammer1.flip(false, true);
		hammer2.flip(false, true);

		// Animations
		TextureRegion[] dummies = { dummy1, dummy2, dummy3, dummy4 };
		dummyAnimation = new Animation(0.03f, dummies);
		dummyAnimation.setPlayMode(Animation.NORMAL);
		TextureRegion[] dummyRev = { dummy4, dummy3, dummy2, dummy1 };
		dummyDies = new Animation(0.03f, dummyRev);
		dummyDies.setPlayMode(Animation.NORMAL);

	}

	/*
	 * public static TextureRegion getBackground(){ table1 = custom.getTable();
	 * table2 = custom.getTable1(); table3 = custom.getTable2();
	 * if(table1.onClick(20, 50)){ System.out.println("changed to wood");
	 * background = AssetLoader.wood; } else if(table2.onClick1(60, 50)){
	 * System.out.println("changed to carbon"); background=AssetLoader.carbon; }
	 * else if (table3.onClick2(100, 50)){
	 * System.out.println("changed to steel"); background=AssetLoader.steel; }
	 * System.out.println("enter"); return background; }
	 */

	public static void dispose() {
		// We must dispose of the textures when we are finished
		gameTexture.dispose();
		tSTexture.dispose();
		shopTexture.dispose();
		// cSTexture.dispose();
		// woodTexture.dispose();
		// steelTexture.dispose();
		// carbonTexture.dispose();
	}
}
