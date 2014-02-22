package com.bulalo.MenuWorld;

import com.bulalo.GameObjects.MenuButton;

public class MenuWorld {

	private MenuButton playButton;
	private MenuButton optionsButton;
	private MenuButton customButton;
	
	public MenuWorld(){
		playButton = new MenuButton(22.5f, 111.75f, 65 ,65);
		optionsButton = new MenuButton(22.5f, 149.75f, 65, 65);
		customButton = new MenuButton(22.5f, 187.75f, 65, 65);
	}
	
	public MenuButton getPlayButton(){
		return playButton;
	}
	
	public MenuButton getOptionsButton(){
		return optionsButton;
	}
	
	public MenuButton getCustomButton(){
		return customButton;
	}
	
	public void update(float delta){	
		playButton.update(delta);
		optionsButton.update(delta);
		customButton.update(delta);
	}
}
