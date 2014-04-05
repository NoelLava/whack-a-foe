package com.bulalo.MenuWorld;

import java.util.ArrayList;
import java.util.List;

import com.bulalo.FileUpload.Upload;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class MenuWorld {
	private static List<Button> menuButtons;
	public Upload upload;
	private static List<Button> sfxButtons;
	private static List<Button> bgmButtons;

	private Button playButton;
	private Button shopButton;
	private Button customButton;
	private Button sfxButtonOn;
	private Button bgmButtonOn;
	private Button sfxButtonOff;
	private Button bgmButtonOff;
	
	public static boolean sfxOn = true;
	public static boolean bgmOn = true;

	float runTime = 0;

	public MenuWorld() {
		menuButtons = new ArrayList<Button>();
		sfxButtons = new ArrayList<Button>();
		bgmButtons = new ArrayList<Button>();
		AssetLoader.load();
		
		// playButton = new Button(Gdx.graphics.getWidth() / 2 - 144.05f,
		// Gdx.graphics.getHeight() / 2 - 147.6f, 43, 41,
		// AssetLoader.redButton, AssetLoader.redPressed);
		// shopButton = new Button(Gdx.graphics.getWidth() / 2 - 144.05f,
		// Gdx.graphics.getHeight() / 2 - 108.24f, 43, 41,
		// AssetLoader.yellowButton, AssetLoader.yellowPressed);
		// customButton = new Button(Gdx.graphics.getWidth() / 2 - 144.05f,
		// Gdx.graphics.getHeight() / 2 - 68.47f, 43, 41,
		// AssetLoader.blueButton, AssetLoader.bluePressed);

		playButton = new Button(15.95f, 108.4f, 43, 41, AssetLoader.redButton,
				AssetLoader.redPressed);
		shopButton = new Button(15.95f, 147.46f, 43, 41,
				AssetLoader.yellowButton, AssetLoader.yellowPressed);
		customButton = new Button(15.95f, 187.53f, 43, 41,
				AssetLoader.blueButton, AssetLoader.bluePressed);	
		
		sfxButtonOn = new Button(5, 237, 15, 15, AssetLoader.sfxOnUp, AssetLoader.sfxOnDown);
		bgmButtonOn = new Button(20, 237, 15, 15, AssetLoader.bgmOnUp, AssetLoader.bgmOnDown);
		
		sfxButtonOff = new Button(5, 237, 15, 15, AssetLoader.sfxOffUp, AssetLoader.sfxOffDown);
		bgmButtonOff = new Button(20, 237, 15, 15, AssetLoader.bgmOffUp, AssetLoader.bgmOffDown);

		upload = new Upload();
		
		menuButtons.add(playButton);
		menuButtons.add(shopButton);
		menuButtons.add(customButton);
		
		sfxButtons.add(sfxButtonOn);
		bgmButtons.add(bgmButtonOn);
		sfxButtons.add(sfxButtonOff);
		bgmButtons.add(bgmButtonOff);
	}

	public void update(float delta) {
		if(bgmButtonOn.isJustPressed()){
			bgmOn = false;
		} else if (bgmButtonOff.isJustPressed()){
			bgmOn = true;
		}
		
		if(sfxButtonOn.isJustPressed()) {
			sfxOn = false;
		}  else if(sfxButtonOff.isJustPressed()){
			sfxOn = true;
		}
		
		setBgm();
		setSfx();
	}

	public void setSfx(){
		if(sfxOn){
			AssetLoader.titleMusic.setVolume(1);
			AssetLoader.gameMusic.setVolume(1);
			AssetLoader.gameMusic2.setVolume(1);
			AssetLoader.gameStart.setVolume(1);
			AssetLoader.gameOver.setVolume(1);
		}else{
			AssetLoader.titleMusic.setVolume(0);
			AssetLoader.gameMusic.setVolume(0);
			AssetLoader.gameMusic2.setVolume(0);
			AssetLoader.gameStart.setVolume(0);
			AssetLoader.gameOver.setVolume(0);
		}
	}
	
	public void setBgm(){
		if(bgmOn){
			AssetLoader.hitSmash.setVolume(1);
			AssetLoader.hitEmpty.setVolume(1);
			AssetLoader.hitFriend.setVolume(1);
			AssetLoader.buttonUp.setVolume(1);
			AssetLoader.buttonDown.setVolume(1);
			AssetLoader.bulaloil.setVolume(1);
			AssetLoader.beep.setVolume(1);
		}else{
			AssetLoader.hitSmash.setVolume(0);
			AssetLoader.hitEmpty.setVolume(0);
			AssetLoader.hitFriend.setVolume(0);
			AssetLoader.buttonUp.setVolume(0);
			AssetLoader.buttonDown.setVolume(0);
			AssetLoader.bulaloil.setVolume(0);
			AssetLoader.beep.setVolume(0);
		}
	}
	
	public static List<Button> getMenuButtons() {
		return menuButtons;
	}
	
	public static List<Button> getSFXButtonOn() {
		return sfxButtons;
	}
	
	public static List<Button> getBGMButtonOn(){
		return bgmButtons;
	}	
}
