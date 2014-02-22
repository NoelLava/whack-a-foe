package com.bulalo.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {
	public static Texture gameTexture;
	public static TextureRegion table;
	public static TextureRegion dummy;
	
	public static Texture tSTexture;
	public static TextureRegion titleBg;
	public static TextureRegion redButton;
	public static TextureRegion redPressed;
	public static TextureRegion yellowButton;
	public static TextureRegion yellowPressed;
	public static TextureRegion blueButton;
	public static TextureRegion bluePressed;
	
	public static void load(){
		gameTexture = new Texture(Gdx.files.internal("data/GameScreenTexture.png"));
		gameTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		tSTexture = new Texture(Gdx.files.internal("data/TitleScreenTexture.png"));
		tSTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		//TitleScreen Textures
		titleBg = new TextureRegion(tSTexture, 0, 0, 320, 512);
		titleBg.flip(false, true);
		
		redButton = new TextureRegion(tSTexture, 320, 0, 65, 65);
		redButton.flip(false, true);
		
		redPressed = new TextureRegion(tSTexture, 390, 0, 65, 65);
		redPressed.flip(false, true);
		
		yellowButton = new TextureRegion(tSTexture, 320, 75, 65, 65);
		yellowButton.flip(false, true);
		
		yellowPressed = new TextureRegion(tSTexture, 390, 75, 65, 65);
		yellowPressed.flip(false, true);
		
		blueButton = new TextureRegion(tSTexture, 320, 150, 65, 65);
		blueButton.flip(false, true);
		
		bluePressed = new TextureRegion(tSTexture, 390, 150, 65, 65);
		bluePressed.flip(false, true);
		
		//GameScreen Textures
		table = new TextureRegion(gameTexture, 0, 0, 320, 512);
		table.flip(false, true);
		
		dummy = new TextureRegion(gameTexture, 320, 0, 55, 85);
		dummy.flip(false, true);
	}
	
	public static void dispose() {
		//We must dispose of the textures when we are finished, beki si kim
		gameTexture.dispose();
	}
}
