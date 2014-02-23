package com.bulalo.MenuWorld;

import com.bulalo.UI.Button;

public class MenuWorld {

	private Button playButton;
	private Button optionsButton;
	private Button customButton;
	
	float runTime = 0;
	
	private GameState currentState;
	
	public enum GameState {
		MENU, PLAY, OPTIONS, CUSTOM
	}
	
	public MenuWorld(){
		currentState = GameState.MENU;
		//playButton = new Button(22.5f, 111.75f, 65 ,65);
		//optionsButton = new Button(22.5f, 149.75f, 65, 65);
		//customButton = new Button(22.5f, 187.75f, 65, 65);
	}
	
	public Button getPlayButton(){
		return playButton;
	}
	
	public Button getOptionsButton(){
		return optionsButton;
	}
	
	public Button getCustomButton(){
		return customButton;
	}
	
	public void update(float delta){	
		runTime += delta;
		
		switch (currentState) {
        case MENU:
            updateReady(delta);
            break;
        case PLAY:
            updatePlay(delta);
            break;
        case OPTIONS:
        	updateOptions(delta);
        case CUSTOM:
        	updateCustom(delta);
        	break;
        default:
            break;
        }
	}

	private void updateReady(float delta) {
		
	}

	private void updatePlay(float delta) {
		
	}

	private void updateOptions(float delta) {
		
	}

	private void updateCustom(float delta) {
		
	}
}
