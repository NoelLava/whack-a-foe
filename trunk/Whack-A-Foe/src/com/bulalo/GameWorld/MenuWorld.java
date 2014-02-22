package com.bulalo.GameWorld;

import com.bulalo.GameObjects.PlayButton;

public class MenuWorld {

	private PlayButton playButton;
	
	public MenuWorld(){
		playButton = new PlayButton(65,65);
	}
	
	public PlayButton getPlayButton(){
		return playButton;
	}
	
	public void update(float delta){	
		//playButton.update(delta);
	}
}
