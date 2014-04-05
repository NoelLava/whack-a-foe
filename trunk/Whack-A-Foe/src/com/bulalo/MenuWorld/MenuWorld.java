package com.bulalo.MenuWorld;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.bulalo.FileUpload.Upload;
=======
import javax.sound.sampled.FloatControl;

>>>>>>> f3a487dff24942d315a83c73c60978472fc6e4db
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class MenuWorld {
	private static List<Button> menuButtons;
<<<<<<< HEAD
	public Upload upload;
=======
	private static List<Button> sfxButtonsOn;
	private static List<Button> bgmButtonsOn;
	private static List<Button> sfxButtonsOff;
	private static List<Button> bgmButtonsOff;
>>>>>>> f3a487dff24942d315a83c73c60978472fc6e4db

	private Button playButton;
	private Button shopButton;
	private Button customButton;
	
<<<<<<< HEAD
	private Button sfxButtonOn;
	
	private Button bgmButtonOn;
	
	private Button sfxButtonOff;

	private Button bgmButtonOff;

=======
>>>>>>> 0e76b3f0bcf2c9c583798bd33c1d442d9fa52633
	float runTime = 0;

	public MenuWorld() {
		menuButtons = new ArrayList<Button>();
		sfxButtonsOn = new ArrayList<Button>();
		bgmButtonsOn = new ArrayList<Button>();
		sfxButtonsOff = new ArrayList<Button>();
		bgmButtonsOff = new ArrayList<Button>();

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
		
		sfxButtonOn = new Button(100, 230, 20, 20, AssetLoader.sfxOnUp, AssetLoader.sfxOnDown);
		bgmButtonOn = new Button(125, 230, 20, 20, AssetLoader.bgmOnUp, AssetLoader.bgmOnDown);
		
		sfxButtonOff = new Button(100, 230, 20, 20, AssetLoader.sfxOffUp, AssetLoader.sfxOffDown);
		bgmButtonOff = new Button(125, 230, 20, 20, AssetLoader.bgmOffUp, AssetLoader.bgmOffDown);

		upload = new Upload();
		
		menuButtons.add(playButton);
		menuButtons.add(shopButton);
		menuButtons.add(customButton);
		
		sfxButtonsOn.add(sfxButtonOn);
		
		bgmButtonsOn.add(bgmButtonOn);
		
		sfxButtonsOff.add(sfxButtonOff);
		
		bgmButtonsOff.add(bgmButtonOff);
	}

	public void update(float delta) {
		if(bgmButtonOn.isJustPressed()){
			AssetLoader.titleMusic.setVolume(0);
			AssetLoader.gameMusic.setVolume(0);
			AssetLoader.gameMusic2.setVolume(0);
			AssetLoader.gameStart.setVolume(0);
			AssetLoader.gameOver.setVolume(0);


		} else if (bgmButtonOff.isJustPressed()){
			AssetLoader.titleMusic.setVolume(1);
		}
		
		if(sfxButtonOn.isJustPressed()) {
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
		return sfxButtonsOn;
	}
	
	public static List<Button> getBGMButtonOn(){
		return bgmButtonsOn;
	}
	
	public static List<Button> getSFXButtonOff() {
		return sfxButtonsOff;
	}
	
	public static List<Button> getBGMButtonOff(){
		return bgmButtonsOff;
	}
	
}
